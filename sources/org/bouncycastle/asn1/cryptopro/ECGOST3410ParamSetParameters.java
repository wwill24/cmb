package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class ECGOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a  reason: collision with root package name */
    ASN1Integer f16846a;

    /* renamed from: b  reason: collision with root package name */
    ASN1Integer f16847b;

    /* renamed from: p  reason: collision with root package name */
    ASN1Integer f16848p;

    /* renamed from: q  reason: collision with root package name */
    ASN1Integer f16849q;

    /* renamed from: x  reason: collision with root package name */
    ASN1Integer f16850x;

    /* renamed from: y  reason: collision with root package name */
    ASN1Integer f16851y;

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i10, BigInteger bigInteger5) {
        this.f16846a = new ASN1Integer(bigInteger);
        this.f16847b = new ASN1Integer(bigInteger2);
        this.f16848p = new ASN1Integer(bigInteger3);
        this.f16849q = new ASN1Integer(bigInteger4);
        this.f16850x = new ASN1Integer((long) i10);
        this.f16851y = new ASN1Integer(bigInteger5);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f16846a = (ASN1Integer) objects.nextElement();
        this.f16847b = (ASN1Integer) objects.nextElement();
        this.f16848p = (ASN1Integer) objects.nextElement();
        this.f16849q = (ASN1Integer) objects.nextElement();
        this.f16850x = (ASN1Integer) objects.nextElement();
        this.f16851y = (ASN1Integer) objects.nextElement();
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof ECGOST3410ParamSetParameters)) {
            return (ECGOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z10));
    }

    public BigInteger getA() {
        return this.f16846a.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f16848p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f16849q.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.add(this.f16846a);
        aSN1EncodableVector.add(this.f16847b);
        aSN1EncodableVector.add(this.f16848p);
        aSN1EncodableVector.add(this.f16849q);
        aSN1EncodableVector.add(this.f16850x);
        aSN1EncodableVector.add(this.f16851y);
        return new DERSequence(aSN1EncodableVector);
    }
}
