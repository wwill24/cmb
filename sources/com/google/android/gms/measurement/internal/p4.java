package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;
import java.lang.Thread;

final class p4 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final String f40132a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ s4 f40133b;

    public p4(s4 s4Var, String str) {
        this.f40133b = s4Var;
        p.k(str);
        this.f40132a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th2) {
        this.f40133b.f40059a.d().r().b(this.f40132a, th2);
    }
}
