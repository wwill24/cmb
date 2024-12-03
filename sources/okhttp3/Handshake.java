package okhttp3;

import bl.d;
import gk.f;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001#B;\b\u0000\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u001f¢\u0006\u0004\b!\u0010\"J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148GX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001e\u001a\u00020\u0007*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u001d¨\u0006$"}, d2 = {"Lokhttp3/Handshake;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lokhttp3/TlsVersion;", "a", "Lokhttp3/TlsVersion;", "e", "()Lokhttp3/TlsVersion;", "tlsVersion", "Lokhttp3/h;", "b", "Lokhttp3/h;", "()Lokhttp3/h;", "cipherSuite", "", "Ljava/security/cert/Certificate;", "c", "Ljava/util/List;", "()Ljava/util/List;", "localCertificates", "d", "Lgk/f;", "peerCertificates", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "name", "Lkotlin/Function0;", "peerCertificatesFn", "<init>", "(Lokhttp3/TlsVersion;Lokhttp3/h;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class Handshake {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f32827e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final TlsVersion f32828a;

    /* renamed from: b  reason: collision with root package name */
    private final h f32829b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f32830c;

    /* renamed from: d  reason: collision with root package name */
    private final f f32831d;

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004*\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lokhttp3/Handshake$Companion;", "", "", "Ljava/security/cert/Certificate;", "", "b", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "Ljavax/net/ssl/SSLSession;", "Lokhttp3/Handshake;", "a", "(Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<Certificate> b(Certificate[] certificateArr) {
            if (certificateArr != null) {
                return d.w(Arrays.copyOf(certificateArr, certificateArr.length));
            }
            return q.j();
        }

        public final Handshake a(SSLSession sSLSession) throws IOException {
            boolean z10;
            List<Certificate> list;
            j.g(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite != null) {
                if (j.b(cipherSuite, "TLS_NULL_WITH_NULL_NULL")) {
                    z10 = true;
                } else {
                    z10 = j.b(cipherSuite, "SSL_NULL_WITH_NULL_NULL");
                }
                if (!z10) {
                    h b10 = h.f32927b.b(cipherSuite);
                    String protocol = sSLSession.getProtocol();
                    if (protocol == null) {
                        throw new IllegalStateException("tlsVersion == null".toString());
                    } else if (!j.b("NONE", protocol)) {
                        TlsVersion a10 = TlsVersion.f32840a.a(protocol);
                        try {
                            list = b(sSLSession.getPeerCertificates());
                        } catch (SSLPeerUnverifiedException unused) {
                            list = q.j();
                        }
                        return new Handshake(a10, b10, b(sSLSession.getLocalCertificates()), new Handshake$Companion$handshake$1(list));
                    } else {
                        throw new IOException("tlsVersion == NONE");
                    }
                } else {
                    throw new IOException(j.p("cipherSuite == ", cipherSuite));
                }
            } else {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
        }
    }

    public Handshake(TlsVersion tlsVersion, h hVar, List<? extends Certificate> list, Function0<? extends List<? extends Certificate>> function0) {
        j.g(tlsVersion, "tlsVersion");
        j.g(hVar, "cipherSuite");
        j.g(list, "localCertificates");
        j.g(function0, "peerCertificatesFn");
        this.f32828a = tlsVersion;
        this.f32829b = hVar;
        this.f32830c = list;
        this.f32831d = b.b(new Handshake$peerCertificates$2(function0));
    }

    private final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        j.f(type, "type");
        return type;
    }

    public final h a() {
        return this.f32829b;
    }

    public final List<Certificate> c() {
        return this.f32830c;
    }

    public final List<Certificate> d() {
        return (List) this.f32831d.getValue();
    }

    public final TlsVersion e() {
        return this.f32828a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.f32828a != this.f32828a || !j.b(handshake.f32829b, this.f32829b) || !j.b(handshake.d(), d()) || !j.b(handshake.f32830c, this.f32830c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f32828a.hashCode()) * 31) + this.f32829b.hashCode()) * 31) + d().hashCode()) * 31) + this.f32830c.hashCode();
    }

    public String toString() {
        List<Certificate> d10 = d();
        ArrayList arrayList = new ArrayList(r.t(d10, 10));
        for (Certificate b10 : d10) {
            arrayList.add(b(b10));
        }
        String obj = arrayList.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Handshake{tlsVersion=");
        sb2.append(this.f32828a);
        sb2.append(" cipherSuite=");
        sb2.append(this.f32829b);
        sb2.append(" peerCertificates=");
        sb2.append(obj);
        sb2.append(" localCertificates=");
        List<Certificate> list = this.f32830c;
        ArrayList arrayList2 = new ArrayList(r.t(list, 10));
        for (Certificate b11 : list) {
            arrayList2.add(b(b11));
        }
        sb2.append(arrayList2);
        sb2.append('}');
        return sb2.toString();
    }
}
