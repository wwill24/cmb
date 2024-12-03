package j$.time;

import j$.time.temporal.b;
import j$.time.temporal.q;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

public final class Period implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final Period f42569d = new Period(0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final int f42570a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42571b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42572c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        Collections.unmodifiableList(Arrays.asList(new q[]{b.YEARS, b.MONTHS, b.DAYS}));
    }

    private Period(int i10, int i11, int i12) {
        this.f42570a = i10;
        this.f42571b = i11;
        this.f42572c = i12;
    }

    public static Period between(LocalDate localDate, LocalDate localDate2) {
        return localDate.G(localDate2);
    }

    public static Period c(int i10, int i11, int i12) {
        return ((i10 | i11) | i12) == 0 ? f42569d : new Period(i10, i11, i12);
    }

    public static Period d(int i10) {
        return (0 | i10) == 0 ? f42569d : new Period(0, 0, i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.temporal.k a(j$.time.temporal.k r7) {
        /*
            r6 = this;
            j$.time.temporal.n r0 = j$.time.temporal.o.a()
            r1 = r7
            j$.time.LocalDate r1 = (j$.time.LocalDate) r1
            java.lang.Object r0 = r1.k(r0)
            j$.time.chrono.f r0 = (j$.time.chrono.f) r0
            if (r0 == 0) goto L_0x0020
            j$.time.chrono.g r2 = j$.time.chrono.g.f42585a
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0018
            goto L_0x0020
        L_0x0018:
            j$.time.d r7 = new j$.time.d
            java.lang.String r0 = "Chronology mismatch, expected: ISO, actual: ISO"
            r7.<init>(r0)
            throw r7
        L_0x0020:
            int r0 = r6.f42571b
            if (r0 != 0) goto L_0x002c
            int r0 = r6.f42570a
            if (r0 == 0) goto L_0x003c
            long r2 = (long) r0
            j$.time.temporal.b r7 = j$.time.temporal.b.YEARS
            goto L_0x0038
        L_0x002c:
            long r2 = r6.e()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x003c
            j$.time.temporal.b r7 = j$.time.temporal.b.MONTHS
        L_0x0038:
            j$.time.LocalDate r7 = r1.f(r2, r7)
        L_0x003c:
            int r0 = r6.f42572c
            if (r0 == 0) goto L_0x0049
            long r0 = (long) r0
            j$.time.temporal.b r2 = j$.time.temporal.b.DAYS
            j$.time.LocalDate r7 = (j$.time.LocalDate) r7
            j$.time.LocalDate r7 = r7.f(r0, r2)
        L_0x0049:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.Period.a(j$.time.temporal.k):j$.time.temporal.k");
    }

    public final int b() {
        return this.f42572c;
    }

    public final long e() {
        return (((long) this.f42570a) * 12) + ((long) this.f42571b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.f42570a == period.f42570a && this.f42571b == period.f42571b && this.f42572c == period.f42572c;
    }

    public int getYears() {
        return this.f42570a;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f42572c, 16) + Integer.rotateLeft(this.f42571b, 8) + this.f42570a;
    }

    public final String toString() {
        if (this == f42569d) {
            return "P0D";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('P');
        int i10 = this.f42570a;
        if (i10 != 0) {
            sb2.append(i10);
            sb2.append('Y');
        }
        int i11 = this.f42571b;
        if (i11 != 0) {
            sb2.append(i11);
            sb2.append('M');
        }
        int i12 = this.f42572c;
        if (i12 != 0) {
            sb2.append(i12);
            sb2.append('D');
        }
        return sb2.toString();
    }
}
