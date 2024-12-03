package org.bouncycastle.asn1;

import java.io.IOException;

public class ASN1Boolean extends ASN1Primitive {
    public static final ASN1Boolean FALSE = new ASN1Boolean(FALSE_VALUE);
    private static final byte FALSE_VALUE = 0;
    public static final ASN1Boolean TRUE = new ASN1Boolean(TRUE_VALUE);
    private static final byte TRUE_VALUE = -1;
    private final byte value;

    private ASN1Boolean(byte b10) {
        this.value = b10;
    }

    static ASN1Boolean fromOctetString(byte[] bArr) {
        if (bArr.length == 1) {
            byte b10 = bArr[0];
            return b10 != -1 ? b10 != 0 ? new ASN1Boolean(b10) : FALSE : TRUE;
        }
        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }

    public static ASN1Boolean getInstance(int i10) {
        return i10 != 0 ? TRUE : FALSE;
    }

    public static ASN1Boolean getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Boolean)) {
            return (ASN1Boolean) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1Boolean) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct boolean from byte[]: " + e10.getMessage());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1Boolean getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z10 || (object instanceof ASN1Boolean)) ? getInstance((Object) object) : fromOctetString(ASN1OctetString.getInstance(object).getOctets());
    }

    public static ASN1Boolean getInstance(boolean z10) {
        return z10 ? TRUE : FALSE;
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return (aSN1Primitive instanceof ASN1Boolean) && isTrue() == ((ASN1Boolean) aSN1Primitive).isTrue();
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        aSN1OutputStream.writeEncoded(z10, 1, this.value);
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() {
        return 3;
    }

    public int hashCode() {
        return isTrue() ? 1 : 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isConstructed() {
        return false;
    }

    public boolean isTrue() {
        return this.value != 0;
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDERObject() {
        return isTrue() ? TRUE : FALSE;
    }

    public String toString() {
        return isTrue() ? "TRUE" : "FALSE";
    }
}
