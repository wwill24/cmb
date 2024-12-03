package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.engine.g;
import g4.a;
import i3.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob<R> implements e.a, Runnable, Comparable<DecodeJob<?>>, a.f {
    private boolean B;
    private Object C;
    private Thread D;
    private i3.b E;
    private i3.b F;
    private Object G;
    private DataSource H;
    private j3.d<?> I;
    private volatile e J;
    private volatile boolean K;
    private volatile boolean L;

    /* renamed from: a  reason: collision with root package name */
    private final f<R> f9244a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f9245b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final g4.c f9246c = g4.c.a();

    /* renamed from: d  reason: collision with root package name */
    private final e f9247d;

    /* renamed from: e  reason: collision with root package name */
    private final androidx.core.util.e<DecodeJob<?>> f9248e;

    /* renamed from: f  reason: collision with root package name */
    private final d<?> f9249f = new d<>();

    /* renamed from: g  reason: collision with root package name */
    private final f f9250g = new f();

    /* renamed from: h  reason: collision with root package name */
    private com.bumptech.glide.e f9251h;

    /* renamed from: j  reason: collision with root package name */
    private i3.b f9252j;

    /* renamed from: k  reason: collision with root package name */
    private Priority f9253k;

    /* renamed from: l  reason: collision with root package name */
    private k f9254l;

    /* renamed from: m  reason: collision with root package name */
    private int f9255m;

    /* renamed from: n  reason: collision with root package name */
    private int f9256n;

    /* renamed from: p  reason: collision with root package name */
    private l3.a f9257p;

    /* renamed from: q  reason: collision with root package name */
    private i3.e f9258q;

    /* renamed from: t  reason: collision with root package name */
    private b<R> f9259t;

    /* renamed from: w  reason: collision with root package name */
    private int f9260w;

    /* renamed from: x  reason: collision with root package name */
    private Stage f9261x;

    /* renamed from: y  reason: collision with root package name */
    private RunReason f9262y;

    /* renamed from: z  reason: collision with root package name */
    private long f9263z;

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9275a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f9276b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f9277c;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        static {
            /*
                com.bumptech.glide.load.EncodeStrategy[] r0 = com.bumptech.glide.load.EncodeStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9277c = r0
                r1 = 1
                com.bumptech.glide.load.EncodeStrategy r2 = com.bumptech.glide.load.EncodeStrategy.SOURCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f9277c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.load.EncodeStrategy r3 = com.bumptech.glide.load.EncodeStrategy.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.bumptech.glide.load.engine.DecodeJob$Stage[] r2 = com.bumptech.glide.load.engine.DecodeJob.Stage.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f9276b = r2
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f9276b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = f9276b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.SOURCE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f9276b     // Catch:{ NoSuchFieldError -> 0x004e }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r3 = f9276b     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                com.bumptech.glide.load.engine.DecodeJob$RunReason[] r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f9275a = r3
                com.bumptech.glide.load.engine.DecodeJob$RunReason r4 = com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x006a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r1 = f9275a     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r0 = f9275a     // Catch:{ NoSuchFieldError -> 0x007e }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r1 = com.bumptech.glide.load.engine.DecodeJob.RunReason.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.a.<clinit>():void");
        }
    }

    interface b<R> {
        void a(DecodeJob<?> decodeJob);

        void b(GlideException glideException);

        void c(l3.c<R> cVar, DataSource dataSource);
    }

    private final class c<Z> implements g.a<Z> {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource f9278a;

        c(DataSource dataSource) {
            this.f9278a = dataSource;
        }

        @NonNull
        public l3.c<Z> a(@NonNull l3.c<Z> cVar) {
            return DecodeJob.this.z(this.f9278a, cVar);
        }
    }

    private static class d<Z> {

        /* renamed from: a  reason: collision with root package name */
        private i3.b f9280a;

        /* renamed from: b  reason: collision with root package name */
        private i3.g<Z> f9281b;

        /* renamed from: c  reason: collision with root package name */
        private p<Z> f9282c;

        d() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f9280a = null;
            this.f9281b = null;
            this.f9282c = null;
        }

        /* access modifiers changed from: package-private */
        public void b(e eVar, i3.e eVar2) {
            g4.b.a("DecodeJob.encode");
            try {
                eVar.a().b(this.f9280a, new d(this.f9281b, this.f9282c, eVar2));
            } finally {
                this.f9282c.g();
                g4.b.d();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f9282c != null;
        }

        /* access modifiers changed from: package-private */
        public <X> void d(i3.b bVar, i3.g<X> gVar, p<X> pVar) {
            this.f9280a = bVar;
            this.f9281b = gVar;
            this.f9282c = pVar;
        }
    }

    interface e {
        n3.a a();
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        private boolean f9283a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f9284b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9285c;

        f() {
        }

        private boolean a(boolean z10) {
            return (this.f9285c || z10 || this.f9284b) && this.f9283a;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean b() {
            this.f9284b = true;
            return a(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean c() {
            this.f9285c = true;
            return a(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean d(boolean z10) {
            this.f9283a = true;
            return a(z10);
        }

        /* access modifiers changed from: package-private */
        public synchronized void e() {
            this.f9284b = false;
            this.f9283a = false;
            this.f9285c = false;
        }
    }

    DecodeJob(e eVar, androidx.core.util.e<DecodeJob<?>> eVar2) {
        this.f9247d = eVar;
        this.f9248e = eVar2;
    }

    private void B() {
        this.f9250g.e();
        this.f9249f.a();
        this.f9244a.a();
        this.K = false;
        this.f9251h = null;
        this.f9252j = null;
        this.f9258q = null;
        this.f9253k = null;
        this.f9254l = null;
        this.f9259t = null;
        this.f9261x = null;
        this.J = null;
        this.D = null;
        this.E = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.f9263z = 0;
        this.L = false;
        this.C = null;
        this.f9245b.clear();
        this.f9248e.a(this);
    }

    private void C() {
        this.D = Thread.currentThread();
        this.f9263z = f4.f.b();
        boolean z10 = false;
        while (!this.L && this.J != null && !(z10 = this.J.d())) {
            this.f9261x = o(this.f9261x);
            this.J = l();
            if (this.f9261x == Stage.SOURCE) {
                c();
                return;
            }
        }
        if ((this.f9261x == Stage.FINISHED || this.L) && !z10) {
            w();
        }
    }

    private <Data, ResourceType> l3.c<R> D(Data data, DataSource dataSource, o<Data, ResourceType, R> oVar) throws GlideException {
        i3.e p10 = p(dataSource);
        j3.e l10 = this.f9251h.h().l(data);
        try {
            return oVar.a(l10, p10, this.f9255m, this.f9256n, new c(dataSource));
        } finally {
            l10.b();
        }
    }

    private void G() {
        int i10 = a.f9275a[this.f9262y.ordinal()];
        if (i10 == 1) {
            this.f9261x = o(Stage.INITIALIZE);
            this.J = l();
            C();
        } else if (i10 == 2) {
            C();
        } else if (i10 == 3) {
            k();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.f9262y);
        }
    }

    private void H() {
        Throwable th2;
        this.f9246c.c();
        if (this.K) {
            if (this.f9245b.isEmpty()) {
                th2 = null;
            } else {
                List<Throwable> list = this.f9245b;
                th2 = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th2);
        }
        this.K = true;
    }

    private int getPriority() {
        return this.f9253k.ordinal();
    }

    private <Data> l3.c<R> i(j3.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long b10 = f4.f.b();
            l3.c<R> j10 = j(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                r("Decoded result " + j10, b10);
            }
            return j10;
        } finally {
            dVar.b();
        }
    }

    private <Data> l3.c<R> j(Data data, DataSource dataSource) throws GlideException {
        return D(data, dataSource, this.f9244a.h(data.getClass()));
    }

    private void k() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j10 = this.f9263z;
            s("Retrieved data", j10, "data: " + this.G + ", cache key: " + this.E + ", fetcher: " + this.I);
        }
        l3.c<R> cVar = null;
        try {
            cVar = i(this.I, this.G, this.H);
        } catch (GlideException e10) {
            e10.i(this.F, this.H);
            this.f9245b.add(e10);
        }
        if (cVar != null) {
            v(cVar, this.H);
        } else {
            C();
        }
    }

    private e l() {
        int i10 = a.f9276b[this.f9261x.ordinal()];
        if (i10 == 1) {
            return new q(this.f9244a, this);
        }
        if (i10 == 2) {
            return new b(this.f9244a, this);
        }
        if (i10 == 3) {
            return new t(this.f9244a, this);
        }
        if (i10 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f9261x);
    }

    private Stage o(Stage stage) {
        int i10 = a.f9276b[stage.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3 || i10 == 4) {
                    return Stage.FINISHED;
                }
                if (i10 != 5) {
                    throw new IllegalArgumentException("Unrecognized stage: " + stage);
                } else if (this.f9257p.b()) {
                    return Stage.RESOURCE_CACHE;
                } else {
                    return o(Stage.RESOURCE_CACHE);
                }
            } else if (this.B) {
                return Stage.FINISHED;
            } else {
                return Stage.SOURCE;
            }
        } else if (this.f9257p.a()) {
            return Stage.DATA_CACHE;
        } else {
            return o(Stage.DATA_CACHE);
        }
    }

    @NonNull
    private i3.e p(DataSource dataSource) {
        boolean z10;
        i3.e eVar = this.f9258q;
        if (Build.VERSION.SDK_INT < 26) {
            return eVar;
        }
        if (dataSource == DataSource.RESOURCE_DISK_CACHE || this.f9244a.w()) {
            z10 = true;
        } else {
            z10 = false;
        }
        i3.d dVar = com.bumptech.glide.load.resource.bitmap.a.f9476j;
        Boolean bool = (Boolean) eVar.a(dVar);
        if (bool != null && (!bool.booleanValue() || z10)) {
            return eVar;
        }
        i3.e eVar2 = new i3.e();
        eVar2.b(this.f9258q);
        eVar2.c(dVar, Boolean.valueOf(z10));
        return eVar2;
    }

    private void r(String str, long j10) {
        s(str, j10, (String) null);
    }

    private void s(String str, long j10, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(f4.f.a(j10));
        sb2.append(", load key: ");
        sb2.append(this.f9254l);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb2.append(str3);
        sb2.append(", thread: ");
        sb2.append(Thread.currentThread().getName());
    }

    private void t(l3.c<R> cVar, DataSource dataSource) {
        H();
        this.f9259t.c(cVar, dataSource);
    }

    private void v(l3.c<R> cVar, DataSource dataSource) {
        if (cVar instanceof l3.b) {
            ((l3.b) cVar).initialize();
        }
        p<R> pVar = null;
        p<R> pVar2 = cVar;
        if (this.f9249f.c()) {
            p<R> e10 = p.e(cVar);
            pVar = e10;
            pVar2 = e10;
        }
        t(pVar2, dataSource);
        this.f9261x = Stage.ENCODE;
        try {
            if (this.f9249f.c()) {
                this.f9249f.b(this.f9247d, this.f9258q);
            }
            x();
        } finally {
            if (pVar != null) {
                pVar.g();
            }
        }
    }

    private void w() {
        H();
        this.f9259t.b(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList(this.f9245b)));
        y();
    }

    private void x() {
        if (this.f9250g.b()) {
            B();
        }
    }

    private void y() {
        if (this.f9250g.c()) {
            B();
        }
    }

    /* access modifiers changed from: package-private */
    public void A(boolean z10) {
        if (this.f9250g.d(z10)) {
            B();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        Stage o10 = o(Stage.INITIALIZE);
        if (o10 == Stage.RESOURCE_CACHE || o10 == Stage.DATA_CACHE) {
            return true;
        }
        return false;
    }

    public void a(i3.b bVar, Exception exc, j3.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.j(bVar, dataSource, dVar.a());
        this.f9245b.add(glideException);
        if (Thread.currentThread() != this.D) {
            this.f9262y = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.f9259t.a(this);
            return;
        }
        C();
    }

    public void b(i3.b bVar, Object obj, j3.d<?> dVar, DataSource dataSource, i3.b bVar2) {
        this.E = bVar;
        this.G = obj;
        this.I = dVar;
        this.H = dataSource;
        this.F = bVar2;
        if (Thread.currentThread() != this.D) {
            this.f9262y = RunReason.DECODE_DATA;
            this.f9259t.a(this);
            return;
        }
        g4.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            k();
        } finally {
            g4.b.d();
        }
    }

    public void c() {
        this.f9262y = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.f9259t.a(this);
    }

    @NonNull
    public g4.c d() {
        return this.f9246c;
    }

    public void e() {
        this.L = true;
        e eVar = this.J;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    /* renamed from: h */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int priority = getPriority() - decodeJob.getPriority();
        if (priority == 0) {
            return this.f9260w - decodeJob.f9260w;
        }
        return priority;
    }

    /* access modifiers changed from: package-private */
    public DecodeJob<R> q(com.bumptech.glide.e eVar, Object obj, k kVar, i3.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, l3.a aVar, Map<Class<?>, h<?>> map, boolean z10, boolean z11, boolean z12, i3.e eVar2, b<R> bVar2, int i12) {
        this.f9244a.u(eVar, obj, bVar, i10, i11, aVar, cls, cls2, priority, eVar2, map, z10, z11, this.f9247d);
        this.f9251h = eVar;
        this.f9252j = bVar;
        this.f9253k = priority;
        this.f9254l = kVar;
        this.f9255m = i10;
        this.f9256n = i11;
        this.f9257p = aVar;
        this.B = z12;
        this.f9258q = eVar2;
        this.f9259t = bVar2;
        this.f9260w = i12;
        this.f9262y = RunReason.INITIALIZE;
        this.C = obj;
        return this;
    }

    public void run() {
        g4.b.b("DecodeJob#run(model=%s)", this.C);
        j3.d<?> dVar = this.I;
        try {
            if (this.L) {
                w();
                if (dVar != null) {
                    dVar.b();
                }
                g4.b.d();
                return;
            }
            G();
            if (dVar != null) {
                dVar.b();
            }
            g4.b.d();
        } catch (CallbackException e10) {
            throw e10;
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.b();
            }
            g4.b.d();
            throw th2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: com.bumptech.glide.load.engine.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: com.bumptech.glide.load.engine.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: com.bumptech.glide.load.engine.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.bumptech.glide.load.engine.r} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Z> l3.c<Z> z(com.bumptech.glide.load.DataSource r12, @androidx.annotation.NonNull l3.c<Z> r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r13.get()
            java.lang.Class r8 = r0.getClass()
            com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
            r1 = 0
            if (r12 == r0) goto L_0x0020
            com.bumptech.glide.load.engine.f<R> r0 = r11.f9244a
            i3.h r0 = r0.r(r8)
            com.bumptech.glide.e r2 = r11.f9251h
            int r3 = r11.f9255m
            int r4 = r11.f9256n
            l3.c r2 = r0.transform(r2, r13, r3, r4)
            r7 = r0
            r0 = r2
            goto L_0x0022
        L_0x0020:
            r0 = r13
            r7 = r1
        L_0x0022:
            boolean r2 = r13.equals(r0)
            if (r2 != 0) goto L_0x002b
            r13.a()
        L_0x002b:
            com.bumptech.glide.load.engine.f<R> r13 = r11.f9244a
            boolean r13 = r13.v(r0)
            if (r13 == 0) goto L_0x0040
            com.bumptech.glide.load.engine.f<R> r13 = r11.f9244a
            i3.g r1 = r13.n(r0)
            i3.e r13 = r11.f9258q
            com.bumptech.glide.load.EncodeStrategy r13 = r1.b(r13)
            goto L_0x0042
        L_0x0040:
            com.bumptech.glide.load.EncodeStrategy r13 = com.bumptech.glide.load.EncodeStrategy.NONE
        L_0x0042:
            r10 = r1
            com.bumptech.glide.load.engine.f<R> r1 = r11.f9244a
            i3.b r2 = r11.E
            boolean r1 = r1.x(r2)
            r2 = 1
            r1 = r1 ^ r2
            l3.a r3 = r11.f9257p
            boolean r12 = r3.d(r1, r12, r13)
            if (r12 == 0) goto L_0x00b3
            if (r10 == 0) goto L_0x00a5
            int[] r12 = com.bumptech.glide.load.engine.DecodeJob.a.f9277c
            int r1 = r13.ordinal()
            r12 = r12[r1]
            if (r12 == r2) goto L_0x0092
            r1 = 2
            if (r12 != r1) goto L_0x007b
            com.bumptech.glide.load.engine.r r12 = new com.bumptech.glide.load.engine.r
            com.bumptech.glide.load.engine.f<R> r13 = r11.f9244a
            m3.b r2 = r13.b()
            i3.b r3 = r11.E
            i3.b r4 = r11.f9252j
            int r5 = r11.f9255m
            int r6 = r11.f9256n
            i3.e r9 = r11.f9258q
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x009b
        L_0x007b:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown strategy: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x0092:
            com.bumptech.glide.load.engine.c r12 = new com.bumptech.glide.load.engine.c
            i3.b r13 = r11.E
            i3.b r1 = r11.f9252j
            r12.<init>(r13, r1)
        L_0x009b:
            com.bumptech.glide.load.engine.p r0 = com.bumptech.glide.load.engine.p.e(r0)
            com.bumptech.glide.load.engine.DecodeJob$d<?> r13 = r11.f9249f
            r13.d(r12, r10, r0)
            goto L_0x00b3
        L_0x00a5:
            com.bumptech.glide.Registry$NoResultEncoderAvailableException r12 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
            java.lang.Object r13 = r0.get()
            java.lang.Class r13 = r13.getClass()
            r12.<init>(r13)
            throw r12
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.z(com.bumptech.glide.load.DataSource, l3.c):l3.c");
    }
}
