package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.x0;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import u.c;

final class q0 extends o0 {

    /* renamed from: t  reason: collision with root package name */
    final Executor f2868t;

    /* renamed from: u  reason: collision with root package name */
    private final Object f2869u = new Object();

    /* renamed from: v  reason: collision with root package name */
    o1 f2870v;

    /* renamed from: w  reason: collision with root package name */
    private b f2871w;

    class a implements c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f2872a;

        a(b bVar) {
            this.f2872a = bVar;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
        }

        public void onFailure(@NonNull Throwable th2) {
            this.f2872a.close();
        }
    }

    static class b extends h0 {

        /* renamed from: d  reason: collision with root package name */
        final WeakReference<q0> f2874d;

        b(@NonNull o1 o1Var, @NonNull q0 q0Var) {
            super(o1Var);
            this.f2874d = new WeakReference<>(q0Var);
            a(new r0(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(o1 o1Var) {
            q0 q0Var = this.f2874d.get();
            if (q0Var != null) {
                q0Var.f2868t.execute(new s0(q0Var));
            }
        }
    }

    q0(Executor executor) {
        this.f2868t = executor;
    }

    /* access modifiers changed from: package-private */
    public o1 d(@NonNull x0 x0Var) {
        return x0Var.b();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        synchronized (this.f2869u) {
            o1 o1Var = this.f2870v;
            if (o1Var != null) {
                o1Var.close();
                this.f2870v = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(@androidx.annotation.NonNull androidx.camera.core.o1 r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f2869u
            monitor-enter(r0)
            boolean r1 = r5.f2850s     // Catch:{ all -> 0x004e }
            if (r1 != 0) goto L_0x000c
            r6.close()     // Catch:{ all -> 0x004e }
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return
        L_0x000c:
            androidx.camera.core.q0$b r1 = r5.f2871w     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0035
            androidx.camera.core.l1 r1 = r6.z1()     // Catch:{ all -> 0x004e }
            long r1 = r1.getTimestamp()     // Catch:{ all -> 0x004e }
            androidx.camera.core.q0$b r3 = r5.f2871w     // Catch:{ all -> 0x004e }
            androidx.camera.core.l1 r3 = r3.z1()     // Catch:{ all -> 0x004e }
            long r3 = r3.getTimestamp()     // Catch:{ all -> 0x004e }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x002a
            r6.close()     // Catch:{ all -> 0x004e }
            goto L_0x0033
        L_0x002a:
            androidx.camera.core.o1 r1 = r5.f2870v     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x0031:
            r5.f2870v = r6     // Catch:{ all -> 0x004e }
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return
        L_0x0035:
            androidx.camera.core.q0$b r1 = new androidx.camera.core.q0$b     // Catch:{ all -> 0x004e }
            r1.<init>(r6, r5)     // Catch:{ all -> 0x004e }
            r5.f2871w = r1     // Catch:{ all -> 0x004e }
            zf.a r6 = r5.e(r1)     // Catch:{ all -> 0x004e }
            androidx.camera.core.q0$a r2 = new androidx.camera.core.q0$a     // Catch:{ all -> 0x004e }
            r2.<init>(r1)     // Catch:{ all -> 0x004e }
            java.util.concurrent.Executor r1 = androidx.camera.core.impl.utils.executor.a.a()     // Catch:{ all -> 0x004e }
            u.f.b(r6, r2, r1)     // Catch:{ all -> 0x004e }
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return
        L_0x004e:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.q0.o(androidx.camera.core.o1):void");
    }

    /* access modifiers changed from: package-private */
    public void z() {
        synchronized (this.f2869u) {
            this.f2871w = null;
            o1 o1Var = this.f2870v;
            if (o1Var != null) {
                this.f2870v = null;
                o(o1Var);
            }
        }
    }
}
