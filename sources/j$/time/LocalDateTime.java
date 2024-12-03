package j$.time;

import j$.time.chrono.b;
import j$.time.chrono.c;
import j$.time.chrono.g;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.a;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import java.io.Serializable;
import java.util.Objects;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

public final class LocalDateTime implements k, l, c, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final LocalDateTime f42563c = w(LocalDate.f42558d, l.f42706e);

    /* renamed from: d  reason: collision with root package name */
    public static final LocalDateTime f42564d = w(LocalDate.f42559e, l.f42707f);

    /* renamed from: a  reason: collision with root package name */
    private final LocalDate f42565a;

    /* renamed from: b  reason: collision with root package name */
    private final l f42566b;

    private LocalDateTime(LocalDate localDate, l lVar) {
        this.f42565a = localDate;
        this.f42566b = lVar;
    }

    private LocalDateTime B(LocalDate localDate, long j10, long j11, long j12, long j13) {
        LocalDate localDate2;
        l lVar;
        if ((j10 | j11 | j12 | j13) == 0) {
            lVar = this.f42566b;
            localDate2 = localDate;
        } else {
            long j14 = j10 / 24;
            long j15 = j14 + (j11 / 1440) + (j12 / 86400) + (j13 / 86400000000000L);
            long j16 = (long) 1;
            long j17 = ((j10 % 24) * 3600000000000L) + ((j11 % 1440) * 60000000000L) + ((j12 % 86400) * 1000000000) + (j13 % 86400000000000L);
            long z10 = this.f42566b.z();
            long j18 = (j17 * j16) + z10;
            long floorDiv = Math.floorDiv(j18, 86400000000000L) + (j15 * j16);
            long floorMod = Math.floorMod(j18, 86400000000000L);
            lVar = floorMod == z10 ? this.f42566b : l.u(floorMod);
            localDate2 = localDate.A(floorDiv);
        }
        return H(localDate2, lVar);
    }

    private LocalDateTime H(LocalDate localDate, l lVar) {
        return (this.f42565a == localDate && this.f42566b == lVar) ? this : new LocalDateTime(localDate, lVar);
    }

    private int n(LocalDateTime localDateTime) {
        int n10 = this.f42565a.n(localDateTime.f42565a);
        return n10 == 0 ? this.f42566b.compareTo(localDateTime.f42566b) : n10;
    }

    public static LocalDateTime o(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).t();
        }
        if (temporalAccessor instanceof OffsetDateTime) {
            return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
        }
        try {
            return new LocalDateTime(LocalDate.o(temporalAccessor), l.o(temporalAccessor));
        } catch (d e10) {
            throw new d("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e10);
        }
    }

    public static LocalDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.f(charSequence, new i(0));
    }

    public static LocalDateTime u(int i10) {
        return new LocalDateTime(LocalDate.w(i10, 12, 31), l.s());
    }

    public static LocalDateTime v(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        return new LocalDateTime(LocalDate.w(i10, i11, i12), l.t(i13, i14, i15, i16));
    }

    public static LocalDateTime w(LocalDate localDate, l lVar) {
        Objects.requireNonNull(localDate, "date");
        Objects.requireNonNull(lVar, "time");
        return new LocalDateTime(localDate, lVar);
    }

    public static LocalDateTime x(long j10, int i10, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, Range.ATTR_OFFSET);
        long j11 = (long) i10;
        a.NANO_OF_SECOND.k(j11);
        long r10 = j10 + ((long) zoneOffset.r());
        return new LocalDateTime(LocalDate.x(Math.floorDiv(r10, 86400)), l.u((((long) ((int) Math.floorMod(r10, 86400))) * 1000000000) + j11));
    }

    public final LocalDateTime A(long j10) {
        return B(this.f42565a, 0, 0, j10, 0);
    }

    public final LocalDate C() {
        return this.f42565a;
    }

    public final b D() {
        return this.f42565a;
    }

    public final l E() {
        return this.f42566b;
    }

    /* renamed from: F */
    public final LocalDateTime b(long j10, m mVar) {
        return mVar instanceof a ? ((a) mVar).isTimeBased() ? H(this.f42565a, this.f42566b.b(j10, mVar)) : H(this.f42565a.b(j10, mVar), this.f42566b) : (LocalDateTime) mVar.i(this, j10);
    }

    /* renamed from: G */
    public final LocalDateTime d(LocalDate localDate) {
        return H(localDate, this.f42566b);
    }

    public final int a(m mVar) {
        return mVar instanceof a ? ((a) mVar).isTimeBased() ? this.f42566b.a(mVar) : this.f42565a.a(mVar) : super.a(mVar);
    }

    public ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.q(this, zoneId, (ZoneOffset) null);
    }

    public final s e(m mVar) {
        return mVar instanceof a ? ((a) mVar).isTimeBased() ? this.f42566b.e(mVar) : this.f42565a.e(mVar) : mVar.d(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.f42565a.equals(localDateTime.f42565a) && this.f42566b.equals(localDateTime.f42566b);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    public final k h(k kVar) {
        return kVar.b(this.f42565a.F(), a.EPOCH_DAY).b(this.f42566b.z(), a.NANO_OF_DAY);
    }

    public final int hashCode() {
        return this.f42565a.hashCode() ^ this.f42566b.hashCode();
    }

    public final boolean i(m mVar) {
        if (!(mVar instanceof a)) {
            return mVar != null && mVar.b(this);
        }
        a aVar = (a) mVar;
        return aVar.isDateBased() || aVar.isTimeBased();
    }

    public final long j(m mVar) {
        return mVar instanceof a ? ((a) mVar).isTimeBased() ? this.f42566b.j(mVar) : this.f42565a.j(mVar) : mVar.h(this);
    }

    public final Object k(p pVar) {
        if (pVar == o.b()) {
            return this.f42565a;
        }
        if (pVar == o.g() || pVar == o.f() || pVar == o.d()) {
            return null;
        }
        if (pVar == o.c()) {
            return this.f42566b;
        }
        if (pVar != o.a()) {
            return pVar == o.e() ? j$.time.temporal.b.NANOS : pVar.a(this);
        }
        ((LocalDate) D()).getClass();
        return g.f42585a;
    }

    /* renamed from: m */
    public final int compareTo(c cVar) {
        if (cVar instanceof LocalDateTime) {
            return n((LocalDateTime) cVar);
        }
        LocalDateTime localDateTime = (LocalDateTime) cVar;
        int m10 = this.f42565a.compareTo(localDateTime.f42565a);
        if (m10 != 0) {
            return m10;
        }
        int m11 = this.f42566b.compareTo(localDateTime.f42566b);
        if (m11 != 0) {
            return m11;
        }
        ((LocalDate) D()).getClass();
        g gVar = g.f42585a;
        ((LocalDate) localDateTime.D()).getClass();
        gVar.getClass();
        gVar.getClass();
        return 0;
    }

    public final int p() {
        return this.f42566b.q();
    }

    public final int q() {
        return this.f42566b.r();
    }

    public final int r() {
        return this.f42565a.t();
    }

    public final boolean s(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return n(localDateTime) > 0;
        }
        int i10 = (this.f42565a.F() > localDateTime.f42565a.F() ? 1 : (this.f42565a.F() == localDateTime.f42565a.F() ? 0 : -1));
        return i10 > 0 || (i10 == 0 && this.f42566b.z() > localDateTime.f42566b.z());
    }

    public final boolean t(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return n(localDateTime) < 0;
        }
        int i10 = (this.f42565a.F() > localDateTime.f42565a.F() ? 1 : (this.f42565a.F() == localDateTime.f42565a.F() ? 0 : -1));
        return i10 < 0 || (i10 == 0 && this.f42566b.z() < localDateTime.f42566b.z());
    }

    public final String toString() {
        return this.f42565a.toString() + 'T' + this.f42566b.toString();
    }

    /* renamed from: y */
    public final LocalDateTime f(long j10, q qVar) {
        long j11 = j10;
        q qVar2 = qVar;
        if (!(qVar2 instanceof j$.time.temporal.b)) {
            return (LocalDateTime) qVar2.b(this, j11);
        }
        switch (j.f42703a[((j$.time.temporal.b) qVar2).ordinal()]) {
            case 1:
                return B(this.f42565a, 0, 0, 0, j10);
            case 2:
                LocalDateTime z10 = z(j11 / 86400000000L);
                return z10.B(z10.f42565a, 0, 0, 0, (j11 % 86400000000L) * 1000);
            case 3:
                LocalDateTime z11 = z(j11 / 86400000);
                return z11.B(z11.f42565a, 0, 0, 0, (j11 % 86400000) * 1000000);
            case 4:
                return A(j10);
            case 5:
                return B(this.f42565a, 0, j10, 0, 0);
            case 6:
                return B(this.f42565a, j10, 0, 0, 0);
            case 7:
                LocalDateTime z12 = z(j11 / 256);
                return z12.B(z12.f42565a, (j11 % 256) * 12, 0, 0, 0);
            default:
                return H(this.f42565a.f(j11, qVar2), this.f42566b);
        }
    }

    public final LocalDateTime z(long j10) {
        return H(this.f42565a.A(j10), this.f42566b);
    }
}
