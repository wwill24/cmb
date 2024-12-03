package org.apache.commons.beanutils.converters;

public final class IntegerConverter extends NumberConverter {
    public IntegerConverter() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public Class<Integer> getDefaultType() {
        return Integer.class;
    }

    public IntegerConverter(Object obj) {
        super(false, obj);
    }
}
