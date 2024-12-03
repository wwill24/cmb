package org.apache.commons.beanutils.converters;

public final class ByteConverter extends NumberConverter {
    public ByteConverter() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public Class<Byte> getDefaultType() {
        return Byte.class;
    }

    public ByteConverter(Object obj) {
        super(false, obj);
    }
}
