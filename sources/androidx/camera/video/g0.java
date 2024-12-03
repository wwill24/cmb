package androidx.camera.video;

import a0.a0;
import a0.d0;
import a0.k;
import a0.u;
import a0.w;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.MediaCodec;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.h1;
import androidx.camera.core.impl.l1;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.utils.q;
import androidx.camera.core.impl.v0;
import androidx.camera.core.v1;
import androidx.camera.video.StreamInfo;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.i1;
import androidx.camera.video.internal.encoder.j1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import b0.t;
import b0.v;
import b0.x;
import b0.y;
import b0.z;
import com.google.android.gms.common.api.a;
import f0.i;
import f0.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.cli.HelpFormatter;
import u.f;

public final class g0<T extends VideoOutput> extends UseCase {

    /* renamed from: w  reason: collision with root package name */
    private static final e f3111w = new e();

    /* renamed from: x  reason: collision with root package name */
    private static final boolean f3112x;

    /* renamed from: y  reason: collision with root package name */
    private static final boolean f3113y;

    /* renamed from: z  reason: collision with root package name */
    private static final boolean f3114z;

    /* renamed from: m  reason: collision with root package name */
    DeferrableSurface f3115m;

    /* renamed from: n  reason: collision with root package name */
    StreamInfo f3116n = StreamInfo.f3065a;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    SessionConfig.b f3117o = new SessionConfig.b();

    /* renamed from: p  reason: collision with root package name */
    zf.a<Void> f3118p = null;

    /* renamed from: q  reason: collision with root package name */
    private SurfaceRequest f3119q;

    /* renamed from: r  reason: collision with root package name */
    VideoOutput.SourceState f3120r = VideoOutput.SourceState.INACTIVE;

    /* renamed from: s  reason: collision with root package name */
    private a0 f3121s;

    /* renamed from: t  reason: collision with root package name */
    private d0 f3122t;

    /* renamed from: u  reason: collision with root package name */
    private i1 f3123u;

    /* renamed from: v  reason: collision with root package name */
    private final l1.a<StreamInfo> f3124v = new a();

    class a implements l1.a<StreamInfo> {
        a() {
        }

        /* renamed from: b */
        public void a(StreamInfo streamInfo) {
            if (streamInfo == null) {
                throw new IllegalArgumentException("StreamInfo can't be null");
            } else if (g0.this.f3120r != VideoOutput.SourceState.INACTIVE) {
                v1.a("VideoCapture", "Stream info update: old: " + g0.this.f3116n + " new: " + streamInfo);
                g0 g0Var = g0.this;
                StreamInfo streamInfo2 = g0Var.f3116n;
                g0Var.f3116n = streamInfo;
                Set<Integer> set = StreamInfo.f3066b;
                if (!set.contains(Integer.valueOf(streamInfo2.a())) && !set.contains(Integer.valueOf(streamInfo.a())) && streamInfo2.a() != streamInfo.a()) {
                    g0 g0Var2 = g0.this;
                    g0Var2.t0(g0Var2.f(), (c0.a) g0.this.g(), (Size) h.g(g0.this.c()));
                } else if ((streamInfo2.a() != -1 && streamInfo.a() == -1) || (streamInfo2.a() == -1 && streamInfo.a() != -1)) {
                    g0 g0Var3 = g0.this;
                    g0Var3.b0(g0Var3.f3117o, streamInfo);
                    g0 g0Var4 = g0.this;
                    g0Var4.J(g0Var4.f3117o.m());
                    g0.this.u();
                } else if (streamInfo2.b() != streamInfo.b()) {
                    g0 g0Var5 = g0.this;
                    g0Var5.b0(g0Var5.f3117o, streamInfo);
                    g0 g0Var6 = g0.this;
                    g0Var6.J(g0Var6.f3117o.m());
                    g0.this.w();
                }
            }
        }

        public void onError(@NonNull Throwable th2) {
            v1.m("VideoCapture", "Receive onError from StreamState observer", th2);
        }
    }

    class b extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f3126a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f3127b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SessionConfig.b f3128c;

        b(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.a aVar, SessionConfig.b bVar) {
            this.f3126a = atomicBoolean;
            this.f3127b = aVar;
            this.f3128c = bVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(SessionConfig.b bVar) {
            bVar.q(this);
        }

        public void b(@NonNull p pVar) {
            Object c10;
            super.b(pVar);
            if (!this.f3126a.get() && (c10 = pVar.c().c("androidx.camera.video.VideoCapture.streamUpdate")) != null && ((Integer) c10).intValue() == this.f3127b.hashCode() && this.f3127b.c(null) && !this.f3126a.getAndSet(true)) {
                androidx.camera.core.impl.utils.executor.a.d().execute(new h0(this, this.f3128c));
            }
        }
    }

    class c implements u.c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ zf.a f3130a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f3131b;

        c(zf.a aVar, boolean z10) {
            this.f3130a = aVar;
            this.f3131b = z10;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            VideoOutput.SourceState sourceState;
            zf.a<Void> aVar = this.f3130a;
            g0 g0Var = g0.this;
            if (aVar == g0Var.f3118p && g0Var.f3120r != VideoOutput.SourceState.INACTIVE) {
                if (this.f3131b) {
                    sourceState = VideoOutput.SourceState.ACTIVE_STREAMING;
                } else {
                    sourceState = VideoOutput.SourceState.ACTIVE_NON_STREAMING;
                }
                g0Var.w0(sourceState);
            }
        }

        public void onFailure(@NonNull Throwable th2) {
            if (!(th2 instanceof CancellationException)) {
                v1.d("VideoCapture", "Surface update completed with unexpected exception", th2);
            }
        }
    }

    public static final class d<T extends VideoOutput> implements f2.a<g0<T>, c0.a<T>, d<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.camera.core.impl.i1 f3133a;

        d(@NonNull T t10) {
            this(d(t10));
        }

        @NonNull
        private static <T extends VideoOutput> androidx.camera.core.impl.i1 d(@NonNull T t10) {
            androidx.camera.core.impl.i1 O = androidx.camera.core.impl.i1.O();
            O.p(c0.a.B, t10);
            return O;
        }

        @NonNull
        static d<? extends VideoOutput> e(@NonNull Config config) {
            return new d<>(androidx.camera.core.impl.i1.P(config));
        }

        @NonNull
        public h1 a() {
            return this.f3133a;
        }

        @NonNull
        public g0<T> c() {
            return new g0<>(b());
        }

        @NonNull
        /* renamed from: f */
        public c0.a<T> b() {
            return new c0.a<>(n1.M(this.f3133a));
        }

        @NonNull
        public d<T> g(int i10) {
            a().p(f2.f2528r, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public d<T> h(@NonNull Class<g0<T>> cls) {
            a().p(v.h.f18039x, cls);
            if (a().g(v.h.f18038w, null) == null) {
                i(cls.getCanonicalName() + HelpFormatter.DEFAULT_OPT_PREFIX + UUID.randomUUID());
            }
            return this;
        }

        @NonNull
        public d<T> i(@NonNull String str) {
            a().p(v.h.f18038w, str);
            return this;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public d<T> j(@NonNull k.a<androidx.camera.video.internal.encoder.h1, i1> aVar) {
            a().p(c0.a.C, aVar);
            return this;
        }

        private d(@NonNull androidx.camera.core.impl.i1 i1Var) {
            Class<g0> cls = g0.class;
            this.f3133a = i1Var;
            if (i1Var.b(c0.a.B)) {
                Class cls2 = (Class) i1Var.g(v.h.f18039x, null);
                if (cls2 == null || cls2.equals(cls)) {
                    h(cls);
                    return;
                }
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls2);
            }
            throw new IllegalArgumentException("VideoOutput is required");
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        private static final VideoOutput f3134a;

        /* renamed from: b  reason: collision with root package name */
        private static final c0.a<?> f3135b;

        /* renamed from: c  reason: collision with root package name */
        private static final k.a<androidx.camera.video.internal.encoder.h1, i1> f3136c;

        /* renamed from: d  reason: collision with root package name */
        static final Range<Integer> f3137d = new Range<>(30, 30);

        static {
            y yVar = new y();
            f3134a = yVar;
            z zVar = new z();
            f3136c = zVar;
            f3135b = new d(yVar).g(5).j(zVar).b();
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ i1 c(androidx.camera.video.internal.encoder.h1 h1Var) {
            try {
                return j1.h(h1Var);
            } catch (InvalidConfigException e10) {
                v1.m("VideoCapture", "Unable to find VideoEncoderInfo", e10);
                return null;
            }
        }

        @NonNull
        public c0.a<?> b() {
            return f3135b;
        }
    }

    static {
        boolean z10;
        boolean z11;
        boolean z12 = true;
        if (f0.e.a(o.class) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        f3112x = z10;
        if (f0.e.a(f0.n.class) != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        f3113y = z11;
        if (f0.e.a(i.class) == null) {
            z12 = false;
        }
        f3114z = z12;
    }

    g0(@NonNull c0.a<T> aVar) {
        super(aVar);
    }

    private static void V(@NonNull Set<Size> set, int i10, int i11, @NonNull Size size, @NonNull i1 i1Var) {
        if (i10 <= size.getWidth() && i11 <= size.getHeight()) {
            try {
                set.add(new Size(i10, i1Var.d(i10).clamp(Integer.valueOf(i11)).intValue()));
            } catch (IllegalArgumentException e10) {
                v1.m("VideoCapture", "No supportedHeights for width: " + i10, e10);
            }
            try {
                set.add(new Size(i1Var.a(i11).clamp(Integer.valueOf(i10)).intValue(), i11));
            } catch (IllegalArgumentException e11) {
                v1.m("VideoCapture", "No supportedWidths for height: " + i11, e11);
            }
        }
    }

    @NonNull
    private Rect W(@NonNull Rect rect, @NonNull Size size, @NonNull androidx.core.util.i<i1> iVar) {
        if (!n0(rect, size)) {
            return rect;
        }
        i1 i1Var = iVar.get();
        if (i1Var != null) {
            return X(rect, size, i1Var);
        }
        v1.l("VideoCapture", "Crop is needed but can't find the encoder info to adjust the cropRect");
        return rect;
    }

    @NonNull
    private static Rect X(@NonNull Rect rect, @NonNull Size size, @NonNull i1 i1Var) {
        boolean z10;
        v1.a("VideoCapture", String.format("Adjust cropRect %s by width/height alignment %d/%d and supported widths %s / supported heights %s", new Object[]{q.i(rect), Integer.valueOf(i1Var.c()), Integer.valueOf(i1Var.b()), i1Var.e(), i1Var.f()}));
        int c10 = i1Var.c();
        int b10 = i1Var.b();
        Range<Integer> e10 = i1Var.e();
        Range<Integer> f10 = i1Var.f();
        int Z = Z(rect.width(), c10, e10);
        int a02 = a0(rect.width(), c10, e10);
        int Z2 = Z(rect.height(), b10, f10);
        int a03 = a0(rect.height(), b10, f10);
        HashSet hashSet = new HashSet();
        V(hashSet, Z, Z2, size, i1Var);
        V(hashSet, Z, a03, size, i1Var);
        V(hashSet, a02, Z2, size, i1Var);
        V(hashSet, a02, a03, size, i1Var);
        if (hashSet.isEmpty()) {
            v1.l("VideoCapture", "Can't find valid cropped size");
            return rect;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        v1.a("VideoCapture", "candidatesList = " + arrayList);
        Collections.sort(arrayList, new x(rect));
        v1.a("VideoCapture", "sorted candidatesList = " + arrayList);
        Size size2 = (Size) arrayList.get(0);
        int width = size2.getWidth();
        int height = size2.getHeight();
        if (width == rect.width() && height == rect.height()) {
            v1.a("VideoCapture", "No need to adjust cropRect because crop size is valid.");
            return rect;
        }
        if (width % 2 != 0 || height % 2 != 0 || width > size.getWidth() || height > size.getHeight()) {
            z10 = false;
        } else {
            z10 = true;
        }
        h.i(z10);
        Rect rect2 = new Rect(rect);
        if (width != rect.width()) {
            int max = Math.max(0, rect.centerX() - (width / 2));
            rect2.left = max;
            int i10 = max + width;
            rect2.right = i10;
            if (i10 > size.getWidth()) {
                int width2 = size.getWidth();
                rect2.right = width2;
                rect2.left = width2 - width;
            }
        }
        if (height != rect.height()) {
            int max2 = Math.max(0, rect.centerY() - (height / 2));
            rect2.top = max2;
            int i11 = max2 + height;
            rect2.bottom = i11;
            if (i11 > size.getHeight()) {
                int height2 = size.getHeight();
                rect2.bottom = height2;
                rect2.top = height2 - height;
            }
        }
        v1.a("VideoCapture", String.format("Adjust cropRect from %s to %s", new Object[]{q.i(rect), q.i(rect2)}));
        return rect2;
    }

    private static int Y(boolean z10, int i10, int i11, @NonNull Range<Integer> range) {
        int i12 = i10 % i11;
        if (i12 != 0) {
            if (z10) {
                i10 -= i12;
            } else {
                i10 += i11 - i12;
            }
        }
        return range.clamp(Integer.valueOf(i10)).intValue();
    }

    private static int Z(int i10, int i11, @NonNull Range<Integer> range) {
        return Y(true, i10, i11, range);
    }

    private static int a0(int i10, int i11, @NonNull Range<Integer> range) {
        return Y(false, i10, i11, range);
    }

    private void c0() {
        androidx.camera.core.impl.utils.p.a();
        DeferrableSurface deferrableSurface = this.f3115m;
        if (deferrableSurface != null) {
            deferrableSurface.c();
            this.f3115m = null;
        }
        this.f3119q = null;
        this.f3116n = StreamInfo.f3065a;
    }

    private d0 d0() {
        if (this.f3121s == null && !f3113y && !f3114z) {
            return null;
        }
        v1.a("VideoCapture", "SurfaceEffect is enabled.");
        CameraInternal d10 = d();
        Objects.requireNonNull(d10);
        CameraInternal cameraInternal = d10;
        SurfaceOutput.GlTransformOptions glTransformOptions = SurfaceOutput.GlTransformOptions.APPLY_CROP_ROTATE_AND_MIRRORING;
        a0 a0Var = this.f3121s;
        if (a0Var == null) {
            a0Var = new k();
        }
        return new d0(cameraInternal, glTransformOptions, a0Var);
    }

    @NonNull
    private SessionConfig.b e0(@NonNull String str, @NonNull c0.a<T> aVar, @NonNull Size size) {
        Timebase timebase;
        Size size2;
        c0.a<T> aVar2 = aVar;
        Size size3 = size;
        androidx.camera.core.impl.utils.p.a();
        CameraInternal cameraInternal = (CameraInternal) h.g(d());
        Range<Integer> C = aVar2.C(e.f3137d);
        Objects.requireNonNull(C);
        Range range = C;
        if (this.f3122t != null) {
            n k02 = k0();
            Objects.requireNonNull(k02);
            Rect j02 = j0(size3);
            Objects.requireNonNull(j02);
            Rect rect = j02;
            timebase = cameraInternal.l().g();
            Rect W = W(j02, size3, new t(this, aVar, cameraInternal, timebase, k02, size, C));
            Matrix l10 = l();
            int k10 = k(cameraInternal);
            CameraInternal cameraInternal2 = cameraInternal;
            Matrix matrix = l10;
            size2 = size3;
            u uVar = new u(2, size, 34, matrix, true, W, k10, false);
            this.f3119q = this.f3122t.i(w.a(Collections.singletonList(uVar))).b().get(0).v(cameraInternal2, C);
            this.f3115m = uVar;
        } else {
            size2 = size3;
            SurfaceRequest surfaceRequest = new SurfaceRequest(size2, cameraInternal, false, C);
            this.f3119q = surfaceRequest;
            this.f3115m = surfaceRequest.k();
            timebase = Timebase.UPTIME;
        }
        aVar.L().b(this.f3119q, timebase);
        v0(size2);
        this.f3115m.o(MediaCodec.class);
        SessionConfig.b o10 = SessionConfig.b.o(aVar);
        o10.f(new b0.u(this, str, aVar2, size2));
        if (f3112x || f3113y || f3114z) {
            o10.t(1);
        }
        return o10;
    }

    private static <T> T f0(@NonNull l1<T> l1Var, T t10) {
        zf.a<T> b10 = l1Var.b();
        if (!b10.isDone()) {
            return t10;
        }
        try {
            return b10.get();
        } catch (InterruptedException | ExecutionException e10) {
            throw new IllegalStateException(e10);
        }
    }

    @NonNull
    static List<Size> g0(@NonNull List<Size> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int i10 = a.e.API_PRIORITY_OTHER;
        for (Size next : list) {
            int h02 = h0(next);
            if (h02 < i10) {
                arrayList.add(next);
                i10 = h02;
            }
        }
        return arrayList;
    }

    private static int h0(@NonNull Size size) {
        return size.getWidth() * size.getHeight();
    }

    private Rect j0(Size size) {
        if (p() != null) {
            return p();
        }
        if (size != null) {
            return new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        return null;
    }

    private n k0() {
        return (n) f0(l0().c(), (Object) null);
    }

    private i1 m0(@NonNull k.a<androidx.camera.video.internal.encoder.h1, i1> aVar, @NonNull f0 f0Var, @NonNull Timebase timebase, @NonNull n nVar, @NonNull Size size, @NonNull Range<Integer> range) {
        i1 i1Var = this.f3123u;
        if (i1Var != null) {
            return i1Var;
        }
        i1 u02 = u0(aVar, f0Var, timebase, nVar, size, range);
        if (u02 == null) {
            return null;
        }
        i1 g10 = i0.c.g(u02, size);
        this.f3123u = g10;
        return g10;
    }

    private static boolean n0(@NonNull Rect rect, @NonNull Size size) {
        if (size.getWidth() == rect.width() && size.getHeight() == rect.height()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int o0(Rect rect, Size size, Size size2) {
        return (Math.abs(size.getWidth() - rect.width()) + Math.abs(size.getHeight() - rect.height())) - (Math.abs(size2.getWidth() - rect.width()) + Math.abs(size2.getHeight() - rect.height()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ i1 p0(c0.a aVar, CameraInternal cameraInternal, Timebase timebase, n nVar, Size size, Range range) {
        return m0(aVar.K(), f0.d(cameraInternal.b()), timebase, nVar, size, range);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0(String str, c0.a aVar, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        t0(str, aVar, size);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void r0(AtomicBoolean atomicBoolean, SessionConfig.b bVar, n nVar) {
        h.j(androidx.camera.core.impl.utils.p.b(), "Surface update cancellation should only occur on main thread.");
        atomicBoolean.set(true);
        bVar.q(nVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object s0(SessionConfig.b bVar, CallbackToFutureAdapter.a aVar) throws Exception {
        bVar.l("androidx.camera.video.VideoCapture.streamUpdate", Integer.valueOf(aVar.hashCode()));
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        b bVar2 = new b(atomicBoolean, aVar, bVar);
        aVar.a(new b0.w(atomicBoolean, bVar, bVar2), androidx.camera.core.impl.utils.executor.a.a());
        bVar.i(bVar2);
        return String.format("%s[0x%x]", new Object[]{"androidx.camera.video.VideoCapture.streamUpdate", Integer.valueOf(aVar.hashCode())});
    }

    private static i1 u0(@NonNull k.a<androidx.camera.video.internal.encoder.h1, i1> aVar, @NonNull f0 f0Var, @NonNull Timebase timebase, @NonNull n nVar, @NonNull Size size, @NonNull Range<Integer> range) {
        return aVar.apply(g0.i.b(g0.i.c(nVar, f0Var.b(size)), timebase, nVar.d(), size, range));
    }

    private void v0(Size size) {
        CameraInternal d10 = d();
        SurfaceRequest surfaceRequest = this.f3119q;
        Rect j02 = j0(size);
        if (d10 != null && surfaceRequest != null && j02 != null) {
            int k10 = k(d10);
            int b10 = b();
            if (this.f3122t != null) {
                i0().K(k10);
            } else {
                surfaceRequest.y(SurfaceRequest.f.d(j02, k10, b10));
            }
        }
    }

    private void x0(@NonNull SessionConfig.b bVar, boolean z10) {
        zf.a<Void> aVar = this.f3118p;
        if (aVar != null && aVar.cancel(false)) {
            v1.a("VideoCapture", "A newer surface update is requested. Previous surface update cancelled.");
        }
        zf.a<Void> a10 = CallbackToFutureAdapter.a(new v(this, bVar));
        this.f3118p = a10;
        f.b(a10, new c(a10, z10), androidx.camera.core.impl.utils.executor.a.d());
    }

    private void y0(@NonNull androidx.camera.core.impl.x xVar, @NonNull f2.a<?, ?, ?> aVar) throws IllegalArgumentException {
        boolean z10;
        n k02 = k0();
        if (k02 != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.b(z10, "Unable to update target resolution by null MediaSpec.");
        if (r.i(xVar).isEmpty()) {
            v1.l("VideoCapture", "Can't find any supported quality on the device.");
            return;
        }
        r e10 = k02.d().e();
        List<q> g10 = e10.g(xVar);
        v1.a("VideoCapture", "Found selectedQualities " + g10 + " by " + e10);
        if (!g10.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (q h10 : g10) {
                arrayList.add(r.h(xVar, h10));
            }
            v1.a("VideoCapture", "Set supported resolutions = " + arrayList);
            List<Size> g02 = g0(arrayList);
            v1.a("VideoCapture", "supportedResolutions after filter out " + g02);
            h.j(g10.isEmpty() ^ true, "No supportedResolutions after filter out");
            aVar.a().p(v0.f2695m, Collections.singletonList(Pair.create(Integer.valueOf(i()), (Size[]) g02.toArray(new Size[0]))));
            return;
        }
        throw new IllegalArgumentException("Unable to find supported quality by QualitySelector");
    }

    @NonNull
    public static <T extends VideoOutput> g0<T> z0(@NonNull T t10) {
        return new d((VideoOutput) h.g(t10)).c();
    }

    public void B() {
        c0();
        d0 d0Var = this.f3122t;
        if (d0Var != null) {
            d0Var.f();
            this.f3122t = null;
        }
        this.f3123u = null;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [androidx.camera.core.impl.f2$a, androidx.camera.core.impl.f2$a<?, ?, ?>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.f2<?> C(@androidx.annotation.NonNull androidx.camera.core.impl.x r1, @androidx.annotation.NonNull androidx.camera.core.impl.f2.a<?, ?, ?> r2) {
        /*
            r0 = this;
            r0.y0(r1, r2)
            androidx.camera.core.impl.f2 r1 = r2.b()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.g0.C(androidx.camera.core.impl.x, androidx.camera.core.impl.f2$a):androidx.camera.core.impl.f2");
    }

    public void D() {
        super.D();
        l0().d().c(androidx.camera.core.impl.utils.executor.a.d(), this.f3124v);
        w0(VideoOutput.SourceState.ACTIVE_NON_STREAMING);
    }

    public void E() {
        h.j(androidx.camera.core.impl.utils.p.b(), "VideoCapture can only be detached on the main thread.");
        w0(VideoOutput.SourceState.INACTIVE);
        l0().d().d(this.f3124v);
        zf.a<Void> aVar = this.f3118p;
        if (aVar != null && aVar.cancel(false)) {
            v1.a("VideoCapture", "VideoCapture is detached from the camera. Surface update cancelled.");
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Size F(@NonNull Size size) {
        Object obj;
        v1.a("VideoCapture", "suggestedResolution = " + size);
        String f10 = f();
        c0.a aVar = (c0.a) g();
        Size[] sizeArr = null;
        List<Pair<Integer, Size[]>> k10 = aVar.k((List<Pair<Integer, Size[]>>) null);
        if (k10 != null) {
            Iterator<Pair<Integer, Size[]>> it = k10.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair next = it.next();
                if (((Integer) next.first).intValue() == i() && (obj = next.second) != null) {
                    sizeArr = (Size[]) obj;
                    break;
                }
            }
        }
        if (sizeArr != null) {
            int width = size.getWidth() * size.getHeight();
            int length = sizeArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                Size size2 = sizeArr[i10];
                if (Objects.equals(size2, size)) {
                    break;
                } else if (size2.getWidth() * size2.getHeight() < width) {
                    v1.a("VideoCapture", "Find a higher priority resolution: " + size2);
                    size = size2;
                    break;
                } else {
                    i10++;
                }
            }
        }
        this.f3116n = (StreamInfo) f0(l0().d(), StreamInfo.f3065a);
        this.f3122t = d0();
        SessionConfig.b e02 = e0(f10, aVar, size);
        this.f3117o = e02;
        b0(e02, this.f3116n);
        J(this.f3117o.m());
        s();
        return size;
    }

    public void I(@NonNull Rect rect) {
        super.I(rect);
        v0(c());
    }

    /* access modifiers changed from: package-private */
    public void b0(@NonNull SessionConfig.b bVar, @NonNull StreamInfo streamInfo) {
        boolean z10;
        boolean z11 = true;
        if (streamInfo.a() == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (streamInfo.b() != StreamInfo.StreamState.ACTIVE) {
            z11 = false;
        }
        if (!z10 || !z11) {
            bVar.n();
            if (!z10) {
                if (z11) {
                    bVar.k(this.f3115m);
                } else {
                    bVar.h(this.f3115m);
                }
            }
            x0(bVar, z11);
            return;
        }
        throw new IllegalStateException("Unexpected stream state, stream is error but active");
    }

    public f2<?> h(boolean z10, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config a10 = useCaseConfigFactory.a(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE, 1);
        if (z10) {
            a10 = Config.D(a10, f3111w.b());
        }
        if (a10 == null) {
            return null;
        }
        return o(a10).b();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public u i0() {
        h.g(this.f3122t);
        DeferrableSurface deferrableSurface = this.f3115m;
        Objects.requireNonNull(deferrableSurface);
        return (u) deferrableSurface;
    }

    @NonNull
    public T l0() {
        return ((c0.a) g()).L();
    }

    @NonNull
    public f2.a<?, ?, ?> o(@NonNull Config config) {
        return d.e(config);
    }

    /* access modifiers changed from: package-private */
    public void t0(@NonNull String str, @NonNull c0.a<T> aVar, @NonNull Size size) {
        c0();
        if (q(str)) {
            SessionConfig.b e02 = e0(str, aVar, size);
            this.f3117o = e02;
            b0(e02, this.f3116n);
            J(this.f3117o.m());
            u();
        }
    }

    @NonNull
    public String toString() {
        return "VideoCapture:" + j();
    }

    /* access modifiers changed from: package-private */
    public void w0(@NonNull VideoOutput.SourceState sourceState) {
        if (sourceState != this.f3120r) {
            this.f3120r = sourceState;
            l0().e(sourceState);
        }
    }
}
