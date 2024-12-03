package j$.time;

import j$.time.chrono.b;
import j$.time.chrono.g;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.a;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import java.io.Serializable;
import java.util.Objects;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.cli.HelpFormatter;

public final class LocalDate implements k, l, b, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final LocalDate f42558d = w(-999999999, 1, 1);

    /* renamed from: e  reason: collision with root package name */
    public static final LocalDate f42559e = w(999999999, 12, 31);

    /* renamed from: a  reason: collision with root package name */
    private final int f42560a;

    /* renamed from: b  reason: collision with root package name */
    private final short f42561b;

    /* renamed from: c  reason: collision with root package name */
    private final short f42562c;

    private LocalDate(int i10, int i11, int i12) {
        this.f42560a = i10;
        this.f42561b = (short) i11;
        this.f42562c = (short) i12;
    }

    private static LocalDate E(int i10, int i11, int i12) {
        int i13;
        if (i11 != 2) {
            if (i11 == 4 || i11 == 6 || i11 == 9 || i11 == 11) {
                i13 = 30;
            }
            return new LocalDate(i10, i11, i12);
        }
        g.f42585a.getClass();
        i13 = g.e((long) i10) ? 29 : 28;
        i12 = Math.min(i12, i13);
        return new LocalDate(i10, i11, i12);
    }

    public static LocalDate now() {
        c c10 = c.c();
        Instant ofEpochMilli = Instant.ofEpochMilli(System.currentTimeMillis());
        return x(Math.floorDiv(ofEpochMilli.getEpochSecond() + ((long) c10.a().o().d(ofEpochMilli).r()), 86400));
    }

    public static LocalDate o(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalDate localDate = (LocalDate) temporalAccessor.k(o.b());
        if (localDate != null) {
            return localDate;
        }
        throw new d("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    private int p(m mVar) {
        switch (h.f42700a[((a) mVar).ordinal()]) {
            case 1:
                return this.f42562c;
            case 2:
                return r();
            case 3:
                return ((this.f42562c - 1) / 7) + 1;
            case 4:
                int i10 = this.f42560a;
                return i10 >= 1 ? i10 : 1 - i10;
            case 5:
                return q().m();
            case 6:
                return ((this.f42562c - 1) % 7) + 1;
            case 7:
                return ((r() - 1) % 7) + 1;
            case 8:
                throw new r("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((r() - 1) / 7) + 1;
            case 10:
                return this.f42561b;
            case 11:
                throw new r("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.f42560a;
            case 13:
                return this.f42560a >= 1 ? 1 : 0;
            default:
                throw new r("Unsupported field: " + mVar);
        }
    }

    private long s() {
        return ((((long) this.f42560a) * 12) + ((long) this.f42561b)) - 1;
    }

    public static LocalDate w(int i10, int i11, int i12) {
        long j10 = (long) i10;
        a.YEAR.k(j10);
        a.MONTH_OF_YEAR.k((long) i11);
        a.DAY_OF_MONTH.k((long) i12);
        int i13 = 28;
        if (i12 > 28) {
            int i14 = 31;
            if (i11 == 2) {
                g.f42585a.getClass();
                if (g.e(j10)) {
                    i13 = 29;
                }
                i14 = i13;
            } else if (i11 == 4 || i11 == 6 || i11 == 9 || i11 == 11) {
                i14 = 30;
            }
            if (i12 > i14) {
                if (i12 == 29) {
                    throw new d("Invalid date 'February 29' as '" + i10 + "' is not a leap year");
                }
                StringBuilder a10 = a.a("Invalid date '");
                a10.append(n.o(i11).name());
                a10.append(" ");
                a10.append(i12);
                a10.append("'");
                throw new d(a10.toString());
            }
        }
        return new LocalDate(i10, i11, i12);
    }

    public static LocalDate x(long j10) {
        long j11;
        long j12 = (j10 + 719528) - 60;
        if (j12 < 0) {
            long j13 = ((j12 + 1) / 146097) - 1;
            j11 = j13 * 400;
            j12 += (-j13) * 146097;
        } else {
            j11 = 0;
        }
        long j14 = ((j12 * 400) + 591) / 146097;
        long j15 = j12 - ((j14 / 400) + (((j14 / 4) + (j14 * 365)) - (j14 / 100)));
        if (j15 < 0) {
            j14--;
            j15 = j12 - ((j14 / 400) + (((j14 / 4) + (365 * j14)) - (j14 / 100)));
        }
        int i10 = (int) j15;
        int i11 = ((i10 * 5) + 2) / Opcodes.IFEQ;
        return new LocalDate(a.YEAR.j(j14 + j11 + ((long) (i11 / 10))), ((i11 + 2) % 12) + 1, (i10 - (((i11 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate y(int i10, int i11) {
        long j10 = (long) i10;
        a.YEAR.k(j10);
        a.DAY_OF_YEAR.k((long) i11);
        g.f42585a.getClass();
        boolean e10 = g.e(j10);
        if (i11 != 366 || e10) {
            n o10 = n.o(((i11 - 1) / 31) + 1);
            if (i11 > (o10.n(e10) + o10.m(e10)) - 1) {
                o10 = o10.p();
            }
            return new LocalDate(i10, o10.ordinal() + 1, (i11 - o10.m(e10)) + 1);
        }
        throw new d("Invalid date 'DayOfYear 366' as '" + i10 + "' is not a leap year");
    }

    public final LocalDate A(long j10) {
        return j10 == 0 ? this : x(Math.addExact(F(), j10));
    }

    public final LocalDate B(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = (((long) this.f42560a) * 12) + ((long) (this.f42561b - 1)) + j10;
        return E(a.YEAR.j(Math.floorDiv(j11, 12)), ((int) Math.floorMod(j11, 12)) + 1, this.f42562c);
    }

    public final LocalDate C(long j10) {
        return A(Math.multiplyExact(j10, 7));
    }

    public final LocalDate D(long j10) {
        return j10 == 0 ? this : E(a.YEAR.j(((long) this.f42560a) + j10), this.f42561b, this.f42562c);
    }

    public final long F() {
        long j10;
        long j11 = (long) this.f42560a;
        long j12 = (long) this.f42561b;
        long j13 = (365 * j11) + 0;
        if (j11 >= 0) {
            j10 = ((j11 + 399) / 400) + (((3 + j11) / 4) - ((99 + j11) / 100)) + j13;
        } else {
            j10 = j13 - ((j11 / -400) + ((j11 / -4) - (j11 / -100)));
        }
        long j14 = (((367 * j12) - 362) / 12) + j10 + ((long) (this.f42562c - 1));
        if (j12 > 2) {
            j14--;
            if (!u()) {
                j14--;
            }
        }
        return j14 - 719528;
    }

    public final Period G(b bVar) {
        LocalDate o10 = o(bVar);
        long s10 = o10.s() - s();
        int i10 = o10.f42562c - this.f42562c;
        int i11 = (s10 > 0 ? 1 : (s10 == 0 ? 0 : -1));
        if (i11 > 0 && i10 < 0) {
            s10--;
            i10 = (int) (o10.F() - B(s10).F());
        } else if (i11 < 0 && i10 > 0) {
            s10++;
            i10 -= o10.v();
        }
        return Period.c(Math.toIntExact(s10 / 12), (int) (s10 % 12), i10);
    }

    /* renamed from: H */
    public final LocalDate b(long j10, m mVar) {
        if (!(mVar instanceof a)) {
            return (LocalDate) mVar.i(this, j10);
        }
        a aVar = (a) mVar;
        aVar.k(j10);
        switch (h.f42700a[aVar.ordinal()]) {
            case 1:
                int i10 = (int) j10;
                return this.f42562c == i10 ? this : w(this.f42560a, this.f42561b, i10);
            case 2:
                return J((int) j10);
            case 3:
                return C(j10 - j(a.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (this.f42560a < 1) {
                    j10 = 1 - j10;
                }
                return K((int) j10);
            case 5:
                return A(j10 - ((long) q().m()));
            case 6:
                return A(j10 - j(a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return A(j10 - j(a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return x(j10);
            case 9:
                return C(j10 - j(a.ALIGNED_WEEK_OF_YEAR));
            case 10:
                int i11 = (int) j10;
                if (this.f42561b == i11) {
                    return this;
                }
                a.MONTH_OF_YEAR.k((long) i11);
                return E(this.f42560a, i11, this.f42562c);
            case 11:
                return B(j10 - s());
            case 12:
                return K((int) j10);
            case 13:
                return j(a.ERA) == j10 ? this : K(1 - this.f42560a);
            default:
                throw new r("Unsupported field: " + mVar);
        }
    }

    /* renamed from: I */
    public final LocalDate d(l lVar) {
        return lVar instanceof LocalDate ? (LocalDate) lVar : (LocalDate) lVar.h(this);
    }

    public final LocalDate J(int i10) {
        return r() == i10 ? this : y(this.f42560a, i10);
    }

    public final LocalDate K(int i10) {
        if (this.f42560a == i10) {
            return this;
        }
        a.YEAR.k((long) i10);
        return E(i10, this.f42561b, this.f42562c);
    }

    public final int a(m mVar) {
        return mVar instanceof a ? p(mVar) : super.a(mVar);
    }

    public final s e(m mVar) {
        int i10;
        if (!(mVar instanceof a)) {
            return mVar.d(this);
        }
        a aVar = (a) mVar;
        if (aVar.isDateBased()) {
            int i11 = h.f42700a[aVar.ordinal()];
            if (i11 == 1) {
                i10 = v();
            } else if (i11 == 2) {
                i10 = u() ? 366 : 365;
            } else if (i11 == 3) {
                return s.i(1, (n.o(this.f42561b) != n.FEBRUARY || u()) ? 5 : 4);
            } else if (i11 != 4) {
                return mVar.e();
            } else {
                return s.i(1, this.f42560a <= 0 ? 1000000000 : 999999999);
            }
            return s.i(1, (long) i10);
        }
        throw new r("Unsupported field: " + mVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDate) {
            return n((LocalDate) obj) == 0;
        }
        return false;
    }

    public final k h(k kVar) {
        return kVar.b(F(), a.EPOCH_DAY);
    }

    public final int hashCode() {
        int i10 = this.f42560a;
        return (((i10 << 11) + (this.f42561b << 6)) + this.f42562c) ^ (i10 & -2048);
    }

    public final boolean i(m mVar) {
        return mVar instanceof a ? mVar.isDateBased() : mVar != null && mVar.b(this);
    }

    public final long j(m mVar) {
        return mVar instanceof a ? mVar == a.EPOCH_DAY ? F() : mVar == a.PROLEPTIC_MONTH ? s() : (long) p(mVar) : mVar.h(this);
    }

    public final Object k(p pVar) {
        if (pVar == o.b()) {
            return this;
        }
        if (pVar == o.g() || pVar == o.f() || pVar == o.d() || pVar == o.c()) {
            return null;
        }
        return pVar == o.a() ? g.f42585a : pVar == o.e() ? j$.time.temporal.b.DAYS : pVar.a(this);
    }

    /* renamed from: m */
    public final int compareTo(b bVar) {
        if (bVar instanceof LocalDate) {
            return n((LocalDate) bVar);
        }
        int compare = Long.compare(F(), ((LocalDate) bVar).F());
        if (compare != 0) {
            return compare;
        }
        g.f42585a.getClass();
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int n(LocalDate localDate) {
        int i10 = this.f42560a - localDate.f42560a;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.f42561b - localDate.f42561b;
        return i11 == 0 ? this.f42562c - localDate.f42562c : i11;
    }

    public final e q() {
        return e.n(((int) Math.floorMod(F() + 3, 7)) + 1);
    }

    public final int r() {
        return (n.o(this.f42561b).m(u()) + this.f42562c) - 1;
    }

    public final int t() {
        return this.f42560a;
    }

    public final String toString() {
        int i10;
        int i11 = this.f42560a;
        short s10 = this.f42561b;
        short s11 = this.f42562c;
        int abs = Math.abs(i11);
        StringBuilder sb2 = new StringBuilder(10);
        if (abs < 1000) {
            if (i11 < 0) {
                sb2.append(i11 - 10000);
                i10 = 1;
            } else {
                sb2.append(i11 + 10000);
                i10 = 0;
            }
            sb2.deleteCharAt(i10);
        } else {
            if (i11 > 9999) {
                sb2.append(SignatureVisitor.EXTENDS);
            }
            sb2.append(i11);
        }
        String str = "-0";
        sb2.append(s10 < 10 ? str : HelpFormatter.DEFAULT_OPT_PREFIX);
        sb2.append(s10);
        if (s11 >= 10) {
            str = HelpFormatter.DEFAULT_OPT_PREFIX;
        }
        sb2.append(str);
        sb2.append(s11);
        return sb2.toString();
    }

    public final boolean u() {
        g.f42585a.getClass();
        return g.e((long) this.f42560a);
    }

    public final int v() {
        short s10 = this.f42561b;
        return s10 != 2 ? (s10 == 4 || s10 == 6 || s10 == 9 || s10 == 11) ? 30 : 31 : u() ? 29 : 28;
    }

    /* renamed from: z */
    public final LocalDate f(long j10, q qVar) {
        if (!(qVar instanceof j$.time.temporal.b)) {
            return (LocalDate) qVar.b(this, j10);
        }
        switch (h.f42701b[((j$.time.temporal.b) qVar).ordinal()]) {
            case 1:
                return A(j10);
            case 2:
                return C(j10);
            case 3:
                return B(j10);
            case 4:
                return D(j10);
            case 5:
                return D(Math.multiplyExact(j10, 10));
            case 6:
                return D(Math.multiplyExact(j10, 100));
            case 7:
                return D(Math.multiplyExact(j10, 1000));
            case 8:
                a aVar = a.ERA;
                return b(Math.addExact(j(aVar), j10), aVar);
            default:
                throw new r("Unsupported unit: " + qVar);
        }
    }
}
