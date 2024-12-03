package org.bouncycastle.pqc.jcajce.spec;

import java.security.InvalidParameterException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceKeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    private int fieldPoly;

    /* renamed from: m  reason: collision with root package name */
    private int f24061m;

    /* renamed from: n  reason: collision with root package name */
    private int f24062n;

    /* renamed from: t  reason: collision with root package name */
    private int f24063t;

    public McElieceKeyGenParameterSpec() {
        this(11, 50);
    }

    public McElieceKeyGenParameterSpec(int i10) {
        if (i10 >= 1) {
            this.f24061m = 0;
            this.f24062n = 1;
            while (true) {
                int i11 = this.f24062n;
                if (i11 < i10) {
                    this.f24062n = i11 << 1;
                    this.f24061m++;
                } else {
                    int i12 = i11 >>> 1;
                    this.f24063t = i12;
                    int i13 = this.f24061m;
                    this.f24063t = i12 / i13;
                    this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i13);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("key size must be positive");
        }
    }

    public McElieceKeyGenParameterSpec(int i10, int i11) throws InvalidParameterException {
        if (i10 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i10 <= 32) {
            this.f24061m = i10;
            int i12 = 1 << i10;
            this.f24062n = i12;
            if (i11 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i11 <= i12) {
                this.f24063t = i11;
                this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i10);
            } else {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            }
        } else {
            throw new IllegalArgumentException("m is too large");
        }
    }

    public McElieceKeyGenParameterSpec(int i10, int i11, int i12) {
        this.f24061m = i10;
        if (i10 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i10 <= 32) {
            int i13 = 1 << i10;
            this.f24062n = i13;
            this.f24063t = i11;
            if (i11 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i11 > i13) {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            } else if (PolynomialRingGF2.degree(i12) != i10 || !PolynomialRingGF2.isIrreducible(i12)) {
                throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
            } else {
                this.fieldPoly = i12;
            }
        } else {
            throw new IllegalArgumentException(" m is too large");
        }
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }

    public int getM() {
        return this.f24061m;
    }

    public int getN() {
        return this.f24062n;
    }

    public int getT() {
        return this.f24063t;
    }
}
