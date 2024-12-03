package org.jivesoftware.smack.util.stringencoder;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Base32 {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
    private static final StringEncoder<String> base32Stringencoder = new StringEncoder<String>() {
        public String decode(String str) {
            return Base32.decode(str);
        }

        public String encode(String str) {
            return Base32.encode(str);
        }
    };

    public static String decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        for (byte b10 : bytes) {
            char c10 = (char) b10;
            if (!Character.isWhitespace(c10)) {
                byteArrayOutputStream.write((byte) Character.toUpperCase(c10));
            }
        }
        while (byteArrayOutputStream.size() % 8 != 0) {
            byteArrayOutputStream.write(56);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i10 = 0; i10 < byteArray.length / 8; i10++) {
            short[] sArr = new short[8];
            int[] iArr = new int[5];
            int i11 = 8;
            for (int i12 = 0; i12 < 8; i12++) {
                byte b11 = byteArray[(i10 * 8) + i12];
                if (((char) b11) == '8') {
                    break;
                }
                short indexOf = (short) ALPHABET.indexOf(b11);
                sArr[i12] = indexOf;
                if (indexOf < 0) {
                    return null;
                }
                i11--;
            }
            int paddingToLen = paddingToLen(i11);
            if (paddingToLen < 0) {
                return null;
            }
            short s10 = sArr[1];
            iArr[0] = (sArr[0] << 3) | (s10 >> 2);
            int i13 = ((s10 & 3) << 6) | (sArr[2] << 1);
            short s11 = sArr[3];
            iArr[1] = i13 | (s11 >> 4);
            short s12 = sArr[4];
            iArr[2] = ((s11 & 15) << 4) | ((s12 >> 1) & 15);
            short s13 = sArr[6];
            iArr[3] = (s12 << 7) | (sArr[5] << 2) | (s13 >> 3);
            iArr[4] = sArr[7] | ((s13 & 7) << 5);
            int i14 = 0;
            while (i14 < paddingToLen) {
                try {
                    dataOutputStream.writeByte((byte) (iArr[i14] & 255));
                    i14++;
                } catch (IOException unused) {
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
    }

    public static String encode(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i10 = 0; i10 < (bytes.length + 4) / 5; i10++) {
            short[] sArr = new short[5];
            int[] iArr = new int[8];
            int i11 = 5;
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = (i10 * 5) + i12;
                if (i13 < bytes.length) {
                    sArr[i12] = (short) (bytes[i13] & 255);
                } else {
                    sArr[i12] = 0;
                    i11--;
                }
            }
            int lenToPadding = lenToPadding(i11);
            short s10 = sArr[0];
            iArr[0] = (byte) ((s10 >> 3) & 31);
            short s11 = sArr[1];
            iArr[1] = (byte) (((s10 & 7) << 2) | ((s11 >> 6) & 3));
            iArr[2] = (byte) ((s11 >> 1) & 31);
            short s12 = sArr[2];
            iArr[3] = (byte) (((s11 & 1) << 4) | ((s12 >> 4) & 15));
            short s13 = sArr[3];
            iArr[4] = (byte) (((s12 & 15) << 1) | (1 & (s13 >> 7)));
            iArr[5] = (byte) ((s13 >> 2) & 31);
            short s14 = sArr[4];
            iArr[6] = (byte) (((s14 >> 5) & 7) | ((s13 & 3) << 3));
            iArr[7] = (byte) (s14 & 31);
            for (int i14 = 0; i14 < 8 - lenToPadding; i14++) {
                byteArrayOutputStream.write(ALPHABET.charAt(iArr[i14]));
            }
        }
        return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
    }

    public static StringEncoder<String> getStringEncoder() {
        return base32Stringencoder;
    }

    private static int lenToPadding(int i10) {
        if (i10 == 1) {
            return 6;
        }
        if (i10 == 2) {
            return 4;
        }
        if (i10 == 3) {
            return 3;
        }
        if (i10 != 4) {
            return i10 != 5 ? -1 : 0;
        }
        return 1;
    }

    private static int paddingToLen(int i10) {
        if (i10 == 0) {
            return 5;
        }
        if (i10 == 1) {
            return 4;
        }
        if (i10 == 3) {
            return 3;
        }
        if (i10 != 4) {
            return i10 != 6 ? -1 : 1;
        }
        return 2;
    }
}
