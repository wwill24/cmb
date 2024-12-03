package j$.time.temporal;

import j$.time.LocalDate;
import j$.time.format.F;
import java.util.HashMap;

/* 'enum' modifier removed */
final class f extends h {
    f() {
        super("WEEK_OF_WEEK_BASED_YEAR", 2);
    }

    public final boolean b(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(a.EPOCH_DAY) && h.j(temporalAccessor);
    }

    public final s d(TemporalAccessor temporalAccessor) {
        if (b(temporalAccessor)) {
            return h.n(LocalDate.o(temporalAccessor));
        }
        throw new r("Unsupported field: WeekOfWeekBasedYear");
    }

    public final s e() {
        return s.k(52, 53);
    }

    public final TemporalAccessor f(HashMap hashMap, TemporalAccessor temporalAccessor, F f10) {
        LocalDate localDate;
        long j10;
        LocalDate C;
        long j11;
        HashMap hashMap2 = hashMap;
        F f11 = f10;
        h hVar = h.WEEK_BASED_YEAR;
        Long l10 = (Long) hashMap2.get(hVar);
        a aVar = a.DAY_OF_WEEK;
        Long l11 = (Long) hashMap2.get(aVar);
        if (l10 == null || l11 == null) {
            return null;
        }
        int a10 = hVar.e().a(l10.longValue(), hVar);
        long longValue = ((Long) hashMap2.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
        h.m(temporalAccessor);
        LocalDate w10 = LocalDate.w(a10, 1, 4);
        if (f11 == F.LENIENT) {
            long longValue2 = l11.longValue();
            if (longValue2 > 7) {
                j11 = longValue2 - 1;
                C = w10.C(j11 / 7);
            } else {
                j10 = 1;
                if (longValue2 < 1) {
                    C = w10.C(Math.subtractExact(longValue2, 7) / 7);
                    j11 = longValue2 + 6;
                }
                localDate = w10.C(Math.subtractExact(longValue, j10)).b(longValue2, aVar);
            }
            w10 = C;
            j10 = 1;
            longValue2 = (j11 % 7) + 1;
            localDate = w10.C(Math.subtractExact(longValue, j10)).b(longValue2, aVar);
        } else {
            int j12 = aVar.j(l11.longValue());
            if (longValue < 1 || longValue > 52) {
                (f11 == F.STRICT ? h.n(w10) : e()).b(longValue, this);
            }
            localDate = w10.C(longValue - 1).b((long) j12, aVar);
        }
        hashMap2.remove(this);
        hashMap2.remove(hVar);
        hashMap2.remove(aVar);
        return localDate;
    }

    public final long h(TemporalAccessor temporalAccessor) {
        if (b(temporalAccessor)) {
            return (long) h.o(LocalDate.o(temporalAccessor));
        }
        throw new r("Unsupported field: WeekOfWeekBasedYear");
    }

    public final k i(k kVar, long j10) {
        e().b(j10, this);
        return kVar.f(Math.subtractExact(j10, h(kVar)), b.WEEKS);
    }

    public final String toString() {
        return "WeekOfWeekBasedYear";
    }
}
