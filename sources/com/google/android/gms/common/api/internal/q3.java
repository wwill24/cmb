package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class q3 implements u1 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f38733a;

    /* synthetic */ q3(y yVar, p3 p3Var) {
        this.f38733a = yVar;
    }

    public final void a(Bundle bundle) {
        this.f38733a.f38818n.lock();
        try {
            y.y(this.f38733a, bundle);
            this.f38733a.f38815k = ConnectionResult.f38485e;
            y.z(this.f38733a);
        } finally {
            this.f38733a.f38818n.unlock();
        }
    }

    public final void b(int i10, boolean z10) {
        Lock t10;
        this.f38733a.f38818n.lock();
        try {
            y yVar = this.f38733a;
            if (!yVar.f38817m && yVar.f38816l != null) {
                if (yVar.f38816l.i0()) {
                    this.f38733a.f38817m = true;
                    this.f38733a.f38810e.f(i10);
                    t10 = this.f38733a.f38818n;
                    t10.unlock();
                }
            }
            this.f38733a.f38817m = false;
            y.x(this.f38733a, i10, z10);
            t10 = this.f38733a.f38818n;
            t10.unlock();
        } catch (Throwable th2) {
            this.f38733a.f38818n.unlock();
            throw th2;
        }
    }

    public final void c(@NonNull ConnectionResult connectionResult) {
        this.f38733a.f38818n.lock();
        try {
            this.f38733a.f38815k = connectionResult;
            y.z(this.f38733a);
        } finally {
            this.f38733a.f38818n.unlock();
        }
    }
}
