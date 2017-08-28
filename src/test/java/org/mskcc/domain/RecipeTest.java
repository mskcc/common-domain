package org.mskcc.domain;

import org.junit.Test;
import org.mskcc.util.TestUtils;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.object.IsCompatibleType.typeCompatibleWith;
import static org.junit.Assert.assertThat;

public class RecipeTest {
    @Test
    public void whenRetrieveNullRecipe_shouldThrowUnsupportedRecipeException() {
        Optional<Exception> exception = TestUtils.assertThrown(() -> Recipe.getRecipeByValue(null));
        assertThat(exception.isPresent(), is(true));
        assertThat(exception.get().getClass(), typeCompatibleWith(Recipe.EmptyRecipeException.class));
    }

    @Test
    public void whenRetrieveEmptyRecipe_shouldThrowUnsupportedRecipeException() {
        Optional<Exception> exception = TestUtils.assertThrown(() -> Recipe.getRecipeByValue(""));
        assertThat(exception.isPresent(), is(true));
        assertThat(exception.get().getClass(), typeCompatibleWith(Recipe.EmptyRecipeException.class));
    }

    @Test
    public void whenRetrieveNotExistingRecipe_shouldThrowUnsupportedRecipeException() {
        Optional<Exception> exception = TestUtils.assertThrown(() -> Recipe.getRecipeByValue("notExistingRecipe"));
        assertThat(exception.isPresent(), is(true));
        assertThat(exception.get().getClass(), typeCompatibleWith(Recipe.UnsupportedRecipeException.class));
    }

    @Test
    public void whenRetrieveExistingRecipe_shouldReturnRecipe() {
        Recipe retrievedRecipe = Recipe.AMPLI_SEQ;
        Recipe recipe = Recipe.getRecipeByValue(retrievedRecipe.getValue());
        assertThat(recipe, is(retrievedRecipe));
    }
}