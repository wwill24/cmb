package org.jivesoftware.smack.util.dns.minidns;

import java.security.KeyManagementException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jivesoftware.smack.util.dns.SmackDaneVerifier;
import org.minidns.dane.a;

public class MiniDnsDaneVerifier implements SmackDaneVerifier {
    private static final a VERIFIER = new a();
    private pm.a expectingTrustManager;

    MiniDnsDaneVerifier() {
    }

    public void finish(SSLSession sSLSession) throws CertificateException {
        if (!VERIFIER.c(sSLSession) && this.expectingTrustManager.b()) {
            throw this.expectingTrustManager.a();
        }
    }

    public void init(SSLContext sSLContext, KeyManager[] keyManagerArr, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws KeyManagementException {
        if (this.expectingTrustManager == null) {
            pm.a aVar = new pm.a(x509TrustManager);
            this.expectingTrustManager = aVar;
            sSLContext.init(keyManagerArr, new TrustManager[]{aVar}, secureRandom);
            return;
        }
        throw new IllegalStateException("DaneProvider was initialized before. Use newInstance() instead.");
    }
}
