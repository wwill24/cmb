package coil.fetch;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.l;
import coil.disk.a;
import coil.fetch.i;
import coil.network.CacheResponse;
import coil.request.k;
import gk.f;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.pool.TypePool;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.d;
import okhttp3.e;
import okhttp3.v;
import okhttp3.y;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;

@Metadata(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000  2\u00020\u0001:\u0002\u001a$B=\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020#\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020(0'\u0012\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0'\u0012\u0006\u00100\u001a\u00020\u000f¢\u0006\u0004\b6\u00107J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J.\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u001b\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u0004\u0018\u00010\t*\u00020\u0002H\u0002J\f\u0010\u0013\u001a\u00020\u0012*\u00020\u0002H\u0002J\f\u0010\u0015\u001a\u00020\u0012*\u00020\u0014H\u0002J\f\u0010\u0017\u001a\u00020\u0016*\u00020\u0007H\u0002J\f\u0010\u0018\u001a\u00020\u0014*\u00020\u0007H\u0002J\u0013\u0010\u001a\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\b \u0010!R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\"R\u0014\u0010&\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010)R\u001c\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0'8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010)R\u0014\u00100\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b,\u00101R\u0014\u00105\u001a\u0002038BX\u0004¢\u0006\u0006\u001a\u0004\b.\u00104\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcoil/fetch/HttpUriFetcher;", "Lcoil/fetch/i;", "Lcoil/disk/a$c;", "i", "snapshot", "Lokhttp3/y;", "request", "Lokhttp3/a0;", "response", "Lcoil/network/CacheResponse;", "cacheResponse", "o", "h", "c", "(Lokhttp3/y;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "g", "k", "Lcoil/decode/k;", "m", "Lokhttp3/b0;", "n", "Lcoil/decode/DataSource;", "l", "j", "Lcoil/fetch/h;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "url", "Lokhttp3/v;", "contentType", "f", "(Ljava/lang/String;Lokhttp3/v;)Ljava/lang/String;", "Ljava/lang/String;", "Lcoil/request/k;", "b", "Lcoil/request/k;", "options", "Lgk/f;", "Lokhttp3/e$a;", "Lgk/f;", "callFactory", "Lcoil/disk/a;", "d", "diskCache", "e", "Z", "respectCacheHeaders", "()Ljava/lang/String;", "diskCacheKey", "Lokio/FileSystem;", "()Lokio/FileSystem;", "fileSystem", "<init>", "(Ljava/lang/String;Lcoil/request/k;Lgk/f;Lgk/f;Z)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class HttpUriFetcher implements i {

    /* renamed from: f  reason: collision with root package name */
    public static final a f8173f = new a((DefaultConstructorMarker) null);

    /* renamed from: g  reason: collision with root package name */
    private static final d f8174g = new d.a().d().e().a();

    /* renamed from: h  reason: collision with root package name */
    private static final d f8175h = new d.a().d().f().a();

    /* renamed from: a  reason: collision with root package name */
    private final String f8176a;

    /* renamed from: b  reason: collision with root package name */
    private final k f8177b;

    /* renamed from: c  reason: collision with root package name */
    private final f<e.a> f8178c;

    /* renamed from: d  reason: collision with root package name */
    private final f<coil.disk.a> f8179d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f8180e;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcoil/fetch/HttpUriFetcher$a;", "", "Lokhttp3/d;", "CACHE_CONTROL_FORCE_NETWORK_NO_CACHE", "Lokhttp3/d;", "CACHE_CONTROL_NO_NETWORK_NO_CACHE", "", "MIME_TYPE_TEXT_PLAIN", "Ljava/lang/String;", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f\u0012\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcoil/fetch/HttpUriFetcher$b;", "Lcoil/fetch/i$a;", "Landroid/net/Uri;", "data", "", "c", "Lcoil/request/k;", "options", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/fetch/i;", "b", "Lgk/f;", "Lokhttp3/e$a;", "a", "Lgk/f;", "callFactory", "Lcoil/disk/a;", "diskCache", "Z", "respectCacheHeaders", "<init>", "(Lgk/f;Lgk/f;Z)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class b implements i.a<Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final f<e.a> f8181a;

        /* renamed from: b  reason: collision with root package name */
        private final f<coil.disk.a> f8182b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f8183c;

        public b(f<? extends e.a> fVar, f<? extends coil.disk.a> fVar2, boolean z10) {
            this.f8181a = fVar;
            this.f8182b = fVar2;
            this.f8183c = z10;
        }

        private final boolean c(Uri uri) {
            return j.b(uri.getScheme(), "http") || j.b(uri.getScheme(), "https");
        }

        /* renamed from: b */
        public i a(Uri uri, k kVar, ImageLoader imageLoader) {
            if (!c(uri)) {
                return null;
            }
            return new HttpUriFetcher(uri.toString(), kVar, this.f8181a, this.f8182b, this.f8183c);
        }
    }

    public HttpUriFetcher(String str, k kVar, f<? extends e.a> fVar, f<? extends coil.disk.a> fVar2, boolean z10) {
        this.f8176a = str;
        this.f8177b = kVar;
        this.f8178c = fVar;
        this.f8179d = fVar2;
        this.f8180e = z10;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(okhttp3.y r5, kotlin.coroutines.c<? super okhttp3.a0> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof coil.fetch.HttpUriFetcher$executeNetworkRequest$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            coil.fetch.HttpUriFetcher$executeNetworkRequest$1 r0 = (coil.fetch.HttpUriFetcher$executeNetworkRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            coil.fetch.HttpUriFetcher$executeNetworkRequest$1 r0 = new coil.fetch.HttpUriFetcher$executeNetworkRequest$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            gk.g.b(r6)
            goto L_0x0072
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            gk.g.b(r6)
            boolean r6 = coil.util.j.s()
            if (r6 == 0) goto L_0x005d
            coil.request.k r6 = r4.f8177b
            coil.request.CachePolicy r6 = r6.k()
            boolean r6 = r6.b()
            if (r6 != 0) goto L_0x0057
            gk.f<okhttp3.e$a> r6 = r4.f8178c
            java.lang.Object r6 = r6.getValue()
            okhttp3.e$a r6 = (okhttp3.e.a) r6
            okhttp3.e r5 = r6.a(r5)
            okhttp3.a0 r5 = r5.f()
            goto L_0x0075
        L_0x0057:
            android.os.NetworkOnMainThreadException r5 = new android.os.NetworkOnMainThreadException
            r5.<init>()
            throw r5
        L_0x005d:
            gk.f<okhttp3.e$a> r6 = r4.f8178c
            java.lang.Object r6 = r6.getValue()
            okhttp3.e$a r6 = (okhttp3.e.a) r6
            okhttp3.e r5 = r6.a(r5)
            r0.label = r3
            java.lang.Object r6 = coil.util.b.a(r5, r0)
            if (r6 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r5 = r6
            okhttp3.a0 r5 = (okhttp3.a0) r5
        L_0x0075:
            boolean r6 = r5.isSuccessful()
            if (r6 != 0) goto L_0x0092
            int r6 = r5.f()
            r0 = 304(0x130, float:4.26E-43)
            if (r6 == r0) goto L_0x0092
            okhttp3.b0 r6 = r5.a()
            if (r6 == 0) goto L_0x008c
            coil.util.j.d(r6)
        L_0x008c:
            coil.network.HttpException r6 = new coil.network.HttpException
            r6.<init>(r5)
            throw r6
        L_0x0092:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.c(okhttp3.y, kotlin.coroutines.c):java.lang.Object");
    }

    private final String d() {
        String h10 = this.f8177b.h();
        return h10 == null ? this.f8176a : h10;
    }

    private final FileSystem e() {
        coil.disk.a value = this.f8179d.getValue();
        j.d(value);
        return value.getFileSystem();
    }

    private final boolean g(y yVar, a0 a0Var) {
        if (!this.f8177b.i().c() || (this.f8180e && !coil.network.a.f8236c.c(yVar, a0Var))) {
            return false;
        }
        return true;
    }

    private final y h() {
        y.a g10 = new y.a().q(this.f8176a).g(this.f8177b.j());
        for (Map.Entry next : this.f8177b.p().a().entrySet()) {
            Object key = next.getKey();
            j.e(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            g10.p((Class) key, next.getValue());
        }
        boolean b10 = this.f8177b.i().b();
        boolean b11 = this.f8177b.k().b();
        if (!b11 && b10) {
            g10.c(d.f32901p);
        } else if (!b11 || b10) {
            if (!b11 && !b10) {
                g10.c(f8175h);
            }
        } else if (this.f8177b.i().c()) {
            g10.c(d.f32900o);
        } else {
            g10.c(f8174g);
        }
        return g10.b();
    }

    private final a.c i() {
        coil.disk.a value;
        if (!this.f8177b.i().b() || (value = this.f8179d.getValue()) == null) {
            return null;
        }
        return value.get(d());
    }

    private final b0 j(a0 a0Var) {
        b0 a10 = a0Var.a();
        if (a10 != null) {
            return a10;
        }
        throw new IllegalStateException("response body == null".toString());
    }

    private final CacheResponse k(a.c cVar) {
        CacheResponse cacheResponse;
        try {
            BufferedSource c10 = Okio.c(e().q(cVar.s()));
            try {
                cacheResponse = new CacheResponse(c10);
                th = null;
            } catch (Throwable th2) {
                th = th2;
                cacheResponse = null;
            }
            if (c10 != null) {
                try {
                    c10.close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    } else {
                        b.a(th, th3);
                    }
                }
            }
            if (th == null) {
                j.d(cacheResponse);
                return cacheResponse;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    private final DataSource l(a0 a0Var) {
        return a0Var.v() != null ? DataSource.NETWORK : DataSource.DISK;
    }

    private final coil.decode.k m(a.c cVar) {
        return l.c(cVar.getData(), e(), d(), cVar);
    }

    private final coil.decode.k n(b0 b0Var) {
        return l.a(b0Var.source(), this.f8177b.g());
    }

    private final a.c o(a.c cVar, y yVar, a0 a0Var, CacheResponse cacheResponse) {
        a.b bVar;
        Unit unit;
        Long l10;
        Unit unit2;
        Throwable th2 = null;
        if (!g(yVar, a0Var)) {
            if (cVar != null) {
                coil.util.j.d(cVar);
            }
            return null;
        }
        if (cVar != null) {
            bVar = cVar.v1();
        } else {
            coil.disk.a value = this.f8179d.getValue();
            if (value != null) {
                bVar = value.a(d());
            } else {
                bVar = null;
            }
        }
        if (bVar == null) {
            return null;
        }
        try {
            if (a0Var.f() != 304 || cacheResponse == null) {
                BufferedSink b10 = Okio.b(e().p(bVar.s(), false));
                try {
                    new CacheResponse(a0Var).g(b10);
                    unit = Unit.f32013a;
                    th = null;
                } catch (Throwable th3) {
                    th = th3;
                    unit = null;
                }
                if (b10 != null) {
                    try {
                        b10.close();
                    } catch (Throwable th4) {
                        if (th == null) {
                            th = th4;
                        } else {
                            b.a(th, th4);
                        }
                    }
                }
                if (th == null) {
                    j.d(unit);
                    BufferedSink b11 = Okio.b(e().p(bVar.getData(), false));
                    try {
                        b0 a10 = a0Var.a();
                        j.d(a10);
                        l10 = Long.valueOf(a10.source().P1(b11));
                    } catch (Throwable th5) {
                        th2 = th5;
                        l10 = null;
                    }
                    if (b11 != null) {
                        try {
                            b11.close();
                        } catch (Throwable th6) {
                            if (th2 == null) {
                                th2 = th6;
                            } else {
                                b.a(th2, th6);
                            }
                        }
                    }
                    if (th2 == null) {
                        j.d(l10);
                    } else {
                        throw th2;
                    }
                } else {
                    throw th;
                }
            } else {
                a0 c10 = a0Var.x().l(coil.network.a.f8236c.a(cacheResponse.d(), a0Var.n())).c();
                BufferedSink b12 = Okio.b(e().p(bVar.s(), false));
                try {
                    new CacheResponse(c10).g(b12);
                    unit2 = Unit.f32013a;
                } catch (Throwable th7) {
                    th2 = th7;
                    unit2 = null;
                }
                if (b12 != null) {
                    try {
                        b12.close();
                    } catch (Throwable th8) {
                        if (th2 == null) {
                            th2 = th8;
                        } else {
                            b.a(th2, th8);
                        }
                    }
                }
                if (th2 == null) {
                    j.d(unit2);
                } else {
                    throw th2;
                }
            }
            a.c t10 = bVar.t();
            coil.util.j.d(a0Var);
            return t10;
        } catch (Exception e10) {
            coil.util.j.a(bVar);
            throw e10;
        } catch (Throwable th9) {
            coil.util.j.d(a0Var);
            throw th9;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0127 A[Catch:{ Exception -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0143 A[Catch:{ Exception -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlin.coroutines.c<? super coil.fetch.h> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof coil.fetch.HttpUriFetcher$fetch$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            coil.fetch.HttpUriFetcher$fetch$1 r0 = (coil.fetch.HttpUriFetcher$fetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            coil.fetch.HttpUriFetcher$fetch$1 r0 = new coil.fetch.HttpUriFetcher$fetch$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 0
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x005e
            if (r2 == r6) goto L_0x0047
            if (r2 != r5) goto L_0x003f
            java.lang.Object r1 = r0.L$2
            okhttp3.a0 r1 = (okhttp3.a0) r1
            java.lang.Object r2 = r0.L$1
            coil.disk.a$c r2 = (coil.disk.a.c) r2
            java.lang.Object r0 = r0.L$0
            coil.fetch.HttpUriFetcher r0 = (coil.fetch.HttpUriFetcher) r0
            gk.g.b(r13)     // Catch:{ Exception -> 0x003c }
            goto L_0x017c
        L_0x003c:
            r13 = move-exception
            goto L_0x019d
        L_0x003f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0047:
            java.lang.Object r2 = r0.L$2
            coil.network.a r2 = (coil.network.a) r2
            java.lang.Object r6 = r0.L$1
            coil.disk.a$c r6 = (coil.disk.a.c) r6
            java.lang.Object r8 = r0.L$0
            coil.fetch.HttpUriFetcher r8 = (coil.fetch.HttpUriFetcher) r8
            gk.g.b(r13)     // Catch:{ Exception -> 0x005b }
            r11 = r6
            r6 = r2
            r2 = r11
            goto L_0x0113
        L_0x005b:
            r13 = move-exception
            goto L_0x01a7
        L_0x005e:
            gk.g.b(r13)
            coil.disk.a$c r13 = r12.i()
            if (r13 == 0) goto L_0x00eb
            okio.FileSystem r2 = r12.e()     // Catch:{ Exception -> 0x01a4 }
            okio.Path r8 = r13.s()     // Catch:{ Exception -> 0x01a4 }
            okio.FileMetadata r2 = r2.l(r8)     // Catch:{ Exception -> 0x01a4 }
            java.lang.Long r2 = r2.d()     // Catch:{ Exception -> 0x01a4 }
            if (r2 != 0) goto L_0x007a
            goto L_0x0094
        L_0x007a:
            long r8 = r2.longValue()     // Catch:{ Exception -> 0x01a4 }
            int r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0094
            coil.fetch.l r0 = new coil.fetch.l     // Catch:{ Exception -> 0x01a4 }
            coil.decode.k r1 = r12.m(r13)     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r2 = r12.f8176a     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r2 = r12.f(r2, r7)     // Catch:{ Exception -> 0x01a4 }
            coil.decode.DataSource r3 = coil.decode.DataSource.DISK     // Catch:{ Exception -> 0x01a4 }
            r0.<init>(r1, r2, r3)     // Catch:{ Exception -> 0x01a4 }
            return r0
        L_0x0094:
            boolean r2 = r12.f8180e     // Catch:{ Exception -> 0x01a4 }
            if (r2 == 0) goto L_0x00cf
            coil.network.a$b r2 = new coil.network.a$b     // Catch:{ Exception -> 0x01a4 }
            okhttp3.y r8 = r12.h()     // Catch:{ Exception -> 0x01a4 }
            coil.network.CacheResponse r9 = r12.k(r13)     // Catch:{ Exception -> 0x01a4 }
            r2.<init>(r8, r9)     // Catch:{ Exception -> 0x01a4 }
            coil.network.a r2 = r2.b()     // Catch:{ Exception -> 0x01a4 }
            okhttp3.y r8 = r2.b()     // Catch:{ Exception -> 0x01a4 }
            if (r8 != 0) goto L_0x00f8
            coil.network.CacheResponse r8 = r2.a()     // Catch:{ Exception -> 0x01a4 }
            if (r8 == 0) goto L_0x00f8
            coil.fetch.l r0 = new coil.fetch.l     // Catch:{ Exception -> 0x01a4 }
            coil.decode.k r1 = r12.m(r13)     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r3 = r12.f8176a     // Catch:{ Exception -> 0x01a4 }
            coil.network.CacheResponse r2 = r2.a()     // Catch:{ Exception -> 0x01a4 }
            okhttp3.v r2 = r2.b()     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r2 = r12.f(r3, r2)     // Catch:{ Exception -> 0x01a4 }
            coil.decode.DataSource r3 = coil.decode.DataSource.DISK     // Catch:{ Exception -> 0x01a4 }
            r0.<init>(r1, r2, r3)     // Catch:{ Exception -> 0x01a4 }
            return r0
        L_0x00cf:
            coil.fetch.l r0 = new coil.fetch.l     // Catch:{ Exception -> 0x01a4 }
            coil.decode.k r1 = r12.m(r13)     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r2 = r12.f8176a     // Catch:{ Exception -> 0x01a4 }
            coil.network.CacheResponse r3 = r12.k(r13)     // Catch:{ Exception -> 0x01a4 }
            if (r3 == 0) goto L_0x00e1
            okhttp3.v r7 = r3.b()     // Catch:{ Exception -> 0x01a4 }
        L_0x00e1:
            java.lang.String r2 = r12.f(r2, r7)     // Catch:{ Exception -> 0x01a4 }
            coil.decode.DataSource r3 = coil.decode.DataSource.DISK     // Catch:{ Exception -> 0x01a4 }
            r0.<init>(r1, r2, r3)     // Catch:{ Exception -> 0x01a4 }
            return r0
        L_0x00eb:
            coil.network.a$b r2 = new coil.network.a$b     // Catch:{ Exception -> 0x01a4 }
            okhttp3.y r8 = r12.h()     // Catch:{ Exception -> 0x01a4 }
            r2.<init>(r8, r7)     // Catch:{ Exception -> 0x01a4 }
            coil.network.a r2 = r2.b()     // Catch:{ Exception -> 0x01a4 }
        L_0x00f8:
            okhttp3.y r8 = r2.b()     // Catch:{ Exception -> 0x01a4 }
            kotlin.jvm.internal.j.d(r8)     // Catch:{ Exception -> 0x01a4 }
            r0.L$0 = r12     // Catch:{ Exception -> 0x01a4 }
            r0.L$1 = r13     // Catch:{ Exception -> 0x01a4 }
            r0.L$2 = r2     // Catch:{ Exception -> 0x01a4 }
            r0.label = r6     // Catch:{ Exception -> 0x01a4 }
            java.lang.Object r6 = r12.c(r8, r0)     // Catch:{ Exception -> 0x01a4 }
            if (r6 != r1) goto L_0x010e
            return r1
        L_0x010e:
            r8 = r12
            r11 = r2
            r2 = r13
            r13 = r6
            r6 = r11
        L_0x0113:
            okhttp3.a0 r13 = (okhttp3.a0) r13     // Catch:{ Exception -> 0x01a1 }
            okhttp3.b0 r9 = r8.j(r13)     // Catch:{ Exception -> 0x01a1 }
            okhttp3.y r10 = r6.b()     // Catch:{ Exception -> 0x019a }
            coil.network.CacheResponse r6 = r6.a()     // Catch:{ Exception -> 0x019a }
            coil.disk.a$c r2 = r8.o(r2, r10, r13, r6)     // Catch:{ Exception -> 0x019a }
            if (r2 == 0) goto L_0x0143
            coil.fetch.l r0 = new coil.fetch.l     // Catch:{ Exception -> 0x019a }
            coil.decode.k r1 = r8.m(r2)     // Catch:{ Exception -> 0x019a }
            java.lang.String r3 = r8.f8176a     // Catch:{ Exception -> 0x019a }
            coil.network.CacheResponse r4 = r8.k(r2)     // Catch:{ Exception -> 0x019a }
            if (r4 == 0) goto L_0x0139
            okhttp3.v r7 = r4.b()     // Catch:{ Exception -> 0x019a }
        L_0x0139:
            java.lang.String r3 = r8.f(r3, r7)     // Catch:{ Exception -> 0x019a }
            coil.decode.DataSource r4 = coil.decode.DataSource.NETWORK     // Catch:{ Exception -> 0x019a }
            r0.<init>(r1, r3, r4)     // Catch:{ Exception -> 0x019a }
            return r0
        L_0x0143:
            long r6 = r9.contentLength()     // Catch:{ Exception -> 0x019a }
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0163
            coil.fetch.l r0 = new coil.fetch.l     // Catch:{ Exception -> 0x019a }
            coil.decode.k r1 = r8.n(r9)     // Catch:{ Exception -> 0x019a }
            java.lang.String r3 = r8.f8176a     // Catch:{ Exception -> 0x019a }
            okhttp3.v r4 = r9.contentType()     // Catch:{ Exception -> 0x019a }
            java.lang.String r3 = r8.f(r3, r4)     // Catch:{ Exception -> 0x019a }
            coil.decode.DataSource r4 = r8.l(r13)     // Catch:{ Exception -> 0x019a }
            r0.<init>(r1, r3, r4)     // Catch:{ Exception -> 0x019a }
            return r0
        L_0x0163:
            coil.util.j.d(r13)     // Catch:{ Exception -> 0x019a }
            okhttp3.y r3 = r8.h()     // Catch:{ Exception -> 0x019a }
            r0.L$0 = r8     // Catch:{ Exception -> 0x019a }
            r0.L$1 = r2     // Catch:{ Exception -> 0x019a }
            r0.L$2 = r13     // Catch:{ Exception -> 0x019a }
            r0.label = r5     // Catch:{ Exception -> 0x019a }
            java.lang.Object r0 = r8.c(r3, r0)     // Catch:{ Exception -> 0x019a }
            if (r0 != r1) goto L_0x0179
            return r1
        L_0x0179:
            r1 = r13
            r13 = r0
            r0 = r8
        L_0x017c:
            okhttp3.a0 r13 = (okhttp3.a0) r13     // Catch:{ Exception -> 0x003c }
            okhttp3.b0 r1 = r0.j(r13)     // Catch:{ Exception -> 0x019a }
            coil.fetch.l r3 = new coil.fetch.l     // Catch:{ Exception -> 0x019a }
            coil.decode.k r4 = r0.n(r1)     // Catch:{ Exception -> 0x019a }
            java.lang.String r5 = r0.f8176a     // Catch:{ Exception -> 0x019a }
            okhttp3.v r1 = r1.contentType()     // Catch:{ Exception -> 0x019a }
            java.lang.String r1 = r0.f(r5, r1)     // Catch:{ Exception -> 0x019a }
            coil.decode.DataSource r0 = r0.l(r13)     // Catch:{ Exception -> 0x019a }
            r3.<init>(r4, r1, r0)     // Catch:{ Exception -> 0x019a }
            return r3
        L_0x019a:
            r0 = move-exception
            r1 = r13
            r13 = r0
        L_0x019d:
            coil.util.j.d(r1)     // Catch:{ Exception -> 0x01a1 }
            throw r13     // Catch:{ Exception -> 0x01a1 }
        L_0x01a1:
            r13 = move-exception
            r6 = r2
            goto L_0x01a7
        L_0x01a4:
            r0 = move-exception
            r6 = r13
            r13 = r0
        L_0x01a7:
            if (r6 == 0) goto L_0x01ac
            coil.util.j.d(r6)
        L_0x01ac:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.a(kotlin.coroutines.c):java.lang.Object");
    }

    public final String f(String str, v vVar) {
        String str2;
        String k10;
        if (vVar != null) {
            str2 = vVar.toString();
        } else {
            str2 = null;
        }
        if ((str2 == null || r.J(str2, "text/plain", false, 2, (Object) null)) && (k10 = coil.util.j.k(MimeTypeMap.getSingleton(), str)) != null) {
            return k10;
        }
        if (str2 != null) {
            return StringsKt__StringsKt.S0(str2, TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, (String) null, 2, (Object) null);
        }
        return null;
    }
}
