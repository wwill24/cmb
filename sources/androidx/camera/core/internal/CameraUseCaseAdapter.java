package androidx.camera.core.internal;

import a0.a0;
import a0.g0;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraControl;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.f2;
import androidx.camera.core.h1;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.x;
import androidx.camera.core.k3;
import androidx.camera.core.l;
import androidx.camera.core.m;
import androidx.camera.core.q;
import androidx.camera.core.v1;
import androidx.camera.core.w2;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import v.d;
import v.e;
import v.k;

public final class CameraUseCaseAdapter implements l {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private CameraInternal f2720a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedHashSet<CameraInternal> f2721b;

    /* renamed from: c  reason: collision with root package name */
    private final v f2722c;

    /* renamed from: d  reason: collision with root package name */
    private final UseCaseConfigFactory f2723d;

    /* renamed from: e  reason: collision with root package name */
    private final a f2724e;

    /* renamed from: f  reason: collision with root package name */
    private final List<UseCase> f2725f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private k3 f2726g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private List<m> f2727h = Collections.emptyList();
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private r f2728j = u.a();

    /* renamed from: k  reason: collision with root package name */
    private final Object f2729k = new Object();

    /* renamed from: l  reason: collision with root package name */
    private boolean f2730l = true;

    /* renamed from: m  reason: collision with root package name */
    private Config f2731m = null;

    /* renamed from: n  reason: collision with root package name */
    private List<UseCase> f2732n = new ArrayList();

    public static final class CameraException extends Exception {
        public CameraException(@NonNull String str) {
            super(str);
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f2733a = new ArrayList();

        a(LinkedHashSet<CameraInternal> linkedHashSet) {
            Iterator<CameraInternal> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                this.f2733a.add(it.next().l().a());
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.f2733a.equals(((a) obj).f2733a);
            }
            return false;
        }

        public int hashCode() {
            return this.f2733a.hashCode() * 53;
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        f2<?> f2734a;

        /* renamed from: b  reason: collision with root package name */
        f2<?> f2735b;

        b(f2<?> f2Var, f2<?> f2Var2) {
            this.f2734a = f2Var;
            this.f2735b = f2Var2;
        }
    }

    public CameraUseCaseAdapter(@NonNull LinkedHashSet<CameraInternal> linkedHashSet, @NonNull v vVar, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        this.f2720a = linkedHashSet.iterator().next();
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>(linkedHashSet);
        this.f2721b = linkedHashSet2;
        this.f2724e = new a(linkedHashSet2);
        this.f2722c = vVar;
        this.f2723d = useCaseConfigFactory;
    }

    private boolean A() {
        boolean z10;
        synchronized (this.f2729k) {
            z10 = true;
            if (this.f2728j.t() != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    private boolean B(@NonNull List<UseCase> list) {
        boolean z10 = false;
        boolean z11 = false;
        for (UseCase next : list) {
            if (E(next)) {
                z10 = true;
            } else if (D(next)) {
                z11 = true;
            }
        }
        if (!z10 || z11) {
            return false;
        }
        return true;
    }

    private boolean C(@NonNull List<UseCase> list) {
        boolean z10 = false;
        boolean z11 = false;
        for (UseCase next : list) {
            if (E(next)) {
                z11 = true;
            } else if (D(next)) {
                z10 = true;
            }
        }
        if (!z10 || z11) {
            return false;
        }
        return true;
    }

    private boolean D(UseCase useCase) {
        return useCase instanceof h1;
    }

    private boolean E(UseCase useCase) {
        return useCase instanceof androidx.camera.core.f2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void F(Surface surface, SurfaceTexture surfaceTexture, SurfaceRequest.e eVar) {
        surface.release();
        surfaceTexture.release();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void G(SurfaceRequest surfaceRequest) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(surfaceRequest.m().getWidth(), surfaceRequest.m().getHeight());
        surfaceTexture.detachFromGLContext();
        Surface surface = new Surface(surfaceTexture);
        surfaceRequest.w(surface, androidx.camera.core.impl.utils.executor.a.a(), new e(surface, surfaceTexture));
    }

    private void I() {
        synchronized (this.f2729k) {
            if (this.f2731m != null) {
                this.f2720a.f().h(this.f2731m);
            }
        }
    }

    static void L(@NonNull List<m> list, @NonNull Collection<UseCase> collection) {
        HashMap hashMap = new HashMap();
        for (m next : list) {
            hashMap.put(Integer.valueOf(next.c()), next);
        }
        for (UseCase next2 : collection) {
            if (next2 instanceof androidx.camera.core.f2) {
                androidx.camera.core.f2 f2Var = (androidx.camera.core.f2) next2;
                m mVar = (m) hashMap.get(1);
                if (mVar == null) {
                    f2Var.W((a0) null);
                } else {
                    w2 b10 = mVar.b();
                    Objects.requireNonNull(b10);
                    f2Var.W(new g0(b10, mVar.a()));
                }
            }
        }
    }

    private void M(@NonNull Map<UseCase, Size> map, @NonNull Collection<UseCase> collection) {
        synchronized (this.f2729k) {
            if (this.f2726g != null) {
                Integer c10 = this.f2720a.l().c();
                boolean z10 = true;
                if (c10 == null) {
                    v1.l("CameraUseCaseAdapter", "The lens facing is null, probably an external.");
                } else if (c10.intValue() != 0) {
                    z10 = false;
                }
                Map<UseCase, Rect> a10 = k.a(this.f2720a.f().d(), z10, this.f2726g.a(), this.f2720a.l().i(this.f2726g.c()), this.f2726g.d(), this.f2726g.b(), map);
                for (UseCase next : collection) {
                    next.I((Rect) h.g(a10.get(next)));
                    next.H(q(this.f2720a.f().d(), map.get(next)));
                }
            }
        }
    }

    private void o() {
        synchronized (this.f2729k) {
            CameraControlInternal f10 = this.f2720a.f();
            this.f2731m = f10.f();
            f10.i();
        }
    }

    @NonNull
    private List<UseCase> p(@NonNull List<UseCase> list, @NonNull List<UseCase> list2) {
        ArrayList arrayList = new ArrayList(list2);
        boolean C = C(list);
        boolean B = B(list);
        UseCase useCase = null;
        UseCase useCase2 = null;
        for (UseCase next : list2) {
            if (E(next)) {
                useCase = next;
            } else if (D(next)) {
                useCase2 = next;
            }
        }
        if (C && useCase == null) {
            arrayList.add(t());
        } else if (!C && useCase != null) {
            arrayList.remove(useCase);
        }
        if (B && useCase2 == null) {
            arrayList.add(s());
        } else if (!B && useCase2 != null) {
            arrayList.remove(useCase2);
        }
        return arrayList;
    }

    @NonNull
    private static Matrix q(@NonNull Rect rect, @NonNull Size size) {
        boolean z10;
        if (rect.width() <= 0 || rect.height() <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        h.b(z10, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    private Map<UseCase, Size> r(@NonNull x xVar, @NonNull List<UseCase> list, @NonNull List<UseCase> list2, @NonNull Map<UseCase, b> map) {
        ArrayList arrayList = new ArrayList();
        String a10 = xVar.a();
        HashMap hashMap = new HashMap();
        for (UseCase next : list2) {
            arrayList.add(androidx.camera.core.impl.a.a(this.f2722c.a(a10, next.i(), next.c()), next.i(), next.c(), next.g().C((Range<Integer>) null)));
            hashMap.put(next, next.c());
        }
        if (!list.isEmpty()) {
            HashMap hashMap2 = new HashMap();
            for (UseCase next2 : list) {
                b bVar = map.get(next2);
                hashMap2.put(next2.r(xVar, bVar.f2734a, bVar.f2735b), next2);
            }
            Map<f2<?>, Size> b10 = this.f2722c.b(a10, arrayList, new ArrayList(hashMap2.keySet()));
            for (Map.Entry entry : hashMap2.entrySet()) {
                hashMap.put((UseCase) entry.getValue(), b10.get(entry.getKey()));
            }
        }
        return hashMap;
    }

    private h1 s() {
        return new h1.h().j("ImageCapture-Extra").c();
    }

    private androidx.camera.core.f2 t() {
        androidx.camera.core.f2 c10 = new f2.b().i("Preview-Extra").c();
        c10.X(new d());
        return c10;
    }

    private void u(@NonNull List<UseCase> list) {
        synchronized (this.f2729k) {
            if (!list.isEmpty()) {
                this.f2720a.k(list);
                for (UseCase next : list) {
                    if (this.f2725f.contains(next)) {
                        next.A(this.f2720a);
                    } else {
                        v1.c("CameraUseCaseAdapter", "Attempting to detach non-attached UseCase: " + next);
                    }
                }
                this.f2725f.removeAll(list);
            }
        }
    }

    @NonNull
    public static a w(@NonNull LinkedHashSet<CameraInternal> linkedHashSet) {
        return new a(linkedHashSet);
    }

    private Map<UseCase, b> y(List<UseCase> list, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        HashMap hashMap = new HashMap();
        for (UseCase next : list) {
            hashMap.put(next, new b(next.h(false, useCaseConfigFactory), next.h(true, useCaseConfigFactory2)));
        }
        return hashMap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H(@androidx.annotation.NonNull java.util.Collection<androidx.camera.core.UseCase> r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f2729k
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0028 }
            r1.<init>(r3)     // Catch:{ all -> 0x0028 }
            r2.u(r1)     // Catch:{ all -> 0x0028 }
            boolean r1 = r2.A()     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0026
            java.util.List<androidx.camera.core.UseCase> r1 = r2.f2732n     // Catch:{ all -> 0x0028 }
            r1.removeAll(r3)     // Catch:{ all -> 0x0028 }
            java.util.List r3 = java.util.Collections.emptyList()     // Catch:{ CameraException -> 0x001e }
            r2.i(r3)     // Catch:{ CameraException -> 0x001e }
            goto L_0x0026
        L_0x001e:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "Failed to add extra fake Preview or ImageCapture use case!"
            r3.<init>(r1)     // Catch:{ all -> 0x0028 }
            throw r3     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0028:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.H(java.util.Collection):void");
    }

    public void J(List<m> list) {
        synchronized (this.f2729k) {
            this.f2727h = list;
        }
    }

    public void K(k3 k3Var) {
        synchronized (this.f2729k) {
            this.f2726g = k3Var;
        }
    }

    @NonNull
    public CameraControl a() {
        return this.f2720a.f();
    }

    @NonNull
    public q b() {
        return this.f2720a.l();
    }

    public void h(boolean z10) {
        this.f2720a.h(z10);
    }

    public void i(@NonNull Collection<UseCase> collection) throws CameraException {
        synchronized (this.f2729k) {
            ArrayList<UseCase> arrayList = new ArrayList<>();
            for (UseCase next : collection) {
                if (this.f2725f.contains(next)) {
                    v1.a("CameraUseCaseAdapter", "Attempting to attach already attached UseCase");
                } else {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(this.f2725f);
            List<UseCase> emptyList = Collections.emptyList();
            List emptyList2 = Collections.emptyList();
            if (A()) {
                arrayList2.removeAll(this.f2732n);
                arrayList2.addAll(arrayList);
                emptyList = p(arrayList2, new ArrayList(this.f2732n));
                ArrayList arrayList3 = new ArrayList(emptyList);
                arrayList3.removeAll(this.f2732n);
                arrayList.addAll(arrayList3);
                emptyList2 = new ArrayList(this.f2732n);
                emptyList2.removeAll(emptyList);
            }
            Map<UseCase, b> y10 = y(arrayList, this.f2728j.j(), this.f2723d);
            try {
                ArrayList arrayList4 = new ArrayList(this.f2725f);
                arrayList4.removeAll(emptyList2);
                Map<UseCase, Size> r10 = r(this.f2720a.l(), arrayList, arrayList4, y10);
                M(r10, collection);
                L(this.f2727h, collection);
                this.f2732n = emptyList;
                u(emptyList2);
                for (UseCase useCase : arrayList) {
                    b bVar = y10.get(useCase);
                    useCase.x(this.f2720a, bVar.f2734a, bVar.f2735b);
                    useCase.K((Size) h.g(r10.get(useCase)));
                }
                this.f2725f.addAll(arrayList);
                if (this.f2730l) {
                    this.f2720a.j(arrayList);
                }
                for (UseCase v10 : arrayList) {
                    v10.v();
                }
            } catch (IllegalArgumentException e10) {
                throw new CameraException(e10.getMessage());
            }
        }
    }

    public void m(r rVar) {
        synchronized (this.f2729k) {
            if (rVar == null) {
                rVar = u.a();
            }
            if (!this.f2725f.isEmpty()) {
                if (!this.f2728j.E().equals(rVar.E())) {
                    throw new IllegalStateException("Need to unbind all use cases before binding with extension enabled");
                }
            }
            this.f2728j = rVar;
            this.f2720a.m(rVar);
        }
    }

    public void n() {
        synchronized (this.f2729k) {
            if (!this.f2730l) {
                this.f2720a.j(this.f2725f);
                I();
                for (UseCase v10 : this.f2725f) {
                    v10.v();
                }
                this.f2730l = true;
            }
        }
    }

    public void v() {
        synchronized (this.f2729k) {
            if (this.f2730l) {
                this.f2720a.k(new ArrayList(this.f2725f));
                o();
                this.f2730l = false;
            }
        }
    }

    @NonNull
    public a x() {
        return this.f2724e;
    }

    @NonNull
    public List<UseCase> z() {
        ArrayList arrayList;
        synchronized (this.f2729k) {
            arrayList = new ArrayList(this.f2725f);
        }
        return arrayList;
    }
}
