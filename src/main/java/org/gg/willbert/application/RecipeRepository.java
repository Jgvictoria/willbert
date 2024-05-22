package org.gg.willbert.application;

import org.gg.willbert.adapter.out.RecipeInMemoryRepository;
import org.gg.willbert.domain.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {

    List<Recipe> getAll();

    List<Recipe> getByNameContains(String affix);

    Optional<String> find(String recipeName);

    void save(String recipeName);

    void save(Recipe recipe);

    static RecipeRepository from(String type) {
        if (type.equals("inMemory")) {
            return new RecipeInMemoryRepository();
        }

        throw new IllegalArgumentException("Unhandled RecipeRepository type...");
    }
}
