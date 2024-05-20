package org.gg.willbert;

import org.gg.willbert.adapter.in.console.ConsolePresenter;
import org.gg.willbert.application.RecipeFinder;
import org.gg.willbert.application.RecipeRepository;

public class WillbertStartup {

    public static void main(String[] args) {
        RecipeFinder recipeFinder = new RecipeFinder(RecipeRepository.from("inMemory"));
        ConsolePresenter consolePresenter = new ConsolePresenter(recipeFinder);
        consolePresenter.present();
    }
}