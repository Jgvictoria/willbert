package org.gg.willbert;

import org.gg.willbert.application.RecipeFinder;
import org.gg.willbert.application.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecipeFinderTest {

    @Test
    void byNameReturnsNoRecipes() {
        RecipeFinder recipeFinder = new RecipeFinder(RecipeRepository.from("inMemory"));

        List<String> recipes = recipeFinder.byName("lasagna");

        assertThat(recipes).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"burger", "Burger"})
    void byNameReturnsOneRecipe(String name) {
        RecipeFinder recipeFinder = new RecipeFinder(RecipeRepository.from("inMemory"));

        List<String> recipes = recipeFinder.byName(name);

        assertThat(recipes).hasSize(1);
    }

    @Test
    void byNameReturnsTwoRecipes() {
        RecipeFinder recipeFinder = new RecipeFinder(RecipeRepository.from("inMemory"));

        List<String> recipes = recipeFinder.byName("meat");

        assertThat(recipes)
                .hasSize(2)
                .containsExactlyInAnyOrder("meatballs", "meatloaf");
    }
}