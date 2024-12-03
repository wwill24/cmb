package org.bouncycastle.asn1.bc;

import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

public class ObjectDataSequence extends ASN1Object implements Iterable<ASN1Encodable> {
    private final ASN1Encodable[] dataSequence;

    private ObjectDataSequence(ASN1Sequence aSN1Sequence) {
        this.dataSequence = new ASN1Encodable[aSN1Sequence.size()];
        int i10 = 0;
        while (true) {
            ASN1Encodable[] aSN1EncodableArr = this.dataSequence;
            if (i10 != aSN1EncodableArr.length) {
                aSN1EncodableArr[i10] = ObjectData.getInstance(aSN1Sequence.getObjectAt(i10));
                i10++;
            } else {
                return;
            }
        }
    }

    public ObjectDataSequence(ObjectData[] objectDataArr) {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[objectDataArr.length];
        this.dataSequence = aSN1EncodableArr;
        System.arraycopy(objectDataArr, 0, aSN1EncodableArr, 0, objectDataArr.length);
    }

    public static ObjectDataSequence getInstance(Object obj) {
        if (obj instanceof ObjectDataSequence) {
            return (ObjectDataSequence) obj;
        }
        if (obj != null) {
            return new ObjectDataSequence(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(this.dataSequence);
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.dataSequence);
    }
}
