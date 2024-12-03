package org.apache.commons.beanutils.locale.converters;

import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class SqlTimeLocaleConverter extends DateLocaleConverter {
    public SqlTimeLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        return new Time(((Date) super.parse(obj, str)).getTime());
    }

    public SqlTimeLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public SqlTimeLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public SqlTimeLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public SqlTimeLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public SqlTimeLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
    }

    public SqlTimeLocaleConverter(Object obj) {
        this(obj, false);
    }

    public SqlTimeLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), false);
    }

    public SqlTimeLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public SqlTimeLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public SqlTimeLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public SqlTimeLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
    }
}
