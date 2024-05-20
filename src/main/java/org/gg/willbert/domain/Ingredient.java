package org.gg.willbert.domain;

public class Ingredient {

    private String name;
    private String amount;

    public Ingredient(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }
}
