package j$.time.temporal;

import j$.time.LocalDate;
import j$.time.chrono.g;
import j$.time.format.F;
import java.util.HashMap;

/* 'enum' modifier removed */
final class d extends h {
    d() {
        super("DAY_OF_QUARTER", 0);
    }

    public final boolean b(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(a.DAY_OF_YEAR) && temporalAccessor.i(a.MONTH_OF_YEAR) && temporalAccessor.i(a.YEAR) && h.j(temporalAccessor);
    }

    public final s d(TemporalAccessor temporalAccessor) {
        if (b(temporalAccessor)) {
            long j10 = temporalAccessor.j(h.QUARTER_OF_YEAR);
            if (j10 != 1) {
                return j10 == 2 ? s.i(1, 91) : (j10 == 3 || j10 == 4) ? s.i(1, 92) : e();
            }
            long j11 = temporalAccessor.j(a.YEAR);
            g.f42585a.getClass();
            return g.e(j11) ? s.i(1, 91) : s.i(1, 90);
        }
        throw new r("Unsupported field: DayOfQuarter");
    }

    public final s e() {
        return s.k(90, 92);
    }

    public final TemporalAccessor f(HashMap hashMap, TemporalAccessor temporalAccessor, F f10) {
        LocalDate localDate;
        long j10;
        a aVar = a.YEAR;
        Long l10 = (Long) hashMap.get(aVar);
        h hVar = h.QUARTER_OF_YEAR;
        Long l11 = (Long) hashMap.get(hVar);
        if (l10 == null || l11 == null) {
            return null;
        }
        int j11 = aVar.j(l10.longValue());
        long longValue = ((Long) hashMap.get(h.DAY_OF_QUARTER)).longValue();
        h.m(temporalAccessor);
        if (f10 == F.LENIENT) {
            localDate = LocalDate.w(j11, 1, 1).B(Math.multiplyExact(Math.subtractExact(l11.longValue(), 1), 3));
            j10 = Math.subtractExact(longValue, 1);
        } else {
            localDate = LocalDate.w(j11, ((hVar.e().a(l11.longValue(), hVar) - 1) * 3) + 1, 1);
            if (longValue < 1 || longValue > 90) {
                (f10 == F.STRICT ? d(localDate) : e()).b(longValue, this);
            }
            j10 = longValue - 1;
        }
        hashMap.remove(this);
        hashMap.remove(aVar);
        hashMap.remove(hVar);
        return localDate.A(j10);
    }

    public final long h(TemporalAccessor temporalAccessor) {
        if (b(temporalAccessor)) {
            int a10 = temporalAccessor.a(a.DAY_OF_YEAR);
            int a11 = temporalAccessor.a(a.MONTH_OF_YEAR);
            long j10 = temporalAccessor.j(a.YEAR);
            int[] k10 = h.f42728a;
            int i10 = (a11 - 1) / 3;
            g.f42585a.getClass();
            return (long) (a10 - k10[i10 + (g.e(j10) ? 4 : 0)]);
        }
        throw new r("Unsupported field: DayOfQuarter");
    }

    public final k i(k kVar, long j10) {
        long h10 = h(kVar);
        e().b(j10, this);
        a aVar = a.DAY_OF_YEAR;
        return kVar.b((j10 - h10) + kVar.j(aVar), aVar);
    }

    public final String toString() {
        return "DayOfQuarter";
    }
}
