package org.apache.commons.beanutils.locale.converters;

import java.sql.Date;
import java.text.ParseException;
import java.util.Locale;

public class SqlDateLocaleConverter extends DateLocaleConverter {
    public SqlDateLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        return new Date(((java.util.Date) super.parse(obj, str)).getTime());
    }

    public SqlDateLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public SqlDateLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public SqlDateLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public SqlDateLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public SqlDateLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
    }

    public SqlDateLocaleConverter(Object obj) {
        this(obj, false);
    }

    public SqlDateLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
    }
}
