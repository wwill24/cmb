package okhttp3;

import fl.e;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.internal.connection.c;
import okhttp3.s;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

@Metadata(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB}\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\b\u0010)\u001a\u0004\u0018\u00010%\u0012\u0006\u0010.\u001a\u00020*\u0012\b\u00103\u001a\u0004\u0018\u00010/\u0012\b\u00107\u001a\u0004\u0018\u00010\u0000\u0012\b\u00109\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010A\u001a\u00020=\u0012\u0006\u0010D\u001a\u00020=\u0012\b\u0010H\u001a\u0004\u0018\u00010E¢\u0006\u0004\bR\u0010SJ\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0006\u0010\u0007\u001a\u00020\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0007¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010)\u001a\u0004\u0018\u00010%8\u0007¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010.\u001a\u00020*8\u0007¢\u0006\f\n\u0004\b\"\u0010+\u001a\u0004\b,\u0010-R\u0019\u00103\u001a\u0004\u0018\u00010/8\u0007¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b\u000f\u00102R\u0019\u00107\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b'\u00104\u001a\u0004\b5\u00106R\u0019\u00109\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b8\u00104\u001a\u0004\b\u001a\u00106R\u0019\u0010<\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b:\u00104\u001a\u0004\b;\u00106R\u0017\u0010A\u001a\u00020=8\u0007¢\u0006\f\n\u0004\b\u0005\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010D\u001a\u00020=8\u0007¢\u0006\f\n\u0004\bB\u0010>\u001a\u0004\bC\u0010@R\u001c\u0010H\u001a\u0004\u0018\u00010E8\u0001X\u0004¢\u0006\f\n\u0004\b,\u0010F\u001a\u0004\b0\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0011\u0010N\u001a\u00020M8F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0011\u0010Q\u001a\u00020I8G¢\u0006\u0006\u001a\u0004\b\u0015\u0010P¨\u0006T"}, d2 = {"Lokhttp3/a0;", "Ljava/io/Closeable;", "", "name", "defaultValue", "l", "Lokhttp3/a0$a;", "x", "", "Lokhttp3/g;", "e", "", "close", "toString", "Lokhttp3/y;", "a", "Lokhttp3/y;", "F", "()Lokhttp3/y;", "request", "Lokhttp3/Protocol;", "b", "Lokhttp3/Protocol;", "C", "()Lokhttp3/Protocol;", "protocol", "c", "Ljava/lang/String;", "u", "()Ljava/lang/String;", "message", "", "d", "I", "f", "()I", "code", "Lokhttp3/Handshake;", "Lokhttp3/Handshake;", "h", "()Lokhttp3/Handshake;", "handshake", "Lokhttp3/s;", "Lokhttp3/s;", "n", "()Lokhttp3/s;", "headers", "Lokhttp3/b0;", "g", "Lokhttp3/b0;", "()Lokhttp3/b0;", "body", "Lokhttp3/a0;", "v", "()Lokhttp3/a0;", "networkResponse", "j", "cacheResponse", "k", "y", "priorResponse", "", "J", "G", "()J", "sentRequestAtMillis", "m", "E", "receivedResponseAtMillis", "Lokhttp3/internal/connection/c;", "Lokhttp3/internal/connection/c;", "()Lokhttp3/internal/connection/c;", "exchange", "Lokhttp3/d;", "p", "Lokhttp3/d;", "lazyCacheControl", "", "isSuccessful", "()Z", "()Lokhttp3/d;", "cacheControl", "<init>", "(Lokhttp3/y;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/s;Lokhttp3/b0;Lokhttp3/a0;Lokhttp3/a0;Lokhttp3/a0;JJLokhttp3/internal/connection/c;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a0 implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final y f32858a;

    /* renamed from: b  reason: collision with root package name */
    private final Protocol f32859b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32860c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32861d;

    /* renamed from: e  reason: collision with root package name */
    private final Handshake f32862e;

    /* renamed from: f  reason: collision with root package name */
    private final s f32863f;

    /* renamed from: g  reason: collision with root package name */
    private final b0 f32864g;

    /* renamed from: h  reason: collision with root package name */
    private final a0 f32865h;

    /* renamed from: j  reason: collision with root package name */
    private final a0 f32866j;

    /* renamed from: k  reason: collision with root package name */
    private final a0 f32867k;

    /* renamed from: l  reason: collision with root package name */
    private final long f32868l;

    /* renamed from: m  reason: collision with root package name */
    private final long f32869m;

    /* renamed from: n  reason: collision with root package name */
    private final c f32870n;

    /* renamed from: p  reason: collision with root package name */
    private d f32871p;

    public a0(y yVar, Protocol protocol, String str, int i10, Handshake handshake, s sVar, b0 b0Var, a0 a0Var, a0 a0Var2, a0 a0Var3, long j10, long j11, c cVar) {
        j.g(yVar, "request");
        j.g(protocol, "protocol");
        j.g(str, "message");
        j.g(sVar, HeadersExtension.ELEMENT);
        this.f32858a = yVar;
        this.f32859b = protocol;
        this.f32860c = str;
        this.f32861d = i10;
        this.f32862e = handshake;
        this.f32863f = sVar;
        this.f32864g = b0Var;
        this.f32865h = a0Var;
        this.f32866j = a0Var2;
        this.f32867k = a0Var3;
        this.f32868l = j10;
        this.f32869m = j11;
        this.f32870n = cVar;
    }

    public static /* synthetic */ String m(a0 a0Var, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return a0Var.l(str, str2);
    }

    public final Protocol C() {
        return this.f32859b;
    }

    public final long E() {
        return this.f32869m;
    }

    public final y F() {
        return this.f32858a;
    }

    public final long G() {
        return this.f32868l;
    }

    public final b0 a() {
        return this.f32864g;
    }

    public final d b() {
        d dVar = this.f32871p;
        if (dVar != null) {
            return dVar;
        }
        d b10 = d.f32899n.b(this.f32863f);
        this.f32871p = b10;
        return b10;
    }

    public final a0 c() {
        return this.f32866j;
    }

    public void close() {
        b0 b0Var = this.f32864g;
        if (b0Var != null) {
            b0Var.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    public final List<g> e() {
        String str;
        s sVar = this.f32863f;
        int i10 = this.f32861d;
        if (i10 == 401) {
            str = "WWW-Authenticate";
        } else if (i10 != 407) {
            return q.j();
        } else {
            str = "Proxy-Authenticate";
        }
        return e.a(sVar, str);
    }

    public final int f() {
        return this.f32861d;
    }

    public final c g() {
        return this.f32870n;
    }

    public final Handshake h() {
        return this.f32862e;
    }

    public final boolean isSuccessful() {
        int i10 = this.f32861d;
        return 200 <= i10 && i10 < 300;
    }

    public final String k(String str) {
        j.g(str, "name");
        return m(this, str, (String) null, 2, (Object) null);
    }

    public final String l(String str, String str2) {
        j.g(str, "name");
        String b10 = this.f32863f.b(str);
        return b10 == null ? str2 : b10;
    }

    public final s n() {
        return this.f32863f;
    }

    public String toString() {
        return "Response{protocol=" + this.f32859b + ", code=" + this.f32861d + ", message=" + this.f32860c + ", url=" + this.f32858a.j() + '}';
    }

    public final String u() {
        return this.f32860c;
    }

    public final a0 v() {
        return this.f32865h;
    }

    public final a x() {
        return new a(this);
    }

    public final a0 y() {
        return this.f32867k;
    }

    @Metadata(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\"\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\bi\u0010jB\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bi\u0010XJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0012\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010!\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010#\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00002\u0006\u0010)\u001a\u00020&H\u0016J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\u0004H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0019\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001f\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b/\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b#\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\b\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010\u001b\u001a\u00020I8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010 \u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b;\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010\"\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bK\u0010T\u001a\u0004\bY\u0010V\"\u0004\bZ\u0010XR$\u0010$\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010T\u001a\u0004\b[\u0010V\"\u0004\b\\\u0010XR\"\u0010'\u001a\u00020&8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010)\u001a\u00020&8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010]\u001a\u0004\bb\u0010_\"\u0004\bc\u0010aR$\u0010h\u001a\u0004\u0018\u00010+8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b-\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010.¨\u0006k"}, d2 = {"Lokhttp3/a0$a;", "", "", "name", "Lokhttp3/a0;", "response", "", "f", "e", "Lokhttp3/y;", "request", "s", "Lokhttp3/Protocol;", "protocol", "q", "", "code", "g", "message", "n", "Lokhttp3/Handshake;", "handshake", "j", "value", "k", "a", "Lokhttp3/s;", "headers", "l", "Lokhttp3/b0;", "body", "b", "networkResponse", "o", "cacheResponse", "d", "priorResponse", "p", "", "sentRequestAtMillis", "t", "receivedResponseAtMillis", "r", "Lokhttp3/internal/connection/c;", "deferredTrailers", "m", "(Lokhttp3/internal/connection/c;)V", "c", "Lokhttp3/y;", "getRequest$okhttp", "()Lokhttp3/y;", "E", "(Lokhttp3/y;)V", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "C", "(Lokhttp3/Protocol;)V", "I", "h", "()I", "w", "(I)V", "Ljava/lang/String;", "getMessage$okhttp", "()Ljava/lang/String;", "z", "(Ljava/lang/String;)V", "Lokhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "x", "(Lokhttp3/Handshake;)V", "Lokhttp3/s$a;", "Lokhttp3/s$a;", "i", "()Lokhttp3/s$a;", "y", "(Lokhttp3/s$a;)V", "Lokhttp3/b0;", "getBody$okhttp", "()Lokhttp3/b0;", "u", "(Lokhttp3/b0;)V", "Lokhttp3/a0;", "getNetworkResponse$okhttp", "()Lokhttp3/a0;", "A", "(Lokhttp3/a0;)V", "getCacheResponse$okhttp", "v", "getPriorResponse$okhttp", "B", "J", "getSentRequestAtMillis$okhttp", "()J", "F", "(J)V", "getReceivedResponseAtMillis$okhttp", "D", "Lokhttp3/internal/connection/c;", "getExchange$okhttp", "()Lokhttp3/internal/connection/c;", "setExchange$okhttp", "exchange", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private y f32872a;

        /* renamed from: b  reason: collision with root package name */
        private Protocol f32873b;

        /* renamed from: c  reason: collision with root package name */
        private int f32874c;

        /* renamed from: d  reason: collision with root package name */
        private String f32875d;

        /* renamed from: e  reason: collision with root package name */
        private Handshake f32876e;

        /* renamed from: f  reason: collision with root package name */
        private s.a f32877f;

        /* renamed from: g  reason: collision with root package name */
        private b0 f32878g;

        /* renamed from: h  reason: collision with root package name */
        private a0 f32879h;

        /* renamed from: i  reason: collision with root package name */
        private a0 f32880i;

        /* renamed from: j  reason: collision with root package name */
        private a0 f32881j;

        /* renamed from: k  reason: collision with root package name */
        private long f32882k;

        /* renamed from: l  reason: collision with root package name */
        private long f32883l;

        /* renamed from: m  reason: collision with root package name */
        private c f32884m;

        public a() {
            this.f32874c = -1;
            this.f32877f = new s.a();
        }

        private final void e(a0 a0Var) {
            if (a0Var != null) {
                if (!(a0Var.a() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        private final void f(String str, a0 a0Var) {
            boolean z10;
            boolean z11;
            boolean z12;
            if (a0Var != null) {
                boolean z13 = true;
                if (a0Var.a() == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    if (a0Var.v() == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        if (a0Var.c() == null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            if (a0Var.y() != null) {
                                z13 = false;
                            }
                            if (!z13) {
                                throw new IllegalArgumentException(j.p(str, ".priorResponse != null").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException(j.p(str, ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException(j.p(str, ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException(j.p(str, ".body != null").toString());
            }
        }

        public final void A(a0 a0Var) {
            this.f32879h = a0Var;
        }

        public final void B(a0 a0Var) {
            this.f32881j = a0Var;
        }

        public final void C(Protocol protocol) {
            this.f32873b = protocol;
        }

        public final void D(long j10) {
            this.f32883l = j10;
        }

        public final void E(y yVar) {
            this.f32872a = yVar;
        }

        public final void F(long j10) {
            this.f32882k = j10;
        }

        public a a(String str, String str2) {
            j.g(str, "name");
            j.g(str2, "value");
            i().a(str, str2);
            return this;
        }

        public a b(b0 b0Var) {
            u(b0Var);
            return this;
        }

        public a0 c() {
            boolean z10;
            int i10 = this.f32874c;
            if (i10 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                y yVar = this.f32872a;
                if (yVar != null) {
                    Protocol protocol = this.f32873b;
                    if (protocol != null) {
                        String str = this.f32875d;
                        if (str != null) {
                            return new a0(yVar, protocol, str, i10, this.f32876e, this.f32877f.f(), this.f32878g, this.f32879h, this.f32880i, this.f32881j, this.f32882k, this.f32883l, this.f32884m);
                        }
                        throw new IllegalStateException("message == null".toString());
                    }
                    throw new IllegalStateException("protocol == null".toString());
                }
                throw new IllegalStateException("request == null".toString());
            }
            throw new IllegalStateException(j.p("code < 0: ", Integer.valueOf(h())).toString());
        }

        public a d(a0 a0Var) {
            f("cacheResponse", a0Var);
            v(a0Var);
            return this;
        }

        public a g(int i10) {
            w(i10);
            return this;
        }

        public final int h() {
            return this.f32874c;
        }

        public final s.a i() {
            return this.f32877f;
        }

        public a j(Handshake handshake) {
            x(handshake);
            return this;
        }

        public a k(String str, String str2) {
            j.g(str, "name");
            j.g(str2, "value");
            i().i(str, str2);
            return this;
        }

        public a l(s sVar) {
            j.g(sVar, HeadersExtension.ELEMENT);
            y(sVar.j());
            return this;
        }

        public final void m(c cVar) {
            j.g(cVar, "deferredTrailers");
            this.f32884m = cVar;
        }

        public a n(String str) {
            j.g(str, "message");
            z(str);
            return this;
        }

        public a o(a0 a0Var) {
            f("networkResponse", a0Var);
            A(a0Var);
            return this;
        }

        public a p(a0 a0Var) {
            e(a0Var);
            B(a0Var);
            return this;
        }

        public a q(Protocol protocol) {
            j.g(protocol, "protocol");
            C(protocol);
            return this;
        }

        public a r(long j10) {
            D(j10);
            return this;
        }

        public a s(y yVar) {
            j.g(yVar, "request");
            E(yVar);
            return this;
        }

        public a t(long j10) {
            F(j10);
            return this;
        }

        public final void u(b0 b0Var) {
            this.f32878g = b0Var;
        }

        public final void v(a0 a0Var) {
            this.f32880i = a0Var;
        }

        public final void w(int i10) {
            this.f32874c = i10;
        }

        public final void x(Handshake handshake) {
            this.f32876e = handshake;
        }

        public final void y(s.a aVar) {
            j.g(aVar, "<set-?>");
            this.f32877f = aVar;
        }

        public final void z(String str) {
            this.f32875d = str;
        }

        public a(a0 a0Var) {
            j.g(a0Var, "response");
            this.f32874c = -1;
            this.f32872a = a0Var.F();
            this.f32873b = a0Var.C();
            this.f32874c = a0Var.f();
            this.f32875d = a0Var.u();
            this.f32876e = a0Var.h();
            this.f32877f = a0Var.n().j();
            this.f32878g = a0Var.a();
            this.f32879h = a0Var.v();
            this.f32880i = a0Var.c();
            this.f32881j = a0Var.y();
            this.f32882k = a0Var.G();
            this.f32883l = a0Var.E();
            this.f32884m = a0Var.g();
        }
    }
}
