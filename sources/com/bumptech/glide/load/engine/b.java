package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.e;
import j3.d;
import java.io.File;
import java.util.List;
import p3.n;

class b implements e, d.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final List<i3.b> f9302a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f9303b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a f9304c;

    /* renamed from: d  reason: collision with root package name */
    private int f9305d;

    /* renamed from: e  reason: collision with root package name */
    private i3.b f9306e;

    /* renamed from: f  reason: collision with root package name */
    private List<n<File, ?>> f9307f;

    /* renamed from: g  reason: collision with root package name */
    private int f9308g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f9309h;

    /* renamed from: j  reason: collision with root package name */
    private File f9310j;

    b(f<?> fVar, e.a aVar) {
        this(fVar.c(), fVar, aVar);
    }

    private boolean a() {
        return this.f9308g < this.f9307f.size();
    }

    public void c(@NonNull Exception exc) {
        this.f9304c.a(this.f9306e, exc, this.f9309h.f16958c, DataSource.DATA_DISK_CACHE);
    }

    public void cancel() {
        n.a<?> aVar = this.f9309h;
        if (aVar != null) {
            aVar.f16958c.cancel();
        }
    }

    public boolean d() {
        while (true) {
            boolean z10 = false;
            if (this.f9307f == null || !a()) {
                int i10 = this.f9305d + 1;
                this.f9305d = i10;
                if (i10 >= this.f9302a.size()) {
                    return false;
                }
                i3.b bVar = this.f9302a.get(this.f9305d);
                File a10 = this.f9303b.d().a(new c(bVar, this.f9303b.o()));
                this.f9310j = a10;
                if (a10 != null) {
                    this.f9306e = bVar;
                    this.f9307f = this.f9303b.j(a10);
                    this.f9308g = 0;
                }
            } else {
                this.f9309h = null;
                while (!z10 && a()) {
                    List<n<File, ?>> list = this.f9307f;
                    int i11 = this.f9308g;
                    this.f9308g = i11 + 1;
                    this.f9309h = list.get(i11).b(this.f9310j, this.f9303b.s(), this.f9303b.f(), this.f9303b.k());
                    if (this.f9309h != null && this.f9303b.t(this.f9309h.f16958c.a())) {
                        this.f9309h.f16958c.d(this.f9303b.l(), this);
                        z10 = true;
                    }
                }
                return z10;
            }
        }
    }

    public void f(Object obj) {
        this.f9304c.b(this.f9306e, obj, this.f9309h.f16958c, DataSource.DATA_DISK_CACHE, this.f9306e);
    }

    b(List<i3.b> list, f<?> fVar, e.a aVar) {
        this.f9305d = -1;
        this.f9302a = list;
        this.f9303b = fVar;
        this.f9304c = aVar;
    }
}
