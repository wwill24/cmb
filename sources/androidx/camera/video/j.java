package androidx.camera.video;

import androidx.annotation.NonNull;

final class j extends e0 {

    /* renamed from: a  reason: collision with root package name */
    private final long f3380a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3381b;

    /* renamed from: c  reason: collision with root package name */
    private final b f3382c;

    j(long j10, long j11, b bVar) {
        this.f3380a = j10;
        this.f3381b = j11;
        if (bVar != null) {
            this.f3382c = bVar;
            return;
        }
        throw new NullPointerException("Null audioStats");
    }

    @NonNull
    public b a() {
        return this.f3382c;
    }

    public long b() {
        return this.f3381b;
    }

    public long c() {
        return this.f3380a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        if (this.f3380a == e0Var.c() && this.f3381b == e0Var.b() && this.f3382c.equals(e0Var.a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f3380a;
        long j11 = this.f3381b;
        return ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f3382c.hashCode();
    }

    public String toString() {
        return "RecordingStats{recordedDurationNanos=" + this.f3380a + ", numBytesRecorded=" + this.f3381b + ", audioStats=" + this.f3382c + "}";
    }
}
