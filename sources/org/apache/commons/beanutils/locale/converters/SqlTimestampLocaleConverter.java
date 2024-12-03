package org.apache.commons.beanutils.locale.converters;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class SqlTimestampLocaleConverter extends DateLocaleConverter {
    public SqlTimestampLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        return new Timestamp(((Date) super.parse(obj, str)).getTime());
    }

    public SqlTimestampLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public SqlTimestampLocaleConverter(Locale locale) {
        this(locale, (String) null);
    }

    public SqlTimestampLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null);
    }

    public SqlTimestampLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public SqlTimestampLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
    }

    public SqlTimestampLocaleConverter(Object obj) {
        this(obj, false);
    }

    public SqlTimestampLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public SqlTimestampLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public SqlTimestampLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public SqlTimestampLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public SqlTimestampLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
    }
}
