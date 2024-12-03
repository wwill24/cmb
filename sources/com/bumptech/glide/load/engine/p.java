package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.e;
import f4.j;
import g4.a;
import l3.c;

final class p<Z> implements c<Z>, a.f {

    /* renamed from: e  reason: collision with root package name */
    private static final e<p<?>> f9414e = g4.a.d(20, new a());

    /* renamed from: a  reason: collision with root package name */
    private final g4.c f9415a = g4.c.a();

    /* renamed from: b  reason: collision with root package name */
    private c<Z> f9416b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9417c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9418d;

    class a implements a.d<p<?>> {
        a() {
        }

        /* renamed from: a */
        public p<?> create() {
            return new p<>();
        }
    }

    p() {
    }

    private void c(c<Z> cVar) {
        this.f9418d = false;
        this.f9417c = true;
        this.f9416b = cVar;
    }

    @NonNull
    static <Z> p<Z> e(c<Z> cVar) {
        p<Z> pVar = (p) j.d(f9414e.acquire());
        pVar.c(cVar);
        return pVar;
    }

    private void f() {
        this.f9416b = null;
        f9414e.a(this);
    }

    public synchronized void a() {
        this.f9415a.c();
        this.f9418d = true;
        if (!this.f9417c) {
            this.f9416b.a();
            f();
        }
    }

    @NonNull
    public Class<Z> b() {
        return this.f9416b.b();
    }

    @NonNull
    public g4.c d() {
        return this.f9415a;
    }

    /* access modifiers changed from: package-private */
    public synchronized void g() {
        this.f9415a.c();
        if (this.f9417c) {
            this.f9417c = false;
            if (this.f9418d) {
                a();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @NonNull
    public Z get() {
        return this.f9416b.get();
    }

    public int getSize() {
        return this.f9416b.getSize();
    }
}
