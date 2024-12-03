package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McEliecePrivateKeyParameters extends McElieceKeyParameters {
    private GF2mField field;
    private PolynomialGF2mSmallM goppaPoly;

    /* renamed from: h  reason: collision with root package name */
    private GF2Matrix f24033h;

    /* renamed from: k  reason: collision with root package name */
    private int f24034k;

    /* renamed from: n  reason: collision with root package name */
    private int f24035n;
    private String oid;

    /* renamed from: p1  reason: collision with root package name */
    private Permutation f24036p1;

    /* renamed from: p2  reason: collision with root package name */
    private Permutation f24037p2;
    private PolynomialGF2mSmallM[] qInv;
    private GF2Matrix sInv;

    public McEliecePrivateKeyParameters(int i10, int i11, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix) {
        super(true, (McElieceParameters) null);
        this.f24034k = i11;
        this.f24035n = i10;
        this.field = gF2mField;
        this.goppaPoly = polynomialGF2mSmallM;
        this.sInv = gF2Matrix;
        this.f24036p1 = permutation;
        this.f24037p2 = permutation2;
        this.f24033h = GoppaCode.createCanonicalCheckMatrix(gF2mField, polynomialGF2mSmallM);
        this.qInv = new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM).getSquareRootMatrix();
    }

    public McEliecePrivateKeyParameters(int i10, int i11, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[][] bArr7) {
        super(true, (McElieceParameters) null);
        this.f24035n = i10;
        this.f24034k = i11;
        GF2mField gF2mField = new GF2mField(bArr);
        this.field = gF2mField;
        this.goppaPoly = new PolynomialGF2mSmallM(gF2mField, bArr2);
        this.sInv = new GF2Matrix(bArr3);
        this.f24036p1 = new Permutation(bArr4);
        this.f24037p2 = new Permutation(bArr5);
        this.f24033h = new GF2Matrix(bArr6);
        this.qInv = new PolynomialGF2mSmallM[bArr7.length];
        for (int i12 = 0; i12 < bArr7.length; i12++) {
            this.qInv[i12] = new PolynomialGF2mSmallM(this.field, bArr7[i12]);
        }
    }

    public GF2mField getField() {
        return this.field;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.goppaPoly;
    }

    public GF2Matrix getH() {
        return this.f24033h;
    }

    public int getK() {
        return this.f24034k;
    }

    public int getN() {
        return this.f24035n;
    }

    public Permutation getP1() {
        return this.f24036p1;
    }

    public Permutation getP2() {
        return this.f24037p2;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.qInv;
    }

    public GF2Matrix getSInv() {
        return this.sInv;
    }
}
