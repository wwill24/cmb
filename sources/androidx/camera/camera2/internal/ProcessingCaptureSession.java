package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.f2;
import androidx.camera.core.h1;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.o0;
import androidx.camera.core.impl.o1;
import androidx.camera.core.impl.u1;
import androidx.camera.core.l0;
import androidx.camera.core.v1;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import n.a;
import s.j;
import u.f;

final class ProcessingCaptureSession implements r1 {

    /* renamed from: q  reason: collision with root package name */
    private static List<DeferrableSurface> f1637q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private static int f1638r = 0;

    /* renamed from: a  reason: collision with root package name */
    private final u1 f1639a;

    /* renamed from: b  reason: collision with root package name */
    private final i0 f1640b;

    /* renamed from: c  reason: collision with root package name */
    final Executor f1641c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f1642d;

    /* renamed from: e  reason: collision with root package name */
    private final CaptureSession f1643e = new CaptureSession();

    /* renamed from: f  reason: collision with root package name */
    private List<DeferrableSurface> f1644f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private SessionConfig f1645g;

    /* renamed from: h  reason: collision with root package name */
    private c1 f1646h;

    /* renamed from: i  reason: collision with root package name */
    private SessionConfig f1647i;

    /* renamed from: j  reason: collision with root package name */
    private ProcessorState f1648j;

    /* renamed from: k  reason: collision with root package name */
    private volatile d0 f1649k = null;

    /* renamed from: l  reason: collision with root package name */
    volatile boolean f1650l = false;

    /* renamed from: m  reason: collision with root package name */
    private final d f1651m;

    /* renamed from: n  reason: collision with root package name */
    private j f1652n = new j.a().d();

    /* renamed from: o  reason: collision with root package name */
    private j f1653o = new j.a().d();

    /* renamed from: p  reason: collision with root package name */
    private int f1654p = 0;

    private enum ProcessorState {
        UNINITIALIZED,
        SESSION_INITIALIZED,
        ON_CAPTURE_SESSION_STARTED,
        ON_CAPTURE_SESSION_ENDED,
        CLOSED
    }

    class a implements u.c<Void> {
        a() {
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
        }

        public void onFailure(@NonNull Throwable th2) {
            v1.d("ProcessingCaptureSession", "open session failed ", th2);
            ProcessingCaptureSession.this.close();
        }
    }

    class b implements u1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d0 f1662a;

        b(d0 d0Var) {
            this.f1662a = d0Var;
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1664a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState[] r0 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1664a = r0
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState r1 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1664a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState r1 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.SESSION_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1664a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState r1 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.ON_CAPTURE_SESSION_STARTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1664a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState r1 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.ON_CAPTURE_SESSION_ENDED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1664a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState r1 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.CLOSED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.ProcessingCaptureSession.c.<clinit>():void");
        }
    }

    private static class d implements u1.a {
        d() {
        }
    }

    ProcessingCaptureSession(@NonNull u1 u1Var, @NonNull i0 i0Var, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.f1639a = u1Var;
        this.f1640b = i0Var;
        this.f1641c = executor;
        this.f1642d = scheduledExecutorService;
        this.f1648j = ProcessorState.UNINITIALIZED;
        this.f1651m = new d();
        int i10 = f1638r;
        f1638r = i10 + 1;
        this.f1654p = i10;
        v1.a("ProcessingCaptureSession", "New ProcessingCaptureSession (id=" + this.f1654p + ")");
    }

    private static void l(@NonNull List<d0> list) {
        for (d0 b10 : list) {
            for (n a10 : b10.b()) {
                a10.a();
            }
        }
    }

    private static List<androidx.camera.core.impl.v1> m(List<DeferrableSurface> list) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface next : list) {
            h.b(next instanceof androidx.camera.core.impl.v1, "Surface must be SessionProcessorSurface");
            arrayList.add((androidx.camera.core.impl.v1) next);
        }
        return arrayList;
    }

    private boolean n(@NonNull List<d0> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (d0 g10 : list) {
            if (g10.g() != 2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o() {
        o0.e(this.f1644f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ zf.a q(SessionConfig sessionConfig, CameraDevice cameraDevice, d3 d3Var, List list) throws Exception {
        v1.a("ProcessingCaptureSession", "-- getSurfaces done, start init (id=" + this.f1654p + ")");
        if (this.f1648j == ProcessorState.CLOSED) {
            return f.f(new IllegalStateException("SessionProcessorCaptureSession is closed."));
        }
        o1 o1Var = null;
        if (list.contains((Object) null)) {
            return f.f(new DeferrableSurface.SurfaceClosedException("Surface closed", sessionConfig.k().get(list.indexOf((Object) null))));
        }
        try {
            o0.f(this.f1644f);
            o1 o1Var2 = null;
            o1 o1Var3 = null;
            for (int i10 = 0; i10 < sessionConfig.k().size(); i10++) {
                DeferrableSurface deferrableSurface = sessionConfig.k().get(i10);
                if (Objects.equals(deferrableSurface.e(), f2.class)) {
                    o1Var = o1.a(deferrableSurface.h().get(), new Size(deferrableSurface.f().getWidth(), deferrableSurface.f().getHeight()), deferrableSurface.g());
                } else if (Objects.equals(deferrableSurface.e(), h1.class)) {
                    o1Var2 = o1.a(deferrableSurface.h().get(), new Size(deferrableSurface.f().getWidth(), deferrableSurface.f().getHeight()), deferrableSurface.g());
                } else if (Objects.equals(deferrableSurface.e(), l0.class)) {
                    o1Var3 = o1.a(deferrableSurface.h().get(), new Size(deferrableSurface.f().getWidth(), deferrableSurface.f().getHeight()), deferrableSurface.g());
                }
            }
            this.f1648j = ProcessorState.SESSION_INITIALIZED;
            v1.l("ProcessingCaptureSession", "== initSession (id=" + this.f1654p + ")");
            SessionConfig b10 = this.f1639a.b(this.f1640b, o1Var, o1Var2, o1Var3);
            this.f1647i = b10;
            b10.k().get(0).i().addListener(new n2(this), androidx.camera.core.impl.utils.executor.a.a());
            for (DeferrableSurface next : this.f1647i.k()) {
                f1637q.add(next);
                next.i().addListener(new o2(next), this.f1641c);
            }
            SessionConfig.f fVar = new SessionConfig.f();
            fVar.a(sessionConfig);
            fVar.d();
            fVar.a(this.f1647i);
            h.b(fVar.f(), "Cannot transform the SessionConfig");
            zf.a<Void> g10 = this.f1643e.g(fVar.c(), (CameraDevice) h.g(cameraDevice), d3Var);
            f.b(g10, new a(), this.f1641c);
            return g10;
        } catch (DeferrableSurface.SurfaceClosedException e10) {
            return f.f(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void r(Void voidR) {
        s(this.f1643e);
        return null;
    }

    private void t(@NonNull j jVar, @NonNull j jVar2) {
        a.C0174a aVar = new a.C0174a();
        aVar.d(jVar);
        aVar.d(jVar2);
        this.f1639a.f(aVar.c());
    }

    public void a(@NonNull List<d0> list) {
        if (!list.isEmpty()) {
            if (list.size() > 1 || !n(list)) {
                l(list);
            } else if (this.f1649k != null || this.f1650l) {
                l(list);
            } else {
                d0 d0Var = list.get(0);
                v1.a("ProcessingCaptureSession", "issueCaptureRequests (id=" + this.f1654p + ") + state =" + this.f1648j);
                int i10 = c.f1664a[this.f1648j.ordinal()];
                if (i10 == 1 || i10 == 2) {
                    this.f1649k = d0Var;
                } else if (i10 == 3) {
                    this.f1650l = true;
                    j.a e10 = j.a.e(d0Var.d());
                    Config d10 = d0Var.d();
                    Config.a<Integer> aVar = d0.f2485h;
                    if (d10.b(aVar)) {
                        e10.g(CaptureRequest.JPEG_ORIENTATION, (Integer) d0Var.d().a(aVar));
                    }
                    Config d11 = d0Var.d();
                    Config.a<Integer> aVar2 = d0.f2486i;
                    if (d11.b(aVar2)) {
                        e10.g(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) d0Var.d().a(aVar2)).byteValue()));
                    }
                    j d12 = e10.d();
                    this.f1653o = d12;
                    t(this.f1652n, d12);
                    this.f1639a.g(new b(d0Var));
                } else if (i10 == 4 || i10 == 5) {
                    v1.a("ProcessingCaptureSession", "Run issueCaptureRequests in wrong state, state = " + this.f1648j);
                    l(list);
                }
            }
        }
    }

    public void b() {
        v1.a("ProcessingCaptureSession", "cancelIssuedCaptureRequests (id=" + this.f1654p + ")");
        if (this.f1649k != null) {
            for (n a10 : this.f1649k.b()) {
                a10.a();
            }
            this.f1649k = null;
        }
    }

    @NonNull
    public zf.a<Void> c(boolean z10) {
        boolean z11;
        if (this.f1648j == ProcessorState.CLOSED) {
            z11 = true;
        } else {
            z11 = false;
        }
        h.j(z11, "release() can only be called in CLOSED state");
        v1.a("ProcessingCaptureSession", "release (id=" + this.f1654p + ")");
        return this.f1643e.c(z10);
    }

    public void close() {
        v1.a("ProcessingCaptureSession", "close (id=" + this.f1654p + ") state=" + this.f1648j);
        int i10 = c.f1664a[this.f1648j.ordinal()];
        if (i10 != 2) {
            if (i10 == 3) {
                this.f1639a.c();
                c1 c1Var = this.f1646h;
                if (c1Var != null) {
                    c1Var.a();
                }
                this.f1648j = ProcessorState.ON_CAPTURE_SESSION_ENDED;
            } else if (i10 != 4) {
                if (i10 == 5) {
                    return;
                }
                this.f1648j = ProcessorState.CLOSED;
                this.f1643e.close();
            }
        }
        this.f1639a.d();
        this.f1648j = ProcessorState.CLOSED;
        this.f1643e.close();
    }

    @NonNull
    public List<d0> d() {
        if (this.f1649k == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(new d0[]{this.f1649k});
    }

    public SessionConfig e() {
        return this.f1645g;
    }

    public void f(SessionConfig sessionConfig) {
        v1.a("ProcessingCaptureSession", "setSessionConfig (id=" + this.f1654p + ")");
        this.f1645g = sessionConfig;
        if (sessionConfig != null) {
            c1 c1Var = this.f1646h;
            if (c1Var != null) {
                c1Var.b(sessionConfig);
            }
            if (this.f1648j == ProcessorState.ON_CAPTURE_SESSION_STARTED) {
                j d10 = j.a.e(sessionConfig.d()).d();
                this.f1652n = d10;
                t(d10, this.f1653o);
                this.f1639a.e(this.f1651m);
            }
        }
    }

    @NonNull
    public zf.a<Void> g(@NonNull SessionConfig sessionConfig, @NonNull CameraDevice cameraDevice, @NonNull d3 d3Var) {
        boolean z10;
        if (this.f1648j == ProcessorState.UNINITIALIZED) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.b(z10, "Invalid state state:" + this.f1648j);
        h.b(sessionConfig.k().isEmpty() ^ true, "SessionConfig contains no surfaces");
        v1.a("ProcessingCaptureSession", "open (id=" + this.f1654p + ")");
        List<DeferrableSurface> k10 = sessionConfig.k();
        this.f1644f = k10;
        return u.d.a(o0.k(k10, false, 5000, this.f1641c, this.f1642d)).e(new l2(this, sessionConfig, cameraDevice, d3Var), this.f1641c).d(new m2(this), this.f1641c);
    }

    /* access modifiers changed from: package-private */
    public void s(@NonNull CaptureSession captureSession) {
        boolean z10;
        if (this.f1648j == ProcessorState.SESSION_INITIALIZED) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.b(z10, "Invalid state state:" + this.f1648j);
        c1 c1Var = new c1(captureSession, m(this.f1647i.k()));
        this.f1646h = c1Var;
        this.f1639a.a(c1Var);
        this.f1648j = ProcessorState.ON_CAPTURE_SESSION_STARTED;
        SessionConfig sessionConfig = this.f1645g;
        if (sessionConfig != null) {
            f(sessionConfig);
        }
        if (this.f1649k != null) {
            List asList = Arrays.asList(new d0[]{this.f1649k});
            this.f1649k = null;
            a(asList);
        }
    }
}
