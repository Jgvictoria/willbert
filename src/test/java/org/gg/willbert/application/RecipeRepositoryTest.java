package org.gg.willbert.application;

import org.gg.willbert.adapter.out.RecipeInMemoryRepository;
import org.gg.willbert.domain.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecipeRepositoryTest {

    @Test
    void fromReturnsInMemoryRepository() {
        RecipeRepository repository = RecipeRepository.from("inMemory");

        assertThat(repository)
                .isInstanceOf(RecipeInMemoryRepository.class);
    }

    @Test
    void fromThrowsExceptionForUnhandledType() {
        assertThrows(IllegalArgumentException.class, () -> RecipeRepository.from("appleSauce"));
    }

    @Test
    void getByNameContainsReturnsNoRecipes() {
        RecipeInMemoryRepository recipeInMemoryRepository = RecipeInMemoryRepository.of("burger");

        List<Recipe> recipes = recipeInMemoryRepository.getByNameContains("lasagna");

        assertThat(recipes).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"burger", "Burger"})
    void getByNameContainsReturnsOneRecipe(String name) {
        RecipeInMemoryRepository recipeInMemoryRepository = RecipeInMemoryRepository.of("burger");

        List<Recipe> recipes = recipeInMemoryRepository.getByNameContains(name);

        assertThat(recipes).hasSize(1);
    }

    @Test
    void getByNameContainsReturnsTwoRecipes() {
        RecipeInMemoryRepository recipeInMemoryRepository = RecipeInMemoryRepository.of("burger", "meatballs", "meatloaf");

        List<Recipe> recipes = recipeInMemoryRepository.getByNameContains("meat");

        assertThat(recipes)
                .hasSize(2)
                .extracting("name")
                .containsExactlyInAnyOrder("meatballs", "meatloaf");
    }
}