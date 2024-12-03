package j$.time;

import java.io.Serializable;

final class b extends c implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final ZoneId f42583a;

    b(ZoneId zoneId) {
        this.f42583a = zoneId;
    }

    public final ZoneId a() {
        return this.f42583a;
    }

    public final long b() {
        return System.currentTimeMillis();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f42583a.equals(((b) obj).f42583a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f42583a.hashCode() + 1;
    }

    public final String toString() {
        StringBuilder a10 = a.a("SystemClock[");
        a10.append(this.f42583a);
        a10.append("]");
        return a10.toString();
    }
}
