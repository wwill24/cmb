package androidx.work.impl.utils.futures;

import androidx.annotation.NonNull;
import com.mparticle.kits.AppsFlyerKit;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractFuture<V> implements zf.a<V> {

    /* renamed from: d  reason: collision with root package name */
    static final boolean f7608d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f7609e = Logger.getLogger(AbstractFuture.class.getName());

    /* renamed from: f  reason: collision with root package name */
    static final b f7610f;

    /* renamed from: g  reason: collision with root package name */
    private static final Object f7611g = new Object();

    /* renamed from: a  reason: collision with root package name */
    volatile Object f7612a;

    /* renamed from: b  reason: collision with root package name */
    volatile d f7613b;

    /* renamed from: c  reason: collision with root package name */
    volatile h f7614c;

    private static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        static final Failure f7615b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        final Throwable f7616a;

        Failure(Throwable th2) {
            this.f7616a = (Throwable) AbstractFuture.d(th2);
        }
    }

    private static abstract class b {
        private b() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2);

        /* access modifiers changed from: package-private */
        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean c(AbstractFuture<?> abstractFuture, h hVar, h hVar2);

        /* access modifiers changed from: package-private */
        public abstract void d(h hVar, h hVar2);

        /* access modifiers changed from: package-private */
        public abstract void e(h hVar, Thread thread);
    }

    private static final class c {

        /* renamed from: c  reason: collision with root package name */
        static final c f7617c;

        /* renamed from: d  reason: collision with root package name */
        static final c f7618d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f7619a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f7620b;

        static {
            if (AbstractFuture.f7608d) {
                f7618d = null;
                f7617c = null;
                return;
            }
            f7618d = new c(false, (Throwable) null);
            f7617c = new c(true, (Throwable) null);
        }

        c(boolean z10, Throwable th2) {
            this.f7619a = z10;
            this.f7620b = th2;
        }
    }

    private static final class d {

        /* renamed from: d  reason: collision with root package name */
        static final d f7621d = new d((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f7622a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f7623b;

        /* renamed from: c  reason: collision with root package name */
        d f7624c;

        d(Runnable runnable, Executor executor) {
            this.f7622a = runnable;
            this.f7623b = executor;
        }
    }

    private static final class e extends b {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, Thread> f7625a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, h> f7626b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, h> f7627c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, d> f7628d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f7629e;

        e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f7625a = atomicReferenceFieldUpdater;
            this.f7626b = atomicReferenceFieldUpdater2;
            this.f7627c = atomicReferenceFieldUpdater3;
            this.f7628d = atomicReferenceFieldUpdater4;
            this.f7629e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return androidx.concurrent.futures.a.a(this.f7628d, abstractFuture, dVar, dVar2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f7629e, abstractFuture, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractFuture<?> abstractFuture, h hVar, h hVar2) {
            return androidx.concurrent.futures.a.a(this.f7627c, abstractFuture, hVar, hVar2);
        }

        /* access modifiers changed from: package-private */
        public void d(h hVar, h hVar2) {
            this.f7626b.lazySet(hVar, hVar2);
        }

        /* access modifiers changed from: package-private */
        public void e(h hVar, Thread thread) {
            this.f7625a.lazySet(hVar, thread);
        }
    }

    private static final class f<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final AbstractFuture<V> f7630a;

        /* renamed from: b  reason: collision with root package name */
        final zf.a<? extends V> f7631b;

        f(AbstractFuture<V> abstractFuture, zf.a<? extends V> aVar) {
            this.f7630a = abstractFuture;
            this.f7631b = aVar;
        }

        public void run() {
            if (this.f7630a.f7612a == this) {
                if (AbstractFuture.f7610f.b(this.f7630a, this, AbstractFuture.i(this.f7631b))) {
                    AbstractFuture.f(this.f7630a);
                }
            }
        }
    }

    private static final class g extends b {
        g() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f7613b != dVar) {
                    return false;
                }
                abstractFuture.f7613b = dVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f7612a != obj) {
                    return false;
                }
                abstractFuture.f7612a = obj2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractFuture<?> abstractFuture, h hVar, h hVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f7614c != hVar) {
                    return false;
                }
                abstractFuture.f7614c = hVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void d(h hVar, h hVar2) {
            hVar.f7634b = hVar2;
        }

        /* access modifiers changed from: package-private */
        public void e(h hVar, Thread thread) {
            hVar.f7633a = thread;
        }
    }

    private static final class h {

        /* renamed from: c  reason: collision with root package name */
        static final h f7632c = new h(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f7633a;

        /* renamed from: b  reason: collision with root package name */
        volatile h f7634b;

        h(boolean z10) {
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar) {
            AbstractFuture.f7610f.d(this, hVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Thread thread = this.f7633a;
            if (thread != null) {
                this.f7633a = null;
                LockSupport.unpark(thread);
            }
        }

        h() {
            AbstractFuture.f7610f.e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.work.impl.utils.futures.AbstractFuture$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.work.impl.utils.futures.AbstractFuture$g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: androidx.work.impl.utils.futures.AbstractFuture$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.work.impl.utils.futures.AbstractFuture$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture$h> r0 = androidx.work.impl.utils.futures.AbstractFuture.h.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            f7608d = r1
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture> r1 = androidx.work.impl.utils.futures.AbstractFuture.class
            java.lang.String r1 = r1.getName()
            java.util.logging.Logger r1 = java.util.logging.Logger.getLogger(r1)
            f7609e = r1
            androidx.work.impl.utils.futures.AbstractFuture$e r1 = new androidx.work.impl.utils.futures.AbstractFuture$e     // Catch:{ all -> 0x004e }
            java.lang.Class<java.lang.Thread> r2 = java.lang.Thread.class
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r3)     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r2)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture> r2 = androidx.work.impl.utils.futures.AbstractFuture.class
            java.lang.String r5 = "c"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r2, r0, r5)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture> r0 = androidx.work.impl.utils.futures.AbstractFuture.class
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture$d> r2 = androidx.work.impl.utils.futures.AbstractFuture.d.class
            java.lang.String r6 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r6)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture> r0 = androidx.work.impl.utils.futures.AbstractFuture.class
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            java.lang.String r7 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r7)     // Catch:{ all -> 0x004e }
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004e }
            r0 = 0
            goto L_0x0054
        L_0x004e:
            r0 = move-exception
            androidx.work.impl.utils.futures.AbstractFuture$g r1 = new androidx.work.impl.utils.futures.AbstractFuture$g
            r1.<init>()
        L_0x0054:
            f7610f = r1
            java.lang.Class<java.util.concurrent.locks.LockSupport> r1 = java.util.concurrent.locks.LockSupport.class
            if (r0 == 0) goto L_0x0063
            java.util.logging.Logger r1 = f7609e
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x0063:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            f7611g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.<clinit>():void");
    }

    protected AbstractFuture() {
    }

    private void a(StringBuilder sb2) {
        try {
            Object j10 = j(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(r(j10));
            sb2.append("]");
        } catch (ExecutionException e10) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e10.getCause());
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e11) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e11.getClass());
            sb2.append(" thrown from get()]");
        }
    }

    private static CancellationException c(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    @NonNull
    static <T> T d(T t10) {
        t10.getClass();
        return t10;
    }

    private d e(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f7613b;
        } while (!f7610f.a(this, dVar2, d.f7621d));
        d dVar3 = dVar2;
        d dVar4 = dVar;
        d dVar5 = dVar3;
        while (dVar5 != null) {
            d dVar6 = dVar5.f7624c;
            dVar5.f7624c = dVar4;
            dVar4 = dVar5;
            dVar5 = dVar6;
        }
        return dVar4;
    }

    static void f(AbstractFuture<?> abstractFuture) {
        d dVar = null;
        AbstractFuture<V> abstractFuture2 = abstractFuture;
        while (true) {
            abstractFuture2.m();
            abstractFuture2.b();
            d e10 = abstractFuture2.e(dVar);
            while (true) {
                if (e10 != null) {
                    dVar = e10.f7624c;
                    Runnable runnable = e10.f7622a;
                    if (runnable instanceof f) {
                        f fVar = (f) runnable;
                        AbstractFuture<V> abstractFuture3 = fVar.f7630a;
                        if (abstractFuture3.f7612a == fVar) {
                            if (f7610f.b(abstractFuture3, fVar, i(fVar.f7631b))) {
                                abstractFuture2 = abstractFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        g(runnable, e10.f7623b);
                    }
                    e10 = dVar;
                } else {
                    return;
                }
            }
        }
    }

    private static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = f7609e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e10);
        }
    }

    private V h(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f7620b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f7616a);
        } else if (obj == f7611g) {
            return null;
        } else {
            return obj;
        }
    }

    static Object i(zf.a<?> aVar) {
        if (aVar instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) aVar).f7612a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (!cVar.f7619a) {
                return obj;
            }
            if (cVar.f7620b != null) {
                return new c(false, cVar.f7620b);
            }
            return c.f7618d;
        }
        boolean isCancelled = aVar.isCancelled();
        if ((!f7608d) && isCancelled) {
            return c.f7618d;
        }
        try {
            Object j10 = j(aVar);
            if (j10 == null) {
                return f7611g;
            }
            return j10;
        } catch (ExecutionException e10) {
            return new Failure(e10.getCause());
        } catch (CancellationException e11) {
            if (isCancelled) {
                return new c(false, e11);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e11));
        } catch (Throwable th2) {
            return new Failure(th2);
        }
    }

    private static <V> V j(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    private void m() {
        h hVar;
        do {
            hVar = this.f7614c;
        } while (!f7610f.c(this, hVar, h.f7632c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f7634b;
        }
    }

    private void n(h hVar) {
        hVar.f7633a = null;
        while (true) {
            h hVar2 = this.f7614c;
            if (hVar2 != h.f7632c) {
                h hVar3 = null;
                while (hVar2 != null) {
                    h hVar4 = hVar2.f7634b;
                    if (hVar2.f7633a != null) {
                        hVar3 = hVar2;
                    } else if (hVar3 != null) {
                        hVar3.f7634b = hVar4;
                        if (hVar3.f7633a == null) {
                        }
                    } else if (!f7610f.c(this, hVar2, hVar4)) {
                    }
                    hVar2 = hVar4;
                }
                return;
            }
            return;
        }
    }

    private String r(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        d dVar = this.f7613b;
        if (dVar != d.f7621d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f7624c = dVar;
                if (!f7610f.a(this, dVar, dVar2)) {
                    dVar = this.f7613b;
                } else {
                    return;
                }
            } while (dVar != d.f7621d);
        }
        g(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, zf.a<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f7612a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.f
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = f7608d
            if (r3 == 0) goto L_0x001f
            androidx.work.impl.utils.futures.AbstractFuture$c r3 = new androidx.work.impl.utils.futures.AbstractFuture$c
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.work.impl.utils.futures.AbstractFuture$c r3 = androidx.work.impl.utils.futures.AbstractFuture.c.f7617c
            goto L_0x0026
        L_0x0024:
            androidx.work.impl.utils.futures.AbstractFuture$c r3 = androidx.work.impl.utils.futures.AbstractFuture.c.f7618d
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            androidx.work.impl.utils.futures.AbstractFuture$b r6 = f7610f
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.k()
        L_0x0035:
            f(r4)
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.f
            if (r4 == 0) goto L_0x0062
            androidx.work.impl.utils.futures.AbstractFuture$f r0 = (androidx.work.impl.utils.futures.AbstractFuture.f) r0
            zf.a<? extends V> r0 = r0.f7631b
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.work.impl.utils.futures.AbstractFuture r4 = (androidx.work.impl.utils.futures.AbstractFuture) r4
            java.lang.Object r0 = r4.f7612a
            if (r0 != 0) goto L_0x004d
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.f
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = r1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.f7612a
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.f
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.cancel(boolean):boolean");
    }

    public final V get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j11 = j10;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j11);
        if (!Thread.interrupted()) {
            Object obj = this.f7612a;
            if ((obj != null) && (!(obj instanceof f))) {
                return h(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                h hVar = this.f7614c;
                if (hVar != h.f7632c) {
                    h hVar2 = new h();
                    do {
                        hVar2.a(hVar);
                        if (f7610f.c(this, hVar, hVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f7612a;
                                    if ((obj2 != null) && (!(obj2 instanceof f))) {
                                        return h(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    n(hVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            n(hVar2);
                        } else {
                            hVar = this.f7614c;
                        }
                    } while (hVar != h.f7632c);
                }
                return h(this.f7612a);
            }
            while (nanos > 0) {
                Object obj3 = this.f7612a;
                if ((obj3 != null) && (!(obj3 instanceof f))) {
                    return h(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j11 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j12 = -nanos;
                long convert = timeUnit2.convert(j12, TimeUnit.NANOSECONDS);
                long nanos2 = j12 - timeUnit2.toNanos(convert);
                int i10 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z10 = i10 == 0 || nanos2 > 1000;
                if (i10 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z10) {
                        str3 = str3 + AppsFlyerKit.COMMA;
                    }
                    str2 = str3 + " ";
                }
                if (z10) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.f7612a instanceof c;
    }

    public final boolean isDone() {
        boolean z10;
        Object obj = this.f7612a;
        if (obj != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return (!(obj instanceof f)) & z10;
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public String l() {
        Object obj = this.f7612a;
        if (obj instanceof f) {
            return "setFuture=[" + r(((f) obj).f7631b) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    /* access modifiers changed from: protected */
    public boolean o(V v10) {
        if (v10 == null) {
            v10 = f7611g;
        }
        if (!f7610f.b(this, (Object) null, v10)) {
            return false;
        }
        f(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean p(Throwable th2) {
        if (!f7610f.b(this, (Object) null, new Failure((Throwable) d(th2)))) {
            return false;
        }
        f(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean q(zf.a<? extends V> aVar) {
        f fVar;
        Failure failure;
        d(aVar);
        Object obj = this.f7612a;
        if (obj == null) {
            if (aVar.isDone()) {
                if (!f7610f.b(this, (Object) null, i(aVar))) {
                    return false;
                }
                f(this);
                return true;
            }
            fVar = new f(this, aVar);
            if (f7610f.b(this, (Object) null, fVar)) {
                try {
                    aVar.addListener(fVar, DirectExecutor.INSTANCE);
                } catch (Throwable unused) {
                    failure = Failure.f7615b;
                }
                return true;
            }
            obj = this.f7612a;
        }
        if (obj instanceof c) {
            aVar.cancel(((c) obj).f7619a);
        }
        return false;
        f7610f.b(this, fVar, failure);
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            a(sb2);
        } else {
            try {
                str = l();
            } catch (RuntimeException e10) {
                str = "Exception thrown from implementation: " + e10.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(str);
                sb2.append("]");
            } else if (isDone()) {
                a(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f7612a;
            if ((obj2 != null) && (!(obj2 instanceof f))) {
                return h(obj2);
            }
            h hVar = this.f7614c;
            if (hVar != h.f7632c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f7610f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f7612a;
                            } else {
                                n(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return h(obj);
                    }
                    hVar = this.f7614c;
                } while (hVar != h.f7632c);
            }
            return h(this.f7612a);
        }
        throw new InterruptedException();
    }
}
