package org.gg.willbert;

import java.util.List;

public class RecipeFinder {

    private final List<String> recipeNames = List.of("burger", "meatballs", "meatloaf");

    public List<String> byName(String name) {
        String normalizedName = name.toLowerCase();

        return recipeNames.stream()
                .filter(n -> n.contains(normalizedName))
                .toList();
    }
}
