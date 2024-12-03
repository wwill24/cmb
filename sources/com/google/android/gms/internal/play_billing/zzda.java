package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;

final class zzda {
    zzda() {
    }

    public static final int zza(int i10, Object obj, Object obj2) {
        zzcz zzcz = (zzcz) obj;
        zzcy zzcy = (zzcy) obj2;
        if (zzcz.isEmpty()) {
            return 0;
        }
        Iterator it = zzcz.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzcz zzcz = (zzcz) obj;
        zzcz zzcz2 = (zzcz) obj2;
        if (!zzcz2.isEmpty()) {
            if (!zzcz.zze()) {
                zzcz = zzcz.zzb();
            }
            zzcz.zzd(zzcz2);
        }
        return zzcz;
    }
}
