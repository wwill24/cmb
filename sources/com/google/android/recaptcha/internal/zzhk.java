package com.google.android.recaptcha.internal;

import java.util.List;

final class zzhk extends zzhm {
    private zzhk() {
        super((zzhl) null);
    }

    /* synthetic */ zzhk(zzhj zzhj) {
        super((zzhl) null);
    }

    /* access modifiers changed from: package-private */
    public final List zza(Object obj, long j10) {
        int i10;
        zzgv zzgv = (zzgv) zzjp.zzf(obj, j10);
        if (zzgv.zzc()) {
            return zzgv;
        }
        int size = zzgv.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size + size;
        }
        zzgv zzd = zzgv.zzd(i10);
        zzjp.zzs(obj, j10, zzd);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j10) {
        ((zzgv) zzjp.zzf(obj, j10)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj, Object obj2, long j10) {
        zzgv zzgv = (zzgv) zzjp.zzf(obj, j10);
        zzgv zzgv2 = (zzgv) zzjp.zzf(obj2, j10);
        int size = zzgv.size();
        int size2 = zzgv2.size();
        if (size > 0 && size2 > 0) {
            if (!zzgv.zzc()) {
                zzgv = zzgv.zzd(size2 + size);
            }
            zzgv.addAll(zzgv2);
        }
        if (size > 0) {
            zzgv2 = zzgv;
        }
        zzjp.zzs(obj, j10, zzgv2);
    }
}
