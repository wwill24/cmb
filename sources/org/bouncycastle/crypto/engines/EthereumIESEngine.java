package org.bouncycastle.crypto.engines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.DigestDerivationFunction;
import org.bouncycastle.crypto.EphemeralKeyPair;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.IESParameters;
import org.bouncycastle.crypto.params.IESWithCipherParameters;
import org.bouncycastle.crypto.params.ISO18033KDFParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Pack;

public class EthereumIESEngine {
    private byte[] IV;
    byte[] V;
    BasicAgreement agree;
    BufferedBlockCipher cipher;
    byte[] commonMac;
    boolean forEncryption;
    DerivationFunction kdf;
    private EphemeralKeyPairGenerator keyPairGenerator;
    private KeyParser keyParser;
    Mac mac;
    byte[] macBuf;
    IESParameters param;
    CipherParameters privParam;
    CipherParameters pubParam;

    public static class HandshakeKDFFunction implements DigestDerivationFunction {
        private int counterStart;
        private Digest digest;
        private byte[] iv;
        private byte[] shared;

        public HandshakeKDFFunction(int i10, Digest digest2) {
            this.counterStart = i10;
            this.digest = digest2;
        }

        public int generateBytes(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
            byte[] bArr2 = bArr;
            int i12 = i11;
            int i13 = i10;
            if (bArr2.length - i12 >= i13) {
                long j10 = (long) i12;
                int digestSize = this.digest.getDigestSize();
                if (j10 <= 8589934591L) {
                    long j11 = (long) digestSize;
                    int i14 = (int) (((j10 + j11) - 1) / j11);
                    byte[] bArr3 = new byte[this.digest.getDigestSize()];
                    int i15 = 4;
                    byte[] bArr4 = new byte[4];
                    Pack.intToBigEndian(this.counterStart, bArr4, 0);
                    int i16 = this.counterStart & -256;
                    int i17 = 0;
                    while (i17 < i14) {
                        this.digest.update(bArr4, 0, i15);
                        Digest digest2 = this.digest;
                        byte[] bArr5 = this.shared;
                        digest2.update(bArr5, 0, bArr5.length);
                        byte[] bArr6 = this.iv;
                        if (bArr6 != null) {
                            this.digest.update(bArr6, 0, bArr6.length);
                        }
                        this.digest.doFinal(bArr3, 0);
                        if (i12 > digestSize) {
                            System.arraycopy(bArr3, 0, bArr2, i13, digestSize);
                            i13 += digestSize;
                            i12 -= digestSize;
                        } else {
                            System.arraycopy(bArr3, 0, bArr2, i13, i12);
                        }
                        byte b10 = (byte) (bArr4[3] + 1);
                        bArr4[3] = b10;
                        if (b10 == 0) {
                            i16 += 256;
                            Pack.intToBigEndian(i16, bArr4, 0);
                        }
                        i17++;
                        i15 = 4;
                    }
                    this.digest.reset();
                    return (int) j10;
                }
                throw new IllegalArgumentException("output length too large");
            }
            throw new OutputLengthException("output buffer too small");
        }

        public Digest getDigest() {
            return this.digest;
        }

        public void init(DerivationParameters derivationParameters) {
            if (derivationParameters instanceof KDFParameters) {
                KDFParameters kDFParameters = (KDFParameters) derivationParameters;
                this.shared = kDFParameters.getSharedSecret();
                this.iv = kDFParameters.getIV();
            } else if (derivationParameters instanceof ISO18033KDFParameters) {
                this.shared = ((ISO18033KDFParameters) derivationParameters).getSeed();
                this.iv = null;
            } else {
                throw new IllegalArgumentException("KDF parameters required for generator");
            }
        }
    }

    public EthereumIESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac2, byte[] bArr) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac2;
        this.macBuf = new byte[mac2.getMacSize()];
        this.commonMac = bArr;
        this.cipher = null;
    }

    public EthereumIESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac2, byte[] bArr, BufferedBlockCipher bufferedBlockCipher) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac2;
        this.macBuf = new byte[mac2.getMacSize()];
        this.commonMac = bArr;
        this.cipher = bufferedBlockCipher;
    }

    private byte[] decryptBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        int i12;
        if (i11 >= this.V.length + this.mac.getMacSize()) {
            if (this.cipher == null) {
                int length = (i11 - this.V.length) - this.mac.getMacSize();
                byte[] bArr4 = new byte[length];
                int macKeySize = this.param.getMacKeySize() / 8;
                bArr2 = new byte[macKeySize];
                int i13 = length + macKeySize;
                byte[] bArr5 = new byte[i13];
                this.kdf.generateBytes(bArr5, 0, i13);
                if (this.V.length != 0) {
                    System.arraycopy(bArr5, 0, bArr2, 0, macKeySize);
                    System.arraycopy(bArr5, macKeySize, bArr4, 0, length);
                } else {
                    System.arraycopy(bArr5, 0, bArr4, 0, length);
                    System.arraycopy(bArr5, length, bArr2, 0, macKeySize);
                }
                bArr3 = new byte[length];
                for (int i14 = 0; i14 != length; i14++) {
                    bArr3[i14] = (byte) (bArr[(this.V.length + i10) + i14] ^ bArr4[i14]);
                }
                i12 = 0;
            } else {
                int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
                byte[] bArr6 = new byte[cipherKeySize];
                int macKeySize2 = this.param.getMacKeySize() / 8;
                bArr2 = new byte[macKeySize2];
                int i15 = cipherKeySize + macKeySize2;
                byte[] bArr7 = new byte[i15];
                this.kdf.generateBytes(bArr7, 0, i15);
                System.arraycopy(bArr7, 0, bArr6, 0, cipherKeySize);
                System.arraycopy(bArr7, cipherKeySize, bArr2, 0, macKeySize2);
                CipherParameters keyParameter = new KeyParameter(bArr6);
                byte[] bArr8 = this.IV;
                if (bArr8 != null) {
                    keyParameter = new ParametersWithIV(keyParameter, bArr8);
                }
                this.cipher.init(false, keyParameter);
                bArr3 = new byte[this.cipher.getOutputSize((i11 - this.V.length) - this.mac.getMacSize())];
                BufferedBlockCipher bufferedBlockCipher = this.cipher;
                byte[] bArr9 = this.V;
                i12 = bufferedBlockCipher.processBytes(bArr, i10 + bArr9.length, (i11 - bArr9.length) - this.mac.getMacSize(), bArr3, 0);
            }
            byte[] encodingV = this.param.getEncodingV();
            byte[] bArr10 = null;
            if (this.V.length != 0) {
                bArr10 = getLengthTag(encodingV);
            }
            int i16 = i10 + i11;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i16 - this.mac.getMacSize(), i16);
            int length2 = copyOfRange.length;
            byte[] bArr11 = new byte[length2];
            SHA256Digest sHA256Digest = new SHA256Digest();
            byte[] bArr12 = new byte[sHA256Digest.getDigestSize()];
            sHA256Digest.reset();
            sHA256Digest.update(bArr2, 0, bArr2.length);
            sHA256Digest.doFinal(bArr12, 0);
            this.mac.init(new KeyParameter(bArr12));
            Mac mac2 = this.mac;
            byte[] bArr13 = this.IV;
            mac2.update(bArr13, 0, bArr13.length);
            Mac mac3 = this.mac;
            byte[] bArr14 = this.V;
            mac3.update(bArr, i10 + bArr14.length, (i11 - bArr14.length) - length2);
            if (encodingV != null) {
                this.mac.update(encodingV, 0, encodingV.length);
            }
            if (this.V.length != 0) {
                this.mac.update(bArr10, 0, bArr10.length);
            }
            Mac mac4 = this.mac;
            byte[] bArr15 = this.commonMac;
            mac4.update(bArr15, 0, bArr15.length);
            this.mac.doFinal(bArr11, 0);
            if (Arrays.constantTimeAreEqual(copyOfRange, bArr11)) {
                BufferedBlockCipher bufferedBlockCipher2 = this.cipher;
                return bufferedBlockCipher2 == null ? bArr3 : Arrays.copyOfRange(bArr3, 0, i12 + bufferedBlockCipher2.doFinal(bArr3, i12));
            }
            throw new InvalidCipherTextException("invalid MAC");
        }
        throw new InvalidCipherTextException("length of input must be greater than the MAC and V combined");
    }

    private byte[] encryptBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        CipherParameters cipherParameters;
        BufferedBlockCipher bufferedBlockCipher;
        if (this.cipher == null) {
            byte[] bArr4 = new byte[i11];
            int macKeySize = this.param.getMacKeySize() / 8;
            bArr2 = new byte[macKeySize];
            int i12 = i11 + macKeySize;
            byte[] bArr5 = new byte[i12];
            this.kdf.generateBytes(bArr5, 0, i12);
            if (this.V.length != 0) {
                System.arraycopy(bArr5, 0, bArr2, 0, macKeySize);
                System.arraycopy(bArr5, macKeySize, bArr4, 0, i11);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, i11);
                System.arraycopy(bArr5, i11, bArr2, 0, macKeySize);
            }
            bArr3 = new byte[i11];
            for (int i13 = 0; i13 != i11; i13++) {
                bArr3[i13] = (byte) (bArr[i10 + i13] ^ bArr4[i13]);
            }
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
            byte[] bArr6 = new byte[cipherKeySize];
            int macKeySize2 = this.param.getMacKeySize() / 8;
            byte[] bArr7 = new byte[macKeySize2];
            int i14 = cipherKeySize + macKeySize2;
            byte[] bArr8 = new byte[i14];
            this.kdf.generateBytes(bArr8, 0, i14);
            System.arraycopy(bArr8, 0, bArr6, 0, cipherKeySize);
            System.arraycopy(bArr8, cipherKeySize, bArr7, 0, macKeySize2);
            if (this.IV != null) {
                bufferedBlockCipher = this.cipher;
                cipherParameters = new ParametersWithIV(new KeyParameter(bArr6), this.IV);
            } else {
                bufferedBlockCipher = this.cipher;
                cipherParameters = new KeyParameter(bArr6);
            }
            bufferedBlockCipher.init(true, cipherParameters);
            bArr3 = new byte[this.cipher.getOutputSize(i11)];
            int processBytes = this.cipher.processBytes(bArr, i10, i11, bArr3, 0);
            i11 = processBytes + this.cipher.doFinal(bArr3, processBytes);
            bArr2 = bArr7;
        }
        byte[] encodingV = this.param.getEncodingV();
        byte[] bArr9 = null;
        if (this.V.length != 0) {
            bArr9 = getLengthTag(encodingV);
        }
        int macSize = this.mac.getMacSize();
        byte[] bArr10 = new byte[macSize];
        SHA256Digest sHA256Digest = new SHA256Digest();
        byte[] bArr11 = new byte[sHA256Digest.getDigestSize()];
        sHA256Digest.reset();
        sHA256Digest.update(bArr2, 0, bArr2.length);
        sHA256Digest.doFinal(bArr11, 0);
        this.mac.init(new KeyParameter(bArr11));
        Mac mac2 = this.mac;
        byte[] bArr12 = this.IV;
        mac2.update(bArr12, 0, bArr12.length);
        this.mac.update(bArr3, 0, bArr3.length);
        if (encodingV != null) {
            this.mac.update(encodingV, 0, encodingV.length);
        }
        if (this.V.length != 0) {
            this.mac.update(bArr9, 0, bArr9.length);
        }
        Mac mac3 = this.mac;
        byte[] bArr13 = this.commonMac;
        mac3.update(bArr13, 0, bArr13.length);
        this.mac.doFinal(bArr10, 0);
        byte[] bArr14 = this.V;
        byte[] bArr15 = new byte[(bArr14.length + i11 + macSize)];
        System.arraycopy(bArr14, 0, bArr15, 0, bArr14.length);
        System.arraycopy(bArr3, 0, bArr15, this.V.length, i11);
        System.arraycopy(bArr10, 0, bArr15, this.V.length + i11, macSize);
        return bArr15;
    }

    private void extractParams(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.IV = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            this.IV = null;
        }
        this.param = (IESParameters) cipherParameters;
    }

    public BufferedBlockCipher getCipher() {
        return this.cipher;
    }

    /* access modifiers changed from: protected */
    public byte[] getLengthTag(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            Pack.longToBigEndian(((long) bArr.length) * 8, bArr2, 0);
        }
        return bArr2;
    }

    public Mac getMac() {
        return this.mac;
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, KeyParser keyParser2) {
        this.forEncryption = false;
        this.privParam = asymmetricKeyParameter;
        this.keyParser = keyParser2;
        extractParams(cipherParameters);
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, EphemeralKeyPairGenerator ephemeralKeyPairGenerator) {
        this.forEncryption = true;
        this.pubParam = asymmetricKeyParameter;
        this.keyPairGenerator = ephemeralKeyPairGenerator;
        extractParams(cipherParameters);
    }

    public void init(boolean z10, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.forEncryption = z10;
        this.privParam = cipherParameters;
        this.pubParam = cipherParameters2;
        this.V = new byte[0];
        extractParams(cipherParameters3);
    }

    public byte[] processBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.forEncryption) {
            EphemeralKeyPairGenerator ephemeralKeyPairGenerator = this.keyPairGenerator;
            if (ephemeralKeyPairGenerator != null) {
                EphemeralKeyPair generate = ephemeralKeyPairGenerator.generate();
                this.privParam = generate.getKeyPair().getPrivate();
                this.V = generate.getEncodedPublicKey();
            }
        } else if (this.keyParser != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i10, i11);
            try {
                this.pubParam = this.keyParser.readKey(byteArrayInputStream);
                this.V = Arrays.copyOfRange(bArr, i10, (i11 - byteArrayInputStream.available()) + i10);
            } catch (IOException e10) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e10.getMessage(), e10);
            } catch (IllegalArgumentException e11) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e11.getMessage(), e11);
            }
        }
        this.agree.init(this.privParam);
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.agree.getFieldSize(), this.agree.calculateAgreement(this.pubParam));
        byte[] bArr2 = this.V;
        if (bArr2.length != 0) {
            byte[] concatenate = Arrays.concatenate(bArr2, asUnsignedByteArray);
            Arrays.fill(asUnsignedByteArray, (byte) 0);
            asUnsignedByteArray = concatenate;
        }
        try {
            this.kdf.init(new KDFParameters(asUnsignedByteArray, this.param.getDerivationV()));
            return this.forEncryption ? encryptBlock(bArr, i10, i11) : decryptBlock(bArr, i10, i11);
        } finally {
            Arrays.fill(asUnsignedByteArray, (byte) 0);
        }
    }
}
