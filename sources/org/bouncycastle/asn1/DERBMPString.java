package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class DERBMPString extends ASN1Primitive implements ASN1String {
    private final char[] string;

    public DERBMPString(String str) {
        if (str != null) {
            this.string = str.toCharArray();
            return;
        }
        throw new NullPointerException("'string' cannot be null");
    }

    DERBMPString(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            if ((length & 1) == 0) {
                int i10 = length / 2;
                char[] cArr = new char[i10];
                for (int i11 = 0; i11 != i10; i11++) {
                    int i12 = i11 * 2;
                    cArr[i11] = (char) ((bArr[i12 + 1] & 255) | (bArr[i12] << 8));
                }
                this.string = cArr;
                return;
            }
            throw new IllegalArgumentException("malformed BMPString encoding encountered");
        }
        throw new NullPointerException("'string' cannot be null");
    }

    DERBMPString(char[] cArr) {
        if (cArr != null) {
            this.string = cArr;
            return;
        }
        throw new NullPointerException("'string' cannot be null");
    }

    public static DERBMPString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBMPString)) {
            return (DERBMPString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERBMPString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e10) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERBMPString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z10 || (object instanceof DERBMPString)) ? getInstance(object) : new DERBMPString(ASN1OctetString.getInstance(object).getOctets());
    }

    /* access modifiers changed from: protected */
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERBMPString)) {
            return false;
        }
        return Arrays.areEqual(this.string, ((DERBMPString) aSN1Primitive).string);
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        int length = this.string.length;
        if (z10) {
            aSN1OutputStream.write(30);
        }
        aSN1OutputStream.writeLength(length * 2);
        byte[] bArr = new byte[8];
        int i10 = length & -4;
        int i11 = 0;
        while (i11 < i10) {
            char[] cArr = this.string;
            char c10 = cArr[i11];
            char c11 = cArr[i11 + 1];
            char c12 = cArr[i11 + 2];
            char c13 = cArr[i11 + 3];
            i11 += 4;
            bArr[0] = (byte) (c10 >> 8);
            bArr[1] = (byte) c10;
            bArr[2] = (byte) (c11 >> 8);
            bArr[3] = (byte) c11;
            bArr[4] = (byte) (c12 >> 8);
            bArr[5] = (byte) c12;
            bArr[6] = (byte) (c13 >> 8);
            bArr[7] = (byte) c13;
            aSN1OutputStream.write(bArr, 0, 8);
        }
        if (i11 < length) {
            int i12 = 0;
            do {
                char c14 = this.string[i11];
                i11++;
                int i13 = i12 + 1;
                bArr[i12] = (byte) (c14 >> 8);
                i12 = i13 + 1;
                bArr[i13] = (byte) c14;
            } while (i11 < length);
            aSN1OutputStream.write(bArr, 0, i12);
        }
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length * 2) + 1 + (this.string.length * 2);
    }

    public String getString() {
        return new String(this.string);
    }

    public int hashCode() {
        return Arrays.hashCode(this.string);
    }

    /* access modifiers changed from: package-private */
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getString();
    }
}
