package org.apache.commons.beanutils.converters;

public final class DoubleConverter extends NumberConverter {
    public DoubleConverter() {
        super(true);
    }

    /* access modifiers changed from: protected */
    public Class<Double> getDefaultType() {
        return Double.class;
    }

    public DoubleConverter(Object obj) {
        super(true, obj);
    }
}
