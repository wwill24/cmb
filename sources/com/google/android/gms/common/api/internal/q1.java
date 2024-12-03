package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.j;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class q1 extends e0 {
    @NotOnlyInitialized

    /* renamed from: c  reason: collision with root package name */
    private final c f38732c;

    public q1(c cVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f38732c = cVar;
    }

    public final <A extends a.b, R extends j, T extends d<R, A>> T g(@NonNull T t10) {
        return this.f38732c.doRead(t10);
    }

    public final <A extends a.b, T extends d<? extends j, A>> T h(@NonNull T t10) {
        return this.f38732c.doWrite(t10);
    }

    public final Context k() {
        return this.f38732c.getApplicationContext();
    }

    public final Looper l() {
        return this.f38732c.getLooper();
    }

    public final void s(u2 u2Var) {
    }

    public final void t(u2 u2Var) {
    }
}
