package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKey extends ASN1Object {
    private final AlgorithmIdentifier digest;

    /* renamed from: g  reason: collision with root package name */
    private final GF2Matrix f23967g;

    /* renamed from: n  reason: collision with root package name */
    private final int f23968n;

    /* renamed from: t  reason: collision with root package name */
    private final int f23969t;

    public McElieceCCA2PublicKey(int i10, int i11, GF2Matrix gF2Matrix, AlgorithmIdentifier algorithmIdentifier) {
        this.f23968n = i10;
        this.f23969t = i11;
        this.f23967g = new GF2Matrix(gF2Matrix.getEncoded());
        this.digest = algorithmIdentifier;
    }

    private McElieceCCA2PublicKey(ASN1Sequence aSN1Sequence) {
        this.f23968n = ((ASN1Integer) aSN1Sequence.getObjectAt(0)).intValueExact();
        this.f23969t = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).intValueExact();
        this.f23967g = new GF2Matrix(((ASN1OctetString) aSN1Sequence.getObjectAt(2)).getOctets());
        this.digest = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }

    public static McElieceCCA2PublicKey getInstance(Object obj) {
        if (obj instanceof McElieceCCA2PublicKey) {
            return (McElieceCCA2PublicKey) obj;
        }
        if (obj != null) {
            return new McElieceCCA2PublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getDigest() {
        return this.digest;
    }

    public GF2Matrix getG() {
        return this.f23967g;
    }

    public int getN() {
        return this.f23968n;
    }

    public int getT() {
        return this.f23969t;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.f23968n));
        aSN1EncodableVector.add(new ASN1Integer((long) this.f23969t));
        aSN1EncodableVector.add(new DEROctetString(this.f23967g.getEncoded()));
        aSN1EncodableVector.add(this.digest);
        return new DERSequence(aSN1EncodableVector);
    }
}
