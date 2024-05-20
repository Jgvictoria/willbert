package org.gg.willbert.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recipe {

    private String name;
    private String description;
    private List<String> instructions;
    private List<Ingredient> ingredients;

    public Recipe(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Recipe name is required");
        }
        this.name = name;
        this.instructions = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }

    public Recipe(String name, String description, List<String> instructions, List<Ingredient> ingredients) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Recipe name is required");
        }
        this.name = name;
        this.description = description;
        this.instructions = new ArrayList<>(instructions);
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getInstructions() {
        return Collections.unmodifiableList(instructions);
    }

    public List<Ingredient> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;
        return name.equals(recipe.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
