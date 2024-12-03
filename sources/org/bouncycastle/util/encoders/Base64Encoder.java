package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public class Base64Encoder implements Encoder {
    protected final byte[] decodingTable = new byte[128];
    protected final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    protected byte padding = 61;

    public Base64Encoder() {
        initialiseDecodingTable();
    }

    private int decodeLastBlock(OutputStream outputStream, char c10, char c11, char c12, char c13) throws IOException {
        byte b10 = this.padding;
        if (c12 == b10) {
            if (c13 == b10) {
                byte[] bArr = this.decodingTable;
                byte b11 = bArr[c10];
                byte b12 = bArr[c11];
                if ((b11 | b12) >= 0) {
                    outputStream.write((b11 << 2) | (b12 >> 4));
                    return 1;
                }
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        } else if (c13 == b10) {
            byte[] bArr2 = this.decodingTable;
            byte b13 = bArr2[c10];
            byte b14 = bArr2[c11];
            byte b15 = bArr2[c12];
            if ((b13 | b14 | b15) >= 0) {
                outputStream.write((b13 << 2) | (b14 >> 4));
                outputStream.write((b14 << 4) | (b15 >> 2));
                return 2;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        } else {
            byte[] bArr3 = this.decodingTable;
            byte b16 = bArr3[c10];
            byte b17 = bArr3[c11];
            byte b18 = bArr3[c12];
            byte b19 = bArr3[c13];
            if ((b16 | b17 | b18 | b19) >= 0) {
                outputStream.write((b16 << 2) | (b17 >> 4));
                outputStream.write((b17 << 4) | (b18 >> 2));
                outputStream.write((b18 << 6) | b19);
                return 3;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        }
    }

    private boolean ignore(char c10) {
        return c10 == 10 || c10 == 13 || c10 == 9 || c10 == ' ';
    }

    private int nextI(String str, int i10, int i11) {
        while (i10 < i11 && ignore(str.charAt(i10))) {
            i10++;
        }
        return i10;
    }

    private int nextI(byte[] bArr, int i10, int i11) {
        while (i10 < i11 && ignore((char) bArr[i10])) {
            i10++;
        }
        return i10;
    }

    public int decode(String str, OutputStream outputStream) throws IOException {
        String str2 = str;
        OutputStream outputStream2 = outputStream;
        byte[] bArr = new byte[54];
        int length = str.length();
        while (length > 0 && ignore(str2.charAt(length - 1))) {
            length--;
        }
        if (length == 0) {
            return 0;
        }
        int i10 = length;
        int i11 = 0;
        while (i10 > 0 && i11 != 4) {
            if (!ignore(str2.charAt(i10 - 1))) {
                i11++;
            }
            i10--;
        }
        int nextI = nextI(str2, 0, i10);
        int i12 = 0;
        int i13 = 0;
        while (nextI < i10) {
            int i14 = nextI + 1;
            byte b10 = this.decodingTable[str2.charAt(nextI)];
            int nextI2 = nextI(str2, i14, i10);
            int i15 = nextI2 + 1;
            byte b11 = this.decodingTable[str2.charAt(nextI2)];
            int nextI3 = nextI(str2, i15, i10);
            int i16 = nextI3 + 1;
            byte b12 = this.decodingTable[str2.charAt(nextI3)];
            int nextI4 = nextI(str2, i16, i10);
            int i17 = nextI4 + 1;
            byte b13 = this.decodingTable[str2.charAt(nextI4)];
            if ((b10 | b11 | b12 | b13) >= 0) {
                int i18 = i12 + 1;
                bArr[i12] = (byte) ((b10 << 2) | (b11 >> 4));
                int i19 = i18 + 1;
                bArr[i18] = (byte) ((b11 << 4) | (b12 >> 2));
                i12 = i19 + 1;
                bArr[i19] = (byte) ((b12 << 6) | b13);
                i13 += 3;
                if (i12 == 54) {
                    outputStream2.write(bArr);
                    i12 = 0;
                }
                nextI = nextI(str2, i17, i10);
            } else {
                throw new IOException("invalid characters encountered in base64 data");
            }
        }
        if (i12 > 0) {
            outputStream2.write(bArr, 0, i12);
        }
        int nextI5 = nextI(str2, nextI, length);
        int nextI6 = nextI(str2, nextI5 + 1, length);
        int nextI7 = nextI(str2, nextI6 + 1, length);
        return i13 + decodeLastBlock(outputStream, str2.charAt(nextI5), str2.charAt(nextI6), str2.charAt(nextI7), str2.charAt(nextI(str2, nextI7 + 1, length)));
    }

    public int decode(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException {
        byte[] bArr2 = bArr;
        int i12 = i10;
        OutputStream outputStream2 = outputStream;
        byte[] bArr3 = new byte[54];
        int i13 = i12 + i11;
        while (i13 > i12 && ignore((char) bArr2[i13 - 1])) {
            i13--;
        }
        if (i13 == 0) {
            return 0;
        }
        int i14 = i13;
        int i15 = 0;
        while (i14 > i12 && i15 != 4) {
            if (!ignore((char) bArr2[i14 - 1])) {
                i15++;
            }
            i14--;
        }
        int nextI = nextI(bArr2, i12, i14);
        int i16 = 0;
        int i17 = 0;
        while (nextI < i14) {
            int i18 = nextI + 1;
            byte b10 = this.decodingTable[bArr2[nextI]];
            int nextI2 = nextI(bArr2, i18, i14);
            int i19 = nextI2 + 1;
            byte b11 = this.decodingTable[bArr2[nextI2]];
            int nextI3 = nextI(bArr2, i19, i14);
            int i20 = nextI3 + 1;
            byte b12 = this.decodingTable[bArr2[nextI3]];
            int nextI4 = nextI(bArr2, i20, i14);
            int i21 = nextI4 + 1;
            byte b13 = this.decodingTable[bArr2[nextI4]];
            if ((b10 | b11 | b12 | b13) >= 0) {
                int i22 = i16 + 1;
                bArr3[i16] = (byte) ((b10 << 2) | (b11 >> 4));
                int i23 = i22 + 1;
                bArr3[i22] = (byte) ((b11 << 4) | (b12 >> 2));
                i16 = i23 + 1;
                bArr3[i23] = (byte) ((b12 << 6) | b13);
                if (i16 == 54) {
                    outputStream2.write(bArr3);
                    i16 = 0;
                }
                i17 += 3;
                nextI = nextI(bArr2, i21, i14);
            } else {
                throw new IOException("invalid characters encountered in base64 data");
            }
        }
        if (i16 > 0) {
            outputStream2.write(bArr3, 0, i16);
        }
        int nextI5 = nextI(bArr2, nextI, i13);
        int nextI6 = nextI(bArr2, nextI5 + 1, i13);
        int nextI7 = nextI(bArr2, nextI6 + 1, i13);
        return i17 + decodeLastBlock(outputStream, (char) bArr2[nextI5], (char) bArr2[nextI6], (char) bArr2[nextI7], (char) bArr2[nextI(bArr2, nextI7 + 1, i13)]);
    }

    public int encode(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[72];
        while (i11 > 0) {
            int min = Math.min(54, i11);
            outputStream.write(bArr2, 0, encode(bArr, i10, min, bArr2, 0));
            i10 += min;
            i11 -= min;
        }
        return ((i11 + 2) / 3) * 4;
    }

    public int encode(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IOException {
        int i13 = (i10 + i11) - 2;
        int i14 = i10;
        int i15 = i12;
        while (i14 < i13) {
            int i16 = i14 + 1;
            byte b10 = bArr[i14];
            int i17 = i16 + 1;
            byte b11 = bArr[i16] & 255;
            int i18 = i17 + 1;
            byte b12 = bArr[i17] & 255;
            int i19 = i15 + 1;
            byte[] bArr3 = this.encodingTable;
            bArr2[i15] = bArr3[(b10 >>> 2) & 63];
            int i20 = i19 + 1;
            bArr2[i19] = bArr3[((b10 << 4) | (b11 >>> 4)) & 63];
            int i21 = i20 + 1;
            bArr2[i20] = bArr3[((b11 << 2) | (b12 >>> 6)) & 63];
            i15 = i21 + 1;
            bArr2[i21] = bArr3[b12 & 63];
            i14 = i18;
        }
        int i22 = i11 - (i14 - i10);
        if (i22 == 1) {
            byte b13 = bArr[i14] & 255;
            int i23 = i15 + 1;
            byte[] bArr4 = this.encodingTable;
            bArr2[i15] = bArr4[(b13 >>> 2) & 63];
            int i24 = i23 + 1;
            bArr2[i23] = bArr4[(b13 << 4) & 63];
            int i25 = i24 + 1;
            byte b14 = this.padding;
            bArr2[i24] = b14;
            i15 = i25 + 1;
            bArr2[i25] = b14;
        } else if (i22 == 2) {
            byte b15 = bArr[i14] & 255;
            byte b16 = bArr[i14 + 1] & 255;
            int i26 = i15 + 1;
            byte[] bArr5 = this.encodingTable;
            bArr2[i15] = bArr5[(b15 >>> 2) & 63];
            int i27 = i26 + 1;
            bArr2[i26] = bArr5[((b15 << 4) | (b16 >>> 4)) & 63];
            int i28 = i27 + 1;
            bArr2[i27] = bArr5[(b16 << 2) & 63];
            i15 = i28 + 1;
            bArr2[i28] = this.padding;
        }
        return i15 - i12;
    }

    public int getEncodedLength(int i10) {
        return ((i10 + 2) / 3) * 4;
    }

    public int getMaxDecodedLength(int i10) {
        return (i10 / 4) * 3;
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
                return;
            }
        }
    }
}
