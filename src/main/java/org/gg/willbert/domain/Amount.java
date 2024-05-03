package org.gg.willbert.domain;

public class Amount {

    private short value;
    private MeasurementUnit unit;

    public Amount(short value, MeasurementUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public short value() {
        return value;
    }

    public MeasurementUnit unit() {
        return unit;
    }

    public void setValue(short value) {
        // TODO: validate
        this.value = value;
    }

    public void setUnit(MeasurementUnit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amount amount)) return false;

        if (value != amount.value) return false;
        return unit == amount.unit;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + unit.hashCode();
        return result;
    }
}
