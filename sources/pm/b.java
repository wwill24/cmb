package pm;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class b {
    public static X509TrustManager a() {
        return b((KeyStore) null);
    }

    public static X509TrustManager b(KeyStore keyStore) {
        String defaultAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(defaultAlgorithm);
            instance.init(keyStore);
            for (TrustManager trustManager : instance.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new AssertionError("No trust manager for the default algorithm " + defaultAlgorithm + " found");
        } catch (KeyStoreException | NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }
}
