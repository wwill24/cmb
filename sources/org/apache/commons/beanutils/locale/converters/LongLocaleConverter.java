package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;

public class LongLocaleConverter extends DecimalLocaleConverter {
    public LongLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        Object parse = super.parse(obj, str);
        if (parse == null || (parse instanceof Long)) {
            return parse;
        }
        return new Long(((Number) parse).longValue());
    }

    public LongLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public LongLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public LongLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public LongLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public LongLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
    }

    public LongLocaleConverter(Object obj) {
        this(obj, false);
    }

    public LongLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public LongLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public LongLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public LongLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public LongLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
    }
}
