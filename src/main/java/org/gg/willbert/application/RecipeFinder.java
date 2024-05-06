package org.gg.willbert.application;

import java.util.List;

public class RecipeFinder {

    private final RecipeRepository recipeRepository;

    public RecipeFinder(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<String> byName(String name) {
        String normalizedName = name.toLowerCase();

        return recipeRepository.getAll().stream()
                .filter(n -> n.contains(normalizedName))
                .toList();
    }
}