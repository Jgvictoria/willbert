package org.gg.willbert.domain;

//TODO: implement compareTo using order
public class Instruction {

    private byte order;
    private String description;

    public Instruction(byte order, String description) {
        // TODO: validate
        this.order = order;
        this.description = description;
    }

    public short order() {
        return order;
    }

    public String description() {
        return description;
    }

    public void setOrder(byte order) {
        // TODO: validate
        this.order = order;
    }

    public void setDescription(String description) {
        // TODO: validate
        this.description = description;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "order=" + order +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instruction that)) return false;

        if (order != that.order) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = order;
        result = 31 * result + description.hashCode();
        return result;
    }
}
