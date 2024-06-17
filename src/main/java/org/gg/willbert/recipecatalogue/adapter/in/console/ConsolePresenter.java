package org.gg.willbert.recipecatalogue.adapter.in.console;

import org.gg.willbert.recipecatalogue.adapter.in.JsonRecipeImporter;
import org.gg.willbert.recipecatalogue.application.RecipeService;

import java.util.Scanner;

public class ConsolePresenter {

    private final RecipeService recipeService;
    private final StringInputRequester requester;

    public ConsolePresenter(RecipeService recipeService, StringInputRequester requester) {
        this.recipeService = recipeService;
        this.requester = requester;
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

            System.out.println(recipeService.getByNameContains(searchTerm));

        } else if (option.equals("i")) {
            System.out.println("Enter filename (default, recipes.json)...");
            String filename = scanner.nextLine();
            if (filename.isEmpty()) {
                filename = "recipes.json";
            }

            JsonRecipeImporter jsonRecipeImporter = new JsonRecipeImporter(recipeService);
            jsonRecipeImporter.importRecipes(filename);
        }

        scanner.close();
    }


}
