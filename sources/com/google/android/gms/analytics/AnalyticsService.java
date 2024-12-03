package com.google.android.gms.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.gtm.zzfm;
import com.google.android.gms.internal.gtm.zzfn;

public final class AnalyticsService extends Service implements zzfm {

    /* renamed from: a  reason: collision with root package name */
    private zzfn<AnalyticsService> f38168a;

    private final zzfn<AnalyticsService> a() {
        if (this.f38168a == null) {
            this.f38168a = new zzfn<>(this);
        }
        return this.f38168a;
    }

    public boolean callServiceStopSelfResult(int i10) {
        return stopSelfResult(i10);
    }

    @NonNull
    public IBinder onBind(@NonNull Intent intent) {
        a();
        return null;
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

    public final void zza(@NonNull JobParameters jobParameters, boolean z10) {
        throw new UnsupportedOperationException();
    }
}
