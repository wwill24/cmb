package j$.time.temporal;

public enum a implements m {
    NANO_OF_SECOND("NanoOfSecond", s.i(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", s.i(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", s.i(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", s.i(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", s.i(0, 999)),
    MILLI_OF_DAY("MilliOfDay", s.i(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", s.i(0, 59), 0),
    SECOND_OF_DAY("SecondOfDay", s.i(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", s.i(0, 59), 0),
    MINUTE_OF_DAY("MinuteOfDay", s.i(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", s.i(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", s.i(1, 12)),
    HOUR_OF_DAY("HourOfDay", s.i(0, 23), 0),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", s.i(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", s.i(0, 1), 0),
    DAY_OF_WEEK("DayOfWeek", s.i(1, 7), 0),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", s.i(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", s.i(1, 7)),
    DAY_OF_MONTH("DayOfMonth", s.k(28, 31), 0),
    DAY_OF_YEAR("DayOfYear", s.k(365, 366)),
    EPOCH_DAY("EpochDay", s.i(-365249999634L, 365249999634L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", s.k(4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", s.i(1, 53)),
    PROLEPTIC_MONTH("ProlepticMonth", s.i(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", s.k(999999999, 1000000000)),
    YEAR("Year", s.i(-999999999, 999999999), 0),
    ERA("Era", s.i(0, 1), 0),
    INSTANT_SECONDS("InstantSeconds", s.i(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", s.i(-64800, 64800));
    

    /* renamed from: a  reason: collision with root package name */
    private final String f42723a;

    /* renamed from: b  reason: collision with root package name */
    private final s f42724b;

    private a(String str, s sVar) {
        this.f42723a = str;
        this.f42724b = sVar;
    }

    private a(String str, s sVar, int i10) {
        this.f42723a = str;
        this.f42724b = sVar;
    }

    public final boolean b(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(this);
    }

    public final s d(TemporalAccessor temporalAccessor) {
        return temporalAccessor.e(this);
    }

    public final s e() {
        return this.f42724b;
    }

    public final long h(TemporalAccessor temporalAccessor) {
        return temporalAccessor.j(this);
    }

    public final k i(k kVar, long j10) {
        return kVar.b(j10, this);
    }

    public final boolean isDateBased() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    public final boolean isTimeBased() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    public final int j(long j10) {
        return this.f42724b.a(j10, this);
    }

    public final void k(long j10) {
        this.f42724b.b(j10, this);
    }

    public final String toString() {
        return this.f42723a;
    }
}
