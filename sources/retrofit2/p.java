package retrofit2;

import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import java.util.regex.Pattern;
import okhttp3.r;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;
import okhttp3.y;
import okhttp3.z;
import okio.Buffer;
import okio.BufferedSink;

final class p {

    /* renamed from: l  reason: collision with root package name */
    private static final char[] f42363l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f42364m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a  reason: collision with root package name */
    private final String f42365a;

    /* renamed from: b  reason: collision with root package name */
    private final t f42366b;

    /* renamed from: c  reason: collision with root package name */
    private String f42367c;

    /* renamed from: d  reason: collision with root package name */
    private t.a f42368d;

    /* renamed from: e  reason: collision with root package name */
    private final y.a f42369e = new y.a();

    /* renamed from: f  reason: collision with root package name */
    private final s.a f42370f;

    /* renamed from: g  reason: collision with root package name */
    private v f42371g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f42372h;

    /* renamed from: i  reason: collision with root package name */
    private w.a f42373i;

    /* renamed from: j  reason: collision with root package name */
    private r.a f42374j;

    /* renamed from: k  reason: collision with root package name */
    private z f42375k;

    private static class a extends z {

        /* renamed from: b  reason: collision with root package name */
        private final z f42376b;

        /* renamed from: c  reason: collision with root package name */
        private final v f42377c;

        a(z zVar, v vVar) {
            this.f42376b = zVar;
            this.f42377c = vVar;
        }

        public long a() throws IOException {
            return this.f42376b.a();
        }

        public v b() {
            return this.f42377c;
        }

        public void i(BufferedSink bufferedSink) throws IOException {
            this.f42376b.i(bufferedSink);
        }
    }

    p(String str, t tVar, String str2, s sVar, v vVar, boolean z10, boolean z11, boolean z12) {
        this.f42365a = str;
        this.f42366b = tVar;
        this.f42367c = str2;
        this.f42371g = vVar;
        this.f42372h = z10;
        if (sVar != null) {
            this.f42370f = sVar.j();
        } else {
            this.f42370f = new s.a();
        }
        if (z11) {
            this.f42374j = new r.a();
        } else if (z12) {
            w.a aVar = new w.a();
            this.f42373i = aVar;
            aVar.e(w.f33202l);
        }
    }

    private static String i(String str, boolean z10) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z10 && (codePointAt == 47 || codePointAt == 37))) {
                Buffer buffer = new Buffer();
                buffer.n0(str, 0, i10);
                j(buffer, str, i10, length, z10);
                return buffer.G();
            }
            i10 += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void j(Buffer buffer, String str, int i10, int i11, boolean z10) {
        Buffer buffer2 = null;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (!z10 || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z10 && (codePointAt == 47 || codePointAt == 37))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.A0(codePointAt);
                    while (!buffer2.Y0()) {
                        byte readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        char[] cArr = f42363l;
                        buffer.writeByte(cArr[(readByte >> 4) & 15]);
                        buffer.writeByte(cArr[readByte & 15]);
                    }
                } else {
                    buffer.A0(codePointAt);
                }
            }
            i10 += Character.charCount(codePointAt);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, boolean z10) {
        if (z10) {
            this.f42374j.b(str, str2);
        } else {
            this.f42374j.a(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(String str, String str2) {
        if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str)) {
            try {
                this.f42371g = v.e(str2);
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e10);
            }
        } else {
            this.f42370f.a(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(s sVar) {
        this.f42370f.b(sVar);
    }

    /* access modifiers changed from: package-private */
    public void d(s sVar, z zVar) {
        this.f42373i.b(sVar, zVar);
    }

    /* access modifiers changed from: package-private */
    public void e(w.c cVar) {
        this.f42373i.c(cVar);
    }

    /* access modifiers changed from: package-private */
    public void f(String str, String str2, boolean z10) {
        if (this.f42367c != null) {
            String i10 = i(str2, z10);
            String str3 = this.f42367c;
            String replace = str3.replace("{" + str + "}", i10);
            if (!f42364m.matcher(replace).matches()) {
                this.f42367c = replace;
                return;
            }
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void g(String str, String str2, boolean z10) {
        String str3 = this.f42367c;
        if (str3 != null) {
            t.a l10 = this.f42366b.l(str3);
            this.f42368d = l10;
            if (l10 != null) {
                this.f42367c = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f42366b + ", Relative: " + this.f42367c);
            }
        }
        if (z10) {
            this.f42368d.a(str, str2);
        } else {
            this.f42368d.b(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public <T> void h(Class<T> cls, T t10) {
        this.f42369e.p(cls, t10);
    }

    /* access modifiers changed from: package-private */
    public y.a k() {
        t tVar;
        t.a aVar = this.f42368d;
        if (aVar != null) {
            tVar = aVar.c();
        } else {
            tVar = this.f42366b.r(this.f42367c);
            if (tVar == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f42366b + ", Relative: " + this.f42367c);
            }
        }
        a aVar2 = this.f42375k;
        if (aVar2 == null) {
            r.a aVar3 = this.f42374j;
            if (aVar3 != null) {
                aVar2 = aVar3.c();
            } else {
                w.a aVar4 = this.f42373i;
                if (aVar4 != null) {
                    aVar2 = aVar4.d();
                } else if (this.f42372h) {
                    aVar2 = z.f((v) null, new byte[0]);
                }
            }
        }
        v vVar = this.f42371g;
        if (vVar != null) {
            if (aVar2 != null) {
                aVar2 = new a(aVar2, vVar);
            } else {
                this.f42370f.a(HttpHeaders.CONTENT_TYPE, vVar.toString());
            }
        }
        return this.f42369e.r(tVar).g(this.f42370f.f()).h(this.f42365a, aVar2);
    }

    /* access modifiers changed from: package-private */
    public void l(z zVar) {
        this.f42375k = zVar;
    }

    /* access modifiers changed from: package-private */
    public void m(Object obj) {
        this.f42367c = obj.toString();
    }
}
