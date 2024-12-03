package com.google.android.gms.common.api.internal;

final class j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k1 f38646a;

    j1(k1 k1Var) {
        this.f38646a = k1Var;
    }

    public final void run() {
        l1 l1Var = this.f38646a.f38655a;
        l1Var.f38660b.disconnect(l1Var.f38660b.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
