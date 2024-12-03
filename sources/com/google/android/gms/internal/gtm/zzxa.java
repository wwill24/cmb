package com.google.android.gms.internal.gtm;

import java.util.Map;

final class zzxa extends zzxk {
    zzxa(int i10) {
        super(i10, (zzxj) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i10 = 0; i10 < zzb(); i10++) {
                ((zzun) zzg(i10).getKey()).zzg();
            }
            for (Map.Entry key : zzc()) {
                ((zzun) key.getKey()).zzg();
            }
        }
        super.zza();
    }
}
