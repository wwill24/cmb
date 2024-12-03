package org.bouncycastle.jcajce;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.crypto.util.PBKDF2Config;
import org.bouncycastle.crypto.util.PBKDFConfig;

public class BCFKSLoadStoreParameter extends BCLoadStoreParameter {
    private final X509Certificate[] certificates;
    private final EncryptionAlgorithm encAlg;
    private final MacAlgorithm macAlg;
    private final SignatureAlgorithm sigAlg;
    private final Key sigKey;
    private final PBKDFConfig storeConfig;
    private final CertChainValidator validator;

    public static class Builder {
        /* access modifiers changed from: private */
        public X509Certificate[] certs;
        /* access modifiers changed from: private */
        public EncryptionAlgorithm encAlg;
        /* access modifiers changed from: private */

        /* renamed from: in  reason: collision with root package name */
        public final InputStream f23832in;
        /* access modifiers changed from: private */
        public MacAlgorithm macAlg;
        /* access modifiers changed from: private */
        public final OutputStream out;
        /* access modifiers changed from: private */
        public final KeyStore.ProtectionParameter protectionParameter;
        /* access modifiers changed from: private */
        public SignatureAlgorithm sigAlg;
        /* access modifiers changed from: private */
        public final Key sigKey;
        /* access modifiers changed from: private */
        public PBKDFConfig storeConfig;
        /* access modifiers changed from: private */
        public CertChainValidator validator;

        public Builder() {
            this((OutputStream) null, (KeyStore.ProtectionParameter) null);
        }

        public Builder(InputStream inputStream, KeyStore.ProtectionParameter protectionParameter2) {
            this.storeConfig = new PBKDF2Config.Builder().withIterationCount(Opcodes.ACC_ENUM).withSaltLength(64).withPRF(PBKDF2Config.PRF_SHA512).build();
            this.encAlg = EncryptionAlgorithm.AES256_CCM;
            this.macAlg = MacAlgorithm.HmacSHA512;
            this.sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.certs = null;
            this.f23832in = inputStream;
            this.out = null;
            this.protectionParameter = protectionParameter2;
            this.sigKey = null;
        }

        public Builder(InputStream inputStream, PublicKey publicKey) {
            this.storeConfig = new PBKDF2Config.Builder().withIterationCount(Opcodes.ACC_ENUM).withSaltLength(64).withPRF(PBKDF2Config.PRF_SHA512).build();
            this.encAlg = EncryptionAlgorithm.AES256_CCM;
            this.macAlg = MacAlgorithm.HmacSHA512;
            this.sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.certs = null;
            this.f23832in = inputStream;
            this.out = null;
            this.protectionParameter = null;
            this.sigKey = publicKey;
        }

        public Builder(InputStream inputStream, CertChainValidator certChainValidator) {
            this.storeConfig = new PBKDF2Config.Builder().withIterationCount(Opcodes.ACC_ENUM).withSaltLength(64).withPRF(PBKDF2Config.PRF_SHA512).build();
            this.encAlg = EncryptionAlgorithm.AES256_CCM;
            this.macAlg = MacAlgorithm.HmacSHA512;
            this.sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.certs = null;
            this.f23832in = inputStream;
            this.out = null;
            this.protectionParameter = null;
            this.validator = certChainValidator;
            this.sigKey = null;
        }

        public Builder(InputStream inputStream, char[] cArr) {
            this(inputStream, (KeyStore.ProtectionParameter) new KeyStore.PasswordProtection(cArr));
        }

        public Builder(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter2) {
            this.storeConfig = new PBKDF2Config.Builder().withIterationCount(Opcodes.ACC_ENUM).withSaltLength(64).withPRF(PBKDF2Config.PRF_SHA512).build();
            this.encAlg = EncryptionAlgorithm.AES256_CCM;
            this.macAlg = MacAlgorithm.HmacSHA512;
            this.sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.certs = null;
            this.f23832in = null;
            this.out = outputStream;
            this.protectionParameter = protectionParameter2;
            this.sigKey = null;
        }

        public Builder(OutputStream outputStream, PrivateKey privateKey) {
            this.storeConfig = new PBKDF2Config.Builder().withIterationCount(Opcodes.ACC_ENUM).withSaltLength(64).withPRF(PBKDF2Config.PRF_SHA512).build();
            this.encAlg = EncryptionAlgorithm.AES256_CCM;
            this.macAlg = MacAlgorithm.HmacSHA512;
            this.sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.certs = null;
            this.f23832in = null;
            this.out = outputStream;
            this.protectionParameter = null;
            this.sigKey = privateKey;
        }

        public Builder(OutputStream outputStream, char[] cArr) {
            this(outputStream, (KeyStore.ProtectionParameter) new KeyStore.PasswordProtection(cArr));
        }

        public BCFKSLoadStoreParameter build() {
            return new BCFKSLoadStoreParameter(this);
        }

        public Builder withCertificates(X509Certificate[] x509CertificateArr) {
            int length = x509CertificateArr.length;
            X509Certificate[] x509CertificateArr2 = new X509Certificate[length];
            System.arraycopy(x509CertificateArr, 0, x509CertificateArr2, 0, length);
            this.certs = x509CertificateArr2;
            return this;
        }

        public Builder withStoreEncryptionAlgorithm(EncryptionAlgorithm encryptionAlgorithm) {
            this.encAlg = encryptionAlgorithm;
            return this;
        }

        public Builder withStoreMacAlgorithm(MacAlgorithm macAlgorithm) {
            this.macAlg = macAlgorithm;
            return this;
        }

        public Builder withStorePBKDFConfig(PBKDFConfig pBKDFConfig) {
            this.storeConfig = pBKDFConfig;
            return this;
        }

        public Builder withStoreSignatureAlgorithm(SignatureAlgorithm signatureAlgorithm) {
            this.sigAlg = signatureAlgorithm;
            return this;
        }
    }

    public interface CertChainValidator {
        boolean isValid(X509Certificate[] x509CertificateArr);
    }

    public enum EncryptionAlgorithm {
        AES256_CCM,
        AES256_KWP
    }

    public enum MacAlgorithm {
        HmacSHA512,
        HmacSHA3_512
    }

    public enum SignatureAlgorithm {
        SHA512withDSA,
        SHA3_512withDSA,
        SHA512withECDSA,
        SHA3_512withECDSA,
        SHA512withRSA,
        SHA3_512withRSA
    }

    private BCFKSLoadStoreParameter(Builder builder) {
        super(builder.f23832in, builder.out, builder.protectionParameter);
        this.storeConfig = builder.storeConfig;
        this.encAlg = builder.encAlg;
        this.macAlg = builder.macAlg;
        this.sigAlg = builder.sigAlg;
        this.sigKey = builder.sigKey;
        this.certificates = builder.certs;
        this.validator = builder.validator;
    }

    public CertChainValidator getCertChainValidator() {
        return this.validator;
    }

    public X509Certificate[] getStoreCertificates() {
        return this.certificates;
    }

    public EncryptionAlgorithm getStoreEncryptionAlgorithm() {
        return this.encAlg;
    }

    public MacAlgorithm getStoreMacAlgorithm() {
        return this.macAlg;
    }

    public PBKDFConfig getStorePBKDFConfig() {
        return this.storeConfig;
    }

    public SignatureAlgorithm getStoreSignatureAlgorithm() {
        return this.sigAlg;
    }

    public Key getStoreSignatureKey() {
        return this.sigKey;
    }
}
