package org.gg.willbert.application;

import org.gg.willbert.adapter.out.RecipeInMemoryRepository;
import org.gg.willbert.domain.Amount;
import org.gg.willbert.domain.Ingredient;
import org.gg.willbert.domain.MeasurementUnit;
import org.gg.willbert.domain.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecipeSaverTest {

    @Test
    void successfullySaveRecipe() {
        RecipeRepository inMemoryRepository = RecipeRepository.from("inMemory");
        RecipeSaver recipeSaver = new RecipeSaver(inMemoryRepository);
        RecipeFinder recipeFinder = new RecipeFinder(inMemoryRepository);
        Recipe recipe = new Recipe("pizza");

        recipeSaver.save(recipe);

        List<Recipe> foundRecipes = recipeFinder.byName("pizza");
        assertThat(foundRecipes).hasSize(1);
        Recipe foundRecipe = foundRecipes.getFirst();
        assertThat(foundRecipe.getIngredients()).isEmpty();
        assertThat(foundRecipe.getDescription()).isNull();
        assertThat(foundRecipe.getInstructions()).isEmpty();
    }

    @Test
    void successfullySaveFullRecipe() {
        RecipeRepository inMemoryRepository = RecipeRepository.from("inMemory");
        RecipeSaver recipeSaver = new RecipeSaver(inMemoryRepository);
        RecipeFinder recipeFinder = new RecipeFinder(inMemoryRepository);
        Recipe recipe = new Recipe("sushi",
                "Japanese food",
                List.of("1. Get fish", "2. Add rice"),
                List.of(
                        new Ingredient("Fish", new Amount((short) 1, MeasurementUnit.QUANTITY)),
                        new Ingredient("Rice", new Amount((short) 100, MeasurementUnit.GRAM))));

        recipeSaver.save(recipe);

        List<Recipe> foundRecipes = recipeFinder.byName("sushi");
        assertThat(foundRecipes).hasSize(1);
        Recipe foundRecipe = foundRecipes.getFirst();
        assertThat(foundRecipe.getDescription()).isEqualTo("Japanese food");
        assertThat(foundRecipe.getInstructions())
                .hasSize(2)
                .containsExactlyInAnyOrder("1. Get fish", "2. Add rice");
        assertThat(foundRecipe.getIngredients())
                .hasSize(2)
                .extracting("productName")
                .containsExactlyInAnyOrder("Rice", "Fish");

    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldNotSaveWhenMissingName(String recipeName) {
        RecipeRepository inMemoryRepository = RecipeRepository.from("inMemory");
        RecipeSaver recipeSaver = new RecipeSaver(inMemoryRepository);

        assertThrows(IllegalArgumentException.class, () -> recipeSaver.save(recipeName));
    }

    @Test
    void shouldRejectDuplicateRecipe() {
        RecipeRepository inMemoryRepository = RecipeInMemoryRepository.of("pizza");
        RecipeSaver recipeSaver = new RecipeSaver(inMemoryRepository);

        assertThrows(IllegalArgumentException.class, () -> recipeSaver.save("pizza"));
    }

    @Test
    void shouldRejectNullFullRecipe() {
        Recipe recipe = null;
        RecipeRepository inMemoryRepository = RecipeInMemoryRepository.of("pizza");
        RecipeSaver recipeSaver = new RecipeSaver(inMemoryRepository);

        assertThrows(IllegalArgumentException.class, () -> recipeSaver.save(recipe));

    }

    @Test
    void shouldRejectDuplicateFullRecipe() {
        RecipeRepository inMemoryRepository = RecipeInMemoryRepository.of("pizza");
        RecipeSaver recipeSaver = new RecipeSaver(inMemoryRepository);

        assertThrows(IllegalArgumentException.class, () -> recipeSaver.save(new Recipe("pizza")));
    }
}