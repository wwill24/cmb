package org.bouncycastle.pqc.crypto.xmss;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public class XMSSUtil {

    private static class CheckingStream extends ObjectInputStream {
        private static final Set components;
        private boolean found = false;
        private final Class mainClass;

        static {
            HashSet hashSet = new HashSet();
            components = hashSet;
            hashSet.add("java.util.TreeMap");
            hashSet.add("java.lang.Integer");
            hashSet.add("java.lang.Number");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDS");
            hashSet.add("java.util.ArrayList");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.XMSSNode");
            hashSet.add("[B");
            hashSet.add("java.util.LinkedList");
            hashSet.add("java.util.Stack");
            hashSet.add("java.util.Vector");
            hashSet.add("[Ljava.lang.Object;");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
        }

        CheckingStream(Class cls, InputStream inputStream) throws IOException {
            super(inputStream);
            this.mainClass = cls;
        }

        /* access modifiers changed from: protected */
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            if (!this.found) {
                if (objectStreamClass.getName().equals(this.mainClass.getName())) {
                    this.found = true;
                } else {
                    throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
                }
            } else if (!components.contains(objectStreamClass.getName())) {
                throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
            }
            return super.resolveClass(objectStreamClass);
        }
    }

    public static boolean areEqual(byte[][] bArr, byte[][] bArr2) {
        if (hasNullPointer(bArr) || hasNullPointer(bArr2)) {
            throw new NullPointerException("a or b == null");
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (!Arrays.areEqual(bArr[i10], bArr2[i10])) {
                return false;
            }
        }
        return true;
    }

    public static long bytesToXBigEndian(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            long j10 = 0;
            for (int i12 = i10; i12 < i10 + i11; i12++) {
                j10 = (j10 << 8) | ((long) (bArr[i12] & 255));
            }
            return j10;
        }
        throw new NullPointerException("in == null");
    }

    public static int calculateTau(int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (((i10 >> i12) & 1) == 0) {
                return i12;
            }
        }
        return 0;
    }

    public static byte[] cloneArray(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        throw new NullPointerException("in == null");
    }

    public static byte[][] cloneArray(byte[][] bArr) {
        if (!hasNullPointer(bArr)) {
            byte[][] bArr2 = new byte[bArr.length][];
            for (int i10 = 0; i10 < bArr.length; i10++) {
                byte[] bArr3 = new byte[bArr[i10].length];
                bArr2[i10] = bArr3;
                byte[] bArr4 = bArr[i10];
                System.arraycopy(bArr4, 0, bArr3, 0, bArr4.length);
            }
            return bArr2;
        }
        throw new NullPointerException("in has null pointers");
    }

    public static void copyBytesAtOffset(byte[] bArr, byte[] bArr2, int i10) {
        if (bArr == null) {
            throw new NullPointerException("dst == null");
        } else if (bArr2 == null) {
            throw new NullPointerException("src == null");
        } else if (i10 < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (bArr2.length + i10 <= bArr.length) {
            for (int i11 = 0; i11 < bArr2.length; i11++) {
                bArr[i10 + i11] = bArr2[i11];
            }
        } else {
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
    }

    public static Object deserialize(byte[] bArr, Class cls) throws IOException, ClassNotFoundException {
        CheckingStream checkingStream = new CheckingStream(cls, new ByteArrayInputStream(bArr));
        Object readObject = checkingStream.readObject();
        if (checkingStream.available() != 0) {
            throw new IOException("unexpected data found at end of ObjectInputStream");
        } else if (cls.isInstance(readObject)) {
            return readObject;
        } else {
            throw new IOException("unexpected class found in ObjectInputStream");
        }
    }

    public static void dumpByteArray(byte[][] bArr) {
        if (!hasNullPointer(bArr)) {
            for (byte[] hexString : bArr) {
                System.out.println(Hex.toHexString(hexString));
            }
            return;
        }
        throw new NullPointerException("x has null pointers");
    }

    public static byte[] extractBytesAtOffset(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new NullPointerException("src == null");
        } else if (i10 < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (i11 < 0) {
            throw new IllegalArgumentException("length hast to be >= 0");
        } else if (i10 + i11 <= bArr.length) {
            byte[] bArr2 = new byte[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                bArr2[i12] = bArr[i10 + i12];
            }
            return bArr2;
        } else {
            throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
    }

    public static int getDigestSize(Digest digest) {
        if (digest != null) {
            String algorithmName = digest.getAlgorithmName();
            if (algorithmName.equals("SHAKE128")) {
                return 32;
            }
            if (algorithmName.equals("SHAKE256")) {
                return 64;
            }
            return digest.getDigestSize();
        }
        throw new NullPointerException("digest == null");
    }

    public static int getLeafIndex(long j10, int i10) {
        return (int) (j10 & ((1 << i10) - 1));
    }

    public static long getTreeIndex(long j10, int i10) {
        return j10 >> i10;
    }

    public static boolean hasNullPointer(byte[][] bArr) {
        if (bArr == null) {
            return true;
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIndexValid(int i10, long j10) {
        if (j10 >= 0) {
            return j10 < (1 << i10);
        }
        throw new IllegalStateException("index must not be negative");
    }

    public static boolean isNewAuthenticationPathNeeded(long j10, int i10, int i11) {
        return j10 != 0 && (j10 + 1) % ((long) Math.pow((double) (1 << i10), (double) i11)) == 0;
    }

    public static boolean isNewBDSInitNeeded(long j10, int i10, int i11) {
        return j10 != 0 && j10 % ((long) Math.pow((double) (1 << i10), (double) (i11 + 1))) == 0;
    }

    public static int log2(int i10) {
        int i11 = 0;
        while (true) {
            i10 >>= 1;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    public static void longToBigEndian(long j10, byte[] bArr, int i10) {
        if (bArr == null) {
            throw new NullPointerException("in == null");
        } else if (bArr.length - i10 >= 8) {
            bArr[i10] = (byte) ((int) ((j10 >> 56) & 255));
            bArr[i10 + 1] = (byte) ((int) ((j10 >> 48) & 255));
            bArr[i10 + 2] = (byte) ((int) ((j10 >> 40) & 255));
            bArr[i10 + 3] = (byte) ((int) ((j10 >> 32) & 255));
            bArr[i10 + 4] = (byte) ((int) ((j10 >> 24) & 255));
            bArr[i10 + 5] = (byte) ((int) ((j10 >> 16) & 255));
            bArr[i10 + 6] = (byte) ((int) ((j10 >> 8) & 255));
            bArr[i10 + 7] = (byte) ((int) (j10 & 255));
        } else {
            throw new IllegalArgumentException("not enough space in array");
        }
    }

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toBytesBigEndian(long j10, int i10) {
        byte[] bArr = new byte[i10];
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            bArr[i11] = (byte) ((int) j10);
            j10 >>>= 8;
        }
        return bArr;
    }
}
