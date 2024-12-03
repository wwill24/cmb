package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.l1;
import androidx.core.util.h;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import u.f;

public abstract class x1<T> implements l1<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2699a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<Object> f2700b;

    /* renamed from: c  reason: collision with root package name */
    private int f2701c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2702d = false;

    /* renamed from: e  reason: collision with root package name */
    private final Map<l1.a<? super T>, b<T>> f2703e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final CopyOnWriteArraySet<b<T>> f2704f = new CopyOnWriteArraySet<>();

    static abstract class a {
        a() {
        }

        @NonNull
        static a b(@NonNull Throwable th2) {
            return new i(th2);
        }

        @NonNull
        public abstract Throwable a();
    }

    private static final class b<T> implements Runnable {

        /* renamed from: h  reason: collision with root package name */
        private static final Object f2705h = new Object();

        /* renamed from: a  reason: collision with root package name */
        private final Executor f2706a;

        /* renamed from: b  reason: collision with root package name */
        private final l1.a<? super T> f2707b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicBoolean f2708c = new AtomicBoolean(true);

        /* renamed from: d  reason: collision with root package name */
        private final AtomicReference<Object> f2709d;

        /* renamed from: e  reason: collision with root package name */
        private Object f2710e = f2705h;

        /* renamed from: f  reason: collision with root package name */
        private int f2711f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2712g = false;

        b(@NonNull AtomicReference<Object> atomicReference, @NonNull Executor executor, @NonNull l1.a<? super T> aVar) {
            this.f2709d = atomicReference;
            this.f2706a = executor;
            this.f2707b = aVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2708c.set(false);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(int r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                java.util.concurrent.atomic.AtomicBoolean r0 = r1.f2708c     // Catch:{ all -> 0x002c }
                boolean r0 = r0.get()     // Catch:{ all -> 0x002c }
                if (r0 != 0) goto L_0x000b
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                return
            L_0x000b:
                int r0 = r1.f2711f     // Catch:{ all -> 0x002c }
                if (r2 > r0) goto L_0x0011
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                return
            L_0x0011:
                r1.f2711f = r2     // Catch:{ all -> 0x002c }
                boolean r2 = r1.f2712g     // Catch:{ all -> 0x002c }
                if (r2 == 0) goto L_0x0019
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                return
            L_0x0019:
                r2 = 1
                r1.f2712g = r2     // Catch:{ all -> 0x002c }
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                java.util.concurrent.Executor r2 = r1.f2706a     // Catch:{ all -> 0x0023 }
                r2.execute(r1)     // Catch:{ all -> 0x0023 }
                goto L_0x0028
            L_0x0023:
                monitor-enter(r1)
                r2 = 0
                r1.f2712g = r2     // Catch:{ all -> 0x0029 }
                monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            L_0x0028:
                return
            L_0x0029:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0029 }
                throw r2
            L_0x002c:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.x1.b.b(int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
            if (java.util.Objects.equals(r4.f2710e, r0) != false) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
            r4.f2710e = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
            if ((r0 instanceof androidx.camera.core.impl.x1.a) == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
            r4.f2707b.onError(((androidx.camera.core.impl.x1.a) r0).a());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
            r4.f2707b.a(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            if (r2 == r4.f2711f) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
            if (r4.f2708c.get() != false) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
            r0 = r4.f2709d.get();
            r2 = r4.f2711f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
            r4.f2712g = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                monitor-enter(r4)
                java.util.concurrent.atomic.AtomicBoolean r0 = r4.f2708c     // Catch:{ all -> 0x0055 }
                boolean r0 = r0.get()     // Catch:{ all -> 0x0055 }
                r1 = 0
                if (r0 != 0) goto L_0x000e
                r4.f2712g = r1     // Catch:{ all -> 0x0055 }
                monitor-exit(r4)     // Catch:{ all -> 0x0055 }
                return
            L_0x000e:
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r4.f2709d     // Catch:{ all -> 0x0055 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0055 }
                int r2 = r4.f2711f     // Catch:{ all -> 0x0055 }
                monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            L_0x0017:
                java.lang.Object r3 = r4.f2710e
                boolean r3 = java.util.Objects.equals(r3, r0)
                if (r3 != 0) goto L_0x0036
                r4.f2710e = r0
                boolean r3 = r0 instanceof androidx.camera.core.impl.x1.a
                if (r3 == 0) goto L_0x0031
                androidx.camera.core.impl.l1$a<? super T> r3 = r4.f2707b
                androidx.camera.core.impl.x1$a r0 = (androidx.camera.core.impl.x1.a) r0
                java.lang.Throwable r0 = r0.a()
                r3.onError(r0)
                goto L_0x0036
            L_0x0031:
                androidx.camera.core.impl.l1$a<? super T> r3 = r4.f2707b
                r3.a(r0)
            L_0x0036:
                monitor-enter(r4)
                int r0 = r4.f2711f     // Catch:{ all -> 0x0052 }
                if (r2 == r0) goto L_0x004e
                java.util.concurrent.atomic.AtomicBoolean r0 = r4.f2708c     // Catch:{ all -> 0x0052 }
                boolean r0 = r0.get()     // Catch:{ all -> 0x0052 }
                if (r0 != 0) goto L_0x0044
                goto L_0x004e
            L_0x0044:
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r4.f2709d     // Catch:{ all -> 0x0052 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0052 }
                int r2 = r4.f2711f     // Catch:{ all -> 0x0052 }
                monitor-exit(r4)     // Catch:{ all -> 0x0052 }
                goto L_0x0017
            L_0x004e:
                r4.f2712g = r1     // Catch:{ all -> 0x0052 }
                monitor-exit(r4)     // Catch:{ all -> 0x0052 }
                return
            L_0x0052:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0052 }
                throw r0
            L_0x0055:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0055 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.x1.b.run():void");
        }
    }

    x1(Object obj, boolean z10) {
        if (z10) {
            h.b(obj instanceof Throwable, "Initial errors must be Throwable");
            this.f2700b = new AtomicReference<>(a.b((Throwable) obj));
            return;
        }
        this.f2700b = new AtomicReference<>(obj);
    }

    private void a(@NonNull l1.a<? super T> aVar) {
        b remove = this.f2703e.remove(aVar);
        if (remove != null) {
            remove.a();
            this.f2704f.remove(remove);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r1.hasNext() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        r1.next().b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r1 = r3.f2699a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r3.f2701c != r4) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        r3.f2702d = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        r4 = r3.f2704f.iterator();
        r0 = r3.f2701c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        r1 = r4;
        r4 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f2699a
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r3.f2700b     // Catch:{ all -> 0x0051 }
            java.lang.Object r1 = r1.getAndSet(r4)     // Catch:{ all -> 0x0051 }
            boolean r4 = java.util.Objects.equals(r1, r4)     // Catch:{ all -> 0x0051 }
            if (r4 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x0011:
            int r4 = r3.f2701c     // Catch:{ all -> 0x0051 }
            r1 = 1
            int r4 = r4 + r1
            r3.f2701c = r4     // Catch:{ all -> 0x0051 }
            boolean r2 = r3.f2702d     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x001d:
            r3.f2702d = r1     // Catch:{ all -> 0x0051 }
            java.util.concurrent.CopyOnWriteArraySet<androidx.camera.core.impl.x1$b<T>> r1 = r3.f2704f     // Catch:{ all -> 0x0051 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0051 }
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
        L_0x0026:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0036
            java.lang.Object r0 = r1.next()
            androidx.camera.core.impl.x1$b r0 = (androidx.camera.core.impl.x1.b) r0
            r0.b(r4)
            goto L_0x0026
        L_0x0036:
            java.lang.Object r1 = r3.f2699a
            monitor-enter(r1)
            int r0 = r3.f2701c     // Catch:{ all -> 0x004e }
            if (r0 != r4) goto L_0x0042
            r4 = 0
            r3.f2702d = r4     // Catch:{ all -> 0x004e }
            monitor-exit(r1)     // Catch:{ all -> 0x004e }
            return
        L_0x0042:
            java.util.concurrent.CopyOnWriteArraySet<androidx.camera.core.impl.x1$b<T>> r4 = r3.f2704f     // Catch:{ all -> 0x004e }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x004e }
            int r0 = r3.f2701c     // Catch:{ all -> 0x004e }
            monitor-exit(r1)     // Catch:{ all -> 0x004e }
            r1 = r4
            r4 = r0
            goto L_0x0026
        L_0x004e:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004e }
            throw r4
        L_0x0051:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.x1.g(java.lang.Object):void");
    }

    @NonNull
    public zf.a<T> b() {
        Object obj = this.f2700b.get();
        if (obj instanceof a) {
            return f.f(((a) obj).a());
        }
        return f.h(obj);
    }

    public void c(@NonNull Executor executor, @NonNull l1.a<? super T> aVar) {
        b bVar;
        synchronized (this.f2699a) {
            a(aVar);
            bVar = new b(this.f2700b, executor, aVar);
            this.f2703e.put(aVar, bVar);
            this.f2704f.add(bVar);
        }
        bVar.b(0);
    }

    public void d(@NonNull l1.a<? super T> aVar) {
        synchronized (this.f2699a) {
            a(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(T t10) {
        g(t10);
    }
}
