package io.sentry;

import java.io.File;
import java.util.concurrent.Callable;

public final /* synthetic */ class b3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ File f31144a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f31145b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ z1 f31146c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ l0 f31147d;

    public /* synthetic */ b3(File file, long j10, z1 z1Var, l0 l0Var) {
        this.f31144a = file;
        this.f31145b = j10;
        this.f31146c = z1Var;
        this.f31147d = l0Var;
    }

    public final Object call() {
        return n3.H(this.f31144a, this.f31145b, this.f31146c, this.f31147d);
    }
}
