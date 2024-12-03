package org.jivesoftware.smack.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;

public class TLSUtils {
    private static final File DEFAULT_TRUSTSTORE_PATH;
    private static final int JKS_MAGIC = -17957139;
    private static final int JKS_VERSION_1 = 1;
    private static final int JKS_VERSION_2 = 2;
    private static final Logger LOGGER = Logger.getLogger(TLSUtils.class.getName());
    public static final String PROTO_SSL3 = "SSLv3";
    public static final String PROTO_TLSV1 = "TLSv1";
    public static final String PROTO_TLSV1_1 = "TLSv1.1";
    public static final String PROTO_TLSV1_2 = "TLSv1.2";
    public static final String PROTO_TLSV1_3 = "TLSv1.3";
    public static final String SSL = "SSL";
    public static final String TLS = "TLS";

    public static class AcceptAllTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    enum DefaultTrustStoreType {
        jks,
        unknown,
        no_default
    }

    static {
        String property = System.getProperty("java.home");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(property);
        String str = File.separator;
        sb2.append(str);
        sb2.append("lib");
        sb2.append(str);
        sb2.append("security");
        sb2.append(str);
        sb2.append("cacerts");
        DEFAULT_TRUSTSTORE_PATH = new File(sb2.toString());
    }

    public static <B extends ConnectionConfiguration.Builder<B, ?>> B acceptAllCertificates(B b10) {
        b10.setCustomX509TrustManager(new AcceptAllTrustManager());
        return b10;
    }

    public static <B extends ConnectionConfiguration.Builder<B, ?>> B disableHostnameVerificationForTlsCertificates(B b10) {
        b10.setHostnameVerifier(new p());
        return b10;
    }

    public static byte[] getChannelBindingTlsServerEndPoint(SSLSession sSLSession) throws SSLPeerUnverifiedException, CertificateEncodingException, NoSuchAlgorithmException {
        Certificate certificate = sSLSession.getPeerCertificates()[0];
        String algorithm = certificate.getPublicKey().getAlgorithm();
        algorithm.hashCode();
        if (algorithm.equals(StringUtils.MD5) || algorithm.equals("SHA-1")) {
            algorithm = "SHA-256";
        }
        MessageDigest instance = MessageDigest.getInstance(algorithm);
        instance.update(certificate.getEncoded());
        return instance.digest();
    }

    public static FileInputStream getDefaultTruststoreStreamIfPossible() {
        try {
            return new FileInputStream(DEFAULT_TRUSTSTORE_PATH);
        } catch (FileNotFoundException e10) {
            Logger logger = LOGGER;
            Level level = Level.WARNING;
            logger.log(level, "Could not open default truststore at " + DEFAULT_TRUSTSTORE_PATH, e10);
            return null;
        }
    }

    public static DefaultTrustStoreType getDefaultTruststoreType() throws IOException {
        FileInputStream defaultTruststoreStreamIfPossible = getDefaultTruststoreStreamIfPossible();
        if (defaultTruststoreStreamIfPossible == null) {
            try {
                DefaultTrustStoreType defaultTrustStoreType = DefaultTrustStoreType.no_default;
                if (defaultTruststoreStreamIfPossible != null) {
                    defaultTruststoreStreamIfPossible.close();
                }
                return defaultTrustStoreType;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            DataInputStream dataInputStream = new DataInputStream(defaultTruststoreStreamIfPossible);
            int readInt = dataInputStream.readInt();
            int readInt2 = dataInputStream.readInt();
            if (readInt == JKS_MAGIC && (readInt2 == 1 || readInt2 == 2)) {
                DefaultTrustStoreType defaultTrustStoreType2 = DefaultTrustStoreType.jks;
                defaultTruststoreStreamIfPossible.close();
                return defaultTrustStoreType2;
            }
            defaultTruststoreStreamIfPossible.close();
            return DefaultTrustStoreType.unknown;
        }
        throw th;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$disableHostnameVerificationForTlsCertificates$0(String str, SSLSession sSLSession) {
        return true;
    }

    public static void setDefaultTrustStoreTypeToJksIfRequired() {
        try {
            if (getDefaultTruststoreType() == DefaultTrustStoreType.jks) {
                System.setProperty("javax.net.ssl.trustStoreType", "JKS");
            }
        } catch (IOException e10) {
            LOGGER.log(Level.WARNING, "Could not set keystore type to jks if required", e10);
        }
    }

    public static void setEnabledProtocolsAndCiphers(SSLSocket sSLSocket, String[] strArr, String[] strArr2) throws SmackException.SecurityNotPossibleException {
        if (strArr != null) {
            HashSet hashSet = new HashSet(Arrays.asList(strArr));
            HashSet hashSet2 = new HashSet(Arrays.asList(sSLSocket.getSupportedProtocols()));
            HashSet hashSet3 = new HashSet(hashSet2);
            hashSet3.retainAll(hashSet);
            if (!hashSet3.isEmpty()) {
                sSLSocket.setEnabledProtocols((String[]) hashSet3.toArray(new String[hashSet3.size()]));
            } else {
                throw new SmackException.SecurityNotPossibleException("Request to enable SSL/TLS protocols '" + StringUtils.collectionToString(hashSet) + "', but only '" + StringUtils.collectionToString(hashSet2) + "' are supported.");
            }
        }
        if (strArr2 != null) {
            HashSet hashSet4 = new HashSet(Arrays.asList(strArr2));
            HashSet hashSet5 = new HashSet(Arrays.asList(sSLSocket.getEnabledCipherSuites()));
            HashSet hashSet6 = new HashSet(hashSet5);
            hashSet6.retainAll(hashSet4);
            if (!hashSet6.isEmpty()) {
                sSLSocket.setEnabledCipherSuites((String[]) hashSet6.toArray(new String[hashSet6.size()]));
                return;
            }
            throw new SmackException.SecurityNotPossibleException("Request to enable SSL/TLS ciphers '" + StringUtils.collectionToString(hashSet4) + "', but only '" + StringUtils.collectionToString(hashSet5) + "' are supported.");
        }
    }

    public static <B extends ConnectionConfiguration.Builder<B, ?>> B setEnabledTlsProtocolsToRecommended(B b10) {
        b10.setEnabledSSLProtocols(new String[]{PROTO_TLSV1_3, PROTO_TLSV1_2});
        return b10;
    }

    @Deprecated
    public static <B extends ConnectionConfiguration.Builder<B, ?>> B setSSLv3AndTLSOnly(B b10) {
        b10.setEnabledSSLProtocols(new String[]{PROTO_TLSV1_2, PROTO_TLSV1_1, PROTO_TLSV1, PROTO_SSL3});
        return b10;
    }

    @Deprecated
    public static <B extends ConnectionConfiguration.Builder<B, ?>> B setTLSOnly(B b10) {
        b10.setEnabledSSLProtocols(new String[]{PROTO_TLSV1_2, PROTO_TLSV1_1, PROTO_TLSV1});
        return b10;
    }
}
