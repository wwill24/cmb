package org.bouncycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ElGamalParameter extends ASN1Object {

    /* renamed from: g  reason: collision with root package name */
    ASN1Integer f16855g;

    /* renamed from: p  reason: collision with root package name */
    ASN1Integer f16856p;

    public ElGamalParameter(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f16856p = new ASN1Integer(bigInteger);
        this.f16855g = new ASN1Integer(bigInteger2);
    }

    private ElGamalParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f16856p = (ASN1Integer) objects.nextElement();
        this.f16855g = (ASN1Integer) objects.nextElement();
    }

    public static ElGamalParameter getInstance(Object obj) {
        if (obj instanceof ElGamalParameter) {
            return (ElGamalParameter) obj;
        }
        if (obj != null) {
            return new ElGamalParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getG() {
        return this.f16855g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f16856p.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.f16856p);
        aSN1EncodableVector.add(this.f16855g);
        return new DERSequence(aSN1EncodableVector);
    }
}
