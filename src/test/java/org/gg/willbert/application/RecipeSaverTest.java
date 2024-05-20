package org.gg.willbert.application;

import org.gg.willbert.adapter.out.RecipeInMemoryRepository;
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

        recipeSaver.save("pizza");

        List<Recipe> foundRecipes = recipeFinder.byName("pizza");
        assertThat(foundRecipes)
                .hasSize(1)
                .containsExactlyInAnyOrder(new Recipe("pizza"));
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
}