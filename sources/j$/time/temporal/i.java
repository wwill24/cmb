package j$.time.temporal;

enum i implements q {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f42731a;

    private i(String str) {
        this.f42731a = str;
    }

    public final k b(k kVar, long j10) {
        int i10 = c.f42727a[ordinal()];
        if (i10 == 1) {
            m mVar = j.f42734c;
            return kVar.b(Math.addExact((long) kVar.a(mVar), j10), mVar);
        } else if (i10 == 2) {
            return kVar.f(j10 / 256, b.YEARS).f((j10 % 256) * 3, b.MONTHS);
        } else {
            throw new IllegalStateException("Unreachable");
        }
    }

    public final boolean isDateBased() {
        return true;
    }

    public final String toString() {
        return this.f42731a;
    }
}
