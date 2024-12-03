package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageSaver;
import androidx.camera.core.h0;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.c0;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.e0;
import androidx.camera.core.impl.f0;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.s0;
import androidx.camera.core.impl.u0;
import androidx.camera.core.impl.u1;
import androidx.camera.core.impl.utils.q;
import androidx.camera.core.impl.v0;
import androidx.camera.core.impl.x0;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.cli.HelpFormatter;
import t.l0;
import t.p0;

public final class h1 extends UseCase {
    public static final i L = new i();
    static final y.a M = new y.a();
    SessionConfig.b A;
    s2 B;
    j2 C;
    private zf.a<Void> D = u.f.h(null);
    private androidx.camera.core.impl.n E;
    private DeferrableSurface F;
    private k G;
    final Executor H;
    private t.p I;
    private l0 J;
    private final t.o K = new g();

    /* renamed from: m  reason: collision with root package name */
    boolean f2272m = false;

    /* renamed from: n  reason: collision with root package name */
    private final x0.a f2273n = new t0();
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    final Executor f2274o;

    /* renamed from: p  reason: collision with root package name */
    private final int f2275p;

    /* renamed from: q  reason: collision with root package name */
    private final AtomicReference<Integer> f2276q = new AtomicReference<>((Object) null);

    /* renamed from: r  reason: collision with root package name */
    private final int f2277r;

    /* renamed from: s  reason: collision with root package name */
    private int f2278s = -1;

    /* renamed from: t  reason: collision with root package name */
    private Rational f2279t = null;

    /* renamed from: u  reason: collision with root package name */
    private ExecutorService f2280u;

    /* renamed from: v  reason: collision with root package name */
    private d0 f2281v;

    /* renamed from: w  reason: collision with root package name */
    private c0 f2282w;

    /* renamed from: x  reason: collision with root package name */
    private int f2283x;

    /* renamed from: y  reason: collision with root package name */
    private e0 f2284y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f2285z = false;

    class a extends androidx.camera.core.impl.n {
        a() {
        }
    }

    class b extends androidx.camera.core.impl.n {
        b() {
        }
    }

    class c implements ImageSaver.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f2288a;

        c(n nVar) {
            this.f2288a = nVar;
        }

        public void a(@NonNull p pVar) {
            this.f2288a.a(pVar);
        }

        public void b(@NonNull ImageSaver.SaveError saveError, @NonNull String str, Throwable th2) {
            int i10;
            if (saveError == ImageSaver.SaveError.FILE_IO_FAILED) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.f2288a.b(new ImageCaptureException(i10, str, th2));
        }
    }

    class d extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f2290a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2291b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Executor f2292c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ImageSaver.b f2293d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ n f2294e;

        d(o oVar, int i10, Executor executor, ImageSaver.b bVar, n nVar) {
            this.f2290a = oVar;
            this.f2291b = i10;
            this.f2292c = executor;
            this.f2293d = bVar;
            this.f2294e = nVar;
        }

        public void a(@NonNull o1 o1Var) {
            h1.this.f2274o.execute(new ImageSaver(o1Var, this.f2290a, o1Var.z1().a(), this.f2291b, this.f2292c, h1.this.H, this.f2293d));
        }

        public void b(@NonNull ImageCaptureException imageCaptureException) {
            this.f2294e.b(imageCaptureException);
        }
    }

    class e implements u.c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f2296a;

        e(CallbackToFutureAdapter.a aVar) {
            this.f2296a = aVar;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            h1.this.M0();
        }

        public void onFailure(@NonNull Throwable th2) {
            h1.this.M0();
            this.f2296a.f(th2);
        }
    }

    class f implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f2298a = new AtomicInteger(0);

        f() {
        }

        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "CameraX-image_capture_" + this.f2298a.getAndIncrement());
        }
    }

    class g implements t.o {
        g() {
        }

        @NonNull
        public zf.a<Void> a(@NonNull List<d0> list) {
            return h1.this.H0(list);
        }

        public void b() {
            h1.this.D0();
        }

        public void c() {
            h1.this.M0();
        }
    }

    public static final class h implements f2.a<h1, s0, h> {

        /* renamed from: a  reason: collision with root package name */
        private final i1 f2301a;

        public h() {
            this(i1.O());
        }

        @NonNull
        public static h d(@NonNull Config config) {
            return new h(i1.P(config));
        }

        @NonNull
        public androidx.camera.core.impl.h1 a() {
            return this.f2301a;
        }

        @NonNull
        public h1 c() {
            Integer num;
            boolean z10;
            if (a().g(v0.f2689g, null) == null || a().g(v0.f2692j, null) == null) {
                Integer num2 = (Integer) a().g(s0.F, null);
                boolean z11 = false;
                if (num2 != null) {
                    if (a().g(s0.E, null) == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    androidx.core.util.h.b(z10, "Cannot set buffer format with CaptureProcessor defined.");
                    a().p(u0.f2585f, num2);
                } else if (a().g(s0.E, null) != null) {
                    a().p(u0.f2585f, 35);
                } else {
                    a().p(u0.f2585f, 256);
                }
                h1 h1Var = new h1(b());
                Size size = (Size) a().g(v0.f2692j, null);
                if (size != null) {
                    h1Var.G0(new Rational(size.getWidth(), size.getHeight()));
                }
                Integer num3 = (Integer) a().g(s0.G, 2);
                androidx.core.util.h.h(num3, "Maximum outstanding image count must be at least 1");
                if (num3.intValue() >= 1) {
                    z11 = true;
                }
                androidx.core.util.h.b(z11, "Maximum outstanding image count must be at least 1");
                androidx.core.util.h.h((Executor) a().g(v.g.f18037v, androidx.camera.core.impl.utils.executor.a.c()), "The IO executor can't be null");
                androidx.camera.core.impl.h1 a10 = a();
                Config.a<Integer> aVar = s0.C;
                if (!a10.b(aVar) || ((num = (Integer) a().a(aVar)) != null && (num.intValue() == 0 || num.intValue() == 1 || num.intValue() == 2))) {
                    return h1Var;
                }
                throw new IllegalArgumentException("The flash mode is not allowed to set: " + num);
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        @NonNull
        /* renamed from: e */
        public s0 b() {
            return new s0(n1.M(this.f2301a));
        }

        @NonNull
        public h f(int i10) {
            a().p(s0.B, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public h g(int i10) {
            a().p(f2.f2528r, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public h h(int i10) {
            a().p(v0.f2689g, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public h i(@NonNull Class<h1> cls) {
            a().p(v.h.f18039x, cls);
            if (a().g(v.h.f18038w, null) == null) {
                j(cls.getCanonicalName() + HelpFormatter.DEFAULT_OPT_PREFIX + UUID.randomUUID());
            }
            return this;
        }

        @NonNull
        public h j(@NonNull String str) {
            a().p(v.h.f18038w, str);
            return this;
        }

        @NonNull
        public h k(int i10) {
            a().p(v0.f2690h, Integer.valueOf(i10));
            return this;
        }

        private h(i1 i1Var) {
            Class<h1> cls = h1.class;
            this.f2301a = i1Var;
            Class cls2 = (Class) i1Var.g(v.h.f18039x, null);
            if (cls2 == null || cls2.equals(cls)) {
                i(cls);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls2);
        }
    }

    public static final class i {

        /* renamed from: a  reason: collision with root package name */
        private static final s0 f2302a = new h().g(4).h(0).b();

        @NonNull
        public s0 a() {
            return f2302a;
        }
    }

    static class j {

        /* renamed from: a  reason: collision with root package name */
        final int f2303a;

        /* renamed from: b  reason: collision with root package name */
        final int f2304b;

        /* renamed from: c  reason: collision with root package name */
        private final Rational f2305c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final Executor f2306d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private final m f2307e;

        /* renamed from: f  reason: collision with root package name */
        AtomicBoolean f2308f = new AtomicBoolean(false);

        /* renamed from: g  reason: collision with root package name */
        private final Rect f2309g;
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        private final Matrix f2310h;

        j(int i10, int i11, Rational rational, Rect rect, @NonNull Matrix matrix, @NonNull Executor executor, @NonNull m mVar) {
            boolean z10 = false;
            this.f2303a = i10;
            this.f2304b = i11;
            if (rational != null) {
                androidx.core.util.h.b(!rational.isZero(), "Target ratio cannot be zero");
                androidx.core.util.h.b(rational.floatValue() > 0.0f ? true : z10, "Target ratio must be positive");
            }
            this.f2305c = rational;
            this.f2309g = rect;
            this.f2310h = matrix;
            this.f2306d = executor;
            this.f2307e = mVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(o1 o1Var) {
            this.f2307e.a(o1Var);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(int i10, String str, Throwable th2) {
            this.f2307e.b(new ImageCaptureException(i10, str, th2));
        }

        /* access modifiers changed from: package-private */
        public void c(o1 o1Var) {
            int i10;
            Size size;
            if (!this.f2308f.compareAndSet(false, true)) {
                o1Var.close();
                return;
            }
            if (h1.M.b(o1Var)) {
                try {
                    ByteBuffer d10 = o1Var.M0()[0].d();
                    d10.rewind();
                    byte[] bArr = new byte[d10.capacity()];
                    d10.get(bArr);
                    androidx.camera.core.impl.utils.i k10 = androidx.camera.core.impl.utils.i.k(new ByteArrayInputStream(bArr));
                    d10.rewind();
                    size = new Size(k10.u(), k10.p());
                    i10 = k10.s();
                } catch (IOException e10) {
                    f(1, "Unable to parse JPEG exif", e10);
                    o1Var.close();
                    return;
                }
            } else {
                size = new Size(o1Var.getWidth(), o1Var.getHeight());
                i10 = this.f2303a;
            }
            t2 t2Var = new t2(o1Var, size, u1.e(o1Var.z1().c(), o1Var.z1().getTimestamp(), i10, this.f2310h));
            t2Var.p0(h1.b0(this.f2309g, this.f2305c, this.f2303a, size, i10));
            try {
                this.f2306d.execute(new j1(this, t2Var));
            } catch (RejectedExecutionException unused) {
                v1.c("ImageCapture", "Unable to post to the supplied executor.");
                o1Var.close();
            }
        }

        /* access modifiers changed from: package-private */
        public void f(int i10, String str, Throwable th2) {
            if (this.f2308f.compareAndSet(false, true)) {
                try {
                    this.f2306d.execute(new i1(this, i10, str, th2));
                } catch (RejectedExecutionException unused) {
                    v1.c("ImageCapture", "Unable to post to the supplied executor.");
                }
            }
        }
    }

    static class k implements h0.a {

        /* renamed from: a  reason: collision with root package name */
        private final Deque<j> f2311a = new ArrayDeque();

        /* renamed from: b  reason: collision with root package name */
        j f2312b = null;

        /* renamed from: c  reason: collision with root package name */
        zf.a<o1> f2313c = null;

        /* renamed from: d  reason: collision with root package name */
        int f2314d = 0;

        /* renamed from: e  reason: collision with root package name */
        private final b f2315e;

        /* renamed from: f  reason: collision with root package name */
        private final int f2316f;

        /* renamed from: g  reason: collision with root package name */
        private final c f2317g;

        /* renamed from: h  reason: collision with root package name */
        final Object f2318h = new Object();

        class a implements u.c<o1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ j f2319a;

            a(j jVar) {
                this.f2319a = jVar;
            }

            /* renamed from: a */
            public void onSuccess(o1 o1Var) {
                synchronized (k.this.f2318h) {
                    androidx.core.util.h.g(o1Var);
                    v2 v2Var = new v2(o1Var);
                    v2Var.a(k.this);
                    k.this.f2314d++;
                    this.f2319a.c(v2Var);
                    k kVar = k.this;
                    kVar.f2312b = null;
                    kVar.f2313c = null;
                    kVar.c();
                }
            }

            public void onFailure(@NonNull Throwable th2) {
                String str;
                synchronized (k.this.f2318h) {
                    if (!(th2 instanceof CancellationException)) {
                        j jVar = this.f2319a;
                        int i02 = h1.i0(th2);
                        if (th2 != null) {
                            str = th2.getMessage();
                        } else {
                            str = "Unknown error";
                        }
                        jVar.f(i02, str, th2);
                    }
                    k kVar = k.this;
                    kVar.f2312b = null;
                    kVar.f2313c = null;
                    kVar.c();
                }
            }
        }

        interface b {
            @NonNull
            zf.a<o1> a(@NonNull j jVar);
        }

        interface c {
            void a(@NonNull j jVar);
        }

        k(int i10, @NonNull b bVar, c cVar) {
            this.f2316f = i10;
            this.f2315e = bVar;
            this.f2317g = cVar;
        }

        public void a(@NonNull o1 o1Var) {
            synchronized (this.f2318h) {
                this.f2314d--;
                androidx.camera.core.impl.utils.executor.a.d().execute(new k1(this));
            }
        }

        public void b(@NonNull Throwable th2) {
            j jVar;
            zf.a<o1> aVar;
            ArrayList<j> arrayList;
            synchronized (this.f2318h) {
                jVar = this.f2312b;
                this.f2312b = null;
                aVar = this.f2313c;
                this.f2313c = null;
                arrayList = new ArrayList<>(this.f2311a);
                this.f2311a.clear();
            }
            if (!(jVar == null || aVar == null)) {
                jVar.f(h1.i0(th2), th2.getMessage(), th2);
                aVar.cancel(true);
            }
            for (j f10 : arrayList) {
                f10.f(h1.i0(th2), th2.getMessage(), th2);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            synchronized (this.f2318h) {
                if (this.f2312b == null) {
                    if (this.f2314d >= this.f2316f) {
                        v1.l("ImageCapture", "Too many acquire images. Close image to be able to process next.");
                        return;
                    }
                    j poll = this.f2311a.poll();
                    if (poll != null) {
                        this.f2312b = poll;
                        c cVar = this.f2317g;
                        if (cVar != null) {
                            cVar.a(poll);
                        }
                        zf.a<o1> a10 = this.f2315e.a(poll);
                        this.f2313c = a10;
                        u.f.b(a10, new a(poll), androidx.camera.core.impl.utils.executor.a.d());
                    }
                }
            }
        }

        @NonNull
        public List<j> d() {
            ArrayList arrayList;
            zf.a<o1> aVar;
            synchronized (this.f2318h) {
                arrayList = new ArrayList(this.f2311a);
                this.f2311a.clear();
                j jVar = this.f2312b;
                this.f2312b = null;
                if (!(jVar == null || (aVar = this.f2313c) == null || !aVar.cancel(true))) {
                    arrayList.add(0, jVar);
                }
            }
            return arrayList;
        }

        public void e(@NonNull j jVar) {
            int i10;
            synchronized (this.f2318h) {
                this.f2311a.offer(jVar);
                Locale locale = Locale.US;
                Object[] objArr = new Object[2];
                if (this.f2312b != null) {
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                objArr[0] = Integer.valueOf(i10);
                objArr[1] = Integer.valueOf(this.f2311a.size());
                v1.a("ImageCapture", String.format(locale, "Send image capture request [current, pending] = [%d, %d]", objArr));
                c();
            }
        }
    }

    public static final class l {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2321a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2322b = false;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2323c;

        /* renamed from: d  reason: collision with root package name */
        private Location f2324d;

        public Location a() {
            return this.f2324d;
        }

        public boolean b() {
            return this.f2321a;
        }

        public boolean c() {
            return this.f2323c;
        }
    }

    public static abstract class m {
        public abstract void a(@NonNull o1 o1Var);

        public abstract void b(@NonNull ImageCaptureException imageCaptureException);
    }

    public interface n {
        void a(@NonNull p pVar);

        void b(@NonNull ImageCaptureException imageCaptureException);
    }

    public static final class o {

        /* renamed from: a  reason: collision with root package name */
        private final File f2325a;

        /* renamed from: b  reason: collision with root package name */
        private final ContentResolver f2326b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f2327c;

        /* renamed from: d  reason: collision with root package name */
        private final ContentValues f2328d;

        /* renamed from: e  reason: collision with root package name */
        private final OutputStream f2329e;
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private final l f2330f;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private File f2331a;

            /* renamed from: b  reason: collision with root package name */
            private ContentResolver f2332b;

            /* renamed from: c  reason: collision with root package name */
            private Uri f2333c;

            /* renamed from: d  reason: collision with root package name */
            private ContentValues f2334d;

            /* renamed from: e  reason: collision with root package name */
            private OutputStream f2335e;

            /* renamed from: f  reason: collision with root package name */
            private l f2336f;

            public a(@NonNull File file) {
                this.f2331a = file;
            }

            @NonNull
            public o a() {
                return new o(this.f2331a, this.f2332b, this.f2333c, this.f2334d, this.f2335e, this.f2336f);
            }
        }

        o(File file, ContentResolver contentResolver, Uri uri, ContentValues contentValues, OutputStream outputStream, l lVar) {
            this.f2325a = file;
            this.f2326b = contentResolver;
            this.f2327c = uri;
            this.f2328d = contentValues;
            this.f2329e = outputStream;
            this.f2330f = lVar == null ? new l() : lVar;
        }

        public ContentResolver a() {
            return this.f2326b;
        }

        public ContentValues b() {
            return this.f2328d;
        }

        public File c() {
            return this.f2325a;
        }

        @NonNull
        public l d() {
            return this.f2330f;
        }

        public OutputStream e() {
            return this.f2329e;
        }

        public Uri f() {
            return this.f2327c;
        }
    }

    public static class p {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f2337a;

        public p(Uri uri) {
            this.f2337a = uri;
        }
    }

    h1(@NonNull s0 s0Var) {
        super(s0Var);
        s0 s0Var2 = (s0) g();
        if (s0Var2.b(s0.B)) {
            this.f2275p = s0Var2.L();
        } else {
            this.f2275p = 1;
        }
        this.f2277r = s0Var2.O(0);
        Executor executor = (Executor) androidx.core.util.h.g(s0Var2.Q(androidx.camera.core.impl.utils.executor.a.c()));
        this.f2274o = executor;
        this.H = androidx.camera.core.impl.utils.executor.a.f(executor);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void A0(CallbackToFutureAdapter.a aVar, x0 x0Var) {
        try {
            o1 b10 = x0Var.b();
            if (b10 == null) {
                aVar.f(new IllegalStateException("Unable to acquire image"));
            } else if (!aVar.c(b10)) {
                b10.close();
            }
        } catch (IllegalStateException e10) {
            aVar.f(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object C0(j jVar, CallbackToFutureAdapter.a aVar) throws Exception {
        this.B.f(new v0(aVar), androidx.camera.core.impl.utils.executor.a.d());
        D0();
        zf.a<Void> q02 = q0(jVar);
        u.f.b(q02, new e(aVar), this.f2280u);
        aVar.a(new w0(q02), androidx.camera.core.impl.utils.executor.a.a());
        return "takePictureInternal";
    }

    private void E0(@NonNull Executor executor, @NonNull m mVar, boolean z10) {
        CameraInternal d10 = d();
        if (d10 == null) {
            executor.execute(new e1(this, mVar));
            return;
        }
        k kVar = this.G;
        if (kVar == null) {
            executor.execute(new f1(mVar));
        } else {
            kVar.e(new j(k(d10), k0(d10, z10), this.f2279t, p(), l(), executor, mVar));
        }
    }

    private void F0(@NonNull Executor executor, m mVar, n nVar) {
        ImageCaptureException imageCaptureException = new ImageCaptureException(4, "Not bound to a valid Camera [" + this + "]", (Throwable) null);
        if (mVar != null) {
            mVar.b(imageCaptureException);
        } else if (nVar != null) {
            nVar.b(imageCaptureException);
        } else {
            throw new IllegalArgumentException("Must have either in-memory or on-disk callback.");
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public zf.a<o1> J0(@NonNull j jVar) {
        return CallbackToFutureAdapter.a(new g1(this, jVar));
    }

    private void K0(@NonNull Executor executor, m mVar, n nVar, o oVar) {
        androidx.camera.core.impl.utils.p.a();
        CameraInternal d10 = d();
        if (d10 == null) {
            F0(executor, mVar, nVar);
            return;
        }
        this.J.i(p0.q(executor, mVar, nVar, oVar, m0(), l(), k(d10), l0(), g0(), this.A.p()));
    }

    private void L0() {
        synchronized (this.f2276q) {
            if (this.f2276q.get() == null) {
                e().e(j0());
            }
        }
    }

    private void Y() {
        if (this.G != null) {
            this.G.b(new CameraClosedException("Camera is closed."));
        }
    }

    private void a0() {
        androidx.camera.core.impl.utils.p.a();
        this.I.a();
        this.I = null;
        this.J.d();
        this.J = null;
    }

    @NonNull
    static Rect b0(Rect rect, Rational rational, int i10, @NonNull Size size, int i11) {
        if (rect != null) {
            return ImageUtil.b(rect, i10, size, i11);
        }
        if (rational != null) {
            if (i11 % Opcodes.GETFIELD != 0) {
                rational = new Rational(rational.getDenominator(), rational.getNumerator());
            }
            if (ImageUtil.g(size, rational)) {
                Rect a10 = ImageUtil.a(size, rational);
                Objects.requireNonNull(a10);
                Rect rect2 = a10;
                return a10;
            }
        }
        return new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    private SessionConfig.b d0(@NonNull String str, @NonNull s0 s0Var, @NonNull Size size) {
        boolean z10;
        androidx.camera.core.impl.utils.p.a();
        boolean z11 = false;
        String.format("createPipelineWithNode(cameraId: %s, resolution: %s)", new Object[]{str, size});
        if (this.I == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        androidx.core.util.h.i(z10);
        this.I = new t.p(s0Var, size);
        if (this.J == null) {
            z11 = true;
        }
        androidx.core.util.h.i(z11);
        this.J = new l0(this.K, this.I);
        SessionConfig.b f10 = this.I.f();
        if (g0() == 2) {
            e().b(f10);
        }
        f10.f(new d1(this, str));
        return f10;
    }

    static boolean e0(@NonNull androidx.camera.core.impl.h1 h1Var) {
        Boolean bool = Boolean.TRUE;
        Config.a<Boolean> aVar = s0.I;
        Boolean bool2 = Boolean.FALSE;
        boolean z10 = false;
        if (bool.equals(h1Var.g(aVar, bool2))) {
            boolean z11 = true;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 26) {
                v1.l("ImageCapture", "Software JPEG only supported on API 26+, but current API level is " + i10);
                z11 = false;
            }
            Integer num = (Integer) h1Var.g(s0.F, null);
            if (num == null || num.intValue() == 256) {
                z10 = z11;
            } else {
                v1.l("ImageCapture", "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z10) {
                v1.l("ImageCapture", "Unable to support software JPEG. Disabling.");
                h1Var.p(aVar, bool2);
            }
        }
        return z10;
    }

    private c0 f0(c0 c0Var) {
        List<f0> a10 = this.f2282w.a();
        if (a10 == null || a10.isEmpty()) {
            return c0Var;
        }
        return w.a(a10);
    }

    private int h0(@NonNull s0 s0Var) {
        List<f0> a10;
        c0 K2 = s0Var.K((c0) null);
        if (K2 == null || (a10 = K2.a()) == null) {
            return 1;
        }
        return a10.size();
    }

    static int i0(Throwable th2) {
        if (th2 instanceof CameraClosedException) {
            return 3;
        }
        if (th2 instanceof ImageCaptureException) {
            return ((ImageCaptureException) th2).a();
        }
        return 0;
    }

    private int k0(@NonNull CameraInternal cameraInternal, boolean z10) {
        if (!z10) {
            return l0();
        }
        int k10 = k(cameraInternal);
        Size c10 = c();
        Objects.requireNonNull(c10);
        Size size = c10;
        Rect b02 = b0(p(), this.f2279t, k10, c10, k10);
        if (!ImageUtil.m(c10.getWidth(), c10.getHeight(), b02.width(), b02.height())) {
            return l0();
        }
        if (this.f2275p == 0) {
            return 100;
        }
        return 95;
    }

    private int l0() {
        s0 s0Var = (s0) g();
        if (s0Var.b(s0.K)) {
            return s0Var.R();
        }
        int i10 = this.f2275p;
        if (i10 == 0) {
            return 100;
        }
        if (i10 == 1 || i10 == 2) {
            return 95;
        }
        throw new IllegalStateException("CaptureMode " + this.f2275p + " is invalid");
    }

    @NonNull
    private Rect m0() {
        Rect p10 = p();
        Size c10 = c();
        Objects.requireNonNull(c10);
        Size size = c10;
        if (p10 != null) {
            return p10;
        }
        if (!ImageUtil.f(this.f2279t)) {
            return new Rect(0, 0, c10.getWidth(), c10.getHeight());
        }
        CameraInternal d10 = d();
        Objects.requireNonNull(d10);
        int k10 = k(d10);
        Rational rational = new Rational(this.f2279t.getDenominator(), this.f2279t.getNumerator());
        if (!q.f(k10)) {
            rational = this.f2279t;
        }
        Rect a10 = ImageUtil.a(c10, rational);
        Objects.requireNonNull(a10);
        Rect rect = a10;
        return a10;
    }

    private static boolean n0(List<Pair<Integer, Size[]>> list, int i10) {
        if (list == null) {
            return false;
        }
        for (Pair<Integer, Size[]> pair : list) {
            if (((Integer) pair.first).equals(Integer.valueOf(i10))) {
                return true;
            }
        }
        return false;
    }

    private boolean o0() {
        androidx.camera.core.impl.utils.p.a();
        s0 s0Var = (s0) g();
        if (s0Var.P() != null || p0() || this.f2284y != null || h0(s0Var) > 1) {
            return false;
        }
        Integer num = (Integer) s0Var.g(u0.f2585f, 256);
        Objects.requireNonNull(num);
        if (num.intValue() != 256) {
            return false;
        }
        return this.f2272m;
    }

    private boolean p0() {
        if (d() == null || d().g().J((u1) null) == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void r0(v.m mVar, j jVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            mVar.g(jVar.f2304b);
            mVar.h(jVar.f2303a);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s0(String str, s0 s0Var, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        List<j> list;
        k kVar = this.G;
        if (kVar != null) {
            list = kVar.d();
        } else {
            list = Collections.emptyList();
        }
        Z();
        if (q(str)) {
            this.A = c0(str, s0Var, size);
            if (this.G != null) {
                for (j e10 : list) {
                    this.G.e(e10);
                }
            }
            J(this.A.m());
            u();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(String str, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (q(str)) {
            this.J.j();
            J(this.A.m());
            u();
            this.J.k();
            return;
        }
        a0();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void u0(j jVar, String str, Throwable th2) {
        v1.c("ImageCapture", "Processing image failed! " + str);
        jVar.f(2, str, th2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void v0(x0 x0Var) {
        o1 b10;
        try {
            b10 = x0Var.b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Discarding ImageProxy which was inadvertently acquired: ");
            sb2.append(b10);
            if (b10 != null) {
                b10.close();
                return;
            }
            return;
        } catch (IllegalStateException unused) {
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0(m mVar) {
        mVar.b(new ImageCaptureException(4, "Not bound to a valid Camera [" + this + "]", (Throwable) null));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void y0(List list) {
        return null;
    }

    public void B() {
        zf.a<Void> aVar = this.D;
        Y();
        Z();
        this.f2285z = false;
        ExecutorService executorService = this.f2280u;
        Objects.requireNonNull(executorService);
        aVar.addListener(new c1(executorService), androidx.camera.core.impl.utils.executor.a.a());
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [androidx.camera.core.impl.f2$a, androidx.camera.core.impl.f2$a<?, ?, ?>, androidx.camera.core.e0] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.f2<?> C(@androidx.annotation.NonNull androidx.camera.core.impl.x r8, @androidx.annotation.NonNull androidx.camera.core.impl.f2.a<?, ?, ?> r9) {
        /*
            r7 = this;
            androidx.camera.core.impl.f2 r0 = r9.b()
            androidx.camera.core.impl.Config$a<androidx.camera.core.impl.e0> r1 = androidx.camera.core.impl.s0.E
            r2 = 0
            java.lang.Object r0 = r0.g(r1, r2)
            java.lang.String r3 = "ImageCapture"
            if (r0 == 0) goto L_0x0026
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r0 < r4) goto L_0x0026
            java.lang.String r8 = "Requesting software JPEG due to a CaptureProcessor is set."
            androidx.camera.core.v1.e(r3, r8)
            androidx.camera.core.impl.h1 r8 = r9.a()
            androidx.camera.core.impl.Config$a<java.lang.Boolean> r0 = androidx.camera.core.impl.s0.I
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r8.p(r0, r3)
            goto L_0x0058
        L_0x0026:
            androidx.camera.core.impl.r1 r8 = r8.e()
            java.lang.Class<x.e> r0 = x.e.class
            boolean r8 = r8.a(r0)
            if (r8 == 0) goto L_0x0058
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            androidx.camera.core.impl.h1 r0 = r9.a()
            androidx.camera.core.impl.Config$a<java.lang.Boolean> r4 = androidx.camera.core.impl.s0.I
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            java.lang.Object r0 = r0.g(r4, r5)
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004c
            java.lang.String r8 = "Device quirk suggests software JPEG encoder, but it has been explicitly disabled."
            androidx.camera.core.v1.l(r3, r8)
            goto L_0x0058
        L_0x004c:
            java.lang.String r8 = "Requesting software JPEG due to device quirk."
            androidx.camera.core.v1.e(r3, r8)
            androidx.camera.core.impl.h1 r8 = r9.a()
            r8.p(r4, r5)
        L_0x0058:
            androidx.camera.core.impl.h1 r8 = r9.a()
            boolean r8 = e0(r8)
            androidx.camera.core.impl.h1 r0 = r9.a()
            androidx.camera.core.impl.Config$a<java.lang.Integer> r3 = androidx.camera.core.impl.s0.F
            java.lang.Object r0 = r0.g(r3, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r3 = 0
            r4 = 1
            r5 = 35
            if (r0 == 0) goto L_0x0099
            androidx.camera.core.impl.h1 r6 = r9.a()
            java.lang.Object r1 = r6.g(r1, r2)
            if (r1 != 0) goto L_0x007e
            r1 = r4
            goto L_0x007f
        L_0x007e:
            r1 = r3
        L_0x007f:
            java.lang.String r2 = "Cannot set buffer format with CaptureProcessor defined."
            androidx.core.util.h.b(r1, r2)
            androidx.camera.core.impl.h1 r1 = r9.a()
            androidx.camera.core.impl.Config$a<java.lang.Integer> r2 = androidx.camera.core.impl.u0.f2585f
            if (r8 == 0) goto L_0x008d
            goto L_0x0091
        L_0x008d:
            int r5 = r0.intValue()
        L_0x0091:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r1.p(r2, r8)
            goto L_0x00f9
        L_0x0099:
            androidx.camera.core.impl.h1 r0 = r9.a()
            java.lang.Object r0 = r0.g(r1, r2)
            if (r0 != 0) goto L_0x00ec
            if (r8 == 0) goto L_0x00a6
            goto L_0x00ec
        L_0x00a6:
            androidx.camera.core.impl.h1 r8 = r9.a()
            androidx.camera.core.impl.Config$a<java.util.List<android.util.Pair<java.lang.Integer, android.util.Size[]>>> r0 = androidx.camera.core.impl.v0.f2695m
            java.lang.Object r8 = r8.g(r0, r2)
            java.util.List r8 = (java.util.List) r8
            r0 = 256(0x100, float:3.59E-43)
            if (r8 != 0) goto L_0x00c4
            androidx.camera.core.impl.h1 r8 = r9.a()
            androidx.camera.core.impl.Config$a<java.lang.Integer> r1 = androidx.camera.core.impl.u0.f2585f
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r8.p(r1, r0)
            goto L_0x00f9
        L_0x00c4:
            boolean r1 = n0(r8, r0)
            if (r1 == 0) goto L_0x00d8
            androidx.camera.core.impl.h1 r8 = r9.a()
            androidx.camera.core.impl.Config$a<java.lang.Integer> r1 = androidx.camera.core.impl.u0.f2585f
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r8.p(r1, r0)
            goto L_0x00f9
        L_0x00d8:
            boolean r8 = n0(r8, r5)
            if (r8 == 0) goto L_0x00f9
            androidx.camera.core.impl.h1 r8 = r9.a()
            androidx.camera.core.impl.Config$a<java.lang.Integer> r0 = androidx.camera.core.impl.u0.f2585f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r8.p(r0, r1)
            goto L_0x00f9
        L_0x00ec:
            androidx.camera.core.impl.h1 r8 = r9.a()
            androidx.camera.core.impl.Config$a<java.lang.Integer> r0 = androidx.camera.core.impl.u0.f2585f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r8.p(r0, r1)
        L_0x00f9:
            androidx.camera.core.impl.h1 r8 = r9.a()
            androidx.camera.core.impl.Config$a<java.lang.Integer> r0 = androidx.camera.core.impl.s0.G
            r1 = 2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r8 = r8.g(r0, r1)
            java.lang.Integer r8 = (java.lang.Integer) r8
            java.lang.String r0 = "Maximum outstanding image count must be at least 1"
            androidx.core.util.h.h(r8, r0)
            int r8 = r8.intValue()
            if (r8 < r4) goto L_0x0116
            r3 = r4
        L_0x0116:
            androidx.core.util.h.b(r3, r0)
            androidx.camera.core.impl.f2 r8 = r9.b()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.h1.C(androidx.camera.core.impl.x, androidx.camera.core.impl.f2$a):androidx.camera.core.impl.f2");
    }

    /* access modifiers changed from: package-private */
    public void D0() {
        synchronized (this.f2276q) {
            if (this.f2276q.get() == null) {
                this.f2276q.set(Integer.valueOf(j0()));
            }
        }
    }

    public void E() {
        Y();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Size F(@NonNull Size size) {
        SessionConfig.b c02 = c0(f(), (s0) g(), size);
        this.A = c02;
        J(c02.m());
        s();
        return size;
    }

    public void G0(@NonNull Rational rational) {
        this.f2279t = rational;
    }

    /* access modifiers changed from: package-private */
    public zf.a<Void> H0(@NonNull List<d0> list) {
        androidx.camera.core.impl.utils.p.a();
        return u.f.o(e().c(list, this.f2275p, this.f2277r), new u0(), androidx.camera.core.impl.utils.executor.a.a());
    }

    /* renamed from: I0 */
    public void z0(@NonNull o oVar, @NonNull Executor executor, @NonNull n nVar) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            androidx.camera.core.impl.utils.executor.a.d().execute(new y0(this, oVar, executor, nVar));
        } else if (o0()) {
            K0(executor, (m) null, nVar, oVar);
        } else {
            o oVar2 = oVar;
            E0(androidx.camera.core.impl.utils.executor.a.d(), new d(oVar2, l0(), executor, new c(nVar), nVar), true);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void M0() {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference<java.lang.Integer> r0 = r3.f2276q
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Integer> r1 = r3.f2276q     // Catch:{ all -> 0x001f }
            r2 = 0
            java.lang.Object r1 = r1.getAndSet(r2)     // Catch:{ all -> 0x001f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x0010:
            int r1 = r1.intValue()     // Catch:{ all -> 0x001f }
            int r2 = r3.j0()     // Catch:{ all -> 0x001f }
            if (r1 == r2) goto L_0x001d
            r3.L0()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.h1.M0():void");
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        androidx.camera.core.impl.utils.p.a();
        if (o0()) {
            a0();
            return;
        }
        k kVar = this.G;
        if (kVar != null) {
            kVar.b(new CancellationException("Request is canceled."));
            this.G = null;
        }
        DeferrableSurface deferrableSurface = this.F;
        this.F = null;
        this.B = null;
        this.C = null;
        this.D = u.f.h(null);
        if (deferrableSurface != null) {
            deferrableSurface.c();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x021b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.SessionConfig.b c0(@androidx.annotation.NonNull java.lang.String r15, @androidx.annotation.NonNull androidx.camera.core.impl.s0 r16, @androidx.annotation.NonNull android.util.Size r17) {
        /*
            r14 = this;
            r0 = r14
            androidx.camera.core.impl.utils.p.a()
            boolean r1 = r14.o0()
            if (r1 == 0) goto L_0x000f
            androidx.camera.core.impl.SessionConfig$b r1 = r14.d0(r15, r16, r17)
            return r1
        L_0x000f:
            androidx.camera.core.impl.SessionConfig$b r1 = androidx.camera.core.impl.SessionConfig.b.o(r16)
            int r2 = android.os.Build.VERSION.SDK_INT
            int r3 = r14.g0()
            r4 = 2
            if (r3 != r4) goto L_0x0023
            androidx.camera.core.impl.CameraControlInternal r3 = r14.e()
            r3.b(r1)
        L_0x0023:
            androidx.camera.core.p1 r3 = r16.P()
            r5 = 0
            if (r3 == 0) goto L_0x0051
            androidx.camera.core.s2 r2 = new androidx.camera.core.s2
            androidx.camera.core.p1 r6 = r16.P()
            int r7 = r17.getWidth()
            int r8 = r17.getHeight()
            int r9 = r14.i()
            r10 = 2
            r11 = 0
            androidx.camera.core.impl.x0 r3 = r6.a(r7, r8, r9, r10, r11)
            r2.<init>(r3)
            r0.B = r2
            androidx.camera.core.h1$a r2 = new androidx.camera.core.h1$a
            r2.<init>()
            r0.E = r2
            goto L_0x0130
        L_0x0051:
            boolean r3 = r14.p0()
            r6 = 26
            r7 = 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0109
            int r3 = r14.i()
            if (r3 != r7) goto L_0x0078
            androidx.camera.core.d r2 = new androidx.camera.core.d
            int r3 = r17.getWidth()
            int r6 = r17.getHeight()
            int r7 = r14.i()
            android.media.ImageReader r3 = android.media.ImageReader.newInstance(r3, r6, r7, r4)
            r2.<init>(r3)
            r3 = r5
            goto L_0x00d6
        L_0x0078:
            int r3 = r14.i()
            r8 = 35
            if (r3 != r8) goto L_0x00ee
            if (r2 < r6) goto L_0x00e6
            v.m r2 = new v.m
            int r3 = r14.l0()
            r2.<init>(r3, r4)
            androidx.camera.core.b2 r3 = new androidx.camera.core.b2
            int r6 = r17.getWidth()
            int r9 = r17.getHeight()
            android.media.ImageReader r6 = android.media.ImageReader.newInstance(r6, r9, r8, r4)
            r3.<init>(r6)
            androidx.camera.core.impl.c0 r6 = androidx.camera.core.w.c()
            androidx.camera.core.j2$e r8 = new androidx.camera.core.j2$e
            r8.<init>(r3, r6, r2)
            java.util.concurrent.ExecutorService r9 = r0.f2280u
            androidx.camera.core.j2$e r8 = r8.c(r9)
            androidx.camera.core.j2$e r7 = r8.b(r7)
            androidx.camera.core.j2 r7 = r7.a()
            androidx.camera.core.impl.k1 r8 = androidx.camera.core.impl.k1.f()
            java.lang.String r9 = r7.n()
            java.util.List r6 = r6.a()
            r10 = 0
            java.lang.Object r6 = r6.get(r10)
            androidx.camera.core.impl.f0 r6 = (androidx.camera.core.impl.f0) r6
            int r6 = r6.getId()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r8.h(r9, r6)
            r3.m(r8)
            r3 = r2
            r2 = r7
        L_0x00d6:
            androidx.camera.core.h1$b r6 = new androidx.camera.core.h1$b
            r6.<init>()
            r0.E = r6
            androidx.camera.core.s2 r6 = new androidx.camera.core.s2
            r6.<init>(r2)
            r0.B = r6
            goto L_0x01b5
        L_0x00e6:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Does not support API level < 26"
            r1.<init>(r2)
            throw r1
        L_0x00ee:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unsupported image format:"
            r2.append(r3)
            int r3 = r14.i()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0109:
            androidx.camera.core.impl.e0 r3 = r0.f2284y
            if (r3 != 0) goto L_0x0133
            boolean r8 = r0.f2285z
            if (r8 == 0) goto L_0x0112
            goto L_0x0133
        L_0x0112:
            androidx.camera.core.y1 r2 = new androidx.camera.core.y1
            int r3 = r17.getWidth()
            int r6 = r17.getHeight()
            int r7 = r14.i()
            r2.<init>(r3, r6, r7, r4)
            androidx.camera.core.impl.n r3 = r2.m()
            r0.E = r3
            androidx.camera.core.s2 r3 = new androidx.camera.core.s2
            r3.<init>(r2)
            r0.B = r3
        L_0x0130:
            r3 = r5
            goto L_0x01b5
        L_0x0133:
            int r9 = r14.i()
            int r8 = r14.i()
            boolean r10 = r0.f2285z
            if (r10 == 0) goto L_0x017b
            if (r2 < r6) goto L_0x0173
            java.lang.String r2 = "ImageCapture"
            java.lang.String r3 = "Using software JPEG encoder."
            androidx.camera.core.v1.e(r2, r3)
            androidx.camera.core.impl.e0 r2 = r0.f2284y
            if (r2 == 0) goto L_0x0163
            v.m r2 = new v.m
            int r3 = r14.l0()
            int r6 = r0.f2283x
            r2.<init>(r3, r6)
            androidx.camera.core.c0 r3 = new androidx.camera.core.c0
            androidx.camera.core.impl.e0 r6 = r0.f2284y
            int r8 = r0.f2283x
            java.util.concurrent.ExecutorService r10 = r0.f2280u
            r3.<init>(r6, r8, r2, r10)
            goto L_0x016f
        L_0x0163:
            v.m r2 = new v.m
            int r3 = r14.l0()
            int r6 = r0.f2283x
            r2.<init>(r3, r6)
            r3 = r2
        L_0x016f:
            r12 = r3
            r3 = r2
            r2 = r7
            goto L_0x017e
        L_0x0173:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Software JPEG only supported on API 26+"
            r1.<init>(r2)
            throw r1
        L_0x017b:
            r12 = r3
            r3 = r5
            r2 = r8
        L_0x017e:
            androidx.camera.core.j2$e r13 = new androidx.camera.core.j2$e
            int r7 = r17.getWidth()
            int r8 = r17.getHeight()
            int r10 = r0.f2283x
            androidx.camera.core.impl.c0 r6 = androidx.camera.core.w.c()
            androidx.camera.core.impl.c0 r11 = r14.f0(r6)
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11, r12)
            java.util.concurrent.ExecutorService r6 = r0.f2280u
            androidx.camera.core.j2$e r6 = r13.c(r6)
            androidx.camera.core.j2$e r2 = r6.b(r2)
            androidx.camera.core.j2 r2 = r2.a()
            r0.C = r2
            androidx.camera.core.impl.n r2 = r2.l()
            r0.E = r2
            androidx.camera.core.s2 r2 = new androidx.camera.core.s2
            androidx.camera.core.j2 r6 = r0.C
            r2.<init>(r6)
            r0.B = r2
        L_0x01b5:
            androidx.camera.core.h1$k r2 = r0.G
            if (r2 == 0) goto L_0x01c3
            java.util.concurrent.CancellationException r6 = new java.util.concurrent.CancellationException
            java.lang.String r7 = "Request is canceled."
            r6.<init>(r7)
            r2.b(r6)
        L_0x01c3:
            androidx.camera.core.h1$k r2 = new androidx.camera.core.h1$k
            androidx.camera.core.z0 r6 = new androidx.camera.core.z0
            r6.<init>(r14)
            if (r3 != 0) goto L_0x01ce
            r7 = r5
            goto L_0x01d3
        L_0x01ce:
            androidx.camera.core.a1 r7 = new androidx.camera.core.a1
            r7.<init>(r3)
        L_0x01d3:
            r2.<init>(r4, r6, r7)
            r0.G = r2
            androidx.camera.core.s2 r2 = r0.B
            androidx.camera.core.impl.x0$a r3 = r0.f2273n
            java.util.concurrent.ScheduledExecutorService r4 = androidx.camera.core.impl.utils.executor.a.d()
            r2.f(r3, r4)
            androidx.camera.core.impl.DeferrableSurface r2 = r0.F
            if (r2 == 0) goto L_0x01ea
            r2.c()
        L_0x01ea:
            androidx.camera.core.impl.y0 r2 = new androidx.camera.core.impl.y0
            androidx.camera.core.s2 r3 = r0.B
            android.view.Surface r3 = r3.getSurface()
            java.util.Objects.requireNonNull(r3)
            r4 = r3
            android.view.Surface r4 = (android.view.Surface) r4
            android.util.Size r4 = new android.util.Size
            androidx.camera.core.s2 r6 = r0.B
            int r6 = r6.getWidth()
            androidx.camera.core.s2 r7 = r0.B
            int r7 = r7.getHeight()
            r4.<init>(r6, r7)
            int r6 = r14.i()
            r2.<init>(r3, r4, r6)
            r0.F = r2
            androidx.camera.core.j2 r2 = r0.C
            if (r2 == 0) goto L_0x021b
            zf.a r2 = r2.m()
            goto L_0x021f
        L_0x021b:
            zf.a r2 = u.f.h(r5)
        L_0x021f:
            r0.D = r2
            androidx.camera.core.impl.DeferrableSurface r2 = r0.F
            zf.a r2 = r2.i()
            androidx.camera.core.s2 r3 = r0.B
            java.util.Objects.requireNonNull(r3)
            androidx.camera.camera2.internal.n3 r4 = new androidx.camera.camera2.internal.n3
            r4.<init>(r3)
            java.util.concurrent.ScheduledExecutorService r3 = androidx.camera.core.impl.utils.executor.a.d()
            r2.addListener(r4, r3)
            androidx.camera.core.impl.DeferrableSurface r2 = r0.F
            r1.h(r2)
            androidx.camera.core.b1 r2 = new androidx.camera.core.b1
            r3 = r15
            r4 = r16
            r5 = r17
            r2.<init>(r14, r15, r4, r5)
            r1.f(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.h1.c0(java.lang.String, androidx.camera.core.impl.s0, android.util.Size):androidx.camera.core.impl.SessionConfig$b");
    }

    public int g0() {
        return this.f2275p;
    }

    public f2<?> h(boolean z10, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config a10 = useCaseConfigFactory.a(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE, g0());
        if (z10) {
            a10 = Config.D(a10, L.a());
        }
        if (a10 == null) {
            return null;
        }
        return o(a10).b();
    }

    public int j0() {
        int i10;
        synchronized (this.f2276q) {
            i10 = this.f2278s;
            if (i10 == -1) {
                i10 = ((s0) g()).N(2);
            }
        }
        return i10;
    }

    @NonNull
    public f2.a<?, ?, ?> o(@NonNull Config config) {
        return h.d(config);
    }

    /* access modifiers changed from: package-private */
    public zf.a<Void> q0(@NonNull j jVar) {
        String str;
        c0 c0Var;
        v1.a("ImageCapture", "issueTakePicture");
        ArrayList arrayList = new ArrayList();
        if (this.C != null) {
            c0Var = f0(w.c());
            if (c0Var == null) {
                return u.f.f(new IllegalArgumentException("ImageCapture cannot set empty CaptureBundle."));
            }
            List<f0> a10 = c0Var.a();
            if (a10 == null) {
                return u.f.f(new IllegalArgumentException("ImageCapture has CaptureBundle with null capture stages"));
            }
            if (this.f2284y == null && a10.size() > 1) {
                return u.f.f(new IllegalArgumentException("No CaptureProcessor can be found to process the images captured for multiple CaptureStages."));
            }
            if (a10.size() > this.f2283x) {
                return u.f.f(new IllegalArgumentException("ImageCapture has CaptureStages > Max CaptureStage size"));
            }
            this.C.s(c0Var);
            this.C.t(androidx.camera.core.impl.utils.executor.a.a(), new x0(jVar));
            str = this.C.n();
        } else {
            c0Var = f0(w.c());
            if (c0Var == null) {
                return u.f.f(new IllegalArgumentException("ImageCapture cannot set empty CaptureBundle."));
            }
            List<f0> a11 = c0Var.a();
            if (a11 == null) {
                return u.f.f(new IllegalArgumentException("ImageCapture has CaptureBundle with null capture stages"));
            }
            if (a11.size() > 1) {
                return u.f.f(new IllegalArgumentException("ImageCapture have no CaptureProcess set with CaptureBundle size > 1."));
            }
            str = null;
        }
        for (f0 next : c0Var.a()) {
            d0.a aVar = new d0.a();
            aVar.q(this.f2281v.g());
            aVar.e(this.f2281v.d());
            aVar.a(this.A.p());
            aVar.f(this.F);
            if (i() == 256) {
                if (M.a()) {
                    aVar.d(d0.f2485h, Integer.valueOf(jVar.f2303a));
                }
                aVar.d(d0.f2486i, Integer.valueOf(jVar.f2304b));
            }
            aVar.e(next.a().d());
            if (str != null) {
                aVar.g(str, Integer.valueOf(next.getId()));
            }
            aVar.c(this.E);
            arrayList.add(aVar.h());
        }
        return H0(arrayList);
    }

    @NonNull
    public String toString() {
        return "ImageCapture:" + j();
    }

    public void y() {
        s0 s0Var = (s0) g();
        this.f2281v = d0.a.j(s0Var).h();
        this.f2284y = s0Var.M((e0) null);
        this.f2283x = s0Var.S(2);
        this.f2282w = s0Var.K(w.c());
        this.f2285z = s0Var.U();
        androidx.core.util.h.h(d(), "Attached camera cannot be null");
        this.f2280u = Executors.newFixedThreadPool(1, new f());
    }

    /* access modifiers changed from: protected */
    public void z() {
        L0();
    }
}
