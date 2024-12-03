package androidx.concurrent.futures;

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

public abstract class AbstractResolvableFuture<V> implements zf.a<V> {
    static final b ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Object NULL = new Object();
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log = Logger.getLogger(AbstractResolvableFuture.class.getName());
    volatile d listeners;
    volatile Object value;
    volatile h waiters;

    private static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        static final Failure f3608b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        final Throwable f3609a;

        Failure(Throwable th2) {
            this.f3609a = (Throwable) AbstractResolvableFuture.checkNotNull(th2);
        }
    }

    private static abstract class b {
        private b() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2);

        /* access modifiers changed from: package-private */
        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2);

        /* access modifiers changed from: package-private */
        public abstract void d(h hVar, h hVar2);

        /* access modifiers changed from: package-private */
        public abstract void e(h hVar, Thread thread);
    }

    private static final class c {

        /* renamed from: c  reason: collision with root package name */
        static final c f3610c;

        /* renamed from: d  reason: collision with root package name */
        static final c f3611d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f3612a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f3613b;

        static {
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
                f3611d = null;
                f3610c = null;
                return;
            }
            f3611d = new c(false, (Throwable) null);
            f3610c = new c(true, (Throwable) null);
        }

        c(boolean z10, Throwable th2) {
            this.f3612a = z10;
            this.f3613b = th2;
        }
    }

    private static final class d {

        /* renamed from: d  reason: collision with root package name */
        static final d f3614d = new d((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f3615a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f3616b;

        /* renamed from: c  reason: collision with root package name */
        d f3617c;

        d(Runnable runnable, Executor executor) {
            this.f3615a = runnable;
            this.f3616b = executor;
        }
    }

    private static final class e extends b {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, Thread> f3618a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, h> f3619b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, h> f3620c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> f3621d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f3622e;

        e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f3618a = atomicReferenceFieldUpdater;
            this.f3619b = atomicReferenceFieldUpdater2;
            this.f3620c = atomicReferenceFieldUpdater3;
            this.f3621d = atomicReferenceFieldUpdater4;
            this.f3622e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            return a.a(this.f3621d, abstractResolvableFuture, dVar, dVar2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return a.a(this.f3622e, abstractResolvableFuture, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2) {
            return a.a(this.f3620c, abstractResolvableFuture, hVar, hVar2);
        }

        /* access modifiers changed from: package-private */
        public void d(h hVar, h hVar2) {
            this.f3619b.lazySet(hVar, hVar2);
        }

        /* access modifiers changed from: package-private */
        public void e(h hVar, Thread thread) {
            this.f3618a.lazySet(hVar, thread);
        }
    }

    private static final class f<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final AbstractResolvableFuture<V> f3623a;

        /* renamed from: b  reason: collision with root package name */
        final zf.a<? extends V> f3624b;

        f(AbstractResolvableFuture<V> abstractResolvableFuture, zf.a<? extends V> aVar) {
            this.f3623a = abstractResolvableFuture;
            this.f3624b = aVar;
        }

        public void run() {
            if (this.f3623a.value == this) {
                if (AbstractResolvableFuture.ATOMIC_HELPER.b(this.f3623a, this, AbstractResolvableFuture.getFutureValue(this.f3624b))) {
                    AbstractResolvableFuture.complete(this.f3623a);
                }
            }
        }
    }

    private static final class g extends b {
        g() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.listeners != dVar) {
                    return false;
                }
                abstractResolvableFuture.listeners = dVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.value != obj) {
                    return false;
                }
                abstractResolvableFuture.value = obj2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.waiters != hVar) {
                    return false;
                }
                abstractResolvableFuture.waiters = hVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void d(h hVar, h hVar2) {
            hVar.f3627b = hVar2;
        }

        /* access modifiers changed from: package-private */
        public void e(h hVar, Thread thread) {
            hVar.f3626a = thread;
        }
    }

    private static final class h {

        /* renamed from: c  reason: collision with root package name */
        static final h f3625c = new h(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f3626a;

        /* renamed from: b  reason: collision with root package name */
        volatile h f3627b;

        h(boolean z10) {
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar) {
            AbstractResolvableFuture.ATOMIC_HELPER.d(this, hVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Thread thread = this.f3626a;
            if (thread != null) {
                this.f3626a = null;
                LockSupport.unpark(thread);
            }
        }

        h() {
            AbstractResolvableFuture.ATOMIC_HELPER.e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$h> r0 = androidx.concurrent.futures.AbstractResolvableFuture.h.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            GENERATE_CANCELLATION_CAUSES = r1
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r1 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.String r1 = r1.getName()
            java.util.logging.Logger r1 = java.util.logging.Logger.getLogger(r1)
            log = r1
            androidx.concurrent.futures.AbstractResolvableFuture$e r1 = new androidx.concurrent.futures.AbstractResolvableFuture$e     // Catch:{ all -> 0x004e }
            java.lang.Class<java.lang.Thread> r2 = java.lang.Thread.class
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r3)     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r2)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r2 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.String r5 = "waiters"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r2, r0, r5)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r0 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$d> r2 = androidx.concurrent.futures.AbstractResolvableFuture.d.class
            java.lang.String r6 = "listeners"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r6)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r0 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            java.lang.String r7 = "value"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r7)     // Catch:{ all -> 0x004e }
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004e }
            r0 = 0
            goto L_0x0054
        L_0x004e:
            r0 = move-exception
            androidx.concurrent.futures.AbstractResolvableFuture$g r1 = new androidx.concurrent.futures.AbstractResolvableFuture$g
            r1.<init>()
        L_0x0054:
            ATOMIC_HELPER = r1
            java.lang.Class<java.util.concurrent.locks.LockSupport> r1 = java.util.concurrent.locks.LockSupport.class
            if (r0 == 0) goto L_0x0063
            java.util.logging.Logger r1 = log
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x0063:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            NULL = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.<clinit>():void");
    }

    protected AbstractResolvableFuture() {
    }

    private void addDoneString(StringBuilder sb2) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(userObjectToString(uninterruptibly));
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

    private static CancellationException cancellationExceptionWithCause(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    @NonNull
    static <T> T checkNotNull(T t10) {
        t10.getClass();
        return t10;
    }

    private d clearListeners(d dVar) {
        d dVar2;
        do {
            dVar2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, dVar2, d.f3614d));
        d dVar3 = dVar2;
        d dVar4 = dVar;
        d dVar5 = dVar3;
        while (dVar5 != null) {
            d dVar6 = dVar5.f3617c;
            dVar5.f3617c = dVar4;
            dVar4 = dVar5;
            dVar5 = dVar6;
        }
        return dVar4;
    }

    static void complete(AbstractResolvableFuture<?> abstractResolvableFuture) {
        d dVar = null;
        AbstractResolvableFuture<V> abstractResolvableFuture2 = abstractResolvableFuture;
        while (true) {
            abstractResolvableFuture2.releaseWaiters();
            abstractResolvableFuture2.afterDone();
            d clearListeners = abstractResolvableFuture2.clearListeners(dVar);
            while (true) {
                if (clearListeners != null) {
                    dVar = clearListeners.f3617c;
                    Runnable runnable = clearListeners.f3615a;
                    if (runnable instanceof f) {
                        f fVar = (f) runnable;
                        AbstractResolvableFuture<V> abstractResolvableFuture3 = fVar.f3623a;
                        if (abstractResolvableFuture3.value == fVar) {
                            if (ATOMIC_HELPER.b(abstractResolvableFuture3, fVar, getFutureValue(fVar.f3624b))) {
                                abstractResolvableFuture2 = abstractResolvableFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, clearListeners.f3616b);
                    }
                    clearListeners = dVar;
                } else {
                    return;
                }
            }
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e10);
        }
    }

    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((c) obj).f3613b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f3609a);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    static Object getFutureValue(zf.a<?> aVar) {
        if (aVar instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) aVar).value;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (!cVar.f3612a) {
                return obj;
            }
            if (cVar.f3613b != null) {
                return new c(false, cVar.f3613b);
            }
            return c.f3611d;
        }
        boolean isCancelled = aVar.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            return c.f3611d;
        }
        try {
            Object uninterruptibly = getUninterruptibly(aVar);
            if (uninterruptibly == null) {
                return NULL;
            }
            return uninterruptibly;
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

    static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
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

    private void releaseWaiters() {
        h hVar;
        do {
            hVar = this.waiters;
        } while (!ATOMIC_HELPER.c(this, hVar, h.f3625c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f3627b;
        }
    }

    private void removeWaiter(h hVar) {
        hVar.f3626a = null;
        while (true) {
            h hVar2 = this.waiters;
            if (hVar2 != h.f3625c) {
                h hVar3 = null;
                while (hVar2 != null) {
                    h hVar4 = hVar2.f3627b;
                    if (hVar2.f3626a != null) {
                        hVar3 = hVar2;
                    } else if (hVar3 != null) {
                        hVar3.f3627b = hVar4;
                        if (hVar3.f3626a == null) {
                        }
                    } else if (!ATOMIC_HELPER.c(this, hVar2, hVar4)) {
                    }
                    hVar2 = hVar4;
                }
                return;
            }
            return;
        }
    }

    private String userObjectToString(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        checkNotNull(runnable);
        checkNotNull(executor);
        d dVar = this.listeners;
        if (dVar != d.f3614d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f3617c = dVar;
                if (!ATOMIC_HELPER.a(this, dVar, dVar2)) {
                    dVar = this.listeners;
                } else {
                    return;
                }
            } while (dVar != d.f3614d);
        }
        executeListener(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, zf.a<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.f
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = GENERATE_CANCELLATION_CAUSES
            if (r3 == 0) goto L_0x001f
            androidx.concurrent.futures.AbstractResolvableFuture$c r3 = new androidx.concurrent.futures.AbstractResolvableFuture$c
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.concurrent.futures.AbstractResolvableFuture$c r3 = androidx.concurrent.futures.AbstractResolvableFuture.c.f3610c
            goto L_0x0026
        L_0x0024:
            androidx.concurrent.futures.AbstractResolvableFuture$c r3 = androidx.concurrent.futures.AbstractResolvableFuture.c.f3611d
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            androidx.concurrent.futures.AbstractResolvableFuture$b r6 = ATOMIC_HELPER
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.interruptTask()
        L_0x0035:
            complete(r4)
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.f
            if (r4 == 0) goto L_0x0062
            androidx.concurrent.futures.AbstractResolvableFuture$f r0 = (androidx.concurrent.futures.AbstractResolvableFuture.f) r0
            zf.a<? extends V> r0 = r0.f3624b
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.concurrent.futures.AbstractResolvableFuture r4 = (androidx.concurrent.futures.AbstractResolvableFuture) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004d
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.f
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = r1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.f
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.cancel(boolean):boolean");
    }

    public final V get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j11 = j10;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j11);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof f))) {
                return getDoneValue(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                h hVar = this.waiters;
                if (hVar != h.f3625c) {
                    h hVar2 = new h();
                    do {
                        hVar2.a(hVar);
                        if (ATOMIC_HELPER.c(this, hVar, hVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof f))) {
                                        return getDoneValue(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    removeWaiter(hVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            removeWaiter(hVar2);
                        } else {
                            hVar = this.waiters;
                        }
                    } while (hVar != h.f3625c);
                }
                return getDoneValue(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof f))) {
                    return getDoneValue(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractResolvableFuture = toString();
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
            throw new TimeoutException(str + " for " + abstractResolvableFuture);
        }
        throw new InterruptedException();
    }

    /* access modifiers changed from: protected */
    public void interruptTask() {
    }

    public final boolean isCancelled() {
        return this.value instanceof c;
    }

    public final boolean isDone() {
        boolean z10;
        Object obj = this.value;
        if (obj != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return (!(obj instanceof f)) & z10;
    }

    /* access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(Future<?> future) {
        boolean z10;
        if (future != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* access modifiers changed from: protected */
    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof f) {
            return "setFuture=[" + userObjectToString(((f) obj).f3624b) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    /* access modifiers changed from: protected */
    public boolean set(V v10) {
        if (v10 == null) {
            v10 = NULL;
        }
        if (!ATOMIC_HELPER.b(this, (Object) null, v10)) {
            return false;
        }
        complete(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setException(Throwable th2) {
        if (!ATOMIC_HELPER.b(this, (Object) null, new Failure((Throwable) checkNotNull(th2)))) {
            return false;
        }
        complete(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setFuture(zf.a<? extends V> aVar) {
        f fVar;
        Failure failure;
        checkNotNull(aVar);
        Object obj = this.value;
        if (obj == null) {
            if (aVar.isDone()) {
                if (!ATOMIC_HELPER.b(this, (Object) null, getFutureValue(aVar))) {
                    return false;
                }
                complete(this);
                return true;
            }
            fVar = new f(this, aVar);
            if (ATOMIC_HELPER.b(this, (Object) null, fVar)) {
                try {
                    aVar.addListener(fVar, DirectExecutor.INSTANCE);
                } catch (Throwable unused) {
                    failure = Failure.f3608b;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            aVar.cancel(((c) obj).f3612a);
        }
        return false;
        ATOMIC_HELPER.b(this, fVar, failure);
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
            addDoneString(sb2);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e10) {
                str = "Exception thrown from implementation: " + e10.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(str);
                sb2.append("]");
            } else if (isDone()) {
                addDoneString(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        if (!(obj instanceof c) || !((c) obj).f3612a) {
            return false;
        }
        return true;
    }

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof f))) {
                return getDoneValue(obj2);
            }
            h hVar = this.waiters;
            if (hVar != h.f3625c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (ATOMIC_HELPER.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return getDoneValue(obj);
                    }
                    hVar = this.waiters;
                } while (hVar != h.f3625c);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
