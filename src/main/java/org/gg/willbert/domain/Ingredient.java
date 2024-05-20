package org.gg.willbert.domain;

public class Ingredient {

    private String productName;
    private Amount amount;

    public Ingredient(String productName, Amount amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount is mandatory");
        }
        //TODO: validate name /product
        this.productName = productName;
        this.amount = amount;
    }

    public Amount getAmount() {
        return amount;
    }

    public String getProductName() {
        return productName;
    }
}
