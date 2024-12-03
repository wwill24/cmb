package org.apache.commons.beanutils.converters;

public final class LongConverter extends NumberConverter {
    public LongConverter() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public Class<Long> getDefaultType() {
        return Long.class;
    }

    public LongConverter(Object obj) {
        super(false, obj);
    }
}
