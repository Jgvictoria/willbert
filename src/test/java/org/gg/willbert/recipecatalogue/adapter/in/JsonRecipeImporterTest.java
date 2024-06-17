package org.gg.willbert.recipecatalogue.adapter.in;

import org.gg.willbert.recipecatalogue.application.RecipeRepository;
import org.gg.willbert.recipecatalogue.application.RecipeService;
import org.gg.willbert.recipecatalogue.domain.Amount;
import org.gg.willbert.recipecatalogue.domain.Ingredient;
import org.gg.willbert.recipecatalogue.domain.MeasurementUnit;
import org.gg.willbert.recipecatalogue.domain.Recipe;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class JsonRecipeImporterTest {

    @Test
    void shouldImportOneRecipe() {
        RecipeRepository inMemoryRepository = RecipeRepository.from("inMemory");
        RecipeService recipeService = new RecipeService(inMemoryRepository);
        JsonRecipeImporter jsonRecipeImporter = new JsonRecipeImporter(recipeService);

        jsonRecipeImporter.importRecipes("recipe.json");

        Optional<String> recipe = inMemoryRepository.find("JG Italiensk lasagne");
        assertThat(recipe).isPresent();
    }

    @Test
    void shouldImportNothing() {
        RecipeRepository inMemoryRepository = RecipeRepository.from("inMemory");
        RecipeService recipeService = new RecipeService(inMemoryRepository);
        JsonRecipeImporter jsonRecipeImporter = new JsonRecipeImporter(recipeService);

        jsonRecipeImporter.importRecipes("empty.json");

        assertThat(recipeService.getAll()).hasSize(0);
    }

    @Test
    void shouldImportTwoRecipe() {
        RecipeRepository inMemoryRepository = RecipeRepository.from("inMemory");
        RecipeService recipeService = new RecipeService(inMemoryRepository);
        JsonRecipeImporter jsonRecipeImporter = new JsonRecipeImporter(recipeService);

        jsonRecipeImporter.importRecipes("recipes.json");

        List<Recipe> recipes = inMemoryRepository.getAll();
        Recipe onion = new Recipe("Rödlöken", "Bara lök", List.of("Ta fram löken"), List.of(new Ingredient("rödlök", new Amount((short) 1, MeasurementUnit.QUANTITY))));
        Recipe mince = new Recipe("Färsen med lök", "Bara färs och lite lök", List.of("Ta fram färsen ha med lök"), List.of(new Ingredient("nötfärs", new Amount((short) 500, MeasurementUnit.GRAM)), new Ingredient("rödlök", new Amount((short) 1, MeasurementUnit.QUANTITY))));
        assertThat(recipes)
                .hasSize(2)
                .containsExactlyInAnyOrder(onion, mince);
    }
}