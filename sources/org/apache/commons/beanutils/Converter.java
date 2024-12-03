package org.apache.commons.beanutils;

public interface Converter {
    <T> T convert(Class<T> cls, Object obj);
}
