package org.bouncycastle.util.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

public class FixedSecureRandom extends SecureRandom {
    private static java.math.BigInteger ANDROID = new java.math.BigInteger("1111111105060708ffffffff01020304", 16);
    private static java.math.BigInteger CLASSPATH = new java.math.BigInteger("3020104ffffffff05060708111111", 16);
    private static java.math.BigInteger REGULAR = new java.math.BigInteger("01020304ffffffff0506070811111111", 16);
    private static final boolean isAndroidStyle;
    private static final boolean isClasspathStyle;
    private static final boolean isRegularStyle;
    private byte[] _data;
    private int _index;

    public static class BigInteger extends Source {
        public BigInteger(int i10, String str) {
            super(FixedSecureRandom.expandToBitLength(i10, Hex.decode(str)));
        }

        public BigInteger(int i10, byte[] bArr) {
            super(FixedSecureRandom.expandToBitLength(i10, bArr));
        }

        public BigInteger(String str) {
            this(Hex.decode(str));
        }

        public BigInteger(byte[] bArr) {
            super(bArr);
        }
    }

    public static class Data extends Source {
        public Data(byte[] bArr) {
            super(bArr);
        }
    }

    private static class DummyProvider extends Provider {
        DummyProvider() {
            super("BCFIPS_FIXED_RNG", 1.0d, "BCFIPS Fixed Secure Random Provider");
        }
    }

    private static class RandomChecker extends SecureRandom {
        byte[] data = Hex.decode("01020304ffffffff0506070811111111");
        int index = 0;

        RandomChecker() {
            super((SecureRandomSpi) null, new DummyProvider());
        }

        public void nextBytes(byte[] bArr) {
            System.arraycopy(this.data, this.index, bArr, 0, bArr.length);
            this.index += bArr.length;
        }
    }

    public static class Source {
        byte[] data;

        Source(byte[] bArr) {
            this.data = bArr;
        }
    }

    static {
        java.math.BigInteger bigInteger = new java.math.BigInteger(128, new RandomChecker());
        java.math.BigInteger bigInteger2 = new java.math.BigInteger(120, new RandomChecker());
        isAndroidStyle = bigInteger.equals(ANDROID);
        isRegularStyle = bigInteger.equals(REGULAR);
        isClasspathStyle = bigInteger2.equals(CLASSPATH);
    }

    public FixedSecureRandom(byte[] bArr) {
        this(new Source[]{new Data(bArr)});
    }

    public FixedSecureRandom(Source[] sourceArr) {
        super((SecureRandomSpi) null, new DummyProvider());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        if (isRegularStyle) {
            if (isClasspathStyle) {
                while (i10 != sourceArr.length) {
                    try {
                        Source source = sourceArr[i10];
                        if (source instanceof BigInteger) {
                            byte[] bArr = source.data;
                            int length = bArr.length - (bArr.length % 4);
                            for (int length2 = (bArr.length - length) - 1; length2 >= 0; length2--) {
                                byteArrayOutputStream.write(bArr[length2]);
                            }
                            for (int length3 = bArr.length - length; length3 < bArr.length; length3 += 4) {
                                byteArrayOutputStream.write(bArr, length3, 4);
                            }
                        } else {
                            byteArrayOutputStream.write(source.data);
                        }
                        i10++;
                    } catch (IOException unused) {
                        throw new IllegalArgumentException("can't save value source.");
                    }
                }
            } else {
                while (i10 != sourceArr.length) {
                    try {
                        byteArrayOutputStream.write(sourceArr[i10].data);
                        i10++;
                    } catch (IOException unused2) {
                        throw new IllegalArgumentException("can't save value source.");
                    }
                }
            }
        } else if (isAndroidStyle) {
            int i11 = 0;
            while (i11 != sourceArr.length) {
                try {
                    Source source2 = sourceArr[i11];
                    if (source2 instanceof BigInteger) {
                        byte[] bArr2 = source2.data;
                        int length4 = bArr2.length - (bArr2.length % 4);
                        int i12 = 0;
                        while (i12 < length4) {
                            i12 += 4;
                            byteArrayOutputStream.write(bArr2, bArr2.length - i12, 4);
                        }
                        if (bArr2.length - length4 != 0) {
                            for (int i13 = 0; i13 != 4 - (bArr2.length - length4); i13++) {
                                byteArrayOutputStream.write(0);
                            }
                        }
                        for (int i14 = 0; i14 != bArr2.length - length4; i14++) {
                            byteArrayOutputStream.write(bArr2[length4 + i14]);
                        }
                    } else {
                        byteArrayOutputStream.write(source2.data);
                    }
                    i11++;
                } catch (IOException unused3) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        } else {
            throw new IllegalStateException("Unrecognized BigInteger implementation");
        }
        this._data = byteArrayOutputStream.toByteArray();
    }

    public FixedSecureRandom(byte[][] bArr) {
        this((Source[]) buildDataArray(bArr));
    }

    private static Data[] buildDataArray(byte[][] bArr) {
        Data[] dataArr = new Data[bArr.length];
        for (int i10 = 0; i10 != bArr.length; i10++) {
            dataArr[i10] = new Data(bArr[i10]);
        }
        return dataArr;
    }

    /* access modifiers changed from: private */
    public static byte[] expandToBitLength(int i10, byte[] bArr) {
        int i11;
        int i12;
        int i13 = (i10 + 7) / 8;
        if (i13 > bArr.length) {
            byte[] bArr2 = new byte[i13];
            System.arraycopy(bArr, 0, bArr2, i13 - bArr.length, bArr.length);
            if (isAndroidStyle && (i12 = i10 % 8) != 0) {
                Pack.intToBigEndian(Pack.bigEndianToInt(bArr2, 0) << (8 - i12), bArr2, 0);
            }
            return bArr2;
        }
        if (isAndroidStyle && i10 < bArr.length * 8 && (i11 = i10 % 8) != 0) {
            Pack.intToBigEndian(Pack.bigEndianToInt(bArr, 0) << (8 - i11), bArr, 0);
        }
        return bArr;
    }

    private int nextValue() {
        byte[] bArr = this._data;
        int i10 = this._index;
        this._index = i10 + 1;
        return bArr[i10] & 255;
    }

    public byte[] generateSeed(int i10) {
        byte[] bArr = new byte[i10];
        nextBytes(bArr);
        return bArr;
    }

    public boolean isExhausted() {
        return this._index == this._data.length;
    }

    public void nextBytes(byte[] bArr) {
        System.arraycopy(this._data, this._index, bArr, 0, bArr.length);
        this._index += bArr.length;
    }

    public int nextInt() {
        return (nextValue() << 24) | 0 | (nextValue() << 16) | (nextValue() << 8) | nextValue();
    }

    public long nextLong() {
        return (((long) nextValue()) << 56) | 0 | (((long) nextValue()) << 48) | (((long) nextValue()) << 40) | (((long) nextValue()) << 32) | (((long) nextValue()) << 24) | (((long) nextValue()) << 16) | (((long) nextValue()) << 8) | ((long) nextValue());
    }
}
