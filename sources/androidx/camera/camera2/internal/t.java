package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.ArrayMap;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraControl;
import androidx.camera.core.f0;
import androidx.camera.core.g0;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.r1;
import androidx.camera.core.v1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import n.a;
import o.c0;
import s.g;
import s.j;
import u.d;
import u.f;

public class t implements CameraControlInternal {

    /* renamed from: b  reason: collision with root package name */
    final b f1948b;

    /* renamed from: c  reason: collision with root package name */
    final Executor f1949c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f1950d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final c0 f1951e;

    /* renamed from: f  reason: collision with root package name */
    private final CameraControlInternal.b f1952f;

    /* renamed from: g  reason: collision with root package name */
    private final SessionConfig.b f1953g;

    /* renamed from: h  reason: collision with root package name */
    private final g2 f1954h;

    /* renamed from: i  reason: collision with root package name */
    private final j3 f1955i;

    /* renamed from: j  reason: collision with root package name */
    private final i3 f1956j;

    /* renamed from: k  reason: collision with root package name */
    private final w1 f1957k;

    /* renamed from: l  reason: collision with root package name */
    l3 f1958l;

    /* renamed from: m  reason: collision with root package name */
    private final g f1959m;

    /* renamed from: n  reason: collision with root package name */
    private final n0 f1960n;

    /* renamed from: o  reason: collision with root package name */
    private int f1961o;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f1962p;

    /* renamed from: q  reason: collision with root package name */
    private volatile int f1963q;

    /* renamed from: r  reason: collision with root package name */
    private final r.a f1964r;

    /* renamed from: s  reason: collision with root package name */
    private final r.b f1965s;

    /* renamed from: t  reason: collision with root package name */
    private final AtomicLong f1966t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    private volatile zf.a<Void> f1967u;

    /* renamed from: v  reason: collision with root package name */
    private int f1968v;

    /* renamed from: w  reason: collision with root package name */
    private long f1969w;

    /* renamed from: x  reason: collision with root package name */
    private final a f1970x;

    static final class a extends n {

        /* renamed from: a  reason: collision with root package name */
        Set<n> f1971a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        Map<n, Executor> f1972b = new ArrayMap();

        a() {
        }

        public void a() {
            for (n next : this.f1971a) {
                try {
                    this.f1972b.get(next).execute(new r(next));
                } catch (RejectedExecutionException e10) {
                    v1.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCancelled.", e10);
                }
            }
        }

        public void b(@NonNull p pVar) {
            for (n next : this.f1971a) {
                try {
                    this.f1972b.get(next).execute(new s(next, pVar));
                } catch (RejectedExecutionException e10) {
                    v1.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCompleted.", e10);
                }
            }
        }

        public void c(@NonNull CameraCaptureFailure cameraCaptureFailure) {
            for (n next : this.f1971a) {
                try {
                    this.f1972b.get(next).execute(new q(next, cameraCaptureFailure));
                } catch (RejectedExecutionException e10) {
                    v1.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureFailed.", e10);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull Executor executor, @NonNull n nVar) {
            this.f1971a.add(nVar);
            this.f1972b.put(nVar, executor);
        }

        /* access modifiers changed from: package-private */
        public void k(@NonNull n nVar) {
            this.f1971a.remove(nVar);
            this.f1972b.remove(nVar);
        }
    }

    static final class b extends CameraCaptureSession.CaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        final Set<c> f1973a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private final Executor f1974b;

        b(@NonNull Executor executor) {
            this.f1974b = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(TotalCaptureResult totalCaptureResult) {
            HashSet hashSet = new HashSet();
            for (c next : this.f1973a) {
                if (next.a(totalCaptureResult)) {
                    hashSet.add(next);
                }
            }
            if (!hashSet.isEmpty()) {
                this.f1973a.removeAll(hashSet);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(@NonNull c cVar) {
            this.f1973a.add(cVar);
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull c cVar) {
            this.f1973a.remove(cVar);
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            this.f1974b.execute(new u(this, totalCaptureResult));
        }
    }

    public interface c {
        boolean a(@NonNull TotalCaptureResult totalCaptureResult);
    }

    t(@NonNull c0 c0Var, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Executor executor, @NonNull CameraControlInternal.b bVar, @NonNull r1 r1Var) {
        SessionConfig.b bVar2 = new SessionConfig.b();
        this.f1953g = bVar2;
        this.f1961o = 0;
        this.f1962p = false;
        this.f1963q = 2;
        this.f1966t = new AtomicLong(0);
        this.f1967u = f.h(null);
        this.f1968v = 1;
        this.f1969w = 0;
        a aVar = new a();
        this.f1970x = aVar;
        this.f1951e = c0Var;
        this.f1952f = bVar;
        this.f1949c = executor;
        b bVar3 = new b(executor);
        this.f1948b = bVar3;
        bVar2.t(this.f1968v);
        bVar2.i(m1.d(bVar3));
        bVar2.i(aVar);
        this.f1957k = new w1(this, c0Var, executor);
        this.f1954h = new g2(this, scheduledExecutorService, executor, r1Var);
        this.f1955i = new j3(this, c0Var, executor);
        this.f1956j = new i3(this, c0Var, executor);
        this.f1958l = new p3(c0Var);
        this.f1964r = new r.a(r1Var);
        this.f1965s = new r.b(r1Var);
        this.f1959m = new g(this, executor);
        this.f1960n = new n0(this, c0Var, r1Var, executor);
        executor.execute(new j(this));
    }

    private int H(int i10) {
        int[] iArr = (int[]) this.f1951e.a(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (O(i10, iArr)) {
            return i10;
        }
        if (O(1, iArr)) {
            return 1;
        }
        return 0;
    }

    private boolean N() {
        return J() > 0;
    }

    private boolean O(int i10, int[] iArr) {
        for (int i11 : iArr) {
            if (i10 == i11) {
                return true;
            }
        }
        return false;
    }

    static boolean P(@NonNull TotalCaptureResult totalCaptureResult, long j10) {
        Long l10;
        if (totalCaptureResult.getRequest() == null) {
            return false;
        }
        Object tag = totalCaptureResult.getRequest().getTag();
        if (!(tag instanceof a2) || (l10 = (Long) ((a2) tag).c("CameraControlSessionUpdateId")) == null || l10.longValue() < j10) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void R() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(Executor executor, n nVar) {
        this.f1970x.g(executor, nVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void T() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U() {
        t(this.f1959m.l());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(n nVar) {
        this.f1970x.k(nVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ zf.a W(List list, int i10, int i11, int i12, Void voidR) throws Exception {
        return this.f1960n.e(list, i10, i11, i12);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(CallbackToFutureAdapter.a aVar) {
        f.k(m0(l0()), aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object Y(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f1949c.execute(new n(this, aVar));
        return "updateSessionConfigAsync";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean Z(long j10, CallbackToFutureAdapter.a aVar, TotalCaptureResult totalCaptureResult) {
        if (!P(totalCaptureResult, j10)) {
            return false;
        }
        aVar.c(null);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object a0(long j10, CallbackToFutureAdapter.a aVar) throws Exception {
        t(new f(j10, aVar));
        return "waitForSessionUpdateId:" + j10;
    }

    @NonNull
    private zf.a<Void> m0(long j10) {
        return CallbackToFutureAdapter.a(new p(this, j10));
    }

    /* access modifiers changed from: package-private */
    public int A() {
        Integer num = (Integer) this.f1951e.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public int B() {
        Integer num = (Integer) this.f1951e.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public int C() {
        Integer num = (Integer) this.f1951e.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @NonNull
    public SessionConfig D() {
        this.f1953g.t(this.f1968v);
        this.f1953g.r(E());
        Object N = this.f1959m.k().N((Object) null);
        if (N != null && (N instanceof Integer)) {
            this.f1953g.l("Camera2CameraControl", N);
        }
        this.f1953g.l("CameraControlSessionUpdateId", Long.valueOf(this.f1969w));
        return this.f1953g.m();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0070 A[LOOP:0: B:10:0x006a->B:12:0x0070, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.Config E() {
        /*
            r7 = this;
            n.a$a r0 = new n.a$a
            r0.<init>()
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_MODE
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.e(r1, r3)
            androidx.camera.camera2.internal.g2 r1 = r7.f1954h
            r1.i(r0)
            r.a r1 = r7.f1964r
            r1.a(r0)
            androidx.camera.camera2.internal.j3 r1 = r7.f1955i
            r1.a(r0)
            boolean r1 = r7.f1962p
            r3 = 2
            if (r1 == 0) goto L_0x002d
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.FLASH_MODE
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.e(r1, r3)
            goto L_0x0033
        L_0x002d:
            int r1 = r7.f1963q
            if (r1 == 0) goto L_0x0037
            if (r1 == r2) goto L_0x0035
        L_0x0033:
            r1 = r2
            goto L_0x003d
        L_0x0035:
            r1 = 3
            goto L_0x003d
        L_0x0037:
            r.b r1 = r7.f1965s
            int r1 = r1.a(r3)
        L_0x003d:
            android.hardware.camera2.CaptureRequest$Key r3 = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE
            int r1 = r7.F(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.e(r3, r1)
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_AWB_MODE
            int r2 = r7.H(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.e(r1, r2)
            androidx.camera.camera2.internal.w1 r1 = r7.f1957k
            r1.c(r0)
            s.g r1 = r7.f1959m
            n.a r1 = r1.k()
            java.util.Set r2 = r1.e()
            java.util.Iterator r2 = r2.iterator()
        L_0x006a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0084
            java.lang.Object r3 = r2.next()
            androidx.camera.core.impl.Config$a r3 = (androidx.camera.core.impl.Config.a) r3
            androidx.camera.core.impl.h1 r4 = r0.a()
            androidx.camera.core.impl.Config$OptionPriority r5 = androidx.camera.core.impl.Config.OptionPriority.ALWAYS_OVERRIDE
            java.lang.Object r6 = r1.a(r3)
            r4.n(r3, r5, r6)
            goto L_0x006a
        L_0x0084:
            n.a r0 = r0.c()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.t.E():androidx.camera.core.impl.Config");
    }

    /* access modifiers changed from: package-private */
    public int F(int i10) {
        int[] iArr = (int[]) this.f1951e.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (O(i10, iArr)) {
            return i10;
        }
        if (O(1, iArr)) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int G(int i10) {
        int[] iArr = (int[]) this.f1951e.a(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (O(i10, iArr)) {
            return i10;
        }
        if (O(4, iArr)) {
            return 4;
        }
        if (O(1, iArr)) {
            return 1;
        }
        return 0;
    }

    @NonNull
    public i3 I() {
        return this.f1956j;
    }

    /* access modifiers changed from: package-private */
    public int J() {
        int i10;
        synchronized (this.f1950d) {
            i10 = this.f1961o;
        }
        return i10;
    }

    @NonNull
    public j3 K() {
        return this.f1955i;
    }

    @NonNull
    public l3 L() {
        return this.f1958l;
    }

    /* access modifiers changed from: package-private */
    public void M() {
        synchronized (this.f1950d) {
            this.f1961o++;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean Q() {
        return this.f1962p;
    }

    @NonNull
    public zf.a<Void> a(boolean z10) {
        if (!N()) {
            return f.f(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return f.j(this.f1956j.d(z10));
    }

    public void b(@NonNull SessionConfig.b bVar) {
        this.f1958l.b(bVar);
    }

    /* access modifiers changed from: package-private */
    public void b0(@NonNull c cVar) {
        this.f1948b.d(cVar);
    }

    @NonNull
    public zf.a<List<Void>> c(@NonNull List<d0> list, int i10, int i11) {
        if (!N()) {
            v1.l("Camera2CameraControlImp", "Camera is not active.");
            return f.f(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return d.a(f.j(this.f1967u)).e(new g(this, list, i10, y(), i11), this.f1949c);
    }

    /* access modifiers changed from: package-private */
    public void c0(@NonNull n nVar) {
        this.f1949c.execute(new o(this, nVar));
    }

    @NonNull
    public Rect d() {
        return (Rect) h.g((Rect) this.f1951e.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    /* access modifiers changed from: package-private */
    public void d0() {
        g0(1);
    }

    public void e(int i10) {
        if (!N()) {
            v1.l("Camera2CameraControlImp", "Camera is not active.");
            return;
        }
        this.f1963q = i10;
        l3 l3Var = this.f1958l;
        boolean z10 = true;
        if (!(this.f1963q == 1 || this.f1963q == 0)) {
            z10 = false;
        }
        l3Var.d(z10);
        this.f1967u = k0();
    }

    /* access modifiers changed from: package-private */
    public void e0(boolean z10) {
        this.f1954h.J(z10);
        this.f1955i.g(z10);
        this.f1956j.j(z10);
        this.f1957k.b(z10);
        this.f1959m.s(z10);
    }

    @NonNull
    public Config f() {
        return this.f1959m.k();
    }

    public void f0(Rational rational) {
        this.f1954h.K(rational);
    }

    @NonNull
    public zf.a<g0> g(@NonNull f0 f0Var) {
        if (!N()) {
            return f.f(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return f.j(this.f1954h.N(f0Var));
    }

    /* access modifiers changed from: package-private */
    public void g0(int i10) {
        this.f1968v = i10;
        this.f1954h.L(i10);
        this.f1960n.d(this.f1968v);
    }

    public void h(@NonNull Config config) {
        this.f1959m.g(j.a.e(config).d()).addListener(new k(), androidx.camera.core.impl.utils.executor.a.a());
    }

    public void h0(boolean z10) {
        this.f1958l.e(z10);
    }

    public void i() {
        this.f1959m.i().addListener(new h(), androidx.camera.core.impl.utils.executor.a.a());
    }

    /* access modifiers changed from: package-private */
    public void i0(List<d0> list) {
        this.f1952f.b(list);
    }

    public void j0() {
        this.f1949c.execute(new m(this));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public zf.a<Void> k0() {
        return f.j(CallbackToFutureAdapter.a(new l(this)));
    }

    /* access modifiers changed from: package-private */
    public long l0() {
        this.f1969w = this.f1966t.getAndIncrement();
        this.f1952f.a();
        return this.f1969w;
    }

    /* access modifiers changed from: package-private */
    public void t(@NonNull c cVar) {
        this.f1948b.b(cVar);
    }

    /* access modifiers changed from: package-private */
    public void u(@NonNull Executor executor, @NonNull n nVar) {
        this.f1949c.execute(new i(this, executor, nVar));
    }

    /* access modifiers changed from: package-private */
    public void v() {
        synchronized (this.f1950d) {
            int i10 = this.f1961o;
            if (i10 != 0) {
                this.f1961o = i10 - 1;
            } else {
                throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void w(boolean z10) {
        this.f1962p = z10;
        if (!z10) {
            d0.a aVar = new d0.a();
            aVar.q(this.f1968v);
            aVar.r(true);
            a.C0174a aVar2 = new a.C0174a();
            aVar2.e(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(F(1)));
            aVar2.e(CaptureRequest.FLASH_MODE, 0);
            aVar.e(aVar2.c());
            i0(Collections.singletonList(aVar.h()));
        }
        l0();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Rect x() {
        return this.f1955i.c();
    }

    public int y() {
        return this.f1963q;
    }

    @NonNull
    public g2 z() {
        return this.f1954h;
    }
}
