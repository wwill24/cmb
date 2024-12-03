package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import c3.f;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class k0<T> {

    /* renamed from: e  reason: collision with root package name */
    public static Executor f8600e = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    private final Set<e0<T>> f8601a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<e0<Throwable>> f8602b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f8603c;

    /* renamed from: d  reason: collision with root package name */
    private volatile i0<T> f8604d;

    private class a extends FutureTask<i0<T>> {
        a(Callable<i0<T>> callable) {
            super(callable);
        }

        /* access modifiers changed from: protected */
        public void done() {
            if (!isCancelled()) {
                try {
                    k0.this.k((i0) get());
                } catch (InterruptedException | ExecutionException e10) {
                    k0.this.k(new i0(e10));
                }
            }
        }
    }

    public k0(Callable<i0<T>> callable) {
        this(callable, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        i0<T> i0Var = this.f8604d;
        if (i0Var != null) {
            if (i0Var.b() != null) {
                h(i0Var.b());
            } else {
                f(i0Var.a());
            }
        }
    }

    private synchronized void f(Throwable th2) {
        ArrayList<e0> arrayList = new ArrayList<>(this.f8602b);
        if (arrayList.isEmpty()) {
            f.d("Lottie encountered an error but no failure listener was added:", th2);
            return;
        }
        for (e0 onResult : arrayList) {
            onResult.onResult(th2);
        }
    }

    private void g() {
        this.f8603c.post(new j0(this));
    }

    private synchronized void h(T t10) {
        for (e0 onResult : new ArrayList(this.f8601a)) {
            onResult.onResult(t10);
        }
    }

    /* access modifiers changed from: private */
    public void k(i0<T> i0Var) {
        if (this.f8604d == null) {
            this.f8604d = i0Var;
            g();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized k0<T> c(e0<Throwable> e0Var) {
        i0<T> i0Var = this.f8604d;
        if (!(i0Var == null || i0Var.a() == null)) {
            e0Var.onResult(i0Var.a());
        }
        this.f8602b.add(e0Var);
        return this;
    }

    public synchronized k0<T> d(e0<T> e0Var) {
        i0<T> i0Var = this.f8604d;
        if (!(i0Var == null || i0Var.b() == null)) {
            e0Var.onResult(i0Var.b());
        }
        this.f8601a.add(e0Var);
        return this;
    }

    public synchronized k0<T> i(e0<Throwable> e0Var) {
        this.f8602b.remove(e0Var);
        return this;
    }

    public synchronized k0<T> j(e0<T> e0Var) {
        this.f8601a.remove(e0Var);
        return this;
    }

    k0(Callable<i0<T>> callable, boolean z10) {
        this.f8601a = new LinkedHashSet(1);
        this.f8602b = new LinkedHashSet(1);
        this.f8603c = new Handler(Looper.getMainLooper());
        this.f8604d = null;
        if (z10) {
            try {
                k(callable.call());
            } catch (Throwable th2) {
                k(new i0(th2));
            }
        } else {
            f8600e.execute(new a(callable));
        }
    }
}
