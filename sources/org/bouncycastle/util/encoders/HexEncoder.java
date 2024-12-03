package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public class HexEncoder implements Encoder {
    protected final byte[] decodingTable = new byte[128];
    protected final byte[] encodingTable = {48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public HexEncoder() {
        initialiseDecodingTable();
    }

    private static boolean ignore(char c10) {
        return c10 == 10 || c10 == 13 || c10 == 9 || c10 == ' ';
    }

    public int decode(String str, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[36];
        int length = str.length();
        while (length > 0 && ignore(str.charAt(length - 1))) {
            length--;
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            while (i10 < length && ignore(str.charAt(i10))) {
                i10++;
            }
            int i13 = i10 + 1;
            byte b10 = this.decodingTable[str.charAt(i10)];
            while (i13 < length && ignore(str.charAt(i13))) {
                i13++;
            }
            int i14 = i13 + 1;
            byte b11 = this.decodingTable[str.charAt(i13)];
            if ((b10 | b11) >= 0) {
                int i15 = i11 + 1;
                bArr[i11] = (byte) ((b10 << 4) | b11);
                if (i15 == 36) {
                    outputStream.write(bArr);
                    i11 = 0;
                } else {
                    i11 = i15;
                }
                i12++;
                i10 = i14;
            } else {
                throw new IOException("invalid characters encountered in Hex string");
            }
        }
        if (i11 > 0) {
            outputStream.write(bArr, 0, i11);
        }
        return i12;
    }

    public int decode(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[36];
        int i12 = i11 + i10;
        while (i12 > i10 && ignore((char) bArr[i12 - 1])) {
            i12--;
        }
        int i13 = 0;
        int i14 = 0;
        while (i10 < i12) {
            while (i10 < i12 && ignore((char) bArr[i10])) {
                i10++;
            }
            int i15 = i10 + 1;
            byte b10 = this.decodingTable[bArr[i10]];
            while (i15 < i12 && ignore((char) bArr[i15])) {
                i15++;
            }
            int i16 = i15 + 1;
            byte b11 = this.decodingTable[bArr[i15]];
            if ((b10 | b11) >= 0) {
                int i17 = i13 + 1;
                bArr2[i13] = (byte) ((b10 << 4) | b11);
                if (i17 == 36) {
                    outputStream.write(bArr2);
                    i13 = 0;
                } else {
                    i13 = i17;
                }
                i14++;
                i10 = i16;
            } else {
                throw new IOException("invalid characters encountered in Hex data");
            }
        }
        if (i13 > 0) {
            outputStream.write(bArr2, 0, i13);
        }
        return i14;
    }

    /* access modifiers changed from: package-private */
    public byte[] decodeStrict(String str, int i10, int i11) throws IOException {
        if (str == null) {
            throw new NullPointerException("'str' cannot be null");
        } else if (i10 < 0 || i11 < 0 || i10 > str.length() - i11) {
            throw new IndexOutOfBoundsException("invalid offset and/or length specified");
        } else if ((i11 & 1) == 0) {
            int i12 = i11 >>> 1;
            byte[] bArr = new byte[i12];
            int i13 = 0;
            while (i13 < i12) {
                int i14 = i10 + 1;
                int i15 = i14 + 1;
                byte b10 = (this.decodingTable[str.charAt(i10)] << 4) | this.decodingTable[str.charAt(i14)];
                if (b10 >= 0) {
                    bArr[i13] = (byte) b10;
                    i13++;
                    i10 = i15;
                } else {
                    throw new IOException("invalid characters encountered in Hex string");
                }
            }
            return bArr;
        } else {
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
    }

    public int encode(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[72];
        while (i11 > 0) {
            int min = Math.min(36, i11);
            outputStream.write(bArr2, 0, encode(bArr, i10, min, bArr2, 0));
            i10 += min;
            i11 -= min;
        }
        return i11 * 2;
    }

    public int encode(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IOException {
        int i13 = i11 + i10;
        int i14 = i12;
        while (i10 < i13) {
            int i15 = i10 + 1;
            byte b10 = bArr[i10] & 255;
            int i16 = i14 + 1;
            byte[] bArr3 = this.encodingTable;
            bArr2[i14] = bArr3[b10 >>> 4];
            i14 = i16 + 1;
            bArr2[i16] = bArr3[b10 & 15];
            i10 = i15;
        }
        return i14 - i12;
    }

    public int getEncodedLength(int i10) {
        return i10 * 2;
    }

    public int getMaxDecodedLength(int i10) {
        return i10 / 2;
    }

    /* access modifiers changed from: protected */
    public void initialiseDecodingTable() {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.decodingTable;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = -1;
            i11++;
        }
        while (true) {
            byte[] bArr2 = this.encodingTable;
            if (i10 < bArr2.length) {
                this.decodingTable[bArr2[i10]] = (byte) i10;
                i10++;
            } else {
                byte[] bArr3 = this.decodingTable;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
        }
    }
}
