package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.internal.n8;
import k1.a;
import we.x;

public final class AppMeasurementService extends Service implements x {

    /* renamed from: a  reason: collision with root package name */
    private n8 f39619a;

    private final n8 d() {
        if (this.f39619a == null) {
            this.f39619a = new n8(this);
        }
        return this.f39619a;
    }

    public final boolean a(int i10) {
        return stopSelfResult(i10);
    }

    public final void b(@NonNull Intent intent) {
        a.b(intent);
    }

    public final void c(@NonNull JobParameters jobParameters, boolean z10) {
        throw new UnsupportedOperationException();
    }

    public IBinder onBind(@NonNull Intent intent) {
        return d().b(intent);
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

    public int onStartCommand(@NonNull Intent intent, int i10, int i11) {
        d().a(intent, i10, i11);
        return 2;
    }

    public boolean onUnbind(@NonNull Intent intent) {
        d().j(intent);
        return true;
    }
}
