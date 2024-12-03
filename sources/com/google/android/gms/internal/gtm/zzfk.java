package com.google.android.gms.internal.gtm;

import android.app.job.JobParameters;

public final /* synthetic */ class zzfk implements Runnable {
    public final /* synthetic */ zzfn zza;
    public final /* synthetic */ zzfb zzb;
    public final /* synthetic */ JobParameters zzc;

    public /* synthetic */ zzfk(zzfn zzfn, zzfb zzfb, JobParameters jobParameters) {
        this.zza = zzfn;
        this.zzb = zzfb;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc);
    }
}
