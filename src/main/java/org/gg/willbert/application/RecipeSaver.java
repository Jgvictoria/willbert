package org.gg.willbert.application;

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
}
