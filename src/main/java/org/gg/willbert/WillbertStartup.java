package org.gg.willbert;

import org.gg.willbert.recipecatalogue.adapter.in.console.ConsolePresenter;
import org.gg.willbert.recipecatalogue.application.RecipeRepository;

public class WillbertStartup {

    public static void main(String[] args) {
        RecipeRepository recipeRepository = RecipeRepository.from("inMemory");
        ConsolePresenter consolePresenter = new ConsolePresenter(recipeRepository);
        consolePresenter.present();
    }
}