package org.bouncycastle.asn1;

import java.io.IOException;

public class DERSequence extends ASN1Sequence {
    private int bodyLength = -1;

    public DERSequence() {
    }

    public DERSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DERSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    public DERSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
    }

    DERSequence(ASN1Encodable[] aSN1EncodableArr, boolean z10) {
        super(aSN1EncodableArr, z10);
    }

    public static DERSequence convert(ASN1Sequence aSN1Sequence) {
        return (DERSequence) aSN1Sequence.toDERObject();
    }

    private int getBodyLength() throws IOException {
        if (this.bodyLength < 0) {
            int i10 = 0;
            for (ASN1Encodable aSN1Primitive : this.elements) {
                i10 += aSN1Primitive.toASN1Primitive().toDERObject().encodedLength();
            }
            this.bodyLength = i10;
        }
        return this.bodyLength;
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        if (z10) {
            aSN1OutputStream.write(48);
        }
        DEROutputStream dERSubStream = aSN1OutputStream.getDERSubStream();
        int length = this.elements.length;
        int i10 = 0;
        if (this.bodyLength >= 0 || length > 16) {
            aSN1OutputStream.writeLength(getBodyLength());
            while (i10 < length) {
                this.elements[i10].toASN1Primitive().toDERObject().encode(dERSubStream, true);
                i10++;
            }
            return;
        }
        ASN1Primitive[] aSN1PrimitiveArr = new ASN1Primitive[length];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            ASN1Primitive dERObject = this.elements[i12].toASN1Primitive().toDERObject();
            aSN1PrimitiveArr[i12] = dERObject;
            i11 += dERObject.encodedLength();
        }
        this.bodyLength = i11;
        aSN1OutputStream.writeLength(i11);
        while (i10 < length) {
            aSN1PrimitiveArr[i10].encode(dERSubStream, true);
            i10++;
        }
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() throws IOException {
        int bodyLength2 = getBodyLength();
        return StreamUtil.calculateBodyLength(bodyLength2) + 1 + bodyLength2;
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
