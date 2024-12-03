package org.jivesoftware.smack.datatypes;

import org.jivesoftware.smack.util.DefaultCharSequence;

public abstract class Scalar extends Number implements DefaultCharSequence {
    private static final long serialVersionUID = 1;
    private final Number number;

    protected Scalar(Number number2) {
        this.number = number2;
    }

    public final double doubleValue() {
        return this.number.doubleValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Scalar)) {
            return false;
        }
        Scalar scalar = (Scalar) obj;
        if (longValue() == scalar.longValue() || doubleValue() == scalar.doubleValue() || floatValue() == scalar.floatValue()) {
            return true;
        }
        return false;
    }

    public final float floatValue() {
        return this.number.floatValue();
    }

    public abstract Scalar getMaxValue();

    public abstract Scalar getMinValue();

    public abstract int hashCode();

    public abstract Scalar incrementedByOne();

    public final int intValue() {
        return this.number.intValue();
    }

    public final long longValue() {
        return this.number.longValue();
    }

    public final Number number() {
        return this.number;
    }

    public final String toString() {
        return this.number.toString();
    }
}
