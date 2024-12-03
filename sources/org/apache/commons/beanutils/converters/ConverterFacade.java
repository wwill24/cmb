package org.apache.commons.beanutils.converters;

import org.apache.commons.beanutils.Converter;

public final class ConverterFacade implements Converter {
    private final Converter converter;

    public ConverterFacade(Converter converter2) {
        if (converter2 != null) {
            this.converter = converter2;
            return;
        }
        throw new IllegalArgumentException("Converter is missing");
    }

    public <T> T convert(Class<T> cls, Object obj) {
        return this.converter.convert(cls, obj);
    }

    public String toString() {
        return "ConverterFacade[" + this.converter.toString() + "]";
    }
}
