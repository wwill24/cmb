package org.apache.commons.validator.routines;

import java.io.Serializable;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Locale;

public abstract class AbstractFormatValidator implements Serializable {
    private static final long serialVersionUID = -4690687565200568258L;
    private final boolean strict;

    public AbstractFormatValidator(boolean z10) {
        this.strict = z10;
    }

    public String format(Object obj) {
        return format(obj, (String) null, (Locale) null);
    }

    /* access modifiers changed from: protected */
    public abstract Format getFormat(String str, Locale locale);

    public boolean isStrict() {
        return this.strict;
    }

    public boolean isValid(String str) {
        return isValid(str, (String) null, (Locale) null);
    }

    public abstract boolean isValid(String str, String str2, Locale locale);

    /* access modifiers changed from: protected */
    public Object parse(String str, Format format2) {
        ParsePosition parsePosition = new ParsePosition(0);
        Object parseObject = format2.parseObject(str, parsePosition);
        if (parsePosition.getErrorIndex() > -1) {
            return null;
        }
        if (isStrict() && parsePosition.getIndex() < str.length()) {
            return null;
        }
        if (parseObject != null) {
            return processParsedValue(parseObject, format2);
        }
        return parseObject;
    }

    /* access modifiers changed from: protected */
    public abstract Object processParsedValue(Object obj, Format format2);

    public String format(Object obj, String str) {
        return format(obj, str, (Locale) null);
    }

    public boolean isValid(String str, String str2) {
        return isValid(str, str2, (Locale) null);
    }

    public String format(Object obj, Locale locale) {
        return format(obj, (String) null, locale);
    }

    public boolean isValid(String str, Locale locale) {
        return isValid(str, (String) null, locale);
    }

    public String format(Object obj, String str, Locale locale) {
        return format(obj, getFormat(str, locale));
    }

    /* access modifiers changed from: protected */
    public String format(Object obj, Format format2) {
        return format2.format(obj);
    }
}
