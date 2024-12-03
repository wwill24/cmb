package org.apache.commons.beanutils.converters;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class SqlTimestampConverter extends DateTimeConverter {
    public SqlTimestampConverter() {
    }

    /* access modifiers changed from: protected */
    public Class<?> getDefaultType() {
        return Timestamp.class;
    }

    /* access modifiers changed from: protected */
    public DateFormat getFormat(Locale locale, TimeZone timeZone) {
        DateFormat dateFormat;
        if (locale == null) {
            dateFormat = DateFormat.getDateTimeInstance(3, 3);
        } else {
            dateFormat = DateFormat.getDateTimeInstance(3, 3, locale);
        }
        if (timeZone != null) {
            dateFormat.setTimeZone(timeZone);
        }
        return dateFormat;
    }

    public SqlTimestampConverter(Object obj) {
        super(obj);
    }
}
