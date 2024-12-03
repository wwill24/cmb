package com.google.android.gms.internal.gtm;

import java.util.List;

final class zzvw extends zzvy {
    private zzvw() {
        super((zzvx) null);
    }

    /* synthetic */ zzvw(zzvv zzvv) {
        super((zzvx) null);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j10) {
        int i10;
        zzvh zzvh = (zzvh) zzxy.zzf(obj, j10);
        if (zzvh.zzc()) {
            return zzvh;
        }
        int size = zzvh.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size + size;
        }
        zzvh zzd = zzvh.zzd(i10);
        zzxy.zzs(obj, j10, zzd);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j10) {
        ((zzvh) zzxy.zzf(obj, j10)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zzc(Object obj, Object obj2, long j10) {
        zzvh zzvh = (zzvh) zzxy.zzf(obj, j10);
        zzvh zzvh2 = (zzvh) zzxy.zzf(obj2, j10);
        int size = zzvh.size();
        int size2 = zzvh2.size();
        if (size > 0 && size2 > 0) {
            if (!zzvh.zzc()) {
                zzvh = zzvh.zzd(size2 + size);
            }
            zzvh.addAll(zzvh2);
        }
        if (size > 0) {
            zzvh2 = zzvh;
        }
        zzxy.zzs(obj, j10, zzvh2);
    }
}
