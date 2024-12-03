package org.bouncycastle.asn1.ua;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class DSTU4145BinaryField extends ASN1Object {

    /* renamed from: j  reason: collision with root package name */
    private int f16860j;

    /* renamed from: k  reason: collision with root package name */
    private int f16861k;

    /* renamed from: l  reason: collision with root package name */
    private int f16862l;

    /* renamed from: m  reason: collision with root package name */
    private int f16863m;

    public DSTU4145BinaryField(int i10, int i11) {
        this(i10, i11, 0, 0);
    }

    public DSTU4145BinaryField(int i10, int i11, int i12, int i13) {
        this.f16863m = i10;
        this.f16861k = i11;
        this.f16860j = i12;
        this.f16862l = i13;
    }

    private DSTU4145BinaryField(ASN1Sequence aSN1Sequence) {
        this.f16863m = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intPositiveValueExact();
        if (aSN1Sequence.getObjectAt(1) instanceof ASN1Integer) {
            this.f16861k = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).intPositiveValueExact();
        } else if (aSN1Sequence.getObjectAt(1) instanceof ASN1Sequence) {
            ASN1Sequence instance = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
            this.f16861k = ASN1Integer.getInstance(instance.getObjectAt(0)).intPositiveValueExact();
            this.f16860j = ASN1Integer.getInstance(instance.getObjectAt(1)).intPositiveValueExact();
            this.f16862l = ASN1Integer.getInstance(instance.getObjectAt(2)).intPositiveValueExact();
        } else {
            throw new IllegalArgumentException("object parse error");
        }
    }

    public static DSTU4145BinaryField getInstance(Object obj) {
        if (obj instanceof DSTU4145BinaryField) {
            return (DSTU4145BinaryField) obj;
        }
        if (obj != null) {
            return new DSTU4145BinaryField(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getK1() {
        return this.f16861k;
    }

    public int getK2() {
        return this.f16860j;
    }

    public int getK3() {
        return this.f16862l;
    }

    public int getM() {
        return this.f16863m;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(new ASN1Integer((long) this.f16863m));
        if (this.f16860j == 0) {
            aSN1EncodableVector.add(new ASN1Integer((long) this.f16861k));
        } else {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(3);
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f16861k));
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f16860j));
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f16862l));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
