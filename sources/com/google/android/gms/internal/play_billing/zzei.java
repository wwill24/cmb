package com.google.android.gms.internal.play_billing;

import java.io.IOException;

final class zzei extends zzeg {
    zzei() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zza(Object obj) {
        return ((zzeh) obj).zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzeh) obj).zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzcb zzcb = (zzcb) obj;
        zzeh zzeh = zzcb.zzc;
        if (zzeh != zzeh.zzc()) {
            return zzeh;
        }
        zzeh zzf = zzeh.zzf();
        zzcb.zzc = zzf;
        return zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzcb) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzeh.zzc().equals(obj2)) {
            return obj;
        }
        if (zzeh.zzc().equals(obj)) {
            return zzeh.zze((zzeh) obj, (zzeh) obj2);
        }
        ((zzeh) obj).zzd((zzeh) obj2);
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i10, long j10) {
        ((zzeh) obj).zzj(i10 << 3, Long.valueOf(j10));
    }

    /* access modifiers changed from: package-private */
    public final void zzg(Object obj) {
        ((zzcb) obj).zzc.zzh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzcb) obj).zzc = (zzeh) obj2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(Object obj, zzey zzey) throws IOException {
        ((zzeh) obj).zzk(zzey);
    }
}
