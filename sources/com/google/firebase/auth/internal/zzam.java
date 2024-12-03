package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzc;
import com.google.firebase.FirebaseApp;
import he.a;
import me.i;

public final class zzam {
    /* access modifiers changed from: private */
    public static final a zzg = new a("TokenRefresher", "FirebaseAuth:");
    volatile long zza;
    volatile long zzb;
    final long zzc = 300000;
    final HandlerThread zzd;
    final Handler zze;
    final Runnable zzf;
    private final FirebaseApp zzh;

    public zzam(FirebaseApp firebaseApp) {
        zzg.g("Initializing TokenRefresher", new Object[0]);
        FirebaseApp firebaseApp2 = (FirebaseApp) p.k(firebaseApp);
        this.zzh = firebaseApp2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.zzd = handlerThread;
        handlerThread.start();
        this.zze = new zzc(handlerThread.getLooper());
        this.zzf = new zzal(this, firebaseApp2.getName());
    }

    public final void zzb() {
        this.zze.removeCallbacks(this.zzf);
    }

    public final void zzc() {
        a aVar = zzg;
        long j10 = this.zza - this.zzc;
        aVar.g("Scheduling refresh for " + j10, new Object[0]);
        zzb();
        this.zzb = Math.max((this.zza - i.c().currentTimeMillis()) - this.zzc, 0) / 1000;
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }

    /* access modifiers changed from: package-private */
    public final void zzd() {
        long j10;
        int i10 = (int) this.zzb;
        if (i10 == 30 || i10 == 60 || i10 == 120 || i10 == 240 || i10 == 480) {
            long j11 = this.zzb;
            j10 = j11 + j11;
        } else if (i10 != 960) {
            j10 = 30;
        } else {
            j10 = 960;
        }
        this.zzb = j10;
        this.zza = i.c().currentTimeMillis() + (this.zzb * 1000);
        a aVar = zzg;
        long j12 = this.zza;
        aVar.g("Scheduling refresh for " + j12, new Object[0]);
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }
}
