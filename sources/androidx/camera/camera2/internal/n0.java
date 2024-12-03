package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.t;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.r1;
import androidx.camera.core.o1;
import androidx.camera.core.v1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import n.a;
import o.c0;
import r.l;
import r.s;

class n0 {

    /* renamed from: g  reason: collision with root package name */
    private static final Set<CameraCaptureMetaData$AfState> f1853g = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData$AfState.PASSIVE_FOCUSED, CameraCaptureMetaData$AfState.PASSIVE_NOT_FOCUSED, CameraCaptureMetaData$AfState.LOCKED_FOCUSED, CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED));

    /* renamed from: h  reason: collision with root package name */
    private static final Set<CameraCaptureMetaData$AwbState> f1854h = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData$AwbState.CONVERGED, CameraCaptureMetaData$AwbState.UNKNOWN));

    /* renamed from: i  reason: collision with root package name */
    private static final Set<CameraCaptureMetaData$AeState> f1855i;

    /* renamed from: j  reason: collision with root package name */
    private static final Set<CameraCaptureMetaData$AeState> f1856j;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final t f1857a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final s f1858b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final r1 f1859c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Executor f1860d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1861e;

    /* renamed from: f  reason: collision with root package name */
    private int f1862f = 1;

    static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private final t f1863a;

        /* renamed from: b  reason: collision with root package name */
        private final l f1864b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1865c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1866d = false;

        a(@NonNull t tVar, int i10, @NonNull l lVar) {
            this.f1863a = tVar;
            this.f1865c = i10;
            this.f1864b = lVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object f(CallbackToFutureAdapter.a aVar) throws Exception {
            this.f1863a.z().Q(aVar);
            this.f1864b.b();
            return "AePreCapture";
        }

        @NonNull
        public zf.a<Boolean> a(TotalCaptureResult totalCaptureResult) {
            if (!n0.b(this.f1865c, totalCaptureResult)) {
                return u.f.h(Boolean.FALSE);
            }
            v1.a("Camera2CapturePipeline", "Trigger AE");
            this.f1866d = true;
            return u.d.a(CallbackToFutureAdapter.a(new l0(this))).d(new m0(), androidx.camera.core.impl.utils.executor.a.a());
        }

        public boolean b() {
            return this.f1865c == 0;
        }

        public void c() {
            if (this.f1866d) {
                v1.a("Camera2CapturePipeline", "cancel TriggerAePreCapture");
                this.f1863a.z().j(false, true);
                this.f1864b.a();
            }
        }
    }

    static class b implements d {

        /* renamed from: a  reason: collision with root package name */
        private final t f1867a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1868b = false;

        b(@NonNull t tVar) {
            this.f1867a = tVar;
        }

        @NonNull
        public zf.a<Boolean> a(TotalCaptureResult totalCaptureResult) {
            Integer num;
            zf.a<Boolean> h10 = u.f.h(Boolean.TRUE);
            if (totalCaptureResult == null || (num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)) == null) {
                return h10;
            }
            int intValue = num.intValue();
            if (intValue == 1 || intValue == 2) {
                v1.a("Camera2CapturePipeline", "TriggerAf? AF mode auto");
                Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num2 != null && num2.intValue() == 0) {
                    v1.a("Camera2CapturePipeline", "Trigger AF");
                    this.f1868b = true;
                    this.f1867a.z().R((CallbackToFutureAdapter.a<p>) null, false);
                }
            }
            return h10;
        }

        public boolean b() {
            return true;
        }

        public void c() {
            if (this.f1868b) {
                v1.a("Camera2CapturePipeline", "cancel TriggerAF");
                this.f1867a.z().j(true, false);
            }
        }
    }

    static class c {

        /* renamed from: i  reason: collision with root package name */
        private static final long f1869i;

        /* renamed from: j  reason: collision with root package name */
        private static final long f1870j;

        /* renamed from: a  reason: collision with root package name */
        private final int f1871a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f1872b;

        /* renamed from: c  reason: collision with root package name */
        private final t f1873c;

        /* renamed from: d  reason: collision with root package name */
        private final l f1874d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f1875e;

        /* renamed from: f  reason: collision with root package name */
        private long f1876f = f1869i;

        /* renamed from: g  reason: collision with root package name */
        final List<d> f1877g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        private final d f1878h = new a();

        class a implements d {
            a() {
            }

            @NonNull
            public zf.a<Boolean> a(TotalCaptureResult totalCaptureResult) {
                ArrayList arrayList = new ArrayList();
                for (d a10 : c.this.f1877g) {
                    arrayList.add(a10.a(totalCaptureResult));
                }
                return u.f.o(u.f.c(arrayList), new u0(), androidx.camera.core.impl.utils.executor.a.a());
            }

            public boolean b() {
                for (d b10 : c.this.f1877g) {
                    if (b10.b()) {
                        return true;
                    }
                }
                return false;
            }

            public void c() {
                for (d c10 : c.this.f1877g) {
                    c10.c();
                }
            }
        }

        class b extends n {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CallbackToFutureAdapter.a f1880a;

            b(CallbackToFutureAdapter.a aVar) {
                this.f1880a = aVar;
            }

            public void a() {
                this.f1880a.f(new ImageCaptureException(3, "Capture request is cancelled because camera is closed", (Throwable) null));
            }

            public void b(@NonNull p pVar) {
                this.f1880a.c(null);
            }

            public void c(@NonNull CameraCaptureFailure cameraCaptureFailure) {
                this.f1880a.f(new ImageCaptureException(2, "Capture request failed with reason " + cameraCaptureFailure.a(), (Throwable) null));
            }
        }

        static {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            f1869i = timeUnit.toNanos(1);
            f1870j = timeUnit.toNanos(5);
        }

        c(int i10, @NonNull Executor executor, @NonNull t tVar, boolean z10, @NonNull l lVar) {
            this.f1871a = i10;
            this.f1872b = executor;
            this.f1873c = tVar;
            this.f1875e = z10;
            this.f1874d = lVar;
        }

        private void g(@NonNull d0.a aVar) {
            a.C0174a aVar2 = new a.C0174a();
            aVar2.e(CaptureRequest.CONTROL_AE_MODE, 3);
            aVar.e(aVar2.c());
        }

        private void h(@NonNull d0.a aVar, @NonNull d0 d0Var) {
            int i10;
            if (this.f1871a == 3 && !this.f1875e) {
                i10 = 4;
            } else if (d0Var.g() == -1 || d0Var.g() == 5) {
                i10 = 2;
            } else {
                i10 = -1;
            }
            if (i10 != -1) {
                aVar.q(i10);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ zf.a j(int i10, TotalCaptureResult totalCaptureResult) throws Exception {
            if (n0.b(i10, totalCaptureResult)) {
                o(f1870j);
            }
            return this.f1878h.a(totalCaptureResult);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ zf.a l(Boolean bool) throws Exception {
            if (Boolean.TRUE.equals(bool)) {
                return n0.f(this.f1876f, this.f1873c, new t0());
            }
            return u.f.h(null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ zf.a m(List list, int i10, TotalCaptureResult totalCaptureResult) throws Exception {
            return p(list, i10);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object n(d0.a aVar, CallbackToFutureAdapter.a aVar2) throws Exception {
            aVar.c(new b(aVar2));
            return "submitStillCapture";
        }

        private void o(long j10) {
            this.f1876f = j10;
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull d dVar) {
            this.f1877g.add(dVar);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public zf.a<List<Void>> i(@NonNull List<d0> list, int i10) {
            zf.a aVar;
            zf.a h10 = u.f.h(null);
            if (!this.f1877g.isEmpty()) {
                if (this.f1878h.b()) {
                    aVar = n0.f(0, this.f1873c, (e.a) null);
                } else {
                    aVar = u.f.h(null);
                }
                h10 = u.d.a(aVar).e(new o0(this, i10), this.f1872b).e(new p0(this), this.f1872b);
            }
            u.d e10 = u.d.a(h10).e(new q0(this, list, i10), this.f1872b);
            d dVar = this.f1878h;
            Objects.requireNonNull(dVar);
            e10.addListener(new r0(dVar), this.f1872b);
            return e10;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public zf.a<List<Void>> p(@NonNull List<d0> list, int i10) {
            boolean z10;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (d0 next : list) {
                d0.a k10 = d0.a.k(next);
                p pVar = null;
                if (next.g() == 5 && !this.f1873c.L().h() && !this.f1873c.L().c()) {
                    o1 f10 = this.f1873c.L().f();
                    if (f10 == null || !this.f1873c.L().g(f10)) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        pVar = q.a(f10.z1());
                    }
                }
                if (pVar != null) {
                    k10.o(pVar);
                } else {
                    h(k10, next);
                }
                if (this.f1874d.c(i10)) {
                    g(k10);
                }
                arrayList.add(CallbackToFutureAdapter.a(new s0(this, k10)));
                arrayList2.add(k10.h());
            }
            this.f1873c.i0(arrayList2);
            return u.f.c(arrayList);
        }
    }

    interface d {
        @NonNull
        zf.a<Boolean> a(TotalCaptureResult totalCaptureResult);

        boolean b();

        void c();
    }

    static class e implements t.c {

        /* renamed from: a  reason: collision with root package name */
        private CallbackToFutureAdapter.a<TotalCaptureResult> f1882a;

        /* renamed from: b  reason: collision with root package name */
        private final zf.a<TotalCaptureResult> f1883b = CallbackToFutureAdapter.a(new v0(this));

        /* renamed from: c  reason: collision with root package name */
        private final long f1884c;

        /* renamed from: d  reason: collision with root package name */
        private final a f1885d;

        /* renamed from: e  reason: collision with root package name */
        private volatile Long f1886e = null;

        interface a {
            boolean a(@NonNull TotalCaptureResult totalCaptureResult);
        }

        e(long j10, a aVar) {
            this.f1884c = j10;
            this.f1885d = aVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object d(CallbackToFutureAdapter.a aVar) throws Exception {
            this.f1882a = aVar;
            return "waitFor3AResult";
        }

        public boolean a(@NonNull TotalCaptureResult totalCaptureResult) {
            Long l10 = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
            if (l10 != null && this.f1886e == null) {
                this.f1886e = l10;
            }
            Long l11 = this.f1886e;
            if (0 == this.f1884c || l11 == null || l10 == null || l10.longValue() - l11.longValue() <= this.f1884c) {
                a aVar = this.f1885d;
                if (aVar != null && !aVar.a(totalCaptureResult)) {
                    return false;
                }
                this.f1882a.c(totalCaptureResult);
                return true;
            }
            this.f1882a.c(null);
            v1.a("Camera2CapturePipeline", "Wait for capture result timeout, current:" + l10 + " first: " + l11);
            return true;
        }

        @NonNull
        public zf.a<TotalCaptureResult> c() {
            return this.f1883b;
        }
    }

    static class f implements d {

        /* renamed from: e  reason: collision with root package name */
        private static final long f1887e = TimeUnit.SECONDS.toNanos(2);

        /* renamed from: a  reason: collision with root package name */
        private final t f1888a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1889b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1890c = false;

        /* renamed from: d  reason: collision with root package name */
        private final Executor f1891d;

        f(@NonNull t tVar, int i10, @NonNull Executor executor) {
            this.f1888a = tVar;
            this.f1889b = i10;
            this.f1891d = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object h(CallbackToFutureAdapter.a aVar) throws Exception {
            this.f1888a.I().g(aVar, true);
            return "TorchOn";
        }

        /* access modifiers changed from: private */
        public /* synthetic */ zf.a j(Void voidR) throws Exception {
            return n0.f(f1887e, this.f1888a, new z0());
        }

        @NonNull
        public zf.a<Boolean> a(TotalCaptureResult totalCaptureResult) {
            if (n0.b(this.f1889b, totalCaptureResult)) {
                if (this.f1888a.Q()) {
                    v1.a("Camera2CapturePipeline", "Torch already on, not turn on");
                } else {
                    v1.a("Camera2CapturePipeline", "Turn on torch");
                    this.f1890c = true;
                    return u.d.a(CallbackToFutureAdapter.a(new w0(this))).e(new x0(this), this.f1891d).d(new y0(), androidx.camera.core.impl.utils.executor.a.a());
                }
            }
            return u.f.h(Boolean.FALSE);
        }

        public boolean b() {
            return this.f1889b == 0;
        }

        public void c() {
            if (this.f1890c) {
                this.f1888a.I().g((CallbackToFutureAdapter.a<Void>) null, false);
                v1.a("Camera2CapturePipeline", "Turn off torch");
            }
        }
    }

    static {
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState = CameraCaptureMetaData$AeState.CONVERGED;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState2 = CameraCaptureMetaData$AeState.FLASH_REQUIRED;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState3 = CameraCaptureMetaData$AeState.UNKNOWN;
        Set<CameraCaptureMetaData$AeState> unmodifiableSet = Collections.unmodifiableSet(EnumSet.of(cameraCaptureMetaData$AeState, cameraCaptureMetaData$AeState2, cameraCaptureMetaData$AeState3));
        f1855i = unmodifiableSet;
        EnumSet<CameraCaptureMetaData$AeState> copyOf = EnumSet.copyOf(unmodifiableSet);
        copyOf.remove(cameraCaptureMetaData$AeState2);
        copyOf.remove(cameraCaptureMetaData$AeState3);
        f1856j = Collections.unmodifiableSet(copyOf);
    }

    n0(@NonNull t tVar, @NonNull c0 c0Var, @NonNull r1 r1Var, @NonNull Executor executor) {
        boolean z10 = true;
        this.f1857a = tVar;
        Integer num = (Integer) c0Var.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        this.f1861e = (num == null || num.intValue() != 2) ? false : z10;
        this.f1860d = executor;
        this.f1859c = r1Var;
        this.f1858b = new s(r1Var);
    }

    /* access modifiers changed from: package-private */
    public static boolean a(TotalCaptureResult totalCaptureResult, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (totalCaptureResult == null) {
            return false;
        }
        e eVar = new e(totalCaptureResult);
        if (eVar.h() == CameraCaptureMetaData$AfMode.OFF || eVar.h() == CameraCaptureMetaData$AfMode.UNKNOWN || f1853g.contains(eVar.e())) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE)).intValue() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z10 ? z12 || f1855i.contains(eVar.g()) : z12 || f1856j.contains(eVar.g())) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_MODE)).intValue() == 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14 || f1854h.contains(eVar.f())) {
            z15 = true;
        } else {
            z15 = false;
        }
        v1.a("Camera2CapturePipeline", "checkCaptureResult, AE=" + eVar.g() + " AF =" + eVar.e() + " AWB=" + eVar.f());
        if (!z11 || !z13 || !z15) {
            return false;
        }
        return true;
    }

    static boolean b(int i10, TotalCaptureResult totalCaptureResult) {
        Integer num;
        if (i10 == 0) {
            if (totalCaptureResult != null) {
                num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
            } else {
                num = null;
            }
            if (num == null || num.intValue() != 4) {
                return false;
            }
            return true;
        } else if (i10 == 1) {
            return true;
        } else {
            if (i10 == 2) {
                return false;
            }
            throw new AssertionError(i10);
        }
    }

    private boolean c(int i10) {
        return this.f1858b.a() || this.f1862f == 3 || i10 == 1;
    }

    @NonNull
    static zf.a<TotalCaptureResult> f(long j10, @NonNull t tVar, e.a aVar) {
        e eVar = new e(j10, aVar);
        tVar.t(eVar);
        return eVar.c();
    }

    public void d(int i10) {
        this.f1862f = i10;
    }

    @NonNull
    public zf.a<List<Void>> e(@NonNull List<d0> list, int i10, int i11, int i12) {
        l lVar = new l(this.f1859c);
        c cVar = new c(this.f1862f, this.f1860d, this.f1857a, this.f1861e, lVar);
        if (i10 == 0) {
            cVar.f(new b(this.f1857a));
        }
        if (c(i12)) {
            cVar.f(new f(this.f1857a, i11, this.f1860d));
        } else {
            cVar.f(new a(this.f1857a, i11, lVar));
        }
        return u.f.j(cVar.i(list, i11));
    }
}
