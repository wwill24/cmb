package org.bouncycastle.asn1;

import java.io.IOException;

public class DLBitString extends ASN1BitString {
    protected DLBitString(byte b10, int i10) {
        super(b10, i10);
    }

    public DLBitString(int i10) {
        super(ASN1BitString.getBytes(i10), ASN1BitString.getPadBits(i10));
    }

    public DLBitString(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    public DLBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public DLBitString(byte[] bArr, int i10) {
        super(bArr, i10);
    }

    static DLBitString fromOctetString(byte[] bArr) {
        if (bArr.length >= 1) {
            byte b10 = bArr[0];
            int length = bArr.length - 1;
            byte[] bArr2 = new byte[length];
            if (length != 0) {
                System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
            }
            return new DLBitString(bArr2, (int) b10);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    public static ASN1BitString getInstance(Object obj) {
        if (obj == null || (obj instanceof DLBitString)) {
            return (DLBitString) obj;
        }
        if (obj instanceof DERBitString) {
            return (DERBitString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1BitString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e10) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1BitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z10 || (object instanceof DLBitString)) ? getInstance(object) : fromOctetString(ASN1OctetString.getInstance(object).getOctets());
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        aSN1OutputStream.writeEncoded(z10, 3, (byte) this.padBits, this.data);
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.data.length + 1) + 1 + this.data.length + 1;
    }

    /* access modifiers changed from: package-private */
    public boolean isConstructed() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDLObject() {
        return this;
    }
}
