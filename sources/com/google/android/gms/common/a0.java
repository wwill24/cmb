package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class a0 extends c0 {

    /* renamed from: f  reason: collision with root package name */
    private final Callable f38495f;

    /* synthetic */ a0(Callable callable, z zVar) {
        super(false, 1, 5, (String) null, (Throwable) null, (b0) null);
        this.f38495f = callable;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        try {
            return (String) this.f38495f.call();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
