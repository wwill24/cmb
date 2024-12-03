package org.bouncycastle.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;
import org.bouncycastle.util.encoders.UTF8;

public final class Strings {
    private static String LINE_SEPARATOR;

    private static class StringListImpl extends ArrayList<String> implements StringList {
        private StringListImpl() {
        }

        public void add(int i10, String str) {
            super.add(i10, str);
        }

        public boolean add(String str) {
            return super.add(str);
        }

        public /* bridge */ /* synthetic */ String get(int i10) {
            return (String) super.get(i10);
        }

        public String set(int i10, String str) {
            return (String) super.set(i10, str);
        }

        public String[] toStringArray() {
            int size = size();
            String[] strArr = new String[size];
            for (int i10 = 0; i10 != size; i10++) {
                strArr[i10] = (String) get(i10);
            }
            return strArr;
        }

        public String[] toStringArray(int i10, int i11) {
            String[] strArr = new String[(i11 - i10)];
            int i12 = i10;
            while (i12 != size() && i12 != i11) {
                strArr[i12 - i10] = (String) get(i12);
                i12++;
            }
            return strArr;
        }
    }

    static {
        try {
            LINE_SEPARATOR = (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
                public String run() {
                    return System.getProperty("line.separator");
                }
            });
        } catch (Exception unused) {
            try {
                LINE_SEPARATOR = String.format("%n", new Object[0]);
            } catch (Exception unused2) {
                LINE_SEPARATOR = "\n";
            }
        }
    }

    public static char[] asCharArray(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 != length; i10++) {
            cArr[i10] = (char) (bArr[i10] & 255);
        }
        return cArr;
    }

    public static boolean constantTimeAreEqual(String str, String str2) {
        boolean z10 = str.length() == str2.length();
        int length = str.length();
        for (int i10 = 0; i10 != length; i10++) {
            z10 &= str.charAt(i10) == str2.charAt(i10);
        }
        return z10;
    }

    public static String fromByteArray(byte[] bArr) {
        return new String(asCharArray(bArr));
    }

    public static String fromUTF8ByteArray(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int transcodeToUTF16 = UTF8.transcodeToUTF16(bArr, cArr);
        if (transcodeToUTF16 >= 0) {
            return new String(cArr, 0, transcodeToUTF16);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    public static String lineSeparator() {
        return LINE_SEPARATOR;
    }

    public static StringList newList() {
        return new StringListImpl();
    }

    public static String[] split(String str, char c10) {
        int i10;
        Vector vector = new Vector();
        boolean z10 = true;
        while (true) {
            if (!z10) {
                break;
            }
            int indexOf = str.indexOf(c10);
            if (indexOf > 0) {
                vector.addElement(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
            } else {
                vector.addElement(str);
                z10 = false;
            }
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (i10 = 0; i10 != size; i10++) {
            strArr[i10] = (String) vector.elementAt(i10);
        }
        return strArr;
    }

    public static int toByteArray(String str, byte[] bArr, int i10) {
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i10 + i11] = (byte) str.charAt(i11);
        }
        return length;
    }

    public static byte[] toByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 != length; i10++) {
            bArr[i10] = (byte) str.charAt(i10);
        }
        return bArr;
    }

    public static byte[] toByteArray(char[] cArr) {
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 != length; i10++) {
            bArr[i10] = (byte) cArr[i10];
        }
        return bArr;
    }

    public static String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z10 = false;
        for (int i10 = 0; i10 != charArray.length; i10++) {
            char c10 = charArray[i10];
            if ('A' <= c10 && 'Z' >= c10) {
                charArray[i10] = (char) ((c10 - 'A') + 97);
                z10 = true;
            }
        }
        return z10 ? new String(charArray) : str;
    }

    public static void toUTF8ByteArray(char[] cArr, OutputStream outputStream) throws IOException {
        int i10;
        int i11;
        int i12 = 0;
        while (i12 < cArr.length) {
            char c10 = cArr[i12];
            char c11 = c10;
            if (c10 >= 128) {
                if (c10 < 2048) {
                    i11 = (c10 >> 6) | 192;
                } else if (c10 < 55296 || c10 > 57343) {
                    outputStream.write((c10 >> 12) | 224);
                    i11 = ((c10 >> 6) & 63) | 128;
                } else {
                    i12++;
                    if (i12 < cArr.length) {
                        char c12 = cArr[i12];
                        if (c10 <= 56319) {
                            i10 = (((c10 & 1023) << 10) | (c12 & 1023)) + 0;
                            outputStream.write((i10 >> 18) | 240);
                            outputStream.write(((i10 >> 12) & 63) | 128);
                            outputStream.write(((i10 >> 6) & 63) | 128);
                            c11 = (i10 & true) | true;
                        } else {
                            throw new IllegalStateException("invalid UTF-16 codepoint");
                        }
                    } else {
                        throw new IllegalStateException("invalid UTF-16 codepoint");
                    }
                }
                outputStream.write(i11);
                i10 = c10;
                c11 = (i10 & true) | true;
            }
            outputStream.write(c11);
            i12++;
        }
    }

    public static byte[] toUTF8ByteArray(String str) {
        return toUTF8ByteArray(str.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char[] cArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            toUTF8ByteArray(cArr, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }

    public static String toUpperCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z10 = false;
        for (int i10 = 0; i10 != charArray.length; i10++) {
            char c10 = charArray[i10];
            if ('a' <= c10 && 'z' >= c10) {
                charArray[i10] = (char) ((c10 - 'a') + 65);
                z10 = true;
            }
        }
        return z10 ? new String(charArray) : str;
    }
}
