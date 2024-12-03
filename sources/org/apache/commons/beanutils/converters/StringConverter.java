package org.apache.commons.beanutils.converters;

public final class StringConverter extends AbstractConverter {
    public StringConverter() {
    }

    /* access modifiers changed from: protected */
    public <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        if (String.class.equals(cls) || Object.class.equals(cls)) {
            return cls.cast(obj.toString());
        }
        throw conversionException(cls, obj);
    }

    /* access modifiers changed from: protected */
    public Class<?> getDefaultType() {
        return String.class;
    }

    public StringConverter(Object obj) {
        super(obj);
    }
}
