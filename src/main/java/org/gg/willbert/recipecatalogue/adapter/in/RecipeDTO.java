package org.gg.willbert.recipecatalogue.adapter.in;

import org.gg.willbert.recipecatalogue.domain.Amount;
import org.gg.willbert.recipecatalogue.domain.Ingredient;
import org.gg.willbert.recipecatalogue.domain.MeasurementUnit;
import org.gg.willbert.recipecatalogue.domain.Recipe;

import java.util.List;

public record RecipeDTO(String name,
                        String description,
                        List<String> instructions,
                        List<IngredientDTO> ingredients) {
    public Recipe to() {
        List<Ingredient> ingredients = this.ingredients
                .stream()
                .map(IngredientDTO::to)
                .toList();
        return new Recipe(this.name, this.description, this.instructions, ingredients);
    }
}

record IngredientDTO(String name, AmountDTO amount) {

    public Ingredient to() {
        return new Ingredient(this.name, this.amount.to());
    }
}

record AmountDTO(String unit, int value) {

    public Amount to() {
        return new Amount((short) this.value, MeasurementUnit.valueOf(this.unit.toUpperCase()));
    }
}
