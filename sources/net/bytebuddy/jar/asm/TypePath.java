package net.bytebuddy.jar.asm;

import net.bytebuddy.pool.TypePool;

public final class TypePath {
    public static final int ARRAY_ELEMENT = 0;
    public static final int INNER_TYPE = 1;
    public static final int TYPE_ARGUMENT = 3;
    public static final int WILDCARD_BOUND = 2;
    private final byte[] typePathContainer;
    private final int typePathOffset;

    TypePath(byte[] bArr, int i10) {
        this.typePathContainer = bArr;
        this.typePathOffset = i10;
    }

    public static TypePath fromString(String str) {
        int i10;
        char charAt;
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        ByteVector byteVector = new ByteVector(length);
        byteVector.putByte(0);
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            char charAt2 = str.charAt(i11);
            if (charAt2 == '[') {
                byteVector.put11(0, 0);
            } else if (charAt2 == '.') {
                byteVector.put11(1, 0);
            } else if (charAt2 == '*') {
                byteVector.put11(2, 0);
            } else if (charAt2 < '0' || charAt2 > '9') {
                throw new IllegalArgumentException();
            } else {
                int i13 = charAt2 - '0';
                while (true) {
                    if (i12 >= length) {
                        break;
                    }
                    i10 = i12 + 1;
                    charAt = str.charAt(i12);
                    if (charAt >= '0' && charAt <= '9') {
                        i13 = ((i13 * 10) + charAt) - 48;
                        i12 = i10;
                    }
                }
                if (charAt == ';') {
                    i12 = i10;
                    byteVector.put11(3, i13);
                } else {
                    throw new IllegalArgumentException();
                }
            }
            i11 = i12;
        }
        byte[] bArr = byteVector.data;
        bArr[0] = (byte) (byteVector.length / 2);
        return new TypePath(bArr, 0);
    }

    static void put(TypePath typePath, ByteVector byteVector) {
        if (typePath == null) {
            byteVector.putByte(0);
            return;
        }
        byte[] bArr = typePath.typePathContainer;
        int i10 = typePath.typePathOffset;
        byteVector.putByteArray(bArr, i10, (bArr[i10] * 2) + 1);
    }

    public int getLength() {
        return this.typePathContainer[this.typePathOffset];
    }

    public int getStep(int i10) {
        return this.typePathContainer[this.typePathOffset + (i10 * 2) + 1];
    }

    public int getStepArgument(int i10) {
        return this.typePathContainer[this.typePathOffset + (i10 * 2) + 2];
    }

    public String toString() {
        int length = getLength();
        StringBuilder sb2 = new StringBuilder(length * 2);
        for (int i10 = 0; i10 < length; i10++) {
            int step = getStep(i10);
            if (step == 0) {
                sb2.append('[');
            } else if (step == 1) {
                sb2.append('.');
            } else if (step == 2) {
                sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
            } else if (step == 3) {
                sb2.append(getStepArgument(i10));
                sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
            } else {
                throw new AssertionError();
            }
        }
        return sb2.toString();
    }
}
