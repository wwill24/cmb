package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.m;
import f4.j;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f9289a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f9290b;

    /* renamed from: c  reason: collision with root package name */
    final Map<i3.b, d> f9291c;

    /* renamed from: d  reason: collision with root package name */
    private final ReferenceQueue<m<?>> f9292d;

    /* renamed from: e  reason: collision with root package name */
    private m.a f9293e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f9294f;

    /* renamed from: g  reason: collision with root package name */
    private volatile c f9295g;

    /* renamed from: com.bumptech.glide.load.engine.a$a  reason: collision with other inner class name */
    class C0110a implements ThreadFactory {

        /* renamed from: com.bumptech.glide.load.engine.a$a$a  reason: collision with other inner class name */
        class C0111a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Runnable f9296a;

            C0111a(Runnable runnable) {
                this.f9296a = runnable;
            }

            public void run() {
                Process.setThreadPriority(10);
                this.f9296a.run();
            }
        }

        C0110a() {
        }

        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new C0111a(runnable), "glide-active-resources");
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            a.this.b();
        }
    }

    interface c {
        void a();
    }

    static final class d extends WeakReference<m<?>> {

        /* renamed from: a  reason: collision with root package name */
        final i3.b f9299a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f9300b;

        /* renamed from: c  reason: collision with root package name */
        l3.c<?> f9301c;

        d(@NonNull i3.b bVar, @NonNull m<?> mVar, @NonNull ReferenceQueue<? super m<?>> referenceQueue, boolean z10) {
            super(mVar, referenceQueue);
            l3.c<?> cVar;
            this.f9299a = (i3.b) j.d(bVar);
            if (!mVar.e() || !z10) {
                cVar = null;
            } else {
                cVar = (l3.c) j.d(mVar.d());
            }
            this.f9301c = cVar;
            this.f9300b = mVar.e();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f9301c = null;
            clear();
        }
    }

    a(boolean z10) {
        this(z10, Executors.newSingleThreadExecutor(new C0110a()));
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(i3.b bVar, m<?> mVar) {
        d put = this.f9291c.put(bVar, new d(bVar, mVar, this.f9292d, this.f9289a));
        if (put != null) {
            put.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        while (!this.f9294f) {
            try {
                c((d) this.f9292d.remove());
                c cVar = this.f9295g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull d dVar) {
        synchronized (this) {
            this.f9291c.remove(dVar.f9299a);
            if (dVar.f9300b) {
                l3.c<?> cVar = dVar.f9301c;
                if (cVar != null) {
                    this.f9293e.d(dVar.f9299a, new m(cVar, true, false, dVar.f9299a, this.f9293e));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void d(i3.b bVar) {
        d remove = this.f9291c.remove(bVar);
        if (remove != null) {
            remove.a();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bumptech.glide.load.engine.m<?> e(i3.b r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<i3.b, com.bumptech.glide.load.engine.a$d> r0 = r1.f9291c     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.a$d r2 = (com.bumptech.glide.load.engine.a.d) r2     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x000e
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x000e:
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.m r0 = (com.bumptech.glide.load.engine.m) r0     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.c(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return r0
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.a.e(i3.b):com.bumptech.glide.load.engine.m");
    }

    /* access modifiers changed from: package-private */
    public void f(m.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f9293e = aVar;
            }
        }
    }

    a(boolean z10, Executor executor) {
        this.f9291c = new HashMap();
        this.f9292d = new ReferenceQueue<>();
        this.f9289a = z10;
        this.f9290b = executor;
        executor.execute(new b());
    }
}
