package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.modes.gcm.BasicGCMExponentiator;
import org.bouncycastle.crypto.modes.gcm.GCMExponentiator;
import org.bouncycastle.crypto.modes.gcm.GCMMultiplier;
import org.bouncycastle.crypto.modes.gcm.GCMUtil;
import org.bouncycastle.crypto.modes.gcm.Tables4kGCMMultiplier;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class GCMBlockCipher implements AEADBlockCipher {
    private static final int BLOCK_SIZE = 16;
    private byte[] H;
    private byte[] J0;
    private byte[] S;
    private byte[] S_at;
    private byte[] S_atPre;
    private byte[] atBlock;
    private int atBlockPos;
    private long atLength;
    private long atLengthPre;
    private int blocksRemaining;
    private byte[] bufBlock;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] counter;
    private GCMExponentiator exp;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private boolean initialised;
    private byte[] lastKey;
    private byte[] macBlock;
    private int macSize;
    private GCMMultiplier multiplier;
    private byte[] nonce;
    private long totalLength;

    public GCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, (GCMMultiplier) null);
    }

    public GCMBlockCipher(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        if (blockCipher.getBlockSize() == 16) {
            gCMMultiplier = gCMMultiplier == null ? new Tables4kGCMMultiplier() : gCMMultiplier;
            this.cipher = blockCipher;
            this.multiplier = gCMMultiplier;
            return;
        }
        throw new IllegalArgumentException("cipher required with a block size of 16.");
    }

    private void checkStatus() {
        if (this.initialised) {
            return;
        }
        if (this.forEncryption) {
            throw new IllegalStateException("GCM cipher cannot be reused for encryption");
        }
        throw new IllegalStateException("GCM cipher needs to be initialised");
    }

    private void gHASH(byte[] bArr, byte[] bArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11 += 16) {
            gHASHPartial(bArr, bArr2, i11, Math.min(i10 - i11, 16));
        }
    }

    private void gHASHBlock(byte[] bArr, byte[] bArr2) {
        GCMUtil.xor(bArr, bArr2);
        this.multiplier.multiplyH(bArr);
    }

    private void gHASHBlock(byte[] bArr, byte[] bArr2, int i10) {
        GCMUtil.xor(bArr, bArr2, i10);
        this.multiplier.multiplyH(bArr);
    }

    private void gHASHPartial(byte[] bArr, byte[] bArr2, int i10, int i11) {
        GCMUtil.xor(bArr, bArr2, i10, i11);
        this.multiplier.multiplyH(bArr);
    }

    private void getNextCTRBlock(byte[] bArr) {
        int i10 = this.blocksRemaining;
        if (i10 != 0) {
            this.blocksRemaining = i10 - 1;
            byte[] bArr2 = this.counter;
            int i11 = (bArr2[15] & 255) + 1;
            bArr2[15] = (byte) i11;
            int i12 = (i11 >>> 8) + (bArr2[14] & 255);
            bArr2[14] = (byte) i12;
            int i13 = (i12 >>> 8) + (bArr2[13] & 255);
            bArr2[13] = (byte) i13;
            bArr2[12] = (byte) ((i13 >>> 8) + (bArr2[12] & 255));
            this.cipher.processBlock(bArr2, 0, bArr, 0);
            return;
        }
        throw new IllegalStateException("Attempt to process too many blocks");
    }

    private void initCipher() {
        if (this.atLength > 0) {
            System.arraycopy(this.S_at, 0, this.S_atPre, 0, 16);
            this.atLengthPre = this.atLength;
        }
        int i10 = this.atBlockPos;
        if (i10 > 0) {
            gHASHPartial(this.S_atPre, this.atBlock, 0, i10);
            this.atLengthPre += (long) this.atBlockPos;
        }
        if (this.atLengthPre > 0) {
            System.arraycopy(this.S_atPre, 0, this.S, 0, 16);
        }
    }

    private void processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (bArr2.length - i11 >= 16) {
            if (this.totalLength == 0) {
                initCipher();
            }
            byte[] bArr3 = new byte[16];
            getNextCTRBlock(bArr3);
            if (this.forEncryption) {
                GCMUtil.xor(bArr3, bArr, i10);
                gHASHBlock(this.S, bArr3);
                System.arraycopy(bArr3, 0, bArr2, i11, 16);
            } else {
                gHASHBlock(this.S, bArr, i10);
                GCMUtil.xor(bArr3, 0, bArr, i10, bArr2, i11);
            }
            this.totalLength += 16;
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    private void processPartial(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = new byte[16];
        getNextCTRBlock(bArr3);
        if (this.forEncryption) {
            GCMUtil.xor(bArr, i10, bArr3, 0, i11);
            gHASHPartial(this.S, bArr, i10, i11);
        } else {
            gHASHPartial(this.S, bArr, i10, i11);
            GCMUtil.xor(bArr, i10, bArr3, 0, i11);
        }
        System.arraycopy(bArr, i10, bArr2, i12, i11);
        this.totalLength += (long) i11;
    }

    private void reset(boolean z10) {
        this.cipher.reset();
        this.S = new byte[16];
        this.S_at = new byte[16];
        this.S_atPre = new byte[16];
        this.atBlock = new byte[16];
        this.atBlockPos = 0;
        this.atLength = 0;
        this.atLengthPre = 0;
        this.counter = Arrays.clone(this.J0);
        this.blocksRemaining = -2;
        this.bufOff = 0;
        this.totalLength = 0;
        byte[] bArr = this.bufBlock;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
        if (z10) {
            this.macBlock = null;
        }
        if (this.forEncryption) {
            this.initialised = false;
            return;
        }
        byte[] bArr2 = this.initialAssociatedText;
        if (bArr2 != null) {
            processAADBytes(bArr2, 0, bArr2.length);
        }
    }

    public int doFinal(byte[] bArr, int i10) throws IllegalStateException, InvalidCipherTextException {
        checkStatus();
        if (this.totalLength == 0) {
            initCipher();
        }
        int i11 = this.bufOff;
        if (!this.forEncryption) {
            int i12 = this.macSize;
            if (i11 >= i12) {
                i11 -= i12;
                if (bArr.length - i10 < i11) {
                    throw new OutputLengthException("Output buffer too short");
                }
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        } else if (bArr.length - i10 < this.macSize + i11) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (i11 > 0) {
            processPartial(this.bufBlock, 0, i11, bArr, i10);
        }
        long j10 = this.atLength;
        int i13 = this.atBlockPos;
        long j11 = j10 + ((long) i13);
        this.atLength = j11;
        if (j11 > this.atLengthPre) {
            if (i13 > 0) {
                gHASHPartial(this.S_at, this.atBlock, 0, i13);
            }
            if (this.atLengthPre > 0) {
                GCMUtil.xor(this.S_at, this.S_atPre);
            }
            long j12 = ((this.totalLength * 8) + 127) >>> 7;
            byte[] bArr2 = new byte[16];
            if (this.exp == null) {
                BasicGCMExponentiator basicGCMExponentiator = new BasicGCMExponentiator();
                this.exp = basicGCMExponentiator;
                basicGCMExponentiator.init(this.H);
            }
            this.exp.exponentiateX(j12, bArr2);
            GCMUtil.multiply(this.S_at, bArr2);
            GCMUtil.xor(this.S, this.S_at);
        }
        byte[] bArr3 = new byte[16];
        Pack.longToBigEndian(this.atLength * 8, bArr3, 0);
        Pack.longToBigEndian(this.totalLength * 8, bArr3, 8);
        gHASHBlock(this.S, bArr3);
        byte[] bArr4 = new byte[16];
        this.cipher.processBlock(this.J0, 0, bArr4, 0);
        GCMUtil.xor(bArr4, this.S);
        int i14 = this.macSize;
        byte[] bArr5 = new byte[i14];
        this.macBlock = bArr5;
        System.arraycopy(bArr4, 0, bArr5, 0, i14);
        if (this.forEncryption) {
            System.arraycopy(this.macBlock, 0, bArr, i10 + this.bufOff, this.macSize);
            i11 += this.macSize;
        } else {
            int i15 = this.macSize;
            byte[] bArr6 = new byte[i15];
            System.arraycopy(this.bufBlock, i11, bArr6, 0, i15);
            if (!Arrays.constantTimeAreEqual(this.macBlock, bArr6)) {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        reset(false);
        return i11;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/GCM";
    }

    public byte[] getMac() {
        byte[] bArr = this.macBlock;
        return bArr == null ? new byte[this.macSize] : Arrays.clone(bArr);
    }

    public int getOutputSize(int i10) {
        int i11 = i10 + this.bufOff;
        if (this.forEncryption) {
            return i11 + this.macSize;
        }
        int i12 = this.macSize;
        if (i11 < i12) {
            return 0;
        }
        return i11 - i12;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public int getUpdateOutputSize(int i10) {
        int i11 = i10 + this.bufOff;
        if (!this.forEncryption) {
            int i12 = this.macSize;
            if (i11 < i12) {
                return 0;
            }
            i11 -= i12;
        }
        return i11 - (i11 % 16);
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        byte[] bArr;
        byte[] bArr2;
        this.forEncryption = z10;
        this.macBlock = null;
        this.initialised = true;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize2 = aEADParameters.getMacSize();
            if (macSize2 < 32 || macSize2 > 128 || macSize2 % 8 != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize2);
            }
            this.macSize = macSize2 / 8;
            keyParameter = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = 16;
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to GCM");
        }
        this.bufBlock = new byte[(z10 ? 16 : this.macSize + 16)];
        if (bArr == null || bArr.length < 1) {
            throw new IllegalArgumentException("IV must be at least 1 byte");
        }
        if (z10 && (bArr2 = this.nonce) != null && Arrays.areEqual(bArr2, bArr)) {
            if (keyParameter != null) {
                byte[] bArr3 = this.lastKey;
                if (bArr3 != null && Arrays.areEqual(bArr3, keyParameter.getKey())) {
                    throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
                }
            } else {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
        }
        this.nonce = bArr;
        if (keyParameter != null) {
            this.lastKey = keyParameter.getKey();
        }
        if (keyParameter != null) {
            this.cipher.init(true, keyParameter);
            byte[] bArr4 = new byte[16];
            this.H = bArr4;
            this.cipher.processBlock(bArr4, 0, bArr4, 0);
            this.multiplier.init(this.H);
            this.exp = null;
        } else if (this.H == null) {
            throw new IllegalArgumentException("Key must be specified in initial init");
        }
        byte[] bArr5 = new byte[16];
        this.J0 = bArr5;
        byte[] bArr6 = this.nonce;
        if (bArr6.length == 12) {
            System.arraycopy(bArr6, 0, bArr5, 0, bArr6.length);
            this.J0[15] = 1;
        } else {
            gHASH(bArr5, bArr6, bArr6.length);
            byte[] bArr7 = new byte[16];
            Pack.longToBigEndian(((long) this.nonce.length) * 8, bArr7, 8);
            gHASHBlock(this.J0, bArr7);
        }
        this.S = new byte[16];
        this.S_at = new byte[16];
        this.S_atPre = new byte[16];
        this.atBlock = new byte[16];
        this.atBlockPos = 0;
        this.atLength = 0;
        this.atLengthPre = 0;
        this.counter = Arrays.clone(this.J0);
        this.blocksRemaining = -2;
        this.bufOff = 0;
        this.totalLength = 0;
        byte[] bArr8 = this.initialAssociatedText;
        if (bArr8 != null) {
            processAADBytes(bArr8, 0, bArr8.length);
        }
    }

    public void processAADByte(byte b10) {
        checkStatus();
        byte[] bArr = this.atBlock;
        int i10 = this.atBlockPos;
        bArr[i10] = b10;
        int i11 = i10 + 1;
        this.atBlockPos = i11;
        if (i11 == 16) {
            gHASHBlock(this.S_at, bArr);
            this.atBlockPos = 0;
            this.atLength += 16;
        }
    }

    public void processAADBytes(byte[] bArr, int i10, int i11) {
        checkStatus();
        for (int i12 = 0; i12 < i11; i12++) {
            byte[] bArr2 = this.atBlock;
            int i13 = this.atBlockPos;
            bArr2[i13] = bArr[i10 + i12];
            int i14 = i13 + 1;
            this.atBlockPos = i14;
            if (i14 == 16) {
                gHASHBlock(this.S_at, bArr2);
                this.atBlockPos = 0;
                this.atLength += 16;
            }
        }
    }

    public int processByte(byte b10, byte[] bArr, int i10) throws DataLengthException {
        checkStatus();
        byte[] bArr2 = this.bufBlock;
        int i11 = this.bufOff;
        bArr2[i11] = b10;
        int i12 = i11 + 1;
        this.bufOff = i12;
        if (i12 != bArr2.length) {
            return 0;
        }
        processBlock(bArr2, 0, bArr, i10);
        if (this.forEncryption) {
            this.bufOff = 0;
        } else {
            byte[] bArr3 = this.bufBlock;
            System.arraycopy(bArr3, 16, bArr3, 0, this.macSize);
            this.bufOff = this.macSize;
        }
        return 16;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:12:0x0031->B:13:0x0033, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int processBytes(byte[] r8, int r9, int r10, byte[] r11, int r12) throws org.bouncycastle.crypto.DataLengthException {
        /*
            r7 = this;
            r7.checkStatus()
            int r0 = r8.length
            int r0 = r0 - r9
            if (r0 < r10) goto L_0x0074
            boolean r0 = r7.forEncryption
            r1 = 16
            r2 = 0
            if (r0 == 0) goto L_0x0049
            int r0 = r7.bufOff
            if (r0 == 0) goto L_0x0030
        L_0x0012:
            if (r10 <= 0) goto L_0x0030
            int r10 = r10 + -1
            byte[] r0 = r7.bufBlock
            int r3 = r7.bufOff
            int r4 = r9 + 1
            byte r9 = r8[r9]
            r0[r3] = r9
            int r3 = r3 + 1
            r7.bufOff = r3
            if (r3 != r1) goto L_0x002e
            r7.processBlock(r0, r2, r11, r12)
            r7.bufOff = r2
            r0 = r1
            r9 = r4
            goto L_0x0031
        L_0x002e:
            r9 = r4
            goto L_0x0012
        L_0x0030:
            r0 = r2
        L_0x0031:
            if (r10 < r1) goto L_0x003f
            int r3 = r12 + r0
            r7.processBlock(r8, r9, r11, r3)
            int r9 = r9 + 16
            int r10 = r10 + -16
            int r0 = r0 + 16
            goto L_0x0031
        L_0x003f:
            if (r10 <= 0) goto L_0x0073
            byte[] r11 = r7.bufBlock
            java.lang.System.arraycopy(r8, r9, r11, r2, r10)
            r7.bufOff = r10
            goto L_0x0073
        L_0x0049:
            r0 = r2
            r3 = r0
        L_0x004b:
            if (r3 >= r10) goto L_0x0073
            byte[] r4 = r7.bufBlock
            int r5 = r7.bufOff
            int r6 = r9 + r3
            byte r6 = r8[r6]
            r4[r5] = r6
            int r5 = r5 + 1
            r7.bufOff = r5
            int r6 = r4.length
            if (r5 != r6) goto L_0x0070
            int r5 = r12 + r0
            r7.processBlock(r4, r2, r11, r5)
            byte[] r4 = r7.bufBlock
            int r5 = r7.macSize
            java.lang.System.arraycopy(r4, r1, r4, r2, r5)
            int r4 = r7.macSize
            r7.bufOff = r4
            int r0 = r0 + 16
        L_0x0070:
            int r3 = r3 + 1
            goto L_0x004b
        L_0x0073:
            return r0
        L_0x0074:
            org.bouncycastle.crypto.DataLengthException r8 = new org.bouncycastle.crypto.DataLengthException
            java.lang.String r9 = "Input buffer too short"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.modes.GCMBlockCipher.processBytes(byte[], int, int, byte[], int):int");
    }

    public void reset() {
        reset(true);
    }
}
