package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.e;
import f4.f;
import i3.b;
import j3.d;
import java.util.Collections;
import java.util.List;
import p3.n;

class t implements e, e.a {

    /* renamed from: a  reason: collision with root package name */
    private final f<?> f9440a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a f9441b;

    /* renamed from: c  reason: collision with root package name */
    private int f9442c;

    /* renamed from: d  reason: collision with root package name */
    private b f9443d;

    /* renamed from: e  reason: collision with root package name */
    private Object f9444e;

    /* renamed from: f  reason: collision with root package name */
    private volatile n.a<?> f9445f;

    /* renamed from: g  reason: collision with root package name */
    private c f9446g;

    class a implements d.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n.a f9447a;

        a(n.a aVar) {
            this.f9447a = aVar;
        }

        public void c(@NonNull Exception exc) {
            if (t.this.g(this.f9447a)) {
                t.this.i(this.f9447a, exc);
            }
        }

        public void f(Object obj) {
            if (t.this.g(this.f9447a)) {
                t.this.h(this.f9447a, obj);
            }
        }
    }

    t(f<?> fVar, e.a aVar) {
        this.f9440a = fVar;
        this.f9441b = aVar;
    }

    /* JADX INFO: finally extract failed */
    private void e(Object obj) {
        long b10 = f.b();
        try {
            i3.a<X> p10 = this.f9440a.p(obj);
            d dVar = new d(p10, obj, this.f9440a.k());
            this.f9446g = new c(this.f9445f.f16956a, this.f9440a.o());
            this.f9440a.d().b(this.f9446g, dVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Finished encoding source to cache, key: ");
                sb2.append(this.f9446g);
                sb2.append(", data: ");
                sb2.append(obj);
                sb2.append(", encoder: ");
                sb2.append(p10);
                sb2.append(", duration: ");
                sb2.append(f.a(b10));
            }
            this.f9445f.f16958c.b();
            this.f9443d = new b(Collections.singletonList(this.f9445f.f16956a), this.f9440a, this);
        } catch (Throwable th2) {
            this.f9445f.f16958c.b();
            throw th2;
        }
    }

    private boolean f() {
        return this.f9442c < this.f9440a.g().size();
    }

    private void j(n.a<?> aVar) {
        this.f9445f.f16958c.d(this.f9440a.l(), new a(aVar));
    }

    public void a(b bVar, Exception exc, d<?> dVar, DataSource dataSource) {
        this.f9441b.a(bVar, exc, dVar, this.f9445f.f16958c.e());
    }

    public void b(b bVar, Object obj, d<?> dVar, DataSource dataSource, b bVar2) {
        this.f9441b.b(bVar, obj, dVar, this.f9445f.f16958c.e(), bVar);
    }

    public void c() {
        throw new UnsupportedOperationException();
    }

    public void cancel() {
        n.a<?> aVar = this.f9445f;
        if (aVar != null) {
            aVar.f16958c.cancel();
        }
    }

    public boolean d() {
        Object obj = this.f9444e;
        if (obj != null) {
            this.f9444e = null;
            e(obj);
        }
        b bVar = this.f9443d;
        if (bVar != null && bVar.d()) {
            return true;
        }
        this.f9443d = null;
        this.f9445f = null;
        boolean z10 = false;
        while (!z10 && f()) {
            List<n.a<?>> g10 = this.f9440a.g();
            int i10 = this.f9442c;
            this.f9442c = i10 + 1;
            this.f9445f = g10.get(i10);
            if (this.f9445f != null && (this.f9440a.e().c(this.f9445f.f16958c.e()) || this.f9440a.t(this.f9445f.f16958c.a()))) {
                j(this.f9445f);
                z10 = true;
            }
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public boolean g(n.a<?> aVar) {
        n.a<?> aVar2 = this.f9445f;
        return aVar2 != null && aVar2 == aVar;
    }

    /* access modifiers changed from: package-private */
    public void h(n.a<?> aVar, Object obj) {
        l3.a e10 = this.f9440a.e();
        if (obj == null || !e10.c(aVar.f16958c.e())) {
            e.a aVar2 = this.f9441b;
            b bVar = aVar.f16956a;
            d<Data> dVar = aVar.f16958c;
            aVar2.b(bVar, obj, dVar, dVar.e(), this.f9446g);
            return;
        }
        this.f9444e = obj;
        this.f9441b.c();
    }

    /* access modifiers changed from: package-private */
    public void i(n.a<?> aVar, @NonNull Exception exc) {
        e.a aVar2 = this.f9441b;
        c cVar = this.f9446g;
        d<Data> dVar = aVar.f16958c;
        aVar2.a(cVar, exc, dVar, dVar.e());
    }
}
