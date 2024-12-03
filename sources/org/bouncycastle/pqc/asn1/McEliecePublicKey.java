package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKey extends ASN1Object {

    /* renamed from: g  reason: collision with root package name */
    private final GF2Matrix f23972g;

    /* renamed from: n  reason: collision with root package name */
    private final int f23973n;

    /* renamed from: t  reason: collision with root package name */
    private final int f23974t;

    public McEliecePublicKey(int i10, int i11, GF2Matrix gF2Matrix) {
        this.f23973n = i10;
        this.f23974t = i11;
        this.f23972g = new GF2Matrix(gF2Matrix);
    }

    private McEliecePublicKey(ASN1Sequence aSN1Sequence) {
        this.f23973n = ((ASN1Integer) aSN1Sequence.getObjectAt(0)).intValueExact();
        this.f23974t = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).intValueExact();
        this.f23972g = new GF2Matrix(((ASN1OctetString) aSN1Sequence.getObjectAt(2)).getOctets());
    }

    public static McEliecePublicKey getInstance(Object obj) {
        if (obj instanceof McEliecePublicKey) {
            return (McEliecePublicKey) obj;
        }
        if (obj != null) {
            return new McEliecePublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GF2Matrix getG() {
        return new GF2Matrix(this.f23972g);
    }

    public int getN() {
        return this.f23973n;
    }

    public int getT() {
        return this.f23974t;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.f23973n));
        aSN1EncodableVector.add(new ASN1Integer((long) this.f23974t));
        aSN1EncodableVector.add(new DEROctetString(this.f23972g.getEncoded()));
        return new DERSequence(aSN1EncodableVector);
    }
}
