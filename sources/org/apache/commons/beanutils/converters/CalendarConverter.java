package org.apache.commons.beanutils.converters;

import java.util.Calendar;

public final class CalendarConverter extends DateTimeConverter {
    public CalendarConverter() {
    }

    /* access modifiers changed from: protected */
    public Class<?> getDefaultType() {
        return Calendar.class;
    }

    public CalendarConverter(Object obj) {
        super(obj);
    }
}
