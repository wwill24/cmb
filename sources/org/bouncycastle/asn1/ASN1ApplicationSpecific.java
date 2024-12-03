package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public abstract class ASN1ApplicationSpecific extends ASN1Primitive {
    protected final boolean isConstructed;
    protected final byte[] octets;
    protected final int tag;

    ASN1ApplicationSpecific(boolean z10, int i10, byte[] bArr) {
        this.isConstructed = z10;
        this.tag = i10;
        this.octets = Arrays.clone(bArr);
    }

    public static ASN1ApplicationSpecific getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ApplicationSpecific)) {
            return (ASN1ApplicationSpecific) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e10) {
                throw new IllegalArgumentException("Failed to construct object from byte[]: " + e10.getMessage());
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    protected static int getLengthOfHeader(byte[] bArr) {
        byte b10 = bArr[1] & 255;
        if (b10 == 128 || b10 <= Byte.MAX_VALUE) {
            return 2;
        }
        byte b11 = b10 & Byte.MAX_VALUE;
        if (b11 <= 4) {
            return b11 + 2;
        }
        throw new IllegalStateException("DER length more than 4 bytes: " + b11);
    }

    private byte[] replaceTagNumber(int i10, byte[] bArr) throws IOException {
        int i11;
        if ((bArr[0] & 31) == 31) {
            i11 = 2;
            byte b10 = bArr[1] & 255;
            if ((b10 & Byte.MAX_VALUE) != 0) {
                while ((b10 & 128) != 0) {
                    b10 = bArr[i11] & 255;
                    i11++;
                }
            } else {
                throw new IOException("corrupted stream - invalid high tag number found");
            }
        } else {
            i11 = 1;
        }
        int length = (bArr.length - i11) + 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i11, bArr2, 1, length - 1);
        bArr2[0] = (byte) i10;
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1ApplicationSpecific)) {
            return false;
        }
        ASN1ApplicationSpecific aSN1ApplicationSpecific = (ASN1ApplicationSpecific) aSN1Primitive;
        return this.isConstructed == aSN1ApplicationSpecific.isConstructed && this.tag == aSN1ApplicationSpecific.tag && Arrays.areEqual(this.octets, aSN1ApplicationSpecific.octets);
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        aSN1OutputStream.writeEncoded(z10, this.isConstructed ? 96 : 64, this.tag, this.octets);
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() throws IOException {
        return StreamUtil.calculateTagLength(this.tag) + StreamUtil.calculateBodyLength(this.octets.length) + this.octets.length;
    }

    public int getApplicationTag() {
        return this.tag;
    }

    public byte[] getContents() {
        return Arrays.clone(this.octets);
    }

    public ASN1Primitive getObject() throws IOException {
        return ASN1Primitive.fromByteArray(getContents());
    }

    public ASN1Primitive getObject(int i10) throws IOException {
        if (i10 < 31) {
            byte[] encoded = getEncoded();
            byte[] replaceTagNumber = replaceTagNumber(i10, encoded);
            if ((encoded[0] & 32) != 0) {
                replaceTagNumber[0] = (byte) (replaceTagNumber[0] | 32);
            }
            return ASN1Primitive.fromByteArray(replaceTagNumber);
        }
        throw new IOException("unsupported tag number");
    }

    public int hashCode() {
        return (this.isConstructed ^ this.tag) ^ Arrays.hashCode(this.octets) ? 1 : 0;
    }

    public boolean isConstructed() {
        return this.isConstructed;
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        if (isConstructed()) {
            stringBuffer.append("CONSTRUCTED ");
        }
        stringBuffer.append("APPLICATION ");
        stringBuffer.append(Integer.toString(getApplicationTag()));
        stringBuffer.append("]");
        if (this.octets != null) {
            stringBuffer.append(" #");
            str = Hex.toHexString(this.octets);
        } else {
            str = " #null";
        }
        stringBuffer.append(str);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }
}
