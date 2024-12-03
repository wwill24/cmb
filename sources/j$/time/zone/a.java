package j$.time.zone;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.f;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

public final class a implements Comparable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final LocalDateTime f42765a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset f42766b;

    /* renamed from: c  reason: collision with root package name */
    private final ZoneOffset f42767c;

    a(long j10, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f42765a = LocalDateTime.x(j10, 0, zoneOffset);
        this.f42766b = zoneOffset;
        this.f42767c = zoneOffset2;
    }

    a(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f42765a = localDateTime;
        this.f42766b = zoneOffset;
        this.f42767c = zoneOffset2;
    }

    public final LocalDateTime b() {
        return this.f42765a.A((long) (this.f42767c.r() - this.f42766b.r()));
    }

    public final int compareTo(Object obj) {
        a aVar = (a) obj;
        LocalDateTime localDateTime = this.f42765a;
        Instant p10 = Instant.p(localDateTime.g(this.f42766b), (long) localDateTime.E().q());
        LocalDateTime localDateTime2 = aVar.f42765a;
        return p10.compareTo(Instant.p(localDateTime2.g(aVar.f42766b), (long) localDateTime2.E().q()));
    }

    public final LocalDateTime d() {
        return this.f42765a;
    }

    public final f e() {
        return f.h((long) (this.f42767c.r() - this.f42766b.r()));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f42765a.equals(aVar.f42765a) && this.f42766b.equals(aVar.f42766b) && this.f42767c.equals(aVar.f42767c);
    }

    public final ZoneOffset f() {
        return this.f42767c;
    }

    public final ZoneOffset h() {
        return this.f42766b;
    }

    public final int hashCode() {
        return (this.f42765a.hashCode() ^ this.f42766b.hashCode()) ^ Integer.rotateLeft(this.f42767c.hashCode(), 16);
    }

    /* access modifiers changed from: package-private */
    public final List i() {
        if (j()) {
            return Collections.emptyList();
        }
        return Arrays.asList(new ZoneOffset[]{this.f42766b, this.f42767c});
    }

    public final boolean j() {
        return this.f42767c.r() > this.f42766b.r();
    }

    public final long l() {
        return this.f42765a.g(this.f42766b);
    }

    public final String toString() {
        StringBuilder a10 = j$.time.a.a("Transition[");
        a10.append(j() ? "Gap" : "Overlap");
        a10.append(" at ");
        a10.append(this.f42765a);
        a10.append(this.f42766b);
        a10.append(" to ");
        a10.append(this.f42767c);
        a10.append(PropertyUtils.INDEXED_DELIM2);
        return a10.toString();
    }
}
