package j$.time.zone;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

public final class c implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    private static final long[] f42768i = new long[0];

    /* renamed from: j  reason: collision with root package name */
    private static final b[] f42769j = new b[0];

    /* renamed from: k  reason: collision with root package name */
    private static final LocalDateTime[] f42770k = new LocalDateTime[0];

    /* renamed from: l  reason: collision with root package name */
    private static final a[] f42771l = new a[0];

    /* renamed from: a  reason: collision with root package name */
    private final long[] f42772a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset[] f42773b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f42774c;

    /* renamed from: d  reason: collision with root package name */
    private final LocalDateTime[] f42775d;

    /* renamed from: e  reason: collision with root package name */
    private final ZoneOffset[] f42776e;

    /* renamed from: f  reason: collision with root package name */
    private final b[] f42777f;

    /* renamed from: g  reason: collision with root package name */
    private final TimeZone f42778g;

    /* renamed from: h  reason: collision with root package name */
    private final transient ConcurrentHashMap f42779h = new ConcurrentHashMap();

    private c(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[1];
        this.f42773b = zoneOffsetArr;
        zoneOffsetArr[0] = zoneOffset;
        long[] jArr = f42768i;
        this.f42772a = jArr;
        this.f42774c = jArr;
        this.f42775d = f42770k;
        this.f42776e = zoneOffsetArr;
        this.f42777f = f42769j;
        this.f42778g = null;
    }

    c(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[1];
        this.f42773b = zoneOffsetArr;
        zoneOffsetArr[0] = k(timeZone.getRawOffset());
        long[] jArr = f42768i;
        this.f42772a = jArr;
        this.f42774c = jArr;
        this.f42775d = f42770k;
        this.f42776e = zoneOffsetArr;
        this.f42777f = f42769j;
        this.f42778g = timeZone;
    }

    private static Object a(LocalDateTime localDateTime, a aVar) {
        LocalDateTime d10 = aVar.d();
        boolean j10 = aVar.j();
        boolean t10 = localDateTime.t(d10);
        return j10 ? t10 ? aVar.h() : localDateTime.t(aVar.b()) ? aVar : aVar.f() : !t10 ? aVar.f() : localDateTime.t(aVar.b()) ? aVar.h() : aVar;
    }

    private a[] b(int i10) {
        long j10;
        int i11 = i10;
        Integer valueOf = Integer.valueOf(i10);
        a[] aVarArr = (a[]) this.f42779h.get(valueOf);
        if (aVarArr != null) {
            return aVarArr;
        }
        if (this.f42778g == null) {
            b[] bVarArr = this.f42777f;
            a[] aVarArr2 = new a[bVarArr.length];
            if (bVarArr.length <= 0) {
                if (i11 < 2100) {
                    this.f42779h.putIfAbsent(valueOf, aVarArr2);
                }
                return aVarArr2;
            }
            b bVar = bVarArr[0];
            throw null;
        } else if (i11 < 1800) {
            return f42771l;
        } else {
            long g10 = LocalDateTime.u(i11 - 1).g(this.f42773b[0]);
            int offset = this.f42778g.getOffset(g10 * 1000);
            long j11 = 31968000 + g10;
            a[] aVarArr3 = f42771l;
            while (g10 < j11) {
                long j12 = 7776000 + g10;
                long j13 = g10;
                if (offset != this.f42778g.getOffset(j12 * 1000)) {
                    g10 = j13;
                    while (j12 - g10 > 1) {
                        long floorDiv = Math.floorDiv(j12 + g10, 2);
                        long j14 = j11;
                        int i12 = offset;
                        if (this.f42778g.getOffset(floorDiv * 1000) == i12) {
                            g10 = floorDiv;
                        } else {
                            j12 = floorDiv;
                        }
                        offset = i12;
                        j11 = j14;
                    }
                    j10 = j11;
                    int i13 = offset;
                    if (this.f42778g.getOffset(g10 * 1000) == i13) {
                        g10 = j12;
                    }
                    ZoneOffset k10 = k(i13);
                    offset = this.f42778g.getOffset(g10 * 1000);
                    ZoneOffset k11 = k(offset);
                    if (c(g10, k11) == i11) {
                        a[] aVarArr4 = (a[]) Arrays.copyOf(aVarArr3, aVarArr3.length + 1);
                        aVarArr4[aVarArr4.length - 1] = new a(g10, k10, k11);
                        aVarArr3 = aVarArr4;
                    }
                } else {
                    j10 = j11;
                    int i14 = offset;
                    g10 = j12;
                }
                j11 = j10;
            }
            if (1916 <= i11 && i11 < 2100) {
                this.f42779h.putIfAbsent(valueOf, aVarArr3);
            }
            return aVarArr3;
        }
    }

    private static int c(long j10, ZoneOffset zoneOffset) {
        return LocalDate.x(Math.floorDiv(j10 + ((long) zoneOffset.r()), 86400)).t();
    }

    private Object e(LocalDateTime localDateTime) {
        Object obj = null;
        int i10 = 0;
        if (this.f42778g != null) {
            a[] b10 = b(localDateTime.r());
            if (b10.length == 0) {
                return k(this.f42778g.getOffset(localDateTime.g(this.f42773b[0]) * 1000));
            }
            int length = b10.length;
            while (i10 < length) {
                a aVar = b10[i10];
                Object a10 = a(localDateTime, aVar);
                if ((a10 instanceof a) || a10.equals(aVar.h())) {
                    return a10;
                }
                i10++;
                obj = a10;
            }
            return obj;
        } else if (this.f42774c.length == 0) {
            return this.f42773b[0];
        } else {
            if (this.f42777f.length > 0) {
                LocalDateTime[] localDateTimeArr = this.f42775d;
                if (localDateTime.s(localDateTimeArr[localDateTimeArr.length - 1])) {
                    a[] b11 = b(localDateTime.r());
                    int length2 = b11.length;
                    while (i10 < length2) {
                        a aVar2 = b11[i10];
                        Object a11 = a(localDateTime, aVar2);
                        if ((a11 instanceof a) || a11.equals(aVar2.h())) {
                            return a11;
                        }
                        i10++;
                        obj = a11;
                    }
                    return obj;
                }
            }
            int binarySearch = Arrays.binarySearch(this.f42775d, localDateTime);
            if (binarySearch == -1) {
                return this.f42776e[0];
            }
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            } else {
                LocalDateTime[] localDateTimeArr2 = this.f42775d;
                if (binarySearch < localDateTimeArr2.length - 1) {
                    int i11 = binarySearch + 1;
                    if (localDateTimeArr2[binarySearch].equals(localDateTimeArr2[i11])) {
                        binarySearch = i11;
                    }
                }
            }
            if ((binarySearch & 1) != 0) {
                return this.f42776e[(binarySearch / 2) + 1];
            }
            LocalDateTime[] localDateTimeArr3 = this.f42775d;
            LocalDateTime localDateTime2 = localDateTimeArr3[binarySearch];
            LocalDateTime localDateTime3 = localDateTimeArr3[binarySearch + 1];
            ZoneOffset[] zoneOffsetArr = this.f42776e;
            int i12 = binarySearch / 2;
            ZoneOffset zoneOffset = zoneOffsetArr[i12];
            ZoneOffset zoneOffset2 = zoneOffsetArr[i12 + 1];
            return zoneOffset2.r() > zoneOffset.r() ? new a(localDateTime2, zoneOffset, zoneOffset2) : new a(localDateTime3, zoneOffset, zoneOffset2);
        }
    }

    public static c j(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, Range.ATTR_OFFSET);
        return new c(zoneOffset);
    }

    private static ZoneOffset k(int i10) {
        return ZoneOffset.u(i10 / 1000);
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f42778g;
        if (timeZone != null) {
            return k(timeZone.getOffset(instant.toEpochMilli()));
        }
        if (this.f42774c.length == 0) {
            return this.f42773b[0];
        }
        long epochSecond = instant.getEpochSecond();
        if (this.f42777f.length > 0) {
            long[] jArr = this.f42774c;
            if (epochSecond > jArr[jArr.length - 1]) {
                ZoneOffset[] zoneOffsetArr = this.f42776e;
                a[] b10 = b(c(epochSecond, zoneOffsetArr[zoneOffsetArr.length - 1]));
                a aVar = null;
                for (int i10 = 0; i10 < b10.length; i10++) {
                    aVar = b10[i10];
                    if (epochSecond < aVar.l()) {
                        return aVar.h();
                    }
                }
                return aVar.f();
            }
        }
        int binarySearch = Arrays.binarySearch(this.f42774c, epochSecond);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.f42776e[binarySearch + 1];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Objects.equals(this.f42778g, cVar.f42778g) && Arrays.equals(this.f42772a, cVar.f42772a) && Arrays.equals(this.f42773b, cVar.f42773b) && Arrays.equals(this.f42774c, cVar.f42774c) && Arrays.equals(this.f42776e, cVar.f42776e) && Arrays.equals(this.f42777f, cVar.f42777f);
    }

    public final a f(LocalDateTime localDateTime) {
        Object e10 = e(localDateTime);
        if (e10 instanceof a) {
            return (a) e10;
        }
        return null;
    }

    public final List g(LocalDateTime localDateTime) {
        Object e10 = e(localDateTime);
        return e10 instanceof a ? ((a) e10).i() : Collections.singletonList((ZoneOffset) e10);
    }

    public final boolean h(Instant instant) {
        ZoneOffset zoneOffset;
        TimeZone timeZone = this.f42778g;
        if (timeZone != null) {
            zoneOffset = k(timeZone.getRawOffset());
        } else if (this.f42774c.length == 0) {
            zoneOffset = this.f42773b[0];
        } else {
            int binarySearch = Arrays.binarySearch(this.f42772a, instant.getEpochSecond());
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            zoneOffset = this.f42773b[binarySearch + 1];
        }
        return !zoneOffset.equals(d(instant));
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.f42778g) ^ Arrays.hashCode(this.f42772a)) ^ Arrays.hashCode(this.f42773b)) ^ Arrays.hashCode(this.f42774c)) ^ Arrays.hashCode(this.f42776e)) ^ Arrays.hashCode(this.f42777f);
    }

    public final boolean i() {
        TimeZone timeZone = this.f42778g;
        if (timeZone == null) {
            return this.f42774c.length == 0;
        }
        if (!timeZone.useDaylightTime() && this.f42778g.getDSTSavings() == 0) {
            Instant now = Instant.now();
            a aVar = null;
            if (this.f42778g != null) {
                long epochSecond = now.getEpochSecond();
                if (now.getNano() > 0 && epochSecond < Long.MAX_VALUE) {
                    epochSecond++;
                }
                int c10 = c(epochSecond, d(now));
                a[] b10 = b(c10);
                int length = b10.length - 1;
                while (true) {
                    if (length >= 0) {
                        if (epochSecond > b10[length].l()) {
                            aVar = b10[length];
                            break;
                        }
                        length--;
                    } else if (c10 > 1800) {
                        a[] b11 = b(c10 - 1);
                        int length2 = b11.length - 1;
                        while (true) {
                            if (length2 < 0) {
                                long min = Math.min(epochSecond - 31104000, (j$.time.c.d().b() / 1000) + 31968000);
                                int offset = this.f42778g.getOffset((epochSecond - 1) * 1000);
                                long F = LocalDate.w(1800, 1, 1).F() * 86400;
                                while (true) {
                                    if (F > min) {
                                        break;
                                    }
                                    int offset2 = this.f42778g.getOffset(min * 1000);
                                    if (offset != offset2) {
                                        int c11 = c(min, k(offset2));
                                        a[] b12 = b(c11 + 1);
                                        int length3 = b12.length - 1;
                                        while (true) {
                                            if (length3 < 0) {
                                                a[] b13 = b(c11);
                                                aVar = b13[b13.length - 1];
                                                break;
                                            } else if (epochSecond > b12[length3].l()) {
                                                aVar = b12[length3];
                                                break;
                                            } else {
                                                length3--;
                                            }
                                        }
                                    } else {
                                        min -= 7776000;
                                    }
                                }
                            } else if (epochSecond > b11[length2].l()) {
                                aVar = b11[length2];
                                break;
                            } else {
                                length2--;
                            }
                        }
                    }
                }
            } else if (this.f42774c.length != 0) {
                long epochSecond2 = now.getEpochSecond();
                if (now.getNano() > 0 && epochSecond2 < Long.MAX_VALUE) {
                    epochSecond2++;
                }
                long[] jArr = this.f42774c;
                long j10 = jArr[jArr.length - 1];
                if (this.f42777f.length > 0 && epochSecond2 > j10) {
                    ZoneOffset[] zoneOffsetArr = this.f42776e;
                    ZoneOffset zoneOffset = zoneOffsetArr[zoneOffsetArr.length - 1];
                    int c12 = c(epochSecond2, zoneOffset);
                    a[] b14 = b(c12);
                    int length4 = b14.length - 1;
                    while (true) {
                        if (length4 < 0) {
                            int i10 = c12 - 1;
                            if (i10 > c(j10, zoneOffset)) {
                                a[] b15 = b(i10);
                                aVar = b15[b15.length - 1];
                            }
                        } else if (epochSecond2 > b14[length4].l()) {
                            aVar = b14[length4];
                            break;
                        } else {
                            length4--;
                        }
                    }
                }
                int binarySearch = Arrays.binarySearch(this.f42774c, epochSecond2);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                if (binarySearch > 0) {
                    int i11 = binarySearch - 1;
                    long j11 = this.f42774c[i11];
                    ZoneOffset[] zoneOffsetArr2 = this.f42776e;
                    aVar = new a(j11, zoneOffsetArr2[i11], zoneOffsetArr2[binarySearch]);
                }
            }
            if (aVar == null) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb2;
        if (this.f42778g != null) {
            sb2 = a.a("ZoneRules[timeZone=");
            sb2.append(this.f42778g.getID());
        } else {
            sb2 = a.a("ZoneRules[currentStandardOffset=");
            ZoneOffset[] zoneOffsetArr = this.f42773b;
            sb2.append(zoneOffsetArr[zoneOffsetArr.length - 1]);
        }
        sb2.append("]");
        return sb2.toString();
    }
}
