package j$.time;

import j$.time.chrono.g;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.a;
import j$.time.temporal.b;
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
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

public final class OffsetDateTime implements k, l, Comparable<OffsetDateTime>, Serializable {
    public static final OffsetDateTime MIN;

    /* renamed from: a  reason: collision with root package name */
    private final LocalDateTime f42567a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset f42568b;

    static {
        LocalDateTime localDateTime = LocalDateTime.f42563c;
        ZoneOffset zoneOffset = ZoneOffset.f42577g;
        localDateTime.getClass();
        MIN = n(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.f42564d;
        ZoneOffset zoneOffset2 = ZoneOffset.f42576f;
        localDateTime2.getClass();
        n(localDateTime2, zoneOffset2);
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "dateTime");
        LocalDateTime localDateTime2 = localDateTime;
        this.f42567a = localDateTime;
        Objects.requireNonNull(zoneOffset, Range.ATTR_OFFSET);
        ZoneOffset zoneOffset2 = zoneOffset;
        this.f42568b = zoneOffset;
    }

    public static OffsetDateTime m(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof OffsetDateTime) {
            return (OffsetDateTime) temporalAccessor;
        }
        try {
            ZoneOffset q10 = ZoneOffset.q(temporalAccessor);
            LocalDate localDate = (LocalDate) temporalAccessor.k(o.b());
            l lVar = (l) temporalAccessor.k(o.c());
            return (localDate == null || lVar == null) ? ofInstant(Instant.from(temporalAccessor), q10) : new OffsetDateTime(LocalDateTime.w(localDate, lVar), q10);
        } catch (d e10) {
            throw new d("Unable to obtain OffsetDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e10);
        }
    }

    public static OffsetDateTime n(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    public static OffsetDateTime now() {
        c c10 = c.c();
        Instant ofEpochMilli = Instant.ofEpochMilli(System.currentTimeMillis());
        return ofInstant(ofEpochMilli, c10.a().o().d(ofEpochMilli));
    }

    private OffsetDateTime o(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.f42567a != localDateTime || !this.f42568b.equals(zoneOffset)) ? new OffsetDateTime(localDateTime, zoneOffset) : this;
    }

    public static OffsetDateTime of(int i10, int i11, int i12, int i13, int i14, int i15, int i16, ZoneOffset zoneOffset) {
        return new OffsetDateTime(LocalDateTime.v(i10, i11, i12, i13, i14, i15, i16), zoneOffset);
    }

    public static OffsetDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset d10 = zoneId.o().d(instant);
        return new OffsetDateTime(LocalDateTime.x(instant.getEpochSecond(), instant.getNano(), d10), d10);
    }

    public static OffsetDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (OffsetDateTime) dateTimeFormatter.f(charSequence, new i(1));
    }

    public final int a(m mVar) {
        if (!(mVar instanceof a)) {
            return super.a(mVar);
        }
        int i10 = o.f42717a[((a) mVar).ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? this.f42567a.a(mVar) : this.f42568b.r();
        }
        throw new r("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public final k b(long j10, m mVar) {
        if (!(mVar instanceof a)) {
            return (OffsetDateTime) mVar.i(this, j10);
        }
        a aVar = (a) mVar;
        int i10 = o.f42717a[aVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? o(this.f42567a.b(j10, mVar), this.f42568b) : o(this.f42567a, ZoneOffset.u(aVar.j(j10))) : ofInstant(Instant.p(j10, (long) this.f42567a.p()), this.f42568b);
    }

    public final int compareTo(Object obj) {
        int i10;
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        if (this.f42568b.equals(offsetDateTime.f42568b)) {
            i10 = toLocalDateTime().compareTo(offsetDateTime.toLocalDateTime());
        } else {
            i10 = Long.compare(this.f42567a.g(this.f42568b), offsetDateTime.f42567a.g(offsetDateTime.f42568b));
            if (i10 == 0) {
                i10 = this.f42567a.E().q() - offsetDateTime.f42567a.E().q();
            }
        }
        return i10 == 0 ? toLocalDateTime().compareTo(offsetDateTime.toLocalDateTime()) : i10;
    }

    public final k d(LocalDate localDate) {
        return o(this.f42567a.d(localDate), this.f42568b);
    }

    public final s e(m mVar) {
        return mVar instanceof a ? (mVar == a.INSTANT_SECONDS || mVar == a.OFFSET_SECONDS) ? mVar.e() : this.f42567a.e(mVar) : mVar.d(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetDateTime)) {
            return false;
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        return this.f42567a.equals(offsetDateTime.f42567a) && this.f42568b.equals(offsetDateTime.f42568b);
    }

    public final k f(long j10, q qVar) {
        return qVar instanceof b ? o(this.f42567a.f(j10, qVar), this.f42568b) : (OffsetDateTime) qVar.b(this, j10);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    public int getYear() {
        return this.f42567a.r();
    }

    public final k h(k kVar) {
        return kVar.b(toLocalDate().F(), a.EPOCH_DAY).b(this.f42567a.E().z(), a.NANO_OF_DAY).b((long) this.f42568b.r(), a.OFFSET_SECONDS);
    }

    public int hashCode() {
        return this.f42567a.hashCode() ^ this.f42568b.hashCode();
    }

    public final boolean i(m mVar) {
        return (mVar instanceof a) || (mVar != null && mVar.b(this));
    }

    public final long j(m mVar) {
        if (!(mVar instanceof a)) {
            return mVar.h(this);
        }
        int i10 = o.f42717a[((a) mVar).ordinal()];
        return i10 != 1 ? i10 != 2 ? this.f42567a.j(mVar) : (long) this.f42568b.r() : this.f42567a.g(this.f42568b);
    }

    public final Object k(p pVar) {
        if (pVar == o.d() || pVar == o.f()) {
            return this.f42568b;
        }
        if (pVar == o.g()) {
            return null;
        }
        return pVar == o.b() ? toLocalDate() : pVar == o.c() ? this.f42567a.E() : pVar == o.a() ? g.f42585a : pVar == o.e() ? b.NANOS : pVar.a(this);
    }

    public OffsetDateTime plusDays(long j10) {
        return o(this.f42567a.z(j10), this.f42568b);
    }

    public LocalDate toLocalDate() {
        return this.f42567a.C();
    }

    public LocalDateTime toLocalDateTime() {
        return this.f42567a;
    }

    public final String toString() {
        return this.f42567a.toString() + this.f42568b.toString();
    }
}
