package org.gg.willbert.application;

import org.gg.willbert.adapter.out.RecipeInMemoryRepository;

import java.util.List;

public interface RecipeRepository {

    List<String> getAll();

    static RecipeRepository from(String type) {
        if (type.equals("inMemory")) {
            return new RecipeInMemoryRepository();
        }

        throw new IllegalArgumentException("Unhandled RecipeRepository type...");
    }
}
