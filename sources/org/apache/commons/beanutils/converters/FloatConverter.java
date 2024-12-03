package org.apache.commons.beanutils.converters;

public final class FloatConverter extends NumberConverter {
    public FloatConverter() {
        super(true);
    }

    /* access modifiers changed from: protected */
    public Class<Float> getDefaultType() {
        return Float.class;
    }

    public FloatConverter(Object obj) {
        super(true, obj);
    }
}
