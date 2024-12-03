package io.sentry;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

final class m1 implements k0 {

    /* renamed from: a  reason: collision with root package name */
    private static final m1 f31334a = new m1();

    private m1() {
    }

    public static k0 e() {
        return f31334a;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object f() throws Exception {
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object g() throws Exception {
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object h() throws Exception {
        return null;
    }

    public void a(long j10) {
    }

    public Future<?> schedule(Runnable runnable, long j10) {
        return new FutureTask(new k1());
    }

    public Future<?> submit(Runnable runnable) {
        return new FutureTask(new j1());
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return new FutureTask(new l1());
    }
}
