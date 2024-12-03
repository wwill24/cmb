package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaix  reason: invalid package */
final class zzaix implements Comparator {
    zzaix() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzajf zzajf = (zzajf) obj;
        zzajf zzajf2 = (zzajf) obj2;
        zzaiw zzaiw = new zzaiw(zzajf);
        zzaiw zzaiw2 = new zzaiw(zzajf2);
        while (zzaiw.hasNext() && zzaiw2.hasNext()) {
            int compareTo = Integer.valueOf(zzaiw.zza() & 255).compareTo(Integer.valueOf(zzaiw2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzajf.zzd()).compareTo(Integer.valueOf(zzajf2.zzd()));
    }
}
