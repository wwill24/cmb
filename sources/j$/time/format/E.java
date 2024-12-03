package j$.time.format;

import com.coffeemeetsbagel.models.util.DateUtils;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.Period;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import j$.time.chrono.b;
import j$.time.chrono.f;
import j$.time.chrono.g;
import j$.time.d;
import j$.time.l;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.p;
import j$.time.temporal.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.jivesoftware.smackx.xdata.FormField;

final class E implements TemporalAccessor {

    /* renamed from: a  reason: collision with root package name */
    final HashMap f42608a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    ZoneId f42609b;

    /* renamed from: c  reason: collision with root package name */
    f f42610c;

    /* renamed from: d  reason: collision with root package name */
    private F f42611d;

    /* renamed from: e  reason: collision with root package name */
    private b f42612e;

    /* renamed from: f  reason: collision with root package name */
    private l f42613f;

    /* renamed from: g  reason: collision with root package name */
    Period f42614g = Period.f42569d;

    E() {
    }

    private void c(TemporalAccessor temporalAccessor) {
        Iterator it = this.f42608a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            m mVar = (m) entry.getKey();
            if (temporalAccessor.i(mVar)) {
                try {
                    long j10 = temporalAccessor.j(mVar);
                    long longValue = ((Long) entry.getValue()).longValue();
                    if (j10 == longValue) {
                        it.remove();
                    } else {
                        throw new d("Conflict found: Field " + mVar + " " + j10 + " differs from " + mVar + " " + longValue + " derived from " + temporalAccessor);
                    }
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    private void m() {
        if (this.f42608a.containsKey(a.INSTANT_SECONDS)) {
            ZoneId zoneId = this.f42609b;
            if (zoneId == null) {
                Long l10 = (Long) this.f42608a.get(a.OFFSET_SECONDS);
                if (l10 != null) {
                    zoneId = ZoneOffset.u(l10.intValue());
                } else {
                    return;
                }
            }
            n(zoneId);
        }
    }

    private void n(ZoneId zoneId) {
        HashMap hashMap = this.f42608a;
        a aVar = a.INSTANT_SECONDS;
        Instant o10 = Instant.o(((Long) hashMap.remove(aVar)).longValue());
        ((g) this.f42610c).getClass();
        ZonedDateTime p10 = ZonedDateTime.p(o10, zoneId);
        r(p10.s());
        s(aVar, a.SECOND_OF_DAY, Long.valueOf((long) p10.v().A()));
    }

    private void o(long j10, long j11, long j12, long j13) {
        l t10;
        Period period;
        if (this.f42611d == F.LENIENT) {
            long addExact = Math.addExact(Math.addExact(Math.addExact(Math.multiplyExact(j10, 3600000000000L), Math.multiplyExact(j11, 60000000000L)), Math.multiplyExact(j12, 1000000000)), j13);
            t10 = l.u(Math.floorMod(addExact, 86400000000000L));
            period = Period.d((int) Math.floorDiv(addExact, 86400000000000L));
        } else {
            int j14 = a.MINUTE_OF_HOUR.j(j11);
            int j15 = a.NANO_OF_SECOND.j(j13);
            if (this.f42611d == F.SMART && j10 == 24 && j14 == 0 && j12 == 0 && j15 == 0) {
                t10 = l.f42708g;
                period = Period.d(1);
            } else {
                t10 = l.t(a.HOUR_OF_DAY.j(j10), j14, a.SECOND_OF_MINUTE.j(j12), j15);
                period = Period.f42569d;
            }
        }
        q(t10, period);
    }

    private void p() {
        Long l10;
        a aVar;
        HashMap hashMap = this.f42608a;
        a aVar2 = a.CLOCK_HOUR_OF_DAY;
        long j10 = 0;
        if (hashMap.containsKey(aVar2)) {
            long longValue = ((Long) this.f42608a.remove(aVar2)).longValue();
            F f10 = this.f42611d;
            if (f10 == F.STRICT || (f10 == F.SMART && longValue != 0)) {
                aVar2.k(longValue);
            }
            a aVar3 = a.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            s(aVar2, aVar3, Long.valueOf(longValue));
        }
        HashMap hashMap2 = this.f42608a;
        a aVar4 = a.CLOCK_HOUR_OF_AMPM;
        if (hashMap2.containsKey(aVar4)) {
            long longValue2 = ((Long) this.f42608a.remove(aVar4)).longValue();
            F f11 = this.f42611d;
            if (f11 == F.STRICT || (f11 == F.SMART && longValue2 != 0)) {
                aVar4.k(longValue2);
            }
            a aVar5 = a.HOUR_OF_AMPM;
            if (longValue2 != 12) {
                j10 = longValue2;
            }
            s(aVar4, aVar5, Long.valueOf(j10));
        }
        HashMap hashMap3 = this.f42608a;
        a aVar6 = a.AMPM_OF_DAY;
        if (hashMap3.containsKey(aVar6)) {
            HashMap hashMap4 = this.f42608a;
            a aVar7 = a.HOUR_OF_AMPM;
            if (hashMap4.containsKey(aVar7)) {
                long longValue3 = ((Long) this.f42608a.remove(aVar6)).longValue();
                long longValue4 = ((Long) this.f42608a.remove(aVar7)).longValue();
                if (this.f42611d == F.LENIENT) {
                    aVar = a.HOUR_OF_DAY;
                    l10 = Long.valueOf(Math.addExact(Math.multiplyExact(longValue3, 12), longValue4));
                } else {
                    aVar6.k(longValue3);
                    aVar7.k(longValue3);
                    aVar = a.HOUR_OF_DAY;
                    l10 = Long.valueOf((longValue3 * 12) + longValue4);
                }
                s(aVar6, aVar, l10);
            }
        }
        HashMap hashMap5 = this.f42608a;
        a aVar8 = a.NANO_OF_DAY;
        if (hashMap5.containsKey(aVar8)) {
            long longValue5 = ((Long) this.f42608a.remove(aVar8)).longValue();
            if (this.f42611d != F.LENIENT) {
                aVar8.k(longValue5);
            }
            s(aVar8, a.HOUR_OF_DAY, Long.valueOf(longValue5 / 3600000000000L));
            s(aVar8, a.MINUTE_OF_HOUR, Long.valueOf((longValue5 / 60000000000L) % 60));
            s(aVar8, a.SECOND_OF_MINUTE, Long.valueOf((longValue5 / 1000000000) % 60));
            s(aVar8, a.NANO_OF_SECOND, Long.valueOf(longValue5 % 1000000000));
        }
        HashMap hashMap6 = this.f42608a;
        a aVar9 = a.MICRO_OF_DAY;
        if (hashMap6.containsKey(aVar9)) {
            long longValue6 = ((Long) this.f42608a.remove(aVar9)).longValue();
            if (this.f42611d != F.LENIENT) {
                aVar9.k(longValue6);
            }
            s(aVar9, a.SECOND_OF_DAY, Long.valueOf(longValue6 / 1000000));
            s(aVar9, a.MICRO_OF_SECOND, Long.valueOf(longValue6 % 1000000));
        }
        HashMap hashMap7 = this.f42608a;
        a aVar10 = a.MILLI_OF_DAY;
        if (hashMap7.containsKey(aVar10)) {
            long longValue7 = ((Long) this.f42608a.remove(aVar10)).longValue();
            if (this.f42611d != F.LENIENT) {
                aVar10.k(longValue7);
            }
            s(aVar10, a.SECOND_OF_DAY, Long.valueOf(longValue7 / 1000));
            s(aVar10, a.MILLI_OF_SECOND, Long.valueOf(longValue7 % 1000));
        }
        HashMap hashMap8 = this.f42608a;
        a aVar11 = a.SECOND_OF_DAY;
        if (hashMap8.containsKey(aVar11)) {
            long longValue8 = ((Long) this.f42608a.remove(aVar11)).longValue();
            if (this.f42611d != F.LENIENT) {
                aVar11.k(longValue8);
            }
            s(aVar11, a.HOUR_OF_DAY, Long.valueOf(longValue8 / DateUtils.SEC_IN_HOUR));
            s(aVar11, a.MINUTE_OF_HOUR, Long.valueOf((longValue8 / 60) % 60));
            s(aVar11, a.SECOND_OF_MINUTE, Long.valueOf(longValue8 % 60));
        }
        HashMap hashMap9 = this.f42608a;
        a aVar12 = a.MINUTE_OF_DAY;
        if (hashMap9.containsKey(aVar12)) {
            long longValue9 = ((Long) this.f42608a.remove(aVar12)).longValue();
            if (this.f42611d != F.LENIENT) {
                aVar12.k(longValue9);
            }
            s(aVar12, a.HOUR_OF_DAY, Long.valueOf(longValue9 / 60));
            s(aVar12, a.MINUTE_OF_HOUR, Long.valueOf(longValue9 % 60));
        }
        HashMap hashMap10 = this.f42608a;
        a aVar13 = a.NANO_OF_SECOND;
        if (hashMap10.containsKey(aVar13)) {
            long longValue10 = ((Long) this.f42608a.get(aVar13)).longValue();
            F f12 = this.f42611d;
            F f13 = F.LENIENT;
            if (f12 != f13) {
                aVar13.k(longValue10);
            }
            HashMap hashMap11 = this.f42608a;
            a aVar14 = a.MICRO_OF_SECOND;
            if (hashMap11.containsKey(aVar14)) {
                long longValue11 = ((Long) this.f42608a.remove(aVar14)).longValue();
                if (this.f42611d != f13) {
                    aVar14.k(longValue11);
                }
                longValue10 = (longValue10 % 1000) + (longValue11 * 1000);
                s(aVar14, aVar13, Long.valueOf(longValue10));
            }
            HashMap hashMap12 = this.f42608a;
            a aVar15 = a.MILLI_OF_SECOND;
            if (hashMap12.containsKey(aVar15)) {
                long longValue12 = ((Long) this.f42608a.remove(aVar15)).longValue();
                if (this.f42611d != f13) {
                    aVar15.k(longValue12);
                }
                s(aVar15, aVar13, Long.valueOf((longValue10 % 1000000) + (longValue12 * 1000000)));
            }
        }
        HashMap hashMap13 = this.f42608a;
        a aVar16 = a.HOUR_OF_DAY;
        if (hashMap13.containsKey(aVar16)) {
            HashMap hashMap14 = this.f42608a;
            a aVar17 = a.MINUTE_OF_HOUR;
            if (hashMap14.containsKey(aVar17)) {
                HashMap hashMap15 = this.f42608a;
                a aVar18 = a.SECOND_OF_MINUTE;
                if (hashMap15.containsKey(aVar18) && this.f42608a.containsKey(aVar13)) {
                    o(((Long) this.f42608a.remove(aVar16)).longValue(), ((Long) this.f42608a.remove(aVar17)).longValue(), ((Long) this.f42608a.remove(aVar18)).longValue(), ((Long) this.f42608a.remove(aVar13)).longValue());
                }
            }
        }
    }

    private void q(l lVar, Period period) {
        l lVar2 = this.f42613f;
        if (lVar2 == null) {
            this.f42613f = lVar;
        } else if (lVar2.equals(lVar)) {
            Period period2 = this.f42614g;
            period2.getClass();
            Period period3 = Period.f42569d;
            boolean z10 = true;
            if (!(period2 == period3)) {
                if (period != period3) {
                    z10 = false;
                }
                if (!z10 && !this.f42614g.equals(period)) {
                    StringBuilder a10 = j$.time.a.a("Conflict found: Fields resolved to different excess periods: ");
                    a10.append(this.f42614g);
                    a10.append(" ");
                    a10.append(period);
                    throw new d(a10.toString());
                }
            }
        } else {
            StringBuilder a11 = j$.time.a.a("Conflict found: Fields resolved to different times: ");
            a11.append(this.f42613f);
            a11.append(" ");
            a11.append(lVar);
            throw new d(a11.toString());
        }
        this.f42614g = period;
    }

    private void r(b bVar) {
        b bVar2 = this.f42612e;
        if (bVar2 != null) {
            if (bVar != null && !bVar2.equals(bVar)) {
                StringBuilder a10 = j$.time.a.a("Conflict found: Fields resolved to two different dates: ");
                a10.append(this.f42612e);
                a10.append(" ");
                a10.append(bVar);
                throw new d(a10.toString());
            }
        } else if (bVar != null) {
            if (((j$.time.chrono.a) this.f42610c).equals(g.f42585a)) {
                this.f42612e = bVar;
                return;
            }
            StringBuilder a11 = j$.time.a.a("ChronoLocalDate must use the effective parsed chronology: ");
            a11.append(this.f42610c);
            throw new d(a11.toString());
        }
    }

    private void s(a aVar, a aVar2, Long l10) {
        Long l11 = (Long) this.f42608a.put(aVar2, l10);
        if (l11 != null && l11.longValue() != l10.longValue()) {
            throw new d("Conflict found: " + aVar2 + " " + l11 + " differs from " + aVar2 + " " + l10 + " while resolving  " + aVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0236  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(j$.time.format.F r19, java.util.Set r20) {
        /*
            r18 = this;
            r9 = r18
            r0 = r20
            if (r0 == 0) goto L_0x000f
            java.util.HashMap r1 = r9.f42608a
            java.util.Set r1 = r1.keySet()
            r1.retainAll(r0)
        L_0x000f:
            r0 = r19
            r9.f42611d = r0
            r18.m()
            j$.time.chrono.f r0 = r9.f42610c
            java.util.HashMap r1 = r9.f42608a
            j$.time.format.F r2 = r9.f42611d
            j$.time.chrono.g r0 = (j$.time.chrono.g) r0
            j$.time.LocalDate r0 = r0.f(r1, r2)
            r9.r(r0)
            r18.p()
            java.util.HashMap r0 = r9.f42608a
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00fd
            r0 = 0
        L_0x0031:
            r1 = 50
            if (r0 >= r1) goto L_0x00db
            java.util.HashMap r2 = r9.f42608a
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x003f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00db
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getKey()
            j$.time.temporal.m r3 = (j$.time.temporal.m) r3
            java.util.HashMap r4 = r9.f42608a
            j$.time.format.F r5 = r9.f42611d
            j$.time.temporal.TemporalAccessor r4 = r3.f(r4, r9, r5)
            if (r4 == 0) goto L_0x00cf
            boolean r1 = r4 instanceof j$.time.chrono.e
            if (r1 == 0) goto L_0x0098
            j$.time.chrono.e r4 = (j$.time.chrono.e) r4
            j$.time.ZoneId r1 = r9.f42609b
            if (r1 != 0) goto L_0x006f
            r1 = r4
            j$.time.ZonedDateTime r1 = (j$.time.ZonedDateTime) r1
            j$.time.ZoneId r1 = r1.o()
            r9.f42609b = r1
            goto L_0x007c
        L_0x006f:
            r2 = r4
            j$.time.ZonedDateTime r2 = (j$.time.ZonedDateTime) r2
            j$.time.ZoneId r2 = r2.o()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0083
        L_0x007c:
            j$.time.ZonedDateTime r4 = (j$.time.ZonedDateTime) r4
            j$.time.LocalDateTime r4 = r4.u()
            goto L_0x0098
        L_0x0083:
            j$.time.d r0 = new j$.time.d
            java.lang.String r1 = "ChronoZonedDateTime must use the effective parsed zone: "
            java.lang.StringBuilder r1 = j$.time.a.a(r1)
            j$.time.ZoneId r2 = r9.f42609b
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0098:
            boolean r1 = r4 instanceof j$.time.chrono.c
            if (r1 == 0) goto L_0x00b1
            j$.time.chrono.c r4 = (j$.time.chrono.c) r4
            j$.time.LocalDateTime r4 = (j$.time.LocalDateTime) r4
            j$.time.l r1 = r4.E()
            j$.time.Period r2 = j$.time.Period.f42569d
            r9.q(r1, r2)
            j$.time.chrono.b r1 = r4.D()
            r9.r(r1)
            goto L_0x00d7
        L_0x00b1:
            boolean r1 = r4 instanceof j$.time.chrono.b
            if (r1 == 0) goto L_0x00bb
            j$.time.chrono.b r4 = (j$.time.chrono.b) r4
            r9.r(r4)
            goto L_0x00d7
        L_0x00bb:
            boolean r1 = r4 instanceof j$.time.l
            if (r1 == 0) goto L_0x00c7
            j$.time.l r4 = (j$.time.l) r4
            j$.time.Period r1 = j$.time.Period.f42569d
            r9.q(r4, r1)
            goto L_0x00d7
        L_0x00c7:
            j$.time.d r0 = new j$.time.d
            java.lang.String r1 = "Method resolve() can only return ChronoZonedDateTime, ChronoLocalDateTime, ChronoLocalDate or LocalTime"
            r0.<init>(r1)
            throw r0
        L_0x00cf:
            java.util.HashMap r4 = r9.f42608a
            boolean r3 = r4.containsKey(r3)
            if (r3 != 0) goto L_0x003f
        L_0x00d7:
            int r0 = r0 + 1
            goto L_0x0031
        L_0x00db:
            if (r0 == r1) goto L_0x00f5
            if (r0 <= 0) goto L_0x00fd
            r18.m()
            j$.time.chrono.f r0 = r9.f42610c
            java.util.HashMap r1 = r9.f42608a
            j$.time.format.F r2 = r9.f42611d
            j$.time.chrono.g r0 = (j$.time.chrono.g) r0
            j$.time.LocalDate r0 = r0.f(r1, r2)
            r9.r(r0)
            r18.p()
            goto L_0x00fd
        L_0x00f5:
            j$.time.d r0 = new j$.time.d
            java.lang.String r1 = "One of the parsed fields has an incorrectly implemented resolve method"
            r0.<init>(r1)
            throw r0
        L_0x00fd:
            j$.time.l r0 = r9.f42613f
            r10 = 1000(0x3e8, double:4.94E-321)
            r1 = 1000000(0xf4240, double:4.940656E-318)
            if (r0 != 0) goto L_0x01e7
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r3 = j$.time.temporal.a.MILLI_OF_SECOND
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x014e
            java.util.HashMap r0 = r9.f42608a
            java.lang.Object r0 = r0.remove(r3)
            java.lang.Long r0 = (java.lang.Long) r0
            long r4 = r0.longValue()
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r6 = j$.time.temporal.a.MICRO_OF_SECOND
            boolean r0 = r0.containsKey(r6)
            if (r0 == 0) goto L_0x0142
            long r4 = r4 * r10
            java.util.HashMap r0 = r9.f42608a
            java.lang.Object r0 = r0.get(r6)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r0 = r0 % r10
            long r0 = r0 + r4
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            r9.s(r3, r6, r2)
            java.util.HashMap r2 = r9.f42608a
            r2.remove(r6)
            goto L_0x0164
        L_0x0142:
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r3 = j$.time.temporal.a.NANO_OF_SECOND
            long r4 = r4 * r1
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            r2 = r0
            r0 = r1
            goto L_0x016d
        L_0x014e:
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r1 = j$.time.temporal.a.MICRO_OF_SECOND
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0170
            java.util.HashMap r0 = r9.f42608a
            java.lang.Object r0 = r0.remove(r1)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
        L_0x0164:
            java.util.HashMap r2 = r9.f42608a
            j$.time.temporal.a r3 = j$.time.temporal.a.NANO_OF_SECOND
            long r0 = r0 * r10
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x016d:
            r2.put(r3, r0)
        L_0x0170:
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r12 = j$.time.temporal.a.HOUR_OF_DAY
            java.lang.Object r0 = r0.get(r12)
            java.lang.Long r0 = (java.lang.Long) r0
            if (r0 == 0) goto L_0x01e7
            java.util.HashMap r1 = r9.f42608a
            j$.time.temporal.a r13 = j$.time.temporal.a.MINUTE_OF_HOUR
            java.lang.Object r1 = r1.get(r13)
            java.lang.Long r1 = (java.lang.Long) r1
            java.util.HashMap r2 = r9.f42608a
            j$.time.temporal.a r14 = j$.time.temporal.a.SECOND_OF_MINUTE
            java.lang.Object r2 = r2.get(r14)
            java.lang.Long r2 = (java.lang.Long) r2
            java.util.HashMap r3 = r9.f42608a
            j$.time.temporal.a r15 = j$.time.temporal.a.NANO_OF_SECOND
            java.lang.Object r3 = r3.get(r15)
            java.lang.Long r3 = (java.lang.Long) r3
            if (r1 != 0) goto L_0x01a0
            if (r2 != 0) goto L_0x022b
            if (r3 != 0) goto L_0x022b
        L_0x01a0:
            if (r1 == 0) goto L_0x01a8
            if (r2 != 0) goto L_0x01a8
            if (r3 == 0) goto L_0x01a8
            goto L_0x022b
        L_0x01a8:
            if (r1 == 0) goto L_0x01af
            long r4 = r1.longValue()
            goto L_0x01b1
        L_0x01af:
            r4 = 0
        L_0x01b1:
            if (r2 == 0) goto L_0x01b8
            long r1 = r2.longValue()
            goto L_0x01ba
        L_0x01b8:
            r1 = 0
        L_0x01ba:
            r6 = r1
            if (r3 == 0) goto L_0x01c2
            long r1 = r3.longValue()
            goto L_0x01c4
        L_0x01c2:
            r1 = 0
        L_0x01c4:
            r16 = r1
            long r1 = r0.longValue()
            r0 = r18
            r3 = r4
            r5 = r6
            r7 = r16
            r0.o(r1, r3, r5, r7)
            java.util.HashMap r0 = r9.f42608a
            r0.remove(r12)
            java.util.HashMap r0 = r9.f42608a
            r0.remove(r13)
            java.util.HashMap r0 = r9.f42608a
            r0.remove(r14)
            java.util.HashMap r0 = r9.f42608a
            r0.remove(r15)
        L_0x01e7:
            j$.time.format.F r0 = r9.f42611d
            j$.time.format.F r1 = j$.time.format.F.LENIENT
            if (r0 == r1) goto L_0x022b
            java.util.HashMap r0 = r9.f42608a
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x022b
            java.util.HashMap r0 = r9.f42608a
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x01ff:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x022b
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            j$.time.temporal.m r2 = (j$.time.temporal.m) r2
            boolean r3 = r2 instanceof j$.time.temporal.a
            if (r3 == 0) goto L_0x01ff
            boolean r3 = r2.isTimeBased()
            if (r3 == 0) goto L_0x01ff
            j$.time.temporal.a r2 = (j$.time.temporal.a) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            r2.k(r3)
            goto L_0x01ff
        L_0x022b:
            j$.time.chrono.b r0 = r9.f42612e
            if (r0 == 0) goto L_0x0232
            r9.c(r0)
        L_0x0232:
            j$.time.l r0 = r9.f42613f
            if (r0 == 0) goto L_0x0255
            r9.c(r0)
            j$.time.chrono.b r0 = r9.f42612e
            if (r0 == 0) goto L_0x0255
            java.util.HashMap r0 = r9.f42608a
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0255
            j$.time.chrono.b r0 = r9.f42612e
            j$.time.l r1 = r9.f42613f
            j$.time.LocalDate r0 = (j$.time.LocalDate) r0
            r0.getClass()
            j$.time.LocalDateTime r0 = j$.time.LocalDateTime.w(r0, r1)
            r9.c(r0)
        L_0x0255:
            j$.time.chrono.b r0 = r9.f42612e
            if (r0 == 0) goto L_0x0299
            j$.time.l r0 = r9.f42613f
            if (r0 == 0) goto L_0x0299
            j$.time.Period r0 = r9.f42614g
            r0.getClass()
            j$.time.Period r1 = j$.time.Period.f42569d
            if (r0 != r1) goto L_0x0268
            r0 = 1
            goto L_0x0269
        L_0x0268:
            r0 = 0
        L_0x0269:
            if (r0 != 0) goto L_0x0299
            j$.time.chrono.b r0 = r9.f42612e
            j$.time.Period r2 = r9.f42614g
            j$.time.LocalDate r0 = (j$.time.LocalDate) r0
            r0.getClass()
            boolean r3 = r2 instanceof j$.time.Period
            if (r3 == 0) goto L_0x028a
            long r3 = r2.e()
            j$.time.LocalDate r0 = r0.B(r3)
            int r2 = r2.b()
            long r2 = (long) r2
            j$.time.LocalDate r0 = r0.A(r2)
            goto L_0x0295
        L_0x028a:
            java.lang.String r3 = "amountToAdd"
            java.util.Objects.requireNonNull(r2, r3)
            j$.time.temporal.k r0 = r2.a(r0)
            j$.time.LocalDate r0 = (j$.time.LocalDate) r0
        L_0x0295:
            r9.f42612e = r0
            r9.f42614g = r1
        L_0x0299:
            j$.time.l r0 = r9.f42613f
            if (r0 != 0) goto L_0x030f
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r1 = j$.time.temporal.a.INSTANT_SECONDS
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x02bb
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r1 = j$.time.temporal.a.SECOND_OF_DAY
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x02bb
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r1 = j$.time.temporal.a.SECOND_OF_MINUTE
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x030f
        L_0x02bb:
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r1 = j$.time.temporal.a.NANO_OF_SECOND
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x02ee
            java.util.HashMap r0 = r9.f42608a
            java.lang.Object r0 = r0.get(r1)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            java.util.HashMap r2 = r9.f42608a
            j$.time.temporal.a r3 = j$.time.temporal.a.MICRO_OF_SECOND
            long r4 = r0 / r10
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2.put(r3, r4)
            java.util.HashMap r2 = r9.f42608a
            j$.time.temporal.a r3 = j$.time.temporal.a.MILLI_OF_SECOND
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 / r4
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r2.put(r3, r0)
            goto L_0x030f
        L_0x02ee:
            java.util.HashMap r0 = r9.f42608a
            r2 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r2)
            r0.put(r1, r4)
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r1 = j$.time.temporal.a.MICRO_OF_SECOND
            java.lang.Long r4 = java.lang.Long.valueOf(r2)
            r0.put(r1, r4)
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r1 = j$.time.temporal.a.MILLI_OF_SECOND
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0.put(r1, r2)
        L_0x030f:
            j$.time.chrono.b r0 = r9.f42612e
            if (r0 == 0) goto L_0x035c
            j$.time.l r1 = r9.f42613f
            if (r1 == 0) goto L_0x035c
            j$.time.ZoneId r2 = r9.f42609b
            if (r2 == 0) goto L_0x0328
            j$.time.LocalDate r0 = (j$.time.LocalDate) r0
            j$.time.LocalDateTime r0 = j$.time.LocalDateTime.w(r0, r1)
            j$.time.ZoneId r1 = r9.f42609b
            j$.time.ZonedDateTime r0 = r0.atZone(r1)
            goto L_0x034d
        L_0x0328:
            java.util.HashMap r0 = r9.f42608a
            j$.time.temporal.a r1 = j$.time.temporal.a.OFFSET_SECONDS
            java.lang.Object r0 = r0.get(r1)
            java.lang.Long r0 = (java.lang.Long) r0
            if (r0 == 0) goto L_0x035c
            int r0 = r0.intValue()
            j$.time.ZoneOffset r0 = j$.time.ZoneOffset.u(r0)
            j$.time.chrono.b r1 = r9.f42612e
            j$.time.l r2 = r9.f42613f
            j$.time.LocalDate r1 = (j$.time.LocalDate) r1
            r1.getClass()
            j$.time.LocalDateTime r1 = j$.time.LocalDateTime.w(r1, r2)
            j$.time.ZonedDateTime r0 = r1.atZone(r0)
        L_0x034d:
            j$.time.temporal.a r1 = j$.time.temporal.a.INSTANT_SECONDS
            long r2 = r0.j(r1)
            java.util.HashMap r0 = r9.f42608a
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0.put(r1, r2)
        L_0x035c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.E.h(j$.time.format.F, java.util.Set):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r1.f42612e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        r0 = r1.f42613f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i(j$.time.temporal.m r2) {
        /*
            r1 = this;
            java.util.HashMap r0 = r1.f42608a
            boolean r0 = r0.containsKey(r2)
            if (r0 != 0) goto L_0x002e
            j$.time.chrono.b r0 = r1.f42612e
            if (r0 == 0) goto L_0x0014
            j$.time.LocalDate r0 = (j$.time.LocalDate) r0
            boolean r0 = r0.i(r2)
            if (r0 != 0) goto L_0x002e
        L_0x0014:
            j$.time.l r0 = r1.f42613f
            if (r0 == 0) goto L_0x001f
            boolean r0 = r0.i(r2)
            if (r0 == 0) goto L_0x001f
            goto L_0x002e
        L_0x001f:
            if (r2 == 0) goto L_0x002c
            boolean r0 = r2 instanceof j$.time.temporal.a
            if (r0 != 0) goto L_0x002c
            boolean r2 = r2.b(r1)
            if (r2 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r2 = 0
            goto L_0x002f
        L_0x002e:
            r2 = 1
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.E.i(j$.time.temporal.m):boolean");
    }

    public final long j(m mVar) {
        Objects.requireNonNull(mVar, FormField.ELEMENT);
        Long l10 = (Long) this.f42608a.get(mVar);
        if (l10 != null) {
            return l10.longValue();
        }
        b bVar = this.f42612e;
        if (bVar != null && ((LocalDate) bVar).i(mVar)) {
            return ((LocalDate) this.f42612e).j(mVar);
        }
        l lVar = this.f42613f;
        if (lVar != null && lVar.i(mVar)) {
            return this.f42613f.j(mVar);
        }
        if (!(mVar instanceof a)) {
            return mVar.h(this);
        }
        throw new r("Unsupported field: " + mVar);
    }

    public final Object k(p pVar) {
        if (pVar == o.g()) {
            return this.f42609b;
        }
        if (pVar == o.a()) {
            return this.f42610c;
        }
        if (pVar == o.b()) {
            b bVar = this.f42612e;
            if (bVar != null) {
                return LocalDate.o(bVar);
            }
            return null;
        } else if (pVar == o.c()) {
            return this.f42613f;
        } else {
            if (pVar == o.f() || pVar == o.d()) {
                return pVar.a(this);
            }
            if (pVar == o.e()) {
                return null;
            }
            return pVar.a(this);
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append(this.f42608a);
        sb2.append(',');
        sb2.append(this.f42610c);
        if (this.f42609b != null) {
            sb2.append(',');
            sb2.append(this.f42609b);
        }
        if (!(this.f42612e == null && this.f42613f == null)) {
            sb2.append(" resolved to ");
            b bVar = this.f42612e;
            if (bVar != null) {
                sb2.append(bVar);
                if (this.f42613f != null) {
                    sb2.append('T');
                }
            }
            sb2.append(this.f42613f);
        }
        return sb2.toString();
    }
}
