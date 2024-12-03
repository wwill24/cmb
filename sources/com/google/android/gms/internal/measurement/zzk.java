package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzk extends zzai {
    private final zzab zza;

    public zzk(zzab zzab) {
        super("internal.eventLogger");
        this.zza = zzab;
    }

    public final zzap zza(zzg zzg, List list) {
        Map map;
        zzh.zzh(this.zzd, 3, list);
        String zzi = zzg.zzb((zzap) list.get(0)).zzi();
        long zza2 = (long) zzh.zza(zzg.zzb((zzap) list.get(1)).zzh().doubleValue());
        zzap zzb = zzg.zzb((zzap) list.get(2));
        if (zzb instanceof zzam) {
            map = zzh.zzg((zzam) zzb);
        } else {
            map = new HashMap();
        }
        this.zza.zze(zzi, zza2, map);
        return zzap.zzf;
    }
}
