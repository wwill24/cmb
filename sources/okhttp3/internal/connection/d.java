package okhttp3.internal.connection;

import com.leanplum.internal.Constants;
import com.mparticle.kits.ReportingMessage;
import fl.g;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.a;
import okhttp3.c0;
import okhttp3.internal.connection.h;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.q;
import okhttp3.t;
import okhttp3.x;

@Metadata(bv = {}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020$\u0012\u0006\u0010)\u001a\u00020'¢\u0006\u0004\b8\u00109J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J0\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u001a\u0010#\u001a\u00020\u001f8\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010.R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u00100R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u00100R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00100R\u0018\u00107\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lokhttp3/internal/connection/d;", "", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "doExtensiveHealthChecks", "Lokhttp3/internal/connection/RealConnection;", "c", "b", "Lokhttp3/c0;", "f", "Lokhttp3/x;", "client", "Lfl/g;", "chain", "Lfl/d;", "a", "Ljava/io/IOException;", "e", "", "h", "Lokhttp3/t;", "url", "g", "Lokhttp3/internal/connection/f;", "Lokhttp3/internal/connection/f;", "connectionPool", "Lokhttp3/a;", "Lokhttp3/a;", "d", "()Lokhttp3/a;", "address", "Lokhttp3/internal/connection/e;", "Lokhttp3/internal/connection/e;", "call", "Lokhttp3/q;", "Lokhttp3/q;", "eventListener", "Lokhttp3/internal/connection/h$b;", "Lokhttp3/internal/connection/h$b;", "routeSelection", "Lokhttp3/internal/connection/h;", "Lokhttp3/internal/connection/h;", "routeSelector", "I", "refusedStreamCount", "connectionShutdownCount", "i", "otherFailureCount", "j", "Lokhttp3/c0;", "nextRouteToTry", "<init>", "(Lokhttp3/internal/connection/f;Lokhttp3/a;Lokhttp3/internal/connection/e;Lokhttp3/q;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final f f33037a;

    /* renamed from: b  reason: collision with root package name */
    private final a f33038b;

    /* renamed from: c  reason: collision with root package name */
    private final e f33039c;

    /* renamed from: d  reason: collision with root package name */
    private final q f33040d;

    /* renamed from: e  reason: collision with root package name */
    private h.b f33041e;

    /* renamed from: f  reason: collision with root package name */
    private h f33042f;

    /* renamed from: g  reason: collision with root package name */
    private int f33043g;

    /* renamed from: h  reason: collision with root package name */
    private int f33044h;

    /* renamed from: i  reason: collision with root package name */
    private int f33045i;

    /* renamed from: j  reason: collision with root package name */
    private c0 f33046j;

    public d(f fVar, a aVar, e eVar, q qVar) {
        j.g(fVar, "connectionPool");
        j.g(aVar, "address");
        j.g(eVar, "call");
        j.g(qVar, "eventListener");
        this.f33037a = fVar;
        this.f33038b = aVar;
        this.f33039c = eVar;
        this.f33040d = qVar;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okhttp3.internal.connection.RealConnection b(int r15, int r16, int r17, int r18, boolean r19) throws java.io.IOException {
        /*
            r14 = this;
            r1 = r14
            okhttp3.internal.connection.e r0 = r1.f33039c
            boolean r0 = r0.m()
            if (r0 != 0) goto L_0x0179
            okhttp3.internal.connection.e r0 = r1.f33039c
            okhttp3.internal.connection.RealConnection r2 = r0.o()
            r0 = 1
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x0065
            monitor-enter(r2)
            boolean r5 = r2.p()     // Catch:{ all -> 0x0062 }
            if (r5 != 0) goto L_0x0030
            okhttp3.c0 r5 = r2.z()     // Catch:{ all -> 0x0062 }
            okhttp3.a r5 = r5.a()     // Catch:{ all -> 0x0062 }
            okhttp3.t r5 = r5.l()     // Catch:{ all -> 0x0062 }
            boolean r5 = r14.g(r5)     // Catch:{ all -> 0x0062 }
            if (r5 != 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r5 = r4
            goto L_0x0036
        L_0x0030:
            okhttp3.internal.connection.e r5 = r1.f33039c     // Catch:{ all -> 0x0062 }
            java.net.Socket r5 = r5.y()     // Catch:{ all -> 0x0062 }
        L_0x0036:
            kotlin.Unit r6 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0062 }
            monitor-exit(r2)
            okhttp3.internal.connection.e r6 = r1.f33039c
            okhttp3.internal.connection.RealConnection r6 = r6.o()
            if (r6 == 0) goto L_0x0054
            if (r5 != 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r0 = r3
        L_0x0045:
            if (r0 == 0) goto L_0x0048
            return r2
        L_0x0048:
            java.lang.String r0 = "Check failed."
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x0054:
            if (r5 != 0) goto L_0x0057
            goto L_0x005a
        L_0x0057:
            bl.d.n(r5)
        L_0x005a:
            okhttp3.q r5 = r1.f33040d
            okhttp3.internal.connection.e r6 = r1.f33039c
            r5.k(r6, r2)
            goto L_0x0065
        L_0x0062:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0065:
            r1.f33043g = r3
            r1.f33044h = r3
            r1.f33045i = r3
            okhttp3.internal.connection.f r2 = r1.f33037a
            okhttp3.a r5 = r1.f33038b
            okhttp3.internal.connection.e r6 = r1.f33039c
            boolean r2 = r2.a(r5, r6, r4, r3)
            if (r2 == 0) goto L_0x0088
            okhttp3.internal.connection.e r0 = r1.f33039c
            okhttp3.internal.connection.RealConnection r0 = r0.o()
            kotlin.jvm.internal.j.d(r0)
            okhttp3.q r2 = r1.f33040d
            okhttp3.internal.connection.e r3 = r1.f33039c
            r2.j(r3, r0)
            return r0
        L_0x0088:
            okhttp3.c0 r2 = r1.f33046j
            if (r2 == 0) goto L_0x0093
            kotlin.jvm.internal.j.d(r2)
            r1.f33046j = r4
        L_0x0091:
            r5 = r4
            goto L_0x00f8
        L_0x0093:
            okhttp3.internal.connection.h$b r2 = r1.f33041e
            if (r2 == 0) goto L_0x00aa
            kotlin.jvm.internal.j.d(r2)
            boolean r2 = r2.b()
            if (r2 == 0) goto L_0x00aa
            okhttp3.internal.connection.h$b r2 = r1.f33041e
            kotlin.jvm.internal.j.d(r2)
            okhttp3.c0 r2 = r2.c()
            goto L_0x0091
        L_0x00aa:
            okhttp3.internal.connection.h r2 = r1.f33042f
            if (r2 != 0) goto L_0x00c5
            okhttp3.internal.connection.h r2 = new okhttp3.internal.connection.h
            okhttp3.a r5 = r1.f33038b
            okhttp3.internal.connection.e r6 = r1.f33039c
            okhttp3.x r6 = r6.l()
            okhttp3.internal.connection.g r6 = r6.u()
            okhttp3.internal.connection.e r7 = r1.f33039c
            okhttp3.q r8 = r1.f33040d
            r2.<init>(r5, r6, r7, r8)
            r1.f33042f = r2
        L_0x00c5:
            okhttp3.internal.connection.h$b r2 = r2.c()
            r1.f33041e = r2
            java.util.List r5 = r2.a()
            okhttp3.internal.connection.e r6 = r1.f33039c
            boolean r6 = r6.m()
            if (r6 != 0) goto L_0x0171
            okhttp3.internal.connection.f r6 = r1.f33037a
            okhttp3.a r7 = r1.f33038b
            okhttp3.internal.connection.e r8 = r1.f33039c
            boolean r3 = r6.a(r7, r8, r5, r3)
            if (r3 == 0) goto L_0x00f4
            okhttp3.internal.connection.e r0 = r1.f33039c
            okhttp3.internal.connection.RealConnection r0 = r0.o()
            kotlin.jvm.internal.j.d(r0)
            okhttp3.q r2 = r1.f33040d
            okhttp3.internal.connection.e r3 = r1.f33039c
            r2.j(r3, r0)
            return r0
        L_0x00f4:
            okhttp3.c0 r2 = r2.c()
        L_0x00f8:
            okhttp3.internal.connection.RealConnection r3 = new okhttp3.internal.connection.RealConnection
            okhttp3.internal.connection.f r6 = r1.f33037a
            r3.<init>(r6, r2)
            okhttp3.internal.connection.e r6 = r1.f33039c
            r6.A(r3)
            okhttp3.internal.connection.e r12 = r1.f33039c     // Catch:{ all -> 0x016a }
            okhttp3.q r13 = r1.f33040d     // Catch:{ all -> 0x016a }
            r6 = r3
            r7 = r15
            r8 = r16
            r9 = r17
            r10 = r18
            r11 = r19
            r6.f(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x016a }
            okhttp3.internal.connection.e r6 = r1.f33039c
            r6.A(r4)
            okhttp3.internal.connection.e r4 = r1.f33039c
            okhttp3.x r4 = r4.l()
            okhttp3.internal.connection.g r4 = r4.u()
            okhttp3.c0 r6 = r3.z()
            r4.a(r6)
            okhttp3.internal.connection.f r4 = r1.f33037a
            okhttp3.a r6 = r1.f33038b
            okhttp3.internal.connection.e r7 = r1.f33039c
            boolean r0 = r4.a(r6, r7, r5, r0)
            if (r0 == 0) goto L_0x0151
            okhttp3.internal.connection.e r0 = r1.f33039c
            okhttp3.internal.connection.RealConnection r0 = r0.o()
            kotlin.jvm.internal.j.d(r0)
            r1.f33046j = r2
            java.net.Socket r2 = r3.D()
            bl.d.n(r2)
            okhttp3.q r2 = r1.f33040d
            okhttp3.internal.connection.e r3 = r1.f33039c
            r2.j(r3, r0)
            return r0
        L_0x0151:
            monitor-enter(r3)
            okhttp3.internal.connection.f r0 = r1.f33037a     // Catch:{ all -> 0x0167 }
            r0.e(r3)     // Catch:{ all -> 0x0167 }
            okhttp3.internal.connection.e r0 = r1.f33039c     // Catch:{ all -> 0x0167 }
            r0.c(r3)     // Catch:{ all -> 0x0167 }
            kotlin.Unit r0 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0167 }
            monitor-exit(r3)
            okhttp3.q r0 = r1.f33040d
            okhttp3.internal.connection.e r2 = r1.f33039c
            r0.j(r2, r3)
            return r3
        L_0x0167:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x016a:
            r0 = move-exception
            okhttp3.internal.connection.e r2 = r1.f33039c
            r2.A(r4)
            throw r0
        L_0x0171:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)
            throw r0
        L_0x0179:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.d.b(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    private final RealConnection c(int i10, int i11, int i12, int i13, boolean z10, boolean z11) throws IOException {
        boolean z12;
        while (true) {
            RealConnection b10 = b(i10, i11, i12, i13, z10);
            if (b10.u(z11)) {
                return b10;
            }
            b10.y();
            if (this.f33046j == null) {
                h.b bVar = this.f33041e;
                boolean z13 = true;
                if (bVar == null) {
                    z12 = true;
                } else {
                    z12 = bVar.b();
                }
                if (!z12) {
                    h hVar = this.f33042f;
                    if (hVar != null) {
                        z13 = hVar.a();
                    }
                    if (!z13) {
                        throw new IOException("exhausted all routes");
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private final c0 f() {
        RealConnection o10;
        if (this.f33043g > 1 || this.f33044h > 1 || this.f33045i > 0 || (o10 = this.f33039c.o()) == null) {
            return null;
        }
        synchronized (o10) {
            if (o10.q() != 0) {
                return null;
            }
            if (!bl.d.j(o10.z().a().l(), d().l())) {
                return null;
            }
            c0 z10 = o10.z();
            return z10;
        }
    }

    public final fl.d a(x xVar, g gVar) {
        boolean z10;
        j.g(xVar, Constants.Params.CLIENT);
        j.g(gVar, "chain");
        try {
            int f10 = gVar.f();
            int i10 = gVar.i();
            int k10 = gVar.k();
            int y10 = xVar.y();
            boolean E = xVar.E();
            if (!j.b(gVar.j().g(), "GET")) {
                z10 = true;
            } else {
                z10 = false;
            }
            return c(f10, i10, k10, y10, E, z10).w(xVar, gVar);
        } catch (RouteException e10) {
            h(e10.c());
            throw e10;
        } catch (IOException e11) {
            h(e11);
            throw new RouteException(e11);
        }
    }

    public final a d() {
        return this.f33038b;
    }

    public final boolean e() {
        h hVar;
        boolean z10 = false;
        if (this.f33043g == 0 && this.f33044h == 0 && this.f33045i == 0) {
            return false;
        }
        if (this.f33046j != null) {
            return true;
        }
        c0 f10 = f();
        if (f10 != null) {
            this.f33046j = f10;
            return true;
        }
        h.b bVar = this.f33041e;
        if (bVar != null && bVar.b()) {
            z10 = true;
        }
        if (!z10 && (hVar = this.f33042f) != null) {
            return hVar.a();
        }
        return true;
    }

    public final boolean g(t tVar) {
        j.g(tVar, "url");
        t l10 = this.f33038b.l();
        if (tVar.o() != l10.o() || !j.b(tVar.i(), l10.i())) {
            return false;
        }
        return true;
    }

    public final void h(IOException iOException) {
        j.g(iOException, ReportingMessage.MessageType.EVENT);
        this.f33046j = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
            this.f33043g++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.f33044h++;
        } else {
            this.f33045i++;
        }
    }
}
