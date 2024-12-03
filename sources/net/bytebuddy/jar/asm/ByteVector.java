package net.bytebuddy.jar.asm;

public class ByteVector {
    byte[] data;
    int length;

    public ByteVector() {
        this.data = new byte[64];
    }

    private void enlarge(int i10) {
        int i11 = this.length;
        byte[] bArr = this.data;
        if (i11 <= bArr.length) {
            int length2 = bArr.length * 2;
            int i12 = i10 + i11;
            if (length2 <= i12) {
                length2 = i12;
            }
            byte[] bArr2 = new byte[length2];
            System.arraycopy(bArr, 0, bArr2, 0, i11);
            this.data = bArr2;
            return;
        }
        throw new AssertionError("Internal error");
    }

    /* access modifiers changed from: package-private */
    public final ByteVector encodeUtf8(String str, int i10, int i11) {
        int i12;
        int length2 = str.length();
        int i13 = i10;
        int i14 = i13;
        while (i13 < length2) {
            char charAt = str.charAt(i13);
            if (charAt >= 1 && charAt <= 127) {
                i14++;
            } else if (charAt <= 2047) {
                i14 += 2;
            } else {
                i14 += 3;
            }
            i13++;
        }
        if (i14 <= i11) {
            int i15 = this.length;
            int i16 = (i15 - i10) - 2;
            if (i16 >= 0) {
                byte[] bArr = this.data;
                bArr[i16] = (byte) (i14 >>> 8);
                bArr[i16 + 1] = (byte) i14;
            }
            if ((i15 + i14) - i10 > this.data.length) {
                enlarge(i14 - i10);
            }
            int i17 = this.length;
            while (i10 < length2) {
                char charAt2 = str.charAt(i10);
                if (charAt2 >= 1 && charAt2 <= 127) {
                    i12 = i17 + 1;
                    this.data[i17] = (byte) charAt2;
                } else if (charAt2 <= 2047) {
                    byte[] bArr2 = this.data;
                    int i18 = i17 + 1;
                    bArr2[i17] = (byte) (((charAt2 >> 6) & 31) | 192);
                    i17 = i18 + 1;
                    bArr2[i18] = (byte) ((charAt2 & '?') | 128);
                    i10++;
                } else {
                    byte[] bArr3 = this.data;
                    int i19 = i17 + 1;
                    bArr3[i17] = (byte) (((charAt2 >> 12) & 15) | 224);
                    int i20 = i19 + 1;
                    bArr3[i19] = (byte) (((charAt2 >> 6) & 63) | 128);
                    i12 = i20 + 1;
                    bArr3[i20] = (byte) ((charAt2 & '?') | 128);
                }
                i17 = i12;
                i10++;
            }
            this.length = i17;
            return this;
        }
        throw new IllegalArgumentException("UTF8 string too large");
    }

    /* access modifiers changed from: package-private */
    public final ByteVector put11(int i10, int i11) {
        int i12 = this.length;
        if (i12 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] bArr = this.data;
        int i13 = i12 + 1;
        bArr[i12] = (byte) i10;
        bArr[i13] = (byte) i11;
        this.length = i13 + 1;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final ByteVector put112(int i10, int i11, int i12) {
        int i13 = this.length;
        if (i13 + 4 > this.data.length) {
            enlarge(4);
        }
        byte[] bArr = this.data;
        int i14 = i13 + 1;
        bArr[i13] = (byte) i10;
        int i15 = i14 + 1;
        bArr[i14] = (byte) i11;
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i12 >>> 8);
        bArr[i16] = (byte) i12;
        this.length = i16 + 1;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final ByteVector put12(int i10, int i11) {
        int i12 = this.length;
        if (i12 + 3 > this.data.length) {
            enlarge(3);
        }
        byte[] bArr = this.data;
        int i13 = i12 + 1;
        bArr[i12] = (byte) i10;
        int i14 = i13 + 1;
        bArr[i13] = (byte) (i11 >>> 8);
        bArr[i14] = (byte) i11;
        this.length = i14 + 1;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final ByteVector put122(int i10, int i11, int i12) {
        int i13 = this.length;
        if (i13 + 5 > this.data.length) {
            enlarge(5);
        }
        byte[] bArr = this.data;
        int i14 = i13 + 1;
        bArr[i13] = (byte) i10;
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i11 >>> 8);
        int i16 = i15 + 1;
        bArr[i15] = (byte) i11;
        int i17 = i16 + 1;
        bArr[i16] = (byte) (i12 >>> 8);
        bArr[i17] = (byte) i12;
        this.length = i17 + 1;
        return this;
    }

    public ByteVector putByte(int i10) {
        int i11 = this.length;
        int i12 = i11 + 1;
        if (i12 > this.data.length) {
            enlarge(1);
        }
        this.data[i11] = (byte) i10;
        this.length = i12;
        return this;
    }

    public ByteVector putByteArray(byte[] bArr, int i10, int i11) {
        if (this.length + i11 > this.data.length) {
            enlarge(i11);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i10, this.data, this.length, i11);
        }
        this.length += i11;
        return this;
    }

    public ByteVector putInt(int i10) {
        int i11 = this.length;
        if (i11 + 4 > this.data.length) {
            enlarge(4);
        }
        byte[] bArr = this.data;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i10 >>> 24);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i10 >>> 16);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (i10 >>> 8);
        bArr[i14] = (byte) i10;
        this.length = i14 + 1;
        return this;
    }

    public ByteVector putLong(long j10) {
        int i10 = this.length;
        if (i10 + 8 > this.data.length) {
            enlarge(8);
        }
        byte[] bArr = this.data;
        int i11 = (int) (j10 >>> 32);
        int i12 = i10 + 1;
        bArr[i10] = (byte) (i11 >>> 24);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i11 >>> 16);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (i11 >>> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) i11;
        int i16 = (int) j10;
        int i17 = i15 + 1;
        bArr[i15] = (byte) (i16 >>> 24);
        int i18 = i17 + 1;
        bArr[i17] = (byte) (i16 >>> 16);
        int i19 = i18 + 1;
        bArr[i18] = (byte) (i16 >>> 8);
        bArr[i19] = (byte) i16;
        this.length = i19 + 1;
        return this;
    }

    public ByteVector putShort(int i10) {
        int i11 = this.length;
        if (i11 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] bArr = this.data;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i10 >>> 8);
        bArr[i12] = (byte) i10;
        this.length = i12 + 1;
        return this;
    }

    public ByteVector putUTF8(String str) {
        int length2 = str.length();
        if (length2 <= 65535) {
            int i10 = this.length;
            if (i10 + 2 + length2 > this.data.length) {
                enlarge(length2 + 2);
            }
            byte[] bArr = this.data;
            int i11 = i10 + 1;
            bArr[i10] = (byte) (length2 >>> 8);
            int i12 = i11 + 1;
            bArr[i11] = (byte) length2;
            int i13 = 0;
            while (i13 < length2) {
                char charAt = str.charAt(i13);
                if (charAt < 1 || charAt > 127) {
                    this.length = i12;
                    return encodeUtf8(str, i13, 65535);
                }
                bArr[i12] = (byte) charAt;
                i13++;
                i12++;
            }
            this.length = i12;
            return this;
        }
        throw new IllegalArgumentException("UTF8 string too large");
    }

    public int size() {
        return this.length;
    }

    public ByteVector(int i10) {
        this.data = new byte[i10];
    }

    ByteVector(byte[] bArr) {
        this.data = bArr;
        this.length = bArr.length;
    }
}
