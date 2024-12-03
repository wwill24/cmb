package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

final class zzwf {
    zzwf() {
    }

    public static final int zza(int i10, Object obj, Object obj2) {
        zzwe zzwe = (zzwe) obj;
        zzwd zzwd = (zzwd) obj2;
        if (zzwe.isEmpty()) {
            return 0;
        }
        Iterator it = zzwe.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzwe) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzwe zzwe = (zzwe) obj;
        zzwe zzwe2 = (zzwe) obj2;
        if (!zzwe2.isEmpty()) {
            if (!zzwe.zze()) {
                zzwe = zzwe.zzb();
            }
            zzwe.zzd(zzwe2);
        }
        return zzwe;
    }
}
