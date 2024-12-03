package okhttp3;

import bl.d;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.s;
import okhttp3.v;
import okhttp3.z;
import okio.BufferedSink;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0003\n\t\u0010B'\b\u0000\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0011\u0010#\u001a\u00020 8G¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lokhttp3/w;", "Lokhttp3/z;", "Lokio/BufferedSink;", "sink", "", "countBytes", "", "l", "Lokhttp3/v;", "b", "a", "", "i", "Lokio/ByteString;", "Lokio/ByteString;", "boundaryByteString", "c", "Lokhttp3/v;", "type", "()Lokhttp3/v;", "", "Lokhttp3/w$c;", "d", "Ljava/util/List;", "k", "()Ljava/util/List;", "parts", "e", "contentType", "f", "J", "contentLength", "", "j", "()Ljava/lang/String;", "boundary", "<init>", "(Lokio/ByteString;Lokhttp3/v;Ljava/util/List;)V", "g", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class w extends z {

    /* renamed from: g  reason: collision with root package name */
    public static final b f33197g = new b((DefaultConstructorMarker) null);

    /* renamed from: h  reason: collision with root package name */
    public static final v f33198h;

    /* renamed from: i  reason: collision with root package name */
    public static final v f33199i;

    /* renamed from: j  reason: collision with root package name */
    public static final v f33200j;

    /* renamed from: k  reason: collision with root package name */
    public static final v f33201k;

    /* renamed from: l  reason: collision with root package name */
    public static final v f33202l;

    /* renamed from: m  reason: collision with root package name */
    private static final byte[] f33203m = {58, 32};

    /* renamed from: n  reason: collision with root package name */
    private static final byte[] f33204n = {13, 10};

    /* renamed from: o  reason: collision with root package name */
    private static final byte[] f33205o = {Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX};

    /* renamed from: b  reason: collision with root package name */
    private final ByteString f33206b;

    /* renamed from: c  reason: collision with root package name */
    private final v f33207c;

    /* renamed from: d  reason: collision with root package name */
    private final List<c> f33208d;

    /* renamed from: e  reason: collision with root package name */
    private final v f33209e;

    /* renamed from: f  reason: collision with root package name */
    private long f33210f = -1;

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000b¨\u0006\u0017"}, d2 = {"Lokhttp3/w$b;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "key", "", "a", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "Lokhttp3/v;", "ALTERNATIVE", "Lokhttp3/v;", "", "COLONSPACE", "[B", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(StringBuilder sb2, String str) {
            j.g(sb2, "<this>");
            j.g(str, SDKConstants.PARAM_KEY);
            sb2.append('\"');
            int length = str.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                char charAt = str.charAt(i10);
                if (charAt == 10) {
                    sb2.append("%0A");
                } else if (charAt == 13) {
                    sb2.append("%0D");
                } else if (charAt == '\"') {
                    sb2.append("%22");
                } else {
                    sb2.append(charAt);
                }
                i10 = i11;
            }
            sb2.append('\"');
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0003B\u001b\b\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000b¨\u0006\u000f"}, d2 = {"Lokhttp3/w$c;", "", "Lokhttp3/s;", "a", "Lokhttp3/s;", "c", "()Lokhttp3/s;", "headers", "Lokhttp3/z;", "b", "Lokhttp3/z;", "()Lokhttp3/z;", "body", "<init>", "(Lokhttp3/s;Lokhttp3/z;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public static final a f33214c = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final s f33215a;

        /* renamed from: b  reason: collision with root package name */
        private final z f33216b;

        @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0010"}, d2 = {"Lokhttp3/w$c$a;", "", "Lokhttp3/s;", "headers", "Lokhttp3/z;", "body", "Lokhttp3/w$c;", "a", "", "name", "value", "b", "filename", "c", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final c a(s sVar, z zVar) {
                String str;
                boolean z10;
                String str2;
                j.g(zVar, "body");
                if (sVar == null) {
                    str = null;
                } else {
                    str = sVar.b(HttpHeaders.CONTENT_TYPE);
                }
                boolean z11 = true;
                if (str == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    if (sVar == null) {
                        str2 = null;
                    } else {
                        str2 = sVar.b(HttpHeaders.CONTENT_LENGTH);
                    }
                    if (str2 != null) {
                        z11 = false;
                    }
                    if (z11) {
                        return new c(sVar, zVar, (DefaultConstructorMarker) null);
                    }
                    throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
                }
                throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
            }

            public final c b(String str, String str2) {
                j.g(str, "name");
                j.g(str2, "value");
                return c(str, (String) null, z.a.j(z.f33274a, str2, (v) null, 1, (Object) null));
            }

            public final c c(String str, String str2, z zVar) {
                j.g(str, "name");
                j.g(zVar, "body");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("form-data; name=");
                b bVar = w.f33197g;
                bVar.a(sb2, str);
                if (str2 != null) {
                    sb2.append("; filename=");
                    bVar.a(sb2, str2);
                }
                String sb3 = sb2.toString();
                j.f(sb3, "StringBuilder().apply(builderAction).toString()");
                return a(new s.a().e("Content-Disposition", sb3).f(), zVar);
            }
        }

        private c(s sVar, z zVar) {
            this.f33215a = sVar;
            this.f33216b = zVar;
        }

        public /* synthetic */ c(s sVar, z zVar, DefaultConstructorMarker defaultConstructorMarker) {
            this(sVar, zVar);
        }

        public static final c b(String str, String str2, z zVar) {
            return f33214c.c(str, str2, zVar);
        }

        public final z a() {
            return this.f33216b;
        }

        public final s c() {
            return this.f33215a;
        }
    }

    static {
        v.a aVar = v.f33190e;
        f33198h = aVar.a("multipart/mixed");
        f33199i = aVar.a("multipart/alternative");
        f33200j = aVar.a("multipart/digest");
        f33201k = aVar.a("multipart/parallel");
        f33202l = aVar.a("multipart/form-data");
    }

    public w(ByteString byteString, v vVar, List<c> list) {
        j.g(byteString, "boundaryByteString");
        j.g(vVar, "type");
        j.g(list, "parts");
        this.f33206b = byteString;
        this.f33207c = vVar;
        this.f33208d = list;
        v.a aVar = v.f33190e;
        this.f33209e = aVar.a(vVar + "; boundary=" + j());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: okio.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long l(okio.BufferedSink r14, boolean r15) throws java.io.IOException {
        /*
            r13 = this;
            if (r15 == 0) goto L_0x0009
            okio.Buffer r14 = new okio.Buffer
            r14.<init>()
            r0 = r14
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<okhttp3.w$c> r1 = r13.f33208d
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r5 = r2
        L_0x0014:
            if (r5 >= r1) goto L_0x00b0
            int r6 = r5 + 1
            java.util.List<okhttp3.w$c> r7 = r13.f33208d
            java.lang.Object r5 = r7.get(r5)
            okhttp3.w$c r5 = (okhttp3.w.c) r5
            okhttp3.s r7 = r5.c()
            okhttp3.z r5 = r5.a()
            kotlin.jvm.internal.j.d(r14)
            byte[] r8 = f33205o
            r14.write(r8)
            okio.ByteString r8 = r13.f33206b
            r14.K1(r8)
            byte[] r8 = f33204n
            r14.write(r8)
            if (r7 == 0) goto L_0x0062
            int r8 = r7.size()
            r9 = r2
        L_0x0041:
            if (r9 >= r8) goto L_0x0062
            int r10 = r9 + 1
            java.lang.String r11 = r7.f(r9)
            okio.BufferedSink r11 = r14.h0(r11)
            byte[] r12 = f33203m
            okio.BufferedSink r11 = r11.write(r12)
            java.lang.String r9 = r7.n(r9)
            okio.BufferedSink r9 = r11.h0(r9)
            byte[] r11 = f33204n
            r9.write(r11)
            r9 = r10
            goto L_0x0041
        L_0x0062:
            okhttp3.v r7 = r5.b()
            if (r7 == 0) goto L_0x007b
            java.lang.String r8 = "Content-Type: "
            okio.BufferedSink r8 = r14.h0(r8)
            java.lang.String r7 = r7.toString()
            okio.BufferedSink r7 = r8.h0(r7)
            byte[] r8 = f33204n
            r7.write(r8)
        L_0x007b:
            long r7 = r5.a()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0095
            java.lang.String r9 = "Content-Length: "
            okio.BufferedSink r9 = r14.h0(r9)
            okio.BufferedSink r9 = r9.J0(r7)
            byte[] r10 = f33204n
            r9.write(r10)
            goto L_0x009e
        L_0x0095:
            if (r15 == 0) goto L_0x009e
            kotlin.jvm.internal.j.d(r0)
            r0.a()
            return r9
        L_0x009e:
            byte[] r9 = f33204n
            r14.write(r9)
            if (r15 == 0) goto L_0x00a7
            long r3 = r3 + r7
            goto L_0x00aa
        L_0x00a7:
            r5.i(r14)
        L_0x00aa:
            r14.write(r9)
            r5 = r6
            goto L_0x0014
        L_0x00b0:
            kotlin.jvm.internal.j.d(r14)
            byte[] r1 = f33205o
            r14.write(r1)
            okio.ByteString r2 = r13.f33206b
            r14.K1(r2)
            r14.write(r1)
            byte[] r1 = f33204n
            r14.write(r1)
            if (r15 == 0) goto L_0x00d2
            kotlin.jvm.internal.j.d(r0)
            long r14 = r0.size()
            long r3 = r3 + r14
            r0.a()
        L_0x00d2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.w.l(okio.BufferedSink, boolean):long");
    }

    public long a() throws IOException {
        long j10 = this.f33210f;
        if (j10 != -1) {
            return j10;
        }
        long l10 = l((BufferedSink) null, true);
        this.f33210f = l10;
        return l10;
    }

    public v b() {
        return this.f33209e;
    }

    public void i(BufferedSink bufferedSink) throws IOException {
        j.g(bufferedSink, "sink");
        l(bufferedSink, false);
    }

    public final String j() {
        return this.f33206b.Q();
    }

    public final List<c> k() {
        return this.f33208d;
    }

    @Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018¨\u0006\u001c"}, d2 = {"Lokhttp3/w$a;", "", "Lokhttp3/v;", "type", "e", "Lokhttp3/s;", "headers", "Lokhttp3/z;", "body", "b", "", "name", "value", "a", "Lokhttp3/w$c;", "part", "c", "Lokhttp3/w;", "d", "Lokio/ByteString;", "Lokio/ByteString;", "boundary", "Lokhttp3/v;", "", "Ljava/util/List;", "parts", "<init>", "(Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ByteString f33211a;

        /* renamed from: b  reason: collision with root package name */
        private v f33212b;

        /* renamed from: c  reason: collision with root package name */
        private final List<c> f33213c;

        public a() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public a(String str) {
            j.g(str, "boundary");
            this.f33211a = ByteString.f33308c.c(str);
            this.f33212b = w.f33198h;
            this.f33213c = new ArrayList();
        }

        public final a a(String str, String str2) {
            j.g(str, "name");
            j.g(str2, "value");
            c(c.f33214c.b(str, str2));
            return this;
        }

        public final a b(s sVar, z zVar) {
            j.g(zVar, "body");
            c(c.f33214c.a(sVar, zVar));
            return this;
        }

        public final a c(c cVar) {
            j.g(cVar, "part");
            this.f33213c.add(cVar);
            return this;
        }

        public final w d() {
            if (!this.f33213c.isEmpty()) {
                return new w(this.f33211a, this.f33212b, d.S(this.f33213c));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        public final a e(v vVar) {
            j.g(vVar, "type");
            if (j.b(vVar.i(), "multipart")) {
                this.f33212b = vVar;
                return this;
            }
            throw new IllegalArgumentException(j.p("multipart != ", vVar).toString());
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ a(java.lang.String r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
            /*
                r0 = this;
                r2 = r2 & 1
                if (r2 == 0) goto L_0x0011
                java.util.UUID r1 = java.util.UUID.randomUUID()
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "randomUUID().toString()"
                kotlin.jvm.internal.j.f(r1, r2)
            L_0x0011:
                r0.<init>(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.w.a.<init>(java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
