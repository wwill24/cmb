package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public abstract class GeneralDigest implements ExtendedDigest, Memoable {
    private static final int BYTE_LENGTH = 64;
    private long byteCount;
    private final byte[] xBuf;
    private int xBufOff;

    protected GeneralDigest() {
        this.xBuf = new byte[4];
        this.xBufOff = 0;
    }

    protected GeneralDigest(GeneralDigest generalDigest) {
        this.xBuf = new byte[4];
        copyIn(generalDigest);
    }

    protected GeneralDigest(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        this.xBuf = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.xBufOff = Pack.bigEndianToInt(bArr, 4);
        this.byteCount = Pack.bigEndianToLong(bArr, 8);
    }

    /* access modifiers changed from: protected */
    public void copyIn(GeneralDigest generalDigest) {
        byte[] bArr = generalDigest.xBuf;
        System.arraycopy(bArr, 0, this.xBuf, 0, bArr.length);
        this.xBufOff = generalDigest.xBufOff;
        this.byteCount = generalDigest.byteCount;
    }

    public void finish() {
        long j10 = this.byteCount << 3;
        byte b10 = Byte.MIN_VALUE;
        while (true) {
            update(b10);
            if (this.xBufOff != 0) {
                b10 = 0;
            } else {
                processLength(j10);
                processBlock();
                return;
            }
        }
    }

    public int getByteLength() {
        return 64;
    }

    /* access modifiers changed from: protected */
    public void populateState(byte[] bArr) {
        System.arraycopy(this.xBuf, 0, bArr, 0, this.xBufOff);
        Pack.intToBigEndian(this.xBufOff, bArr, 4);
        Pack.longToBigEndian(this.byteCount, bArr, 8);
    }

    /* access modifiers changed from: protected */
    public abstract void processBlock();

    /* access modifiers changed from: protected */
    public abstract void processLength(long j10);

    /* access modifiers changed from: protected */
    public abstract void processWord(byte[] bArr, int i10);

    public void reset() {
        this.byteCount = 0;
        this.xBufOff = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.xBuf;
            if (i10 < bArr.length) {
                bArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }

    public void update(byte b10) {
        byte[] bArr = this.xBuf;
        int i10 = this.xBufOff;
        int i11 = i10 + 1;
        this.xBufOff = i11;
        bArr[i10] = b10;
        if (i11 == bArr.length) {
            processWord(bArr, 0);
            this.xBufOff = 0;
        }
        this.byteCount++;
    }

    public void update(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        int max = Math.max(0, i11);
        if (this.xBufOff != 0) {
            int i13 = 0;
            while (true) {
                if (i13 >= max) {
                    i12 = i13;
                    break;
                }
                byte[] bArr2 = this.xBuf;
                int i14 = this.xBufOff;
                int i15 = i14 + 1;
                this.xBufOff = i15;
                int i16 = i13 + 1;
                bArr2[i14] = bArr[i13 + i10];
                if (i15 == 4) {
                    processWord(bArr2, 0);
                    this.xBufOff = 0;
                    i12 = i16;
                    break;
                }
                i13 = i16;
            }
        }
        int i17 = ((max - i12) & -4) + i12;
        while (i12 < i17) {
            processWord(bArr, i10 + i12);
            i12 += 4;
        }
        while (i12 < max) {
            byte[] bArr3 = this.xBuf;
            int i18 = this.xBufOff;
            this.xBufOff = i18 + 1;
            bArr3[i18] = bArr[i12 + i10];
            i12++;
        }
        this.byteCount += (long) max;
    }
}
