package com.google.android.gms.internal.location;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.apache.commons.cli.HelpFormatter;

public final class zzdj {
    private static final SimpleDateFormat zza;
    private static final SimpleDateFormat zzb;
    private static final StringBuilder zzc = new StringBuilder(33);

    static {
        Locale locale = Locale.ROOT;
        zza = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        zzb = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
    }

    public static String zza(long j10) {
        String sb2;
        StringBuilder sb3 = zzc;
        synchronized (sb3) {
            sb3.setLength(0);
            zzb(j10, sb3);
            sb2 = sb3.toString();
        }
        return sb2;
    }

    public static void zzb(long j10, StringBuilder sb2) {
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 == 0) {
            sb2.append("0s");
            return;
        }
        sb2.ensureCapacity(sb2.length() + 27);
        boolean z10 = false;
        if (i10 < 0) {
            sb2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            if (j10 != Long.MIN_VALUE) {
                j10 = -j10;
            } else {
                j10 = Long.MAX_VALUE;
                z10 = true;
            }
        }
        if (j10 >= 86400000) {
            sb2.append(j10 / 86400000);
            sb2.append("d");
            j10 %= 86400000;
        }
        if (true == z10) {
            j10 = 25975808;
        }
        if (j10 >= DateUtils.MILLIS_IN_HOUR) {
            sb2.append(j10 / DateUtils.MILLIS_IN_HOUR);
            sb2.append("h");
            j10 %= DateUtils.MILLIS_IN_HOUR;
        }
        if (j10 >= DateUtils.MILLIS_IN_MINUTE) {
            sb2.append(j10 / DateUtils.MILLIS_IN_MINUTE);
            sb2.append(NetworkProfile.MALE);
            j10 %= DateUtils.MILLIS_IN_MINUTE;
        }
        if (j10 >= 1000) {
            sb2.append(j10 / 1000);
            sb2.append("s");
            j10 %= 1000;
        }
        if (j10 > 0) {
            sb2.append(j10);
            sb2.append("ms");
        }
    }
}
