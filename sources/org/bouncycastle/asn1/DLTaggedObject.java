package org.bouncycastle.asn1;

import java.io.IOException;

public class DLTaggedObject extends ASN1TaggedObject {
    public DLTaggedObject(boolean z10, int i10, ASN1Encodable aSN1Encodable) {
        super(z10, i10, aSN1Encodable);
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        ASN1Primitive dLObject = this.obj.toASN1Primitive().toDLObject();
        aSN1OutputStream.writeTag(z10, (this.explicit || dLObject.isConstructed()) ? 160 : 128, this.tagNo);
        if (this.explicit) {
            aSN1OutputStream.writeLength(dLObject.encodedLength());
        }
        aSN1OutputStream.getDLSubStream().writePrimitive(dLObject, this.explicit);
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() throws IOException {
        int calculateTagLength;
        int encodedLength = this.obj.toASN1Primitive().toDLObject().encodedLength();
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
        return this.explicit || this.obj.toASN1Primitive().toDLObject().isConstructed();
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDLObject() {
        return this;
    }
}
