package j$.time.format;

import j$.time.a;
import j$.time.d;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.m;
import j$.time.temporal.p;
import java.util.Locale;

final class A {

    /* renamed from: a  reason: collision with root package name */
    private TemporalAccessor f42591a;

    /* renamed from: b  reason: collision with root package name */
    private DateTimeFormatter f42592b;

    /* renamed from: c  reason: collision with root package name */
    private int f42593c;

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    A(j$.time.temporal.TemporalAccessor r10, j$.time.format.DateTimeFormatter r11) {
        /*
            r9 = this;
            r9.<init>()
            j$.time.chrono.f r0 = r11.b()
            j$.time.ZoneId r1 = r11.e()
            if (r0 != 0) goto L_0x0011
            if (r1 != 0) goto L_0x0011
            goto L_0x010c
        L_0x0011:
            j$.time.temporal.n r2 = j$.time.temporal.o.a()
            java.lang.Object r2 = r10.k(r2)
            j$.time.chrono.f r2 = (j$.time.chrono.f) r2
            j$.time.temporal.n r3 = j$.time.temporal.o.g()
            java.lang.Object r3 = r10.k(r3)
            j$.time.ZoneId r3 = (j$.time.ZoneId) r3
            boolean r4 = java.util.Objects.equals(r0, r2)
            r5 = 0
            if (r4 == 0) goto L_0x002d
            r0 = r5
        L_0x002d:
            boolean r4 = java.util.Objects.equals(r1, r3)
            if (r4 == 0) goto L_0x0034
            r1 = r5
        L_0x0034:
            if (r0 != 0) goto L_0x003a
            if (r1 != 0) goto L_0x003a
            goto L_0x010c
        L_0x003a:
            if (r0 == 0) goto L_0x003e
            r4 = r0
            goto L_0x003f
        L_0x003e:
            r4 = r2
        L_0x003f:
            if (r1 == 0) goto L_0x00af
            j$.time.temporal.a r6 = j$.time.temporal.a.INSTANT_SECONDS
            boolean r6 = r10.i(r6)
            if (r6 == 0) goto L_0x005d
            if (r4 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            j$.time.chrono.g r4 = j$.time.chrono.g.f42585a
        L_0x004e:
            j$.time.Instant r10 = j$.time.Instant.from(r10)
            j$.time.chrono.g r4 = (j$.time.chrono.g) r4
            r4.getClass()
            j$.time.ZonedDateTime r10 = j$.time.ZonedDateTime.p(r10, r1)
            goto L_0x010c
        L_0x005d:
            j$.time.zone.c r6 = r1.o()     // Catch:{ d -> 0x006e }
            boolean r7 = r6.i()     // Catch:{ d -> 0x006e }
            if (r7 == 0) goto L_0x006e
            j$.time.Instant r7 = j$.time.Instant.f42555c     // Catch:{ d -> 0x006e }
            j$.time.ZoneOffset r6 = r6.d(r7)     // Catch:{ d -> 0x006e }
            goto L_0x006f
        L_0x006e:
            r6 = r1
        L_0x006f:
            boolean r6 = r6 instanceof j$.time.ZoneOffset
            if (r6 == 0) goto L_0x00af
            j$.time.temporal.a r6 = j$.time.temporal.a.OFFSET_SECONDS
            boolean r7 = r10.i(r6)
            if (r7 == 0) goto L_0x00af
            int r6 = r10.a(r6)
            j$.time.zone.c r7 = r1.o()
            j$.time.Instant r8 = j$.time.Instant.f42555c
            j$.time.ZoneOffset r7 = r7.d(r8)
            int r7 = r7.r()
            if (r6 != r7) goto L_0x0090
            goto L_0x00af
        L_0x0090:
            j$.time.d r11 = new j$.time.d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Unable to apply override zone '"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = "' because the temporal object being formatted has a different offset but does not represent an instant: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r11.<init>(r10)
            throw r11
        L_0x00af:
            if (r1 == 0) goto L_0x00b2
            r3 = r1
        L_0x00b2:
            if (r0 == 0) goto L_0x0106
            j$.time.temporal.a r1 = j$.time.temporal.a.EPOCH_DAY
            boolean r1 = r10.i(r1)
            if (r1 == 0) goto L_0x00c7
            r0 = r4
            j$.time.chrono.g r0 = (j$.time.chrono.g) r0
            r0.getClass()
            j$.time.LocalDate r5 = j$.time.LocalDate.o(r10)
            goto L_0x0106
        L_0x00c7:
            j$.time.chrono.g r1 = j$.time.chrono.g.f42585a
            if (r0 != r1) goto L_0x00cd
            if (r2 == 0) goto L_0x0106
        L_0x00cd:
            j$.time.temporal.a[] r1 = j$.time.temporal.a.values()
            int r2 = r1.length
            r6 = 0
        L_0x00d3:
            if (r6 >= r2) goto L_0x0106
            r7 = r1[r6]
            boolean r8 = r7.isDateBased()
            if (r8 == 0) goto L_0x0103
            boolean r7 = r10.i(r7)
            if (r7 != 0) goto L_0x00e4
            goto L_0x0103
        L_0x00e4:
            j$.time.d r11 = new j$.time.d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to apply override chronology '"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = "' because the temporal object being formatted contains date fields but does not represent a whole date: "
            r1.append(r0)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r11.<init>(r10)
            throw r11
        L_0x0103:
            int r6 = r6 + 1
            goto L_0x00d3
        L_0x0106:
            j$.time.format.z r0 = new j$.time.format.z
            r0.<init>(r5, r10, r4, r3)
            r10 = r0
        L_0x010c:
            r9.f42591a = r10
            r9.f42592b = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.A.<init>(j$.time.temporal.TemporalAccessor, j$.time.format.DateTimeFormatter):void");
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f42593c--;
    }

    /* access modifiers changed from: package-private */
    public final D b() {
        return this.f42592b.c();
    }

    /* access modifiers changed from: package-private */
    public final Locale c() {
        return this.f42592b.d();
    }

    /* access modifiers changed from: package-private */
    public final TemporalAccessor d() {
        return this.f42591a;
    }

    /* access modifiers changed from: package-private */
    public final Long e(m mVar) {
        try {
            return Long.valueOf(this.f42591a.j(mVar));
        } catch (d e10) {
            if (this.f42593c > 0) {
                return null;
            }
            throw e10;
        }
    }

    /* access modifiers changed from: package-private */
    public final Object f(p pVar) {
        Object k10 = this.f42591a.k(pVar);
        if (k10 != null || this.f42593c != 0) {
            return k10;
        }
        StringBuilder a10 = a.a("Unable to extract value: ");
        a10.append(this.f42591a.getClass());
        throw new d(a10.toString());
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        this.f42593c++;
    }

    public final String toString() {
        return this.f42591a.toString();
    }
}
