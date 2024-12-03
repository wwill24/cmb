package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.internal.n8;
import we.x;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements x {

    /* renamed from: a  reason: collision with root package name */
    private n8 f39617a;

    private final n8 d() {
        if (this.f39617a == null) {
            this.f39617a = new n8(this);
        }
        return this.f39617a;
    }

    public final boolean a(int i10) {
        throw new UnsupportedOperationException();
    }

    public final void b(@NonNull Intent intent) {
    }

    @TargetApi(24)
    public final void c(@NonNull JobParameters jobParameters, boolean z10) {
        jobFinished(jobParameters, false);
    }

    public void onCreate() {
        super.onCreate();
        d().e();
    }

    public void onDestroy() {
        d().f();
        super.onDestroy();
    }

    public void onRebind(@NonNull Intent intent) {
        d().g(intent);
    }

    public boolean onStartJob(@NonNull JobParameters jobParameters) {
        d().i(jobParameters);
        return true;
    }

    public boolean onStopJob(@NonNull JobParameters jobParameters) {
        return false;
    }

    public boolean onUnbind(@NonNull Intent intent) {
        d().j(intent);
        return true;
    }
}
