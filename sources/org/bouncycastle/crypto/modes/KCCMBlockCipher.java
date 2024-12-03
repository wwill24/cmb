package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class KCCMBlockCipher implements AEADBlockCipher {
    private static final int BITS_IN_BYTE = 8;
    private static final int BYTES_IN_INT = 4;
    private static final int MAX_MAC_BIT_LENGTH = 512;
    private static final int MIN_MAC_BIT_LENGTH = 64;
    private byte[] G1;
    private int Nb_;
    private ExposedByteArrayOutputStream associatedText;
    private byte[] buffer;
    private byte[] counter;
    private ExposedByteArrayOutputStream data;
    private BlockCipher engine;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private byte[] mac;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonce;

    /* renamed from: s  reason: collision with root package name */
    private byte[] f41491s;

    private class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public ExposedByteArrayOutputStream() {
        }

        public byte[] getBuffer() {
            return this.buf;
        }
    }

    public KCCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, 4);
    }

    public KCCMBlockCipher(BlockCipher blockCipher, int i10) {
        this.associatedText = new ExposedByteArrayOutputStream();
        this.data = new ExposedByteArrayOutputStream();
        this.Nb_ = 4;
        this.engine = blockCipher;
        this.macSize = blockCipher.getBlockSize();
        this.nonce = new byte[blockCipher.getBlockSize()];
        this.initialAssociatedText = new byte[blockCipher.getBlockSize()];
        this.mac = new byte[blockCipher.getBlockSize()];
        this.macBlock = new byte[blockCipher.getBlockSize()];
        this.G1 = new byte[blockCipher.getBlockSize()];
        this.buffer = new byte[blockCipher.getBlockSize()];
        this.f41491s = new byte[blockCipher.getBlockSize()];
        this.counter = new byte[blockCipher.getBlockSize()];
        setNb(i10);
    }

    private void CalculateMac(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            for (int i12 = 0; i12 < this.engine.getBlockSize(); i12++) {
                byte[] bArr2 = this.macBlock;
                bArr2[i12] = (byte) (bArr2[i12] ^ bArr[i10 + i12]);
            }
            BlockCipher blockCipher = this.engine;
            byte[] bArr3 = this.macBlock;
            blockCipher.processBlock(bArr3, 0, bArr3, 0);
            i11 -= this.engine.getBlockSize();
            i10 += this.engine.getBlockSize();
        }
    }

    private void ProcessBlock(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        int i13 = 0;
        while (true) {
            byte[] bArr3 = this.counter;
            if (i13 >= bArr3.length) {
                break;
            }
            byte[] bArr4 = this.f41491s;
            bArr4[i13] = (byte) (bArr4[i13] + bArr3[i13]);
            i13++;
        }
        this.engine.processBlock(this.f41491s, 0, this.buffer, 0);
        for (int i14 = 0; i14 < this.engine.getBlockSize(); i14++) {
            bArr2[i12 + i14] = (byte) (this.buffer[i14] ^ bArr[i10 + i14]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047 A[LOOP:0: B:21:0x0040->B:23:0x0047, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte getFlag(boolean r4, int r5) {
        /*
            r3 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "0"
            if (r4 == 0) goto L_0x000f
            java.lang.String r4 = "1"
            r0.append(r4)
            goto L_0x0012
        L_0x000f:
            r0.append(r1)
        L_0x0012:
            r4 = 8
            if (r5 == r4) goto L_0x0033
            r4 = 16
            if (r5 == r4) goto L_0x0030
            r4 = 32
            if (r5 == r4) goto L_0x002d
            r4 = 48
            if (r5 == r4) goto L_0x002a
            r4 = 64
            if (r5 == r4) goto L_0x0027
            goto L_0x0038
        L_0x0027:
            java.lang.String r4 = "110"
            goto L_0x0035
        L_0x002a:
            java.lang.String r4 = "101"
            goto L_0x0035
        L_0x002d:
            java.lang.String r4 = "100"
            goto L_0x0035
        L_0x0030:
            java.lang.String r4 = "011"
            goto L_0x0035
        L_0x0033:
            java.lang.String r4 = "010"
        L_0x0035:
            r0.append(r4)
        L_0x0038:
            int r4 = r3.Nb_
            int r4 = r4 + -1
            java.lang.String r4 = java.lang.Integer.toBinaryString(r4)
        L_0x0040:
            int r5 = r4.length()
            r2 = 4
            if (r5 >= r2) goto L_0x0056
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            r5.<init>(r4)
            r4 = 0
            java.lang.StringBuffer r4 = r5.insert(r4, r1)
            java.lang.String r4 = r4.toString()
            goto L_0x0040
        L_0x0056:
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5 = 2
            int r4 = java.lang.Integer.parseInt(r4, r5)
            byte r4 = (byte) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.modes.KCCMBlockCipher.getFlag(boolean, int):byte");
    }

    private void intToBytes(int i10, byte[] bArr, int i11) {
        bArr[i11 + 3] = (byte) (i10 >> 24);
        bArr[i11 + 2] = (byte) (i10 >> 16);
        bArr[i11 + 1] = (byte) (i10 >> 8);
        bArr[i11] = (byte) i10;
    }

    private void processAAD(byte[] bArr, int i10, int i11, int i12) {
        if (i11 - i10 < this.engine.getBlockSize()) {
            throw new IllegalArgumentException("authText buffer too short");
        } else if (i11 % this.engine.getBlockSize() == 0) {
            byte[] bArr2 = this.nonce;
            System.arraycopy(bArr2, 0, this.G1, 0, (bArr2.length - this.Nb_) - 1);
            intToBytes(i12, this.buffer, 0);
            System.arraycopy(this.buffer, 0, this.G1, (this.nonce.length - this.Nb_) - 1, 4);
            byte[] bArr3 = this.G1;
            bArr3[bArr3.length - 1] = getFlag(true, this.macSize);
            this.engine.processBlock(this.G1, 0, this.macBlock, 0);
            intToBytes(i11, this.buffer, 0);
            if (i11 <= this.engine.getBlockSize() - this.Nb_) {
                for (int i13 = 0; i13 < i11; i13++) {
                    byte[] bArr4 = this.buffer;
                    int i14 = this.Nb_ + i13;
                    bArr4[i14] = (byte) (bArr4[i14] ^ bArr[i10 + i13]);
                }
                for (int i15 = 0; i15 < this.engine.getBlockSize(); i15++) {
                    byte[] bArr5 = this.macBlock;
                    bArr5[i15] = (byte) (bArr5[i15] ^ this.buffer[i15]);
                }
                BlockCipher blockCipher = this.engine;
                byte[] bArr6 = this.macBlock;
                blockCipher.processBlock(bArr6, 0, bArr6, 0);
                return;
            }
            for (int i16 = 0; i16 < this.engine.getBlockSize(); i16++) {
                byte[] bArr7 = this.macBlock;
                bArr7[i16] = (byte) (bArr7[i16] ^ this.buffer[i16]);
            }
            BlockCipher blockCipher2 = this.engine;
            byte[] bArr8 = this.macBlock;
            blockCipher2.processBlock(bArr8, 0, bArr8, 0);
            while (i11 != 0) {
                for (int i17 = 0; i17 < this.engine.getBlockSize(); i17++) {
                    byte[] bArr9 = this.macBlock;
                    bArr9[i17] = (byte) (bArr9[i17] ^ bArr[i17 + i10]);
                }
                BlockCipher blockCipher3 = this.engine;
                byte[] bArr10 = this.macBlock;
                blockCipher3.processBlock(bArr10, 0, bArr10, 0);
                i10 += this.engine.getBlockSize();
                i11 -= this.engine.getBlockSize();
            }
        } else {
            throw new IllegalArgumentException("padding not supported");
        }
    }

    private void setNb(int i10) {
        if (i10 == 4 || i10 == 6 || i10 == 8) {
            this.Nb_ = i10;
            return;
        }
        throw new IllegalArgumentException("Nb = 4 is recommended by DSTU7624 but can be changed to only 6 or 8 in this implementation");
    }

    public int doFinal(byte[] bArr, int i10) throws IllegalStateException, InvalidCipherTextException {
        int processPacket = processPacket(this.data.getBuffer(), 0, this.data.size(), bArr, i10);
        reset();
        return processPacket;
    }

    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KCCM";
    }

    public byte[] getMac() {
        return Arrays.clone(this.mac);
    }

    public int getOutputSize(int i10) {
        return i10 + this.macSize;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public int getUpdateOutputSize(int i10) {
        return i10;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            if (aEADParameters.getMacSize() > 512 || aEADParameters.getMacSize() < 64 || aEADParameters.getMacSize() % 8 != 0) {
                throw new IllegalArgumentException("Invalid mac size specified");
            }
            this.nonce = aEADParameters.getNonce();
            this.macSize = aEADParameters.getMacSize() / 8;
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            cipherParameters2 = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.nonce = parametersWithIV.getIV();
            this.macSize = this.engine.getBlockSize();
            this.initialAssociatedText = null;
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Invalid parameters specified");
        }
        this.mac = new byte[this.macSize];
        this.forEncryption = z10;
        this.engine.init(true, cipherParameters2);
        this.counter[0] = 1;
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }

    public void processAADByte(byte b10) {
        this.associatedText.write(b10);
    }

    public void processAADBytes(byte[] bArr, int i10, int i11) {
        this.associatedText.write(bArr, i10, i11);
    }

    public int processByte(byte b10, byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        this.data.write(b10);
        return 0;
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i10 + i11) {
            this.data.write(bArr, i10, i11);
            return 0;
        }
        throw new DataLengthException("input buffer too short");
    }

    public int processPacket(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IllegalStateException, InvalidCipherTextException {
        int i13;
        if (bArr.length - i10 < i11) {
            throw new DataLengthException("input buffer too short");
        } else if (bArr2.length - i12 >= i11) {
            if (this.associatedText.size() > 0) {
                if (this.forEncryption) {
                    processAAD(this.associatedText.getBuffer(), 0, this.associatedText.size(), this.data.size());
                } else {
                    processAAD(this.associatedText.getBuffer(), 0, this.associatedText.size(), this.data.size() - this.macSize);
                }
            }
            if (this.forEncryption) {
                if (i11 % this.engine.getBlockSize() == 0) {
                    CalculateMac(bArr, i10, i11);
                    this.engine.processBlock(this.nonce, 0, this.f41491s, 0);
                    int i14 = i11;
                    while (i14 > 0) {
                        ProcessBlock(bArr, i10, i11, bArr2, i12);
                        i14 -= this.engine.getBlockSize();
                        i10 += this.engine.getBlockSize();
                        i12 += this.engine.getBlockSize();
                    }
                    int i15 = 0;
                    while (true) {
                        byte[] bArr3 = this.counter;
                        if (i15 >= bArr3.length) {
                            break;
                        }
                        byte[] bArr4 = this.f41491s;
                        bArr4[i15] = (byte) (bArr4[i15] + bArr3[i15]);
                        i15++;
                    }
                    this.engine.processBlock(this.f41491s, 0, this.buffer, 0);
                    int i16 = 0;
                    while (true) {
                        int i17 = this.macSize;
                        if (i16 < i17) {
                            bArr2[i12 + i16] = (byte) (this.buffer[i16] ^ this.macBlock[i16]);
                            i16++;
                        } else {
                            System.arraycopy(this.macBlock, 0, this.mac, 0, i17);
                            reset();
                            return i11 + this.macSize;
                        }
                    }
                } else {
                    throw new DataLengthException("partial blocks not supported");
                }
            } else if ((i11 - this.macSize) % this.engine.getBlockSize() == 0) {
                this.engine.processBlock(this.nonce, 0, this.f41491s, 0);
                int blockSize = i11 / this.engine.getBlockSize();
                for (int i18 = 0; i18 < blockSize; i18++) {
                    ProcessBlock(bArr, i10, i11, bArr2, i12);
                    i10 += this.engine.getBlockSize();
                    i12 += this.engine.getBlockSize();
                }
                if (i11 > i10) {
                    int i19 = 0;
                    while (true) {
                        byte[] bArr5 = this.counter;
                        if (i19 >= bArr5.length) {
                            break;
                        }
                        byte[] bArr6 = this.f41491s;
                        bArr6[i19] = (byte) (bArr6[i19] + bArr5[i19]);
                        i19++;
                    }
                    this.engine.processBlock(this.f41491s, 0, this.buffer, 0);
                    int i20 = 0;
                    while (true) {
                        i13 = this.macSize;
                        if (i20 >= i13) {
                            break;
                        }
                        bArr2[i12 + i20] = (byte) (this.buffer[i20] ^ bArr[i10 + i20]);
                        i20++;
                    }
                    i12 += i13;
                }
                int i21 = 0;
                while (true) {
                    byte[] bArr7 = this.counter;
                    if (i21 >= bArr7.length) {
                        break;
                    }
                    byte[] bArr8 = this.f41491s;
                    bArr8[i21] = (byte) (bArr8[i21] + bArr7[i21]);
                    i21++;
                }
                this.engine.processBlock(this.f41491s, 0, this.buffer, 0);
                int i22 = this.macSize;
                System.arraycopy(bArr2, i12 - i22, this.buffer, 0, i22);
                CalculateMac(bArr2, 0, i12 - this.macSize);
                System.arraycopy(this.macBlock, 0, this.mac, 0, this.macSize);
                int i23 = this.macSize;
                byte[] bArr9 = new byte[i23];
                System.arraycopy(this.buffer, 0, bArr9, 0, i23);
                if (Arrays.constantTimeAreEqual(this.mac, bArr9)) {
                    reset();
                    return i11 - this.macSize;
                }
                throw new InvalidCipherTextException("mac check failed");
            } else {
                throw new DataLengthException("partial blocks not supported");
            }
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        Arrays.fill(this.G1, (byte) 0);
        Arrays.fill(this.buffer, (byte) 0);
        Arrays.fill(this.counter, (byte) 0);
        Arrays.fill(this.macBlock, (byte) 0);
        this.counter[0] = 1;
        this.data.reset();
        this.associatedText.reset();
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}
