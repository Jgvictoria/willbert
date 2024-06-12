package org.gg.willbert.recipecatalogue.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gg.willbert.recipecatalogue.domain.MeasurementUnit.QUANTITY;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecipeTest {

    @ParameterizedTest
    @NullAndEmptySource
    void shouldRejectRecipeWithMissingName(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Recipe(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldRejectFullRecipeWithMissingName(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> new Recipe(name, null, null, null));
    }

    @Test
    void shouldReturnOneIngredientWithAmount() {
        Recipe recipe = new Recipe("sushi",
                "",
                Collections.emptyList(),
                List.of(new Ingredient("Fish", new Amount((short) 1, QUANTITY))));

        assertThat(recipe.getIngredients()).hasSize(1);
        assertThat(recipe.getIngredients().getFirst().getProductName()).isEqualTo("Fish");
        assertThat(recipe.getIngredients().getFirst().getAmount().getValue()).isEqualTo((short) 1);
        assertThat(recipe.getIngredients().getFirst().getAmount().getUnit()).isEqualTo(QUANTITY);
    }
}