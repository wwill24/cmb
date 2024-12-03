package org.bouncycastle.asn1;

import java.io.IOException;

public class DERTaggedObject extends ASN1TaggedObject {
    public DERTaggedObject(int i10, ASN1Encodable aSN1Encodable) {
        super(true, i10, aSN1Encodable);
    }

    public DERTaggedObject(boolean z10, int i10, ASN1Encodable aSN1Encodable) {
        super(z10, i10, aSN1Encodable);
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        ASN1Primitive dERObject = this.obj.toASN1Primitive().toDERObject();
        aSN1OutputStream.writeTag(z10, (this.explicit || dERObject.isConstructed()) ? 160 : 128, this.tagNo);
        if (this.explicit) {
            aSN1OutputStream.writeLength(dERObject.encodedLength());
        }
        dERObject.encode(aSN1OutputStream.getDERSubStream(), this.explicit);
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() throws IOException {
        int calculateTagLength;
        int encodedLength = this.obj.toASN1Primitive().toDERObject().encodedLength();
        if (this.explicit) {
            calculateTagLength = StreamUtil.calculateTagLength(this.tagNo) + StreamUtil.calculateBodyLength(encodedLength);
        } else {
            encodedLength--;
            calculateTagLength = StreamUtil.calculateTagLength(this.tagNo);
        }
        return calculateTagLength + encodedLength;
    }

    /* access modifiers changed from: package-private */
    public boolean isConstructed() {
        return this.explicit || this.obj.toASN1Primitive().toDERObject().isConstructed();
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
