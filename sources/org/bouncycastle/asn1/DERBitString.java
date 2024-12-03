package org.bouncycastle.asn1;

import java.io.IOException;

public class DERBitString extends ASN1BitString {
    protected DERBitString(byte b10, int i10) {
        super(b10, i10);
    }

    public DERBitString(int i10) {
        super(ASN1BitString.getBytes(i10), ASN1BitString.getPadBits(i10));
    }

    public DERBitString(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    public DERBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public DERBitString(byte[] bArr, int i10) {
        super(bArr, i10);
    }

    static DERBitString fromOctetString(byte[] bArr) {
        if (bArr.length >= 1) {
            byte b10 = bArr[0];
            int length = bArr.length - 1;
            byte[] bArr2 = new byte[length];
            if (length != 0) {
                System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
            }
            return new DERBitString(bArr2, (int) b10);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    public static DERBitString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBitString)) {
            return (DERBitString) obj;
        }
        if (obj instanceof DLBitString) {
            DLBitString dLBitString = (DLBitString) obj;
            return new DERBitString(dLBitString.data, dLBitString.padBits);
        } else if (obj instanceof byte[]) {
            try {
                return (DERBitString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e10) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERBitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z10 || (object instanceof DERBitString)) ? getInstance(object) : fromOctetString(ASN1OctetString.getInstance(object).getOctets());
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        int i10;
        byte[] bArr = this.data;
        int length = bArr.length;
        if (!(length == 0 || (i10 = this.padBits) == 0)) {
            int i11 = length - 1;
            byte b10 = bArr[i11];
            if (b10 != ((byte) ((255 << i10) & b10))) {
                aSN1OutputStream.writeEncoded(z10, 3, (byte) i10, bArr, 0, i11, (byte) (b10 & (255 << i10)));
                return;
            }
        }
        aSN1OutputStream.writeEncoded(z10, 3, (byte) this.padBits, bArr);
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
    public ASN1Primitive toDERObject() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDLObject() {
        return this;
    }
}
