package org.apache.commons.beanutils.converters;

import java.io.File;

public final class FileConverter extends AbstractConverter {
    public FileConverter() {
    }

    /* access modifiers changed from: protected */
    public <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        if (File.class.equals(cls)) {
            return cls.cast(new File(obj.toString()));
        }
        throw conversionException(cls, obj);
    }

    /* access modifiers changed from: protected */
    public Class<?> getDefaultType() {
        return File.class;
    }

    public FileConverter(Object obj) {
        super(obj);
    }
}
