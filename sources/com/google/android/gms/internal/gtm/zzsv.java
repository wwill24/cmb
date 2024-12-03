package com.google.android.gms.internal.gtm;

import java.util.Comparator;

final class zzsv implements Comparator<zztd> {
    zzsv() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zztd zztd = (zztd) obj;
        zztd zztd2 = (zztd) obj2;
        zzst zzst = new zzst(zztd);
        zzst zzst2 = new zzst(zztd2);
        while (zzst.hasNext() && zzst2.hasNext()) {
            int zza = zzsu.zza(zzst.zza() & 255, zzst2.zza() & 255);
            if (zza != 0) {
                return zza;
            }
        }
        return zzsu.zza(zztd.zzd(), zztd2.zzd());
    }
}
