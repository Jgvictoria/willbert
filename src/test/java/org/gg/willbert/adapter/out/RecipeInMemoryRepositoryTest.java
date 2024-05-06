package org.gg.willbert.adapter.out;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecipeInMemoryRepositoryTest {

    @Test
    void getAllReturnsCompleteList() {
        RecipeInMemoryRepository recipeInMemoryRepository = new RecipeInMemoryRepository();

        List<String> all = recipeInMemoryRepository.getAll();

        assertThat(all)
                .hasSize(3)
                .containsExactlyInAnyOrder("meatloaf", "burger", "meatballs");
    }
}