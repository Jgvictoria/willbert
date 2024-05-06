package org.gg.willbert.adapter.in.console;

import org.gg.willbert.application.RecipeFinder;

public class Main {

    public static void main(String[] args) {
        RecipeFinder recipeFinder = new RecipeFinder();
        ConsolePresenter consolePresenter = new ConsolePresenter(recipeFinder);
        consolePresenter.present();
    }
}
