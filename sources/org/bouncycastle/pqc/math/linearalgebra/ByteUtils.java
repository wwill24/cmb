package org.bouncycastle.pqc.math.linearalgebra;

import net.bytebuddy.asm.Advice;

public final class ByteUtils {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};

    private ByteUtils() {
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] concatenate(byte[][] bArr) {
        int length = bArr[0].length;
        byte[] bArr2 = new byte[(bArr.length * length)];
        int i10 = 0;
        for (byte[] arraycopy : bArr) {
            System.arraycopy(arraycopy, 0, bArr2, i10, length);
            i10 += length;
        }
        return bArr2;
    }

    public static int deepHashCode(byte[] bArr) {
        int i10 = 1;
        for (byte b10 : bArr) {
            i10 = (i10 * 31) + b10;
        }
        return i10;
    }

    public static int deepHashCode(byte[][] bArr) {
        int i10 = 1;
        for (byte[] deepHashCode : bArr) {
            i10 = (i10 * 31) + deepHashCode(deepHashCode);
        }
        return i10;
    }

    public static int deepHashCode(byte[][][] bArr) {
        int i10 = 1;
        for (byte[][] deepHashCode : bArr) {
            i10 = (i10 * 31) + deepHashCode(deepHashCode);
        }
        return i10;
    }

    public static boolean equals(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2 == null;
        }
        if (bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        boolean z10 = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            z10 &= bArr[length] == bArr2[length];
        }
        return z10;
    }

    public static boolean equals(byte[][] bArr, byte[][] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        boolean z10 = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            z10 &= equals(bArr[length], bArr2[length]);
        }
        return z10;
    }

    public static boolean equals(byte[][][] bArr, byte[][][] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        boolean z10 = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            byte[][] bArr3 = bArr[length];
            if (bArr3.length != bArr2[length].length) {
                return false;
            }
            for (int length2 = bArr3.length - 1; length2 >= 0; length2--) {
                z10 &= equals(bArr[length][length2], bArr2[length][length2]);
            }
        }
        return z10;
    }

    public static byte[] fromHexString(String str) {
        char[] charArray = str.toUpperCase().toCharArray();
        int i10 = 0;
        for (char c10 : charArray) {
            if ((c10 >= '0' && c10 <= '9') || (c10 >= 'A' && c10 <= 'F')) {
                i10++;
            }
        }
        byte[] bArr = new byte[((i10 + 1) >> 1)];
        int i11 = i10 & 1;
        for (char c11 : charArray) {
            if (c11 < '0' || c11 > '9') {
                if (c11 >= 'A' && c11 <= 'F') {
                    int i12 = i11 >> 1;
                    byte b10 = (byte) (bArr[i12] << 4);
                    bArr[i12] = b10;
                    bArr[i12] = (byte) (((c11 - 'A') + 10) | b10);
                }
            } else {
                int i13 = i11 >> 1;
                byte b11 = (byte) (bArr[i13] << 4);
                bArr[i13] = b11;
                bArr[i13] = (byte) ((c11 - '0') | b11);
            }
            i11++;
        }
        return bArr;
    }

    public static byte[][] split(byte[] bArr, int i10) throws ArrayIndexOutOfBoundsException {
        if (i10 <= bArr.length) {
            byte[] bArr2 = new byte[i10];
            byte[][] bArr3 = {bArr2, new byte[(bArr.length - i10)]};
            System.arraycopy(bArr, 0, bArr2, 0, i10);
            System.arraycopy(bArr, i10, bArr3[1], 0, bArr.length - i10);
            return bArr3;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static byte[] subArray(byte[] bArr, int i10) {
        return subArray(bArr, i10, bArr.length);
    }

    public static byte[] subArray(byte[] bArr, int i10, int i11) {
        int i12 = i11 - i10;
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i10, bArr2, 0, i12);
        return bArr2;
    }

    public static String toBinaryString(byte[] bArr) {
        String str = "";
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            for (int i11 = 0; i11 < 8; i11++) {
                str = str + ((b10 >>> i11) & 1);
            }
            if (i10 != bArr.length - 1) {
                str = str + " ";
            }
        }
        return str;
    }

    public static char[] toCharArray(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            cArr[i10] = (char) bArr[i10];
        }
        return cArr;
    }

    public static String toHexString(byte[] bArr) {
        String str = "";
        for (int i10 = 0; i10 < bArr.length; i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            char[] cArr = HEX_CHARS;
            sb2.append(cArr[(bArr[i10] >>> 4) & 15]);
            str = sb2.toString() + cArr[bArr[i10] & 15];
        }
        return str;
    }

    public static String toHexString(byte[] bArr, String str, String str2) {
        String str3 = new String(str);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            char[] cArr = HEX_CHARS;
            sb2.append(cArr[(bArr[i10] >>> 4) & 15]);
            str3 = sb2.toString() + cArr[bArr[i10] & 15];
            if (i10 < bArr.length - 1) {
                str3 = str3 + str2;
            }
        }
        return str3;
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr3[length] = (byte) (bArr[length] ^ bArr2[length]);
        }
        return bArr3;
    }
}
