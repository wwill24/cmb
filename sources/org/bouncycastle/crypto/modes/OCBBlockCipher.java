package org.bouncycastle.crypto.modes;

import java.util.Vector;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class OCBBlockCipher implements AEADBlockCipher {
    private static final int BLOCK_SIZE = 16;
    private byte[] Checksum;
    private byte[] KtopInput = null;
    private Vector L;
    private byte[] L_Asterisk;
    private byte[] L_Dollar;
    private byte[] OffsetHASH;
    private byte[] OffsetMAIN = new byte[16];
    private byte[] OffsetMAIN_0 = new byte[16];
    private byte[] Stretch = new byte[24];
    private byte[] Sum;
    private boolean forEncryption;
    private byte[] hashBlock;
    private long hashBlockCount;
    private int hashBlockPos;
    private BlockCipher hashCipher;
    private byte[] initialAssociatedText;
    private byte[] macBlock;
    private int macSize;
    private byte[] mainBlock;
    private long mainBlockCount;
    private int mainBlockPos;
    private BlockCipher mainCipher;

    public OCBBlockCipher(BlockCipher blockCipher, BlockCipher blockCipher2) {
        if (blockCipher == null) {
            throw new IllegalArgumentException("'hashCipher' cannot be null");
        } else if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
        } else if (blockCipher2 == null) {
            throw new IllegalArgumentException("'mainCipher' cannot be null");
        } else if (blockCipher2.getBlockSize() != 16) {
            throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        } else if (blockCipher.getAlgorithmName().equals(blockCipher2.getAlgorithmName())) {
            this.hashCipher = blockCipher;
            this.mainCipher = blockCipher2;
        } else {
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
        }
    }

    protected static byte[] OCB_double(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) ((135 >>> ((1 - shiftLeft(bArr, bArr2)) << 3)) ^ bArr2[15]);
        return bArr2;
    }

    protected static void OCB_extend(byte[] bArr, int i10) {
        bArr[i10] = Byte.MIN_VALUE;
        while (true) {
            i10++;
            if (i10 < 16) {
                bArr[i10] = 0;
            } else {
                return;
            }
        }
    }

    protected static int OCB_ntz(long j10) {
        if (j10 == 0) {
            return 64;
        }
        int i10 = 0;
        while ((1 & j10) == 0) {
            i10++;
            j10 >>>= 1;
        }
        return i10;
    }

    protected static int shiftLeft(byte[] bArr, byte[] bArr2) {
        int i10 = 16;
        int i11 = 0;
        while (true) {
            i10--;
            if (i10 < 0) {
                return i11;
            }
            byte b10 = bArr[i10] & 255;
            bArr2[i10] = (byte) (i11 | (b10 << 1));
            i11 = (b10 >>> 7) & 1;
        }
    }

    protected static void xor(byte[] bArr, byte[] bArr2) {
        for (int i10 = 15; i10 >= 0; i10--) {
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
    }

    /* access modifiers changed from: protected */
    public void clear(byte[] bArr) {
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    public int doFinal(byte[] bArr, int i10) throws IllegalStateException, InvalidCipherTextException {
        byte[] bArr2;
        if (!this.forEncryption) {
            int i11 = this.mainBlockPos;
            int i12 = this.macSize;
            if (i11 >= i12) {
                int i13 = i11 - i12;
                this.mainBlockPos = i13;
                bArr2 = new byte[i12];
                System.arraycopy(this.mainBlock, i13, bArr2, 0, i12);
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        } else {
            bArr2 = null;
        }
        int i14 = this.hashBlockPos;
        if (i14 > 0) {
            OCB_extend(this.hashBlock, i14);
            updateHASH(this.L_Asterisk);
        }
        int i15 = this.mainBlockPos;
        if (i15 > 0) {
            if (this.forEncryption) {
                OCB_extend(this.mainBlock, i15);
                xor(this.Checksum, this.mainBlock);
            }
            xor(this.OffsetMAIN, this.L_Asterisk);
            byte[] bArr3 = new byte[16];
            this.hashCipher.processBlock(this.OffsetMAIN, 0, bArr3, 0);
            xor(this.mainBlock, bArr3);
            int length = bArr.length;
            int i16 = this.mainBlockPos;
            if (length >= i10 + i16) {
                System.arraycopy(this.mainBlock, 0, bArr, i10, i16);
                if (!this.forEncryption) {
                    OCB_extend(this.mainBlock, this.mainBlockPos);
                    xor(this.Checksum, this.mainBlock);
                }
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        }
        xor(this.Checksum, this.OffsetMAIN);
        xor(this.Checksum, this.L_Dollar);
        BlockCipher blockCipher = this.hashCipher;
        byte[] bArr4 = this.Checksum;
        blockCipher.processBlock(bArr4, 0, bArr4, 0);
        xor(this.Checksum, this.Sum);
        int i17 = this.macSize;
        byte[] bArr5 = new byte[i17];
        this.macBlock = bArr5;
        System.arraycopy(this.Checksum, 0, bArr5, 0, i17);
        int i18 = this.mainBlockPos;
        if (this.forEncryption) {
            int length2 = bArr.length;
            int i19 = i10 + i18;
            int i20 = this.macSize;
            if (length2 >= i19 + i20) {
                System.arraycopy(this.macBlock, 0, bArr, i19, i20);
                i18 += this.macSize;
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        } else if (!Arrays.constantTimeAreEqual(this.macBlock, bArr2)) {
            throw new InvalidCipherTextException("mac check in OCB failed");
        }
        reset(false);
        return i18;
    }

    public String getAlgorithmName() {
        return this.mainCipher.getAlgorithmName() + "/OCB";
    }

    /* access modifiers changed from: protected */
    public byte[] getLSub(int i10) {
        while (i10 >= this.L.size()) {
            Vector vector = this.L;
            vector.addElement(OCB_double((byte[]) vector.lastElement()));
        }
        return (byte[]) this.L.elementAt(i10);
    }

    public byte[] getMac() {
        byte[] bArr = this.macBlock;
        return bArr == null ? new byte[this.macSize] : Arrays.clone(bArr);
    }

    public int getOutputSize(int i10) {
        int i11 = i10 + this.mainBlockPos;
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
        return this.mainCipher;
    }

    public int getUpdateOutputSize(int i10) {
        int i11 = i10 + this.mainBlockPos;
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
        boolean z11 = this.forEncryption;
        this.forEncryption = z10;
        this.macBlock = null;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize2 = aEADParameters.getMacSize();
            if (macSize2 < 64 || macSize2 > 128 || macSize2 % 8 != 0) {
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
            throw new IllegalArgumentException("invalid parameters passed to OCB");
        }
        this.hashBlock = new byte[16];
        this.mainBlock = new byte[(z10 ? 16 : this.macSize + 16)];
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr.length <= 15) {
            if (keyParameter != null) {
                this.hashCipher.init(true, keyParameter);
                this.mainCipher.init(z10, keyParameter);
                this.KtopInput = null;
            } else if (z11 != z10) {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            }
            byte[] bArr2 = new byte[16];
            this.L_Asterisk = bArr2;
            this.hashCipher.processBlock(bArr2, 0, bArr2, 0);
            this.L_Dollar = OCB_double(this.L_Asterisk);
            Vector vector = new Vector();
            this.L = vector;
            vector.addElement(OCB_double(this.L_Dollar));
            int processNonce = processNonce(bArr);
            int i10 = processNonce % 8;
            int i11 = processNonce / 8;
            if (i10 == 0) {
                System.arraycopy(this.Stretch, i11, this.OffsetMAIN_0, 0, 16);
            } else {
                for (int i12 = 0; i12 < 16; i12++) {
                    byte[] bArr3 = this.Stretch;
                    i11++;
                    this.OffsetMAIN_0[i12] = (byte) (((bArr3[i11] & 255) >>> (8 - i10)) | ((bArr3[i11] & 255) << i10));
                }
            }
            this.hashBlockPos = 0;
            this.mainBlockPos = 0;
            this.hashBlockCount = 0;
            this.mainBlockCount = 0;
            this.OffsetHASH = new byte[16];
            this.Sum = new byte[16];
            System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
            this.Checksum = new byte[16];
            byte[] bArr4 = this.initialAssociatedText;
            if (bArr4 != null) {
                processAADBytes(bArr4, 0, bArr4.length);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("IV must be no more than 15 bytes");
    }

    public void processAADByte(byte b10) {
        byte[] bArr = this.hashBlock;
        int i10 = this.hashBlockPos;
        bArr[i10] = b10;
        int i11 = i10 + 1;
        this.hashBlockPos = i11;
        if (i11 == bArr.length) {
            processHashBlock();
        }
    }

    public void processAADBytes(byte[] bArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            byte[] bArr2 = this.hashBlock;
            int i13 = this.hashBlockPos;
            bArr2[i13] = bArr[i10 + i12];
            int i14 = i13 + 1;
            this.hashBlockPos = i14;
            if (i14 == bArr2.length) {
                processHashBlock();
            }
        }
    }

    public int processByte(byte b10, byte[] bArr, int i10) throws DataLengthException {
        byte[] bArr2 = this.mainBlock;
        int i11 = this.mainBlockPos;
        bArr2[i11] = b10;
        int i12 = i11 + 1;
        this.mainBlockPos = i12;
        if (i12 != bArr2.length) {
            return 0;
        }
        processMainBlock(bArr, i10);
        return 16;
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        if (bArr.length >= i10 + i11) {
            int i13 = 0;
            for (int i14 = 0; i14 < i11; i14++) {
                byte[] bArr3 = this.mainBlock;
                int i15 = this.mainBlockPos;
                bArr3[i15] = bArr[i10 + i14];
                int i16 = i15 + 1;
                this.mainBlockPos = i16;
                if (i16 == bArr3.length) {
                    processMainBlock(bArr2, i12 + i13);
                    i13 += 16;
                }
            }
            return i13;
        }
        throw new DataLengthException("Input buffer too short");
    }

    /* access modifiers changed from: protected */
    public void processHashBlock() {
        long j10 = this.hashBlockCount + 1;
        this.hashBlockCount = j10;
        updateHASH(getLSub(OCB_ntz(j10)));
        this.hashBlockPos = 0;
    }

    /* access modifiers changed from: protected */
    public void processMainBlock(byte[] bArr, int i10) {
        if (bArr.length >= i10 + 16) {
            if (this.forEncryption) {
                xor(this.Checksum, this.mainBlock);
                this.mainBlockPos = 0;
            }
            byte[] bArr2 = this.OffsetMAIN;
            long j10 = this.mainBlockCount + 1;
            this.mainBlockCount = j10;
            xor(bArr2, getLSub(OCB_ntz(j10)));
            xor(this.mainBlock, this.OffsetMAIN);
            BlockCipher blockCipher = this.mainCipher;
            byte[] bArr3 = this.mainBlock;
            blockCipher.processBlock(bArr3, 0, bArr3, 0);
            xor(this.mainBlock, this.OffsetMAIN);
            System.arraycopy(this.mainBlock, 0, bArr, i10, 16);
            if (!this.forEncryption) {
                xor(this.Checksum, this.mainBlock);
                byte[] bArr4 = this.mainBlock;
                System.arraycopy(bArr4, 16, bArr4, 0, this.macSize);
                this.mainBlockPos = this.macSize;
                return;
            }
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    /* access modifiers changed from: protected */
    public int processNonce(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i10 = 0;
        System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
        bArr2[0] = (byte) (this.macSize << 4);
        int length = 15 - bArr.length;
        bArr2[length] = (byte) (bArr2[length] | 1);
        byte b10 = bArr2[15];
        byte b11 = b10 & 63;
        bArr2[15] = (byte) (b10 & 192);
        byte[] bArr3 = this.KtopInput;
        if (bArr3 == null || !Arrays.areEqual(bArr2, bArr3)) {
            byte[] bArr4 = new byte[16];
            this.KtopInput = bArr2;
            this.hashCipher.processBlock(bArr2, 0, bArr4, 0);
            System.arraycopy(bArr4, 0, this.Stretch, 0, 16);
            while (i10 < 8) {
                byte[] bArr5 = this.Stretch;
                int i11 = i10 + 16;
                byte b12 = bArr4[i10];
                i10++;
                bArr5[i11] = (byte) (b12 ^ bArr4[i10]);
            }
        }
        return b11;
    }

    public void reset() {
        reset(true);
    }

    /* access modifiers changed from: protected */
    public void reset(boolean z10) {
        this.hashCipher.reset();
        this.mainCipher.reset();
        clear(this.hashBlock);
        clear(this.mainBlock);
        this.hashBlockPos = 0;
        this.mainBlockPos = 0;
        this.hashBlockCount = 0;
        this.mainBlockCount = 0;
        clear(this.OffsetHASH);
        clear(this.Sum);
        System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
        clear(this.Checksum);
        if (z10) {
            this.macBlock = null;
        }
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }

    /* access modifiers changed from: protected */
    public void updateHASH(byte[] bArr) {
        xor(this.OffsetHASH, bArr);
        xor(this.hashBlock, this.OffsetHASH);
        BlockCipher blockCipher = this.hashCipher;
        byte[] bArr2 = this.hashBlock;
        blockCipher.processBlock(bArr2, 0, bArr2, 0);
        xor(this.Sum, this.hashBlock);
    }
}
