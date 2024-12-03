package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class Base32Encoder implements Encoder {
    private static final byte[] DEAULT_ENCODING_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55};
    private static final byte DEFAULT_PADDING = 61;
    private final byte[] decodingTable;
    private final byte[] encodingTable;
    private final byte padding;

    public Base32Encoder() {
        this.decodingTable = new byte[128];
        this.encodingTable = DEAULT_ENCODING_TABLE;
        this.padding = DEFAULT_PADDING;
        initialiseDecodingTable();
    }

    public Base32Encoder(byte[] bArr, byte b10) {
        this.decodingTable = new byte[128];
        if (bArr.length == 32) {
            this.encodingTable = Arrays.clone(bArr);
            this.padding = b10;
            initialiseDecodingTable();
            return;
        }
        throw new IllegalArgumentException("encoding table needs to be length 32");
    }

    private int decodeLastBlock(OutputStream outputStream, char c10, char c11, char c12, char c13, char c14, char c15, char c16, char c17) throws IOException {
        byte b10 = this.padding;
        if (c17 != b10) {
            byte[] bArr = this.decodingTable;
            byte b11 = bArr[c10];
            byte b12 = bArr[c11];
            byte b13 = bArr[c12];
            byte b14 = bArr[c13];
            byte b15 = bArr[c14];
            byte b16 = bArr[c15];
            byte b17 = bArr[c16];
            byte b18 = bArr[c17];
            if ((b11 | b12 | b13 | b14 | b15 | b16 | b17 | b18) >= 0) {
                outputStream.write((b11 << 3) | (b12 >> 2));
                outputStream.write((b12 << 6) | (b13 << 1) | (b14 >> 4));
                outputStream.write((b14 << 4) | (b15 >> 1));
                outputStream.write((b15 << 7) | (b16 << 2) | (b17 >> 3));
                outputStream.write((b17 << 5) | b18);
                return 5;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c16 != b10) {
            byte[] bArr2 = this.decodingTable;
            byte b19 = bArr2[c10];
            byte b20 = bArr2[c11];
            byte b21 = bArr2[c12];
            byte b22 = bArr2[c13];
            byte b23 = bArr2[c14];
            byte b24 = bArr2[c15];
            byte b25 = bArr2[c16];
            if ((b19 | b20 | b21 | b22 | b23 | b24 | b25) >= 0) {
                outputStream.write((b19 << 3) | (b20 >> 2));
                outputStream.write((b20 << 6) | (b21 << 1) | (b22 >> 4));
                outputStream.write((b22 << 4) | (b23 >> 1));
                outputStream.write((b23 << 7) | (b24 << 2) | (b25 >> 3));
                return 4;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c15 != b10) {
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c14 != b10) {
            byte[] bArr3 = this.decodingTable;
            byte b26 = bArr3[c10];
            byte b27 = bArr3[c11];
            byte b28 = bArr3[c12];
            byte b29 = bArr3[c13];
            byte b30 = bArr3[c14];
            if ((b26 | b27 | b28 | b29 | b30) >= 0) {
                outputStream.write((b26 << 3) | (b27 >> 2));
                outputStream.write((b27 << 6) | (b28 << 1) | (b29 >> 4));
                outputStream.write((b29 << 4) | (b30 >> 1));
                return 3;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c13 != b10) {
            byte[] bArr4 = this.decodingTable;
            byte b31 = bArr4[c10];
            byte b32 = bArr4[c11];
            byte b33 = bArr4[c12];
            byte b34 = bArr4[c13];
            if ((b31 | b32 | b33 | b34) >= 0) {
                outputStream.write((b31 << 3) | (b32 >> 2));
                outputStream.write((b32 << 6) | (b33 << 1) | (b34 >> 4));
                return 2;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c12 == b10) {
            byte[] bArr5 = this.decodingTable;
            byte b35 = bArr5[c10];
            byte b36 = bArr5[c11];
            if ((b35 | b36) >= 0) {
                outputStream.write((b35 << 3) | (b36 >> 2));
                return 1;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else {
            throw new IOException("invalid characters encountered at end of base32 data");
        }
    }

    private void encodeBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int i12 = i10 + 1;
        byte b10 = bArr[i10];
        int i13 = i12 + 1;
        byte b11 = bArr[i12] & 255;
        int i14 = i13 + 1;
        byte b12 = bArr[i13] & 255;
        int i15 = i14 + 1;
        byte b13 = bArr[i14] & 255;
        byte b14 = bArr[i15] & 255;
        int i16 = i11 + 1;
        byte[] bArr3 = this.encodingTable;
        bArr2[i11] = bArr3[(b10 >>> 3) & 31];
        int i17 = i16 + 1;
        bArr2[i16] = bArr3[((b10 << 2) | (b11 >>> 6)) & 31];
        int i18 = i17 + 1;
        bArr2[i17] = bArr3[(b11 >>> 1) & 31];
        int i19 = i18 + 1;
        bArr2[i18] = bArr3[((b11 << 4) | (b12 >>> 4)) & 31];
        int i20 = i19 + 1;
        bArr2[i19] = bArr3[((b12 << 1) | (b13 >>> 7)) & 31];
        int i21 = i20 + 1;
        bArr2[i20] = bArr3[(b13 >>> 2) & 31];
        bArr2[i21] = bArr3[((b13 << 3) | (b14 >>> 5)) & 31];
        bArr2[i21 + 1] = bArr3[b14 & 31];
    }

    private boolean ignore(char c10) {
        return c10 == 10 || c10 == 13 || c10 == 9 || c10 == ' ';
    }

    private int nextI(byte[] bArr, int i10, int i11) {
        while (i10 < i11 && ignore((char) bArr[i10])) {
            i10++;
        }
        return i10;
    }

    public int decode(String str, OutputStream outputStream) throws IOException {
        byte[] byteArray = Strings.toByteArray(str);
        return decode(byteArray, 0, byteArray.length, outputStream);
    }

    public int decode(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException {
        byte[] bArr2 = bArr;
        int i12 = i10;
        OutputStream outputStream2 = outputStream;
        byte[] bArr3 = new byte[55];
        int i13 = i12 + i11;
        while (i13 > i12 && ignore((char) bArr2[i13 - 1])) {
            i13--;
        }
        if (i13 == 0) {
            return 0;
        }
        int i14 = i13;
        int i15 = 0;
        while (i14 > i12 && i15 != 8) {
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
            int nextI5 = nextI(bArr2, i21, i14);
            int i22 = nextI5 + 1;
            byte b14 = this.decodingTable[bArr2[nextI5]];
            int nextI6 = nextI(bArr2, i22, i14);
            int i23 = nextI6 + 1;
            byte b15 = this.decodingTable[bArr2[nextI6]];
            int nextI7 = nextI(bArr2, i23, i14);
            int i24 = i13;
            int i25 = nextI7 + 1;
            byte b16 = this.decodingTable[bArr2[nextI7]];
            int nextI8 = nextI(bArr2, i25, i14);
            int i26 = i14;
            int i27 = nextI8 + 1;
            byte b17 = this.decodingTable[bArr2[nextI8]];
            if ((b10 | b11 | b12 | b13 | b14 | b15 | b16 | b17) >= 0) {
                int i28 = i16 + 1;
                bArr3[i16] = (byte) ((b10 << 3) | (b11 >> 2));
                int i29 = i28 + 1;
                bArr3[i28] = (byte) ((b11 << 6) | (b12 << 1) | (b13 >> 4));
                int i30 = i29 + 1;
                bArr3[i29] = (byte) ((b13 << 4) | (b14 >> 1));
                int i31 = i30 + 1;
                bArr3[i30] = (byte) ((b15 << 2) | (b14 << 7) | (b16 >> 3));
                int i32 = i31 + 1;
                bArr3[i31] = (byte) ((b16 << 5) | b17);
                if (i32 == 55) {
                    outputStream2.write(bArr3);
                    i16 = 0;
                } else {
                    i16 = i32;
                }
                i17 += 5;
                int i33 = i26;
                int nextI9 = nextI(bArr2, i27, i33);
                i14 = i33;
                i13 = i24;
                nextI = nextI9;
            } else {
                throw new IOException("invalid characters encountered in base32 data");
            }
        }
        int i34 = i13;
        if (i16 > 0) {
            outputStream2.write(bArr3, 0, i16);
        }
        int i35 = i34;
        int nextI10 = nextI(bArr2, nextI, i35);
        int nextI11 = nextI(bArr2, nextI10 + 1, i35);
        int nextI12 = nextI(bArr2, nextI11 + 1, i35);
        int nextI13 = nextI(bArr2, nextI12 + 1, i35);
        int nextI14 = nextI(bArr2, nextI13 + 1, i35);
        int nextI15 = nextI(bArr2, nextI14 + 1, i35);
        int nextI16 = nextI(bArr2, nextI15 + 1, i35);
        return i17 + decodeLastBlock(outputStream, (char) bArr2[nextI10], (char) bArr2[nextI11], (char) bArr2[nextI12], (char) bArr2[nextI13], (char) bArr2[nextI14], (char) bArr2[nextI15], (char) bArr2[nextI16], (char) bArr2[nextI(bArr2, nextI16 + 1, i35)]);
    }

    public int encode(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[72];
        while (i11 > 0) {
            int min = Math.min(45, i11);
            outputStream.write(bArr2, 0, encode(bArr, i10, min, bArr2, 0));
            i10 += min;
            i11 -= min;
        }
        return ((i11 + 2) / 3) * 4;
    }

    public int encode(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IOException {
        int i13 = (i10 + i11) - 4;
        int i14 = i10;
        int i15 = i12;
        while (i14 < i13) {
            encodeBlock(bArr, i14, bArr2, i15);
            i14 += 5;
            i15 += 8;
        }
        int i16 = i11 - (i14 - i10);
        if (i16 > 0) {
            byte[] bArr3 = new byte[5];
            System.arraycopy(bArr, i14, bArr3, 0, i16);
            encodeBlock(bArr3, 0, bArr2, i15);
            if (i16 == 1) {
                byte b10 = this.padding;
                bArr2[i15 + 2] = b10;
                bArr2[i15 + 3] = b10;
                bArr2[i15 + 4] = b10;
                bArr2[i15 + 5] = b10;
                bArr2[i15 + 6] = b10;
                bArr2[i15 + 7] = b10;
            } else if (i16 == 2) {
                byte b11 = this.padding;
                bArr2[i15 + 4] = b11;
                bArr2[i15 + 5] = b11;
                bArr2[i15 + 6] = b11;
                bArr2[i15 + 7] = b11;
            } else if (i16 == 3) {
                byte b12 = this.padding;
                bArr2[i15 + 5] = b12;
                bArr2[i15 + 6] = b12;
                bArr2[i15 + 7] = b12;
            } else if (i16 == 4) {
                bArr2[i15 + 7] = this.padding;
            }
            i15 += 8;
        }
        return i15 - i12;
    }

    public int getEncodedLength(int i10) {
        return ((i10 + 4) / 5) * 8;
    }

    public int getMaxDecodedLength(int i10) {
        return (i10 / 8) * 5;
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
