package org.apache.commons.validator.routines;

import java.text.Format;
import java.util.Locale;

public class LongValidator extends AbstractNumberValidator {
    private static final LongValidator VALIDATOR = new LongValidator();
    private static final long serialVersionUID = -5117231731027866098L;

    public LongValidator() {
        this(true, 0);
    }

    public static LongValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isInRange(long j10, long j11, long j12) {
        return j10 >= j11 && j10 <= j12;
    }

    public boolean isInRange(Long l10, long j10, long j11) {
        return isInRange(l10.longValue(), j10, j11);
    }

    public boolean maxValue(long j10, long j11) {
        return j10 <= j11;
    }

    public boolean maxValue(Long l10, long j10) {
        return maxValue(l10.longValue(), j10);
    }

    public boolean minValue(long j10, long j11) {
        return j10 >= j11;
    }

    public boolean minValue(Long l10, long j10) {
        return minValue(l10.longValue(), j10);
    }

    /* access modifiers changed from: protected */
    public Object processParsedValue(Object obj, Format format2) {
        if (obj instanceof Long) {
            return obj;
        }
        return new Long(((Number) obj).longValue());
    }

    public Long validate(String str) {
        return (Long) parse(str, (String) null, (Locale) null);
    }

    public LongValidator(boolean z10, int i10) {
        super(z10, i10, false);
    }

    public Long validate(String str, String str2) {
        return (Long) parse(str, str2, (Locale) null);
    }

    public Long validate(String str, Locale locale) {
        return (Long) parse(str, (String) null, locale);
    }

    public Long validate(String str, String str2, Locale locale) {
        return (Long) parse(str, str2, locale);
    }
}
