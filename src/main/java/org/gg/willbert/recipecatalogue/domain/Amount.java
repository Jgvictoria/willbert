package org.gg.willbert.recipecatalogue.domain;

public class Amount {

    private short value;
    private MeasurementUnit unit;

    public Amount(short value, MeasurementUnit unit) {
        requiresValueBiggerThanZero(value);
        requiresUnit(unit);
        this.value = value;
        this.unit = unit;
    }

    public short getValue() {
        return value;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }

    private static void requiresValueBiggerThanZero(short value) {
        if (value == 0 || value < 0) {
            throw new IllegalArgumentException("Value must be bigger than 0");
        }
    }

    private static void requiresUnit(MeasurementUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Measurement unit is mandatory");
        }
    }
}
