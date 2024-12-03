package org.apache.commons.validator.routines;

import java.text.DateFormat;
import java.text.Format;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class TimeValidator extends AbstractCalendarValidator {
    private static final TimeValidator VALIDATOR = new TimeValidator();
    private static final long serialVersionUID = 3494007492269691581L;

    public TimeValidator() {
        this(true, 3);
    }

    public static TimeValidator getInstance() {
        return VALIDATOR;
    }

    public int compareHours(Calendar calendar, Calendar calendar2) {
        return compareTime(calendar, calendar2, 11);
    }

    public int compareMinutes(Calendar calendar, Calendar calendar2) {
        return compareTime(calendar, calendar2, 12);
    }

    public int compareSeconds(Calendar calendar, Calendar calendar2) {
        return compareTime(calendar, calendar2, 13);
    }

    public int compareTime(Calendar calendar, Calendar calendar2) {
        return compareTime(calendar, calendar2, 14);
    }

    /* access modifiers changed from: protected */
    public Object processParsedValue(Object obj, Format format2) {
        return ((DateFormat) format2).getCalendar();
    }

    public Calendar validate(String str) {
        return (Calendar) parse(str, (String) null, (Locale) null, (TimeZone) null);
    }

    public TimeValidator(boolean z10, int i10) {
        super(z10, -1, i10);
    }

    public Calendar validate(String str, TimeZone timeZone) {
        return (Calendar) parse(str, (String) null, (Locale) null, timeZone);
    }

    public Calendar validate(String str, String str2) {
        return (Calendar) parse(str, str2, (Locale) null, (TimeZone) null);
    }

    public Calendar validate(String str, String str2, TimeZone timeZone) {
        return (Calendar) parse(str, str2, (Locale) null, timeZone);
    }

    public Calendar validate(String str, Locale locale) {
        return (Calendar) parse(str, (String) null, locale, (TimeZone) null);
    }

    public Calendar validate(String str, Locale locale, TimeZone timeZone) {
        return (Calendar) parse(str, (String) null, locale, timeZone);
    }

    public Calendar validate(String str, String str2, Locale locale) {
        return (Calendar) parse(str, str2, locale, (TimeZone) null);
    }

    public Calendar validate(String str, String str2, Locale locale, TimeZone timeZone) {
        return (Calendar) parse(str, str2, locale, timeZone);
    }
}
