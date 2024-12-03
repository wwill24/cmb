package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.internal.p003firebaseauthapi.zzahb;
import com.google.firebase.FirebaseApp;

public final class zzbv {
    private volatile int zza = 0;
    /* access modifiers changed from: private */
    public final zzam zzb;
    /* access modifiers changed from: private */
    public volatile boolean zzc = false;

    public zzbv(FirebaseApp firebaseApp) {
        Context applicationContext = firebaseApp.getApplicationContext();
        zzam zzam = new zzam(firebaseApp);
        this.zzb = zzam;
        c.c((Application) applicationContext.getApplicationContext());
        c.b().a(new zzbu(this));
    }

    /* access modifiers changed from: private */
    public final boolean zzg() {
        return this.zza > 0 && !this.zzc;
    }

    public final void zzc() {
        this.zzb.zzb();
    }

    public final void zzd(int i10) {
        if (i10 > 0 && this.zza == 0) {
            this.zza = i10;
            if (zzg()) {
                this.zzb.zzc();
            }
        } else if (i10 == 0 && this.zza != 0) {
            this.zzb.zzb();
        }
        this.zza = i10;
    }

    public final void zze(zzahb zzahb) {
        if (zzahb != null) {
            long zzb2 = zzahb.zzb();
            if (zzb2 <= 0) {
                zzb2 = DateUtils.SEC_IN_HOUR;
            }
            zzam zzam = this.zzb;
            zzam.zza = zzahb.zzc() + (zzb2 * 1000);
            zzam.zzb = -1;
            if (zzg()) {
                this.zzb.zzc();
            }
        }
    }
}
