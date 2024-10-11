package org.gg.willbert;

import org.gg.willbert.recipecatalogue.adapter.in.console.ConsolePresenter;
import org.gg.willbert.recipecatalogue.adapter.in.console.SimpleIOHandler;
import org.gg.willbert.recipecatalogue.application.RecipeRepository;
import org.gg.willbert.recipecatalogue.application.RecipeService;

public class WillbertStartup {

    public static void main(String[] args) {
        RecipeRepository recipeRepository = RecipeRepository.from("inMemory");
        RecipeService recipeService = new RecipeService(recipeRepository);
        ConsolePresenter consolePresenter = new ConsolePresenter(recipeService, new SimpleIOHandler(System.in, System.out));
        consolePresenter.present();
    }
}