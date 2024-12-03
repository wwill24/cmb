package hl;

import com.facebook.internal.security.CertificateUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013B\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0014B\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lhl/a;", "", "", "toString", "Lokio/ByteString;", "a", "b", "", "hashCode", "other", "", "equals", "Lokio/ByteString;", "name", "value", "c", "I", "hpackSize", "<init>", "(Lokio/ByteString;Lokio/ByteString;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "(Lokio/ByteString;Ljava/lang/String;)V", "d", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0345a f29750d = new C0345a((DefaultConstructorMarker) null);

    /* renamed from: e  reason: collision with root package name */
    public static final ByteString f29751e;

    /* renamed from: f  reason: collision with root package name */
    public static final ByteString f29752f;

    /* renamed from: g  reason: collision with root package name */
    public static final ByteString f29753g;

    /* renamed from: h  reason: collision with root package name */
    public static final ByteString f29754h;

    /* renamed from: i  reason: collision with root package name */
    public static final ByteString f29755i;

    /* renamed from: j  reason: collision with root package name */
    public static final ByteString f29756j;

    /* renamed from: a  reason: collision with root package name */
    public final ByteString f29757a;

    /* renamed from: b  reason: collision with root package name */
    public final ByteString f29758b;

    /* renamed from: c  reason: collision with root package name */
    public final int f29759c;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\b¨\u0006\u0013"}, d2 = {"Lhl/a$a;", "", "Lokio/ByteString;", "PSEUDO_PREFIX", "Lokio/ByteString;", "RESPONSE_STATUS", "", "RESPONSE_STATUS_UTF8", "Ljava/lang/String;", "TARGET_AUTHORITY", "TARGET_AUTHORITY_UTF8", "TARGET_METHOD", "TARGET_METHOD_UTF8", "TARGET_PATH", "TARGET_PATH_UTF8", "TARGET_SCHEME", "TARGET_SCHEME_UTF8", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    /* renamed from: hl.a$a  reason: collision with other inner class name */
    public static final class C0345a {
        private C0345a() {
        }

        public /* synthetic */ C0345a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ByteString.Companion companion = ByteString.f33308c;
        f29751e = companion.c(CertificateUtil.DELIMITER);
        f29752f = companion.c(":status");
        f29753g = companion.c(":method");
        f29754h = companion.c(":path");
        f29755i = companion.c(":scheme");
        f29756j = companion.c(":authority");
    }

    public a(ByteString byteString, ByteString byteString2) {
        j.g(byteString, "name");
        j.g(byteString2, "value");
        this.f29757a = byteString;
        this.f29758b = byteString2;
        this.f29759c = byteString.H() + 32 + byteString2.H();
    }

    public final ByteString a() {
        return this.f29757a;
    }

    public final ByteString b() {
        return this.f29758b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.b(this.f29757a, aVar.f29757a) && j.b(this.f29758b, aVar.f29758b);
    }

    public int hashCode() {
        return (this.f29757a.hashCode() * 31) + this.f29758b.hashCode();
    }

    public String toString() {
        return this.f29757a.Q() + ": " + this.f29758b.Q();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.j.g(r2, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.j.g(r3, r0)
            okio.ByteString$Companion r0 = okio.ByteString.f33308c
            okio.ByteString r2 = r0.c(r2)
            okio.ByteString r3 = r0.c(r3)
            r1.<init>((okio.ByteString) r2, (okio.ByteString) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hl.a.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(ByteString byteString, String str) {
        this(byteString, ByteString.f33308c.c(str));
        j.g(byteString, "name");
        j.g(str, "value");
    }
}
