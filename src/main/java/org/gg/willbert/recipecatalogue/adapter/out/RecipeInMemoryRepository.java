package org.gg.willbert.recipecatalogue.adapter.out;

import org.gg.willbert.recipecatalogue.application.RecipeRepository;
import org.gg.willbert.recipecatalogue.domain.Recipe;

import java.util.*;

public class RecipeInMemoryRepository implements RecipeRepository {

    private List<Recipe> recipes = new ArrayList<>();

    public RecipeInMemoryRepository() {
    }

    private RecipeInMemoryRepository(String... recipeNames) {
        List<Recipe> recipes = Arrays.stream(recipeNames)
                .map(Recipe::new)
                .toList();
        this.recipes.addAll(recipes);
    }

    public static RecipeInMemoryRepository of(String... recipes) {
        return new RecipeInMemoryRepository(recipes);
    }

    public static RecipeInMemoryRepository empty() {
        return new RecipeInMemoryRepository();
    }

    @Override
    public List<Recipe> getAll() {
        return Collections.unmodifiableList(recipes);
    }

    @Override
    public List<Recipe> getByNameContains(String affix) {
        String normalizedName = affix.toLowerCase();

        return recipes.stream()
                .filter(r -> r.getName().contains(normalizedName))
                .toList();
    }

    @Override
    public void save(String recipeName) {
        recipes.add(new Recipe(recipeName));
    }

    @Override
    public void save(Recipe recipe) {
        recipes.add(recipe);
    }

    @Override
    public Optional<String> find(String recipeName) {
        return recipes.stream()
                .map(Recipe::getName)
                .filter(name -> name.equals(recipeName))
                .findFirst();
    }
}
