package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.r2;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.n1;
import androidx.camera.core.v1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import r.o;
import r.r;
import u.f;

final class CaptureSession implements r1 {

    /* renamed from: a  reason: collision with root package name */
    final Object f1607a;

    /* renamed from: b  reason: collision with root package name */
    private final List<d0> f1608b;

    /* renamed from: c  reason: collision with root package name */
    private final CameraCaptureSession.CaptureCallback f1609c;

    /* renamed from: d  reason: collision with root package name */
    private final e f1610d;

    /* renamed from: e  reason: collision with root package name */
    d3 f1611e;

    /* renamed from: f  reason: collision with root package name */
    r2 f1612f;

    /* renamed from: g  reason: collision with root package name */
    SessionConfig f1613g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    Config f1614h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    n.c f1615i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<DeferrableSurface, Surface> f1616j;

    /* renamed from: k  reason: collision with root package name */
    List<DeferrableSurface> f1617k;

    /* renamed from: l  reason: collision with root package name */
    State f1618l;

    /* renamed from: m  reason: collision with root package name */
    zf.a<Void> f1619m;

    /* renamed from: n  reason: collision with root package name */
    CallbackToFutureAdapter.a<Void> f1620n;

    /* renamed from: o  reason: collision with root package name */
    final o f1621o;

    /* renamed from: p  reason: collision with root package name */
    final r f1622p;

    enum State {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    class a extends CameraCaptureSession.CaptureCallback {
        a() {
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        }
    }

    class b implements u.c<Void> {
        b() {
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
        }

        public void onFailure(@NonNull Throwable th2) {
            synchronized (CaptureSession.this.f1607a) {
                CaptureSession.this.f1611e.e();
                int i10 = d.f1635a[CaptureSession.this.f1618l.ordinal()];
                if (i10 == 4 || i10 == 6 || i10 == 7) {
                    if (!(th2 instanceof CancellationException)) {
                        v1.m("CaptureSession", "Opening session with fail " + CaptureSession.this.f1618l, th2);
                        CaptureSession.this.l();
                    }
                }
            }
        }
    }

    class c extends CameraCaptureSession.CaptureCallback {
        c() {
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            synchronized (CaptureSession.this.f1607a) {
                SessionConfig sessionConfig = CaptureSession.this.f1613g;
                if (sessionConfig != null) {
                    d0 h10 = sessionConfig.h();
                    v1.a("CaptureSession", "Submit FLASH_MODE_OFF request");
                    CaptureSession captureSession = CaptureSession.this;
                    captureSession.a(Collections.singletonList(captureSession.f1622p.a(h10)));
                }
            }
        }
    }

    static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1635a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.camera2.internal.CaptureSession$State[] r0 = androidx.camera.camera2.internal.CaptureSession.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1635a = r0
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1635a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1635a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.GET_SURFACE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1635a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.OPENING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1635a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.OPENED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1635a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.CLOSED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1635a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f1635a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.d.<clinit>():void");
        }
    }

    final class e extends r2.a {
        e() {
        }

        public void q(@NonNull r2 r2Var) {
            synchronized (CaptureSession.this.f1607a) {
                switch (d.f1635a[CaptureSession.this.f1618l.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                        throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + CaptureSession.this.f1618l);
                    case 4:
                    case 6:
                    case 7:
                        CaptureSession.this.l();
                        break;
                    case 8:
                        v1.a("CaptureSession", "ConfigureFailed callback after change to RELEASED state");
                        break;
                }
                v1.c("CaptureSession", "CameraCaptureSession.onConfigureFailed() " + CaptureSession.this.f1618l);
            }
        }

        public void r(@NonNull r2 r2Var) {
            synchronized (CaptureSession.this.f1607a) {
                switch (d.f1635a[CaptureSession.this.f1618l.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 8:
                        throw new IllegalStateException("onConfigured() should not be possible in state: " + CaptureSession.this.f1618l);
                    case 4:
                        CaptureSession captureSession = CaptureSession.this;
                        captureSession.f1618l = State.OPENED;
                        captureSession.f1612f = r2Var;
                        if (captureSession.f1613g != null) {
                            List<d0> c10 = captureSession.f1615i.d().c();
                            if (!c10.isEmpty()) {
                                CaptureSession captureSession2 = CaptureSession.this;
                                captureSession2.o(captureSession2.w(c10));
                            }
                        }
                        v1.a("CaptureSession", "Attempting to send capture request onConfigured");
                        CaptureSession captureSession3 = CaptureSession.this;
                        captureSession3.q(captureSession3.f1613g);
                        CaptureSession.this.p();
                        break;
                    case 6:
                        CaptureSession.this.f1612f = r2Var;
                        break;
                    case 7:
                        r2Var.close();
                        break;
                }
                v1.a("CaptureSession", "CameraCaptureSession.onConfigured() mState=" + CaptureSession.this.f1618l);
            }
        }

        public void s(@NonNull r2 r2Var) {
            synchronized (CaptureSession.this.f1607a) {
                if (d.f1635a[CaptureSession.this.f1618l.ordinal()] != 1) {
                    v1.a("CaptureSession", "CameraCaptureSession.onReady() " + CaptureSession.this.f1618l);
                } else {
                    throw new IllegalStateException("onReady() should not be possible in state: " + CaptureSession.this.f1618l);
                }
            }
        }

        public void t(@NonNull r2 r2Var) {
            synchronized (CaptureSession.this.f1607a) {
                if (CaptureSession.this.f1618l != State.UNINITIALIZED) {
                    v1.a("CaptureSession", "onSessionFinished()");
                    CaptureSession.this.l();
                } else {
                    throw new IllegalStateException("onSessionFinished() should not be possible in state: " + CaptureSession.this.f1618l);
                }
            }
        }
    }

    CaptureSession() {
        this.f1607a = new Object();
        this.f1608b = new ArrayList();
        this.f1609c = new a();
        this.f1614h = n1.L();
        this.f1615i = n.c.e();
        this.f1616j = new HashMap();
        this.f1617k = Collections.emptyList();
        this.f1618l = State.UNINITIALIZED;
        this.f1621o = new o();
        this.f1622p = new r();
        this.f1618l = State.INITIALIZED;
        this.f1610d = new e();
    }

    private CameraCaptureSession.CaptureCallback k(List<n> list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        for (n a10 : list) {
            arrayList.add(n1.a(a10));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return j0.a(arrayList);
    }

    @NonNull
    private p.b m(@NonNull SessionConfig.e eVar, @NonNull Map<DeferrableSurface, Surface> map, String str) {
        Surface surface = map.get(eVar.d());
        h.h(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        p.b bVar = new p.b(eVar.e(), surface);
        if (str != null) {
            bVar.e(str);
        } else {
            bVar.e(eVar.b());
        }
        if (!eVar.c().isEmpty()) {
            bVar.b();
            for (DeferrableSurface deferrableSurface : eVar.c()) {
                Surface surface2 = map.get(deferrableSurface);
                h.h(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                bVar.a(surface2);
            }
        }
        return bVar;
    }

    @NonNull
    private List<p.b> n(@NonNull List<p.b> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (p.b next : list) {
            if (!arrayList.contains(next.d())) {
                arrayList.add(next.d());
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(CameraCaptureSession cameraCaptureSession, int i10, boolean z10) {
        synchronized (this.f1607a) {
            if (this.f1618l == State.OPENED) {
                q(this.f1613g);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object t(CallbackToFutureAdapter.a aVar) throws Exception {
        boolean z10;
        String str;
        synchronized (this.f1607a) {
            if (this.f1620n == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.j(z10, "Release completer expected to be null");
            this.f1620n = aVar;
            str = "Release[session=" + this + "]";
        }
        return str;
    }

    @NonNull
    private static Config u(List<d0> list) {
        i1 O = i1.O();
        for (d0 d10 : list) {
            Config d11 = d10.d();
            for (Config.a next : d11.e()) {
                Object g10 = d11.g(next, null);
                if (O.b(next)) {
                    Object g11 = O.g(next, null);
                    if (!Objects.equals(g11, g10)) {
                        v1.a("CaptureSession", "Detect conflicting option " + next.c() + " : " + g10 + " != " + g11);
                    }
                } else {
                    O.p(next, g10);
                }
            }
        }
        return O;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0132, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0138, code lost:
        return u.f.f(r11);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    @androidx.annotation.NonNull
    /* renamed from: v */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zf.a<java.lang.Void> s(@androidx.annotation.NonNull java.util.List<android.view.Surface> r11, @androidx.annotation.NonNull androidx.camera.core.impl.SessionConfig r12, @androidx.annotation.NonNull android.hardware.camera2.CameraDevice r13) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f1607a
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.d.f1635a     // Catch:{ all -> 0x0157 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r10.f1618l     // Catch:{ all -> 0x0157 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0157 }
            r1 = r1[r2]     // Catch:{ all -> 0x0157 }
            r2 = 1
            if (r1 == r2) goto L_0x0139
            r3 = 2
            if (r1 == r3) goto L_0x0139
            r4 = 3
            r5 = 5
            if (r1 == r4) goto L_0x0037
            if (r1 == r5) goto L_0x0139
            java.util.concurrent.CancellationException r11 = new java.util.concurrent.CancellationException     // Catch:{ all -> 0x0157 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0157 }
            r12.<init>()     // Catch:{ all -> 0x0157 }
            java.lang.String r13 = "openCaptureSession() not execute in state: "
            r12.append(r13)     // Catch:{ all -> 0x0157 }
            androidx.camera.camera2.internal.CaptureSession$State r13 = r10.f1618l     // Catch:{ all -> 0x0157 }
            r12.append(r13)     // Catch:{ all -> 0x0157 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0157 }
            r11.<init>(r12)     // Catch:{ all -> 0x0157 }
            zf.a r11 = u.f.f(r11)     // Catch:{ all -> 0x0157 }
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            return r11
        L_0x0037:
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r1 = r10.f1616j     // Catch:{ all -> 0x0157 }
            r1.clear()     // Catch:{ all -> 0x0157 }
            r1 = 0
            r4 = r1
        L_0x003e:
            int r6 = r11.size()     // Catch:{ all -> 0x0157 }
            if (r4 >= r6) goto L_0x005a
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r6 = r10.f1616j     // Catch:{ all -> 0x0157 }
            java.util.List<androidx.camera.core.impl.DeferrableSurface> r7 = r10.f1617k     // Catch:{ all -> 0x0157 }
            java.lang.Object r7 = r7.get(r4)     // Catch:{ all -> 0x0157 }
            androidx.camera.core.impl.DeferrableSurface r7 = (androidx.camera.core.impl.DeferrableSurface) r7     // Catch:{ all -> 0x0157 }
            java.lang.Object r8 = r11.get(r4)     // Catch:{ all -> 0x0157 }
            android.view.Surface r8 = (android.view.Surface) r8     // Catch:{ all -> 0x0157 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0157 }
            int r4 = r4 + 1
            goto L_0x003e
        L_0x005a:
            androidx.camera.camera2.internal.CaptureSession$State r11 = androidx.camera.camera2.internal.CaptureSession.State.OPENING     // Catch:{ all -> 0x0157 }
            r10.f1618l = r11     // Catch:{ all -> 0x0157 }
            java.lang.String r11 = "CaptureSession"
            java.lang.String r4 = "Opening capture session."
            androidx.camera.core.v1.a(r11, r4)     // Catch:{ all -> 0x0157 }
            androidx.camera.camera2.internal.r2$a[] r11 = new androidx.camera.camera2.internal.r2.a[r3]     // Catch:{ all -> 0x0157 }
            androidx.camera.camera2.internal.CaptureSession$e r3 = r10.f1610d     // Catch:{ all -> 0x0157 }
            r11[r1] = r3     // Catch:{ all -> 0x0157 }
            androidx.camera.camera2.internal.e3$a r3 = new androidx.camera.camera2.internal.e3$a     // Catch:{ all -> 0x0157 }
            java.util.List r4 = r12.i()     // Catch:{ all -> 0x0157 }
            r3.<init>((java.util.List<android.hardware.camera2.CameraCaptureSession.StateCallback>) r4)     // Catch:{ all -> 0x0157 }
            r11[r2] = r3     // Catch:{ all -> 0x0157 }
            androidx.camera.camera2.internal.r2$a r11 = androidx.camera.camera2.internal.e3.v(r11)     // Catch:{ all -> 0x0157 }
            n.a r2 = new n.a     // Catch:{ all -> 0x0157 }
            androidx.camera.core.impl.Config r3 = r12.d()     // Catch:{ all -> 0x0157 }
            r2.<init>(r3)     // Catch:{ all -> 0x0157 }
            n.c r3 = n.c.e()     // Catch:{ all -> 0x0157 }
            n.c r3 = r2.L(r3)     // Catch:{ all -> 0x0157 }
            r10.f1615i = r3     // Catch:{ all -> 0x0157 }
            n.c$a r3 = r3.d()     // Catch:{ all -> 0x0157 }
            java.util.List r3 = r3.d()     // Catch:{ all -> 0x0157 }
            androidx.camera.core.impl.d0 r4 = r12.h()     // Catch:{ all -> 0x0157 }
            androidx.camera.core.impl.d0$a r4 = androidx.camera.core.impl.d0.a.k(r4)     // Catch:{ all -> 0x0157 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0157 }
        L_0x00a1:
            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x0157 }
            if (r6 == 0) goto L_0x00b5
            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x0157 }
            androidx.camera.core.impl.d0 r6 = (androidx.camera.core.impl.d0) r6     // Catch:{ all -> 0x0157 }
            androidx.camera.core.impl.Config r6 = r6.d()     // Catch:{ all -> 0x0157 }
            r4.e(r6)     // Catch:{ all -> 0x0157 }
            goto L_0x00a1
        L_0x00b5:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0157 }
            r3.<init>()     // Catch:{ all -> 0x0157 }
            r6 = 0
            java.lang.String r2 = r2.Q(r6)     // Catch:{ all -> 0x0157 }
            java.util.List r6 = r12.f()     // Catch:{ all -> 0x0157 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0157 }
        L_0x00c7:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0157 }
            if (r7 == 0) goto L_0x00fa
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0157 }
            androidx.camera.core.impl.SessionConfig$e r7 = (androidx.camera.core.impl.SessionConfig.e) r7     // Catch:{ all -> 0x0157 }
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r8 = r10.f1616j     // Catch:{ all -> 0x0157 }
            p.b r7 = r10.m(r7, r8, r2)     // Catch:{ all -> 0x0157 }
            androidx.camera.core.impl.Config r8 = r12.d()     // Catch:{ all -> 0x0157 }
            androidx.camera.core.impl.Config$a<java.lang.Long> r9 = n.a.C     // Catch:{ all -> 0x0157 }
            boolean r8 = r8.b(r9)     // Catch:{ all -> 0x0157 }
            if (r8 == 0) goto L_0x00f6
            androidx.camera.core.impl.Config r8 = r12.d()     // Catch:{ all -> 0x0157 }
            java.lang.Object r8 = r8.a(r9)     // Catch:{ all -> 0x0157 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0157 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x0157 }
            r7.f(r8)     // Catch:{ all -> 0x0157 }
        L_0x00f6:
            r3.add(r7)     // Catch:{ all -> 0x0157 }
            goto L_0x00c7
        L_0x00fa:
            java.util.List r2 = r10.n(r3)     // Catch:{ all -> 0x0157 }
            androidx.camera.camera2.internal.d3 r3 = r10.f1611e     // Catch:{ all -> 0x0157 }
            p.k r11 = r3.a(r1, r2, r11)     // Catch:{ all -> 0x0157 }
            int r1 = r12.l()     // Catch:{ all -> 0x0157 }
            if (r1 != r5) goto L_0x011b
            android.hardware.camera2.params.InputConfiguration r1 = r12.e()     // Catch:{ all -> 0x0157 }
            if (r1 == 0) goto L_0x011b
            android.hardware.camera2.params.InputConfiguration r12 = r12.e()     // Catch:{ all -> 0x0157 }
            p.a r12 = p.a.b(r12)     // Catch:{ all -> 0x0157 }
            r11.f(r12)     // Catch:{ all -> 0x0157 }
        L_0x011b:
            androidx.camera.core.impl.d0 r12 = r4.h()     // Catch:{ CameraAccessException -> 0x0132 }
            android.hardware.camera2.CaptureRequest r12 = androidx.camera.camera2.internal.a1.c(r12, r13)     // Catch:{ CameraAccessException -> 0x0132 }
            if (r12 == 0) goto L_0x0128
            r11.g(r12)     // Catch:{ CameraAccessException -> 0x0132 }
        L_0x0128:
            androidx.camera.camera2.internal.d3 r12 = r10.f1611e     // Catch:{ all -> 0x0157 }
            java.util.List<androidx.camera.core.impl.DeferrableSurface> r1 = r10.f1617k     // Catch:{ all -> 0x0157 }
            zf.a r11 = r12.c(r13, r11, r1)     // Catch:{ all -> 0x0157 }
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            return r11
        L_0x0132:
            r11 = move-exception
            zf.a r11 = u.f.f(r11)     // Catch:{ all -> 0x0157 }
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            return r11
        L_0x0139:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0157 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0157 }
            r12.<init>()     // Catch:{ all -> 0x0157 }
            java.lang.String r13 = "openCaptureSession() should not be possible in state: "
            r12.append(r13)     // Catch:{ all -> 0x0157 }
            androidx.camera.camera2.internal.CaptureSession$State r13 = r10.f1618l     // Catch:{ all -> 0x0157 }
            r12.append(r13)     // Catch:{ all -> 0x0157 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0157 }
            r11.<init>(r12)     // Catch:{ all -> 0x0157 }
            zf.a r11 = u.f.f(r11)     // Catch:{ all -> 0x0157 }
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            return r11
        L_0x0157:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.s(java.util.List, androidx.camera.core.impl.SessionConfig, android.hardware.camera2.CameraDevice):zf.a");
    }

    public void a(@NonNull List<d0> list) {
        synchronized (this.f1607a) {
            switch (d.f1635a[this.f1618l.ordinal()]) {
                case 1:
                    throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.f1618l);
                case 2:
                case 3:
                case 4:
                    this.f1608b.addAll(list);
                    break;
                case 5:
                    this.f1608b.addAll(list);
                    p();
                    break;
                case 6:
                case 7:
                case 8:
                    throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
            }
        }
    }

    public void b() {
        ArrayList<d0> arrayList;
        synchronized (this.f1607a) {
            if (!this.f1608b.isEmpty()) {
                arrayList = new ArrayList<>(this.f1608b);
                this.f1608b.clear();
            } else {
                arrayList = null;
            }
        }
        if (arrayList != null) {
            for (d0 b10 : arrayList) {
                for (n a10 : b10.b()) {
                    a10.a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        r3.f1615i.d().a();
        r3.f1618l = androidx.camera.camera2.internal.CaptureSession.State.f1629g;
        r4 = r3.f1611e;
        androidx.core.util.h.h(r4, "The Opener shouldn't null in state:" + r3.f1618l);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r3.f1611e.e() == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (r3.f1619m != null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        r3.f1619m = androidx.concurrent.futures.CallbackToFutureAdapter.a(new androidx.camera.camera2.internal.q1(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        r4 = r3.f1619m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        r3.f1618l = androidx.camera.camera2.internal.CaptureSession.State.f1630h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ae, code lost:
        return u.f.h(null);
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zf.a<java.lang.Void> c(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1607a
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.d.f1635a     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f1618l     // Catch:{ all -> 0x00af }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x00af }
            r1 = r1[r2]     // Catch:{ all -> 0x00af }
            switch(r1) {
                case 1: goto L_0x008f;
                case 2: goto L_0x008a;
                case 3: goto L_0x006d;
                case 4: goto L_0x0029;
                case 5: goto L_0x0012;
                case 6: goto L_0x0012;
                case 7: goto L_0x005a;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x00af }
        L_0x0010:
            goto L_0x00a8
        L_0x0012:
            androidx.camera.camera2.internal.r2 r1 = r3.f1612f     // Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x0029
            if (r4 == 0) goto L_0x0024
            r1.e()     // Catch:{ CameraAccessException -> 0x001c }
            goto L_0x0024
        L_0x001c:
            r4 = move-exception
            java.lang.String r1 = "CaptureSession"
            java.lang.String r2 = "Unable to abort captures."
            androidx.camera.core.v1.d(r1, r2, r4)     // Catch:{ all -> 0x00af }
        L_0x0024:
            androidx.camera.camera2.internal.r2 r4 = r3.f1612f     // Catch:{ all -> 0x00af }
            r4.close()     // Catch:{ all -> 0x00af }
        L_0x0029:
            n.c r4 = r3.f1615i     // Catch:{ all -> 0x00af }
            n.c$a r4 = r4.d()     // Catch:{ all -> 0x00af }
            r4.a()     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch:{ all -> 0x00af }
            r3.f1618l = r4     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.d3 r4 = r3.f1611e     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r1.<init>()     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f1618l     // Catch:{ all -> 0x00af }
            r1.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00af }
            androidx.core.util.h.h(r4, r1)     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.d3 r4 = r3.f1611e     // Catch:{ all -> 0x00af }
            boolean r4 = r4.e()     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x005a
            r3.l()     // Catch:{ all -> 0x00af }
            goto L_0x00a8
        L_0x005a:
            zf.a<java.lang.Void> r4 = r3.f1619m     // Catch:{ all -> 0x00af }
            if (r4 != 0) goto L_0x0069
            androidx.camera.camera2.internal.q1 r4 = new androidx.camera.camera2.internal.q1     // Catch:{ all -> 0x00af }
            r4.<init>(r3)     // Catch:{ all -> 0x00af }
            zf.a r4 = androidx.concurrent.futures.CallbackToFutureAdapter.a(r4)     // Catch:{ all -> 0x00af }
            r3.f1619m = r4     // Catch:{ all -> 0x00af }
        L_0x0069:
            zf.a<java.lang.Void> r4 = r3.f1619m     // Catch:{ all -> 0x00af }
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            return r4
        L_0x006d:
            androidx.camera.camera2.internal.d3 r4 = r3.f1611e     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r1.<init>()     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f1618l     // Catch:{ all -> 0x00af }
            r1.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00af }
            androidx.core.util.h.h(r4, r1)     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.d3 r4 = r3.f1611e     // Catch:{ all -> 0x00af }
            r4.e()     // Catch:{ all -> 0x00af }
        L_0x008a:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch:{ all -> 0x00af }
            r3.f1618l = r4     // Catch:{ all -> 0x00af }
            goto L_0x00a8
        L_0x008f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r1.<init>()     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "release() should not be possible in state: "
            r1.append(r2)     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f1618l     // Catch:{ all -> 0x00af }
            r1.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00af }
            r4.<init>(r1)     // Catch:{ all -> 0x00af }
            throw r4     // Catch:{ all -> 0x00af }
        L_0x00a8:
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            r4 = 0
            zf.a r4 = u.f.h(r4)
            return r4
        L_0x00af:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.c(boolean):zf.a");
    }

    public void close() {
        synchronized (this.f1607a) {
            int i10 = d.f1635a[this.f1618l.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 == 5) {
                                if (this.f1613g != null) {
                                    List<d0> b10 = this.f1615i.d().b();
                                    if (!b10.isEmpty()) {
                                        try {
                                            a(w(b10));
                                        } catch (IllegalStateException e10) {
                                            v1.d("CaptureSession", "Unable to issue the request before close the capture session", e10);
                                        }
                                    }
                                }
                            }
                        }
                        d3 d3Var = this.f1611e;
                        h.h(d3Var, "The Opener shouldn't null in state:" + this.f1618l);
                        this.f1611e.e();
                        this.f1618l = State.CLOSED;
                        this.f1613g = null;
                    } else {
                        d3 d3Var2 = this.f1611e;
                        h.h(d3Var2, "The Opener shouldn't null in state:" + this.f1618l);
                        this.f1611e.e();
                    }
                }
                this.f1618l = State.RELEASED;
            } else {
                throw new IllegalStateException("close() should not be possible in state: " + this.f1618l);
            }
        }
    }

    @NonNull
    public List<d0> d() {
        List<d0> unmodifiableList;
        synchronized (this.f1607a) {
            unmodifiableList = Collections.unmodifiableList(this.f1608b);
        }
        return unmodifiableList;
    }

    public SessionConfig e() {
        SessionConfig sessionConfig;
        synchronized (this.f1607a) {
            sessionConfig = this.f1613g;
        }
        return sessionConfig;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(androidx.camera.core.impl.SessionConfig r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1607a
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.d.f1635a     // Catch:{ all -> 0x0063 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f1618l     // Catch:{ all -> 0x0063 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0063 }
            r1 = r1[r2]     // Catch:{ all -> 0x0063 }
            switch(r1) {
                case 1: goto L_0x0048;
                case 2: goto L_0x0045;
                case 3: goto L_0x0045;
                case 4: goto L_0x0045;
                case 5: goto L_0x0019;
                case 6: goto L_0x0011;
                case 7: goto L_0x0011;
                case 8: goto L_0x0011;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x0063 }
        L_0x0010:
            goto L_0x0061
        L_0x0011:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "Session configuration cannot be set on a closed/released session."
            r4.<init>(r1)     // Catch:{ all -> 0x0063 }
            throw r4     // Catch:{ all -> 0x0063 }
        L_0x0019:
            r3.f1613g = r4     // Catch:{ all -> 0x0063 }
            if (r4 != 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x001f:
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r1 = r3.f1616j     // Catch:{ all -> 0x0063 }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x0063 }
            java.util.List r4 = r4.k()     // Catch:{ all -> 0x0063 }
            boolean r4 = r1.containsAll(r4)     // Catch:{ all -> 0x0063 }
            if (r4 != 0) goto L_0x0038
            java.lang.String r4 = "CaptureSession"
            java.lang.String r1 = "Does not have the proper configured lists"
            androidx.camera.core.v1.c(r4, r1)     // Catch:{ all -> 0x0063 }
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x0038:
            java.lang.String r4 = "CaptureSession"
            java.lang.String r1 = "Attempting to submit CaptureRequest after setting"
            androidx.camera.core.v1.a(r4, r1)     // Catch:{ all -> 0x0063 }
            androidx.camera.core.impl.SessionConfig r4 = r3.f1613g     // Catch:{ all -> 0x0063 }
            r3.q(r4)     // Catch:{ all -> 0x0063 }
            goto L_0x0061
        L_0x0045:
            r3.f1613g = r4     // Catch:{ all -> 0x0063 }
            goto L_0x0061
        L_0x0048:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0063 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r1.<init>()     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = "setSessionConfig() should not be possible in state: "
            r1.append(r2)     // Catch:{ all -> 0x0063 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f1618l     // Catch:{ all -> 0x0063 }
            r1.append(r2)     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0063 }
            r4.<init>(r1)     // Catch:{ all -> 0x0063 }
            throw r4     // Catch:{ all -> 0x0063 }
        L_0x0061:
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x0063:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.f(androidx.camera.core.impl.SessionConfig):void");
    }

    @NonNull
    public zf.a<Void> g(@NonNull SessionConfig sessionConfig, @NonNull CameraDevice cameraDevice, @NonNull d3 d3Var) {
        synchronized (this.f1607a) {
            if (d.f1635a[this.f1618l.ordinal()] != 2) {
                v1.c("CaptureSession", "Open not allowed in state: " + this.f1618l);
                zf.a<Void> f10 = f.f(new IllegalStateException("open() should not allow the state: " + this.f1618l));
                return f10;
            }
            this.f1618l = State.GET_SURFACE;
            ArrayList arrayList = new ArrayList(sessionConfig.k());
            this.f1617k = arrayList;
            this.f1611e = d3Var;
            u.d<T> e10 = u.d.a(d3Var.d(arrayList, 5000)).e(new p1(this, sessionConfig, cameraDevice), this.f1611e.b());
            f.b(e10, new b(), this.f1611e.b());
            zf.a<Void> j10 = f.j(e10);
            return j10;
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        State state = this.f1618l;
        State state2 = State.RELEASED;
        if (state == state2) {
            v1.a("CaptureSession", "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.f1618l = state2;
        this.f1612f = null;
        CallbackToFutureAdapter.a<Void> aVar = this.f1620n;
        if (aVar != null) {
            aVar.c(null);
            this.f1620n = null;
        }
    }

    /* access modifiers changed from: package-private */
    public int o(List<d0> list) {
        boolean z10;
        synchronized (this.f1607a) {
            if (list.isEmpty()) {
                return -1;
            }
            try {
                f1 f1Var = new f1();
                ArrayList arrayList = new ArrayList();
                v1.a("CaptureSession", "Issuing capture request.");
                boolean z11 = false;
                for (d0 next : list) {
                    if (next.e().isEmpty()) {
                        v1.a("CaptureSession", "Skipping issuing empty capture request.");
                    } else {
                        Iterator<DeferrableSurface> it = next.e().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z10 = true;
                                break;
                            }
                            DeferrableSurface next2 = it.next();
                            if (!this.f1616j.containsKey(next2)) {
                                v1.a("CaptureSession", "Skipping capture request with invalid surface: " + next2);
                                z10 = false;
                                break;
                            }
                        }
                        if (z10) {
                            if (next.g() == 2) {
                                z11 = true;
                            }
                            d0.a k10 = d0.a.k(next);
                            if (next.g() == 5 && next.c() != null) {
                                k10.o(next.c());
                            }
                            SessionConfig sessionConfig = this.f1613g;
                            if (sessionConfig != null) {
                                k10.e(sessionConfig.h().d());
                            }
                            k10.e(this.f1614h);
                            k10.e(next.d());
                            CaptureRequest b10 = a1.b(k10.h(), this.f1612f.f(), this.f1616j);
                            if (b10 == null) {
                                v1.a("CaptureSession", "Skipping issuing request without surface.");
                                return -1;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (n b11 : next.b()) {
                                n1.b(b11, arrayList2);
                            }
                            f1Var.a(b10, arrayList2);
                            arrayList.add(b10);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    if (this.f1621o.a(arrayList, z11)) {
                        this.f1612f.l();
                        f1Var.c(new o1(this));
                    }
                    if (this.f1622p.b(arrayList, z11)) {
                        f1Var.a((CaptureRequest) arrayList.get(arrayList.size() - 1), Collections.singletonList(new c()));
                    }
                    int j10 = this.f1612f.j(arrayList, f1Var);
                    return j10;
                }
                v1.a("CaptureSession", "Skipping issuing burst request due to no valid request elements");
            } catch (CameraAccessException e10) {
                v1.c("CaptureSession", "Unable to access camera: " + e10.getMessage());
                Thread.dumpStack();
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        if (!this.f1608b.isEmpty()) {
            try {
                o(this.f1608b);
            } finally {
                this.f1608b.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int q(SessionConfig sessionConfig) {
        synchronized (this.f1607a) {
            if (sessionConfig == null) {
                v1.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no configuration case.");
                return -1;
            }
            d0 h10 = sessionConfig.h();
            if (h10.e().isEmpty()) {
                v1.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no surface.");
                try {
                    this.f1612f.l();
                } catch (CameraAccessException e10) {
                    v1.c("CaptureSession", "Unable to access camera: " + e10.getMessage());
                    Thread.dumpStack();
                }
            } else {
                try {
                    v1.a("CaptureSession", "Issuing request for session.");
                    d0.a k10 = d0.a.k(h10);
                    Config u10 = u(this.f1615i.d().e());
                    this.f1614h = u10;
                    k10.e(u10);
                    CaptureRequest b10 = a1.b(k10.h(), this.f1612f.f(), this.f1616j);
                    if (b10 == null) {
                        v1.a("CaptureSession", "Skipping issuing empty request for session.");
                        return -1;
                    }
                    int g10 = this.f1612f.g(b10, k(h10.b(), this.f1609c));
                    return g10;
                } catch (CameraAccessException e11) {
                    v1.c("CaptureSession", "Unable to access camera: " + e11.getMessage());
                    Thread.dumpStack();
                    return -1;
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public List<d0> w(List<d0> list) {
        ArrayList arrayList = new ArrayList();
        for (d0 k10 : list) {
            d0.a k11 = d0.a.k(k10);
            k11.q(1);
            for (DeferrableSurface f10 : this.f1613g.h().e()) {
                k11.f(f10);
            }
            arrayList.add(k11.h());
        }
        return arrayList;
    }
}
