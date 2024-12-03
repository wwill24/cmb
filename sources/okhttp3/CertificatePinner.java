package okhttp3;

import com.facebook.internal.security.CertificateUtil;
import com.leanplum.internal.Constants;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0003\b\f\u000fB#\b\u0000\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b!\u0010\"J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J+\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\tH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lokhttp3/CertificatePinner;", "", "", "hostname", "", "Ljava/security/cert/Certificate;", "peerCertificates", "", "a", "Lkotlin/Function0;", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", "b", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lokhttp3/CertificatePinner$c;", "c", "Lll/c;", "certificateChainCleaner", "e", "(Lll/c;)Lokhttp3/CertificatePinner;", "other", "", "equals", "", "hashCode", "", "Ljava/util/Set;", "getPins", "()Ljava/util/Set;", "pins", "Lll/c;", "d", "()Lll/c;", "<init>", "(Ljava/util/Set;Lll/c;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class CertificatePinner {

    /* renamed from: c  reason: collision with root package name */
    public static final b f32819c = new b((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    public static final CertificatePinner f32820d = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final Set<c> f32821a;

    /* renamed from: b  reason: collision with root package name */
    private final ll.c f32822b;

    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lokhttp3/CertificatePinner$a;", "", "Lokhttp3/CertificatePinner;", "a", "", "Lokhttp3/CertificatePinner$c;", "Ljava/util/List;", "getPins", "()Ljava/util/List;", "pins", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<c> f32823a = new ArrayList();

        public final CertificatePinner a() {
            return new CertificatePinner(CollectionsKt___CollectionsKt.B0(this.f32823a), (ll.c) null, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lokhttp3/CertificatePinner$b;", "", "Ljava/security/cert/X509Certificate;", "Lokio/ByteString;", "b", "c", "Ljava/security/cert/Certificate;", "certificate", "", "a", "Lokhttp3/CertificatePinner;", "DEFAULT", "Lokhttp3/CertificatePinner;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Certificate certificate) {
            j.g(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return j.p("sha256/", c((X509Certificate) certificate).a());
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        public final ByteString b(X509Certificate x509Certificate) {
            j.g(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.f33308c;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            j.f(encoded, "publicKey.encoded");
            return ByteString.Companion.e(companion, encoded, 0, 0, 3, (Object) null).D();
        }

        public final ByteString c(X509Certificate x509Certificate) {
            j.g(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.f33308c;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            j.f(encoded, "publicKey.encoded");
            return ByteString.Companion.e(companion, encoded, 0, 0, 3, (Object) null).G();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0013\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014¨\u0006\u0016"}, d2 = {"Lokhttp3/CertificatePinner$c;", "", "", "hostname", "", "c", "toString", "other", "equals", "", "hashCode", "a", "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "pattern", "b", "hashAlgorithm", "Lokio/ByteString;", "Lokio/ByteString;", "()Lokio/ByteString;", "hash", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f32824a;

        /* renamed from: b  reason: collision with root package name */
        private final String f32825b;

        /* renamed from: c  reason: collision with root package name */
        private final ByteString f32826c;

        public final ByteString a() {
            return this.f32826c;
        }

        public final String b() {
            return this.f32825b;
        }

        public final boolean c(String str) {
            j.g(str, "hostname");
            if (r.J(this.f32824a, "**.", false, 2, (Object) null)) {
                int length = this.f32824a.length() - 3;
                int length2 = str.length() - length;
                if (!r.y(str, str.length() - length, this.f32824a, 3, length, false, 16, (Object) null)) {
                    return false;
                }
                if (!(length2 == 0 || str.charAt(length2 - 1) == '.')) {
                    return false;
                }
            } else if (!r.J(this.f32824a, "*.", false, 2, (Object) null)) {
                return j.b(str, this.f32824a);
            } else {
                int length3 = this.f32824a.length() - 1;
                int length4 = str.length() - length3;
                if (!r.y(str, str.length() - length3, this.f32824a, 1, length3, false, 16, (Object) null)) {
                    return false;
                }
                if (StringsKt__StringsKt.f0(str, '.', length4 - 1, false, 4, (Object) null) != -1) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (j.b(this.f32824a, cVar.f32824a) && j.b(this.f32825b, cVar.f32825b) && j.b(this.f32826c, cVar.f32826c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f32824a.hashCode() * 31) + this.f32825b.hashCode()) * 31) + this.f32826c.hashCode();
        }

        public String toString() {
            return this.f32825b + '/' + this.f32826c.a();
        }
    }

    public CertificatePinner(Set<c> set, ll.c cVar) {
        j.g(set, "pins");
        this.f32821a = set;
        this.f32822b = cVar;
    }

    public final void a(String str, List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        j.g(str, "hostname");
        j.g(list, "peerCertificates");
        b(str, new CertificatePinner$check$1(this, list, str));
    }

    public final void b(String str, Function0<? extends List<? extends X509Certificate>> function0) {
        j.g(str, "hostname");
        j.g(function0, "cleanedPeerCertificatesFn");
        List<c> c10 = c(str);
        if (!c10.isEmpty()) {
            List<X509Certificate> list = (List) function0.invoke();
            for (X509Certificate x509Certificate : list) {
                Iterator<c> it = c10.iterator();
                ByteString byteString = null;
                ByteString byteString2 = null;
                while (true) {
                    if (it.hasNext()) {
                        c next = it.next();
                        String b10 = next.b();
                        if (j.b(b10, Constants.Params.MIGRATE_STATE_HASH)) {
                            if (byteString == null) {
                                byteString = f32819c.c(x509Certificate);
                            }
                            if (j.b(next.a(), byteString)) {
                                return;
                            }
                        } else if (j.b(b10, "sha1")) {
                            if (byteString2 == null) {
                                byteString2 = f32819c.b(x509Certificate);
                            }
                            if (j.b(next.a(), byteString2)) {
                                return;
                            }
                        } else {
                            throw new AssertionError(j.p("unsupported hashAlgorithm: ", next.b()));
                        }
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Certificate pinning failure!");
            sb2.append("\n  Peer certificate chain:");
            for (X509Certificate x509Certificate2 : list) {
                sb2.append("\n    ");
                sb2.append(f32819c.a(x509Certificate2));
                sb2.append(": ");
                sb2.append(x509Certificate2.getSubjectDN().getName());
            }
            sb2.append("\n  Pinned certificates for ");
            sb2.append(str);
            sb2.append(CertificateUtil.DELIMITER);
            for (c append : c10) {
                sb2.append("\n    ");
                sb2.append(append);
            }
            String sb3 = sb2.toString();
            j.f(sb3, "StringBuilder().apply(builderAction).toString()");
            throw new SSLPeerUnverifiedException(sb3);
        }
    }

    public final List<c> c(String str) {
        j.g(str, "hostname");
        Set<c> set = this.f32821a;
        List<c> j10 = q.j();
        for (T next : set) {
            if (((c) next).c(str)) {
                if (j10.isEmpty()) {
                    j10 = new ArrayList<>();
                }
                p.b(j10).add(next);
            }
        }
        return j10;
    }

    public final ll.c d() {
        return this.f32822b;
    }

    public final CertificatePinner e(ll.c cVar) {
        j.g(cVar, "certificateChainCleaner");
        if (j.b(this.f32822b, cVar)) {
            return this;
        }
        return new CertificatePinner(this.f32821a, cVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (!j.b(certificatePinner.f32821a, this.f32821a) || !j.b(certificatePinner.f32822b, this.f32822b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = (1517 + this.f32821a.hashCode()) * 41;
        ll.c cVar = this.f32822b;
        if (cVar != null) {
            i10 = cVar.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CertificatePinner(Set set, ll.c cVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i10 & 2) != 0 ? null : cVar);
    }
}
