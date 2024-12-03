package u;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

class h<V> implements zf.a<List<V>> {

    /* renamed from: a  reason: collision with root package name */
    List<? extends zf.a<? extends V>> f17932a;

    /* renamed from: b  reason: collision with root package name */
    List<V> f17933b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17934c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f17935d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final zf.a<List<V>> f17936e = CallbackToFutureAdapter.a(new a());

    /* renamed from: f  reason: collision with root package name */
    CallbackToFutureAdapter.a<List<V>> f17937f;

    class a implements CallbackToFutureAdapter.b<List<V>> {
        a() {
        }

        public Object a(@NonNull CallbackToFutureAdapter.a<List<V>> aVar) {
            boolean z10;
            if (h.this.f17937f == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            androidx.core.util.h.j(z10, "The result can only set once!");
            h.this.f17937f = aVar;
            return "ListFuture[" + this + "]";
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            h hVar = h.this;
            hVar.f17933b = null;
            hVar.f17932a = null;
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f17940a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ zf.a f17941b;

        c(int i10, zf.a aVar) {
            this.f17940a = i10;
            this.f17941b = aVar;
        }

        public void run() {
            h.this.e(this.f17940a, this.f17941b);
        }
    }

    h(@NonNull List<? extends zf.a<? extends V>> list, boolean z10, @NonNull Executor executor) {
        this.f17932a = (List) androidx.core.util.h.g(list);
        this.f17933b = new ArrayList(list.size());
        this.f17934c = z10;
        this.f17935d = new AtomicInteger(list.size());
        d(executor);
    }

    private void a() throws InterruptedException {
        List<? extends zf.a<? extends V>> list = this.f17932a;
        if (list != null && !isDone()) {
            for (zf.a aVar : list) {
                while (true) {
                    if (!aVar.isDone()) {
                        try {
                            aVar.get();
                        } catch (Error e10) {
                            throw e10;
                        } catch (InterruptedException e11) {
                            throw e11;
                        } catch (Throwable unused) {
                            if (this.f17934c) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private void d(@NonNull Executor executor) {
        addListener(new b(), androidx.camera.core.impl.utils.executor.a.a());
        if (this.f17932a.isEmpty()) {
            this.f17937f.c(new ArrayList(this.f17933b));
            return;
        }
        for (int i10 = 0; i10 < this.f17932a.size(); i10++) {
            this.f17933b.add((Object) null);
        }
        List<? extends zf.a<? extends V>> list = this.f17932a;
        for (int i11 = 0; i11 < list.size(); i11++) {
            zf.a aVar = (zf.a) list.get(i11);
            aVar.addListener(new c(i11, aVar), executor);
        }
    }

    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.f17936e.addListener(runnable, executor);
    }

    /* renamed from: b */
    public List<V> get() throws InterruptedException, ExecutionException {
        a();
        return this.f17936e.get();
    }

    /* renamed from: c */
    public List<V> get(long j10, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f17936e.get(j10, timeUnit);
    }

    public boolean cancel(boolean z10) {
        List<? extends zf.a<? extends V>> list = this.f17932a;
        if (list != null) {
            for (zf.a cancel : list) {
                cancel.cancel(z10);
            }
        }
        return this.f17936e.cancel(z10);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x00ba */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(int r7, @androidx.annotation.NonNull java.util.concurrent.Future<? extends V> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Less than 0 remaining futures"
            java.util.List<V> r1 = r6.f17933b
            boolean r2 = r6.isDone()
            if (r2 != 0) goto L_0x0104
            if (r1 != 0) goto L_0x000e
            goto L_0x0104
        L_0x000e:
            r2 = 1
            r3 = 0
            boolean r4 = r8.isDone()     // Catch:{ CancellationException -> 0x00ba, ExecutionException -> 0x0091, RuntimeException -> 0x006c, Error -> 0x004b }
            java.lang.String r5 = "Tried to set value from future which is not done"
            androidx.core.util.h.j(r4, r5)     // Catch:{ CancellationException -> 0x00ba, ExecutionException -> 0x0091, RuntimeException -> 0x006c, Error -> 0x004b }
            java.lang.Object r8 = u.f.e(r8)     // Catch:{ CancellationException -> 0x00ba, ExecutionException -> 0x0091, RuntimeException -> 0x006c, Error -> 0x004b }
            r1.set(r7, r8)     // Catch:{ CancellationException -> 0x00ba, ExecutionException -> 0x0091, RuntimeException -> 0x006c, Error -> 0x004b }
            java.util.concurrent.atomic.AtomicInteger r7 = r6.f17935d
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r2 = r3
        L_0x002a:
            androidx.core.util.h.j(r2, r0)
            if (r7 != 0) goto L_0x00dd
            java.util.List<V> r7 = r6.f17933b
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.util.List<V>> r8 = r6.f17937f
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
        L_0x003a:
            r8.c(r0)
            goto L_0x00dd
        L_0x003f:
            boolean r7 = r6.isDone()
            androidx.core.util.h.i(r7)
            goto L_0x00dd
        L_0x0048:
            r7 = move-exception
            goto L_0x00de
        L_0x004b:
            r7 = move-exception
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.util.List<V>> r8 = r6.f17937f     // Catch:{ all -> 0x0048 }
            r8.f(r7)     // Catch:{ all -> 0x0048 }
            java.util.concurrent.atomic.AtomicInteger r7 = r6.f17935d
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r2 = r3
        L_0x005b:
            androidx.core.util.h.j(r2, r0)
            if (r7 != 0) goto L_0x00dd
            java.util.List<V> r7 = r6.f17933b
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.util.List<V>> r8 = r6.f17937f
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x006c:
            r7 = move-exception
            boolean r8 = r6.f17934c     // Catch:{ all -> 0x0048 }
            if (r8 == 0) goto L_0x0076
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.util.List<V>> r8 = r6.f17937f     // Catch:{ all -> 0x0048 }
            r8.f(r7)     // Catch:{ all -> 0x0048 }
        L_0x0076:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.f17935d
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r2 = r3
        L_0x0080:
            androidx.core.util.h.j(r2, r0)
            if (r7 != 0) goto L_0x00dd
            java.util.List<V> r7 = r6.f17933b
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.util.List<V>> r8 = r6.f17937f
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x0091:
            r7 = move-exception
            boolean r8 = r6.f17934c     // Catch:{ all -> 0x0048 }
            if (r8 == 0) goto L_0x009f
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.util.List<V>> r8 = r6.f17937f     // Catch:{ all -> 0x0048 }
            java.lang.Throwable r7 = r7.getCause()     // Catch:{ all -> 0x0048 }
            r8.f(r7)     // Catch:{ all -> 0x0048 }
        L_0x009f:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.f17935d
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r2 = r3
        L_0x00a9:
            androidx.core.util.h.j(r2, r0)
            if (r7 != 0) goto L_0x00dd
            java.util.List<V> r7 = r6.f17933b
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.util.List<V>> r8 = r6.f17937f
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x00ba:
            boolean r7 = r6.f17934c     // Catch:{ all -> 0x0048 }
            if (r7 == 0) goto L_0x00c1
            r6.cancel(r3)     // Catch:{ all -> 0x0048 }
        L_0x00c1:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.f17935d
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x00ca
            goto L_0x00cb
        L_0x00ca:
            r2 = r3
        L_0x00cb:
            androidx.core.util.h.j(r2, r0)
            if (r7 != 0) goto L_0x00dd
            java.util.List<V> r7 = r6.f17933b
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.util.List<V>> r8 = r6.f17937f
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x00dd:
            return
        L_0x00de:
            java.util.concurrent.atomic.AtomicInteger r8 = r6.f17935d
            int r8 = r8.decrementAndGet()
            if (r8 < 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r2 = r3
        L_0x00e8:
            androidx.core.util.h.j(r2, r0)
            if (r8 != 0) goto L_0x0103
            java.util.List<V> r8 = r6.f17933b
            if (r8 == 0) goto L_0x00fc
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.util.List<V>> r0 = r6.f17937f
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r8)
            r0.c(r1)
            goto L_0x0103
        L_0x00fc:
            boolean r8 = r6.isDone()
            androidx.core.util.h.i(r8)
        L_0x0103:
            throw r7
        L_0x0104:
            boolean r7 = r6.f17934c
            java.lang.String r8 = "Future was done before all dependencies completed"
            androidx.core.util.h.j(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u.h.e(int, java.util.concurrent.Future):void");
    }

    public boolean isCancelled() {
        return this.f17936e.isCancelled();
    }

    public boolean isDone() {
        return this.f17936e.isDone();
    }
}
