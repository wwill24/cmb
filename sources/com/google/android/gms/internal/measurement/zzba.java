package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

final class zzba implements Comparator {
    final /* synthetic */ zzai zza;
    final /* synthetic */ zzg zzb;

    zzba(zzai zzai, zzg zzg) {
        this.zza = zzai;
        this.zzb = zzg;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzap zzap = (zzap) obj;
        boolean z10 = zzap instanceof zzau;
        zzap zzap2 = (zzap) obj2;
        zzai zzai = this.zza;
        zzg zzg = this.zzb;
        if (z10) {
            if (!(zzap2 instanceof zzau)) {
                return 1;
            }
            return 0;
        } else if (zzap2 instanceof zzau) {
            return -1;
        } else {
            if (zzai == null) {
                return zzap.zzi().compareTo(zzap2.zzi());
            }
            return (int) zzh.zza(zzai.zza(zzg, Arrays.asList(new zzap[]{zzap, zzap2})).zzh().doubleValue());
        }
    }
}
