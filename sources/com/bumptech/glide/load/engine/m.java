package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import f4.j;
import i3.b;
import l3.c;

class m<Z> implements c<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f9401a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9402b;

    /* renamed from: c  reason: collision with root package name */
    private final c<Z> f9403c;

    /* renamed from: d  reason: collision with root package name */
    private final a f9404d;

    /* renamed from: e  reason: collision with root package name */
    private final b f9405e;

    /* renamed from: f  reason: collision with root package name */
    private int f9406f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9407g;

    interface a {
        void d(b bVar, m<?> mVar);
    }

    m(c<Z> cVar, boolean z10, boolean z11, b bVar, a aVar) {
        this.f9403c = (c) j.d(cVar);
        this.f9401a = z10;
        this.f9402b = z11;
        this.f9405e = bVar;
        this.f9404d = (a) j.d(aVar);
    }

    public synchronized void a() {
        if (this.f9406f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f9407g) {
            this.f9407g = true;
            if (this.f9402b) {
                this.f9403c.a();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    @NonNull
    public Class<Z> b() {
        return this.f9403c.b();
    }

    /* access modifiers changed from: package-private */
    public synchronized void c() {
        if (!this.f9407g) {
            this.f9406f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* access modifiers changed from: package-private */
    public c<Z> d() {
        return this.f9403c;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f9401a;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        boolean z10;
        synchronized (this) {
            int i10 = this.f9406f;
            if (i10 > 0) {
                z10 = true;
                int i11 = i10 - 1;
                this.f9406f = i11;
                if (i11 != 0) {
                    z10 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z10) {
            this.f9404d.d(this.f9405e, this);
        }
    }

    @NonNull
    public Z get() {
        return this.f9403c.get();
    }

    public int getSize() {
        return this.f9403c.getSize();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f9401a + ", listener=" + this.f9404d + ", key=" + this.f9405e + ", acquired=" + this.f9406f + ", isRecycled=" + this.f9407g + ", resource=" + this.f9403c + '}';
    }
}
