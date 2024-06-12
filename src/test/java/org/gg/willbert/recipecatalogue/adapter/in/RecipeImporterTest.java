package org.gg.willbert.recipecatalogue.adapter.in;

import org.gg.willbert.recipecatalogue.application.RecipeRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class RecipeImporterTest {

    @Test
    void shouldImportOneRecipe() {
        RecipeRepository inMemoryRepository = RecipeRepository.from("inMemory");
        RecipeImporter recipeImporter = new RecipeImporter(inMemoryRepository);

        recipeImporter.importRecipes("recipes.json");

        Optional<String> recipe = inMemoryRepository.find("JG Italiensk lasagne");
        assertThat(recipe).isPresent();
    }
}