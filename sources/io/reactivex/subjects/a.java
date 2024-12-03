package io.reactivex.subjects;

import androidx.camera.view.h;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import qj.u;
import tj.b;

public final class a<T> extends c<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final Object[] f30755h = new Object[0];

    /* renamed from: j  reason: collision with root package name */
    static final C0359a[] f30756j = new C0359a[0];

    /* renamed from: k  reason: collision with root package name */
    static final C0359a[] f30757k = new C0359a[0];

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<Object> f30758a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<C0359a<T>[]> f30759b;

    /* renamed from: c  reason: collision with root package name */
    final ReadWriteLock f30760c;

    /* renamed from: d  reason: collision with root package name */
    final Lock f30761d;

    /* renamed from: e  reason: collision with root package name */
    final Lock f30762e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<Throwable> f30763f;

    /* renamed from: g  reason: collision with root package name */
    long f30764g;

    /* renamed from: io.reactivex.subjects.a$a  reason: collision with other inner class name */
    static final class C0359a<T> implements b, a.C0358a<Object> {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30765a;

        /* renamed from: b  reason: collision with root package name */
        final a<T> f30766b;

        /* renamed from: c  reason: collision with root package name */
        boolean f30767c;

        /* renamed from: d  reason: collision with root package name */
        boolean f30768d;

        /* renamed from: e  reason: collision with root package name */
        io.reactivex.internal.util.a<Object> f30769e;

        /* renamed from: f  reason: collision with root package name */
        boolean f30770f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f30771g;

        /* renamed from: h  reason: collision with root package name */
        long f30772h;

        C0359a(u<? super T> uVar, a<T> aVar) {
            this.f30765a = uVar;
            this.f30766b = aVar;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            if (test(r0) == false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                boolean r0 = r4.f30771g
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.f30771g     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x000c:
                boolean r0 = r4.f30767c     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x0012:
                io.reactivex.subjects.a<T> r0 = r4.f30766b     // Catch:{ all -> 0x003e }
                java.util.concurrent.locks.Lock r1 = r0.f30761d     // Catch:{ all -> 0x003e }
                r1.lock()     // Catch:{ all -> 0x003e }
                long r2 = r0.f30764g     // Catch:{ all -> 0x003e }
                r4.f30772h = r2     // Catch:{ all -> 0x003e }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.f30758a     // Catch:{ all -> 0x003e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003e }
                r1.unlock()     // Catch:{ all -> 0x003e }
                r1 = 1
                if (r0 == 0) goto L_0x002b
                r2 = r1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                r4.f30768d = r2     // Catch:{ all -> 0x003e }
                r4.f30767c = r1     // Catch:{ all -> 0x003e }
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x003d
                boolean r0 = r4.test(r0)
                if (r0 == 0) goto L_0x003a
                return
            L_0x003a:
                r4.b()
            L_0x003d:
                return
            L_0x003e:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.a.C0359a.a():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.d(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.f30771g
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                io.reactivex.internal.util.a<java.lang.Object> r0 = r2.f30769e     // Catch:{ all -> 0x0017 }
                if (r0 != 0) goto L_0x000f
                r0 = 0
                r2.f30768d = r0     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x000f:
                r1 = 0
                r2.f30769e = r1     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                r0.d(r2)
                goto L_0x0000
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.a.C0359a.b():void");
        }

        public boolean c() {
            return this.f30771g;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r2.f30770f = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(java.lang.Object r3, long r4) {
            /*
                r2 = this;
                boolean r0 = r2.f30771g
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r2.f30770f
                if (r0 != 0) goto L_0x0037
                monitor-enter(r2)
                boolean r0 = r2.f30771g     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0010:
                long r0 = r2.f30772h     // Catch:{ all -> 0x0034 }
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 != 0) goto L_0x0018
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0018:
                boolean r4 = r2.f30768d     // Catch:{ all -> 0x0034 }
                if (r4 == 0) goto L_0x002d
                io.reactivex.internal.util.a<java.lang.Object> r4 = r2.f30769e     // Catch:{ all -> 0x0034 }
                if (r4 != 0) goto L_0x0028
                io.reactivex.internal.util.a r4 = new io.reactivex.internal.util.a     // Catch:{ all -> 0x0034 }
                r5 = 4
                r4.<init>(r5)     // Catch:{ all -> 0x0034 }
                r2.f30769e = r4     // Catch:{ all -> 0x0034 }
            L_0x0028:
                r4.c(r3)     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x002d:
                r4 = 1
                r2.f30767c = r4     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                r2.f30770f = r4
                goto L_0x0037
            L_0x0034:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                throw r3
            L_0x0037:
                r2.test(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.a.C0359a.d(java.lang.Object, long):void");
        }

        public void dispose() {
            if (!this.f30771g) {
                this.f30771g = true;
                this.f30766b.F0(this);
            }
        }

        public boolean test(Object obj) {
            return this.f30771g || NotificationLite.a(obj, this.f30765a);
        }
    }

    a() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f30760c = reentrantReadWriteLock;
        this.f30761d = reentrantReadWriteLock.readLock();
        this.f30762e = reentrantReadWriteLock.writeLock();
        this.f30759b = new AtomicReference<>(f30756j);
        this.f30758a = new AtomicReference<>();
        this.f30763f = new AtomicReference<>();
    }

    public static <T> a<T> C0() {
        return new a<>();
    }

    public static <T> a<T> D0(T t10) {
        return new a<>(t10);
    }

    /* access modifiers changed from: package-private */
    public boolean B0(C0359a<T> aVar) {
        C0359a[] aVarArr;
        C0359a[] aVarArr2;
        do {
            aVarArr = (C0359a[]) this.f30759b.get();
            if (aVarArr == f30757k) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new C0359a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!h.a(this.f30759b, aVarArr, aVarArr2));
        return true;
    }

    public T E0() {
        Object obj = this.f30758a.get();
        if (NotificationLite.k(obj) || NotificationLite.l(obj)) {
            return null;
        }
        return NotificationLite.j(obj);
    }

    /* access modifiers changed from: package-private */
    public void F0(C0359a<T> aVar) {
        C0359a<T>[] aVarArr;
        C0359a[] aVarArr2;
        do {
            aVarArr = (C0359a[]) this.f30759b.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (aVarArr[i11] == aVar) {
                        i10 = i11;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i10 >= 0) {
                    if (length == 1) {
                        aVarArr2 = f30756j;
                    } else {
                        C0359a[] aVarArr3 = new C0359a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i10);
                        System.arraycopy(aVarArr, i10 + 1, aVarArr3, i10, (length - i10) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!h.a(this.f30759b, aVarArr, aVarArr2));
    }

    /* access modifiers changed from: package-private */
    public void G0(Object obj) {
        this.f30762e.lock();
        this.f30764g++;
        this.f30758a.lazySet(obj);
        this.f30762e.unlock();
    }

    /* access modifiers changed from: package-private */
    public C0359a<T>[] H0(Object obj) {
        AtomicReference<C0359a<T>[]> atomicReference = this.f30759b;
        C0359a<T>[] aVarArr = f30757k;
        C0359a<T>[] aVarArr2 = (C0359a[]) atomicReference.getAndSet(aVarArr);
        if (aVarArr2 != aVarArr) {
            G0(obj);
        }
        return aVarArr2;
    }

    public void a(b bVar) {
        if (this.f30763f.get() != null) {
            bVar.dispose();
        }
    }

    public void d(T t10) {
        xj.b.e(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f30763f.get() == null) {
            Object o10 = NotificationLite.o(t10);
            G0(o10);
            for (C0359a d10 : (C0359a[]) this.f30759b.get()) {
                d10.d(o10, this.f30764g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        C0359a aVar = new C0359a(uVar, this);
        uVar.a(aVar);
        if (!B0(aVar)) {
            Throwable th2 = this.f30763f.get();
            if (th2 == ExceptionHelper.f30712a) {
                uVar.onComplete();
            } else {
                uVar.onError(th2);
            }
        } else if (aVar.f30771g) {
            F0(aVar);
        } else {
            aVar.a();
        }
    }

    public void onComplete() {
        if (h.a(this.f30763f, (Object) null, ExceptionHelper.f30712a)) {
            Object d10 = NotificationLite.d();
            for (C0359a d11 : H0(d10)) {
                d11.d(d10, this.f30764g);
            }
        }
    }

    public void onError(Throwable th2) {
        xj.b.e(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!h.a(this.f30763f, (Object) null, th2)) {
            bk.a.s(th2);
            return;
        }
        Object h10 = NotificationLite.h(th2);
        for (C0359a d10 : H0(h10)) {
            d10.d(h10, this.f30764g);
        }
    }

    a(T t10) {
        this();
        this.f30758a.lazySet(xj.b.e(t10, "defaultValue is null"));
    }
}
