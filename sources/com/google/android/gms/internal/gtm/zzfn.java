package com.google.android.gms.internal.gtm;

import af.a;
import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.gtm.zzfm;

public final class zzfn<T extends Context & zzfm> {
    private static Boolean zza;
    /* access modifiers changed from: private */
    public final Handler zzb = new zzga();
    private final T zzc;

    public zzfn(T t10) {
        p.k(t10);
        this.zzc = t10;
    }

    public static boolean zzh(Context context) {
        p.k(context);
        Boolean bool = zza;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z10 = false;
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                z10 = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        zza = Boolean.valueOf(z10);
        return z10;
    }

    public final int zza(Intent intent, int i10, int i11) {
        try {
            synchronized (zzfi.zza) {
                a aVar = zzfi.zzb;
                if (aVar != null && aVar.b()) {
                    aVar.c();
                }
            }
        } catch (SecurityException unused) {
        }
        zzbv zzg = zzbv.zzg(this.zzc);
        zzfb zzm = zzg.zzm();
        if (intent == null) {
            zzm.zzR("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzg.zzj();
        zzm.zzQ("Local AnalyticsService called. startId, action", Integer.valueOf(i11), action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            zzg(new zzfj(this, i11, zzm));
        }
        return 2;
    }

    public final /* synthetic */ void zzc(int i10, zzfb zzfb) {
        if (((zzfm) this.zzc).callServiceStopSelfResult(i10)) {
            zzfb.zzO("Local AnalyticsService processed last dispatch request");
        }
    }

    public final /* synthetic */ void zzd(zzfb zzfb, JobParameters jobParameters) {
        zzfb.zzO("AnalyticsJobService processed last dispatch request");
        ((zzfm) this.zzc).zza(jobParameters, false);
    }

    public final void zze() {
        zzbv zzg = zzbv.zzg(this.zzc);
        zzfb zzm = zzg.zzm();
        zzg.zzj();
        zzm.zzO("Local AnalyticsService is starting up");
    }

    public final void zzf() {
        zzbv zzg = zzbv.zzg(this.zzc);
        zzfb zzm = zzg.zzm();
        zzg.zzj();
        zzm.zzO("Local AnalyticsService is shutting down");
    }

    public final void zzg(Runnable runnable) {
        zzbv.zzg(this.zzc).zzf().zze(new zzfl(this, runnable));
    }

    @TargetApi(24)
    public final boolean zzi(JobParameters jobParameters) {
        zzbv zzg = zzbv.zzg(this.zzc);
        zzfb zzm = zzg.zzm();
        String string = jobParameters.getExtras().getString("action");
        zzg.zzj();
        zzm.zzP("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        zzg(new zzfk(this, zzm, jobParameters));
        return true;
    }
}
