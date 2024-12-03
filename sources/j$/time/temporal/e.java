package j$.time.temporal;

/* 'enum' modifier removed */
final class e extends h {
    e() {
        super("QUARTER_OF_YEAR", 1);
    }

    public final boolean b(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(a.MONTH_OF_YEAR) && h.j(temporalAccessor);
    }

    public final s e() {
        return s.i(1, 4);
    }

    public final long h(TemporalAccessor temporalAccessor) {
        if (b(temporalAccessor)) {
            return (temporalAccessor.j(a.MONTH_OF_YEAR) + 2) / 3;
        }
        throw new r("Unsupported field: QuarterOfYear");
    }

    public final k i(k kVar, long j10) {
        long h10 = h(kVar);
        e().b(j10, this);
        a aVar = a.MONTH_OF_YEAR;
        return kVar.b(((j10 - h10) * 3) + kVar.j(aVar), aVar);
    }

    public final String toString() {
        return "QuarterOfYear";
    }
}
