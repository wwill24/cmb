package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Strings;

public class CRLDistPoint extends ASN1Object {
    ASN1Sequence seq;

    private CRLDistPoint(ASN1Sequence aSN1Sequence) {
        this.seq = aSN1Sequence;
    }

    public CRLDistPoint(DistributionPoint[] distributionPointArr) {
        this.seq = null;
        this.seq = new DERSequence((ASN1Encodable[]) distributionPointArr);
    }

    public static CRLDistPoint fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.cRLDistributionPoints));
    }

    public static CRLDistPoint getInstance(Object obj) {
        if (obj instanceof CRLDistPoint) {
            return (CRLDistPoint) obj;
        }
        if (obj != null) {
            return new CRLDistPoint(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static CRLDistPoint getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z10));
    }

    public DistributionPoint[] getDistributionPoints() {
        DistributionPoint[] distributionPointArr = new DistributionPoint[this.seq.size()];
        for (int i10 = 0; i10 != this.seq.size(); i10++) {
            distributionPointArr[i10] = DistributionPoint.getInstance(this.seq.getObjectAt(i10));
        }
        return distributionPointArr;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("CRLDistPoint:");
        stringBuffer.append(lineSeparator);
        DistributionPoint[] distributionPoints = getDistributionPoints();
        for (int i10 = 0; i10 != distributionPoints.length; i10++) {
            stringBuffer.append("    ");
            stringBuffer.append(distributionPoints[i10]);
            stringBuffer.append(lineSeparator);
        }
        return stringBuffer.toString();
    }
}
