package org.gg.willbert.application;

import org.gg.willbert.domain.Recipe;

public class RecipeSaver {

    private final RecipeRepository recipeRepository;

    public RecipeSaver(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void save(String recipeName) {
        if (recipeName == null || recipeName.isEmpty()) {
            throw new IllegalArgumentException("Recipe name is mandatory.");
        }

        if (recipeRepository.find(recipeName).isPresent()) {
            throw new IllegalArgumentException(
                    "Recipe name %s is already present."
                            .formatted(recipeName));
        }

        recipeRepository.save(recipeName);
    }

    public void save(Recipe recipe) {
        if (recipe == null) {
            throw new IllegalArgumentException("Invalid null recipe");
        }

        if (recipeRepository.find(recipe.getName()).isPresent()) {
            throw new IllegalArgumentException(
                    "Recipe name %s is already present."
                            .formatted(recipe.getName()));
        }

        recipeRepository.save(recipe);
    }
}
