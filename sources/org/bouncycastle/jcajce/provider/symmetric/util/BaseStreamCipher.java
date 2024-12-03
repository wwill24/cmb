package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.PBE;

public class BaseStreamCipher extends BaseWrapCipher {
    private Class[] availableSpecs;
    private StreamCipher cipher;
    private int digest;
    private int ivLength;
    private ParametersWithIV ivParam;
    private int keySizeInBits;
    private String pbeAlgorithm;
    private PBEParameterSpec pbeSpec;

    protected BaseStreamCipher(StreamCipher streamCipher, int i10) {
        this(streamCipher, i10, -1, -1);
    }

    protected BaseStreamCipher(StreamCipher streamCipher, int i10, int i11) {
        this(streamCipher, i10, i11, -1);
    }

    protected BaseStreamCipher(StreamCipher streamCipher, int i10, int i11, int i12) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.cipher = streamCipher;
        this.ivLength = i10;
        this.keySizeInBits = i11;
        this.digest = i12;
    }

    /* access modifiers changed from: protected */
    public int engineDoFinal(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException {
        if (i12 + i11 <= bArr2.length) {
            if (i11 != 0) {
                this.cipher.processBytes(bArr, i10, i11, bArr2, i12);
            }
            this.cipher.reset();
            return i11;
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal(byte[] bArr, int i10, int i11) {
        if (i11 != 0) {
            byte[] engineUpdate = engineUpdate(bArr, i10, i11);
            this.cipher.reset();
            return engineUpdate;
        }
        this.cipher.reset();
        return new byte[0];
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetIV() {
        ParametersWithIV parametersWithIV = this.ivParam;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int i10) {
        return i10;
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            if (this.pbeSpec != null) {
                try {
                    AlgorithmParameters createParametersInstance = createParametersInstance(this.pbeAlgorithm);
                    createParametersInstance.init(this.pbeSpec);
                    return createParametersInstance;
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.ivParam != null) {
                String algorithmName = this.cipher.getAlgorithmName();
                if (algorithmName.indexOf(47) >= 0) {
                    algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
                }
                if (algorithmName.startsWith("ChaCha7539")) {
                    algorithmName = "ChaCha7539";
                } else if (algorithmName.startsWith("Grain")) {
                    algorithmName = "Grainv1";
                } else if (algorithmName.startsWith("HC")) {
                    int indexOf = algorithmName.indexOf(45);
                    algorithmName = algorithmName.substring(0, indexOf) + algorithmName.substring(indexOf + 1);
                }
                try {
                    AlgorithmParameters createParametersInstance2 = createParametersInstance(algorithmName);
                    this.engineParams = createParametersInstance2;
                    createParametersInstance2.init(new IvParameterSpec(this.ivParam.getIV()));
                } catch (Exception e10) {
                    throw new RuntimeException(e10.toString());
                }
            }
        }
        return this.engineParams;
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            algorithmParameterSpec = SpecUtil.extractSpec(algorithmParameters, this.availableSpecs);
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            algorithmParameterSpec = null;
        }
        engineInit(i10, key, algorithmParameterSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i10, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i10, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e10) {
            throw new InvalidKeyException(e10.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i10, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithIV parametersWithIV;
        CipherParameters cipherParameters;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.engineParams = null;
        if (key instanceof SecretKey) {
            if (key instanceof PKCS12Key) {
                PKCS12Key pKCS12Key = (PKCS12Key) key;
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                this.pbeSpec = pBEParameterSpec;
                if ((pKCS12Key instanceof PKCS12KeyWithParameters) && pBEParameterSpec == null) {
                    PKCS12KeyWithParameters pKCS12KeyWithParameters = (PKCS12KeyWithParameters) pKCS12Key;
                    this.pbeSpec = new PBEParameterSpec(pKCS12KeyWithParameters.getSalt(), pKCS12KeyWithParameters.getIterationCount());
                }
                parametersWithIV = PBE.Util.makePBEParameters(pKCS12Key.getEncoded(), 2, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
            } else {
                if (key instanceof BCPBEKey) {
                    BCPBEKey bCPBEKey = (BCPBEKey) key;
                    this.pbeAlgorithm = bCPBEKey.getOID() != null ? bCPBEKey.getOID().getId() : bCPBEKey.getAlgorithm();
                    if (bCPBEKey.getParam() != null) {
                        cipherParameters = bCPBEKey.getParam();
                        this.pbeSpec = new PBEParameterSpec(bCPBEKey.getSalt(), bCPBEKey.getIterationCount());
                    } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                        CipherParameters makePBEParameters = PBE.Util.makePBEParameters(bCPBEKey, algorithmParameterSpec, this.cipher.getAlgorithmName());
                        this.pbeSpec = (PBEParameterSpec) algorithmParameterSpec;
                        cipherParameters = makePBEParameters;
                    } else {
                        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                    }
                    if (bCPBEKey.getIvSize() != 0) {
                        this.ivParam = (ParametersWithIV) cipherParameters;
                    }
                } else if (algorithmParameterSpec == null) {
                    if (this.digest <= 0) {
                        cipherParameters = new KeyParameter(key.getEncoded());
                    } else {
                        throw new InvalidKeyException("Algorithm requires a PBE key");
                    }
                } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                    ParametersWithIV parametersWithIV2 = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
                    this.ivParam = parametersWithIV2;
                    parametersWithIV = parametersWithIV2;
                } else {
                    throw new InvalidAlgorithmParameterException("unknown parameter type.");
                }
                parametersWithIV = cipherParameters;
            }
            if (this.ivLength != 0 && !(parametersWithIV instanceof ParametersWithIV)) {
                if (secureRandom == null) {
                    secureRandom = CryptoServicesRegistrar.getSecureRandom();
                }
                if (i10 == 1 || i10 == 3) {
                    byte[] bArr = new byte[this.ivLength];
                    secureRandom.nextBytes(bArr);
                    ParametersWithIV parametersWithIV3 = new ParametersWithIV(parametersWithIV, bArr);
                    this.ivParam = parametersWithIV3;
                    parametersWithIV = parametersWithIV3;
                } else {
                    throw new InvalidAlgorithmParameterException("no IV set when one expected");
                }
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            try {
                                throw new InvalidParameterException("unknown opmode " + i10 + " passed");
                            } catch (Exception e10) {
                                throw new InvalidKeyException(e10.getMessage());
                            }
                        }
                    }
                }
                this.cipher.init(false, parametersWithIV);
                return;
            }
            this.cipher.init(true, parametersWithIV);
            return;
        }
        throw new InvalidKeyException("Key for algorithm " + key.getAlgorithm() + " not suitable for symmetric enryption.");
    }

    /* access modifiers changed from: protected */
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        if (!str.equalsIgnoreCase("ECB") && !str.equals("NONE")) {
            throw new NoSuchAlgorithmException("can't support mode " + str);
        }
    }

    /* access modifiers changed from: protected */
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        if (!str.equalsIgnoreCase("NoPadding")) {
            throw new NoSuchPaddingException("Padding " + str + " unknown.");
        }
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException {
        if (i12 + i11 <= bArr2.length) {
            try {
                this.cipher.processBytes(bArr, i10, i11, bArr2, i12);
                return i11;
            } catch (DataLengthException e10) {
                throw new IllegalStateException(e10.getMessage());
            }
        } else {
            throw new ShortBufferException("output buffer too short for input.");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        this.cipher.processBytes(bArr, i10, i11, bArr2, 0);
        return bArr2;
    }
}
