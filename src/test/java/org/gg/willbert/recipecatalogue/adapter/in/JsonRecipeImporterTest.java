package org.gg.willbert.recipecatalogue.adapter.in;

import org.gg.willbert.recipecatalogue.application.RecipeRepository;
import org.gg.willbert.recipecatalogue.application.RecipeService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class JsonRecipeImporterTest {

    @Test
    void shouldImportOneRecipe() {
        RecipeRepository inMemoryRepository = RecipeRepository.from("inMemory");
        RecipeService recipeService = new RecipeService(inMemoryRepository);
        JsonRecipeImporter jsonRecipeImporter = new JsonRecipeImporter(recipeService);

        jsonRecipeImporter.importRecipes("recipes.json");

        Optional<String> recipe = inMemoryRepository.find("JG Italiensk lasagne");
        assertThat(recipe).isPresent();
    }
}