package j$.time;

import com.coffeemeetsbagel.models.util.DateUtils;
import com.mparticle.kits.MPSideloadedKit;
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

public final class Instant implements k, l, Comparable<Instant>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final Instant f42555c = new Instant(0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final long f42556a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42557b;

    static {
        p(-31557014167219200L, 0);
        p(31556889864403199L, 999999999);
    }

    private Instant(long j10, int i10) {
        this.f42556a = j10;
        this.f42557b = i10;
    }

    public static Instant from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Instant) {
            return (Instant) temporalAccessor;
        }
        Objects.requireNonNull(temporalAccessor, "temporal");
        try {
            return p(temporalAccessor.j(a.INSTANT_SECONDS), (long) temporalAccessor.a(a.NANO_OF_SECOND));
        } catch (d e10) {
            throw new d("Unable to obtain Instant from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e10);
        }
    }

    private static Instant n(long j10, int i10) {
        if ((((long) i10) | j10) == 0) {
            return f42555c;
        }
        if (j10 >= -31557014167219200L && j10 <= 31556889864403199L) {
            return new Instant(j10, i10);
        }
        throw new d("Instant exceeds minimum or maximum instant");
    }

    public static Instant now() {
        c.d();
        return ofEpochMilli(System.currentTimeMillis());
    }

    public static Instant o(long j10) {
        return n(j10, 0);
    }

    public static Instant ofEpochMilli(long j10) {
        return n(Math.floorDiv(j10, 1000), ((int) Math.floorMod(j10, 1000)) * MPSideloadedKit.MIN_SIDELOADED_KIT);
    }

    public static Instant p(long j10, long j11) {
        return n(Math.addExact(j10, Math.floorDiv(j11, 1000000000)), (int) Math.floorMod(j11, 1000000000));
    }

    private Instant q(long j10, long j11) {
        if ((j10 | j11) == 0) {
            return this;
        }
        return p(Math.addExact(Math.addExact(this.f42556a, j10), j11 / 1000000000), ((long) this.f42557b) + (j11 % 1000000000));
    }

    public final int a(m mVar) {
        if (!(mVar instanceof a)) {
            return super.e(mVar).a(mVar.h(this), mVar);
        }
        int i10 = g.f42698a[((a) mVar).ordinal()];
        if (i10 == 1) {
            return this.f42557b;
        }
        if (i10 == 2) {
            return this.f42557b / 1000;
        }
        if (i10 == 3) {
            return this.f42557b / MPSideloadedKit.MIN_SIDELOADED_KIT;
        }
        if (i10 == 4) {
            a.INSTANT_SECONDS.j(this.f42556a);
        }
        throw new r("Unsupported field: " + mVar);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.ofInstant(this, zoneOffset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r3 != r2.f42557b) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r3 != r2.f42557b) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.temporal.k b(long r3, j$.time.temporal.m r5) {
        /*
            r2 = this;
            boolean r0 = r5 instanceof j$.time.temporal.a
            if (r0 == 0) goto L_0x006b
            r0 = r5
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            r0.k(r3)
            int[] r1 = j$.time.g.f42698a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L_0x005a
            r1 = 2
            if (r0 == r1) goto L_0x004c
            r1 = 3
            if (r0 == r1) goto L_0x0042
            r1 = 4
            if (r0 != r1) goto L_0x002b
            long r0 = r2.f42556a
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x0069
            int r5 = r2.f42557b
            j$.time.Instant r3 = n(r3, r5)
            goto L_0x0071
        L_0x002b:
            j$.time.temporal.r r3 = new j$.time.temporal.r
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Unsupported field: "
            r4.append(r0)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x0042:
            int r3 = (int) r3
            r4 = 1000000(0xf4240, float:1.401298E-39)
            int r3 = r3 * r4
            int r4 = r2.f42557b
            if (r3 == r4) goto L_0x0069
            goto L_0x0053
        L_0x004c:
            int r3 = (int) r3
            int r3 = r3 * 1000
            int r4 = r2.f42557b
            if (r3 == r4) goto L_0x0069
        L_0x0053:
            long r4 = r2.f42556a
            j$.time.Instant r3 = n(r4, r3)
            goto L_0x0071
        L_0x005a:
            int r5 = r2.f42557b
            long r0 = (long) r5
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x0069
            long r0 = r2.f42556a
            int r3 = (int) r3
            j$.time.Instant r3 = n(r0, r3)
            goto L_0x0071
        L_0x0069:
            r3 = r2
            goto L_0x0071
        L_0x006b:
            j$.time.temporal.k r3 = r5.i(r2, r3)
            j$.time.Instant r3 = (j$.time.Instant) r3
        L_0x0071:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.Instant.b(long, j$.time.temporal.m):j$.time.temporal.k");
    }

    public final k d(LocalDate localDate) {
        return (Instant) localDate.h(this);
    }

    public final s e(m mVar) {
        return super.e(mVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.f42556a == instant.f42556a && this.f42557b == instant.f42557b;
    }

    public final k f(long j10, q qVar) {
        long j11;
        if (!(qVar instanceof b)) {
            return (Instant) qVar.b(this, j10);
        }
        switch (g.f42699b[((b) qVar).ordinal()]) {
            case 1:
                return q(0, j10);
            case 2:
                return q(j10 / 1000000, (j10 % 1000000) * 1000);
            case 3:
                return q(j10 / 1000, (j10 % 1000) * 1000000);
            case 4:
                return r(j10);
            case 5:
                j11 = 60;
                break;
            case 6:
                j11 = DateUtils.SEC_IN_HOUR;
                break;
            case 7:
                j11 = 43200;
                break;
            case 8:
                j11 = 86400;
                break;
            default:
                throw new r("Unsupported unit: " + qVar);
        }
        j10 = Math.multiplyExact(j10, j11);
        return r(j10);
    }

    public long getEpochSecond() {
        return this.f42556a;
    }

    public int getNano() {
        return this.f42557b;
    }

    public final k h(k kVar) {
        return kVar.b(this.f42556a, a.INSTANT_SECONDS).b((long) this.f42557b, a.NANO_OF_SECOND);
    }

    public final int hashCode() {
        long j10 = this.f42556a;
        return (this.f42557b * 51) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final boolean i(m mVar) {
        return mVar instanceof a ? mVar == a.INSTANT_SECONDS || mVar == a.NANO_OF_SECOND || mVar == a.MICRO_OF_SECOND || mVar == a.MILLI_OF_SECOND : mVar != null && mVar.b(this);
    }

    public final long j(m mVar) {
        int i10;
        if (!(mVar instanceof a)) {
            return mVar.h(this);
        }
        int i11 = g.f42698a[((a) mVar).ordinal()];
        if (i11 == 1) {
            i10 = this.f42557b;
        } else if (i11 == 2) {
            i10 = this.f42557b / 1000;
        } else if (i11 == 3) {
            i10 = this.f42557b / MPSideloadedKit.MIN_SIDELOADED_KIT;
        } else if (i11 == 4) {
            return this.f42556a;
        } else {
            throw new r("Unsupported field: " + mVar);
        }
        return (long) i10;
    }

    public final Object k(p pVar) {
        if (pVar == o.e()) {
            return b.NANOS;
        }
        if (pVar == o.a() || pVar == o.g() || pVar == o.f() || pVar == o.d() || pVar == o.b() || pVar == o.c()) {
            return null;
        }
        return pVar.a(this);
    }

    /* renamed from: m */
    public final int compareTo(Instant instant) {
        int compare = Long.compare(this.f42556a, instant.f42556a);
        return compare != 0 ? compare : this.f42557b - instant.f42557b;
    }

    public final Instant r(long j10) {
        return q(j10, 0);
    }

    public long toEpochMilli() {
        long multiplyExact;
        int i10;
        long j10 = this.f42556a;
        if (j10 >= 0 || this.f42557b <= 0) {
            multiplyExact = Math.multiplyExact(j10, 1000);
            i10 = this.f42557b / MPSideloadedKit.MIN_SIDELOADED_KIT;
        } else {
            multiplyExact = Math.multiplyExact(j10 + 1, 1000);
            i10 = (this.f42557b / MPSideloadedKit.MIN_SIDELOADED_KIT) - 1000;
        }
        return Math.addExact(multiplyExact, (long) i10);
    }

    public String toString() {
        return DateTimeFormatter.f42600h.a(this);
    }
}
