package com.google.android.gms.internal.gtm;

import android.os.Handler;
import com.google.android.gms.common.internal.p;

abstract class zzcw {
    private static volatile Handler zza;
    /* access modifiers changed from: private */
    public final zzbv zzb;
    private final Runnable zzc = new zzcv(this);
    /* access modifiers changed from: private */
    public volatile long zzd;

    zzcw(zzbv zzbv) {
        p.k(zzbv);
        this.zzb = zzbv;
    }

    private final Handler zzi() {
        Handler handler;
        if (zza != null) {
            return zza;
        }
        synchronized (zzcw.class) {
            if (zza == null) {
                zza = new zzga(this.zzb.zza().getMainLooper());
            }
            handler = zza;
        }
        return handler;
    }

    public abstract void zza();

    public final long zzb() {
        if (this.zzd == 0) {
            return 0;
        }
        return Math.abs(this.zzb.zzr().currentTimeMillis() - this.zzd);
    }

    public final void zze(long j10) {
        if (zzh()) {
            long j11 = 0;
            if (j10 < 0) {
                zzf();
                return;
            }
            long abs = j10 - Math.abs(this.zzb.zzr().currentTimeMillis() - this.zzd);
            if (abs >= 0) {
                j11 = abs;
            }
            zzi().removeCallbacks(this.zzc);
            if (!zzi().postDelayed(this.zzc, j11)) {
                this.zzb.zzm().zzK("Failed to adjust delayed post. time", Long.valueOf(j11));
            }
        }
    }

    public final void zzf() {
        this.zzd = 0;
        zzi().removeCallbacks(this.zzc);
    }

    public final void zzg(long j10) {
        zzf();
        if (j10 >= 0) {
            this.zzd = this.zzb.zzr().currentTimeMillis();
            if (!zzi().postDelayed(this.zzc, j10)) {
                this.zzb.zzm().zzK("Failed to schedule delayed post. time", Long.valueOf(j10));
            }
        }
    }

    public final boolean zzh() {
        return this.zzd != 0;
    }
}
