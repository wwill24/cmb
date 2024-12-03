package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.d;
import j$.time.e;
import j$.time.temporal.b;
import j$.time.temporal.n;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a implements f {
    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new Locale("ja", "JP", "JP");
    }

    protected a() {
    }

    static void b(HashMap hashMap, j$.time.temporal.a aVar, long j10) {
        Long l10 = (Long) hashMap.get(aVar);
        if (l10 == null || l10.longValue() == j10) {
            hashMap.put(aVar, Long.valueOf(j10));
            return;
        }
        throw new d("Conflict found: " + aVar + " " + l10 + " differs from " + aVar + " " + j10);
    }

    static LocalDate d(LocalDate localDate, long j10, long j11, long j12) {
        long j13;
        LocalDate z10 = localDate.f(j10, b.MONTHS);
        b bVar = b.WEEKS;
        LocalDate z11 = z10.f(j11, bVar);
        if (j12 > 7) {
            j13 = j12 - 1;
            z11 = z11.f(j13 / 7, bVar);
        } else {
            if (j12 < 1) {
                z11 = z11.f(Math.subtractExact(j12, 7) / 7, bVar);
                j13 = j12 + 6;
            }
            return z11.d(new n(e.n((int) j12).m()));
        }
        j12 = (j13 % 7) + 1;
        return z11.d(new n(e.n((int) j12).m()));
    }

    public final int compareTo(Object obj) {
        ((f) obj).getClass();
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        ((a) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return getClass().hashCode() ^ 72805;
    }

    public final String toString() {
        return "ISO";
    }
}
