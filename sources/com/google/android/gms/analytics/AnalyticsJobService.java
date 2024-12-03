package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.gtm.zzfm;
import com.google.android.gms.internal.gtm.zzfn;

@TargetApi(24)
public final class AnalyticsJobService extends JobService implements zzfm {

    /* renamed from: a  reason: collision with root package name */
    private zzfn<AnalyticsJobService> f38166a;

    private final zzfn<AnalyticsJobService> a() {
        if (this.f38166a == null) {
            this.f38166a = new zzfn<>(this);
        }
        return this.f38166a;
    }

    public boolean callServiceStopSelfResult(int i10) {
        return stopSelfResult(i10);
    }

    public final void onCreate() {
        super.onCreate();
        a().zze();
    }

    public final void onDestroy() {
        a().zzf();
        super.onDestroy();
    }

    public final int onStartCommand(@NonNull Intent intent, int i10, int i11) {
        a().zza(intent, i10, i11);
        return 2;
    }

    public boolean onStartJob(@NonNull JobParameters jobParameters) {
        a().zzi(jobParameters);
        return true;
    }

    public boolean onStopJob(@NonNull JobParameters jobParameters) {
        return false;
    }

    @TargetApi(24)
    public final void zza(@NonNull JobParameters jobParameters, boolean z10) {
        jobFinished(jobParameters, false);
    }
}
