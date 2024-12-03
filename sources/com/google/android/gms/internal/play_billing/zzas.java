package com.google.android.gms.internal.play_billing;

import java.util.Comparator;

final class zzas implements Comparator {
    zzas() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzba zzba = (zzba) obj;
        zzba zzba2 = (zzba) obj2;
        zzar zzar = new zzar(zzba);
        zzar zzar2 = new zzar(zzba2);
        while (zzar.hasNext() && zzar2.hasNext()) {
            int compareTo = Integer.valueOf(zzar.zza() & 255).compareTo(Integer.valueOf(zzar2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzba.zzd()).compareTo(Integer.valueOf(zzba2.zzd()));
    }
}
