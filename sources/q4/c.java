package q4;

import com.clevertap.android.sdk.p;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.jivesoftware.smack.util.TLSUtils;

final class c {
    c() {
    }

    /* access modifiers changed from: package-private */
    public SSLContext a() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore instance3 = KeyStore.getInstance(KeyStore.getDefaultType());
            instance3.load((InputStream) null, (char[]) null);
            instance3.setCertificateEntry("AmazonRootCA1", (X509Certificate) instance.generateCertificate(new BufferedInputStream(c.class.getClassLoader().getResourceAsStream("com/clevertap/android/sdk/certificates/AmazonRootCA1.cer"))));
            instance2.init(instance3);
            SSLContext instance4 = SSLContext.getInstance(TLSUtils.TLS);
            instance4.init((KeyManager[]) null, instance2.getTrustManagers(), (SecureRandom) null);
            p.a("SSL Context built");
            return instance4;
        } catch (Throwable th2) {
            p.k("Error building SSL Context", th2);
            return null;
        }
    }
}
