package j$.time.temporal;

public enum b implements q {
    NANOS("Nanos"),
    MICROS("Micros"),
    MILLIS("Millis"),
    SECONDS("Seconds"),
    MINUTES("Minutes"),
    HOURS("Hours"),
    HALF_DAYS("HalfDays"),
    DAYS("Days"),
    WEEKS("Weeks"),
    MONTHS("Months"),
    YEARS("Years"),
    DECADES("Decades"),
    CENTURIES("Centuries"),
    MILLENNIA("Millennia"),
    ERAS("Eras"),
    FOREVER("Forever");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f42726a;

    private b(String str) {
        this.f42726a = str;
    }

    public final k b(k kVar, long j10) {
        return kVar.f(j10, this);
    }

    public final boolean isDateBased() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    public final String toString() {
        return this.f42726a;
    }
}
