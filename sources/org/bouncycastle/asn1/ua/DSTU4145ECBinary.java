package org.bouncycastle.asn1.ua;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;

public class DSTU4145ECBinary extends ASN1Object {

    /* renamed from: a  reason: collision with root package name */
    ASN1Integer f16864a;

    /* renamed from: b  reason: collision with root package name */
    ASN1OctetString f16865b;
    ASN1OctetString bp;

    /* renamed from: f  reason: collision with root package name */
    DSTU4145BinaryField f16866f;

    /* renamed from: n  reason: collision with root package name */
    ASN1Integer f16867n;
    BigInteger version = BigInteger.valueOf(0);

    private DSTU4145ECBinary(ASN1Sequence aSN1Sequence) {
        int i10 = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(0);
            if (!aSN1TaggedObject.isExplicit() || aSN1TaggedObject.getTagNo() != 0) {
                throw new IllegalArgumentException("object parse error");
            }
            this.version = ASN1Integer.getInstance(aSN1TaggedObject.getLoadedObject()).getValue();
            i10 = 1;
        }
        this.f16866f = DSTU4145BinaryField.getInstance(aSN1Sequence.getObjectAt(i10));
        int i11 = i10 + 1;
        this.f16864a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i11));
        int i12 = i11 + 1;
        this.f16865b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i12));
        int i13 = i12 + 1;
        this.f16867n = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i13));
        this.bp = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i13 + 1));
    }

    public DSTU4145ECBinary(ECDomainParameters eCDomainParameters) {
        DSTU4145BinaryField dSTU4145BinaryField;
        ECCurve curve = eCDomainParameters.getCurve();
        if (ECAlgorithms.isF2mCurve(curve)) {
            int[] exponentsPresent = ((PolynomialExtensionField) curve.getField()).getMinimalPolynomial().getExponentsPresent();
            if (exponentsPresent.length == 3) {
                dSTU4145BinaryField = new DSTU4145BinaryField(exponentsPresent[2], exponentsPresent[1]);
            } else if (exponentsPresent.length == 5) {
                dSTU4145BinaryField = new DSTU4145BinaryField(exponentsPresent[4], exponentsPresent[1], exponentsPresent[2], exponentsPresent[3]);
            } else {
                throw new IllegalArgumentException("curve must have a trinomial or pentanomial basis");
            }
            this.f16866f = dSTU4145BinaryField;
            this.f16864a = new ASN1Integer(curve.getA().toBigInteger());
            this.f16865b = new DEROctetString(curve.getB().getEncoded());
            this.f16867n = new ASN1Integer(eCDomainParameters.getN());
            this.bp = new DEROctetString(DSTU4145PointEncoder.encodePoint(eCDomainParameters.getG()));
            return;
        }
        throw new IllegalArgumentException("only binary domain is possible");
    }

    public static DSTU4145ECBinary getInstance(Object obj) {
        if (obj instanceof DSTU4145ECBinary) {
            return (DSTU4145ECBinary) obj;
        }
        if (obj != null) {
            return new DSTU4145ECBinary(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getA() {
        return this.f16864a.getValue();
    }

    public byte[] getB() {
        return Arrays.clone(this.f16865b.getOctets());
    }

    public DSTU4145BinaryField getField() {
        return this.f16866f;
    }

    public byte[] getG() {
        return Arrays.clone(this.bp.getOctets());
    }

    public BigInteger getN() {
        return this.f16867n.getValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        if (this.version.compareTo(BigInteger.valueOf(0)) != 0) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, new ASN1Integer(this.version)));
        }
        aSN1EncodableVector.add(this.f16866f);
        aSN1EncodableVector.add(this.f16864a);
        aSN1EncodableVector.add(this.f16865b);
        aSN1EncodableVector.add(this.f16867n);
        aSN1EncodableVector.add(this.bp);
        return new DERSequence(aSN1EncodableVector);
    }
}
