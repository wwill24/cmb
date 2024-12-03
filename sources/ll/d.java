package ll;

import bl.a;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.pool.TypePool;
import okio.Utf8;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u000b\u001a\u00020\u0006*\u00020\u0002H\u0002J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u001a"}, d2 = {"Lll/d;", "Ljavax/net/ssl/HostnameVerifier;", "", "ipAddress", "Ljava/security/cert/X509Certificate;", "certificate", "", "h", "hostname", "g", "b", "d", "pattern", "f", "", "type", "", "c", "host", "Ljavax/net/ssl/SSLSession;", "session", "verify", "e", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final d f32787a = new d();

    private d() {
    }

    private final String b(String str) {
        if (!d(str)) {
            return str;
        }
        Locale locale = Locale.US;
        j.f(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        j.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List<String> c(X509Certificate x509Certificate, int i10) {
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return q.j();
            }
            ArrayList arrayList = new ArrayList();
            for (List next : subjectAlternativeNames) {
                if (next != null) {
                    if (next.size() >= 2) {
                        if (j.b(next.get(0), Integer.valueOf(i10))) {
                            Object obj = next.get(1);
                            if (obj != null) {
                                arrayList.add((String) obj);
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return q.j();
        }
    }

    private final boolean d(String str) {
        return str.length() == ((int) Utf8.b(str, 0, 0, 3, (Object) null));
    }

    private final boolean f(String str, String str2) {
        boolean z10;
        boolean z11;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && !r.J(str, ".", false, 2, (Object) null) && !r.s(str, "..", false, 2, (Object) null)) {
            if (str2 == null || str2.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && !r.J(str2, ".", false, 2, (Object) null) && !r.s(str2, "..", false, 2, (Object) null)) {
                if (!r.s(str, ".", false, 2, (Object) null)) {
                    str = j.p(str, ".");
                }
                String str3 = str;
                if (!r.s(str2, ".", false, 2, (Object) null)) {
                    str2 = j.p(str2, ".");
                }
                String b10 = b(str2);
                if (!StringsKt__StringsKt.O(b10, "*", false, 2, (Object) null)) {
                    return j.b(str3, b10);
                }
                if (!r.J(b10, "*.", false, 2, (Object) null) || StringsKt__StringsKt.a0(b10, TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH, 1, false, 4, (Object) null) != -1 || str3.length() < b10.length() || j.b("*.", b10)) {
                    return false;
                }
                String substring = b10.substring(1);
                j.f(substring, "this as java.lang.String).substring(startIndex)");
                if (!r.s(str3, substring, false, 2, (Object) null)) {
                    return false;
                }
                int length = str3.length() - substring.length();
                if (length <= 0 || StringsKt__StringsKt.f0(str3, '.', length - 1, false, 4, (Object) null) == -1) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private final boolean g(String str, X509Certificate x509Certificate) {
        String b10 = b(str);
        List<String> c10 = c(x509Certificate, 2);
        if ((c10 instanceof Collection) && c10.isEmpty()) {
            return false;
        }
        for (String f10 : c10) {
            if (f32787a.f(b10, f10)) {
                return true;
            }
        }
        return false;
    }

    private final boolean h(String str, X509Certificate x509Certificate) {
        String e10 = a.e(str);
        List<String> c10 = c(x509Certificate, 7);
        if ((c10 instanceof Collection) && c10.isEmpty()) {
            return false;
        }
        for (String e11 : c10) {
            if (j.b(e10, a.e(e11))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> a(X509Certificate x509Certificate) {
        j.g(x509Certificate, "certificate");
        return CollectionsKt___CollectionsKt.h0(c(x509Certificate, 7), c(x509Certificate, 2));
    }

    public final boolean e(String str, X509Certificate x509Certificate) {
        j.g(str, JingleS5BTransportCandidate.ATTR_HOST);
        j.g(x509Certificate, "certificate");
        if (bl.d.i(str)) {
            return h(str, x509Certificate);
        }
        return g(str, x509Certificate);
    }

    public boolean verify(String str, SSLSession sSLSession) {
        j.g(str, JingleS5BTransportCandidate.ATTR_HOST);
        j.g(sSLSession, Session.ELEMENT);
        if (!d(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            if (certificate != null) {
                return e(str, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
