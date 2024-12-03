package org.bouncycastle.pqc.jcajce.provider.lms;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.lms.HSSKeyGenerationParameters;
import org.bouncycastle.pqc.crypto.lms.HSSKeyPairGenerator;
import org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMOtsParameters;
import org.bouncycastle.pqc.crypto.lms.LMSKeyGenerationParameters;
import org.bouncycastle.pqc.crypto.lms.LMSKeyPairGenerator;
import org.bouncycastle.pqc.crypto.lms.LMSKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSigParameters;
import org.bouncycastle.pqc.jcajce.spec.LMSHSSKeyGenParameterSpec;
import org.bouncycastle.pqc.jcajce.spec.LMSHSSParameterSpec;
import org.bouncycastle.pqc.jcajce.spec.LMSKeyGenParameterSpec;
import org.bouncycastle.pqc.jcajce.spec.LMSParameterSpec;

public class LMSKeyPairGeneratorSpi extends KeyPairGenerator {
    private AsymmetricCipherKeyPairGenerator engine = new LMSKeyPairGenerator();
    private boolean initialised = false;
    private KeyGenerationParameters param;
    private SecureRandom random = CryptoServicesRegistrar.getSecureRandom();
    private ASN1ObjectIdentifier treeDigest;

    public LMSKeyPairGeneratorSpi() {
        super("LMS");
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            LMSKeyGenerationParameters lMSKeyGenerationParameters = new LMSKeyGenerationParameters(new LMSParameters(LMSigParameters.lms_sha256_n32_h10, LMOtsParameters.sha256_n32_w2), this.random);
            this.param = lMSKeyGenerationParameters;
            this.engine.init(lMSKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return this.engine instanceof LMSKeyPairGenerator ? new KeyPair(new BCLMSPublicKey((LMSKeyParameters) (LMSPublicKeyParameters) generateKeyPair.getPublic()), new BCLMSPrivateKey((LMSKeyParameters) (LMSPrivateKeyParameters) generateKeyPair.getPrivate())) : new KeyPair(new BCLMSPublicKey((LMSKeyParameters) (HSSPublicKeyParameters) generateKeyPair.getPublic()), new BCLMSPrivateKey((LMSKeyParameters) (HSSPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i10, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        AsymmetricCipherKeyPairGenerator hSSKeyPairGenerator;
        if (algorithmParameterSpec instanceof LMSKeyGenParameterSpec) {
            LMSKeyGenParameterSpec lMSKeyGenParameterSpec = (LMSKeyGenParameterSpec) algorithmParameterSpec;
            this.param = new LMSKeyGenerationParameters(new LMSParameters(lMSKeyGenParameterSpec.getSigParams(), lMSKeyGenParameterSpec.getOtsParams()), secureRandom);
            hSSKeyPairGenerator = new LMSKeyPairGenerator();
        } else {
            int i10 = 0;
            if (algorithmParameterSpec instanceof LMSHSSKeyGenParameterSpec) {
                LMSKeyGenParameterSpec[] lMSSpecs = ((LMSHSSKeyGenParameterSpec) algorithmParameterSpec).getLMSSpecs();
                LMSParameters[] lMSParametersArr = new LMSParameters[lMSSpecs.length];
                while (i10 != lMSSpecs.length) {
                    lMSParametersArr[i10] = new LMSParameters(lMSSpecs[i10].getSigParams(), lMSSpecs[i10].getOtsParams());
                    i10++;
                }
                this.param = new HSSKeyGenerationParameters(lMSParametersArr, secureRandom);
                hSSKeyPairGenerator = new HSSKeyPairGenerator();
            } else if (algorithmParameterSpec instanceof LMSParameterSpec) {
                LMSParameterSpec lMSParameterSpec = (LMSParameterSpec) algorithmParameterSpec;
                this.param = new LMSKeyGenerationParameters(new LMSParameters(lMSParameterSpec.getSigParams(), lMSParameterSpec.getOtsParams()), secureRandom);
                hSSKeyPairGenerator = new LMSKeyPairGenerator();
            } else if (algorithmParameterSpec instanceof LMSHSSParameterSpec) {
                LMSParameterSpec[] lMSSpecs2 = ((LMSHSSParameterSpec) algorithmParameterSpec).getLMSSpecs();
                LMSParameters[] lMSParametersArr2 = new LMSParameters[lMSSpecs2.length];
                while (i10 != lMSSpecs2.length) {
                    lMSParametersArr2[i10] = new LMSParameters(lMSSpecs2[i10].getSigParams(), lMSSpecs2[i10].getOtsParams());
                    i10++;
                }
                this.param = new HSSKeyGenerationParameters(lMSParametersArr2, secureRandom);
                hSSKeyPairGenerator = new HSSKeyPairGenerator();
            } else {
                throw new InvalidAlgorithmParameterException("parameter object not a LMSParameterSpec/LMSHSSParameterSpec");
            }
        }
        this.engine = hSSKeyPairGenerator;
        hSSKeyPairGenerator.init(this.param);
        this.initialised = true;
    }
}
