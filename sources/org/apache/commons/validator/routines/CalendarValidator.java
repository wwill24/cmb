package org.apache.commons.validator.routines;

import java.text.DateFormat;
import java.text.Format;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarValidator extends AbstractCalendarValidator {
    private static final CalendarValidator VALIDATOR = new CalendarValidator();
    private static final long serialVersionUID = 9109652318762134167L;

    public CalendarValidator() {
        this(true, 3);
    }

    public static void adjustToTimeZone(Calendar calendar, TimeZone timeZone) {
        if (calendar.getTimeZone().hasSameRules(timeZone)) {
            calendar.setTimeZone(timeZone);
            return;
        }
        int i10 = calendar.get(1);
        int i11 = calendar.get(2);
        int i12 = calendar.get(5);
        int i13 = calendar.get(11);
        int i14 = calendar.get(12);
        calendar.setTimeZone(timeZone);
        calendar.set(i10, i11, i12, i13, i14);
    }

    public static CalendarValidator getInstance() {
        return VALIDATOR;
    }

    public int compareDates(Calendar calendar, Calendar calendar2) {
        return compare(calendar, calendar2, 5);
    }

    public int compareMonths(Calendar calendar, Calendar calendar2) {
        return compare(calendar, calendar2, 2);
    }

    public int compareQuarters(Calendar calendar, Calendar calendar2) {
        return compareQuarters(calendar, calendar2, 1);
    }

    public int compareWeeks(Calendar calendar, Calendar calendar2) {
        return compare(calendar, calendar2, 3);
    }

    public int compareYears(Calendar calendar, Calendar calendar2) {
        return compare(calendar, calendar2, 1);
    }

    /* access modifiers changed from: protected */
    public Object processParsedValue(Object obj, Format format2) {
        return ((DateFormat) format2).getCalendar();
    }

    public Calendar validate(String str) {
        return (Calendar) parse(str, (String) null, (Locale) null, (TimeZone) null);
    }

    public CalendarValidator(boolean z10, int i10) {
        super(z10, i10, -1);
    }

    public int compareQuarters(Calendar calendar, Calendar calendar2, int i10) {
        return super.compareQuarters(calendar, calendar2, i10);
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
