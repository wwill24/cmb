package org.apache.commons.validator.routines;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public abstract class AbstractCalendarValidator extends AbstractFormatValidator {
    private static final long serialVersionUID = -1410008585975827379L;
    private final int dateStyle;
    private final int timeStyle;

    public AbstractCalendarValidator(boolean z10, int i10, int i11) {
        super(z10);
        this.dateStyle = i10;
        this.timeStyle = i11;
    }

    private int calculateCompareResult(Calendar calendar, Calendar calendar2, int i10) {
        int i11 = calendar.get(i10) - calendar2.get(i10);
        if (i11 < 0) {
            return -1;
        }
        return i11 > 0 ? 1 : 0;
    }

    private int calculateQuarter(Calendar calendar, int i10) {
        int i11;
        int i12 = calendar.get(1);
        int i13 = calendar.get(2) + 1;
        if (i13 >= i10) {
            i11 = i13 - i10;
        } else {
            i11 = (12 - i10) + i13;
        }
        int i14 = (i11 / 3) + 1;
        if (i13 < i10) {
            i12--;
        }
        return (i12 * 10) + i14;
    }

    /* access modifiers changed from: protected */
    public int compare(Calendar calendar, Calendar calendar2, int i10) {
        int calculateCompareResult = calculateCompareResult(calendar, calendar2, 1);
        if (calculateCompareResult == 0 && i10 != 1) {
            if (i10 == 3) {
                return calculateCompareResult(calendar, calendar2, 3);
            }
            if (i10 == 6) {
                return calculateCompareResult(calendar, calendar2, 6);
            }
            calculateCompareResult = calculateCompareResult(calendar, calendar2, 2);
            if (calculateCompareResult == 0 && i10 != 2) {
                if (i10 == 4) {
                    return calculateCompareResult(calendar, calendar2, 4);
                }
                calculateCompareResult = calculateCompareResult(calendar, calendar2, 5);
                if (!(calculateCompareResult != 0 || i10 == 5 || i10 == 7 || i10 == 8)) {
                    return compareTime(calendar, calendar2, i10);
                }
            }
        }
        return calculateCompareResult;
    }

    /* access modifiers changed from: protected */
    public int compareQuarters(Calendar calendar, Calendar calendar2, int i10) {
        int calculateQuarter = calculateQuarter(calendar, i10);
        int calculateQuarter2 = calculateQuarter(calendar2, i10);
        if (calculateQuarter < calculateQuarter2) {
            return -1;
        }
        if (calculateQuarter > calculateQuarter2) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int compareTime(Calendar calendar, Calendar calendar2, int i10) {
        int calculateCompareResult = calculateCompareResult(calendar, calendar2, 11);
        if (calculateCompareResult != 0 || i10 == 10 || i10 == 11 || (calculateCompareResult = calculateCompareResult(calendar, calendar2, 12)) != 0 || i10 == 12 || (calculateCompareResult = calculateCompareResult(calendar, calendar2, 13)) != 0 || i10 == 13) {
            return calculateCompareResult;
        }
        if (i10 == 14) {
            return calculateCompareResult(calendar, calendar2, 14);
        }
        throw new IllegalArgumentException("Invalid field: " + i10);
    }

    public String format(Object obj, TimeZone timeZone) {
        return format(obj, (String) null, (Locale) null, timeZone);
    }

    /* access modifiers changed from: protected */
    public Format getFormat(String str, Locale locale) {
        DateFormat dateFormat;
        SimpleDateFormat simpleDateFormat;
        if (!(str != null && str.length() > 0)) {
            dateFormat = (DateFormat) getFormat(locale);
        } else {
            if (locale == null) {
                simpleDateFormat = new SimpleDateFormat(str);
            } else {
                simpleDateFormat = new SimpleDateFormat(str, new DateFormatSymbols(locale));
            }
            dateFormat = simpleDateFormat;
        }
        dateFormat.setLenient(false);
        return dateFormat;
    }

    public boolean isValid(String str, String str2, Locale locale) {
        return parse(str, str2, locale, (TimeZone) null) != null;
    }

    /* access modifiers changed from: protected */
    public Object parse(String str, String str2, Locale locale, TimeZone timeZone) {
        String str3;
        if (str == null) {
            str3 = null;
        } else {
            str3 = str.trim();
        }
        if (str3 == null || str3.length() == 0) {
            return null;
        }
        DateFormat dateFormat = (DateFormat) getFormat(str2, locale);
        if (timeZone != null) {
            dateFormat.setTimeZone(timeZone);
        }
        return parse(str3, dateFormat);
    }

    /* access modifiers changed from: protected */
    public abstract Object processParsedValue(Object obj, Format format2);

    public String format(Object obj, String str, TimeZone timeZone) {
        return format(obj, str, (Locale) null, timeZone);
    }

    public String format(Object obj, Locale locale, TimeZone timeZone) {
        return format(obj, (String) null, locale, timeZone);
    }

    public String format(Object obj, String str, Locale locale) {
        return format(obj, str, locale, (TimeZone) null);
    }

    public String format(Object obj, String str, Locale locale, TimeZone timeZone) {
        DateFormat dateFormat = (DateFormat) getFormat(str, locale);
        if (timeZone != null) {
            dateFormat.setTimeZone(timeZone);
        } else if (obj instanceof Calendar) {
            dateFormat.setTimeZone(((Calendar) obj).getTimeZone());
        }
        return format(obj, (Format) dateFormat);
    }

    /* access modifiers changed from: protected */
    public Format getFormat(Locale locale) {
        DateFormat dateFormat;
        int i10;
        int i11 = this.dateStyle;
        if (i11 < 0 || (i10 = this.timeStyle) < 0) {
            int i12 = this.timeStyle;
            if (i12 < 0) {
                if (i11 < 0) {
                    i11 = 3;
                }
                if (locale == null) {
                    dateFormat = DateFormat.getDateInstance(i11);
                } else {
                    dateFormat = DateFormat.getDateInstance(i11, locale);
                }
            } else if (locale == null) {
                dateFormat = DateFormat.getTimeInstance(i12);
            } else {
                dateFormat = DateFormat.getTimeInstance(i12, locale);
            }
        } else if (locale == null) {
            dateFormat = DateFormat.getDateTimeInstance(i11, i10);
        } else {
            dateFormat = DateFormat.getDateTimeInstance(i11, i10, locale);
        }
        dateFormat.setLenient(false);
        return dateFormat;
    }

    /* access modifiers changed from: protected */
    public String format(Object obj, Format format2) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            obj = ((Calendar) obj).getTime();
        }
        return format2.format(obj);
    }
}
