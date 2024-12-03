package org.bouncycastle.pqc.crypto.gmss.util;

public class GMSSUtil {
    public int bytesToIntLittleEndian(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << Tnaf.POW_2_WIDTH);
    }

    public int bytesToIntLittleEndian(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        byte b10 = (bArr[i10] & 255) | ((bArr[i11] & 255) << 8);
        return ((bArr[i12 + 1] & 255) << 24) | b10 | ((bArr[i12] & 255) << Tnaf.POW_2_WIDTH);
    }

    public byte[] concatenateArray(byte[][] bArr) {
        byte[] bArr2 = new byte[(bArr.length * bArr[0].length)];
        int i10 = 0;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte[] bArr3 = bArr[i11];
            System.arraycopy(bArr3, 0, bArr2, i10, bArr3.length);
            i10 += bArr[i11].length;
        }
        return bArr2;
    }

    public int getLog(int i10) {
        int i11 = 1;
        int i12 = 2;
        while (i12 < i10) {
            i12 <<= 1;
            i11++;
        }
        return i11;
    }

    public byte[] intToBytesLittleEndian(int i10) {
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 24) & 255)};
    }

    public void printArray(String str, byte[] bArr) {
        System.out.println(str);
        int i10 = 0;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            System.out.println(i10 + "; " + bArr[i11]);
            i10++;
        }
    }

    public void printArray(String str, byte[][] bArr) {
        System.out.println(str);
        int i10 = 0;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            for (int i12 = 0; i12 < bArr[0].length; i12++) {
                System.out.println(i10 + "; " + bArr[i11][i12]);
                i10++;
            }
        }
    }

    public boolean testPowerOfTwo(int i10) {
        int i11 = 1;
        while (i11 < i10) {
            i11 <<= 1;
        }
        return i10 == i11;
    }
}
