package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class DHParameter extends ASN1Object {

    /* renamed from: g  reason: collision with root package name */
    ASN1Integer f16857g;

    /* renamed from: l  reason: collision with root package name */
    ASN1Integer f16858l;

    /* renamed from: p  reason: collision with root package name */
    ASN1Integer f16859p;

    public DHParameter(BigInteger bigInteger, BigInteger bigInteger2, int i10) {
        this.f16859p = new ASN1Integer(bigInteger);
        this.f16857g = new ASN1Integer(bigInteger2);
        this.f16858l = i10 != 0 ? new ASN1Integer((long) i10) : null;
    }

    private DHParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f16859p = ASN1Integer.getInstance(objects.nextElement());
        this.f16857g = ASN1Integer.getInstance(objects.nextElement());
        this.f16858l = objects.hasMoreElements() ? (ASN1Integer) objects.nextElement() : null;
    }

    public static DHParameter getInstance(Object obj) {
        if (obj instanceof DHParameter) {
            return (DHParameter) obj;
        }
        if (obj != null) {
            return new DHParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getG() {
        return this.f16857g.getPositiveValue();
    }

    public BigInteger getL() {
        ASN1Integer aSN1Integer = this.f16858l;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f16859p.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.f16859p);
        aSN1EncodableVector.add(this.f16857g);
        if (getL() != null) {
            aSN1EncodableVector.add(this.f16858l);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
