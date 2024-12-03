package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.jcajce.provider.util.DigestFactory;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class PSSSignatureSpi extends SignatureSpi {
    private Digest contentDigest;
    private AlgorithmParameters engineParams;
    private final JcaJceHelper helper;
    private boolean isInitState;
    private boolean isRaw;
    private RSAKeyParameters key;
    private Digest mgfDigest;
    private PSSParameterSpec originalSpec;
    private PSSParameterSpec paramSpec;
    private PSSSigner pss;
    private SecureRandom random;
    private int saltLength;
    private AsymmetricBlockCipher signer;
    private byte trailer;

    private class NullPssDigest implements Digest {
        private ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        private Digest baseDigest;
        private boolean oddTime = true;

        public NullPssDigest(Digest digest) {
            this.baseDigest = digest;
        }

        public int doFinal(byte[] bArr, int i10) {
            byte[] byteArray = this.bOut.toByteArray();
            if (this.oddTime) {
                System.arraycopy(byteArray, 0, bArr, i10, byteArray.length);
            } else {
                this.baseDigest.update(byteArray, 0, byteArray.length);
                this.baseDigest.doFinal(bArr, i10);
            }
            reset();
            this.oddTime = !this.oddTime;
            return byteArray.length;
        }

        public String getAlgorithmName() {
            return "NULL";
        }

        public int getByteLength() {
            return 0;
        }

        public int getDigestSize() {
            return this.baseDigest.getDigestSize();
        }

        public void reset() {
            this.bOut.reset();
            this.baseDigest.reset();
        }

        public void update(byte b10) {
            this.bOut.write(b10);
        }

        public void update(byte[] bArr, int i10, int i11) {
            this.bOut.write(bArr, i10, i11);
        }
    }

    public static class PSSwithRSA extends PSSSignatureSpi {
        public PSSwithRSA() {
            super(new RSABlindedEngine(), (PSSParameterSpec) null);
        }
    }

    public static class SHA1withRSA extends PSSSignatureSpi {
        public SHA1withRSA() {
            super(new RSABlindedEngine(), PSSParameterSpec.DEFAULT);
        }
    }

    public static class SHA1withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA1withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA1", "SHAKE128", (AlgorithmParameterSpec) null, 20, 1));
        }
    }

    public static class SHA1withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA1withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA1", "SHAKE256", (AlgorithmParameterSpec) null, 20, 1));
        }
    }

    public static class SHA224withRSA extends PSSSignatureSpi {
        public SHA224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224), 28, 1));
        }
    }

    public static class SHA224withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA224withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "SHAKE128", (AlgorithmParameterSpec) null, 28, 1));
        }
    }

    public static class SHA224withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA224withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "SHAKE256", (AlgorithmParameterSpec) null, 28, 1));
        }
    }

    public static class SHA256withRSA extends PSSSignatureSpi {
        public SHA256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), 32, 1));
        }
    }

    public static class SHA256withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA256withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-256", "SHAKE128", (AlgorithmParameterSpec) null, 32, 1));
        }
    }

    public static class SHA256withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA256withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-256", "SHAKE256", (AlgorithmParameterSpec) null, 32, 1));
        }
    }

    public static class SHA384withRSA extends PSSSignatureSpi {
        public SHA384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384), 48, 1));
        }
    }

    public static class SHA384withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA384withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384, "SHAKE128", (AlgorithmParameterSpec) null, 48, 1));
        }
    }

    public static class SHA384withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA384withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384, "SHAKE256", (AlgorithmParameterSpec) null, 48, 1));
        }
    }

    public static class SHA3_224withRSA extends PSSSignatureSpi {
        public SHA3_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), 28, 1));
        }
    }

    public static class SHA3_224withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA3_224withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-224", "SHAKE128", (AlgorithmParameterSpec) null, 28, 1));
        }
    }

    public static class SHA3_224withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA3_224withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-224", "SHAKE256", (AlgorithmParameterSpec) null, 28, 1));
        }
    }

    public static class SHA3_256withRSA extends PSSSignatureSpi {
        public SHA3_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), 32, 1));
        }
    }

    public static class SHA3_256withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA3_256withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-256", "SHAKE128", (AlgorithmParameterSpec) null, 32, 1));
        }
    }

    public static class SHA3_256withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA3_256withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-256", "SHAKE256", (AlgorithmParameterSpec) null, 32, 1));
        }
    }

    public static class SHA3_384withRSA extends PSSSignatureSpi {
        public SHA3_384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), 48, 1));
        }
    }

    public static class SHA3_384withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA3_384withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-384", "SHAKE128", (AlgorithmParameterSpec) null, 48, 1));
        }
    }

    public static class SHA3_384withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA3_384withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-384", "SHAKE256", (AlgorithmParameterSpec) null, 48, 1));
        }
    }

    public static class SHA3_512withRSA extends PSSSignatureSpi {
        public SHA3_512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), 64, 1));
        }
    }

    public static class SHA3_512withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA3_512withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-512", "SHAKE128", (AlgorithmParameterSpec) null, 64, 1));
        }
    }

    public static class SHA3_512withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA3_512withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-512", "SHAKE256", (AlgorithmParameterSpec) null, 64, 1));
        }
    }

    public static class SHA512_224withRSA extends PSSSignatureSpi {
        public SHA512_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(224)", "MGF1", new MGF1ParameterSpec("SHA-512(224)"), 28, 1));
        }
    }

    public static class SHA512_224withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA512_224withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(224)", "SHAKE128", (AlgorithmParameterSpec) null, 28, 1));
        }
    }

    public static class SHA512_224withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA512_224withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(224)", "SHAKE256", (AlgorithmParameterSpec) null, 28, 1));
        }
    }

    public static class SHA512_256withRSA extends PSSSignatureSpi {
        public SHA512_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(256)", "MGF1", new MGF1ParameterSpec("SHA-512(256)"), 32, 1));
        }
    }

    public static class SHA512_256withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA512_256withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(256)", "SHAKE128", (AlgorithmParameterSpec) null, 32, 1));
        }
    }

    public static class SHA512_256withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA512_256withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(256)", "SHAKE256", (AlgorithmParameterSpec) null, 32, 1));
        }
    }

    public static class SHA512withRSA extends PSSSignatureSpi {
        public SHA512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512", "MGF1", new MGF1ParameterSpec("SHA-512"), 64, 1));
        }
    }

    public static class SHA512withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA512withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512", "SHAKE128", (AlgorithmParameterSpec) null, 64, 1));
        }
    }

    public static class SHA512withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA512withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512", "SHAKE256", (AlgorithmParameterSpec) null, 64, 1));
        }
    }

    public static class SHAKE128WithRSAPSS extends PSSSignatureSpi {
        public SHAKE128WithRSAPSS() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHAKE128", "SHAKE128", (AlgorithmParameterSpec) null, 32, 1));
        }
    }

    public static class SHAKE256WithRSAPSS extends PSSSignatureSpi {
        public SHAKE256WithRSAPSS() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHAKE256", "SHAKE256", (AlgorithmParameterSpec) null, 64, 1));
        }
    }

    public static class nonePSS extends PSSSignatureSpi {
        public nonePSS() {
            super(new RSABlindedEngine(), (PSSParameterSpec) null, true);
        }
    }

    protected PSSSignatureSpi(AsymmetricBlockCipher asymmetricBlockCipher, PSSParameterSpec pSSParameterSpec) {
        this(asymmetricBlockCipher, pSSParameterSpec, false);
    }

    protected PSSSignatureSpi(AsymmetricBlockCipher asymmetricBlockCipher, PSSParameterSpec pSSParameterSpec, boolean z10) {
        this.helper = new BCJcaJceHelper();
        this.isInitState = true;
        this.signer = asymmetricBlockCipher;
        this.originalSpec = pSSParameterSpec;
        if (pSSParameterSpec == null) {
            this.paramSpec = PSSParameterSpec.DEFAULT;
        } else {
            this.paramSpec = pSSParameterSpec;
        }
        this.mgfDigest = DigestFactory.getDigest("MGF1".equals(this.paramSpec.getMGFAlgorithm()) ? this.paramSpec.getDigestAlgorithm() : this.paramSpec.getMGFAlgorithm());
        this.saltLength = this.paramSpec.getSaltLength();
        this.trailer = getTrailer(this.paramSpec.getTrailerField());
        this.isRaw = z10;
        setupContentDigest();
    }

    private byte getTrailer(int i10) {
        if (i10 == 1) {
            return PSSSigner.TRAILER_IMPLICIT;
        }
        throw new IllegalArgumentException("unknown trailer field");
    }

    private void setupContentDigest() {
        this.contentDigest = this.isRaw ? new NullPssDigest(this.mgfDigest) : DigestFactory.getDigest(this.paramSpec.getDigestAlgorithm());
    }

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        PSSParameterSpec pSSParameterSpec;
        if (this.engineParams == null && (pSSParameterSpec = this.paramSpec) != null) {
            if (pSSParameterSpec.getDigestAlgorithm().equals(this.paramSpec.getMGFAlgorithm()) && this.paramSpec.getMGFParameters() == null) {
                return null;
            }
            try {
                AlgorithmParameters createAlgorithmParameters = this.helper.createAlgorithmParameters("PSS");
                this.engineParams = createAlgorithmParameters;
                createAlgorithmParameters.init(this.paramSpec);
            } catch (Exception e10) {
                throw new RuntimeException(e10.toString());
            }
        }
        return this.engineParams;
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            this.key = RSAUtil.generatePrivateKeyParameter((RSAPrivateKey) privateKey);
            PSSSigner pSSSigner = new PSSSigner(this.signer, this.contentDigest, this.mgfDigest, this.saltLength, this.trailer);
            this.pss = pSSSigner;
            SecureRandom secureRandom = this.random;
            if (secureRandom != null) {
                pSSSigner.init(true, new ParametersWithRandom(this.key, secureRandom));
            } else {
                pSSSigner.init(true, this.key);
            }
            this.isInitState = true;
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.random = secureRandom;
        engineInitSign(privateKey);
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof RSAPublicKey) {
            this.key = RSAUtil.generatePublicKeyParameter((RSAPublicKey) publicKey);
            PSSSigner pSSSigner = new PSSSigner(this.signer, this.contentDigest, this.mgfDigest, this.saltLength, this.trailer);
            this.pss = pSSSigner;
            pSSSigner.init(false, this.key);
            this.isInitState = true;
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        String str;
        PSSSigner pSSSigner;
        boolean z10;
        if (algorithmParameterSpec != null || (algorithmParameterSpec = this.originalSpec) != null) {
            if (!this.isInitState) {
                throw new ProviderException("cannot call setParameter in the middle of update");
            } else if (algorithmParameterSpec instanceof PSSParameterSpec) {
                PSSParameterSpec pSSParameterSpec = (PSSParameterSpec) algorithmParameterSpec;
                PSSParameterSpec pSSParameterSpec2 = this.originalSpec;
                if (pSSParameterSpec2 == null || DigestFactory.isSameDigest(pSSParameterSpec2.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                    if (pSSParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") || pSSParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1.getId())) {
                        if (pSSParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                            MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) pSSParameterSpec.getMGFParameters();
                            if (DigestFactory.isSameDigest(mGF1ParameterSpec.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                                str = mGF1ParameterSpec.getDigestAlgorithm();
                            } else {
                                throw new InvalidAlgorithmParameterException("digest algorithm for MGF should be the same as for PSS parameters.");
                            }
                        } else {
                            throw new InvalidAlgorithmParameterException("unknown MGF parameters");
                        }
                    } else if (pSSParameterSpec.getMGFAlgorithm().equals("SHAKE128") || pSSParameterSpec.getMGFAlgorithm().equals("SHAKE256")) {
                        str = pSSParameterSpec.getMGFAlgorithm();
                    } else {
                        throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
                    }
                    Digest digest = DigestFactory.getDigest(str);
                    if (digest != null) {
                        this.engineParams = null;
                        this.paramSpec = pSSParameterSpec;
                        this.mgfDigest = digest;
                        this.saltLength = pSSParameterSpec.getSaltLength();
                        this.trailer = getTrailer(this.paramSpec.getTrailerField());
                        setupContentDigest();
                        if (this.key != null) {
                            this.pss = new PSSSigner(this.signer, this.contentDigest, digest, this.saltLength, this.trailer);
                            if (this.key.isPrivate()) {
                                pSSSigner = this.pss;
                                z10 = true;
                            } else {
                                pSSSigner = this.pss;
                                z10 = false;
                            }
                            pSSSigner.init(z10, this.key);
                            return;
                        }
                        return;
                    }
                    throw new InvalidAlgorithmParameterException("no match on MGF algorithm: " + pSSParameterSpec.getMGFAlgorithm());
                }
                throw new InvalidAlgorithmParameterException("parameter must be using " + this.originalSpec.getDigestAlgorithm());
            } else {
                throw new InvalidAlgorithmParameterException("Only PSSParameterSpec supported");
            }
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineSign() throws SignatureException {
        this.isInitState = true;
        try {
            return this.pss.generateSignature();
        } catch (CryptoException e10) {
            throw new SignatureException(e10.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b10) throws SignatureException {
        this.pss.update(b10);
        this.isInitState = false;
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.pss.update(bArr, i10, i11);
        this.isInitState = false;
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        this.isInitState = true;
        return this.pss.verifySignature(bArr);
    }
}
