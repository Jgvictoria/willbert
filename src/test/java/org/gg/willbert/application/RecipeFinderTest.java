package org.gg.willbert.application;

import org.gg.willbert.adapter.out.RecipeInMemoryRepository;
import org.gg.willbert.domain.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecipeFinderTest {

    @Test
    void byNameReturnsNoRecipes() {
        RecipeFinder recipeFinder = new RecipeFinder(RecipeInMemoryRepository.of("burger"));

        List<Recipe> recipes = recipeFinder.byName("lasagna");

        assertThat(recipes).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"burger", "Burger"})
    void byNameReturnsOneRecipe(String name) {
        RecipeFinder recipeFinder = new RecipeFinder(RecipeInMemoryRepository.of("burger"));

        List<Recipe> recipes = recipeFinder.byName(name);

        assertThat(recipes).hasSize(1);
    }

    @Test
    void byNameReturnsTwoRecipes() {
        RecipeFinder recipeFinder = new RecipeFinder(RecipeInMemoryRepository.of("burger", "meatballs", "meatloaf"));

        List<Recipe> recipes = recipeFinder.byName("meat");

        assertThat(recipes)
                .hasSize(2)
                .extracting("name")
                .containsExactlyInAnyOrder("meatballs", "meatloaf");
    }
}