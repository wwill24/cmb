package com.jakewharton.rxrelay2;

import androidx.camera.view.h;
import com.jakewharton.rxrelay2.a;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import qj.u;

public final class b<T> extends c<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final Object[] f22163f = new Object[0];

    /* renamed from: g  reason: collision with root package name */
    static final a[] f22164g = new a[0];

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<T> f22165a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<a<T>[]> f22166b;

    /* renamed from: c  reason: collision with root package name */
    final Lock f22167c;

    /* renamed from: d  reason: collision with root package name */
    final Lock f22168d;

    /* renamed from: e  reason: collision with root package name */
    long f22169e;

    static final class a<T> implements tj.b, a.C0252a<T> {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f22170a;

        /* renamed from: b  reason: collision with root package name */
        final b<T> f22171b;

        /* renamed from: c  reason: collision with root package name */
        boolean f22172c;

        /* renamed from: d  reason: collision with root package name */
        boolean f22173d;

        /* renamed from: e  reason: collision with root package name */
        a<T> f22174e;

        /* renamed from: f  reason: collision with root package name */
        boolean f22175f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f22176g;

        /* renamed from: h  reason: collision with root package name */
        long f22177h;

        a(u<? super T> uVar, b<T> bVar) {
            this.f22170a = uVar;
            this.f22171b = bVar;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
            test(r0);
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                boolean r0 = r4.f22176g
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.f22176g     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                return
            L_0x000c:
                boolean r0 = r4.f22172c     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                return
            L_0x0012:
                com.jakewharton.rxrelay2.b<T> r0 = r4.f22171b     // Catch:{ all -> 0x003a }
                java.util.concurrent.locks.Lock r1 = r0.f22167c     // Catch:{ all -> 0x003a }
                r1.lock()     // Catch:{ all -> 0x003a }
                long r2 = r0.f22169e     // Catch:{ all -> 0x003a }
                r4.f22177h = r2     // Catch:{ all -> 0x003a }
                java.util.concurrent.atomic.AtomicReference<T> r0 = r0.f22165a     // Catch:{ all -> 0x003a }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003a }
                r1.unlock()     // Catch:{ all -> 0x003a }
                r1 = 1
                if (r0 == 0) goto L_0x002b
                r2 = r1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                r4.f22173d = r2     // Catch:{ all -> 0x003a }
                r4.f22172c = r1     // Catch:{ all -> 0x003a }
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x0039
                r4.test(r0)
                r4.b()
            L_0x0039:
                return
            L_0x003a:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.rxrelay2.b.a.a():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.c(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.f22176g
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                com.jakewharton.rxrelay2.a<T> r0 = r2.f22174e     // Catch:{ all -> 0x0017 }
                if (r0 != 0) goto L_0x000f
                r0 = 0
                r2.f22173d = r0     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x000f:
                r1 = 0
                r2.f22174e = r1     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                r0.c(r2)
                goto L_0x0000
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.rxrelay2.b.a.b():void");
        }

        public boolean c() {
            return this.f22176g;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r2.f22175f = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(T r3, long r4) {
            /*
                r2 = this;
                boolean r0 = r2.f22176g
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r2.f22175f
                if (r0 != 0) goto L_0x0037
                monitor-enter(r2)
                boolean r0 = r2.f22176g     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0010:
                long r0 = r2.f22177h     // Catch:{ all -> 0x0034 }
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 != 0) goto L_0x0018
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0018:
                boolean r4 = r2.f22173d     // Catch:{ all -> 0x0034 }
                if (r4 == 0) goto L_0x002d
                com.jakewharton.rxrelay2.a<T> r4 = r2.f22174e     // Catch:{ all -> 0x0034 }
                if (r4 != 0) goto L_0x0028
                com.jakewharton.rxrelay2.a r4 = new com.jakewharton.rxrelay2.a     // Catch:{ all -> 0x0034 }
                r5 = 4
                r4.<init>(r5)     // Catch:{ all -> 0x0034 }
                r2.f22174e = r4     // Catch:{ all -> 0x0034 }
            L_0x0028:
                r4.b(r3)     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x002d:
                r4 = 1
                r2.f22172c = r4     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                r2.f22175f = r4
                goto L_0x0037
            L_0x0034:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                throw r3
            L_0x0037:
                r2.test(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.rxrelay2.b.a.d(java.lang.Object, long):void");
        }

        public void dispose() {
            if (!this.f22176g) {
                this.f22176g = true;
                this.f22171b.G0(this);
            }
        }

        public boolean test(T t10) {
            if (this.f22176g) {
                return false;
            }
            this.f22170a.d(t10);
            return false;
        }
    }

    b() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f22167c = reentrantReadWriteLock.readLock();
        this.f22168d = reentrantReadWriteLock.writeLock();
        this.f22166b = new AtomicReference<>(f22164g);
        this.f22165a = new AtomicReference<>();
    }

    public static <T> b<T> C0() {
        return new b<>();
    }

    public static <T> b<T> D0(T t10) {
        return new b<>(t10);
    }

    /* access modifiers changed from: package-private */
    public void B0(a<T> aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f22166b.get();
            int length = aVarArr.length;
            aVarArr2 = new a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!h.a(this.f22166b, aVarArr, aVarArr2));
    }

    public T E0() {
        return this.f22165a.get();
    }

    public boolean F0() {
        return this.f22165a.get() != null;
    }

    /* access modifiers changed from: package-private */
    public void G0(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f22166b.get();
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
                        aVarArr2 = f22164g;
                    } else {
                        a[] aVarArr3 = new a[(length - 1)];
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
        } while (!h.a(this.f22166b, aVarArr, aVarArr2));
    }

    /* access modifiers changed from: package-private */
    public void H0(T t10) {
        this.f22168d.lock();
        this.f22169e++;
        this.f22165a.lazySet(t10);
        this.f22168d.unlock();
    }

    public void accept(T t10) {
        if (t10 != null) {
            H0(t10);
            for (a d10 : (a[]) this.f22166b.get()) {
                d10.d(t10, this.f22169e);
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        a aVar = new a(uVar, this);
        uVar.a(aVar);
        B0(aVar);
        if (aVar.f22176g) {
            G0(aVar);
        } else {
            aVar.a();
        }
    }

    b(T t10) {
        this();
        if (t10 != null) {
            this.f22165a.lazySet(t10);
            return;
        }
        throw new NullPointerException("defaultValue == null");
    }
}
