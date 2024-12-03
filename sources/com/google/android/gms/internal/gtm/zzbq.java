package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.p;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import rd.u;

public final class zzbq extends zzbs {
    /* access modifiers changed from: private */
    public final zzck zza;

    public zzbq(zzbv zzbv, zzbw zzbw) {
        super(zzbv);
        p.k(zzbw);
        this.zza = new zzck(zzbv, zzbw);
    }

    public final long zza(zzbx zzbx) {
        zzW();
        p.k(zzbx);
        u.h();
        long zzb = this.zza.zzb(zzbx, true);
        if (zzb == 0) {
            this.zza.zzk(zzbx);
        }
        return zzb;
    }

    public final void zzc() {
        zzW();
        Context zzo = zzo();
        if (!zzfi.zza(zzo) || !zzfn.zzh(zzo)) {
            zze((zzcz) null);
            return;
        }
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(zzo, "com.google.android.gms.analytics.AnalyticsService"));
        zzo.startService(intent);
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        this.zza.zzX();
    }

    public final void zze(zzcz zzcz) {
        zzW();
        zzq().i(new zzbo(this, zzcz));
    }

    public final void zzf(String str, Runnable runnable) {
        p.h(str, "campaign param can't be empty");
        zzq().i(new zzbk(this, str, runnable));
    }

    public final void zzg() {
        zzW();
        zzE();
        zzq().i(new zzbn(this));
    }

    public final void zzh(zzex zzex) {
        p.k(zzex);
        zzW();
        zzG("Hit delivery requested", zzex);
        zzq().i(new zzbm(this, zzex));
    }

    /* access modifiers changed from: package-private */
    public final void zzi() {
        u.h();
        this.zza.zzl();
    }

    /* access modifiers changed from: package-private */
    public final void zzj() {
        u.h();
        this.zza.zzm();
    }

    public final void zzk() {
        zzW();
        u.h();
        zzck zzck = this.zza;
        u.h();
        zzck.zzW();
        zzck.zzO("Service disconnected");
    }

    public final void zzl(int i10) {
        zzW();
        zzG("setLocalDispatchPeriod (sec)", Integer.valueOf(i10));
        zzq().i(new zzbl(this, i10));
    }

    public final void zzm() {
        this.zza.zzaa();
    }

    public final boolean zzn() {
        zzW();
        try {
            zzq().g(new zzbp(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e10) {
            zzS("syncDispatchLocalHits interrupted", e10);
            return false;
        } catch (ExecutionException e11) {
            zzK("syncDispatchLocalHits failed", e11);
            return false;
        } catch (TimeoutException e12) {
            zzS("syncDispatchLocalHits timed out", e12);
            return false;
        }
    }
}
