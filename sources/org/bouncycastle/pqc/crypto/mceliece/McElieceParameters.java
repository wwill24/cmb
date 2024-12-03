package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceParameters implements CipherParameters {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    private Digest digest;
    private int fieldPoly;

    /* renamed from: m  reason: collision with root package name */
    private int f24027m;

    /* renamed from: n  reason: collision with root package name */
    private int f24028n;

    /* renamed from: t  reason: collision with root package name */
    private int f24029t;

    public McElieceParameters() {
        this(11, 50);
    }

    public McElieceParameters(int i10) {
        this(i10, (Digest) null);
    }

    public McElieceParameters(int i10, int i11) {
        this(i10, i11, (Digest) null);
    }

    public McElieceParameters(int i10, int i11, int i12) {
        this(i10, i11, i12, (Digest) null);
    }

    public McElieceParameters(int i10, int i11, int i12, Digest digest2) {
        this.f24027m = i10;
        if (i10 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i10 <= 32) {
            int i13 = 1 << i10;
            this.f24028n = i13;
            this.f24029t = i11;
            if (i11 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i11 > i13) {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            } else if (PolynomialRingGF2.degree(i12) != i10 || !PolynomialRingGF2.isIrreducible(i12)) {
                throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
            } else {
                this.fieldPoly = i12;
                this.digest = digest2;
            }
        } else {
            throw new IllegalArgumentException(" m is too large");
        }
    }

    public McElieceParameters(int i10, int i11, Digest digest2) {
        if (i10 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i10 <= 32) {
            this.f24027m = i10;
            int i12 = 1 << i10;
            this.f24028n = i12;
            if (i11 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i11 <= i12) {
                this.f24029t = i11;
                this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i10);
                this.digest = digest2;
            } else {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            }
        } else {
            throw new IllegalArgumentException("m is too large");
        }
    }

    public McElieceParameters(int i10, Digest digest2) {
        if (i10 >= 1) {
            this.f24027m = 0;
            this.f24028n = 1;
            while (true) {
                int i11 = this.f24028n;
                if (i11 < i10) {
                    this.f24028n = i11 << 1;
                    this.f24027m++;
                } else {
                    int i12 = i11 >>> 1;
                    this.f24029t = i12;
                    int i13 = this.f24027m;
                    this.f24029t = i12 / i13;
                    this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i13);
                    this.digest = digest2;
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("key size must be positive");
        }
    }

    public McElieceParameters(Digest digest2) {
        this(11, 50, digest2);
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }

    public int getM() {
        return this.f24027m;
    }

    public int getN() {
        return this.f24028n;
    }

    public int getT() {
        return this.f24029t;
    }
}
