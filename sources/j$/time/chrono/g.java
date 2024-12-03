package j$.time.chrono;

import java.io.Serializable;

public final class g extends a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final g f42585a = new g();

    private g() {
    }

    public static boolean e(long j10) {
        return (3 & j10) == 0 && (j10 % 100 != 0 || j10 % 400 == 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0089, code lost:
        if (r2 > 0) goto L_0x00a8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.LocalDate f(java.util.HashMap r20, j$.time.format.F r21) {
        /*
            r19 = this;
            r0 = r20
            r1 = r21
            j$.time.temporal.a r2 = j$.time.temporal.a.EPOCH_DAY
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L_0x001c
            java.lang.Object r0 = r0.remove(r2)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            j$.time.LocalDate r0 = j$.time.LocalDate.x(r0)
            goto L_0x04b3
        L_0x001c:
            j$.time.temporal.a r2 = j$.time.temporal.a.PROLEPTIC_MONTH
            java.lang.Object r3 = r0.remove(r2)
            java.lang.Long r3 = (java.lang.Long) r3
            r4 = 1
            if (r3 == 0) goto L_0x0050
            j$.time.format.F r6 = j$.time.format.F.LENIENT
            if (r1 == r6) goto L_0x0033
            long r6 = r3.longValue()
            r2.k(r6)
        L_0x0033:
            j$.time.temporal.a r2 = j$.time.temporal.a.MONTH_OF_YEAR
            long r6 = r3.longValue()
            r8 = 12
            long r6 = java.lang.Math.floorMod(r6, r8)
            long r6 = r6 + r4
            j$.time.chrono.a.b(r0, r2, r6)
            j$.time.temporal.a r2 = j$.time.temporal.a.YEAR
            long r6 = r3.longValue()
            long r6 = java.lang.Math.floorDiv(r6, r8)
            j$.time.chrono.a.b(r0, r2, r6)
        L_0x0050:
            j$.time.temporal.a r2 = j$.time.temporal.a.YEAR_OF_ERA
            java.lang.Object r3 = r0.remove(r2)
            java.lang.Long r3 = (java.lang.Long) r3
            r6 = 0
            if (r3 == 0) goto L_0x00e8
            j$.time.format.F r8 = j$.time.format.F.LENIENT
            if (r1 == r8) goto L_0x0067
            long r8 = r3.longValue()
            r2.k(r8)
        L_0x0067:
            j$.time.temporal.a r8 = j$.time.temporal.a.ERA
            java.lang.Object r8 = r0.remove(r8)
            java.lang.Long r8 = (java.lang.Long) r8
            if (r8 != 0) goto L_0x00ac
            j$.time.temporal.a r8 = j$.time.temporal.a.YEAR
            java.lang.Object r9 = r0.get(r8)
            java.lang.Long r9 = (java.lang.Long) r9
            j$.time.format.F r10 = j$.time.format.F.STRICT
            if (r1 != r10) goto L_0x0090
            if (r9 == 0) goto L_0x008c
            long r9 = r9.longValue()
            int r2 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            long r9 = r3.longValue()
            if (r2 <= 0) goto L_0x009f
            goto L_0x00a8
        L_0x008c:
            r0.put(r2, r3)
            goto L_0x00fd
        L_0x0090:
            if (r9 == 0) goto L_0x00a4
            long r9 = r9.longValue()
            int r2 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x009b
            goto L_0x00a4
        L_0x009b:
            long r9 = r3.longValue()
        L_0x009f:
            long r9 = java.lang.Math.subtractExact(r4, r9)
            goto L_0x00a8
        L_0x00a4:
            long r9 = r3.longValue()
        L_0x00a8:
            j$.time.chrono.a.b(r0, r8, r9)
            goto L_0x00fd
        L_0x00ac:
            long r9 = r8.longValue()
            int r2 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x00bb
            j$.time.temporal.a r2 = j$.time.temporal.a.YEAR
            long r8 = r3.longValue()
            goto L_0x00cd
        L_0x00bb:
            long r9 = r8.longValue()
            int r2 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x00d1
            j$.time.temporal.a r2 = j$.time.temporal.a.YEAR
            long r8 = r3.longValue()
            long r8 = java.lang.Math.subtractExact(r4, r8)
        L_0x00cd:
            j$.time.chrono.a.b(r0, r2, r8)
            goto L_0x00fd
        L_0x00d1:
            j$.time.d r0 = new j$.time.d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid value for era: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00e8:
            j$.time.temporal.a r2 = j$.time.temporal.a.ERA
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L_0x00fd
            java.lang.Object r3 = r0.get(r2)
            java.lang.Long r3 = (java.lang.Long) r3
            long r8 = r3.longValue()
            r2.k(r8)
        L_0x00fd:
            j$.time.temporal.a r2 = j$.time.temporal.a.YEAR
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L_0x04b2
            j$.time.temporal.a r3 = j$.time.temporal.a.MONTH_OF_YEAR
            boolean r8 = r0.containsKey(r3)
            r9 = 1
            if (r8 == 0) goto L_0x032d
            j$.time.temporal.a r8 = j$.time.temporal.a.DAY_OF_MONTH
            boolean r10 = r0.containsKey(r8)
            if (r10 == 0) goto L_0x01b2
            java.lang.Object r10 = r0.remove(r2)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            int r2 = r2.j(r10)
            j$.time.format.F r10 = j$.time.format.F.LENIENT
            if (r1 != r10) goto L_0x0152
            java.lang.Object r1 = r0.remove(r3)
            java.lang.Long r1 = (java.lang.Long) r1
            long r6 = r1.longValue()
            long r6 = java.lang.Math.subtractExact(r6, r4)
            java.lang.Object r0 = r0.remove(r8)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r0 = java.lang.Math.subtractExact(r0, r4)
            j$.time.LocalDate r2 = j$.time.LocalDate.w(r2, r9, r9)
            j$.time.LocalDate r2 = r2.B(r6)
            j$.time.LocalDate r0 = r2.A(r0)
            goto L_0x04b3
        L_0x0152:
            java.lang.Object r4 = r0.remove(r3)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r3 = r3.j(r4)
            java.lang.Object r0 = r0.remove(r8)
            java.lang.Long r0 = (java.lang.Long) r0
            long r4 = r0.longValue()
            int r0 = r8.j(r4)
            j$.time.format.F r4 = j$.time.format.F.SMART
            if (r1 != r4) goto L_0x01ac
            r1 = 4
            if (r3 == r1) goto L_0x01a6
            r1 = 6
            if (r3 == r1) goto L_0x01a6
            r1 = 9
            if (r3 == r1) goto L_0x01a6
            r1 = 11
            if (r3 != r1) goto L_0x0181
            goto L_0x01a6
        L_0x0181:
            r1 = 2
            if (r3 != r1) goto L_0x01ac
            j$.time.n r1 = j$.time.n.FEBRUARY
            long r4 = (long) r2
            int r8 = j$.time.p.f42718a
            r10 = 3
            long r10 = r10 & r4
            int r8 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x01a0
            r10 = 100
            long r10 = r4 % r10
            int r8 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x01a1
            r10 = 400(0x190, double:1.976E-321)
            long r4 = r4 % r10
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x01a0
            goto L_0x01a1
        L_0x01a0:
            r9 = 0
        L_0x01a1:
            int r1 = r1.n(r9)
            goto L_0x01a8
        L_0x01a6:
            r1 = 30
        L_0x01a8:
            int r0 = java.lang.Math.min(r0, r1)
        L_0x01ac:
            j$.time.LocalDate r0 = j$.time.LocalDate.w(r2, r3, r0)
            goto L_0x04b3
        L_0x01b2:
            j$.time.temporal.a r6 = j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH
            boolean r7 = r0.containsKey(r6)
            if (r7 == 0) goto L_0x032d
            j$.time.temporal.a r7 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH
            boolean r8 = r0.containsKey(r7)
            java.lang.String r10 = "Strict mode rejected resolved date as it is in a different month"
            if (r8 == 0) goto L_0x0274
            j$.time.temporal.s r8 = r2.e()
            java.lang.Object r11 = r0.remove(r2)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            int r2 = r8.a(r11, r2)
            j$.time.format.F r8 = j$.time.format.F.LENIENT
            if (r1 != r8) goto L_0x021c
            java.lang.Object r1 = r0.remove(r3)
            java.lang.Long r1 = (java.lang.Long) r1
            long r10 = r1.longValue()
            long r10 = java.lang.Math.subtractExact(r10, r4)
            java.lang.Object r1 = r0.remove(r6)
            java.lang.Long r1 = (java.lang.Long) r1
            long r12 = r1.longValue()
            long r12 = java.lang.Math.subtractExact(r12, r4)
            java.lang.Object r0 = r0.remove(r7)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r0 = java.lang.Math.subtractExact(r0, r4)
            j$.time.LocalDate r2 = j$.time.LocalDate.w(r2, r9, r9)
            j$.time.temporal.b r3 = j$.time.temporal.b.MONTHS
            j$.time.LocalDate r2 = r2.f(r10, r3)
            j$.time.temporal.b r3 = j$.time.temporal.b.WEEKS
            j$.time.LocalDate r2 = r2.f(r12, r3)
            j$.time.temporal.b r3 = j$.time.temporal.b.DAYS
            j$.time.LocalDate r0 = r2.f(r0, r3)
            goto L_0x04b3
        L_0x021c:
            j$.time.temporal.s r4 = r3.e()
            java.lang.Object r5 = r0.remove(r3)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            int r4 = r4.a(r11, r3)
            j$.time.temporal.s r5 = r6.e()
            java.lang.Object r8 = r0.remove(r6)
            java.lang.Long r8 = (java.lang.Long) r8
            long r11 = r8.longValue()
            int r5 = r5.a(r11, r6)
            j$.time.temporal.s r6 = r7.e()
            java.lang.Object r0 = r0.remove(r7)
            java.lang.Long r0 = (java.lang.Long) r0
            long r11 = r0.longValue()
            int r0 = r6.a(r11, r7)
            j$.time.LocalDate r2 = j$.time.LocalDate.w(r2, r4, r9)
            int r5 = r5 - r9
            int r5 = r5 * 7
            int r0 = r0 - r9
            int r0 = r0 + r5
            long r5 = (long) r0
            j$.time.temporal.b r0 = j$.time.temporal.b.DAYS
            j$.time.LocalDate r0 = r2.f(r5, r0)
            j$.time.format.F r2 = j$.time.format.F.STRICT
            if (r1 != r2) goto L_0x04b3
            int r1 = r0.a(r3)
            if (r1 != r4) goto L_0x026e
            goto L_0x04b3
        L_0x026e:
            j$.time.d r0 = new j$.time.d
            r0.<init>(r10)
            throw r0
        L_0x0274:
            j$.time.temporal.a r7 = j$.time.temporal.a.DAY_OF_WEEK
            boolean r8 = r0.containsKey(r7)
            if (r8 == 0) goto L_0x032d
            j$.time.temporal.s r8 = r2.e()
            java.lang.Object r11 = r0.remove(r2)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            int r2 = r8.a(r11, r2)
            j$.time.format.F r8 = j$.time.format.F.LENIENT
            if (r1 != r8) goto L_0x02c6
            java.lang.Object r1 = r0.remove(r3)
            java.lang.Long r1 = (java.lang.Long) r1
            long r10 = r1.longValue()
            long r13 = java.lang.Math.subtractExact(r10, r4)
            java.lang.Object r1 = r0.remove(r6)
            java.lang.Long r1 = (java.lang.Long) r1
            long r10 = r1.longValue()
            long r15 = java.lang.Math.subtractExact(r10, r4)
            java.lang.Object r0 = r0.remove(r7)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r17 = java.lang.Math.subtractExact(r0, r4)
            j$.time.LocalDate r12 = j$.time.LocalDate.w(r2, r9, r9)
            j$.time.LocalDate r0 = j$.time.chrono.a.d(r12, r13, r15, r17)
            goto L_0x04b3
        L_0x02c6:
            j$.time.temporal.s r4 = r3.e()
            java.lang.Object r5 = r0.remove(r3)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            int r4 = r4.a(r11, r3)
            j$.time.temporal.s r5 = r6.e()
            java.lang.Object r8 = r0.remove(r6)
            java.lang.Long r8 = (java.lang.Long) r8
            long r11 = r8.longValue()
            int r5 = r5.a(r11, r6)
            j$.time.temporal.s r6 = r7.e()
            java.lang.Object r0 = r0.remove(r7)
            java.lang.Long r0 = (java.lang.Long) r0
            long r11 = r0.longValue()
            int r0 = r6.a(r11, r7)
            j$.time.LocalDate r2 = j$.time.LocalDate.w(r2, r4, r9)
            int r5 = r5 - r9
            int r5 = r5 * 7
            long r5 = (long) r5
            j$.time.temporal.b r7 = j$.time.temporal.b.DAYS
            j$.time.LocalDate r2 = r2.f(r5, r7)
            j$.time.e r0 = j$.time.e.n(r0)
            int r0 = r0.m()
            j$.time.temporal.n r5 = new j$.time.temporal.n
            r5.<init>(r0)
            j$.time.LocalDate r0 = r2.d(r5)
            j$.time.format.F r2 = j$.time.format.F.STRICT
            if (r1 != r2) goto L_0x04b3
            int r1 = r0.a(r3)
            if (r1 != r4) goto L_0x0327
            goto L_0x04b3
        L_0x0327:
            j$.time.d r0 = new j$.time.d
            r0.<init>(r10)
            throw r0
        L_0x032d:
            j$.time.temporal.a r3 = j$.time.temporal.a.DAY_OF_YEAR
            boolean r6 = r0.containsKey(r3)
            if (r6 == 0) goto L_0x037d
            j$.time.temporal.s r6 = r2.e()
            java.lang.Object r7 = r0.remove(r2)
            java.lang.Long r7 = (java.lang.Long) r7
            long r7 = r7.longValue()
            int r2 = r6.a(r7, r2)
            j$.time.format.F r6 = j$.time.format.F.LENIENT
            if (r1 != r6) goto L_0x0365
            java.lang.Object r0 = r0.remove(r3)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r0 = java.lang.Math.subtractExact(r0, r4)
            j$.time.LocalDate r2 = j$.time.LocalDate.y(r2, r9)
            j$.time.temporal.b r3 = j$.time.temporal.b.DAYS
            j$.time.LocalDate r0 = r2.f(r0, r3)
            goto L_0x04b3
        L_0x0365:
            j$.time.temporal.s r1 = r3.e()
            java.lang.Object r0 = r0.remove(r3)
            java.lang.Long r0 = (java.lang.Long) r0
            long r4 = r0.longValue()
            int r0 = r1.a(r4, r3)
            j$.time.LocalDate r0 = j$.time.LocalDate.y(r2, r0)
            goto L_0x04b3
        L_0x037d:
            j$.time.temporal.a r3 = j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR
            boolean r6 = r0.containsKey(r3)
            if (r6 == 0) goto L_0x04b2
            j$.time.temporal.a r6 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR
            boolean r7 = r0.containsKey(r6)
            java.lang.String r8 = "Strict mode rejected resolved date as it is in a different year"
            if (r7 == 0) goto L_0x0419
            j$.time.temporal.s r7 = r2.e()
            java.lang.Object r10 = r0.remove(r2)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            int r7 = r7.a(r10, r2)
            j$.time.format.F r10 = j$.time.format.F.LENIENT
            if (r1 != r10) goto L_0x03d3
            java.lang.Object r1 = r0.remove(r3)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r1 = java.lang.Math.subtractExact(r1, r4)
            java.lang.Object r0 = r0.remove(r6)
            java.lang.Long r0 = (java.lang.Long) r0
            long r10 = r0.longValue()
            long r3 = java.lang.Math.subtractExact(r10, r4)
            j$.time.LocalDate r0 = j$.time.LocalDate.y(r7, r9)
            j$.time.temporal.b r5 = j$.time.temporal.b.WEEKS
            j$.time.LocalDate r0 = r0.f(r1, r5)
            j$.time.temporal.b r1 = j$.time.temporal.b.DAYS
            j$.time.LocalDate r0 = r0.f(r3, r1)
            goto L_0x04b3
        L_0x03d3:
            j$.time.temporal.s r4 = r3.e()
            java.lang.Object r5 = r0.remove(r3)
            java.lang.Long r5 = (java.lang.Long) r5
            long r10 = r5.longValue()
            int r3 = r4.a(r10, r3)
            j$.time.temporal.s r4 = r6.e()
            java.lang.Object r0 = r0.remove(r6)
            java.lang.Long r0 = (java.lang.Long) r0
            long r10 = r0.longValue()
            int r0 = r4.a(r10, r6)
            j$.time.LocalDate r4 = j$.time.LocalDate.y(r7, r9)
            int r3 = r3 - r9
            int r3 = r3 * 7
            int r0 = r0 - r9
            int r0 = r0 + r3
            long r5 = (long) r0
            j$.time.temporal.b r0 = j$.time.temporal.b.DAYS
            j$.time.LocalDate r0 = r4.f(r5, r0)
            j$.time.format.F r3 = j$.time.format.F.STRICT
            if (r1 != r3) goto L_0x04b3
            int r1 = r0.a(r2)
            if (r1 != r7) goto L_0x0413
            goto L_0x04b3
        L_0x0413:
            j$.time.d r0 = new j$.time.d
            r0.<init>(r8)
            throw r0
        L_0x0419:
            j$.time.temporal.a r6 = j$.time.temporal.a.DAY_OF_WEEK
            boolean r7 = r0.containsKey(r6)
            if (r7 == 0) goto L_0x04b2
            j$.time.temporal.s r7 = r2.e()
            java.lang.Object r10 = r0.remove(r2)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            int r7 = r7.a(r10, r2)
            j$.time.format.F r10 = j$.time.format.F.LENIENT
            if (r1 != r10) goto L_0x045e
            java.lang.Object r1 = r0.remove(r3)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r13 = java.lang.Math.subtractExact(r1, r4)
            java.lang.Object r0 = r0.remove(r6)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r15 = java.lang.Math.subtractExact(r0, r4)
            j$.time.LocalDate r10 = j$.time.LocalDate.y(r7, r9)
            r11 = 0
            j$.time.LocalDate r0 = j$.time.chrono.a.d(r10, r11, r13, r15)
            goto L_0x04b3
        L_0x045e:
            j$.time.temporal.s r4 = r3.e()
            java.lang.Object r5 = r0.remove(r3)
            java.lang.Long r5 = (java.lang.Long) r5
            long r10 = r5.longValue()
            int r3 = r4.a(r10, r3)
            j$.time.temporal.s r4 = r6.e()
            java.lang.Object r0 = r0.remove(r6)
            java.lang.Long r0 = (java.lang.Long) r0
            long r10 = r0.longValue()
            int r0 = r4.a(r10, r6)
            j$.time.LocalDate r4 = j$.time.LocalDate.y(r7, r9)
            int r3 = r3 - r9
            int r3 = r3 * 7
            long r5 = (long) r3
            j$.time.temporal.b r3 = j$.time.temporal.b.DAYS
            j$.time.LocalDate r3 = r4.f(r5, r3)
            j$.time.e r0 = j$.time.e.n(r0)
            int r0 = r0.m()
            j$.time.temporal.n r4 = new j$.time.temporal.n
            r4.<init>(r0)
            j$.time.LocalDate r0 = r3.d(r4)
            j$.time.format.F r3 = j$.time.format.F.STRICT
            if (r1 != r3) goto L_0x04b3
            int r1 = r0.a(r2)
            if (r1 != r7) goto L_0x04ac
            goto L_0x04b3
        L_0x04ac:
            j$.time.d r0 = new j$.time.d
            r0.<init>(r8)
            throw r0
        L_0x04b2:
            r0 = 0
        L_0x04b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.g.f(java.util.HashMap, j$.time.format.F):j$.time.LocalDate");
    }
}
