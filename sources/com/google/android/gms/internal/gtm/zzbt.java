package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.d;

public final class zzbt {
    public static final String zza;
    public static final String zzb;

    static {
        String str;
        String replaceAll = String.valueOf(d.f38874a / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        zza = replaceAll;
        String valueOf = String.valueOf(replaceAll);
        if (valueOf.length() != 0) {
            str = "ma".concat(valueOf);
        } else {
            str = new String("ma");
        }
        zzb = str;
    }
}
