package com.facebook.gamingservices.internal;

import android.os.Build;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/facebook/gamingservices/internal/DateFormatter;", "", "", "isoDate", "j$/time/ZonedDateTime", "format$facebook_gamingservices_release", "(Ljava/lang/String;)Lj$/time/ZonedDateTime;", "format", "<init>", "()V", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1})
public final class DateFormatter {
    public static final DateFormatter INSTANCE = new DateFormatter();

    private DateFormatter() {
    }

    public final ZonedDateTime format$facebook_gamingservices_release(String str) {
        j.g(str, "isoDate");
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        j.f(ofPattern, "ofPattern(\"yyyy-MM-dd'T'HH:mm:ssZ\")");
        return ZonedDateTime.parse(str, ofPattern);
    }
}
