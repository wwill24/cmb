package j$.time.temporal;

import j$.time.d;
import java.io.Serializable;

public final class s implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final long f42744a;

    /* renamed from: b  reason: collision with root package name */
    private final long f42745b;

    /* renamed from: c  reason: collision with root package name */
    private final long f42746c;

    /* renamed from: d  reason: collision with root package name */
    private final long f42747d;

    private s(long j10, long j11, long j12, long j13) {
        this.f42744a = j10;
        this.f42745b = j11;
        this.f42746c = j12;
        this.f42747d = j13;
    }

    private String c(long j10, m mVar) {
        if (mVar != null) {
            return "Invalid value for " + mVar + " (valid values " + this + "): " + j10;
        }
        return "Invalid value (valid values " + this + "): " + j10;
    }

    public static s i(long j10, long j11) {
        if (j10 <= j11) {
            return new s(j10, j10, j11, j11);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static s j(long j10, long j11, long j12) {
        if (j10 > 1) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        } else if (j11 > j12) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (1 <= j12) {
            return new s(j10, 1, j11, j12);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    public static s k(long j10, long j11) {
        return j(1, j10, j11);
    }

    public final int a(long j10, m mVar) {
        if (g() && h(j10)) {
            return (int) j10;
        }
        throw new d(c(j10, mVar));
    }

    public final void b(long j10, m mVar) {
        if (!h(j10)) {
            throw new d(c(j10, mVar));
        }
    }

    public final long d() {
        return this.f42747d;
    }

    public final long e() {
        return this.f42744a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f42744a == sVar.f42744a && this.f42745b == sVar.f42745b && this.f42746c == sVar.f42746c && this.f42747d == sVar.f42747d;
    }

    public final boolean f() {
        return this.f42744a == this.f42745b && this.f42746c == this.f42747d;
    }

    public final boolean g() {
        return this.f42744a >= -2147483648L && this.f42747d <= 2147483647L;
    }

    public final boolean h(long j10) {
        return j10 >= this.f42744a && j10 <= this.f42747d;
    }

    public final int hashCode() {
        long j10 = this.f42744a;
        long j11 = this.f42745b;
        long j12 = j10 + (j11 << 16) + (j11 >> 48);
        long j13 = this.f42746c;
        long j14 = j12 + (j13 << 32) + (j13 >> 32);
        long j15 = this.f42747d;
        long j16 = j14 + (j15 << 48) + (j15 >> 16);
        return (int) (j16 ^ (j16 >>> 32));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f42744a);
        if (this.f42744a != this.f42745b) {
            sb2.append('/');
            sb2.append(this.f42745b);
        }
        sb2.append(" - ");
        sb2.append(this.f42746c);
        if (this.f42746c != this.f42747d) {
            sb2.append('/');
            sb2.append(this.f42747d);
        }
        return sb2.toString();
    }
}
