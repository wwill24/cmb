package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECFieldElement;

public class X9FieldElement extends ASN1Object {
    private static X9IntegerConverter converter = new X9IntegerConverter();

    /* renamed from: f  reason: collision with root package name */
    protected ECFieldElement f41353f;

    public X9FieldElement(int i10, int i11, int i12, int i13, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.F2m(i10, i11, i12, i13, new BigInteger(1, aSN1OctetString.getOctets())));
    }

    public X9FieldElement(BigInteger bigInteger, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.Fp(bigInteger, new BigInteger(1, aSN1OctetString.getOctets())));
    }

    public X9FieldElement(ECFieldElement eCFieldElement) {
        this.f41353f = eCFieldElement;
    }

    public ECFieldElement getValue() {
        return this.f41353f;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(converter.integerToBytes(this.f41353f.toBigInteger(), converter.getByteLength(this.f41353f)));
    }
}
