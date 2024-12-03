package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.e;
import com.bumptech.glide.load.engine.DecodeJob;
import i3.b;
import i3.g;
import i3.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l3.a;
import l3.c;
import p3.n;

final class f<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n.a<?>> f9316a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f9317b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private e f9318c;

    /* renamed from: d  reason: collision with root package name */
    private Object f9319d;

    /* renamed from: e  reason: collision with root package name */
    private int f9320e;

    /* renamed from: f  reason: collision with root package name */
    private int f9321f;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f9322g;

    /* renamed from: h  reason: collision with root package name */
    private DecodeJob.e f9323h;

    /* renamed from: i  reason: collision with root package name */
    private i3.e f9324i;

    /* renamed from: j  reason: collision with root package name */
    private Map<Class<?>, h<?>> f9325j;

    /* renamed from: k  reason: collision with root package name */
    private Class<Transcode> f9326k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9327l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9328m;

    /* renamed from: n  reason: collision with root package name */
    private b f9329n;

    /* renamed from: o  reason: collision with root package name */
    private Priority f9330o;

    /* renamed from: p  reason: collision with root package name */
    private a f9331p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f9332q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f9333r;

    f() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f9318c = null;
        this.f9319d = null;
        this.f9329n = null;
        this.f9322g = null;
        this.f9326k = null;
        this.f9324i = null;
        this.f9330o = null;
        this.f9325j = null;
        this.f9331p = null;
        this.f9316a.clear();
        this.f9327l = false;
        this.f9317b.clear();
        this.f9328m = false;
    }

    /* access modifiers changed from: package-private */
    public m3.b b() {
        return this.f9318c.b();
    }

    /* access modifiers changed from: package-private */
    public List<b> c() {
        if (!this.f9328m) {
            this.f9328m = true;
            this.f9317b.clear();
            List<n.a<?>> g10 = g();
            int size = g10.size();
            for (int i10 = 0; i10 < size; i10++) {
                n.a aVar = g10.get(i10);
                if (!this.f9317b.contains(aVar.f16956a)) {
                    this.f9317b.add(aVar.f16956a);
                }
                for (int i11 = 0; i11 < aVar.f16957b.size(); i11++) {
                    if (!this.f9317b.contains(aVar.f16957b.get(i11))) {
                        this.f9317b.add(aVar.f16957b.get(i11));
                    }
                }
            }
        }
        return this.f9317b;
    }

    /* access modifiers changed from: package-private */
    public n3.a d() {
        return this.f9323h.a();
    }

    /* access modifiers changed from: package-private */
    public a e() {
        return this.f9331p;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f9321f;
    }

    /* access modifiers changed from: package-private */
    public List<n.a<?>> g() {
        if (!this.f9327l) {
            this.f9327l = true;
            this.f9316a.clear();
            List i10 = this.f9318c.h().i(this.f9319d);
            int size = i10.size();
            for (int i11 = 0; i11 < size; i11++) {
                n.a b10 = ((n) i10.get(i11)).b(this.f9319d, this.f9320e, this.f9321f, this.f9324i);
                if (b10 != null) {
                    this.f9316a.add(b10);
                }
            }
        }
        return this.f9316a;
    }

    /* access modifiers changed from: package-private */
    public <Data> o<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f9318c.h().h(cls, this.f9322g, this.f9326k);
    }

    /* access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f9319d.getClass();
    }

    /* access modifiers changed from: package-private */
    public List<n<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f9318c.h().i(file);
    }

    /* access modifiers changed from: package-private */
    public i3.e k() {
        return this.f9324i;
    }

    /* access modifiers changed from: package-private */
    public Priority l() {
        return this.f9330o;
    }

    /* access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f9318c.h().j(this.f9319d.getClass(), this.f9322g, this.f9326k);
    }

    /* access modifiers changed from: package-private */
    public <Z> g<Z> n(c<Z> cVar) {
        return this.f9318c.h().k(cVar);
    }

    /* access modifiers changed from: package-private */
    public b o() {
        return this.f9329n;
    }

    /* access modifiers changed from: package-private */
    public <X> i3.a<X> p(X x10) throws Registry.NoSourceEncoderAvailableException {
        return this.f9318c.h().m(x10);
    }

    /* access modifiers changed from: package-private */
    public Class<?> q() {
        return this.f9326k;
    }

    /* access modifiers changed from: package-private */
    public <Z> h<Z> r(Class<Z> cls) {
        h<Z> hVar = this.f9325j.get(cls);
        if (hVar == null) {
            Iterator<Map.Entry<Class<?>, h<?>>> it = this.f9325j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    hVar = (h) next.getValue();
                    break;
                }
            }
        }
        if (hVar != null) {
            return hVar;
        }
        if (!this.f9325j.isEmpty() || !this.f9332q) {
            return r3.c.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* access modifiers changed from: package-private */
    public int s() {
        return this.f9320e;
    }

    /* access modifiers changed from: package-private */
    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* access modifiers changed from: package-private */
    public <R> void u(e eVar, Object obj, b bVar, int i10, int i11, a aVar, Class<?> cls, Class<R> cls2, Priority priority, i3.e eVar2, Map<Class<?>, h<?>> map, boolean z10, boolean z11, DecodeJob.e eVar3) {
        this.f9318c = eVar;
        this.f9319d = obj;
        this.f9329n = bVar;
        this.f9320e = i10;
        this.f9321f = i11;
        this.f9331p = aVar;
        this.f9322g = cls;
        this.f9323h = eVar3;
        this.f9326k = cls2;
        this.f9330o = priority;
        this.f9324i = eVar2;
        this.f9325j = map;
        this.f9332q = z10;
        this.f9333r = z11;
    }

    /* access modifiers changed from: package-private */
    public boolean v(c<?> cVar) {
        return this.f9318c.h().n(cVar);
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        return this.f9333r;
    }

    /* access modifiers changed from: package-private */
    public boolean x(b bVar) {
        List<n.a<?>> g10 = g();
        int size = g10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (g10.get(i10).f16956a.equals(bVar)) {
                return true;
            }
        }
        return false;
    }
}
