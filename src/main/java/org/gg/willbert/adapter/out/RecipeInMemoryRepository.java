package org.gg.willbert.adapter.out;

import org.gg.willbert.application.RecipeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RecipeInMemoryRepository implements RecipeRepository {

    private List<String> recipeNames = new ArrayList<>();

    public RecipeInMemoryRepository() {
        this.recipeNames.add("burger");
        this.recipeNames.add("meatballs");
        this.recipeNames.add("meatloaf");
    }

    public RecipeInMemoryRepository(String recipe) {
        this.recipeNames.add(recipe);
    }

    public static RecipeInMemoryRepository of(String recipe) {
        return new RecipeInMemoryRepository(recipe);
    }

    @Override
    public List<String> getAll() {
        return Collections.unmodifiableList(recipeNames);
    }

    @Override
    public void save(String recipeName) {
        recipeNames.add(recipeName);
    }

    @Override
    public Optional<String> find(String recipeName) {
        return recipeNames.stream()
                .filter(name -> name.equals(recipeName))
                .findFirst();
    }
}
