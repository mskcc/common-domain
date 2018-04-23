/**
 * Copyright 2014 - Sapio Sciences, LLC - All Rights Reserved
 */
package org.mskcc.util.lims;

import com.velox.api.servermanager.PickListConfig;
import com.velox.api.util.ServerException;
import com.velox.sapioutils.shared.managers.ManagerBase;
import com.velox.sapioutils.shared.managers.ManagerContext;
import org.apache.commons.lang3.StringUtils;

import java.rmi.RemoteException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A utility object used throughout the Sloan CMO project.
 *
 * @author Dmitri Petanov
 */
public class LimsPluginUtils extends ManagerBase {

    private static final String EXECUTE_CUSTOM_PLUGIN = "EXECUTE CUSTOM PLUGIN";
    /**
     * A picklist that defines all custom plugins to be executed within workflows.
     */
    private static final String CUSTOM_PLUGIN_PICKLIST = "Custom Plugin List";
    private static Map<String, Integer> pluginIdentifierMap;

    public LimsPluginUtils(ManagerContext managerContext) {
        setManagerContext(managerContext);
    }

    /**
     * <p>To avoid depending on workflow names and task names (which could change), use this method
     * to execute proper plugin classes. The setup is expected to have a <b>EXECUTE CUSTOM PLUGIN</b>
     * task option key and plugin identifiers, delimited by commas, listed in the task option values.</p>
     * <p>
     * <p>The plugin identifiers are expected to be listed in a pick list named "Custom Plugin List" which
     * is to be set up in the following manner:<ul>
     * <p>
     * {Numeric Identifier}: {Package name and class name}
     * </ul>
     * <p>
     * <b>Example:</b><ul><br>
     * 1: com.velox.sloan.cmo.workflows.poolingandnormalization.LoadQcResultsEntry<br>
     * 2: com.velox.sloan.cmo.workflows.poolingandnormalization.LoadQcResultsSubmit</ul>
     *
     * @return <b>True / False</b> depicting whether or not to run the calling plugin class.
     * @throws RemoteException
     * @throws ServerException
     */
    // [CR-11556] Provide support for executing task specific plugins without a dependency on workflow or task names.
    public boolean shouldRunPlugin() throws RemoteException, ServerException {

        Map<String, String> taskOptions = activeTask.getTask().getTaskOptions();

        // If the tag for executing a custom plugin does not exist here, then there is no need to continue
        // through the process
        if (!taskOptions.containsKey(EXECUTE_CUSTOM_PLUGIN) || StringUtils.isBlank(taskOptions.get
                (EXECUTE_CUSTOM_PLUGIN).trim()))
            return false;

        // Instantiate the static map of plugin identifiers. The variable is made static to allow quick access and
        // reuse without wasting time creating it every time. This implementation should be fine since if plugins
        // are added or subtracted, plugins will need to be reloaded, thus clearing cache.
        if (pluginIdentifierMap == null) {
            PickListConfig pickListConfig = dataMgmtServer.getPickListManager(user).getPickListConfig
                    (CUSTOM_PLUGIN_PICKLIST);

            if (pickListConfig == null) {
                logError("Failed to locate a list of workflow plugins! Picklist \"" + CUSTOM_PLUGIN_PICKLIST + "\" is" +
                        " not defined in the system.");
                return false;
            }

            List<String> picklistValueList = pickListConfig.getEntryList();

            if (picklistValueList.isEmpty()) {
                logError("Failed to locate a list of workflow plugins! Picklist \"" + CUSTOM_PLUGIN_PICKLIST + "\" is" +
                        " empty.");
                return false;
            }

            pluginIdentifierMap = new HashMap<>();

            // Keep a set of plugin values for fast checking of a previous entry, thus avoiding duplicates
            Set<Integer> pluginIdentifierSet = new HashSet<>();

            Pattern pickListValuePattern = Pattern.compile("^\\s*(\\d+)\\:\\s*([^\\s]+)\\s*$");

            for (String pickListValue : picklistValueList) {
                Matcher matcher = pickListValuePattern.matcher(pickListValue);

                if (!matcher.matches()) {
                    logError("Picklist value \"" + pickListValue + "\" from picklist \"" + CUSTOM_PLUGIN_PICKLIST +
                            "\" is not in a proper format. The expected value is: {Numeric Identifer}: {Package and " +
                            "Class Name}");
                    continue;
                }

                Integer pluginIdentifier = Integer.parseInt(matcher.group(1));

                if (pluginIdentifierSet.contains(pluginIdentifier)) {
                    logError("Plugin identifier \"" + pluginIdentifier + "\" is listed multiple times in the \"" +
                            CUSTOM_PLUGIN_PICKLIST + "\" picklist!");
                    continue;
                }

                pluginIdentifierSet.add(pluginIdentifier);

                String pluginValue = matcher.group(2);

                if (pluginIdentifierMap.containsKey(pluginValue)) {
                    logError("Plugin value \"" + pluginValue + "\" is listed multiple times in the \"" +
                            CUSTOM_PLUGIN_PICKLIST + "\" picklist!");
                    continue;
                }
                pluginIdentifierMap.put(pluginValue, pluginIdentifier);
            }

            if (pluginIdentifierMap.isEmpty()) {
                logError("Picklist \"" + CUSTOM_PLUGIN_PICKLIST + "\" does not contain any plugin values in a proper " +
                        "format!");
                pluginIdentifierMap = null;
            }
        }


        // If this method is called from somewhere where the activeTask or activeWorkflow objects
        // are not instantiated (like a button), then we cannot proceed
        if (activeWorkflow == null || activeTask == null)
            return false;

        String taskOptionValue = taskOptions.get(EXECUTE_CUSTOM_PLUGIN);

        if (!Pattern.matches("^\\s*[,\\d\\s]+\\s*$", taskOptionValue)) {
            logError("Task option value \"" + taskOptionValue + "\" for task option key \"" + EXECUTE_CUSTOM_PLUGIN +
                    "\" is not in a proper format! The expected format expects plugin identifiers to be delimited by " +
                    "commas.");
            return false;
        }

        String[] pluginIdentifiers = taskOptionValue.trim().split("\\s*,\\s*");
        Set<String> pluginIdentifierSet = new HashSet<>(Arrays.asList(pluginIdentifiers));

        String callerClassName = new Exception().getStackTrace()[1].getClassName();

        if (pluginIdentifierMap.containsKey(callerClassName)) {
            return pluginIdentifierSet.contains(String.valueOf(pluginIdentifierMap.get(callerClassName)));
        }

        return false;
    }
}
