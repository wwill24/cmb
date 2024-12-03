package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class f1 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f38600a;

    public /* synthetic */ f1(Handler handler) {
        this.f38600a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f38600a.post(runnable);
    }
}
