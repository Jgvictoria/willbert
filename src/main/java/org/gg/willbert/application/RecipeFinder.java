package org.gg.willbert.application;

import org.gg.willbert.domain.Recipe;

import java.util.List;

public class RecipeFinder {

    private final RecipeRepository recipeRepository;

    public RecipeFinder(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> byName(String name) {
        String normalizedName = name.toLowerCase();

        return recipeRepository.getAll().stream()
                .filter(r -> r.getName().contains(normalizedName))
                .toList();
    }
}