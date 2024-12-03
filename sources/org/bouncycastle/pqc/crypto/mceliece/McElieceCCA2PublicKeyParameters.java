package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKeyParameters extends McElieceCCA2KeyParameters {
    private GF2Matrix matrixG;

    /* renamed from: n  reason: collision with root package name */
    private int f24013n;

    /* renamed from: t  reason: collision with root package name */
    private int f24014t;

    public McElieceCCA2PublicKeyParameters(int i10, int i11, GF2Matrix gF2Matrix, String str) {
        super(false, str);
        this.f24013n = i10;
        this.f24014t = i11;
        this.matrixG = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.matrixG;
    }

    public int getK() {
        return this.matrixG.getNumRows();
    }

    public int getN() {
        return this.f24013n;
    }

    public int getT() {
        return this.f24014t;
    }
}
