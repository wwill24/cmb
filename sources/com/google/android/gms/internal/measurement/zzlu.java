package com.google.android.gms.internal.measurement;

final class zzlu extends zzlw {
    private zzlu() {
        super((zzlv) null);
    }

    /* synthetic */ zzlu(zzlt zzlt) {
        super((zzlv) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j10) {
        ((zzli) zznu.zzf(obj, j10)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, Object obj2, long j10) {
        zzli zzli = (zzli) zznu.zzf(obj, j10);
        zzli zzli2 = (zzli) zznu.zzf(obj2, j10);
        int size = zzli.size();
        int size2 = zzli2.size();
        if (size > 0 && size2 > 0) {
            if (!zzli.zzc()) {
                zzli = zzli.zzd(size2 + size);
            }
            zzli.addAll(zzli2);
        }
        if (size > 0) {
            zzli2 = zzli;
        }
        zznu.zzs(obj, j10, zzli2);
    }
}
