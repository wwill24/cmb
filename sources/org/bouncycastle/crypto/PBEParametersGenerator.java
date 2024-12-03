package org.bouncycastle.crypto;

import org.bouncycastle.util.Strings;

public abstract class PBEParametersGenerator {
    protected int iterationCount;
    protected byte[] password;
    protected byte[] salt;

    protected PBEParametersGenerator() {
    }

    public static byte[] PKCS12PasswordToBytes(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[((cArr.length + 1) * 2)];
        for (int i10 = 0; i10 != cArr.length; i10++) {
            int i11 = i10 * 2;
            char c10 = cArr[i10];
            bArr[i11] = (byte) (c10 >>> 8);
            bArr[i11 + 1] = (byte) c10;
        }
        return bArr;
    }

    public static byte[] PKCS5PasswordToBytes(char[] cArr) {
        if (cArr == null) {
            return new byte[0];
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 != length; i10++) {
            bArr[i10] = (byte) cArr[i10];
        }
        return bArr;
    }

    public static byte[] PKCS5PasswordToUTF8Bytes(char[] cArr) {
        return cArr != null ? Strings.toUTF8ByteArray(cArr) : new byte[0];
    }

    public abstract CipherParameters generateDerivedMacParameters(int i10);

    public abstract CipherParameters generateDerivedParameters(int i10);

    public abstract CipherParameters generateDerivedParameters(int i10, int i11);

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getPassword() {
        return this.password;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public void init(byte[] bArr, byte[] bArr2, int i10) {
        this.password = bArr;
        this.salt = bArr2;
        this.iterationCount = i10;
    }
}
