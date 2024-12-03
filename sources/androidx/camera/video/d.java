package androidx.camera.video;

final class d extends b {

    /* renamed from: b  reason: collision with root package name */
    private final int f3091b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f3092c;

    d(int i10, Throwable th2) {
        this.f3091b = i10;
        this.f3092c = th2;
    }

    public int a() {
        return this.f3091b;
    }

    public Throwable b() {
        return this.f3092c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f3091b == bVar.a()) {
            Throwable th2 = this.f3092c;
            if (th2 == null) {
                if (bVar.b() == null) {
                    return true;
                }
            } else if (th2.equals(bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int i11 = (this.f3091b ^ 1000003) * 1000003;
        Throwable th2 = this.f3092c;
        if (th2 == null) {
            i10 = 0;
        } else {
            i10 = th2.hashCode();
        }
        return i11 ^ i10;
    }

    public String toString() {
        return "AudioStats{audioState=" + this.f3091b + ", errorCause=" + this.f3092c + "}";
    }
}
