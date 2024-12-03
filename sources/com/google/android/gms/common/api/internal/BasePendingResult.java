package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.base.zau;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends j> extends f<R> {
    static final ThreadLocal zaa = new j3();
    public static final /* synthetic */ int zad = 0;
    @KeepName
    private l3 mResultGuardian;
    @NonNull
    protected final a zab;
    @NonNull
    protected final WeakReference zac;
    private final Object zae;
    private final CountDownLatch zaf;
    private final ArrayList zag;
    private k zah;
    private final AtomicReference zai;
    /* access modifiers changed from: private */
    public j zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private com.google.android.gms.common.internal.j zao;
    private volatile u2 zap;
    private boolean zaq;

    @Deprecated
    BasePendingResult() {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList();
        this.zai = new AtomicReference();
        this.zaq = false;
        this.zab = new a(Looper.getMainLooper());
        this.zac = new WeakReference((Object) null);
    }

    private final j zaa() {
        j jVar;
        synchronized (this.zae) {
            p.p(!this.zal, "Result has already been consumed.");
            p.p(isReady(), "Result is not ready.");
            jVar = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        v2 v2Var = (v2) this.zai.getAndSet((Object) null);
        if (v2Var != null) {
            v2Var.f38789a.f38795a.remove(this);
        }
        return (j) p.k(jVar);
    }

    private final void zab(j jVar) {
        this.zaj = jVar;
        this.zak = jVar.getStatus();
        this.zao = null;
        this.zaf.countDown();
        if (this.zam) {
            this.zah = null;
        } else {
            k kVar = this.zah;
            if (kVar != null) {
                this.zab.removeMessages(2);
                this.zab.a(kVar, zaa());
            } else if (this.zaj instanceof h) {
                this.mResultGuardian = new l3(this, (k3) null);
            }
        }
        ArrayList arrayList = this.zag;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((f.a) arrayList.get(i10)).a(this.zak);
        }
        this.zag.clear();
    }

    public static void zal(j jVar) {
        if (jVar instanceof h) {
            try {
                ((h) jVar).release();
            } catch (RuntimeException unused) {
                "Unable to release ".concat(String.valueOf(jVar));
            }
        }
    }

    public final void addStatusListener(@NonNull f.a aVar) {
        boolean z10;
        if (aVar != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.b(z10, "Callback cannot be null.");
        synchronized (this.zae) {
            if (isReady()) {
                aVar.a(this.zak);
            } else {
                this.zag.add(aVar);
            }
        }
    }

    @NonNull
    public final R await() {
        p.j("await must not be called on the UI thread");
        boolean z10 = true;
        p.p(!this.zal, "Result has already been consumed");
        if (this.zap != null) {
            z10 = false;
        }
        p.p(z10, "Cannot await if then() has been called.");
        try {
            this.zaf.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f38501h);
        }
        p.p(isReady(), "Result is not ready.");
        return zaa();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|(2:10|11)|12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.zae
            monitor-enter(r0)
            boolean r1 = r2.zam     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0026
            boolean r1 = r2.zal     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0026
        L_0x000c:
            com.google.android.gms.common.internal.j r1 = r2.zao     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0013
            r1.cancel()     // Catch:{ RemoteException -> 0x0013 }
        L_0x0013:
            com.google.android.gms.common.api.j r1 = r2.zaj     // Catch:{ all -> 0x0028 }
            zal(r1)     // Catch:{ all -> 0x0028 }
            r1 = 1
            r2.zam = r1     // Catch:{ all -> 0x0028 }
            com.google.android.gms.common.api.Status r1 = com.google.android.gms.common.api.Status.f38504l     // Catch:{ all -> 0x0028 }
            com.google.android.gms.common.api.j r1 = r2.createFailedResult(r1)     // Catch:{ all -> 0x0028 }
            r2.zab(r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0026:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0028:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.cancel():void");
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract R createFailedResult(@NonNull Status status);

    @Deprecated
    public final void forceFailureUnlessReady(@NonNull Status status) {
        synchronized (this.zae) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zan = true;
            }
        }
    }

    public final boolean isCanceled() {
        boolean z10;
        synchronized (this.zae) {
            z10 = this.zam;
        }
        return z10;
    }

    public final boolean isReady() {
        return this.zaf.getCount() == 0;
    }

    /* access modifiers changed from: protected */
    public final void setCancelToken(@NonNull com.google.android.gms.common.internal.j jVar) {
        synchronized (this.zae) {
            this.zao = jVar;
        }
    }

    public final void setResult(@NonNull R r10) {
        synchronized (this.zae) {
            if (this.zan || this.zam) {
                zal(r10);
                return;
            }
            isReady();
            p.p(!isReady(), "Results have already been set");
            p.p(!this.zal, "Result has already been consumed");
            zab(r10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.k<? super R> r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zae
            monitor-enter(r0)
            if (r5 != 0) goto L_0x000a
            r5 = 0
            r4.zah = r5     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x000a:
            boolean r1 = r4.zal     // Catch:{ all -> 0x003a }
            r2 = 1
            r1 = r1 ^ r2
            java.lang.String r3 = "Result has already been consumed."
            com.google.android.gms.common.internal.p.p(r1, r3)     // Catch:{ all -> 0x003a }
            com.google.android.gms.common.api.internal.u2 r1 = r4.zap     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.p.p(r2, r1)     // Catch:{ all -> 0x003a }
            boolean r1 = r4.isCanceled()     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0026
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x0026:
            boolean r1 = r4.isReady()     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0036
            com.google.android.gms.common.api.internal.BasePendingResult$a r1 = r4.zab     // Catch:{ all -> 0x003a }
            com.google.android.gms.common.api.j r2 = r4.zaa()     // Catch:{ all -> 0x003a }
            r1.a(r5, r2)     // Catch:{ all -> 0x003a }
            goto L_0x0038
        L_0x0036:
            r4.zah = r5     // Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.k):void");
    }

    @NonNull
    public final <S extends j> n<S> then(@NonNull m<? super R, ? extends S> mVar) {
        boolean z10;
        n<S> b10;
        p.p(!this.zal, "Result has already been consumed.");
        synchronized (this.zae) {
            boolean z11 = false;
            if (this.zap == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            p.p(z10, "Cannot call then() twice.");
            if (this.zah == null) {
                z11 = true;
            }
            p.p(z11, "Cannot call then() if callbacks are set.");
            p.p(!this.zam, "Cannot call then() if result was canceled.");
            this.zaq = true;
            this.zap = new u2(this.zac);
            b10 = this.zap.b(mVar);
            if (isReady()) {
                this.zab.a(this.zap, zaa());
            } else {
                this.zah = this.zap;
            }
        }
        return b10;
    }

    public final void zak() {
        boolean z10 = true;
        if (!this.zaq && !((Boolean) zaa.get()).booleanValue()) {
            z10 = false;
        }
        this.zaq = z10;
    }

    public final boolean zam() {
        boolean isCanceled;
        synchronized (this.zae) {
            if (((d) this.zac.get()) == null || !this.zaq) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zan(v2 v2Var) {
        this.zai.set(v2Var);
    }

    public static class a<R extends j> extends zau {
        public a() {
            super(Looper.getMainLooper());
        }

        public final void a(@NonNull k kVar, @NonNull j jVar) {
            int i10 = BasePendingResult.zad;
            sendMessage(obtainMessage(1, new Pair((k) p.k(kVar), jVar)));
        }

        public final void handleMessage(@NonNull Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                Pair pair = (Pair) message.obj;
                k kVar = (k) pair.first;
                j jVar = (j) pair.second;
                try {
                    kVar.a(jVar);
                } catch (RuntimeException e10) {
                    BasePendingResult.zal(jVar);
                    throw e10;
                }
            } else if (i10 != 2) {
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + i10, new Exception());
            } else {
                ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.f38503k);
            }
        }

        public a(@NonNull Looper looper) {
            super(looper);
        }
    }

    @Deprecated
    protected BasePendingResult(@NonNull Looper looper) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList();
        this.zai = new AtomicReference();
        this.zaq = false;
        this.zab = new a(looper);
        this.zac = new WeakReference((Object) null);
    }

    @NonNull
    public final R await(long j10, @NonNull TimeUnit timeUnit) {
        if (j10 > 0) {
            p.j("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z10 = true;
        p.p(!this.zal, "Result has already been consumed.");
        if (this.zap != null) {
            z10 = false;
        }
        p.p(z10, "Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(j10, timeUnit)) {
                forceFailureUnlessReady(Status.f38503k);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f38501h);
        }
        p.p(isReady(), "Result is not ready.");
        return zaa();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(@androidx.annotation.NonNull com.google.android.gms.common.api.k<? super R> r5, long r6, @androidx.annotation.NonNull java.util.concurrent.TimeUnit r8) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zae
            monitor-enter(r0)
            if (r5 != 0) goto L_0x000a
            r5 = 0
            r4.zah = r5     // Catch:{ all -> 0x0048 }
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000a:
            boolean r1 = r4.zal     // Catch:{ all -> 0x0048 }
            r2 = 1
            r1 = r1 ^ r2
            java.lang.String r3 = "Result has already been consumed."
            com.google.android.gms.common.internal.p.p(r1, r3)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.common.api.internal.u2 r1 = r4.zap     // Catch:{ all -> 0x0048 }
            if (r1 != 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.p.p(r2, r1)     // Catch:{ all -> 0x0048 }
            boolean r1 = r4.isCanceled()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0026
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0026:
            boolean r1 = r4.isReady()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0036
            com.google.android.gms.common.api.internal.BasePendingResult$a r6 = r4.zab     // Catch:{ all -> 0x0048 }
            com.google.android.gms.common.api.j r7 = r4.zaa()     // Catch:{ all -> 0x0048 }
            r6.a(r5, r7)     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0036:
            r4.zah = r5     // Catch:{ all -> 0x0048 }
            com.google.android.gms.common.api.internal.BasePendingResult$a r5 = r4.zab     // Catch:{ all -> 0x0048 }
            long r6 = r8.toMillis(r6)     // Catch:{ all -> 0x0048 }
            r8 = 2
            android.os.Message r8 = r5.obtainMessage(r8, r4)     // Catch:{ all -> 0x0048 }
            r5.sendMessageDelayed(r8, r6)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.k, long, java.util.concurrent.TimeUnit):void");
    }

    protected BasePendingResult(d dVar) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList();
        this.zai = new AtomicReference();
        this.zaq = false;
        this.zab = new a(dVar != null ? dVar.l() : Looper.getMainLooper());
        this.zac = new WeakReference(dVar);
    }

    protected BasePendingResult(@NonNull a<R> aVar) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList();
        this.zai = new AtomicReference();
        this.zaq = false;
        this.zab = (a) p.l(aVar, "CallbackHandler must not be null");
        this.zac = new WeakReference((Object) null);
    }
}
