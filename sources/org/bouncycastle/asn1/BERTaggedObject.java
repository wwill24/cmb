package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class BERTaggedObject extends ASN1TaggedObject {
    public BERTaggedObject(int i10) {
        super(false, i10, new BERSequence());
    }

    public BERTaggedObject(int i10, ASN1Encodable aSN1Encodable) {
        super(true, i10, aSN1Encodable);
    }

    public BERTaggedObject(boolean z10, int i10, ASN1Encodable aSN1Encodable) {
        super(z10, i10, aSN1Encodable);
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        Enumeration enumeration;
        aSN1OutputStream.writeTag(z10, 160, this.tagNo);
        aSN1OutputStream.write(128);
        if (!this.explicit) {
            ASN1Encodable aSN1Encodable = this.obj;
            if (aSN1Encodable instanceof ASN1OctetString) {
                enumeration = aSN1Encodable instanceof BEROctetString ? ((BEROctetString) aSN1Encodable).getObjects() : new BEROctetString(((ASN1OctetString) aSN1Encodable).getOctets()).getObjects();
            } else if (aSN1Encodable instanceof ASN1Sequence) {
                enumeration = ((ASN1Sequence) aSN1Encodable).getObjects();
            } else if (aSN1Encodable instanceof ASN1Set) {
                enumeration = ((ASN1Set) aSN1Encodable).getObjects();
            } else {
                throw new ASN1Exception("not implemented: " + this.obj.getClass().getName());
            }
            aSN1OutputStream.writeElements(enumeration);
        } else {
            aSN1OutputStream.writePrimitive(this.obj.toASN1Primitive(), true);
        }
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() throws IOException {
        int calculateTagLength;
        int encodedLength = this.obj.toASN1Primitive().encodedLength();
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
        return this.explicit || this.obj.toASN1Primitive().isConstructed();
    }
}
