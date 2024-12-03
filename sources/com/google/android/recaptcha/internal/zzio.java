package com.google.android.recaptcha.internal;

import java.util.Map;

final class zzio extends zziy {
    zzio(int i10) {
        super(i10, (zzix) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i10 = 0; i10 < zzb(); i10++) {
                ((zzgd) zzg(i10).getKey()).zzg();
            }
            for (Map.Entry key : zzc()) {
                ((zzgd) key.getKey()).zzg();
            }
        }
        super.zza();
    }
}
