package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.crypto.rainbow.Layer;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;

public class RainbowPrivateKey extends ASN1Object {

    /* renamed from: b1  reason: collision with root package name */
    private byte[] f23979b1;

    /* renamed from: b2  reason: collision with root package name */
    private byte[] f23980b2;
    private byte[][] invA1;
    private byte[][] invA2;
    private Layer[] layers;
    private ASN1ObjectIdentifier oid;
    private ASN1Integer version;

    /* renamed from: vi  reason: collision with root package name */
    private byte[] f23981vi;

    private RainbowPrivateKey(ASN1Sequence aSN1Sequence) {
        ASN1Sequence aSN1Sequence2 = aSN1Sequence;
        int i10 = 0;
        if (aSN1Sequence2.getObjectAt(0) instanceof ASN1Integer) {
            this.version = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(0));
        } else {
            this.oid = ASN1ObjectIdentifier.getInstance(aSN1Sequence2.getObjectAt(0));
        }
        ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence2.getObjectAt(1);
        this.invA1 = new byte[aSN1Sequence3.size()][];
        for (int i11 = 0; i11 < aSN1Sequence3.size(); i11++) {
            this.invA1[i11] = ((ASN1OctetString) aSN1Sequence3.getObjectAt(i11)).getOctets();
        }
        this.f23979b1 = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence2.getObjectAt(2)).getObjectAt(0)).getOctets();
        ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence2.getObjectAt(3);
        this.invA2 = new byte[aSN1Sequence4.size()][];
        for (int i12 = 0; i12 < aSN1Sequence4.size(); i12++) {
            this.invA2[i12] = ((ASN1OctetString) aSN1Sequence4.getObjectAt(i12)).getOctets();
        }
        this.f23980b2 = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence2.getObjectAt(4)).getObjectAt(0)).getOctets();
        this.f23981vi = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence2.getObjectAt(5)).getObjectAt(0)).getOctets();
        ASN1Sequence aSN1Sequence5 = (ASN1Sequence) aSN1Sequence2.getObjectAt(6);
        byte[][][][] bArr = new byte[aSN1Sequence5.size()][][][];
        byte[][][][] bArr2 = new byte[aSN1Sequence5.size()][][][];
        byte[][][] bArr3 = new byte[aSN1Sequence5.size()][][];
        byte[][] bArr4 = new byte[aSN1Sequence5.size()][];
        int i13 = 0;
        while (i13 < aSN1Sequence5.size()) {
            ASN1Sequence aSN1Sequence6 = (ASN1Sequence) aSN1Sequence5.getObjectAt(i13);
            ASN1Sequence aSN1Sequence7 = (ASN1Sequence) aSN1Sequence6.getObjectAt(i10);
            bArr[i13] = new byte[aSN1Sequence7.size()][][];
            for (int i14 = i10; i14 < aSN1Sequence7.size(); i14++) {
                ASN1Sequence aSN1Sequence8 = (ASN1Sequence) aSN1Sequence7.getObjectAt(i14);
                bArr[i13][i14] = new byte[aSN1Sequence8.size()][];
                for (int i15 = 0; i15 < aSN1Sequence8.size(); i15++) {
                    bArr[i13][i14][i15] = ((ASN1OctetString) aSN1Sequence8.getObjectAt(i15)).getOctets();
                }
            }
            ASN1Sequence aSN1Sequence9 = (ASN1Sequence) aSN1Sequence6.getObjectAt(1);
            bArr2[i13] = new byte[aSN1Sequence9.size()][][];
            for (int i16 = 0; i16 < aSN1Sequence9.size(); i16++) {
                ASN1Sequence aSN1Sequence10 = (ASN1Sequence) aSN1Sequence9.getObjectAt(i16);
                bArr2[i13][i16] = new byte[aSN1Sequence10.size()][];
                for (int i17 = 0; i17 < aSN1Sequence10.size(); i17++) {
                    bArr2[i13][i16][i17] = ((ASN1OctetString) aSN1Sequence10.getObjectAt(i17)).getOctets();
                }
            }
            ASN1Sequence aSN1Sequence11 = (ASN1Sequence) aSN1Sequence6.getObjectAt(2);
            bArr3[i13] = new byte[aSN1Sequence11.size()][];
            for (int i18 = 0; i18 < aSN1Sequence11.size(); i18++) {
                bArr3[i13][i18] = ((ASN1OctetString) aSN1Sequence11.getObjectAt(i18)).getOctets();
            }
            bArr4[i13] = ((ASN1OctetString) aSN1Sequence6.getObjectAt(3)).getOctets();
            i13++;
            i10 = 0;
        }
        int length = this.f23981vi.length - 1;
        this.layers = new Layer[length];
        int i19 = 0;
        while (i19 < length) {
            byte[] bArr5 = this.f23981vi;
            int i20 = i19 + 1;
            this.layers[i19] = new Layer(bArr5[i19], bArr5[i20], RainbowUtil.convertArray(bArr[i19]), RainbowUtil.convertArray(bArr2[i19]), RainbowUtil.convertArray(bArr3[i19]), RainbowUtil.convertArray(bArr4[i19]));
            i19 = i20;
        }
    }

    public RainbowPrivateKey(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.version = new ASN1Integer(1);
        this.invA1 = RainbowUtil.convertArray(sArr);
        this.f23979b1 = RainbowUtil.convertArray(sArr2);
        this.invA2 = RainbowUtil.convertArray(sArr3);
        this.f23980b2 = RainbowUtil.convertArray(sArr4);
        this.f23981vi = RainbowUtil.convertIntArray(iArr);
        this.layers = layerArr;
    }

    public static RainbowPrivateKey getInstance(Object obj) {
        if (obj instanceof RainbowPrivateKey) {
            return (RainbowPrivateKey) obj;
        }
        if (obj != null) {
            return new RainbowPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public short[] getB1() {
        return RainbowUtil.convertArray(this.f23979b1);
    }

    public short[] getB2() {
        return RainbowUtil.convertArray(this.f23980b2);
    }

    public short[][] getInvA1() {
        return RainbowUtil.convertArray(this.invA1);
    }

    public short[][] getInvA2() {
        return RainbowUtil.convertArray(this.invA2);
    }

    public Layer[] getLayers() {
        return this.layers;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public int[] getVi() {
        return RainbowUtil.convertArraytoInt(this.f23981vi);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Encodable aSN1Encodable = this.version;
        if (aSN1Encodable == null) {
            aSN1Encodable = this.oid;
        }
        aSN1EncodableVector.add(aSN1Encodable);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        int i10 = 0;
        while (true) {
            byte[][] bArr = this.invA1;
            if (i10 >= bArr.length) {
                break;
            }
            aSN1EncodableVector2.add(new DEROctetString(bArr[i10]));
            i10++;
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        aSN1EncodableVector3.add(new DEROctetString(this.f23979b1));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
        int i11 = 0;
        while (true) {
            byte[][] bArr2 = this.invA2;
            if (i11 >= bArr2.length) {
                break;
            }
            aSN1EncodableVector4.add(new DEROctetString(bArr2[i11]));
            i11++;
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
        ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
        aSN1EncodableVector5.add(new DEROctetString(this.f23980b2));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector5));
        ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
        aSN1EncodableVector6.add(new DEROctetString(this.f23981vi));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector6));
        ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
        for (int i12 = 0; i12 < this.layers.length; i12++) {
            ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
            byte[][][] convertArray = RainbowUtil.convertArray(this.layers[i12].getCoeffAlpha());
            ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
            for (byte[][] bArr3 : convertArray) {
                ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                int i13 = 0;
                while (true) {
                    if (i13 >= bArr3.length) {
                        break;
                    }
                    aSN1EncodableVector10.add(new DEROctetString(bArr3[i13]));
                    i13++;
                }
                aSN1EncodableVector9.add(new DERSequence(aSN1EncodableVector10));
            }
            aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector9));
            byte[][][] convertArray2 = RainbowUtil.convertArray(this.layers[i12].getCoeffBeta());
            ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
            for (byte[][] bArr4 : convertArray2) {
                ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
                int i14 = 0;
                while (true) {
                    if (i14 >= bArr4.length) {
                        break;
                    }
                    aSN1EncodableVector12.add(new DEROctetString(bArr4[i14]));
                    i14++;
                }
                aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector12));
            }
            aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector11));
            byte[][] convertArray3 = RainbowUtil.convertArray(this.layers[i12].getCoeffGamma());
            ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector();
            for (byte[] dEROctetString : convertArray3) {
                aSN1EncodableVector13.add(new DEROctetString(dEROctetString));
            }
            aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector13));
            aSN1EncodableVector8.add(new DEROctetString(RainbowUtil.convertArray(this.layers[i12].getCoeffEta())));
            aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector8));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector7));
        return new DERSequence(aSN1EncodableVector);
    }
}
