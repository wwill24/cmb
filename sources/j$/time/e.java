package j$.time;

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

public enum e implements TemporalAccessor, l {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    

    /* renamed from: a  reason: collision with root package name */
    private static final e[] f42586a = null;

    static {
        f42586a = values();
    }

    public static e n(int i10) {
        if (i10 >= 1 && i10 <= 7) {
            return f42586a[i10 - 1];
        }
        throw new d("Invalid value for DayOfWeek: " + i10);
    }

    public final int a(m mVar) {
        return mVar == a.DAY_OF_WEEK ? m() : super.a(mVar);
    }

    public final s e(m mVar) {
        return mVar == a.DAY_OF_WEEK ? mVar.e() : super.e(mVar);
    }

    public final k h(k kVar) {
        return kVar.b((long) m(), a.DAY_OF_WEEK);
    }

    public final boolean i(m mVar) {
        return mVar instanceof a ? mVar == a.DAY_OF_WEEK : mVar != null && mVar.b(this);
    }

    public final long j(m mVar) {
        if (mVar == a.DAY_OF_WEEK) {
            return (long) m();
        }
        if (!(mVar instanceof a)) {
            return mVar.h(this);
        }
        throw new r("Unsupported field: " + mVar);
    }

    public final Object k(p pVar) {
        return pVar == o.e() ? b.DAYS : super.k(pVar);
    }

    public final int m() {
        return ordinal() + 1;
    }

    public final e o(long j10) {
        return f42586a[((((int) (j10 % 7)) + 7) + ordinal()) % 7];
    }
}
