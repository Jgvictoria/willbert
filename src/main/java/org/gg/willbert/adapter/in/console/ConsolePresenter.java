package org.gg.willbert.adapter.in.console;

import org.gg.willbert.application.RecipeFinder;

import java.util.Scanner;

class ConsolePresenter {

    private final RecipeFinder recipeFinder;

    ConsolePresenter(RecipeFinder recipeFinder) {
        this.recipeFinder = recipeFinder;
    }

    void present() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Willbert!");
        System.out.println("Find recipe (f) or Quit (q)");

        String option = scanner.nextLine();

        if (option.equals("f")) {
            System.out.println("Enter search term...");
            String searchTerm = scanner.nextLine();

            System.out.println(recipeFinder.byName(searchTerm));

        }

        scanner.close();
    }

}
