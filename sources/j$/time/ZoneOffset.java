package j$.time;

import com.facebook.internal.security.CertificateUtil;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.a;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.p;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.zone.c;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.cli.HelpFormatter;

public final class ZoneOffset extends ZoneId implements TemporalAccessor, l, Comparable<ZoneOffset> {
    public static final ZoneOffset UTC = u(0);

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentHashMap f42574d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentHashMap f42575e = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: f  reason: collision with root package name */
    public static final ZoneOffset f42576f = u(-64800);

    /* renamed from: g  reason: collision with root package name */
    public static final ZoneOffset f42577g = u(64800);

    /* renamed from: b  reason: collision with root package name */
    private final int f42578b;

    /* renamed from: c  reason: collision with root package name */
    private final transient String f42579c;

    private ZoneOffset(int i10) {
        String str;
        this.f42578b = i10;
        if (i10 == 0) {
            str = "Z";
        } else {
            int abs = Math.abs(i10);
            StringBuilder sb2 = new StringBuilder();
            int i11 = abs / 3600;
            int i12 = (abs / 60) % 60;
            sb2.append(i10 < 0 ? HelpFormatter.DEFAULT_OPT_PREFIX : "+");
            sb2.append(i11 < 10 ? "0" : "");
            sb2.append(i11);
            String str2 = ":0";
            sb2.append(i12 < 10 ? str2 : CertificateUtil.DELIMITER);
            sb2.append(i12);
            int i13 = abs % 60;
            if (i13 != 0) {
                sb2.append(i13 >= 10 ? CertificateUtil.DELIMITER : str2);
                sb2.append(i13);
            }
            str = sb2.toString();
        }
        this.f42579c = str;
    }

    public static ZoneOffset q(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.k(o.d());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        throw new d("Unable to obtain ZoneOffset from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j$.time.ZoneOffset s(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentHashMap r0 = f42575e
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto L_0x0010
            return r0
        L_0x0010:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x006e
            r1 = 3
            if (r0 == r1) goto L_0x008a
            r4 = 5
            if (r0 == r4) goto L_0x0064
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L_0x005b
            r5 = 7
            if (r0 == r5) goto L_0x004e
            r1 = 9
            if (r0 != r1) goto L_0x0037
            int r0 = v(r7, r2, r3)
            int r1 = v(r7, r6, r2)
            int r2 = v(r7, r5, r2)
            goto L_0x0090
        L_0x0037:
            j$.time.d r0 = new j$.time.d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, invalid format: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x004e:
            int r0 = v(r7, r2, r3)
            int r1 = v(r7, r1, r3)
            int r2 = v(r7, r4, r3)
            goto L_0x0090
        L_0x005b:
            int r0 = v(r7, r2, r3)
            int r1 = v(r7, r6, r2)
            goto L_0x006c
        L_0x0064:
            int r0 = v(r7, r2, r3)
            int r1 = v(r7, r1, r3)
        L_0x006c:
            r2 = r3
            goto L_0x0090
        L_0x006e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r1 = r7.charAt(r3)
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            char r7 = r7.charAt(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L_0x008a:
            int r0 = v(r7, r2, r3)
            r1 = r3
            r2 = r1
        L_0x0090:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto L_0x00b4
            if (r3 != r5) goto L_0x009d
            goto L_0x00b4
        L_0x009d:
            j$.time.d r0 = new j$.time.d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x00b4:
            if (r3 != r5) goto L_0x00be
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.ZoneOffset r7 = t(r7, r0, r1)
            return r7
        L_0x00be:
            j$.time.ZoneOffset r7 = t(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.s(java.lang.String):j$.time.ZoneOffset");
    }

    public static ZoneOffset t(int i10, int i11, int i12) {
        if (i10 < -18 || i10 > 18) {
            throw new d("Zone offset hours not in valid range: value " + i10 + " is not in the range -18 to 18");
        }
        if (i10 > 0) {
            if (i11 < 0 || i12 < 0) {
                throw new d("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i10 < 0) {
            if (i11 > 0 || i12 > 0) {
                throw new d("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i11 > 0 && i12 < 0) || (i11 < 0 && i12 > 0)) {
            throw new d("Zone offset minutes and seconds must have the same sign");
        }
        if (i11 < -59 || i11 > 59) {
            throw new d("Zone offset minutes not in valid range: value " + i11 + " is not in the range -59 to 59");
        } else if (i12 < -59 || i12 > 59) {
            throw new d("Zone offset seconds not in valid range: value " + i12 + " is not in the range -59 to 59");
        } else if (Math.abs(i10) != 18 || (i11 | i12) == 0) {
            return u((i11 * 60) + (i10 * 3600) + i12);
        } else {
            throw new d("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    public static ZoneOffset u(int i10) {
        if (i10 < -64800 || i10 > 64800) {
            throw new d("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i10 % 900 != 0) {
            return new ZoneOffset(i10);
        } else {
            Integer valueOf = Integer.valueOf(i10);
            ConcurrentHashMap concurrentHashMap = f42574d;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentHashMap.putIfAbsent(valueOf, new ZoneOffset(i10));
            ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(valueOf);
            f42575e.putIfAbsent(zoneOffset2.f42579c, zoneOffset2);
            return zoneOffset2;
        }
    }

    private static int v(CharSequence charSequence, int i10, boolean z10) {
        if (!z10 || charSequence.charAt(i10 - 1) == ':') {
            char charAt = charSequence.charAt(i10);
            char charAt2 = charSequence.charAt(i10 + 1);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
                throw new d("Invalid ID for ZoneOffset, non numeric characters found: " + charSequence);
            }
            return (charAt2 - '0') + ((charAt - '0') * 10);
        }
        throw new d("Invalid ID for ZoneOffset, colon not found when expected: " + charSequence);
    }

    public final int a(m mVar) {
        if (mVar == a.OFFSET_SECONDS) {
            return this.f42578b;
        }
        if (!(mVar instanceof a)) {
            return super.e(mVar).a(j(mVar), mVar);
        }
        throw new r("Unsupported field: " + mVar);
    }

    public final int compareTo(Object obj) {
        return ((ZoneOffset) obj).f42578b - this.f42578b;
    }

    public final s e(m mVar) {
        return super.e(mVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneOffset) {
            return this.f42578b == ((ZoneOffset) obj).f42578b;
        }
        return false;
    }

    public final k h(k kVar) {
        return kVar.b((long) this.f42578b, a.OFFSET_SECONDS);
    }

    public final int hashCode() {
        return this.f42578b;
    }

    public final boolean i(m mVar) {
        return mVar instanceof a ? mVar == a.OFFSET_SECONDS : mVar != null && mVar.b(this);
    }

    public final long j(m mVar) {
        if (mVar == a.OFFSET_SECONDS) {
            return (long) this.f42578b;
        }
        if (!(mVar instanceof a)) {
            return mVar.h(this);
        }
        throw new r("Unsupported field: " + mVar);
    }

    public final Object k(p pVar) {
        return (pVar == o.d() || pVar == o.f()) ? this : super.k(pVar);
    }

    public final String n() {
        return this.f42579c;
    }

    public final c o() {
        return c.j(this);
    }

    public final int r() {
        return this.f42578b;
    }

    public final String toString() {
        return this.f42579c;
    }
}
