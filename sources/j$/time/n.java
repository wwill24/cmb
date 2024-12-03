package j$.time;

import j$.time.chrono.f;
import j$.time.chrono.g;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.p;
import j$.time.temporal.r;
import j$.time.temporal.s;

public enum n implements TemporalAccessor, l {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    

    /* renamed from: a  reason: collision with root package name */
    private static final n[] f42715a = null;

    static {
        f42715a = values();
    }

    public static n o(int i10) {
        if (i10 >= 1 && i10 <= 12) {
            return f42715a[i10 - 1];
        }
        throw new d("Invalid value for MonthOfYear: " + i10);
    }

    public final int a(m mVar) {
        return mVar == a.MONTH_OF_YEAR ? ordinal() + 1 : super.a(mVar);
    }

    public final s e(m mVar) {
        return mVar == a.MONTH_OF_YEAR ? mVar.e() : super.e(mVar);
    }

    public final k h(k kVar) {
        if (((j$.time.chrono.a) f.c(kVar)).equals(g.f42585a)) {
            return kVar.b((long) (ordinal() + 1), a.MONTH_OF_YEAR);
        }
        throw new d("Adjustment only supported on ISO date-time");
    }

    public final boolean i(m mVar) {
        return mVar instanceof a ? mVar == a.MONTH_OF_YEAR : mVar != null && mVar.b(this);
    }

    public final long j(m mVar) {
        if (mVar == a.MONTH_OF_YEAR) {
            return (long) (ordinal() + 1);
        }
        if (!(mVar instanceof a)) {
            return mVar.h(this);
        }
        throw new r("Unsupported field: " + mVar);
    }

    public final Object k(p pVar) {
        return pVar == o.a() ? g.f42585a : pVar == o.e() ? b.MONTHS : super.k(pVar);
    }

    public final int m(boolean z10) {
        switch (m.f42714a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z10 ? 1 : 0) + true;
            case 3:
                return z10 + true;
            case 4:
                return z10 + true;
            case 5:
                return z10 + true;
            case 6:
                return 1;
            case 7:
                return z10 + true;
            case 8:
                return z10 + true;
            case 9:
                return z10 + true;
            case 10:
                return z10 + true;
            case 11:
                return z10 + true;
            default:
                return z10 + true;
        }
    }

    public final int n(boolean z10) {
        int i10 = m.f42714a[ordinal()];
        return i10 != 1 ? (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) ? 30 : 31 : z10 ? 29 : 28;
    }

    public final n p() {
        return f42715a[((((int) 1) + 12) + ordinal()) % 12];
    }
}
