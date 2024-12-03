package md;

import ed.i;
import ed.p;

final class b extends k {

    /* renamed from: a  reason: collision with root package name */
    private final long f41192a;

    /* renamed from: b  reason: collision with root package name */
    private final p f41193b;

    /* renamed from: c  reason: collision with root package name */
    private final i f41194c;

    b(long j10, p pVar, i iVar) {
        this.f41192a = j10;
        if (pVar != null) {
            this.f41193b = pVar;
            if (iVar != null) {
                this.f41194c = iVar;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public i b() {
        return this.f41194c;
    }

    public long c() {
        return this.f41192a;
    }

    public p d() {
        return this.f41193b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f41192a != kVar.c() || !this.f41193b.equals(kVar.d()) || !this.f41194c.equals(kVar.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j10 = this.f41192a;
        return ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f41193b.hashCode()) * 1000003) ^ this.f41194c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f41192a + ", transportContext=" + this.f41193b + ", event=" + this.f41194c + "}";
    }
}
