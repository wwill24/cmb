package org.bouncycastle.asn1;

import java.io.IOException;

public class DLSequence extends ASN1Sequence {
    private int bodyLength = -1;

    public DLSequence() {
    }

    public DLSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DLSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    public DLSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
    }

    DLSequence(ASN1Encodable[] aSN1EncodableArr, boolean z10) {
        super(aSN1EncodableArr, z10);
    }

    private int getBodyLength() throws IOException {
        if (this.bodyLength < 0) {
            int i10 = 0;
            for (ASN1Encodable aSN1Primitive : this.elements) {
                i10 += aSN1Primitive.toASN1Primitive().toDLObject().encodedLength();
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
        ASN1OutputStream dLSubStream = aSN1OutputStream.getDLSubStream();
        int length = this.elements.length;
        int i10 = 0;
        if (this.bodyLength >= 0 || length > 16) {
            aSN1OutputStream.writeLength(getBodyLength());
            while (i10 < length) {
                dLSubStream.writePrimitive(this.elements[i10].toASN1Primitive(), true);
                i10++;
            }
            return;
        }
        ASN1Primitive[] aSN1PrimitiveArr = new ASN1Primitive[length];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            ASN1Primitive dLObject = this.elements[i12].toASN1Primitive().toDLObject();
            aSN1PrimitiveArr[i12] = dLObject;
            i11 += dLObject.encodedLength();
        }
        this.bodyLength = i11;
        aSN1OutputStream.writeLength(i11);
        while (i10 < length) {
            dLSubStream.writePrimitive(aSN1PrimitiveArr[i10], true);
            i10++;
        }
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() throws IOException {
        int bodyLength2 = getBodyLength();
        return StreamUtil.calculateBodyLength(bodyLength2) + 1 + bodyLength2;
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDLObject() {
        return this;
    }
}
