package j$.time;

import com.facebook.internal.security.CertificateUtil;
import com.mparticle.kits.MPSideloadedKit;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.k;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.p;
import j$.time.temporal.r;
import j$.time.temporal.s;
import java.io.Serializable;
import java.util.Objects;

public final class l implements k, j$.time.temporal.l, Comparable, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final l f42706e;

    /* renamed from: f  reason: collision with root package name */
    public static final l f42707f = new l(23, 59, 59, 999999999);

    /* renamed from: g  reason: collision with root package name */
    public static final l f42708g;

    /* renamed from: h  reason: collision with root package name */
    private static final l[] f42709h = new l[24];

    /* renamed from: a  reason: collision with root package name */
    private final byte f42710a;

    /* renamed from: b  reason: collision with root package name */
    private final byte f42711b;

    /* renamed from: c  reason: collision with root package name */
    private final byte f42712c;

    /* renamed from: d  reason: collision with root package name */
    private final int f42713d;

    static {
        int i10 = 0;
        while (true) {
            l[] lVarArr = f42709h;
            if (i10 < lVarArr.length) {
                lVarArr[i10] = new l(i10, 0, 0, 0);
                i10++;
            } else {
                l lVar = lVarArr[0];
                f42708g = lVar;
                l lVar2 = lVarArr[12];
                f42706e = lVar;
                return;
            }
        }
    }

    private l(int i10, int i11, int i12, int i13) {
        this.f42710a = (byte) i10;
        this.f42711b = (byte) i11;
        this.f42712c = (byte) i12;
        this.f42713d = i13;
    }

    private static l n(int i10, int i11, int i12, int i13) {
        return ((i11 | i12) | i13) == 0 ? f42709h[i10] : new l(i10, i11, i12, i13);
    }

    public static l o(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.k(o.c());
        if (lVar != null) {
            return lVar;
        }
        throw new d("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    private int p(m mVar) {
        switch (k.f42704a[((a) mVar).ordinal()]) {
            case 1:
                return this.f42713d;
            case 2:
                throw new r("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.f42713d / 1000;
            case 4:
                throw new r("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.f42713d / MPSideloadedKit.MIN_SIDELOADED_KIT;
            case 6:
                return (int) (z() / 1000000);
            case 7:
                return this.f42712c;
            case 8:
                return A();
            case 9:
                return this.f42711b;
            case 10:
                return (this.f42710a * 60) + this.f42711b;
            case 11:
                return this.f42710a % 12;
            case 12:
                int i10 = this.f42710a % 12;
                if (i10 % 12 == 0) {
                    return 12;
                }
                return i10;
            case 13:
                return this.f42710a;
            case 14:
                byte b10 = this.f42710a;
                if (b10 == 0) {
                    return 24;
                }
                return b10;
            case 15:
                return this.f42710a / 12;
            default:
                throw new r("Unsupported field: " + mVar);
        }
    }

    public static l s() {
        a.HOUR_OF_DAY.k((long) 0);
        return f42709h[0];
    }

    public static l t(int i10, int i11, int i12, int i13) {
        a.HOUR_OF_DAY.k((long) i10);
        a.MINUTE_OF_HOUR.k((long) i11);
        a.SECOND_OF_MINUTE.k((long) i12);
        a.NANO_OF_SECOND.k((long) i13);
        return n(i10, i11, i12, i13);
    }

    public static l u(long j10) {
        a.NANO_OF_DAY.k(j10);
        int i10 = (int) (j10 / 3600000000000L);
        long j11 = j10 - (((long) i10) * 3600000000000L);
        int i11 = (int) (j11 / 60000000000L);
        long j12 = j11 - (((long) i11) * 60000000000L);
        int i12 = (int) (j12 / 1000000000);
        return n(i10, i11, i12, (int) (j12 - (((long) i12) * 1000000000)));
    }

    public final int A() {
        return (this.f42711b * 60) + (this.f42710a * Tnaf.POW_2_WIDTH) + this.f42712c;
    }

    /* renamed from: B */
    public final l b(long j10, m mVar) {
        if (!(mVar instanceof a)) {
            return (l) mVar.i(this, j10);
        }
        a aVar = (a) mVar;
        aVar.k(j10);
        switch (k.f42704a[aVar.ordinal()]) {
            case 1:
                return C((int) j10);
            case 2:
                return u(j10);
            case 3:
                return C(((int) j10) * 1000);
            case 4:
                return u(j10 * 1000);
            case 5:
                return C(((int) j10) * MPSideloadedKit.MIN_SIDELOADED_KIT);
            case 6:
                return u(j10 * 1000000);
            case 7:
                int i10 = (int) j10;
                if (this.f42712c == i10) {
                    return this;
                }
                a.SECOND_OF_MINUTE.k((long) i10);
                return n(this.f42710a, this.f42711b, i10, this.f42713d);
            case 8:
                return y(j10 - ((long) A()));
            case 9:
                int i11 = (int) j10;
                if (this.f42711b == i11) {
                    return this;
                }
                a.MINUTE_OF_HOUR.k((long) i11);
                return n(this.f42710a, i11, this.f42712c, this.f42713d);
            case 10:
                return w(j10 - ((long) ((this.f42710a * 60) + this.f42711b)));
            case 11:
                return v(j10 - ((long) (this.f42710a % 12)));
            case 12:
                if (j10 == 12) {
                    j10 = 0;
                }
                return v(j10 - ((long) (this.f42710a % 12)));
            case 13:
                int i12 = (int) j10;
                if (this.f42710a == i12) {
                    return this;
                }
                a.HOUR_OF_DAY.k((long) i12);
                return n(i12, this.f42711b, this.f42712c, this.f42713d);
            case 14:
                if (j10 == 24) {
                    j10 = 0;
                }
                int i13 = (int) j10;
                if (this.f42710a == i13) {
                    return this;
                }
                a.HOUR_OF_DAY.k((long) i13);
                return n(i13, this.f42711b, this.f42712c, this.f42713d);
            case 15:
                return v((j10 - ((long) (this.f42710a / 12))) * 12);
            default:
                throw new r("Unsupported field: " + mVar);
        }
    }

    public final l C(int i10) {
        if (this.f42713d == i10) {
            return this;
        }
        a.NANO_OF_SECOND.k((long) i10);
        return n(this.f42710a, this.f42711b, this.f42712c, i10);
    }

    public final int a(m mVar) {
        return mVar instanceof a ? p(mVar) : super.a(mVar);
    }

    public final k d(LocalDate localDate) {
        boolean z10 = localDate instanceof l;
        TemporalAccessor temporalAccessor = localDate;
        if (!z10) {
            temporalAccessor = localDate.h(this);
        }
        return (l) temporalAccessor;
    }

    public final s e(m mVar) {
        return super.e(mVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f42710a == lVar.f42710a && this.f42711b == lVar.f42711b && this.f42712c == lVar.f42712c && this.f42713d == lVar.f42713d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004e, code lost:
        r3 = r3 * r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return v(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.temporal.k f(long r3, j$.time.temporal.q r5) {
        /*
            r2 = this;
            boolean r0 = r5 instanceof j$.time.temporal.b
            if (r0 == 0) goto L_0x0054
            int[] r0 = j$.time.k.f42705b
            r1 = r5
            j$.time.temporal.b r1 = (j$.time.temporal.b) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x004f;
                case 2: goto L_0x0046;
                case 3: goto L_0x003e;
                case 4: goto L_0x0039;
                case 5: goto L_0x0034;
                case 6: goto L_0x002f;
                case 7: goto L_0x0029;
                default: goto L_0x0012;
            }
        L_0x0012:
            j$.time.temporal.r r3 = new j$.time.temporal.r
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Unsupported unit: "
            r4.append(r0)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x0029:
            r0 = 2
            long r3 = r3 % r0
            r0 = 12
            long r3 = r3 * r0
        L_0x002f:
            j$.time.l r3 = r2.v(r3)
            goto L_0x005a
        L_0x0034:
            j$.time.l r3 = r2.w(r3)
            goto L_0x005a
        L_0x0039:
            j$.time.l r3 = r2.y(r3)
            goto L_0x005a
        L_0x003e:
            r0 = 86400000(0x5265c00, double:4.2687272E-316)
            long r3 = r3 % r0
            r0 = 1000000(0xf4240, double:4.940656E-318)
            goto L_0x004e
        L_0x0046:
            r0 = 86400000000(0x141dd76000, double:4.26872718007E-313)
            long r3 = r3 % r0
            r0 = 1000(0x3e8, double:4.94E-321)
        L_0x004e:
            long r3 = r3 * r0
        L_0x004f:
            j$.time.l r3 = r2.x(r3)
            goto L_0x005a
        L_0x0054:
            j$.time.temporal.k r3 = r5.b(r2, r3)
            j$.time.l r3 = (j$.time.l) r3
        L_0x005a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.l.f(long, j$.time.temporal.q):j$.time.temporal.k");
    }

    public final k h(k kVar) {
        return kVar.b(z(), a.NANO_OF_DAY);
    }

    public final int hashCode() {
        long z10 = z();
        return (int) (z10 ^ (z10 >>> 32));
    }

    public final boolean i(m mVar) {
        return mVar instanceof a ? mVar.isTimeBased() : mVar != null && mVar.b(this);
    }

    public final long j(m mVar) {
        return mVar instanceof a ? mVar == a.NANO_OF_DAY ? z() : mVar == a.MICRO_OF_DAY ? z() / 1000 : (long) p(mVar) : mVar.h(this);
    }

    public final Object k(p pVar) {
        if (pVar == o.a() || pVar == o.g() || pVar == o.f() || pVar == o.d()) {
            return null;
        }
        if (pVar == o.c()) {
            return this;
        }
        if (pVar == o.b()) {
            return null;
        }
        return pVar == o.e() ? b.NANOS : pVar.a(this);
    }

    /* renamed from: m */
    public final int compareTo(l lVar) {
        int compare = Integer.compare(this.f42710a, lVar.f42710a);
        if (compare != 0) {
            return compare;
        }
        int compare2 = Integer.compare(this.f42711b, lVar.f42711b);
        if (compare2 != 0) {
            return compare2;
        }
        int compare3 = Integer.compare(this.f42712c, lVar.f42712c);
        return compare3 == 0 ? Integer.compare(this.f42713d, lVar.f42713d) : compare3;
    }

    public final int q() {
        return this.f42713d;
    }

    public final int r() {
        return this.f42712c;
    }

    public final String toString() {
        int i10;
        StringBuilder sb2 = new StringBuilder(18);
        byte b10 = this.f42710a;
        byte b11 = this.f42711b;
        byte b12 = this.f42712c;
        int i11 = this.f42713d;
        sb2.append(b10 < 10 ? "0" : "");
        sb2.append(b10);
        String str = ":0";
        sb2.append(b11 < 10 ? str : CertificateUtil.DELIMITER);
        sb2.append(b11);
        if (b12 > 0 || i11 > 0) {
            if (b12 >= 10) {
                str = CertificateUtil.DELIMITER;
            }
            sb2.append(str);
            sb2.append(b12);
            if (i11 > 0) {
                sb2.append('.');
                int i12 = MPSideloadedKit.MIN_SIDELOADED_KIT;
                if (i11 % MPSideloadedKit.MIN_SIDELOADED_KIT == 0) {
                    i10 = (i11 / MPSideloadedKit.MIN_SIDELOADED_KIT) + 1000;
                } else {
                    if (i11 % 1000 == 0) {
                        i11 /= 1000;
                    } else {
                        i12 = 1000000000;
                    }
                    i10 = i11 + i12;
                }
                sb2.append(Integer.toString(i10).substring(1));
            }
        }
        return sb2.toString();
    }

    public final l v(long j10) {
        return j10 == 0 ? this : n(((((int) (j10 % 24)) + this.f42710a) + 24) % 24, this.f42711b, this.f42712c, this.f42713d);
    }

    public final l w(long j10) {
        if (j10 == 0) {
            return this;
        }
        int i10 = (this.f42710a * 60) + this.f42711b;
        int i11 = ((((int) (j10 % 1440)) + i10) + 1440) % 1440;
        return i10 == i11 ? this : n(i11 / 60, i11 % 60, this.f42712c, this.f42713d);
    }

    public final l x(long j10) {
        if (j10 == 0) {
            return this;
        }
        long z10 = z();
        long j11 = (((j10 % 86400000000000L) + z10) + 86400000000000L) % 86400000000000L;
        return z10 == j11 ? this : n((int) (j11 / 3600000000000L), (int) ((j11 / 60000000000L) % 60), (int) ((j11 / 1000000000) % 60), (int) (j11 % 1000000000));
    }

    public final l y(long j10) {
        if (j10 == 0) {
            return this;
        }
        int i10 = (this.f42711b * 60) + (this.f42710a * Tnaf.POW_2_WIDTH) + this.f42712c;
        int i11 = ((((int) (j10 % 86400)) + i10) + 86400) % 86400;
        return i10 == i11 ? this : n(i11 / 3600, (i11 / 60) % 60, i11 % 60, this.f42713d);
    }

    public final long z() {
        return (((long) this.f42712c) * 1000000000) + (((long) this.f42711b) * 60000000000L) + (((long) this.f42710a) * 3600000000000L) + ((long) this.f42713d);
    }
}
