package java.org.gg.willbert.backend.domain;

public class Ingredient {

    private Product product;
    private Amount amount;

    public Ingredient(Product product, Amount amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product product() {
        return product;
    }

    public Amount amount() {
        return amount;
    }

    public void setProduct(Product product) {
        // TODO: validate
        this.product = product;
    }

    public void setAmount(Amount amount) {
        // TODO validate
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "product=" + product +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient that)) return false;

        if (!product.equals(that.product)) return false;
        return amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        int result = product.hashCode();
        result = 31 * result + amount.hashCode();
        return result;
    }
}
