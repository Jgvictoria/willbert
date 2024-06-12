package org.gg.willbert.recipecatalogue.application;

import org.gg.willbert.recipecatalogue.domain.Recipe;

import java.util.ArrayList;
import java.util.List;

public record SaveRecipesResult(List<Recipe> skippedRecipes) {
    public SaveRecipesResult() {
        this(new ArrayList<>());
    }

    public void addSkippedRecipe(Recipe recipe) {
        this.skippedRecipes.add(recipe);
    }
}
