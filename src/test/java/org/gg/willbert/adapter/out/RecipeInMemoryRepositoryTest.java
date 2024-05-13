package org.gg.willbert.adapter.out;

import org.gg.willbert.application.RecipeFinder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecipeInMemoryRepositoryTest {

    @Test
    void getAllReturnsCompleteList() {
        RecipeInMemoryRepository recipeInMemoryRepository = RecipeInMemoryRepository.of("burger", "meatballs", "meatloaf");

        List<String> all = recipeInMemoryRepository.getAll();

        assertThat(all)
                .hasSize(3)
                .containsExactlyInAnyOrder("meatloaf", "burger", "meatballs");
    }
}