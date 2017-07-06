package org.mskcc.domain;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.object.IsCompatibleType.typeCompatibleWith;
import static org.junit.Assert.*;

public class RecipeTest {
    @Test
    public void whenRetrieveNullRecipe_shouldThrowUnsupportedRecipeException() {
        Optional<Exception> exception = assertThrown(() -> Recipe.getRecipeByValue(null));
        assertThat(exception.isPresent(), is(true));
        assertThat(exception.get().getClass(), typeCompatibleWith(Recipe.UnsupportedRecipeException.class));
    }

    @Test
    public void whenRetrieveEmptyRecipe_shouldThrowUnsupportedRecipeException() {
        Optional<Exception> exception = assertThrown(() -> Recipe.getRecipeByValue(""));
        assertThat(exception.isPresent(), is(true));
        assertThat(exception.get().getClass(), typeCompatibleWith(Recipe.UnsupportedRecipeException.class));
    }

    @Test
    public void whenRetrieveNotExistingRecipe_shouldThrowUnsupportedRecipeException() {
        Optional<Exception> exception = assertThrown(() -> Recipe.getRecipeByValue("notExistingRecipe"));
        assertThat(exception.isPresent(), is(true));
        assertThat(exception.get().getClass(), typeCompatibleWith(Recipe.UnsupportedRecipeException.class));
    }

    @Test
    public void whenRetrieveExistingRecipe_shouldReturnRecipe() {
        Recipe retrievedRecipe = Recipe.AMPLI_SEQ;
        Recipe recipe = Recipe.getRecipeByValue(retrievedRecipe.getValue());
        assertThat(recipe, is(retrievedRecipe));
    }

    private Optional<Exception> assertThrown(Runnable runnable) {
        try {
            runnable.run();
            return Optional.empty();
        } catch (Exception e) {
            return Optional.of(e);
        }
    }
}