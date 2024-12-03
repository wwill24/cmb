package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.l;
import androidx.camera.core.v1;
import androidx.core.util.h;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f2452a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private final Object f2453b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final int f2454c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<l, a> f2455d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private int f2456e;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private CameraInternal.State f2457a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f2458b;

        /* renamed from: c  reason: collision with root package name */
        private final b f2459c;

        a(CameraInternal.State state, @NonNull Executor executor, @NonNull b bVar) {
            this.f2457a = state;
            this.f2458b = executor;
            this.f2459c = bVar;
        }

        /* access modifiers changed from: package-private */
        public CameraInternal.State a() {
            return this.f2457a;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            try {
                Executor executor = this.f2458b;
                b bVar = this.f2459c;
                Objects.requireNonNull(bVar);
                executor.execute(new z(bVar));
            } catch (RejectedExecutionException e10) {
                v1.d("CameraStateRegistry", "Unable to notify camera.", e10);
            }
        }

        /* access modifiers changed from: package-private */
        public CameraInternal.State c(CameraInternal.State state) {
            CameraInternal.State state2 = this.f2457a;
            this.f2457a = state;
            return state2;
        }
    }

    public interface b {
        void a();
    }

    public a0(int i10) {
        this.f2454c = i10;
        synchronized ("mLock") {
            this.f2456e = i10;
        }
    }

    private static boolean b(CameraInternal.State state) {
        return state != null && state.a();
    }

    private void d() {
        String str;
        if (v1.f("CameraStateRegistry")) {
            this.f2452a.setLength(0);
            this.f2452a.append("Recalculating open cameras:\n");
            this.f2452a.append(String.format(Locale.US, "%-45s%-22s\n", new Object[]{"Camera", "State"}));
            this.f2452a.append("-------------------------------------------------------------------\n");
        }
        int i10 = 0;
        for (Map.Entry next : this.f2455d.entrySet()) {
            if (v1.f("CameraStateRegistry")) {
                if (((a) next.getValue()).a() != null) {
                    str = ((a) next.getValue()).a().toString();
                } else {
                    str = IdentityHttpResponse.UNKNOWN;
                }
                this.f2452a.append(String.format(Locale.US, "%-45s%-22s\n", new Object[]{((l) next.getKey()).toString(), str}));
            }
            if (b(((a) next.getValue()).a())) {
                i10++;
            }
        }
        if (v1.f("CameraStateRegistry")) {
            this.f2452a.append("-------------------------------------------------------------------\n");
            this.f2452a.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", new Object[]{Integer.valueOf(i10), Integer.valueOf(this.f2454c)}));
            v1.a("CameraStateRegistry", this.f2452a.toString());
        }
        this.f2456e = Math.max(this.f2454c - i10, 0);
    }

    private CameraInternal.State g(l lVar) {
        a remove = this.f2455d.remove(lVar);
        if (remove == null) {
            return null;
        }
        d();
        return remove.a();
    }

    private CameraInternal.State h(@NonNull l lVar, @NonNull CameraInternal.State state) {
        boolean z10;
        CameraInternal.State c10 = ((a) h.h(this.f2455d.get(lVar), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).c(state);
        CameraInternal.State state2 = CameraInternal.State.OPENING;
        if (state == state2) {
            if (b(state) || c10 == state2) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.j(z10, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
        }
        if (c10 != state) {
            d();
        }
        return c10;
    }

    public boolean a() {
        synchronized (this.f2453b) {
            for (Map.Entry<l, a> value : this.f2455d.entrySet()) {
                if (((a) value.getValue()).a() == CameraInternal.State.CLOSING) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0078, code lost:
        if (r7 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007a, code lost:
        r6 = r7.values().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0086, code lost:
        if (r6.hasNext() == false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0088, code lost:
        ((androidx.camera.core.impl.a0.a) r6.next()).b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(@androidx.annotation.NonNull androidx.camera.core.l r6, @androidx.annotation.NonNull androidx.camera.core.impl.CameraInternal.State r7, boolean r8) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f2453b
            monitor-enter(r0)
            int r1 = r5.f2456e     // Catch:{ all -> 0x0093 }
            androidx.camera.core.impl.CameraInternal$State r2 = androidx.camera.core.impl.CameraInternal.State.RELEASED     // Catch:{ all -> 0x0093 }
            if (r7 != r2) goto L_0x000e
            androidx.camera.core.impl.CameraInternal$State r2 = r5.g(r6)     // Catch:{ all -> 0x0093 }
            goto L_0x0012
        L_0x000e:
            androidx.camera.core.impl.CameraInternal$State r2 = r5.h(r6, r7)     // Catch:{ all -> 0x0093 }
        L_0x0012:
            if (r2 != r7) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            return
        L_0x0016:
            r2 = 1
            if (r1 >= r2) goto L_0x0056
            int r1 = r5.f2456e     // Catch:{ all -> 0x0093 }
            if (r1 <= 0) goto L_0x0056
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0093 }
            r7.<init>()     // Catch:{ all -> 0x0093 }
            java.util.Map<androidx.camera.core.l, androidx.camera.core.impl.a0$a> r1 = r5.f2455d     // Catch:{ all -> 0x0093 }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x0093 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0093 }
        L_0x002c:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0093 }
            if (r2 == 0) goto L_0x0070
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0093 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0093 }
            java.lang.Object r3 = r2.getValue()     // Catch:{ all -> 0x0093 }
            androidx.camera.core.impl.a0$a r3 = (androidx.camera.core.impl.a0.a) r3     // Catch:{ all -> 0x0093 }
            androidx.camera.core.impl.CameraInternal$State r3 = r3.a()     // Catch:{ all -> 0x0093 }
            androidx.camera.core.impl.CameraInternal$State r4 = androidx.camera.core.impl.CameraInternal.State.PENDING_OPEN     // Catch:{ all -> 0x0093 }
            if (r3 != r4) goto L_0x002c
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x0093 }
            androidx.camera.core.l r3 = (androidx.camera.core.l) r3     // Catch:{ all -> 0x0093 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0093 }
            androidx.camera.core.impl.a0$a r2 = (androidx.camera.core.impl.a0.a) r2     // Catch:{ all -> 0x0093 }
            r7.put(r3, r2)     // Catch:{ all -> 0x0093 }
            goto L_0x002c
        L_0x0056:
            androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.PENDING_OPEN     // Catch:{ all -> 0x0093 }
            if (r7 != r1) goto L_0x006f
            int r7 = r5.f2456e     // Catch:{ all -> 0x0093 }
            if (r7 <= 0) goto L_0x006f
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0093 }
            r7.<init>()     // Catch:{ all -> 0x0093 }
            java.util.Map<androidx.camera.core.l, androidx.camera.core.impl.a0$a> r1 = r5.f2455d     // Catch:{ all -> 0x0093 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0093 }
            androidx.camera.core.impl.a0$a r1 = (androidx.camera.core.impl.a0.a) r1     // Catch:{ all -> 0x0093 }
            r7.put(r6, r1)     // Catch:{ all -> 0x0093 }
            goto L_0x0070
        L_0x006f:
            r7 = 0
        L_0x0070:
            if (r7 == 0) goto L_0x0077
            if (r8 != 0) goto L_0x0077
            r7.remove(r6)     // Catch:{ all -> 0x0093 }
        L_0x0077:
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            if (r7 == 0) goto L_0x0092
            java.util.Collection r6 = r7.values()
            java.util.Iterator r6 = r6.iterator()
        L_0x0082:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0092
            java.lang.Object r7 = r6.next()
            androidx.camera.core.impl.a0$a r7 = (androidx.camera.core.impl.a0.a) r7
            r7.b()
            goto L_0x0082
        L_0x0092:
            return
        L_0x0093:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.a0.c(androidx.camera.core.l, androidx.camera.core.impl.CameraInternal$State, boolean):void");
    }

    public void e(@NonNull l lVar, @NonNull Executor executor, @NonNull b bVar) {
        boolean z10;
        synchronized (this.f2453b) {
            if (!this.f2455d.containsKey(lVar)) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.j(z10, "Camera is already registered: " + lVar);
            this.f2455d.put(lVar, new a((CameraInternal.State) null, executor, bVar));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f(@androidx.annotation.NonNull androidx.camera.core.l r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f2453b
            monitor-enter(r0)
            java.util.Map<androidx.camera.core.l, androidx.camera.core.impl.a0$a> r1 = r9.f2455d     // Catch:{ all -> 0x009b }
            java.lang.Object r1 = r1.get(r10)     // Catch:{ all -> 0x009b }
            androidx.camera.core.impl.a0$a r1 = (androidx.camera.core.impl.a0.a) r1     // Catch:{ all -> 0x009b }
            java.lang.String r2 = "Camera must first be registered with registerCamera()"
            java.lang.Object r1 = androidx.core.util.h.h(r1, r2)     // Catch:{ all -> 0x009b }
            androidx.camera.core.impl.a0$a r1 = (androidx.camera.core.impl.a0.a) r1     // Catch:{ all -> 0x009b }
            java.lang.String r2 = "CameraStateRegistry"
            boolean r2 = androidx.camera.core.v1.f(r2)     // Catch:{ all -> 0x009b }
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0052
            java.lang.StringBuilder r2 = r9.f2452a     // Catch:{ all -> 0x009b }
            r2.setLength(r4)     // Catch:{ all -> 0x009b }
            java.lang.StringBuilder r2 = r9.f2452a     // Catch:{ all -> 0x009b }
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ all -> 0x009b }
            java.lang.String r6 = "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]"
            r7 = 4
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x009b }
            r7[r4] = r10     // Catch:{ all -> 0x009b }
            int r10 = r9.f2456e     // Catch:{ all -> 0x009b }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x009b }
            r7[r3] = r10     // Catch:{ all -> 0x009b }
            r10 = 2
            androidx.camera.core.impl.CameraInternal$State r8 = r1.a()     // Catch:{ all -> 0x009b }
            boolean r8 = b(r8)     // Catch:{ all -> 0x009b }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x009b }
            r7[r10] = r8     // Catch:{ all -> 0x009b }
            r10 = 3
            androidx.camera.core.impl.CameraInternal$State r8 = r1.a()     // Catch:{ all -> 0x009b }
            r7[r10] = r8     // Catch:{ all -> 0x009b }
            java.lang.String r10 = java.lang.String.format(r5, r6, r7)     // Catch:{ all -> 0x009b }
            r2.append(r10)     // Catch:{ all -> 0x009b }
        L_0x0052:
            int r10 = r9.f2456e     // Catch:{ all -> 0x009b }
            if (r10 > 0) goto L_0x0063
            androidx.camera.core.impl.CameraInternal$State r10 = r1.a()     // Catch:{ all -> 0x009b }
            boolean r10 = b(r10)     // Catch:{ all -> 0x009b }
            if (r10 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r10 = r4
            goto L_0x0069
        L_0x0063:
            androidx.camera.core.impl.CameraInternal$State r10 = androidx.camera.core.impl.CameraInternal.State.OPENING     // Catch:{ all -> 0x009b }
            r1.c(r10)     // Catch:{ all -> 0x009b }
            r10 = r3
        L_0x0069:
            java.lang.String r1 = "CameraStateRegistry"
            boolean r1 = androidx.camera.core.v1.f(r1)     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x0094
            java.lang.StringBuilder r1 = r9.f2452a     // Catch:{ all -> 0x009b }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ all -> 0x009b }
            java.lang.String r5 = " --> %s"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x009b }
            if (r10 == 0) goto L_0x007e
            java.lang.String r6 = "SUCCESS"
            goto L_0x0080
        L_0x007e:
            java.lang.String r6 = "FAIL"
        L_0x0080:
            r3[r4] = r6     // Catch:{ all -> 0x009b }
            java.lang.String r2 = java.lang.String.format(r2, r5, r3)     // Catch:{ all -> 0x009b }
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.String r1 = "CameraStateRegistry"
            java.lang.StringBuilder r2 = r9.f2452a     // Catch:{ all -> 0x009b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x009b }
            androidx.camera.core.v1.a(r1, r2)     // Catch:{ all -> 0x009b }
        L_0x0094:
            if (r10 == 0) goto L_0x0099
            r9.d()     // Catch:{ all -> 0x009b }
        L_0x0099:
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            return r10
        L_0x009b:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.a0.f(androidx.camera.core.l):boolean");
    }
}
