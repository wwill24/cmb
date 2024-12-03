package org.bouncycastle.crypto.params;

public class GOST3410ValidationParameters {

    /* renamed from: c  reason: collision with root package name */
    private int f41535c;
    private long cL;

    /* renamed from: x0  reason: collision with root package name */
    private int f41536x0;
    private long x0L;

    public GOST3410ValidationParameters(int i10, int i11) {
        this.f41536x0 = i10;
        this.f41535c = i11;
    }

    public GOST3410ValidationParameters(long j10, long j11) {
        this.x0L = j10;
        this.cL = j11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ValidationParameters)) {
            return false;
        }
        GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
        return gOST3410ValidationParameters.f41535c == this.f41535c && gOST3410ValidationParameters.f41536x0 == this.f41536x0 && gOST3410ValidationParameters.cL == this.cL && gOST3410ValidationParameters.x0L == this.x0L;
    }

    public int getC() {
        return this.f41535c;
    }

    public long getCL() {
        return this.cL;
    }

    public int getX0() {
        return this.f41536x0;
    }

    public long getX0L() {
        return this.x0L;
    }

    public int hashCode() {
        int i10 = this.f41536x0 ^ this.f41535c;
        long j10 = this.x0L;
        int i11 = (i10 ^ ((int) j10)) ^ ((int) (j10 >> 32));
        long j11 = this.cL;
        return (i11 ^ ((int) j11)) ^ ((int) (j11 >> 32));
    }
}
