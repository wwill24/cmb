package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeyParameters extends McElieceKeyParameters {

    /* renamed from: g  reason: collision with root package name */
    private GF2Matrix f24038g;

    /* renamed from: n  reason: collision with root package name */
    private int f24039n;

    /* renamed from: t  reason: collision with root package name */
    private int f24040t;

    public McEliecePublicKeyParameters(int i10, int i11, GF2Matrix gF2Matrix) {
        super(false, (McElieceParameters) null);
        this.f24039n = i10;
        this.f24040t = i11;
        this.f24038g = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.f24038g;
    }

    public int getK() {
        return this.f24038g.getNumRows();
    }

    public int getN() {
        return this.f24039n;
    }

    public int getT() {
        return this.f24040t;
    }
}
