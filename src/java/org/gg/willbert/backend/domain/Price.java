package java.org.gg.willbert.backend.domain;

public class Price {

    private float value;
    private ComparisonUnit unit;

    public Price(float value, ComparisonUnit unit) {
        // TODO: validate
        this.value = value;
        this.unit = unit;
    }

    public float value() {
        return value;
    }

    public ComparisonUnit unit() {
        return unit;
    }

    public void setValue(float value) {
        // TODO: validate
        this.value = value;
    }

    public void setUnit(ComparisonUnit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ComparisonPrice{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price that)) return false;

        if (Float.compare(value, that.value) != 0) return false;
        return unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        int result = (value != 0.0f ? Float.floatToIntBits(value) : 0);
        result = 31 * result + unit.hashCode();
        return result;
    }
}
