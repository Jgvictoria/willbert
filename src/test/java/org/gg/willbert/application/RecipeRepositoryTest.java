package org.gg.willbert.application;

import org.gg.willbert.adapter.out.RecipeInMemoryRepository;
import org.junit.jupiter.api.Test;

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
}