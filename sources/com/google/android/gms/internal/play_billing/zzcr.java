package com.google.android.gms.internal.play_billing;

final class zzcr extends zzct {
    private zzcr() {
        super((zzcs) null);
    }

    /* synthetic */ zzcr(zzcq zzcq) {
        super((zzcs) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j10) {
        ((zzcf) zzeq.zzf(obj, j10)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, Object obj2, long j10) {
        zzcf zzcf = (zzcf) zzeq.zzf(obj, j10);
        zzcf zzcf2 = (zzcf) zzeq.zzf(obj2, j10);
        int size = zzcf.size();
        int size2 = zzcf2.size();
        if (size > 0 && size2 > 0) {
            if (!zzcf.zzc()) {
                zzcf = zzcf.zzd(size2 + size);
            }
            zzcf.addAll(zzcf2);
        }
        if (size > 0) {
            zzcf2 = zzcf;
        }
        zzeq.zzs(obj, j10, zzcf2);
    }
}
