package org.gg.willbert.adapter.out;

import org.gg.willbert.application.RecipeRepository;

import java.util.List;

public class RecipeInMemoryRepository implements RecipeRepository {

    private final List<String> recipeNames = List.of("burger", "meatballs", "meatloaf");

    @Override
    public List<String> getAll() {
        return recipeNames;
    }
}
