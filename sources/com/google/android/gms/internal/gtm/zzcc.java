package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import java.util.Collections;
import le.b;
import rd.u;

public final class zzcc extends zzbs {
    /* access modifiers changed from: private */
    public final zzcb zza = new zzcb(this);
    private final zzcw zzb;
    private final zzfo zzc;
    private zzey zzd;

    protected zzcc(zzbv zzbv) {
        super(zzbv);
        this.zzc = new zzfo(zzbv.zzr());
        this.zzb = new zzby(this, zzbv);
    }

    static /* bridge */ /* synthetic */ void zzb(zzcc zzcc, ComponentName componentName) {
        u.h();
        if (zzcc.zzd != null) {
            zzcc.zzd = null;
            zzcc.zzP("Disconnected from device AnalyticsService", componentName);
            zzcc.zzs().zzk();
        }
    }

    static /* bridge */ /* synthetic */ void zzi(zzcc zzcc, zzey zzey) {
        u.h();
        zzcc.zzd = zzey;
        zzcc.zzj();
        zzcc.zzs().zzj();
    }

    private final void zzj() {
        this.zzc.zzb();
        zzcw zzcw = this.zzb;
        zzw();
        zzcw.zzg(zzeu.zzK.zzb().longValue());
    }

    public final void zzc() {
        u.h();
        zzW();
        try {
            b.b().c(zzo(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        if (this.zzd != null) {
            this.zzd = null;
            zzs().zzk();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
    }

    public final boolean zze() {
        u.h();
        zzW();
        zzey zzey = this.zzd;
        if (zzey == null) {
            return false;
        }
        try {
            zzey.zze();
            zzj();
            return true;
        } catch (RemoteException unused) {
            zzO("Failed to clear hits from AnalyticsService");
            return false;
        }
    }

    public final boolean zzf() {
        u.h();
        zzW();
        if (this.zzd != null) {
            return true;
        }
        zzey zza2 = this.zza.zza();
        if (zza2 == null) {
            return false;
        }
        this.zzd = zza2;
        zzj();
        return true;
    }

    public final boolean zzg() {
        u.h();
        zzW();
        if (this.zzd != null) {
            return true;
        }
        return false;
    }

    public final boolean zzh(zzex zzex) {
        String str;
        p.k(zzex);
        u.h();
        zzW();
        zzey zzey = this.zzd;
        if (zzey == null) {
            return false;
        }
        if (zzex.zzh()) {
            zzw();
            str = zzct.zzi();
        } else {
            zzw();
            str = zzct.zzk();
        }
        try {
            zzey.zzf(zzex.zzg(), zzex.zzd(), str, Collections.emptyList());
            zzj();
            return true;
        } catch (RemoteException unused) {
            zzO("Failed to send hits to AnalyticsService");
            return false;
        }
    }
}
