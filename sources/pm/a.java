package pm;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class a implements X509TrustManager {

    /* renamed from: a  reason: collision with root package name */
    private CertificateException f33768a;

    /* renamed from: b  reason: collision with root package name */
    private final X509TrustManager f33769b;

    public a(X509TrustManager x509TrustManager) {
        this.f33769b = x509TrustManager == null ? b.a() : x509TrustManager;
    }

    public CertificateException a() {
        CertificateException certificateException = this.f33768a;
        this.f33768a = null;
        return certificateException;
    }

    public boolean b() {
        return this.f33768a != null;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.f33769b.checkClientTrusted(x509CertificateArr, str);
        } catch (CertificateException e10) {
            this.f33768a = e10;
        }
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.f33769b.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e10) {
            this.f33768a = e10;
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.f33769b.getAcceptedIssuers();
    }
}
