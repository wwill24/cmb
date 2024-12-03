package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class v3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f38790a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f38791b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ w3 f38792c;

    v3(w3 w3Var, LifecycleCallback lifecycleCallback, String str) {
        this.f38792c = w3Var;
        this.f38790a = lifecycleCallback;
        this.f38791b = str;
    }

    public final void run() {
        Bundle bundle;
        w3 w3Var = this.f38792c;
        if (w3Var.f38799b > 0) {
            LifecycleCallback lifecycleCallback = this.f38790a;
            if (w3Var.f38800c != null) {
                bundle = w3Var.f38800c.getBundle(this.f38791b);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (this.f38792c.f38799b >= 2) {
            this.f38790a.onStart();
        }
        if (this.f38792c.f38799b >= 3) {
            this.f38790a.onResume();
        }
        if (this.f38792c.f38799b >= 4) {
            this.f38790a.onStop();
        }
        if (this.f38792c.f38799b >= 5) {
            this.f38790a.onDestroy();
        }
    }
}
