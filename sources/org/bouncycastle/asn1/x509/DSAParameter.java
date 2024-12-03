package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class DSAParameter extends ASN1Object {

    /* renamed from: g  reason: collision with root package name */
    ASN1Integer f16875g;

    /* renamed from: p  reason: collision with root package name */
    ASN1Integer f16876p;

    /* renamed from: q  reason: collision with root package name */
    ASN1Integer f16877q;

    public DSAParameter(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f16876p = new ASN1Integer(bigInteger);
        this.f16877q = new ASN1Integer(bigInteger2);
        this.f16875g = new ASN1Integer(bigInteger3);
    }

    private DSAParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.f16876p = ASN1Integer.getInstance(objects.nextElement());
            this.f16877q = ASN1Integer.getInstance(objects.nextElement());
            this.f16875g = ASN1Integer.getInstance(objects.nextElement());
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public static DSAParameter getInstance(Object obj) {
        if (obj instanceof DSAParameter) {
            return (DSAParameter) obj;
        }
        if (obj != null) {
            return new DSAParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static DSAParameter getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z10));
    }

    public BigInteger getG() {
        return this.f16875g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f16876p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f16877q.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.f16876p);
        aSN1EncodableVector.add(this.f16877q);
        aSN1EncodableVector.add(this.f16875g);
        return new DERSequence(aSN1EncodableVector);
    }
}
