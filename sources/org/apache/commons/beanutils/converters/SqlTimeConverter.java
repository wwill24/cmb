package org.apache.commons.beanutils.converters;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class SqlTimeConverter extends DateTimeConverter {
    public SqlTimeConverter() {
    }

    /* access modifiers changed from: protected */
    public Class<?> getDefaultType() {
        return Time.class;
    }

    /* access modifiers changed from: protected */
    public DateFormat getFormat(Locale locale, TimeZone timeZone) {
        DateFormat dateFormat;
        if (locale == null) {
            dateFormat = DateFormat.getTimeInstance(3);
        } else {
            dateFormat = DateFormat.getTimeInstance(3, locale);
        }
        if (timeZone != null) {
            dateFormat.setTimeZone(timeZone);
        }
        return dateFormat;
    }

    public SqlTimeConverter(Object obj) {
        super(obj);
    }
}
