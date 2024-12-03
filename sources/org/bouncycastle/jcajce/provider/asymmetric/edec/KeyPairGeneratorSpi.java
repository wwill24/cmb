package org.bouncycastle.jcajce.provider.asymmetric.edec;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.generators.Ed25519KeyPairGenerator;
import org.bouncycastle.crypto.generators.Ed448KeyPairGenerator;
import org.bouncycastle.crypto.generators.X25519KeyPairGenerator;
import org.bouncycastle.crypto.generators.X448KeyPairGenerator;
import org.bouncycastle.crypto.params.Ed25519KeyGenerationParameters;
import org.bouncycastle.crypto.params.Ed448KeyGenerationParameters;
import org.bouncycastle.crypto.params.X25519KeyGenerationParameters;
import org.bouncycastle.crypto.params.X448KeyGenerationParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveGenParameterSpec;

public class KeyPairGeneratorSpi extends java.security.KeyPairGeneratorSpi {
    private static final int Ed25519 = 1;
    private static final int Ed448 = 2;
    private static final int EdDSA = -1;
    private static final int X25519 = 3;
    private static final int X448 = 4;
    private static final int XDH = -2;
    private final int algorithmDeclared;
    private int algorithmInitialized;
    private AsymmetricCipherKeyPairGenerator generator;
    private SecureRandom secureRandom;

    public static final class Ed25519 extends KeyPairGeneratorSpi {
        public Ed25519() {
            super(1);
        }
    }

    public static final class Ed448 extends KeyPairGeneratorSpi {
        public Ed448() {
            super(2);
        }
    }

    public static final class EdDSA extends KeyPairGeneratorSpi {
        public EdDSA() {
            super(-1);
        }
    }

    public static final class X25519 extends KeyPairGeneratorSpi {
        public X25519() {
            super(3);
        }
    }

    public static final class X448 extends KeyPairGeneratorSpi {
        public X448() {
            super(4);
        }
    }

    public static final class XDH extends KeyPairGeneratorSpi {
        public XDH() {
            super(-2);
        }
    }

    KeyPairGeneratorSpi(int i10) {
        this.algorithmDeclared = i10;
        if (getAlgorithmFamily(i10) != i10) {
            this.algorithmInitialized = i10;
        }
    }

    private static int getAlgorithmFamily(int i10) {
        if (i10 == 1 || i10 == 2) {
            return -1;
        }
        if (i10 == 3 || i10 == 4) {
            return -2;
        }
        return i10;
    }

    private static int getAlgorithmForName(String str) throws InvalidAlgorithmParameterException {
        if (str.equalsIgnoreCase(XDHParameterSpec.X25519) || str.equals(EdECObjectIdentifiers.id_X25519.getId())) {
            return 3;
        }
        if (str.equalsIgnoreCase(EdDSAParameterSpec.Ed25519) || str.equals(EdECObjectIdentifiers.id_Ed25519.getId())) {
            return 1;
        }
        if (str.equalsIgnoreCase(XDHParameterSpec.X448) || str.equals(EdECObjectIdentifiers.id_X448.getId())) {
            return 4;
        }
        if (str.equalsIgnoreCase(EdDSAParameterSpec.Ed448) || str.equals(EdECObjectIdentifiers.id_Ed448.getId())) {
            return 2;
        }
        throw new InvalidAlgorithmParameterException("invalid parameterSpec name: " + str);
    }

    private int getAlgorithmForStrength(int i10) {
        if (i10 == 255 || i10 == 256) {
            int i11 = this.algorithmDeclared;
            if (i11 != -2) {
                if (i11 == -1 || i11 == 1) {
                    return 1;
                }
                if (i11 != 3) {
                    throw new InvalidParameterException("key size not configurable");
                }
            }
            return 3;
        } else if (i10 == 448) {
            int i12 = this.algorithmDeclared;
            if (i12 != -2) {
                if (i12 == -1 || i12 == 2) {
                    return 2;
                }
                if (i12 != 4) {
                    throw new InvalidParameterException("key size not configurable");
                }
            }
            return 4;
        } else {
            throw new InvalidParameterException("unknown key size");
        }
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        return algorithmParameterSpec instanceof ECGenParameterSpec ? ((ECGenParameterSpec) algorithmParameterSpec).getName() : algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec ? ((ECNamedCurveGenParameterSpec) algorithmParameterSpec).getName() : algorithmParameterSpec instanceof EdDSAParameterSpec ? ((EdDSAParameterSpec) algorithmParameterSpec).getCurveName() : algorithmParameterSpec instanceof XDHParameterSpec ? ((XDHParameterSpec) algorithmParameterSpec).getCurveName() : ECUtil.getNameFrom(algorithmParameterSpec);
    }

    private AsymmetricCipherKeyPairGenerator setupGenerator() {
        if (this.secureRandom == null) {
            this.secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        int i10 = this.algorithmInitialized;
        if (i10 == 1) {
            Ed25519KeyPairGenerator ed25519KeyPairGenerator = new Ed25519KeyPairGenerator();
            ed25519KeyPairGenerator.init(new Ed25519KeyGenerationParameters(this.secureRandom));
            return ed25519KeyPairGenerator;
        } else if (i10 == 2) {
            Ed448KeyPairGenerator ed448KeyPairGenerator = new Ed448KeyPairGenerator();
            ed448KeyPairGenerator.init(new Ed448KeyGenerationParameters(this.secureRandom));
            return ed448KeyPairGenerator;
        } else if (i10 == 3) {
            X25519KeyPairGenerator x25519KeyPairGenerator = new X25519KeyPairGenerator();
            x25519KeyPairGenerator.init(new X25519KeyGenerationParameters(this.secureRandom));
            return x25519KeyPairGenerator;
        } else if (i10 == 4) {
            X448KeyPairGenerator x448KeyPairGenerator = new X448KeyPairGenerator();
            x448KeyPairGenerator.init(new X448KeyGenerationParameters(this.secureRandom));
            return x448KeyPairGenerator;
        } else {
            throw new IllegalStateException("generator not correctly initialized");
        }
    }

    public KeyPair generateKeyPair() {
        if (this.algorithmInitialized != 0) {
            if (this.generator == null) {
                this.generator = setupGenerator();
            }
            AsymmetricCipherKeyPair generateKeyPair = this.generator.generateKeyPair();
            int i10 = this.algorithmInitialized;
            if (i10 == 1 || i10 == 2) {
                return new KeyPair(new BCEdDSAPublicKey(generateKeyPair.getPublic()), new BCEdDSAPrivateKey(generateKeyPair.getPrivate()));
            }
            if (i10 == 3 || i10 == 4) {
                return new KeyPair(new BCXDHPublicKey(generateKeyPair.getPublic()), new BCXDHPrivateKey(generateKeyPair.getPrivate()));
            }
            throw new IllegalStateException("generator not correctly initialized");
        }
        throw new IllegalStateException("generator not correctly initialized");
    }

    public void initialize(int i10, SecureRandom secureRandom2) {
        this.algorithmInitialized = getAlgorithmForStrength(i10);
        this.secureRandom = secureRandom2;
        this.generator = null;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom2) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams != null) {
            int algorithmForName = getAlgorithmForName(nameFromParams);
            int i10 = this.algorithmDeclared;
            if (i10 == algorithmForName || i10 == getAlgorithmFamily(algorithmForName)) {
                this.algorithmInitialized = algorithmForName;
                this.secureRandom = secureRandom2;
                this.generator = null;
                return;
            }
            throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
        }
        throw new InvalidAlgorithmParameterException("invalid parameterSpec: " + algorithmParameterSpec);
    }
}
