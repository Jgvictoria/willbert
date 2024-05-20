package org.gg.willbert.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

}