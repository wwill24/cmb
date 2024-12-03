package j$.time;

import j$.time.chrono.e;
import j$.time.chrono.g;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.k;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.zone.c;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

public final class ZonedDateTime implements k, e, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final LocalDateTime f42580a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset f42581b;

    /* renamed from: c  reason: collision with root package name */
    private final ZoneId f42582c;

    private ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.f42580a = localDateTime;
        this.f42581b = zoneOffset;
        this.f42582c = zoneId;
    }

    private static ZonedDateTime h(long j10, int i10, ZoneId zoneId) {
        ZoneOffset d10 = zoneId.o().d(Instant.p(j10, (long) i10));
        return new ZonedDateTime(LocalDateTime.x(j10, i10, d10), zoneId, d10);
    }

    public static ZonedDateTime m(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof ZonedDateTime) {
            return (ZonedDateTime) temporalAccessor;
        }
        try {
            ZoneId m10 = ZoneId.m(temporalAccessor);
            a aVar = a.INSTANT_SECONDS;
            return temporalAccessor.i(aVar) ? h(temporalAccessor.j(aVar), temporalAccessor.a(a.NANO_OF_SECOND), m10) : q(LocalDateTime.w(LocalDate.o(temporalAccessor), l.o(temporalAccessor)), m10, (ZoneOffset) null);
        } catch (d e10) {
            throw new d("Unable to obtain ZonedDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e10);
        }
    }

    public static ZonedDateTime p(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return h(instant.getEpochSecond(), instant.getNano(), zoneId);
    }

    public static ZonedDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (ZonedDateTime) dateTimeFormatter.f(charSequence, new i(2));
    }

    public static ZonedDateTime q(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        c o10 = zoneId.o();
        List g10 = o10.g(localDateTime);
        if (g10.size() == 1) {
            zoneOffset = (ZoneOffset) g10.get(0);
        } else if (g10.size() == 0) {
            j$.time.zone.a f10 = o10.f(localDateTime);
            localDateTime = localDateTime.A(f10.e().d());
            zoneOffset = f10.f();
        } else if (zoneOffset == null || !g10.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) g10.get(0);
            Objects.requireNonNull(zoneOffset, Range.ATTR_OFFSET);
            ZoneOffset zoneOffset2 = zoneOffset;
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    private ZonedDateTime r(ZoneOffset zoneOffset) {
        return (zoneOffset.equals(this.f42581b) || !this.f42582c.o().g(this.f42580a).contains(zoneOffset)) ? this : new ZonedDateTime(this.f42580a, this.f42582c, zoneOffset);
    }

    public final int a(m mVar) {
        if (!(mVar instanceof a)) {
            return super.a(mVar);
        }
        int i10 = r.f42721a[((a) mVar).ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? this.f42580a.a(mVar) : this.f42581b.r();
        }
        throw new r("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public final k b(long j10, m mVar) {
        if (!(mVar instanceof a)) {
            return (ZonedDateTime) mVar.i(this, j10);
        }
        a aVar = (a) mVar;
        int i10 = r.f42721a[aVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? q(this.f42580a.b(j10, mVar), this.f42582c, this.f42581b) : r(ZoneOffset.u(aVar.j(j10))) : h(j10, this.f42580a.p(), this.f42582c);
    }

    public final k d(LocalDate localDate) {
        return q(LocalDateTime.w(localDate, this.f42580a.E()), this.f42582c, this.f42581b);
    }

    public final s e(m mVar) {
        return mVar instanceof a ? (mVar == a.INSTANT_SECONDS || mVar == a.OFFSET_SECONDS) ? mVar.e() : this.f42580a.e(mVar) : mVar.d(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedDateTime)) {
            return false;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
        return this.f42580a.equals(zonedDateTime.f42580a) && this.f42581b.equals(zonedDateTime.f42581b) && this.f42582c.equals(zonedDateTime.f42582c);
    }

    public final k f(long j10, q qVar) {
        if (!(qVar instanceof b)) {
            return (ZonedDateTime) qVar.b(this, j10);
        }
        if (qVar.isDateBased()) {
            return q(this.f42580a.f(j10, qVar), this.f42582c, this.f42581b);
        }
        LocalDateTime y10 = this.f42580a.f(j10, qVar);
        ZoneOffset zoneOffset = this.f42581b;
        ZoneId zoneId = this.f42582c;
        Objects.requireNonNull(y10, "localDateTime");
        Objects.requireNonNull(zoneOffset, Range.ATTR_OFFSET);
        Objects.requireNonNull(zoneId, "zone");
        return zoneId.o().g(y10).contains(zoneOffset) ? new ZonedDateTime(y10, zoneId, zoneOffset) : h(y10.g(zoneOffset), y10.p(), zoneId);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    public int hashCode() {
        return (this.f42580a.hashCode() ^ this.f42581b.hashCode()) ^ Integer.rotateLeft(this.f42582c.hashCode(), 3);
    }

    public final boolean i(m mVar) {
        return (mVar instanceof a) || (mVar != null && mVar.b(this));
    }

    public final long j(m mVar) {
        if (!(mVar instanceof a)) {
            return mVar.h(this);
        }
        int i10 = r.f42721a[((a) mVar).ordinal()];
        return i10 != 1 ? i10 != 2 ? this.f42580a.j(mVar) : (long) this.f42581b.r() : l();
    }

    public final Object k(p pVar) {
        if (pVar == o.b()) {
            return s();
        }
        if (pVar == o.f() || pVar == o.g()) {
            return this.f42582c;
        }
        if (pVar == o.d()) {
            return this.f42581b;
        }
        if (pVar == o.c()) {
            return v();
        }
        if (pVar != o.a()) {
            return pVar == o.e() ? b.NANOS : pVar.a(this);
        }
        s().getClass();
        return g.f42585a;
    }

    public final ZoneOffset n() {
        return this.f42581b;
    }

    public final ZoneId o() {
        return this.f42582c;
    }

    public final LocalDate s() {
        return this.f42580a.C();
    }

    public final LocalDateTime t() {
        return this.f42580a;
    }

    public OffsetDateTime toOffsetDateTime() {
        return OffsetDateTime.n(this.f42580a, this.f42581b);
    }

    public final String toString() {
        String str = this.f42580a.toString() + this.f42581b.toString();
        if (this.f42581b == this.f42582c) {
            return str;
        }
        return str + '[' + this.f42582c.toString() + PropertyUtils.INDEXED_DELIM2;
    }

    public final LocalDateTime u() {
        return this.f42580a;
    }

    public final l v() {
        return this.f42580a.E();
    }
}
