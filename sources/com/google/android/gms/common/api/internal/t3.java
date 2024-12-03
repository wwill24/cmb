package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class t3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f38744a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f38745b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ u3 f38746c;

    t3(u3 u3Var, LifecycleCallback lifecycleCallback, String str) {
        this.f38746c = u3Var;
        this.f38744a = lifecycleCallback;
        this.f38745b = str;
    }

    public final void run() {
        Bundle bundle;
        u3 u3Var = this.f38746c;
        if (u3Var.f38779b > 0) {
            LifecycleCallback lifecycleCallback = this.f38744a;
            if (u3Var.f38780c != null) {
                bundle = u3Var.f38780c.getBundle(this.f38745b);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (this.f38746c.f38779b >= 2) {
            this.f38744a.onStart();
        }
        if (this.f38746c.f38779b >= 3) {
            this.f38744a.onResume();
        }
        if (this.f38746c.f38779b >= 4) {
            this.f38744a.onStop();
        }
        if (this.f38746c.f38779b >= 5) {
            this.f38744a.onDestroy();
        }
    }
}
