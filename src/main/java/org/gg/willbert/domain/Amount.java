package org.gg.willbert.domain;

public class Amount {

    private short value;
    private MeasurementUnit unit;

    public Amount(short value, MeasurementUnit unit) {
        if (value == 0 || value < 0) {
            throw new IllegalArgumentException("Value must be larger than 0");
        }
        this.value = value;
        this.unit = unit;
    }

    public short getValue() {
        return value;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }
}
