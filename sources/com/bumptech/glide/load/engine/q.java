package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.e;
import i3.b;
import j3.d;
import java.io.File;
import java.util.List;
import p3.n;

class q implements e, d.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final e.a f9419a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f9420b;

    /* renamed from: c  reason: collision with root package name */
    private int f9421c;

    /* renamed from: d  reason: collision with root package name */
    private int f9422d = -1;

    /* renamed from: e  reason: collision with root package name */
    private b f9423e;

    /* renamed from: f  reason: collision with root package name */
    private List<n<File, ?>> f9424f;

    /* renamed from: g  reason: collision with root package name */
    private int f9425g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f9426h;

    /* renamed from: j  reason: collision with root package name */
    private File f9427j;

    /* renamed from: k  reason: collision with root package name */
    private r f9428k;

    q(f<?> fVar, e.a aVar) {
        this.f9420b = fVar;
        this.f9419a = aVar;
    }

    private boolean a() {
        return this.f9425g < this.f9424f.size();
    }

    public void c(@NonNull Exception exc) {
        this.f9419a.a(this.f9428k, exc, this.f9426h.f16958c, DataSource.RESOURCE_DISK_CACHE);
    }

    public void cancel() {
        n.a<?> aVar = this.f9426h;
        if (aVar != null) {
            aVar.f16958c.cancel();
        }
    }

    public boolean d() {
        List<b> c10 = this.f9420b.c();
        boolean z10 = false;
        if (c10.isEmpty()) {
            return false;
        }
        List<Class<?>> m10 = this.f9420b.m();
        if (!m10.isEmpty()) {
            while (true) {
                if (this.f9424f == null || !a()) {
                    int i10 = this.f9422d + 1;
                    this.f9422d = i10;
                    if (i10 >= m10.size()) {
                        int i11 = this.f9421c + 1;
                        this.f9421c = i11;
                        if (i11 >= c10.size()) {
                            return false;
                        }
                        this.f9422d = 0;
                    }
                    b bVar = c10.get(this.f9421c);
                    Class cls = m10.get(this.f9422d);
                    this.f9428k = new r(this.f9420b.b(), bVar, this.f9420b.o(), this.f9420b.s(), this.f9420b.f(), this.f9420b.r(cls), cls, this.f9420b.k());
                    File a10 = this.f9420b.d().a(this.f9428k);
                    this.f9427j = a10;
                    if (a10 != null) {
                        this.f9423e = bVar;
                        this.f9424f = this.f9420b.j(a10);
                        this.f9425g = 0;
                    }
                } else {
                    this.f9426h = null;
                    while (!z10 && a()) {
                        List<n<File, ?>> list = this.f9424f;
                        int i12 = this.f9425g;
                        this.f9425g = i12 + 1;
                        this.f9426h = list.get(i12).b(this.f9427j, this.f9420b.s(), this.f9420b.f(), this.f9420b.k());
                        if (this.f9426h != null && this.f9420b.t(this.f9426h.f16958c.a())) {
                            this.f9426h.f16958c.d(this.f9420b.l(), this);
                            z10 = true;
                        }
                    }
                    return z10;
                }
            }
        } else if (File.class.equals(this.f9420b.q())) {
            return false;
        } else {
            throw new IllegalStateException("Failed to find any load path from " + this.f9420b.i() + " to " + this.f9420b.q());
        }
    }

    public void f(Object obj) {
        this.f9419a.b(this.f9423e, obj, this.f9426h.f16958c, DataSource.RESOURCE_DISK_CACHE, this.f9428k);
    }
}
