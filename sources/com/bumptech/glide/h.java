package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import b4.c;
import f4.k;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import y3.c;
import y3.d;
import y3.i;
import y3.m;
import y3.n;
import y3.p;

public class h implements ComponentCallbacks2, i {

    /* renamed from: n  reason: collision with root package name */
    private static final c f9197n = ((c) c.m0(Bitmap.class).Q());

    /* renamed from: p  reason: collision with root package name */
    private static final c f9198p = ((c) c.m0(w3.c.class).Q());

    /* renamed from: q  reason: collision with root package name */
    private static final c f9199q = ((c) ((c) c.n0(l3.a.f15996c).Y(Priority.LOW)).g0(true));

    /* renamed from: a  reason: collision with root package name */
    protected final c f9200a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f9201b;

    /* renamed from: c  reason: collision with root package name */
    final y3.h f9202c;

    /* renamed from: d  reason: collision with root package name */
    private final n f9203d;

    /* renamed from: e  reason: collision with root package name */
    private final m f9204e;

    /* renamed from: f  reason: collision with root package name */
    private final p f9205f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f9206g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f9207h;

    /* renamed from: j  reason: collision with root package name */
    private final y3.c f9208j;

    /* renamed from: k  reason: collision with root package name */
    private final CopyOnWriteArrayList<b4.b<Object>> f9209k;

    /* renamed from: l  reason: collision with root package name */
    private c f9210l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9211m;

    class a implements Runnable {
        a() {
        }

        public void run() {
            h hVar = h.this;
            hVar.f9202c.b(hVar);
        }
    }

    private class b implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final n f9213a;

        b(@NonNull n nVar) {
            this.f9213a = nVar;
        }

        public void a(boolean z10) {
            if (z10) {
                synchronized (h.this) {
                    this.f9213a.e();
                }
            }
        }
    }

    public h(@NonNull c cVar, @NonNull y3.h hVar, @NonNull m mVar, @NonNull Context context) {
        this(cVar, hVar, mVar, new n(), cVar.g(), context);
    }

    private void C(@NonNull c4.h<?> hVar) {
        boolean B = B(hVar);
        b4.a a10 = hVar.a();
        if (!B && !this.f9200a.p(hVar) && a10 != null) {
            hVar.g((b4.a) null);
            a10.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void A(@NonNull c4.h<?> hVar, @NonNull b4.a aVar) {
        this.f9205f.n(hVar);
        this.f9203d.g(aVar);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean B(@NonNull c4.h<?> hVar) {
        b4.a a10 = hVar.a();
        if (a10 == null) {
            return true;
        }
        if (!this.f9203d.a(a10)) {
            return false;
        }
        this.f9205f.o(hVar);
        hVar.g((b4.a) null);
        return true;
    }

    public synchronized void b() {
        y();
        this.f9205f.b();
    }

    public synchronized void d() {
        this.f9205f.d();
        for (c4.h<?> p10 : this.f9205f.h()) {
            p(p10);
        }
        this.f9205f.e();
        this.f9203d.b();
        this.f9202c.a(this);
        this.f9202c.a(this.f9208j);
        this.f9207h.removeCallbacks(this.f9206g);
        this.f9200a.s(this);
    }

    @NonNull
    public <ResourceType> g<ResourceType> e(@NonNull Class<ResourceType> cls) {
        return new g<>(this.f9200a, this, cls, this.f9201b);
    }

    @NonNull
    public g<Bitmap> h() {
        return e(Bitmap.class).a(f9197n);
    }

    public synchronized void m() {
        x();
        this.f9205f.m();
    }

    @NonNull
    public g<Drawable> n() {
        return e(Drawable.class);
    }

    @NonNull
    public g<w3.c> o() {
        return e(w3.c.class).a(f9198p);
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i10) {
        if (i10 == 60 && this.f9211m) {
            w();
        }
    }

    public void p(c4.h<?> hVar) {
        if (hVar != null) {
            C(hVar);
        }
    }

    /* access modifiers changed from: package-private */
    public List<b4.b<Object>> q() {
        return this.f9209k;
    }

    /* access modifiers changed from: package-private */
    public synchronized b4.c r() {
        return this.f9210l;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public <T> i<?, T> s(Class<T> cls) {
        return this.f9200a.i().e(cls);
    }

    @NonNull
    public g<Drawable> t(Integer num) {
        return n().A0(num);
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f9203d + ", treeNode=" + this.f9204e + "}";
    }

    @NonNull
    public g<Drawable> u(String str) {
        return n().C0(str);
    }

    public synchronized void v() {
        this.f9203d.c();
    }

    public synchronized void w() {
        v();
        for (h v10 : this.f9204e.a()) {
            v10.v();
        }
    }

    public synchronized void x() {
        this.f9203d.d();
    }

    public synchronized void y() {
        this.f9203d.f();
    }

    /* access modifiers changed from: protected */
    public synchronized void z(@NonNull b4.c cVar) {
        this.f9210l = (b4.c) ((b4.c) cVar.clone()).b();
    }

    h(c cVar, y3.h hVar, m mVar, n nVar, d dVar, Context context) {
        this.f9205f = new p();
        a aVar = new a();
        this.f9206g = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f9207h = handler;
        this.f9200a = cVar;
        this.f9202c = hVar;
        this.f9204e = mVar;
        this.f9203d = nVar;
        this.f9201b = context;
        y3.c a10 = dVar.a(context.getApplicationContext(), new b(nVar));
        this.f9208j = a10;
        if (k.o()) {
            handler.post(aVar);
        } else {
            hVar.b(this);
        }
        hVar.b(a10);
        this.f9209k = new CopyOnWriteArrayList<>(cVar.i().c());
        z(cVar.i().d());
        cVar.o(this);
    }
}
