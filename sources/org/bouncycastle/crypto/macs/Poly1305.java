package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;
import org.jivesoftware.smack.datatypes.UInt32;

public class Poly1305 implements Mac {
    private static final int BLOCK_SIZE = 16;
    private final BlockCipher cipher;
    private final byte[] currentBlock;
    private int currentBlockOffset;

    /* renamed from: h0  reason: collision with root package name */
    private int f41452h0;

    /* renamed from: h1  reason: collision with root package name */
    private int f41453h1;

    /* renamed from: h2  reason: collision with root package name */
    private int f41454h2;

    /* renamed from: h3  reason: collision with root package name */
    private int f41455h3;

    /* renamed from: h4  reason: collision with root package name */
    private int f41456h4;

    /* renamed from: k0  reason: collision with root package name */
    private int f41457k0;

    /* renamed from: k1  reason: collision with root package name */
    private int f41458k1;

    /* renamed from: k2  reason: collision with root package name */
    private int f41459k2;

    /* renamed from: k3  reason: collision with root package name */
    private int f41460k3;

    /* renamed from: r0  reason: collision with root package name */
    private int f41461r0;

    /* renamed from: r1  reason: collision with root package name */
    private int f41462r1;

    /* renamed from: r2  reason: collision with root package name */
    private int f41463r2;

    /* renamed from: r3  reason: collision with root package name */
    private int f41464r3;

    /* renamed from: r4  reason: collision with root package name */
    private int f41465r4;

    /* renamed from: s1  reason: collision with root package name */
    private int f41466s1;

    /* renamed from: s2  reason: collision with root package name */
    private int f41467s2;

    /* renamed from: s3  reason: collision with root package name */
    private int f41468s3;

    /* renamed from: s4  reason: collision with root package name */
    private int f41469s4;
    private final byte[] singleByte;

    public Poly1305() {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        this.cipher = null;
    }

    public Poly1305(BlockCipher blockCipher) {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        if (blockCipher.getBlockSize() == 16) {
            this.cipher = blockCipher;
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
    }

    private static final long mul32x32_64(int i10, int i11) {
        return (((long) i10) & UInt32.MAX_VALUE_LONG) * ((long) i11);
    }

    private void processBlock() {
        int i10 = this.currentBlockOffset;
        if (i10 < 16) {
            this.currentBlock[i10] = 1;
            for (int i11 = i10 + 1; i11 < 16; i11++) {
                this.currentBlock[i11] = 0;
            }
        }
        long littleEndianToInt = ((long) Pack.littleEndianToInt(this.currentBlock, 0)) & UInt32.MAX_VALUE_LONG;
        long littleEndianToInt2 = ((long) Pack.littleEndianToInt(this.currentBlock, 4)) & UInt32.MAX_VALUE_LONG;
        long littleEndianToInt3 = ((long) Pack.littleEndianToInt(this.currentBlock, 8)) & UInt32.MAX_VALUE_LONG;
        long littleEndianToInt4 = UInt32.MAX_VALUE_LONG & ((long) Pack.littleEndianToInt(this.currentBlock, 12));
        int i12 = (int) (((long) this.f41452h0) + (littleEndianToInt & 67108863));
        this.f41452h0 = i12;
        this.f41453h1 = (int) (((long) this.f41453h1) + ((((littleEndianToInt2 << 32) | littleEndianToInt) >>> 26) & 67108863));
        this.f41454h2 = (int) (((long) this.f41454h2) + (((littleEndianToInt2 | (littleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.f41455h3 = (int) (((long) this.f41455h3) + ((((littleEndianToInt4 << 32) | littleEndianToInt3) >>> 14) & 67108863));
        int i13 = (int) (((long) this.f41456h4) + (littleEndianToInt4 >>> 8));
        this.f41456h4 = i13;
        if (this.currentBlockOffset == 16) {
            this.f41456h4 = i13 + 16777216;
        }
        long mul32x32_64 = mul32x32_64(i12, this.f41461r0) + mul32x32_64(this.f41453h1, this.f41469s4) + mul32x32_64(this.f41454h2, this.f41468s3) + mul32x32_64(this.f41455h3, this.f41467s2) + mul32x32_64(this.f41456h4, this.f41466s1);
        long mul32x32_642 = mul32x32_64(this.f41452h0, this.f41462r1) + mul32x32_64(this.f41453h1, this.f41461r0) + mul32x32_64(this.f41454h2, this.f41469s4) + mul32x32_64(this.f41455h3, this.f41468s3) + mul32x32_64(this.f41456h4, this.f41467s2);
        long mul32x32_643 = mul32x32_64(this.f41452h0, this.f41463r2) + mul32x32_64(this.f41453h1, this.f41462r1) + mul32x32_64(this.f41454h2, this.f41461r0) + mul32x32_64(this.f41455h3, this.f41469s4) + mul32x32_64(this.f41456h4, this.f41468s3);
        long mul32x32_644 = mul32x32_64(this.f41452h0, this.f41464r3) + mul32x32_64(this.f41453h1, this.f41463r2) + mul32x32_64(this.f41454h2, this.f41462r1) + mul32x32_64(this.f41455h3, this.f41461r0) + mul32x32_64(this.f41456h4, this.f41469s4);
        long mul32x32_645 = mul32x32_64(this.f41452h0, this.f41465r4) + mul32x32_64(this.f41453h1, this.f41464r3) + mul32x32_64(this.f41454h2, this.f41463r2) + mul32x32_64(this.f41455h3, this.f41462r1) + mul32x32_64(this.f41456h4, this.f41461r0);
        long j10 = mul32x32_642 + (mul32x32_64 >>> 26);
        long j11 = mul32x32_643 + (j10 >>> 26);
        this.f41454h2 = ((int) j11) & 67108863;
        long j12 = mul32x32_644 + (j11 >>> 26);
        this.f41455h3 = ((int) j12) & 67108863;
        long j13 = mul32x32_645 + (j12 >>> 26);
        this.f41456h4 = ((int) j13) & 67108863;
        int i14 = (((int) mul32x32_64) & 67108863) + (((int) (j13 >>> 26)) * 5);
        this.f41453h1 = (((int) j10) & 67108863) + (i14 >>> 26);
        this.f41452h0 = i14 & 67108863;
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            int i10 = 16;
            if (this.cipher == null || (bArr2 != null && bArr2.length == 16)) {
                int littleEndianToInt = Pack.littleEndianToInt(bArr, 0);
                int littleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
                int littleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
                int littleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
                this.f41461r0 = 67108863 & littleEndianToInt;
                int i11 = ((littleEndianToInt >>> 26) | (littleEndianToInt2 << 6)) & 67108611;
                this.f41462r1 = i11;
                int i12 = ((littleEndianToInt2 >>> 20) | (littleEndianToInt3 << 12)) & 67092735;
                this.f41463r2 = i12;
                int i13 = ((littleEndianToInt3 >>> 14) | (littleEndianToInt4 << 18)) & 66076671;
                this.f41464r3 = i13;
                int i14 = (littleEndianToInt4 >>> 8) & 1048575;
                this.f41465r4 = i14;
                this.f41466s1 = i11 * 5;
                this.f41467s2 = i12 * 5;
                this.f41468s3 = i13 * 5;
                this.f41469s4 = i14 * 5;
                BlockCipher blockCipher = this.cipher;
                if (blockCipher != null) {
                    byte[] bArr3 = new byte[16];
                    blockCipher.init(true, new KeyParameter(bArr, 16, 16));
                    this.cipher.processBlock(bArr2, 0, bArr3, 0);
                    i10 = 0;
                    bArr = bArr3;
                }
                this.f41457k0 = Pack.littleEndianToInt(bArr, i10 + 0);
                this.f41458k1 = Pack.littleEndianToInt(bArr, i10 + 4);
                this.f41459k2 = Pack.littleEndianToInt(bArr, i10 + 8);
                this.f41460k3 = Pack.littleEndianToInt(bArr, i10 + 12);
                return;
            }
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        if (i10 + 16 <= bArr.length) {
            if (this.currentBlockOffset > 0) {
                processBlock();
            }
            int i11 = this.f41453h1;
            int i12 = this.f41452h0;
            int i13 = i11 + (i12 >>> 26);
            int i14 = this.f41454h2 + (i13 >>> 26);
            int i15 = this.f41455h3 + (i14 >>> 26);
            int i16 = i14 & 67108863;
            int i17 = this.f41456h4 + (i15 >>> 26);
            int i18 = i15 & 67108863;
            int i19 = (i12 & 67108863) + ((i17 >>> 26) * 5);
            int i20 = i17 & 67108863;
            int i21 = (i13 & 67108863) + (i19 >>> 26);
            int i22 = i19 & 67108863;
            int i23 = i22 + 5;
            int i24 = (i23 >>> 26) + i21;
            int i25 = (i24 >>> 26) + i16;
            int i26 = (i25 >>> 26) + i18;
            int i27 = 67108863 & i26;
            int i28 = ((i26 >>> 26) + i20) - 67108864;
            int i29 = (i28 >>> 31) - 1;
            int i30 = ~i29;
            int i31 = (i22 & i30) | (i23 & 67108863 & i29);
            this.f41452h0 = i31;
            int i32 = (i21 & i30) | (i24 & 67108863 & i29);
            this.f41453h1 = i32;
            int i33 = (i16 & i30) | (i25 & 67108863 & i29);
            this.f41454h2 = i33;
            int i34 = (i27 & i29) | (i18 & i30);
            this.f41455h3 = i34;
            int i35 = (i20 & i30) | (i28 & i29);
            this.f41456h4 = i35;
            long j10 = (((long) (i31 | (i32 << 26))) & UInt32.MAX_VALUE_LONG) + (((long) this.f41457k0) & UInt32.MAX_VALUE_LONG);
            long j11 = (((long) ((i32 >>> 6) | (i33 << 20))) & UInt32.MAX_VALUE_LONG) + (((long) this.f41458k1) & UInt32.MAX_VALUE_LONG);
            long j12 = (((long) ((i33 >>> 12) | (i34 << 14))) & UInt32.MAX_VALUE_LONG) + (((long) this.f41459k2) & UInt32.MAX_VALUE_LONG);
            Pack.intToLittleEndian((int) j10, bArr, i10);
            long j13 = j11 + (j10 >>> 32);
            Pack.intToLittleEndian((int) j13, bArr, i10 + 4);
            long j14 = j12 + (j13 >>> 32);
            Pack.intToLittleEndian((int) j14, bArr, i10 + 8);
            Pack.intToLittleEndian((int) ((((long) ((i34 >>> 18) | (i35 << 8))) & UInt32.MAX_VALUE_LONG) + (UInt32.MAX_VALUE_LONG & ((long) this.f41460k3)) + (j14 >>> 32)), bArr, i10 + 12);
            reset();
            return 16;
        }
        throw new OutputLengthException("Output buffer is too short.");
    }

    public String getAlgorithmName() {
        if (this.cipher == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.cipher.getAlgorithmName();
    }

    public int getMacSize() {
        return 16;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] bArr;
        if (this.cipher == null) {
            bArr = null;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
        }
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey(), bArr);
            reset();
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a key.");
    }

    public void reset() {
        this.currentBlockOffset = 0;
        this.f41456h4 = 0;
        this.f41455h3 = 0;
        this.f41454h2 = 0;
        this.f41453h1 = 0;
        this.f41452h0 = 0;
    }

    public void update(byte b10) throws IllegalStateException {
        byte[] bArr = this.singleByte;
        bArr[0] = b10;
        update(bArr, 0, 1);
    }

    public void update(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalStateException {
        int i12 = 0;
        while (i11 > i12) {
            if (this.currentBlockOffset == 16) {
                processBlock();
                this.currentBlockOffset = 0;
            }
            int min = Math.min(i11 - i12, 16 - this.currentBlockOffset);
            System.arraycopy(bArr, i12 + i10, this.currentBlock, this.currentBlockOffset, min);
            i12 += min;
            this.currentBlockOffset += min;
        }
    }
}
