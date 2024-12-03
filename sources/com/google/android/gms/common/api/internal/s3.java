package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class s3 implements u1 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f38741a;

    /* synthetic */ s3(y yVar, r3 r3Var) {
        this.f38741a = yVar;
    }

    public final void a(Bundle bundle) {
        this.f38741a.f38818n.lock();
        try {
            this.f38741a.f38816l = ConnectionResult.f38485e;
            y.z(this.f38741a);
        } finally {
            this.f38741a.f38818n.unlock();
        }
    }

    public final void b(int i10, boolean z10) {
        Lock t10;
        this.f38741a.f38818n.lock();
        try {
            y yVar = this.f38741a;
            if (yVar.f38817m) {
                yVar.f38817m = false;
                y.x(this.f38741a, i10, z10);
                t10 = this.f38741a.f38818n;
            } else {
                yVar.f38817m = true;
                this.f38741a.f38809d.f(i10);
                t10 = this.f38741a.f38818n;
            }
            t10.unlock();
        } catch (Throwable th2) {
            this.f38741a.f38818n.unlock();
            throw th2;
        }
    }

    public final void c(@NonNull ConnectionResult connectionResult) {
        this.f38741a.f38818n.lock();
        try {
            this.f38741a.f38816l = connectionResult;
            y.z(this.f38741a);
        } finally {
            this.f38741a.f38818n.unlock();
        }
    }
}
