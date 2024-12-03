package v;

final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final float f18029a;

    /* renamed from: b  reason: collision with root package name */
    private final float f18030b;

    /* renamed from: c  reason: collision with root package name */
    private final float f18031c;

    /* renamed from: d  reason: collision with root package name */
    private final float f18032d;

    a(float f10, float f11, float f12, float f13) {
        this.f18029a = f10;
        this.f18030b = f11;
        this.f18031c = f12;
        this.f18032d = f13;
    }

    public float a() {
        return this.f18030b;
    }

    public float b() {
        return this.f18032d;
    }

    public float c() {
        return this.f18031c;
    }

    public float d() {
        return this.f18029a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (Float.floatToIntBits(this.f18029a) == Float.floatToIntBits(fVar.d()) && Float.floatToIntBits(this.f18030b) == Float.floatToIntBits(fVar.a()) && Float.floatToIntBits(this.f18031c) == Float.floatToIntBits(fVar.c()) && Float.floatToIntBits(this.f18032d) == Float.floatToIntBits(fVar.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((Float.floatToIntBits(this.f18029a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.f18030b)) * 1000003) ^ Float.floatToIntBits(this.f18031c)) * 1000003) ^ Float.floatToIntBits(this.f18032d);
    }

    public String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.f18029a + ", maxZoomRatio=" + this.f18030b + ", minZoomRatio=" + this.f18031c + ", linearZoom=" + this.f18032d + "}";
    }
}
