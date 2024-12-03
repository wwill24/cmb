package org.apache.commons.beanutils.locale;

import org.apache.commons.beanutils.Converter;

public interface LocaleConverter extends Converter {
    <T> T convert(Class<T> cls, Object obj, String str);
}
