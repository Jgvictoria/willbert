package org.gg.willbert.recipecatalogue.adapter.in.console;

import org.gg.willbert.recipecatalogue.adapter.in.JsonRecipeImporter;
import org.gg.willbert.recipecatalogue.application.RecipeService;

public class ConsolePresenter {

    private final RecipeService recipeService;
    private final SimpleIOHandler ioHandler;

    public ConsolePresenter(RecipeService recipeService, SimpleIOHandler ioHandler) {
        this.recipeService = recipeService;
        this.ioHandler = ioHandler;
    }

    public void present() {
        welcome();
        UserAction action = presentAndSelectAction();

        switch (action) {
            case f -> findRecipes();
            case i -> importRecipes();
            case q -> quit();
            default -> throw new IllegalStateException("Unexpected action: " + action);
        }
        ;

        quit(); //TODO: loop?
    }

    private UserAction presentAndSelectAction() {
        ioHandler.output(UserAction.toPrintableActions());
        return UserAction.valueOf(ioHandler.getInput());
    }

    private void welcome() {
        ioHandler.output("Welcome to Willbert!");
    }

    private void quit() {
        ioHandler.close();
    }

    private void findRecipes() {
        ioHandler.output("Enter search term...");
        String searchTerm = ioHandler.getInput();
        ioHandler.output(recipeService.getByNameContains(searchTerm).toString());
    }

    private void importRecipes() {
        ioHandler.output("Enter filename (default, recipes.json)...");
        String filename = ioHandler.getInput();
        if (filename.isEmpty()) {
            filename = "recipes.json";
        }

        JsonRecipeImporter jsonRecipeImporter = new JsonRecipeImporter(recipeService);
        jsonRecipeImporter.importRecipes(filename);
    }
}