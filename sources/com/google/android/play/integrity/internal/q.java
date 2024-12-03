package com.google.android.play.integrity.internal;

import android.os.IBinder;

public final /* synthetic */ class q implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f20521a;

    public /* synthetic */ q(z zVar) {
        this.f20521a = zVar;
    }

    public final void binderDied() {
        z.h(this.f20521a);
    }
}
