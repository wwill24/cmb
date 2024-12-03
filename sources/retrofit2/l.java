package retrofit2;

import java.io.IOException;
import java.util.Objects;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.e;
import okhttp3.f;
import okhttp3.v;
import okhttp3.y;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

final class l<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final q f42296a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f42297b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a f42298c;

    /* renamed from: d  reason: collision with root package name */
    private final f<b0, T> f42299d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f42300e;

    /* renamed from: f  reason: collision with root package name */
    private e f42301f;

    /* renamed from: g  reason: collision with root package name */
    private Throwable f42302g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f42303h;

    class a implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f42304a;

        a(d dVar) {
            this.f42304a = dVar;
        }

        private void a(Throwable th2) {
            try {
                this.f42304a.onFailure(l.this, th2);
            } catch (Throwable th3) {
                w.s(th3);
                th3.printStackTrace();
            }
        }

        public void onFailure(e eVar, IOException iOException) {
            a(iOException);
        }

        public void onResponse(e eVar, a0 a0Var) {
            try {
                try {
                    this.f42304a.onResponse(l.this, l.this.d(a0Var));
                } catch (Throwable th2) {
                    w.s(th2);
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                w.s(th3);
                a(th3);
            }
        }
    }

    static final class b extends b0 {

        /* renamed from: a  reason: collision with root package name */
        private final b0 f42306a;

        /* renamed from: b  reason: collision with root package name */
        private final BufferedSource f42307b;

        /* renamed from: c  reason: collision with root package name */
        IOException f42308c;

        class a extends ForwardingSource {
            a(Source source) {
                super(source);
            }

            public long N1(Buffer buffer, long j10) throws IOException {
                try {
                    return super.N1(buffer, j10);
                } catch (IOException e10) {
                    b.this.f42308c = e10;
                    throw e10;
                }
            }
        }

        b(b0 b0Var) {
            this.f42306a = b0Var;
            this.f42307b = Okio.c(new a(b0Var.source()));
        }

        /* access modifiers changed from: package-private */
        public void a() throws IOException {
            IOException iOException = this.f42308c;
            if (iOException != null) {
                throw iOException;
            }
        }

        public void close() {
            this.f42306a.close();
        }

        public long contentLength() {
            return this.f42306a.contentLength();
        }

        public v contentType() {
            return this.f42306a.contentType();
        }

        public BufferedSource source() {
            return this.f42307b;
        }
    }

    static final class c extends b0 {

        /* renamed from: a  reason: collision with root package name */
        private final v f42310a;

        /* renamed from: b  reason: collision with root package name */
        private final long f42311b;

        c(v vVar, long j10) {
            this.f42310a = vVar;
            this.f42311b = j10;
        }

        public long contentLength() {
            return this.f42311b;
        }

        public v contentType() {
            return this.f42310a;
        }

        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    l(q qVar, Object[] objArr, e.a aVar, f<b0, T> fVar) {
        this.f42296a = qVar;
        this.f42297b = objArr;
        this.f42298c = aVar;
        this.f42299d = fVar;
    }

    private e b() throws IOException {
        e a10 = this.f42298c.a(this.f42296a.a(this.f42297b));
        if (a10 != null) {
            return a10;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private e c() throws IOException {
        e eVar = this.f42301f;
        if (eVar != null) {
            return eVar;
        }
        Throwable th2 = this.f42302g;
        if (th2 == null) {
            try {
                e b10 = b();
                this.f42301f = b10;
                return b10;
            } catch (IOException | Error | RuntimeException e10) {
                w.s(e10);
                this.f42302g = e10;
                throw e10;
            }
        } else if (th2 instanceof IOException) {
            throw ((IOException) th2);
        } else if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        } else {
            throw ((Error) th2);
        }
    }

    public void L(d<T> dVar) {
        e eVar;
        Throwable th2;
        Objects.requireNonNull(dVar, "callback == null");
        synchronized (this) {
            if (!this.f42303h) {
                this.f42303h = true;
                eVar = this.f42301f;
                th2 = this.f42302g;
                if (eVar == null && th2 == null) {
                    try {
                        e b10 = b();
                        this.f42301f = b10;
                        eVar = b10;
                    } catch (Throwable th3) {
                        th2 = th3;
                        w.s(th2);
                        this.f42302g = th2;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th2 != null) {
            dVar.onFailure(this, th2);
            return;
        }
        if (this.f42300e) {
            eVar.cancel();
        }
        eVar.P(new a(dVar));
    }

    /* renamed from: a */
    public l<T> clone() {
        return new l<>(this.f42296a, this.f42297b, this.f42298c, this.f42299d);
    }

    public void cancel() {
        e eVar;
        this.f42300e = true;
        synchronized (this) {
            eVar = this.f42301f;
        }
        if (eVar != null) {
            eVar.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public r<T> d(a0 a0Var) throws IOException {
        b0 a10 = a0Var.a();
        a0 c10 = a0Var.x().b(new c(a10.contentType(), a10.contentLength())).c();
        int f10 = c10.f();
        if (f10 < 200 || f10 >= 300) {
            try {
                return r.d(w.a(a10), c10);
            } finally {
                a10.close();
            }
        } else if (f10 == 204 || f10 == 205) {
            a10.close();
            return r.j(null, c10);
        } else {
            b bVar = new b(a10);
            try {
                return r.j(this.f42299d.convert(bVar), c10);
            } catch (RuntimeException e10) {
                bVar.a();
                throw e10;
            }
        }
    }

    public r<T> f() throws IOException {
        e c10;
        synchronized (this) {
            if (!this.f42303h) {
                this.f42303h = true;
                c10 = c();
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f42300e) {
            c10.cancel();
        }
        return d(c10.f());
    }

    public synchronized y g() {
        try {
        } catch (IOException e10) {
            throw new RuntimeException("Unable to create request.", e10);
        }
        return c().g();
    }

    public boolean m() {
        boolean z10 = true;
        if (this.f42300e) {
            return true;
        }
        synchronized (this) {
            e eVar = this.f42301f;
            if (eVar == null || !eVar.m()) {
                z10 = false;
            }
        }
        return z10;
    }
}
