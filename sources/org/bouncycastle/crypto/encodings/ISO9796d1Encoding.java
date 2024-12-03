package org.bouncycastle.crypto.encodings;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class ISO9796d1Encoding implements AsymmetricBlockCipher {
    private static final BigInteger SIX = BigInteger.valueOf(6);
    private static final BigInteger SIXTEEN = BigInteger.valueOf(16);
    private static byte[] inverse = {8, 15, 6, 1, 5, 2, 11, 12, 3, 4, 13, 10, 14, 9, 0, 7};
    private static byte[] shadows = {14, 3, 5, 8, 9, 4, 2, 15, 0, 13, 11, 6, 7, 10, 12, 1};
    private int bitSize;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private BigInteger modulus;
    private int padBits = 0;

    public ISO9796d1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.engine = asymmetricBlockCipher;
    }

    private static byte[] convertOutputDecryptOnly(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] != 0) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    private byte[] decodeBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte[] processBlock = this.engine.processBlock(bArr, i10, i11);
        int i12 = (this.bitSize + 13) / 16;
        BigInteger bigInteger = new BigInteger(1, processBlock);
        BigInteger bigInteger2 = SIXTEEN;
        BigInteger mod = bigInteger.mod(bigInteger2);
        BigInteger bigInteger3 = SIX;
        if (!mod.equals(bigInteger3)) {
            if (this.modulus.subtract(bigInteger).mod(bigInteger2).equals(bigInteger3)) {
                bigInteger = this.modulus.subtract(bigInteger);
            } else {
                throw new InvalidCipherTextException("resulting integer iS or (modulus - iS) is not congruent to 6 mod 16");
            }
        }
        byte[] convertOutputDecryptOnly = convertOutputDecryptOnly(bigInteger);
        if ((convertOutputDecryptOnly[convertOutputDecryptOnly.length - 1] & 15) == 6) {
            convertOutputDecryptOnly[convertOutputDecryptOnly.length - 1] = (byte) (((convertOutputDecryptOnly[convertOutputDecryptOnly.length - 1] & 255) >>> 4) | (inverse[(convertOutputDecryptOnly[convertOutputDecryptOnly.length - 2] & 255) >> 4] << 4));
            byte[] bArr2 = shadows;
            byte b10 = convertOutputDecryptOnly[1];
            byte b11 = bArr2[b10 & 15];
            convertOutputDecryptOnly[0] = (byte) (b11 | (bArr2[(b10 & 255) >>> 4] << 4));
            byte b12 = 1;
            int i13 = 0;
            boolean z10 = false;
            for (int length = convertOutputDecryptOnly.length - 1; length >= convertOutputDecryptOnly.length - (i12 * 2); length -= 2) {
                byte[] bArr3 = shadows;
                byte b13 = convertOutputDecryptOnly[length];
                byte b14 = bArr3[b13 & 15] | (bArr3[(b13 & 255) >>> 4] << 4);
                int i14 = length - 1;
                byte b15 = convertOutputDecryptOnly[i14];
                if (((b15 ^ b14) & 255) != 0) {
                    if (!z10) {
                        b12 = (b15 ^ b14) & 255;
                        z10 = true;
                        i13 = i14;
                    } else {
                        throw new InvalidCipherTextException("invalid tsums in block");
                    }
                }
            }
            convertOutputDecryptOnly[i13] = 0;
            int length2 = (convertOutputDecryptOnly.length - i13) / 2;
            byte[] bArr4 = new byte[length2];
            for (int i15 = 0; i15 < length2; i15++) {
                bArr4[i15] = convertOutputDecryptOnly[(i15 * 2) + i13 + 1];
            }
            this.padBits = b12 - 1;
            return bArr4;
        }
        throw new InvalidCipherTextException("invalid forcing byte in block");
    }

    private byte[] encodeBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        int i12 = this.bitSize;
        int i13 = (i12 + 7) / 8;
        byte[] bArr2 = new byte[i13];
        int i14 = 1;
        int i15 = this.padBits + 1;
        int i16 = (i12 + 13) / 16;
        int i17 = 0;
        while (i17 < i16) {
            if (i17 > i16 - i11) {
                int i18 = i16 - i17;
                System.arraycopy(bArr, (i10 + i11) - i18, bArr2, i13 - i16, i18);
            } else {
                System.arraycopy(bArr, i10, bArr2, i13 - (i17 + i11), i11);
            }
            i17 += i11;
        }
        for (int i19 = i13 - (i16 * 2); i19 != i13; i19 += 2) {
            byte b10 = bArr2[(i13 - i16) + (i19 / 2)];
            byte[] bArr3 = shadows;
            bArr2[i19] = (byte) (bArr3[b10 & 15] | (bArr3[(b10 & 255) >>> 4] << 4));
            bArr2[i19 + 1] = b10;
        }
        int i20 = i13 - (i11 * 2);
        bArr2[i20] = (byte) (bArr2[i20] ^ i15);
        int i21 = i13 - 1;
        bArr2[i21] = (byte) ((bArr2[i21] << 4) | 6);
        int i22 = 8 - ((this.bitSize - 1) % 8);
        if (i22 != 8) {
            byte b11 = (byte) (bArr2[0] & (255 >>> i22));
            bArr2[0] = b11;
            bArr2[0] = (byte) ((128 >>> i22) | b11);
            i14 = 0;
        } else {
            bArr2[0] = 0;
            bArr2[1] = (byte) (bArr2[1] | 128);
        }
        return this.engine.processBlock(bArr2, i14, i13 - i14);
    }

    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? (inputBlockSize + 1) / 2 : inputBlockSize;
    }

    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : (outputBlockSize + 1) / 2;
    }

    public int getPadBits() {
        return this.padBits;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = cipherParameters instanceof ParametersWithRandom ? (RSAKeyParameters) ((ParametersWithRandom) cipherParameters).getParameters() : (RSAKeyParameters) cipherParameters;
        this.engine.init(z10, cipherParameters);
        BigInteger modulus2 = rSAKeyParameters.getModulus();
        this.modulus = modulus2;
        this.bitSize = modulus2.bitLength();
        this.forEncryption = z10;
    }

    public byte[] processBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        return this.forEncryption ? encodeBlock(bArr, i10, i11) : decodeBlock(bArr, i10, i11);
    }

    public void setPadBits(int i10) {
        if (i10 <= 7) {
            this.padBits = i10;
            return;
        }
        throw new IllegalArgumentException("padBits > 7");
    }
}
