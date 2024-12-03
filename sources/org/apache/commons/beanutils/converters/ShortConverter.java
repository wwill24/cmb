package org.apache.commons.beanutils.converters;

public final class ShortConverter extends NumberConverter {
    public ShortConverter() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public Class<Short> getDefaultType() {
        return Short.class;
    }

    public ShortConverter(Object obj) {
        super(false, obj);
    }
}
