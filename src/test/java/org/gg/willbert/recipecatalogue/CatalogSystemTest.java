package org.gg.willbert.recipecatalogue;

import org.gg.willbert.recipecatalogue.adapter.in.console.ConsolePresenter;
import org.gg.willbert.recipecatalogue.adapter.in.console.SimpleIOHandler;
import org.gg.willbert.recipecatalogue.adapter.out.RecipeInMemoryRepository;
import org.gg.willbert.recipecatalogue.application.RecipeService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CatalogSystemTest {

    private final RecipeService recipeService = new RecipeService(RecipeInMemoryRepository.of("pants"));

    @Test
    void shouldFindRecipe() {
        ByteArrayInputStream in = new ByteArrayInputStream("f\npants\n".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        ConsolePresenter console = new ConsolePresenter(recipeService, new SimpleIOHandler(in, new PrintStream(out)));
        console.present();

        String[] outputs = out.toString().split("\r\n");
        assertThat(outputs).containsExactly(
                "Welcome to Willbert!",
                "Find recipe (f)",
                "Import recipes from file (i)",
                "Quit (q)",
                "",
                "Enter search term...",
                "[Recipe{name='pants', description='null', instructions=[], ingredients=[]}]"
        );
    }

    @Test
    void shouldImportRecipeFromJsonFile() {
        ByteArrayInputStream in = new ByteArrayInputStream("i\n\n".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        ConsolePresenter console = new ConsolePresenter(recipeService, new SimpleIOHandler(in, new PrintStream(out)));
        console.present();

        assertThat(recipeService.find("Rödlöken")).isPresent();
        assertThat(recipeService.find("Färsen med lök")).isPresent();
    }


}