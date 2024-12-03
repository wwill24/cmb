package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

public class ASN1Integer extends ASN1Primitive {
    static final int SIGN_EXT_SIGNED = -1;
    static final int SIGN_EXT_UNSIGNED = 255;
    private final byte[] bytes;
    private final int start;

    public ASN1Integer(long j10) {
        this.bytes = BigInteger.valueOf(j10).toByteArray();
        this.start = 0;
    }

    public ASN1Integer(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
        this.start = 0;
    }

    public ASN1Integer(byte[] bArr) {
        this(bArr, true);
    }

    ASN1Integer(byte[] bArr, boolean z10) {
        if (!isMalformed(bArr)) {
            this.bytes = z10 ? Arrays.clone(bArr) : bArr;
            this.start = signBytesToSkip(bArr);
            return;
        }
        throw new IllegalArgumentException("malformed integer");
    }

    public static ASN1Integer getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Integer)) {
            return (ASN1Integer) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1Integer) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e10) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1Integer getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z10 || (object instanceof ASN1Integer)) ? getInstance(object) : new ASN1Integer(ASN1OctetString.getInstance(object).getOctets());
    }

    static int intValue(byte[] bArr, int i10, int i11) {
        int length = bArr.length;
        int max = Math.max(i10, length - 4);
        byte b10 = i11 & bArr[max];
        while (true) {
            max++;
            if (max >= length) {
                return b10;
            }
            b10 = (b10 << 8) | (bArr[max] & 255);
        }
    }

    static boolean isMalformed(byte[] bArr) {
        int length = bArr.length;
        if (length == 0) {
            return true;
        }
        if (length != 1) {
            return bArr[0] == (bArr[1] >> 7) && !Properties.isOverrideSet("org.bouncycastle.asn1.allow_unsafe_integer");
        }
        return false;
    }

    static long longValue(byte[] bArr, int i10, int i11) {
        int length = bArr.length;
        int max = Math.max(i10, length - 8);
        long j10 = (long) (i11 & bArr[max]);
        while (true) {
            max++;
            if (max >= length) {
                return j10;
            }
            j10 = (j10 << 8) | ((long) (bArr[max] & 255));
        }
    }

    static int signBytesToSkip(byte[] bArr) {
        int length = bArr.length - 1;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            if (bArr[i10] != (bArr[i11] >> 7)) {
                break;
            }
            i10 = i11;
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Integer)) {
            return false;
        }
        return Arrays.areEqual(this.bytes, ((ASN1Integer) aSN1Primitive).bytes);
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        aSN1OutputStream.writeEncoded(z10, 2, this.bytes);
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.bytes.length) + 1 + this.bytes.length;
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.bytes);
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public boolean hasValue(int i10) {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i11 = this.start;
        return length - i11 <= 4 && intValue(bArr, i11, -1) == i10;
    }

    public boolean hasValue(long j10) {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i10 = this.start;
        return length - i10 <= 8 && longValue(bArr, i10, -1) == j10;
    }

    public boolean hasValue(BigInteger bigInteger) {
        return bigInteger != null && intValue(this.bytes, this.start, -1) == bigInteger.intValue() && getValue().equals(bigInteger);
    }

    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    public int intPositiveValueExact() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i10 = this.start;
        int i11 = length - i10;
        if (i11 <= 4 && (i11 != 4 || (bArr[i10] & 128) == 0)) {
            return intValue(bArr, i10, 255);
        }
        throw new ArithmeticException("ASN.1 Integer out of positive int range");
    }

    public int intValueExact() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i10 = this.start;
        if (length - i10 <= 4) {
            return intValue(bArr, i10, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    /* access modifiers changed from: package-private */
    public boolean isConstructed() {
        return false;
    }

    public long longValueExact() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i10 = this.start;
        if (length - i10 <= 8) {
            return longValue(bArr, i10, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    public String toString() {
        return getValue().toString();
    }
}
