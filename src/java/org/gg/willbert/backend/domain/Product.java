package org.gg.willbert.backend.domain;

public class Product {

    private final String identification;
    private String name;
    private String description;
    private Price comparisonprice;
    private Price price;

    public Product(String identification, String name, String description, Price comparisonprice) {
        // TODO: validate
        this.identification = identification;
        this.name = name;
        this.description = description;
        this.comparisonprice = comparisonprice;
    }

    public String identification() {
        return identification;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public Price comparisonPrice() {
        return comparisonprice;
    }

    public Price price() {
        return price;
    }

    public void setDescription(String description) {
        // TODO validate
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComparisonPrice(Price price) {
        // TODO validate
        this.comparisonprice = price;
    }

    public void setPrice(Price price) {
        //TODO validate
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "identification='" + identification + '\'' +
                ", name='" + name + '\'' +
                ", comparisonPrice=" + comparisonprice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        return identification.equals(product.identification);
    }

    @Override
    public int hashCode() {
        return identification.hashCode();
    }
}
