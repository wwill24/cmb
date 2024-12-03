package org.apache.commons.beanutils.converters;

import java.util.Date;

public final class DateConverter extends DateTimeConverter {
    public DateConverter() {
    }

    /* access modifiers changed from: protected */
    public Class<?> getDefaultType() {
        return Date.class;
    }

    public DateConverter(Object obj) {
        super(obj);
    }
}
