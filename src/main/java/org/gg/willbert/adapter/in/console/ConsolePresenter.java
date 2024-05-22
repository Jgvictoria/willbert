package org.gg.willbert.adapter.in.console;

import org.gg.willbert.application.RecipeRepository;

import java.util.Scanner;

public class ConsolePresenter {

    private final RecipeRepository recipeRepository;

    public ConsolePresenter(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void present() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Willbert!");
        System.out.println("Find recipe (f) or Quit (q)");

        String option = scanner.nextLine();

        if (option.equals("f")) {
            System.out.println("Enter search term...");
            String searchTerm = scanner.nextLine();

            System.out.println(recipeRepository.getByNameContains(searchTerm));

        }

        scanner.close();
    }

}
