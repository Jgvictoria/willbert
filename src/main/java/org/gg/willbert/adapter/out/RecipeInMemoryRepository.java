package org.gg.willbert.adapter.out;

import org.gg.willbert.application.RecipeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RecipeInMemoryRepository implements RecipeRepository {

    private List<String> recipeNames = new ArrayList<>();

    public RecipeInMemoryRepository() {
    }

    private RecipeInMemoryRepository(String... recipes) {
        this.recipeNames.addAll(List.of(recipes));
    }

    public static RecipeInMemoryRepository of(String... recipes) {
        return new RecipeInMemoryRepository(recipes);
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
