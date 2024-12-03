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

public class GOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a  reason: collision with root package name */
    ASN1Integer f16852a;
    int keySize;

    /* renamed from: p  reason: collision with root package name */
    ASN1Integer f16853p;

    /* renamed from: q  reason: collision with root package name */
    ASN1Integer f16854q;

    public GOST3410ParamSetParameters(int i10, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.keySize = i10;
        this.f16853p = new ASN1Integer(bigInteger);
        this.f16854q = new ASN1Integer(bigInteger2);
        this.f16852a = new ASN1Integer(bigInteger3);
    }

    public GOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.keySize = ((ASN1Integer) objects.nextElement()).intValueExact();
        this.f16853p = (ASN1Integer) objects.nextElement();
        this.f16854q = (ASN1Integer) objects.nextElement();
        this.f16852a = (ASN1Integer) objects.nextElement();
    }

    public static GOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof GOST3410ParamSetParameters)) {
            return (GOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new GOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public static GOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z10));
    }

    public BigInteger getA() {
        return this.f16852a.getPositiveValue();
    }

    public int getKeySize() {
        return this.keySize;
    }

    public int getLKeySize() {
        return this.keySize;
    }

    public BigInteger getP() {
        return this.f16853p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f16854q.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.add(new ASN1Integer((long) this.keySize));
        aSN1EncodableVector.add(this.f16853p);
        aSN1EncodableVector.add(this.f16854q);
        aSN1EncodableVector.add(this.f16852a);
        return new DERSequence(aSN1EncodableVector);
    }
}
