package j$.time.temporal;

import j$.time.LocalDate;

/* 'enum' modifier removed */
final class g extends h {
    g() {
        super("WEEK_BASED_YEAR", 3);
    }

    public final boolean b(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(a.EPOCH_DAY) && h.j(temporalAccessor);
    }

    public final s e() {
        return a.YEAR.e();
    }

    public final long h(TemporalAccessor temporalAccessor) {
        if (b(temporalAccessor)) {
            return (long) h.r(LocalDate.o(temporalAccessor));
        }
        throw new r("Unsupported field: WeekBasedYear");
    }

    public final k i(k kVar, long j10) {
        if (b(kVar)) {
            int a10 = e().a(j10, h.WEEK_BASED_YEAR);
            LocalDate o10 = LocalDate.o(kVar);
            a aVar = a.DAY_OF_WEEK;
            int a11 = o10.a(aVar);
            int o11 = h.o(o10);
            if (o11 == 53 && h.s(a10) == 52) {
                o11 = 52;
            }
            LocalDate w10 = LocalDate.w(a10, 1, 4);
            return kVar.d(w10.A((long) (((o11 - 1) * 7) + (a11 - w10.a(aVar)))));
        }
        throw new r("Unsupported field: WeekBasedYear");
    }

    public final String toString() {
        return "WeekBasedYear";
    }
}
