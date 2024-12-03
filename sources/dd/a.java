package dd;

final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private final long f40602a;

    a(long j10) {
        this.f40602a = j10;
    }

    public long c() {
        return this.f40602a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        if (this.f40602a == ((b) obj).c()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f40602a;
        return ((int) (j10 ^ (j10 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f40602a + "}";
    }
}
