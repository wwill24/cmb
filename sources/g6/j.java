package g6;

import fa.a;
import j$.time.OffsetDateTime;
import j$.time.format.DateTimeFormatter;

public final class j {
    public final String a(OffsetDateTime offsetDateTime) {
        String format2 = offsetDateTime != null ? offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) : null;
        return format2 == null ? "" : format2;
    }

    public final OffsetDateTime b(String str) {
        boolean z10;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return null;
        }
        try {
            return OffsetDateTime.parse(str, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (Exception e10) {
            a.C0491a aVar = a.f40771d;
            aVar.c("OffsetDateTimeConverter", "Unable to parse " + str + " as an OffsetDateTime.", e10);
            return OffsetDateTime.MIN;
        }
    }
}
