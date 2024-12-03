package com.google.android.play.integrity.internal;

final class g extends h {

    /* renamed from: a  reason: collision with root package name */
    private final long f20516a;

    g(int i10, long j10) {
        this.f20516a = j10;
    }

    public final int a() {
        return 3;
    }

    public final long b() {
        return this.f20516a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            hVar.a();
            if (this.f20516a == hVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f20516a;
        return ((int) (j10 ^ (j10 >>> 32))) ^ -724379968;
    }

    public final String toString() {
        long j10 = this.f20516a;
        return "EventRecord{eventType=3, eventTimestamp=" + j10 + "}";
    }
}
