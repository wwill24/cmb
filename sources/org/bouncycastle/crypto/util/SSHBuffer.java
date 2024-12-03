package org.bouncycastle.crypto.util;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

class SSHBuffer {
    private final byte[] buffer;
    private int pos = 0;

    public SSHBuffer(byte[] bArr) {
        this.buffer = bArr;
    }

    public SSHBuffer(byte[] bArr, byte[] bArr2) {
        int i10 = 0;
        this.buffer = bArr2;
        while (i10 != bArr.length) {
            if (bArr[i10] == bArr2[i10]) {
                i10++;
            } else {
                throw new IllegalArgumentException("magic-number incorrect");
            }
        }
        this.pos += bArr.length;
    }

    public byte[] getBuffer() {
        return Arrays.clone(this.buffer);
    }

    public boolean hasRemaining() {
        return this.pos < this.buffer.length;
    }

    public BigInteger readBigNumPositive() {
        int readU32 = readU32();
        int i10 = this.pos;
        int i11 = i10 + readU32;
        byte[] bArr = this.buffer;
        if (i11 <= bArr.length) {
            int i12 = readU32 + i10;
            this.pos = i12;
            return new BigInteger(1, Arrays.copyOfRange(bArr, i10, i12));
        }
        throw new IllegalArgumentException("not enough data for big num");
    }

    public byte[] readBlock() {
        int readU32 = readU32();
        if (readU32 == 0) {
            return new byte[0];
        }
        int i10 = this.pos;
        byte[] bArr = this.buffer;
        if (i10 <= bArr.length - readU32) {
            int i11 = readU32 + i10;
            this.pos = i11;
            return Arrays.copyOfRange(bArr, i10, i11);
        }
        throw new IllegalArgumentException("not enough data for block");
    }

    public byte[] readPaddedBlock() {
        return readPaddedBlock(8);
    }

    public byte[] readPaddedBlock(int i10) {
        byte b10;
        int readU32 = readU32();
        if (readU32 == 0) {
            return new byte[0];
        }
        int i11 = this.pos;
        byte[] bArr = this.buffer;
        if (i11 > bArr.length - readU32) {
            throw new IllegalArgumentException("not enough data for block");
        } else if (readU32 % i10 == 0) {
            int i12 = i11 + readU32;
            this.pos = i12;
            if (readU32 > 0 && (b10 = bArr[i12 - 1] & 255) > 0 && b10 < i10) {
                i12 -= b10;
                int i13 = 1;
                int i14 = i12;
                while (i13 <= b10) {
                    if (i13 == (this.buffer[i14] & 255)) {
                        i13++;
                        i14++;
                    } else {
                        throw new IllegalArgumentException("incorrect padding");
                    }
                }
            }
            return Arrays.copyOfRange(this.buffer, i11, i12);
        } else {
            throw new IllegalArgumentException("missing padding");
        }
    }

    public String readString() {
        return Strings.fromByteArray(readBlock());
    }

    public int readU32() {
        int i10 = this.pos;
        byte[] bArr = this.buffer;
        if (i10 <= bArr.length - 4) {
            int i11 = i10 + 1;
            int i12 = i11 + 1;
            byte b10 = ((bArr[i10] & 255) << 24) | ((bArr[i11] & 255) << Tnaf.POW_2_WIDTH);
            int i13 = i12 + 1;
            byte b11 = b10 | ((bArr[i12] & 255) << 8);
            this.pos = i13 + 1;
            return b11 | (bArr[i13] & 255);
        }
        throw new IllegalArgumentException("4 bytes for U32 exceeds buffer.");
    }

    public void skipBlock() {
        int readU32 = readU32();
        int i10 = this.pos;
        if (i10 <= this.buffer.length - readU32) {
            this.pos = i10 + readU32;
            return;
        }
        throw new IllegalArgumentException("not enough data for block");
    }
}
