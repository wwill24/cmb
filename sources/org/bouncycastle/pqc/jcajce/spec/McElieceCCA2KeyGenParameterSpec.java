package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceCCA2KeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    public static final String SHA1 = "SHA-1";
    public static final String SHA224 = "SHA-224";
    public static final String SHA256 = "SHA-256";
    public static final String SHA384 = "SHA-384";
    public static final String SHA512 = "SHA-512";
    private final String digest;
    private int fieldPoly;

    /* renamed from: m  reason: collision with root package name */
    private final int f24058m;

    /* renamed from: n  reason: collision with root package name */
    private final int f24059n;

    /* renamed from: t  reason: collision with root package name */
    private final int f24060t;

    public McElieceCCA2KeyGenParameterSpec() {
        this(11, 50, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int i10) {
        this(i10, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int i10, int i11) {
        this(i10, i11, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int i10, int i11, int i12) {
        this(i10, i11, i12, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int i10, int i11, int i12, String str) {
        this.f24058m = i10;
        if (i10 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i10 <= 32) {
            int i13 = 1 << i10;
            this.f24059n = i13;
            this.f24060t = i11;
            if (i11 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i11 > i13) {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            } else if (PolynomialRingGF2.degree(i12) != i10 || !PolynomialRingGF2.isIrreducible(i12)) {
                throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
            } else {
                this.fieldPoly = i12;
                this.digest = str;
            }
        } else {
            throw new IllegalArgumentException(" m is too large");
        }
    }

    public McElieceCCA2KeyGenParameterSpec(int i10, int i11, String str) {
        if (i10 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i10 <= 32) {
            this.f24058m = i10;
            int i12 = 1 << i10;
            this.f24059n = i12;
            if (i11 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i11 <= i12) {
                this.f24060t = i11;
                this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i10);
                this.digest = str;
            } else {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            }
        } else {
            throw new IllegalArgumentException("m is too large");
        }
    }

    public McElieceCCA2KeyGenParameterSpec(int i10, String str) {
        int i11 = 1;
        if (i10 >= 1) {
            int i12 = 0;
            while (i11 < i10) {
                i11 <<= 1;
                i12++;
            }
            this.f24060t = (i11 >>> 1) / i12;
            this.f24058m = i12;
            this.f24059n = i11;
            this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i12);
            this.digest = str;
            return;
        }
        throw new IllegalArgumentException("key size must be positive");
    }

    public String getDigest() {
        return this.digest;
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }

    public int getM() {
        return this.f24058m;
    }

    public int getN() {
        return this.f24059n;
    }

    public int getT() {
        return this.f24060t;
    }
}
