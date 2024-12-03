package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class CramerShoupCiphertext {

    /* renamed from: e  reason: collision with root package name */
    BigInteger f41420e;

    /* renamed from: u1  reason: collision with root package name */
    BigInteger f41421u1;

    /* renamed from: u2  reason: collision with root package name */
    BigInteger f41422u2;

    /* renamed from: v  reason: collision with root package name */
    BigInteger f41423v;

    public CramerShoupCiphertext() {
    }

    public CramerShoupCiphertext(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f41421u1 = bigInteger;
        this.f41422u2 = bigInteger2;
        this.f41420e = bigInteger3;
        this.f41423v = bigInteger4;
    }

    public CramerShoupCiphertext(byte[] bArr) {
        int bigEndianToInt = Pack.bigEndianToInt(bArr, 0) + 4;
        this.f41421u1 = new BigInteger(Arrays.copyOfRange(bArr, 4, bigEndianToInt));
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr, bigEndianToInt);
        int i10 = bigEndianToInt + 4;
        int i11 = bigEndianToInt2 + i10;
        this.f41422u2 = new BigInteger(Arrays.copyOfRange(bArr, i10, i11));
        int bigEndianToInt3 = Pack.bigEndianToInt(bArr, i11);
        int i12 = i11 + 4;
        int i13 = bigEndianToInt3 + i12;
        this.f41420e = new BigInteger(Arrays.copyOfRange(bArr, i12, i13));
        int bigEndianToInt4 = Pack.bigEndianToInt(bArr, i13);
        int i14 = i13 + 4;
        this.f41423v = new BigInteger(Arrays.copyOfRange(bArr, i14, bigEndianToInt4 + i14));
    }

    public BigInteger getE() {
        return this.f41420e;
    }

    public BigInteger getU1() {
        return this.f41421u1;
    }

    public BigInteger getU2() {
        return this.f41422u2;
    }

    public BigInteger getV() {
        return this.f41423v;
    }

    public void setE(BigInteger bigInteger) {
        this.f41420e = bigInteger;
    }

    public void setU1(BigInteger bigInteger) {
        this.f41421u1 = bigInteger;
    }

    public void setU2(BigInteger bigInteger) {
        this.f41422u2 = bigInteger;
    }

    public void setV(BigInteger bigInteger) {
        this.f41423v = bigInteger;
    }

    public byte[] toByteArray() {
        byte[] byteArray = this.f41421u1.toByteArray();
        int length = byteArray.length;
        byte[] byteArray2 = this.f41422u2.toByteArray();
        int length2 = byteArray2.length;
        byte[] byteArray3 = this.f41420e.toByteArray();
        int length3 = byteArray3.length;
        byte[] byteArray4 = this.f41423v.toByteArray();
        int length4 = byteArray4.length;
        byte[] bArr = new byte[(length + length2 + length3 + length4 + 16)];
        Pack.intToBigEndian(length, bArr, 0);
        System.arraycopy(byteArray, 0, bArr, 4, length);
        int i10 = length + 4;
        Pack.intToBigEndian(length2, bArr, i10);
        int i11 = i10 + 4;
        System.arraycopy(byteArray2, 0, bArr, i11, length2);
        int i12 = i11 + length2;
        Pack.intToBigEndian(length3, bArr, i12);
        int i13 = i12 + 4;
        System.arraycopy(byteArray3, 0, bArr, i13, length3);
        int i14 = i13 + length3;
        Pack.intToBigEndian(length4, bArr, i14);
        System.arraycopy(byteArray4, 0, bArr, i14 + 4, length4);
        return bArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("u1: " + this.f41421u1.toString());
        stringBuffer.append("\nu2: " + this.f41422u2.toString());
        stringBuffer.append("\ne: " + this.f41420e.toString());
        stringBuffer.append("\nv: " + this.f41423v.toString());
        return stringBuffer.toString();
    }
}
