package org.gg.willbert.recipecatalogue.application;

import org.gg.willbert.recipecatalogue.domain.Recipe;

import java.util.List;
import java.util.Optional;

public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
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

    public SaveRecipesResult saveAll(List<Recipe> recipes) {
        SaveRecipesResult saveRecipesResult = new SaveRecipesResult();

        for (Recipe recipe : recipes) {
            try {
                this.save(recipe);
            } catch (IllegalArgumentException e) {
                saveRecipesResult.addSkippedRecipe(recipe);
                System.out.printf("Skipping duplicate recipe with name %s%n", recipe.getName());
            }
        }
        return saveRecipesResult;
    }

    public List<Recipe> getAll() {
        return recipeRepository.getAll();
    }

    public List<Recipe> getByNameContains(String affix) {
        return recipeRepository.getByNameContains(affix);
    }

    public Optional<String> find(String recipeName) {
        return recipeRepository.find(recipeName);
    }
}
