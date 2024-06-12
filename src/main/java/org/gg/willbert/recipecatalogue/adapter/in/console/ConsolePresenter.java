package org.gg.willbert.recipecatalogue.adapter.in.console;

import org.gg.willbert.recipecatalogue.adapter.in.RecipeImporter;
import org.gg.willbert.recipecatalogue.application.RecipeRepository;

import java.util.Scanner;

public class ConsolePresenter {

    private final RecipeRepository recipeRepository;

    public ConsolePresenter(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void present() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Willbert!");
        System.out.println("Find recipe (f)");
        System.out.println("Import recipes from file (i)");
        System.out.println("Quit (q)");

        String option = scanner.nextLine();

        if (option.equals("f")) {
            System.out.println("Enter search term...");
            String searchTerm = scanner.nextLine();

            System.out.println(recipeRepository.getByNameContains(searchTerm));

        } else if (option.equals("i")) {
            System.out.println("Enter filename (default, recipes.json)...");
            String filename = scanner.nextLine();
            if (filename.isEmpty()) {
                filename = "recipes.json";
            }

            RecipeImporter recipeImporter = new RecipeImporter(recipeRepository);
            recipeImporter.importRecipes(filename);
        }

        scanner.close();
    }


}
