package org.gg.willbert.recipecatalogue.adapter.in;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.gg.willbert.recipecatalogue.application.RecipeRepository;
import org.gg.willbert.recipecatalogue.domain.Recipe;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RecipeImporter {

    private final RecipeRepository recipeRepository;

    public RecipeImporter(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void importRecipes(String filename) {
        Optional<Path> jsonRecipe = getFromDefaultLocation(filename);

        if (jsonRecipe.isPresent()) {
            List<Recipe> recipes = parseJson(jsonRecipe.get());
            recipeRepository.save(recipes.getFirst());
        }
    }

    private List<Recipe> parseJson(Path jsonFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<RecipeDTO> recipeDTOS = objectMapper.readValue(jsonFile.toFile(), new TypeReference<List<RecipeDTO>>() {
            });

            return recipeDTOS.stream().map(RecipeDTO::to).toList();
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private Optional<Path> getFromDefaultLocation(String filename) {
        URL resource = RecipeImporter.class.getClassLoader().getResource(filename);

        if (resource == null) {
            return Optional.empty();
        }

        try {
            return Optional.of(Paths.get(resource.toURI()));
        } catch (URISyntaxException e) {
            return Optional.empty();
        }
    }
}
