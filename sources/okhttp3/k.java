package okhttp3;

import bl.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0002\u0012\u0017B9\b\u0000\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001a\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001a¢\u0006\u0004\b&\u0010'J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u0013\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0017\u0010\u0016\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001bR\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0019\u0010\"\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010!R\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001f8G¢\u0006\u0006\u001a\u0004\b$\u0010!¨\u0006("}, d2 = {"Lokhttp3/k;", "", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "isFallback", "g", "", "c", "(Ljavax/net/ssl/SSLSocket;Z)V", "socket", "e", "other", "equals", "", "hashCode", "", "toString", "a", "Z", "f", "()Z", "isTls", "b", "h", "supportsTlsExtensions", "", "[Ljava/lang/String;", "cipherSuitesAsString", "d", "tlsVersionsAsString", "", "Lokhttp3/h;", "()Ljava/util/List;", "cipherSuites", "Lokhttp3/TlsVersion;", "i", "tlsVersions", "<init>", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class k {

    /* renamed from: e  reason: collision with root package name */
    public static final b f33114e = new b((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private static final h[] f33115f;

    /* renamed from: g  reason: collision with root package name */
    private static final h[] f33116g;

    /* renamed from: h  reason: collision with root package name */
    public static final k f33117h;

    /* renamed from: i  reason: collision with root package name */
    public static final k f33118i;

    /* renamed from: j  reason: collision with root package name */
    public static final k f33119j;

    /* renamed from: k  reason: collision with root package name */
    public static final k f33120k = new a(false).a();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f33121a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f33122b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String[] f33123c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String[] f33124d;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lokhttp3/k$b;", "", "", "Lokhttp3/h;", "APPROVED_CIPHER_SUITES", "[Lokhttp3/h;", "Lokhttp3/k;", "CLEARTEXT", "Lokhttp3/k;", "COMPATIBLE_TLS", "MODERN_TLS", "RESTRICTED_CIPHER_SUITES", "RESTRICTED_TLS", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        h hVar = h.f32968o1;
        h hVar2 = h.f32971p1;
        h hVar3 = h.f32974q1;
        h hVar4 = h.f32926a1;
        h hVar5 = h.f32938e1;
        h hVar6 = h.f32929b1;
        h hVar7 = h.f32941f1;
        h hVar8 = h.f32959l1;
        h hVar9 = h.f32956k1;
        h[] hVarArr = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9};
        f33115f = hVarArr;
        h[] hVarArr2 = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, h.L0, h.M0, h.f32952j0, h.f32955k0, h.H, h.L, h.f32957l};
        f33116g = hVarArr2;
        a c10 = new a(true).c((h[]) Arrays.copyOf(hVarArr, hVarArr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        f33117h = c10.j(tlsVersion, tlsVersion2).h(true).a();
        f33118i = new a(true).c((h[]) Arrays.copyOf(hVarArr2, hVarArr2.length)).j(tlsVersion, tlsVersion2).h(true).a();
        f33119j = new a(true).c((h[]) Arrays.copyOf(hVarArr2, hVarArr2.length)).j(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).h(true).a();
    }

    public k(boolean z10, boolean z11, String[] strArr, String[] strArr2) {
        this.f33121a = z10;
        this.f33122b = z11;
        this.f33123c = strArr;
        this.f33124d = strArr2;
    }

    private final k g(SSLSocket sSLSocket, boolean z10) {
        String[] strArr;
        String[] strArr2;
        if (this.f33123c != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            j.f(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            strArr = d.E(enabledCipherSuites, this.f33123c, h.f32927b.c());
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f33124d != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            j.f(enabledProtocols, "sslSocket.enabledProtocols");
            strArr2 = d.E(enabledProtocols, this.f33124d, b.b());
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        j.f(supportedCipherSuites, "supportedCipherSuites");
        int x10 = d.x(supportedCipherSuites, "TLS_FALLBACK_SCSV", h.f32927b.c());
        if (z10 && x10 != -1) {
            j.f(strArr, "cipherSuitesIntersection");
            String str = supportedCipherSuites[x10];
            j.f(str, "supportedCipherSuites[indexOfFallbackScsv]");
            strArr = d.o(strArr, str);
        }
        a aVar = new a(this);
        j.f(strArr, "cipherSuitesIntersection");
        a b10 = aVar.b((String[]) Arrays.copyOf(strArr, strArr.length));
        j.f(strArr2, "tlsVersionsIntersection");
        return b10.i((String[]) Arrays.copyOf(strArr2, strArr2.length)).a();
    }

    public final void c(SSLSocket sSLSocket, boolean z10) {
        j.g(sSLSocket, "sslSocket");
        k g10 = g(sSLSocket, z10);
        if (g10.i() != null) {
            sSLSocket.setEnabledProtocols(g10.f33124d);
        }
        if (g10.d() != null) {
            sSLSocket.setEnabledCipherSuites(g10.f33123c);
        }
    }

    public final List<h> d() {
        String[] strArr = this.f33123c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String b10 : strArr) {
            arrayList.add(h.f32927b.b(b10));
        }
        return CollectionsKt___CollectionsKt.x0(arrayList);
    }

    public final boolean e(SSLSocket sSLSocket) {
        j.g(sSLSocket, "socket");
        if (!this.f33121a) {
            return false;
        }
        String[] strArr = this.f33124d;
        if (strArr != null && !d.u(strArr, sSLSocket.getEnabledProtocols(), b.b())) {
            return false;
        }
        String[] strArr2 = this.f33123c;
        if (strArr2 == null || d.u(strArr2, sSLSocket.getEnabledCipherSuites(), h.f32927b.c())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z10 = this.f33121a;
        k kVar = (k) obj;
        if (z10 != kVar.f33121a) {
            return false;
        }
        if (!z10 || (Arrays.equals(this.f33123c, kVar.f33123c) && Arrays.equals(this.f33124d, kVar.f33124d) && this.f33122b == kVar.f33122b)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return this.f33121a;
    }

    public final boolean h() {
        return this.f33122b;
    }

    public int hashCode() {
        int i10;
        if (!this.f33121a) {
            return 17;
        }
        String[] strArr = this.f33123c;
        int i11 = 0;
        if (strArr == null) {
            i10 = 0;
        } else {
            i10 = Arrays.hashCode(strArr);
        }
        int i12 = (527 + i10) * 31;
        String[] strArr2 = this.f33124d;
        if (strArr2 != null) {
            i11 = Arrays.hashCode(strArr2);
        }
        return ((i12 + i11) * 31) + (this.f33122b ^ true ? 1 : 0);
    }

    public final List<TlsVersion> i() {
        String[] strArr = this.f33124d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a10 : strArr) {
            arrayList.add(TlsVersion.f32840a.a(a10));
        }
        return CollectionsKt___CollectionsKt.x0(arrayList);
    }

    public String toString() {
        if (!this.f33121a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(d(), "[all enabled]") + ", tlsVersions=" + Objects.toString(i(), "[all enabled]") + ", supportsTlsExtensions=" + this.f33122b + PropertyUtils.MAPPED_DELIM2;
    }

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b#\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020\u0012¢\u0006\u0004\b#\u0010%J!\u0010\u0005\u001a\u00020\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\b\u001a\u00020\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002\"\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0002\"\u00020\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002\"\u00020\u0007¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0006\u0010\u0013\u001a\u00020\u0012R\"\u0010\u0019\u001a\u00020\u000f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\"\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018¨\u0006&"}, d2 = {"Lokhttp3/k$a;", "", "", "Lokhttp3/h;", "cipherSuites", "c", "([Lokhttp3/h;)Lokhttp3/k$a;", "", "b", "([Ljava/lang/String;)Lokhttp3/k$a;", "Lokhttp3/TlsVersion;", "tlsVersions", "j", "([Lokhttp3/TlsVersion;)Lokhttp3/k$a;", "i", "", "supportsTlsExtensions", "h", "Lokhttp3/k;", "a", "Z", "d", "()Z", "setTls$okhttp", "(Z)V", "tls", "[Ljava/lang/String;", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "e", "([Ljava/lang/String;)V", "getTlsVersions$okhttp", "g", "getSupportsTlsExtensions$okhttp", "f", "<init>", "connectionSpec", "(Lokhttp3/k;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f33125a;

        /* renamed from: b  reason: collision with root package name */
        private String[] f33126b;

        /* renamed from: c  reason: collision with root package name */
        private String[] f33127c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f33128d;

        public a(boolean z10) {
            this.f33125a = z10;
        }

        public final k a() {
            return new k(this.f33125a, this.f33128d, this.f33126b, this.f33127c);
        }

        public final a b(String... strArr) {
            boolean z10;
            j.g(strArr, "cipherSuites");
            if (d()) {
                if (strArr.length == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    e((String[]) strArr.clone());
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final a c(h... hVarArr) {
            j.g(hVarArr, "cipherSuites");
            if (d()) {
                ArrayList arrayList = new ArrayList(hVarArr.length);
                for (h c10 : hVarArr) {
                    arrayList.add(c10.c());
                }
                Object[] array2 = arrayList.toArray(new String[0]);
                if (array2 != null) {
                    String[] strArr = (String[]) array2;
                    return b((String[]) Arrays.copyOf(strArr, strArr.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final boolean d() {
            return this.f33125a;
        }

        public final void e(String[] strArr) {
            this.f33126b = strArr;
        }

        public final void f(boolean z10) {
            this.f33128d = z10;
        }

        public final void g(String[] strArr) {
            this.f33127c = strArr;
        }

        public final a h(boolean z10) {
            if (d()) {
                f(z10);
                return this;
            }
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }

        public final a i(String... strArr) {
            boolean z10;
            j.g(strArr, "tlsVersions");
            if (d()) {
                if (strArr.length == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    g((String[]) strArr.clone());
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public final a j(TlsVersion... tlsVersionArr) {
            j.g(tlsVersionArr, "tlsVersions");
            if (d()) {
                ArrayList arrayList = new ArrayList(tlsVersionArr.length);
                for (TlsVersion b10 : tlsVersionArr) {
                    arrayList.add(b10.b());
                }
                Object[] array2 = arrayList.toArray(new String[0]);
                if (array2 != null) {
                    String[] strArr = (String[]) array2;
                    return i((String[]) Arrays.copyOf(strArr, strArr.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public a(k kVar) {
            j.g(kVar, "connectionSpec");
            this.f33125a = kVar.f();
            this.f33126b = kVar.f33123c;
            this.f33127c = kVar.f33124d;
            this.f33128d = kVar.h();
        }
    }
}
