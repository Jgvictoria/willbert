package org.gg.willbert.backend.domain;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;

public class Recipe {

    private final int identification;
    private String name;
    private String sourceUrl;
    private String imagePath;
    private List<Ingredient> ingredients;
    private SortedSet<Instruction> instructions;

    public Recipe(int identification, String name, List<Ingredient> ingredients,
                  SortedSet<Instruction> instructions) {
        this.identification = identification;
        this.name = name;
        this.ingredients = ingredients;
        //TODO: create a copy before assigning
        this.instructions = instructions;
    }

    public Recipe(int identification, String name, String imagePath, List<Ingredient> ingredients,
                  SortedSet<Instruction> instructions) {
        this.identification = identification;
        this.name = name;
        this.imagePath = imagePath;
        this.ingredients = ingredients;
        //TODO: create a copy before assigning
        this.instructions = instructions;
    }

    public Recipe(int identification, String name, String sourceUrl, String imagePath,
                  List<Ingredient> ingredients, SortedSet<Instruction> instructions) {
        // TODO: validate
        this.identification = identification;
        this.name = name;
        this.sourceUrl = sourceUrl;
        this.imagePath = imagePath;
        this.ingredients = List.copyOf(ingredients);
        //TODO: create a copy before assigning
        this.instructions = instructions;
    }

    public int identification() {
        return identification;
    }

    public String name() {
        return name;
    }

    public String sourceUrl() {
        return sourceUrl;
    }

    public String imagePath() {
        return imagePath;
    }

    public List<Ingredient> ingredients() {
        return Collections.unmodifiableList(ingredients);
    }

    public SortedSet<Instruction> instructions() {
        return Collections.unmodifiableSortedSet(instructions);
    }

    public void setName(String name) {
        // TODO: validate
        this.name = name;
    }

    public void setSourceUrl(String sourceUrl) {
        //TODO validate
        this.sourceUrl = sourceUrl;
    }

    public void setImagePath(String imagePath) {
        // TODO validate
        this.imagePath = imagePath;
    }

    public void addIngredient(Ingredient ingredient) {
        //TODO: validate
        this.ingredients.add(ingredient);
    }

    public void addInstruction(Instruction instruction) {
        // TODO: instruction
        this.instructions.add(instruction);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "identification=" + identification +
                ", name='" + name + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe recipe)) return false;

        return name.equals(recipe.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
