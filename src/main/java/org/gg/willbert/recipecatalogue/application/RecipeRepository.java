package org.gg.willbert.recipecatalogue.application;

import org.gg.willbert.recipecatalogue.adapter.out.RecipeInMemoryRepository;
import org.gg.willbert.recipecatalogue.domain.Recipe;

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
