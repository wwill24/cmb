package org.apache.commons.beanutils.converters;

import java.net.URL;

public final class URLConverter extends AbstractConverter {
    public URLConverter() {
    }

    /* access modifiers changed from: protected */
    public <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        if (URL.class.equals(cls)) {
            return cls.cast(new URL(obj.toString()));
        }
        throw conversionException(cls, obj);
    }

    /* access modifiers changed from: protected */
    public Class<?> getDefaultType() {
        return URL.class;
    }

    public URLConverter(Object obj) {
        super(obj);
    }
}
