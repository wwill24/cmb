package j$.time.temporal;

import j$.time.LocalDate;
import j$.time.a;
import j$.time.chrono.f;
import j$.time.chrono.g;
import j$.time.d;
import j$.time.format.F;
import java.util.HashMap;

final class t implements m {

    /* renamed from: f  reason: collision with root package name */
    private static final s f42748f = s.i(1, 7);

    /* renamed from: g  reason: collision with root package name */
    private static final s f42749g = s.j(0, 4, 6);

    /* renamed from: h  reason: collision with root package name */
    private static final s f42750h = s.j(0, 52, 54);

    /* renamed from: i  reason: collision with root package name */
    private static final s f42751i = s.k(52, 53);

    /* renamed from: a  reason: collision with root package name */
    private final String f42752a;

    /* renamed from: b  reason: collision with root package name */
    private final u f42753b;

    /* renamed from: c  reason: collision with root package name */
    private final q f42754c;

    /* renamed from: d  reason: collision with root package name */
    private final q f42755d;

    /* renamed from: e  reason: collision with root package name */
    private final s f42756e;

    private t(String str, u uVar, q qVar, q qVar2, s sVar) {
        this.f42752a = str;
        this.f42753b = uVar;
        this.f42754c = qVar;
        this.f42755d = qVar2;
        this.f42756e = sVar;
    }

    private static int a(int i10, int i11) {
        return ((i11 - 1) + (i10 + 7)) / 7;
    }

    private int c(TemporalAccessor temporalAccessor) {
        return Math.floorMod(temporalAccessor.a(a.DAY_OF_WEEK) - this.f42753b.e().m(), 7) + 1;
    }

    private int g(TemporalAccessor temporalAccessor) {
        int c10 = c(temporalAccessor);
        int a10 = temporalAccessor.a(a.YEAR);
        a aVar = a.DAY_OF_YEAR;
        int a11 = temporalAccessor.a(aVar);
        int t10 = t(a11, c10);
        int a12 = a(t10, a11);
        if (a12 == 0) {
            return a10 - 1;
        }
        return a12 >= a(t10, this.f42753b.f() + ((int) temporalAccessor.e(aVar).d())) ? a10 + 1 : a10;
    }

    private long j(TemporalAccessor temporalAccessor) {
        int c10 = c(temporalAccessor);
        int a10 = temporalAccessor.a(a.DAY_OF_MONTH);
        return (long) a(t(a10, c10), a10);
    }

    private int k(TemporalAccessor temporalAccessor) {
        long j10;
        int c10 = c(temporalAccessor);
        a aVar = a.DAY_OF_YEAR;
        int a10 = temporalAccessor.a(aVar);
        int t10 = t(a10, c10);
        int a11 = a(t10, a10);
        if (a11 == 0) {
            ((g) f.c(temporalAccessor)).getClass();
            LocalDate o10 = LocalDate.o(temporalAccessor);
            long j11 = (long) a10;
            b bVar = b.DAYS;
            if (j11 == Long.MIN_VALUE) {
                o10 = o10.f(Long.MAX_VALUE, bVar);
                j10 = 1;
            } else {
                j10 = -j11;
            }
            return k(o10.f(j10, bVar));
        } else if (a11 <= 50) {
            return a11;
        } else {
            int a12 = a(t10, this.f42753b.f() + ((int) temporalAccessor.e(aVar).d()));
            return a11 >= a12 ? (a11 - a12) + 1 : a11;
        }
    }

    private long l(TemporalAccessor temporalAccessor) {
        int c10 = c(temporalAccessor);
        int a10 = temporalAccessor.a(a.DAY_OF_YEAR);
        return (long) a(t(a10, c10), a10);
    }

    static t m(u uVar) {
        return new t("DayOfWeek", uVar, b.DAYS, b.WEEKS, f42748f);
    }

    private LocalDate n(f fVar, int i10, int i11, int i12) {
        ((g) fVar).getClass();
        LocalDate w10 = LocalDate.w(i10, 1, 1);
        int t10 = t(1, c(w10));
        return w10.f((long) (((Math.min(i11, a(t10, this.f42753b.f() + (w10.u() ? 366 : 365)) - 1) - 1) * 7) + (i12 - 1) + (-t10)), b.DAYS);
    }

    static t o(u uVar) {
        return new t("WeekBasedYear", uVar, j.f42735d, b.FOREVER, a.YEAR.e());
    }

    static t p(u uVar) {
        return new t("WeekOfMonth", uVar, b.WEEKS, b.MONTHS, f42749g);
    }

    static t q(u uVar) {
        return new t("WeekOfWeekBasedYear", uVar, b.WEEKS, j.f42735d, f42751i);
    }

    private s r(TemporalAccessor temporalAccessor, a aVar) {
        int t10 = t(temporalAccessor.a(aVar), c(temporalAccessor));
        s e10 = temporalAccessor.e(aVar);
        return s.i((long) a(t10, (int) e10.e()), (long) a(t10, (int) e10.d()));
    }

    private s s(TemporalAccessor temporalAccessor) {
        a aVar = a.DAY_OF_YEAR;
        if (!temporalAccessor.i(aVar)) {
            return f42750h;
        }
        int c10 = c(temporalAccessor);
        int a10 = temporalAccessor.a(aVar);
        int t10 = t(a10, c10);
        int a11 = a(t10, a10);
        if (a11 == 0) {
            ((g) f.c(temporalAccessor)).getClass();
            LocalDate o10 = LocalDate.o(temporalAccessor);
            long j10 = (long) (a10 + 7);
            b bVar = b.DAYS;
            return s(j10 == Long.MIN_VALUE ? o10.f(Long.MAX_VALUE, bVar).f(1, bVar) : o10.f(-j10, bVar));
        }
        int d10 = (int) temporalAccessor.e(aVar).d();
        int a12 = a(t10, this.f42753b.f() + d10);
        if (a11 < a12) {
            return s.i(1, (long) (a12 - 1));
        }
        ((g) f.c(temporalAccessor)).getClass();
        return s(LocalDate.o(temporalAccessor).f((long) ((d10 - a10) + 1 + 7), b.DAYS));
    }

    private int t(int i10, int i11) {
        int floorMod = Math.floorMod(i10 - i11, 7);
        return floorMod + 1 > this.f42753b.f() ? 7 - floorMod : -floorMod;
    }

    public final boolean b(TemporalAccessor temporalAccessor) {
        a aVar;
        if (!temporalAccessor.i(a.DAY_OF_WEEK)) {
            return false;
        }
        q qVar = this.f42755d;
        if (qVar == b.WEEKS) {
            return true;
        }
        if (qVar == b.MONTHS) {
            aVar = a.DAY_OF_MONTH;
        } else if (qVar == b.YEARS || qVar == u.f42758h) {
            aVar = a.DAY_OF_YEAR;
        } else if (qVar != b.FOREVER) {
            return false;
        } else {
            aVar = a.YEAR;
        }
        return temporalAccessor.i(aVar);
    }

    public final s d(TemporalAccessor temporalAccessor) {
        q qVar = this.f42755d;
        if (qVar == b.WEEKS) {
            return this.f42756e;
        }
        if (qVar == b.MONTHS) {
            return r(temporalAccessor, a.DAY_OF_MONTH);
        }
        if (qVar == b.YEARS) {
            return r(temporalAccessor, a.DAY_OF_YEAR);
        }
        if (qVar == u.f42758h) {
            return s(temporalAccessor);
        }
        if (qVar == b.FOREVER) {
            return a.YEAR.e();
        }
        StringBuilder a10 = a.a("unreachable, rangeUnit: ");
        a10.append(this.f42755d);
        a10.append(", this: ");
        a10.append(this);
        throw new IllegalStateException(a10.toString());
    }

    public final s e() {
        return this.f42756e;
    }

    public final TemporalAccessor f(HashMap hashMap, TemporalAccessor temporalAccessor, F f10) {
        LocalDate localDate;
        LocalDate localDate2;
        LocalDate localDate3;
        HashMap hashMap2 = hashMap;
        F f11 = f10;
        long longValue = ((Long) hashMap2.get(this)).longValue();
        int intExact = Math.toIntExact(longValue);
        q qVar = this.f42755d;
        b bVar = b.WEEKS;
        if (qVar == bVar) {
            hashMap2.remove(this);
            hashMap2.put(a.DAY_OF_WEEK, Long.valueOf((long) (Math.floorMod((this.f42756e.a(longValue, this) - 1) + (this.f42753b.e().m() - 1), 7) + 1)));
        } else {
            a aVar = a.DAY_OF_WEEK;
            if (hashMap2.containsKey(aVar)) {
                int floorMod = Math.floorMod(aVar.j(((Long) hashMap2.get(aVar)).longValue()) - this.f42753b.e().m(), 7) + 1;
                f c10 = f.c(temporalAccessor);
                a aVar2 = a.YEAR;
                if (hashMap2.containsKey(aVar2)) {
                    int j10 = aVar2.j(((Long) hashMap2.get(aVar2)).longValue());
                    q qVar2 = this.f42755d;
                    b bVar2 = b.MONTHS;
                    if (qVar2 == bVar2) {
                        a aVar3 = a.MONTH_OF_YEAR;
                        if (hashMap2.containsKey(aVar3)) {
                            long longValue2 = ((Long) hashMap2.get(aVar3)).longValue();
                            long j11 = (long) intExact;
                            if (f11 == F.LENIENT) {
                                ((g) c10).getClass();
                                LocalDate z10 = LocalDate.w(j10, 1, 1).f(Math.subtractExact(longValue2, 1), bVar2);
                                localDate3 = z10.f(Math.addExact(Math.multiplyExact(Math.subtractExact(j11, j(z10)), 7), (long) (floorMod - c(z10))), b.DAYS);
                            } else {
                                int j12 = aVar3.j(longValue2);
                                ((g) c10).getClass();
                                LocalDate w10 = LocalDate.w(j10, j12, 1);
                                LocalDate z11 = w10.f((long) ((((int) (((long) this.f42756e.a(j11, this)) - j(w10))) * 7) + (floorMod - c(w10))), b.DAYS);
                                if (f11 != F.STRICT || z11.j(aVar3) == longValue2) {
                                    localDate3 = z11;
                                } else {
                                    throw new d("Strict mode rejected resolved date as it is in a different month");
                                }
                            }
                            hashMap2.remove(this);
                            hashMap2.remove(aVar2);
                            hashMap2.remove(aVar3);
                            hashMap2.remove(aVar);
                            return localDate3;
                        }
                    }
                    if (this.f42755d == b.YEARS) {
                        long j13 = (long) intExact;
                        ((g) c10).getClass();
                        LocalDate w11 = LocalDate.w(j10, 1, 1);
                        if (f11 == F.LENIENT) {
                            localDate2 = w11.f(Math.addExact(Math.multiplyExact(Math.subtractExact(j13, l(w11)), 7), (long) (floorMod - c(w11))), b.DAYS);
                        } else {
                            LocalDate z12 = w11.f((long) ((((int) (((long) this.f42756e.a(j13, this)) - l(w11))) * 7) + (floorMod - c(w11))), b.DAYS);
                            if (f11 != F.STRICT || z12.j(aVar2) == ((long) j10)) {
                                localDate2 = z12;
                            } else {
                                throw new d("Strict mode rejected resolved date as it is in a different year");
                            }
                        }
                        hashMap2.remove(this);
                        hashMap2.remove(aVar2);
                        hashMap2.remove(aVar);
                        return localDate2;
                    }
                } else {
                    q qVar3 = this.f42755d;
                    if ((qVar3 == u.f42758h || qVar3 == b.FOREVER) && hashMap2.containsKey(this.f42753b.f42764f) && hashMap2.containsKey(this.f42753b.f42763e)) {
                        int a10 = ((t) this.f42753b.f42764f).f42756e.a(((Long) hashMap2.get(this.f42753b.f42764f)).longValue(), this.f42753b.f42764f);
                        if (f11 == F.LENIENT) {
                            localDate = n(c10, a10, 1, floorMod).f(Math.subtractExact(((Long) hashMap2.get(this.f42753b.f42763e)).longValue(), 1), bVar);
                        } else {
                            LocalDate n10 = n(c10, a10, ((t) this.f42753b.f42763e).f42756e.a(((Long) hashMap2.get(this.f42753b.f42763e)).longValue(), this.f42753b.f42763e), floorMod);
                            if (f11 != F.STRICT || g(n10) == a10) {
                                localDate = n10;
                            } else {
                                throw new d("Strict mode rejected resolved date as it is in a different week-based-year");
                            }
                        }
                        hashMap2.remove(this);
                        hashMap2.remove(this.f42753b.f42764f);
                        hashMap2.remove(this.f42753b.f42763e);
                        hashMap2.remove(aVar);
                        return localDate;
                    }
                }
            }
        }
        return null;
    }

    public final long h(TemporalAccessor temporalAccessor) {
        int i10;
        q qVar = this.f42755d;
        if (qVar == b.WEEKS) {
            i10 = c(temporalAccessor);
        } else if (qVar == b.MONTHS) {
            return j(temporalAccessor);
        } else {
            if (qVar == b.YEARS) {
                return l(temporalAccessor);
            }
            if (qVar == u.f42758h) {
                i10 = k(temporalAccessor);
            } else if (qVar == b.FOREVER) {
                i10 = g(temporalAccessor);
            } else {
                StringBuilder a10 = a.a("unreachable, rangeUnit: ");
                a10.append(this.f42755d);
                a10.append(", this: ");
                a10.append(this);
                throw new IllegalStateException(a10.toString());
            }
        }
        return (long) i10;
    }

    public final k i(k kVar, long j10) {
        int a10 = this.f42756e.a(j10, this);
        int a11 = kVar.a(this);
        if (a10 == a11) {
            return kVar;
        }
        if (this.f42755d != b.FOREVER) {
            return kVar.f((long) (a10 - a11), this.f42754c);
        }
        int a12 = kVar.a(this.f42753b.f42761c);
        return n(f.c(kVar), (int) j10, kVar.a(this.f42753b.f42763e), a12);
    }

    public final boolean isDateBased() {
        return true;
    }

    public final boolean isTimeBased() {
        return false;
    }

    public final String toString() {
        return this.f42752a + "[" + this.f42753b.toString() + "]";
    }
}
