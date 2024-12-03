package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.e;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.m;
import f4.f;
import f4.j;
import g4.a;
import java.util.Map;
import java.util.concurrent.Executor;
import n3.a;
import n3.h;
import net.bytebuddy.jar.asm.Opcodes;

public class h implements j, h.a, m.a {

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f9339i = Log.isLoggable("Engine", 2);

    /* renamed from: a  reason: collision with root package name */
    private final n f9340a;

    /* renamed from: b  reason: collision with root package name */
    private final l f9341b;

    /* renamed from: c  reason: collision with root package name */
    private final n3.h f9342c;

    /* renamed from: d  reason: collision with root package name */
    private final b f9343d;

    /* renamed from: e  reason: collision with root package name */
    private final s f9344e;

    /* renamed from: f  reason: collision with root package name */
    private final c f9345f;

    /* renamed from: g  reason: collision with root package name */
    private final a f9346g;

    /* renamed from: h  reason: collision with root package name */
    private final a f9347h;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final DecodeJob.e f9348a;

        /* renamed from: b  reason: collision with root package name */
        final e<DecodeJob<?>> f9349b = g4.a.d(Opcodes.FCMPG, new C0112a());

        /* renamed from: c  reason: collision with root package name */
        private int f9350c;

        /* renamed from: com.bumptech.glide.load.engine.h$a$a  reason: collision with other inner class name */
        class C0112a implements a.d<DecodeJob<?>> {
            C0112a() {
            }

            /* renamed from: a */
            public DecodeJob<?> create() {
                a aVar = a.this;
                return new DecodeJob<>(aVar.f9348a, aVar.f9349b);
            }
        }

        a(DecodeJob.e eVar) {
            this.f9348a = eVar;
        }

        /* access modifiers changed from: package-private */
        public <R> DecodeJob<R> a(com.bumptech.glide.e eVar, Object obj, k kVar, i3.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, l3.a aVar, Map<Class<?>, i3.h<?>> map, boolean z10, boolean z11, boolean z12, i3.e eVar2, DecodeJob.b<R> bVar2) {
            DecodeJob decodeJob = (DecodeJob) j.d(this.f9349b.acquire());
            int i12 = this.f9350c;
            int i13 = i12;
            this.f9350c = i12 + 1;
            return decodeJob.q(eVar, obj, kVar, bVar, i10, i11, cls, cls2, priority, aVar, map, z10, z11, z12, eVar2, bVar2, i13);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final o3.a f9352a;

        /* renamed from: b  reason: collision with root package name */
        final o3.a f9353b;

        /* renamed from: c  reason: collision with root package name */
        final o3.a f9354c;

        /* renamed from: d  reason: collision with root package name */
        final o3.a f9355d;

        /* renamed from: e  reason: collision with root package name */
        final j f9356e;

        /* renamed from: f  reason: collision with root package name */
        final m.a f9357f;

        /* renamed from: g  reason: collision with root package name */
        final e<i<?>> f9358g = g4.a.d(Opcodes.FCMPG, new a());

        class a implements a.d<i<?>> {
            a() {
            }

            /* renamed from: a */
            public i<?> create() {
                b bVar = b.this;
                return new i(bVar.f9352a, bVar.f9353b, bVar.f9354c, bVar.f9355d, bVar.f9356e, bVar.f9357f, bVar.f9358g);
            }
        }

        b(o3.a aVar, o3.a aVar2, o3.a aVar3, o3.a aVar4, j jVar, m.a aVar5) {
            this.f9352a = aVar;
            this.f9353b = aVar2;
            this.f9354c = aVar3;
            this.f9355d = aVar4;
            this.f9356e = jVar;
            this.f9357f = aVar5;
        }

        /* access modifiers changed from: package-private */
        public <R> i<R> a(i3.b bVar, boolean z10, boolean z11, boolean z12, boolean z13) {
            return ((i) j.d(this.f9358g.acquire())).l(bVar, z10, z11, z12, z13);
        }
    }

    private static class c implements DecodeJob.e {

        /* renamed from: a  reason: collision with root package name */
        private final a.C0176a f9360a;

        /* renamed from: b  reason: collision with root package name */
        private volatile n3.a f9361b;

        c(a.C0176a aVar) {
            this.f9360a = aVar;
        }

        public n3.a a() {
            if (this.f9361b == null) {
                synchronized (this) {
                    if (this.f9361b == null) {
                        this.f9361b = this.f9360a.build();
                    }
                    if (this.f9361b == null) {
                        this.f9361b = new n3.b();
                    }
                }
            }
            return this.f9361b;
        }
    }

    public class d {

        /* renamed from: a  reason: collision with root package name */
        private final i<?> f9362a;

        /* renamed from: b  reason: collision with root package name */
        private final b4.d f9363b;

        d(b4.d dVar, i<?> iVar) {
            this.f9363b = dVar;
            this.f9362a = iVar;
        }

        public void a() {
            synchronized (h.this) {
                this.f9362a.r(this.f9363b);
            }
        }
    }

    public h(n3.h hVar, a.C0176a aVar, o3.a aVar2, o3.a aVar3, o3.a aVar4, o3.a aVar5, boolean z10) {
        this(hVar, aVar, aVar2, aVar3, aVar4, aVar5, (n) null, (l) null, (a) null, (b) null, (a) null, (s) null, z10);
    }

    private m<?> e(i3.b bVar) {
        l3.c<?> e10 = this.f9342c.e(bVar);
        if (e10 == null) {
            return null;
        }
        if (e10 instanceof m) {
            return (m) e10;
        }
        return new m<>(e10, true, true, bVar, this);
    }

    private m<?> g(i3.b bVar) {
        m<?> e10 = this.f9347h.e(bVar);
        if (e10 != null) {
            e10.c();
        }
        return e10;
    }

    private m<?> h(i3.b bVar) {
        m<?> e10 = e(bVar);
        if (e10 != null) {
            e10.c();
            this.f9347h.a(bVar, e10);
        }
        return e10;
    }

    private m<?> i(k kVar, boolean z10, long j10) {
        if (!z10) {
            return null;
        }
        m<?> g10 = g(kVar);
        if (g10 != null) {
            if (f9339i) {
                j("Loaded resource from active resources", j10, kVar);
            }
            return g10;
        }
        m<?> h10 = h(kVar);
        if (h10 == null) {
            return null;
        }
        if (f9339i) {
            j("Loaded resource from cache", j10, kVar);
        }
        return h10;
    }

    private static void j(String str, long j10, i3.b bVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(f.a(j10));
        sb2.append("ms, key: ");
        sb2.append(bVar);
    }

    private <R> d l(com.bumptech.glide.e eVar, Object obj, i3.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, l3.a aVar, Map<Class<?>, i3.h<?>> map, boolean z10, boolean z11, i3.e eVar2, boolean z12, boolean z13, boolean z14, boolean z15, b4.d dVar, Executor executor, k kVar, long j10) {
        b4.d dVar2 = dVar;
        Executor executor2 = executor;
        k kVar2 = kVar;
        long j11 = j10;
        i<?> a10 = this.f9340a.a(kVar2, z15);
        if (a10 != null) {
            a10.e(dVar2, executor2);
            if (f9339i) {
                j("Added to existing load", j11, kVar2);
            }
            return new d(dVar2, a10);
        }
        i a11 = this.f9343d.a(kVar, z12, z13, z14, z15);
        i iVar = a11;
        k kVar3 = kVar2;
        DecodeJob<R> a12 = this.f9346g.a(eVar, obj, kVar, bVar, i10, i11, cls, cls2, priority, aVar, map, z10, z11, z15, eVar2, a11);
        this.f9340a.c(kVar3, iVar);
        i iVar2 = iVar;
        k kVar4 = kVar3;
        b4.d dVar3 = dVar;
        iVar2.e(dVar3, executor);
        iVar2.s(a12);
        if (f9339i) {
            j("Started new load", j10, kVar4);
        }
        return new d(dVar3, iVar2);
    }

    public void a(@NonNull l3.c<?> cVar) {
        this.f9344e.a(cVar, true);
    }

    public synchronized void b(i<?> iVar, i3.b bVar, m<?> mVar) {
        if (mVar != null) {
            if (mVar.e()) {
                this.f9347h.a(bVar, mVar);
            }
        }
        this.f9340a.d(bVar, iVar);
    }

    public synchronized void c(i<?> iVar, i3.b bVar) {
        this.f9340a.d(bVar, iVar);
    }

    public void d(i3.b bVar, m<?> mVar) {
        this.f9347h.d(bVar);
        if (mVar.e()) {
            this.f9342c.d(bVar, mVar);
        } else {
            this.f9344e.a(mVar, false);
        }
    }

    public <R> d f(com.bumptech.glide.e eVar, Object obj, i3.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, l3.a aVar, Map<Class<?>, i3.h<?>> map, boolean z10, boolean z11, i3.e eVar2, boolean z12, boolean z13, boolean z14, boolean z15, b4.d dVar, Executor executor) {
        long b10 = f9339i ? f.b() : 0;
        k a10 = this.f9341b.a(obj, bVar, i10, i11, map, cls, cls2, eVar2);
        synchronized (this) {
            m<?> i12 = i(a10, z12, b10);
            if (i12 == null) {
                d l10 = l(eVar, obj, bVar, i10, i11, cls, cls2, priority, aVar, map, z10, z11, eVar2, z12, z13, z14, z15, dVar, executor, a10, b10);
                return l10;
            }
            dVar.c(i12, DataSource.MEMORY_CACHE);
            return null;
        }
    }

    public void k(l3.c<?> cVar) {
        if (cVar instanceof m) {
            ((m) cVar).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    h(n3.h hVar, a.C0176a aVar, o3.a aVar2, o3.a aVar3, o3.a aVar4, o3.a aVar5, n nVar, l lVar, a aVar6, b bVar, a aVar7, s sVar, boolean z10) {
        this.f9342c = hVar;
        a.C0176a aVar8 = aVar;
        c cVar = new c(aVar);
        this.f9345f = cVar;
        a aVar9 = aVar6 == null ? new a(z10) : aVar6;
        this.f9347h = aVar9;
        aVar9.f(this);
        this.f9341b = lVar == null ? new l() : lVar;
        this.f9340a = nVar == null ? new n() : nVar;
        this.f9343d = bVar == null ? new b(aVar2, aVar3, aVar4, aVar5, this, this) : bVar;
        this.f9346g = aVar7 == null ? new a(cVar) : aVar7;
        this.f9344e = sVar == null ? new s() : sVar;
        hVar.c(this);
    }
}
