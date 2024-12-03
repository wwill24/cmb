package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;

final class i extends SurfaceOutput.a {

    /* renamed from: a  reason: collision with root package name */
    private final int f2341a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceOutput f2342b;

    i(int i10, SurfaceOutput surfaceOutput) {
        this.f2341a = i10;
        if (surfaceOutput != null) {
            this.f2342b = surfaceOutput;
            return;
        }
        throw new NullPointerException("Null surfaceOutput");
    }

    public int a() {
        return this.f2341a;
    }

    @NonNull
    public SurfaceOutput b() {
        return this.f2342b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceOutput.a)) {
            return false;
        }
        SurfaceOutput.a aVar = (SurfaceOutput.a) obj;
        if (this.f2341a != aVar.a() || !this.f2342b.equals(aVar.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f2341a ^ 1000003) * 1000003) ^ this.f2342b.hashCode();
    }

    public String toString() {
        return "Event{eventCode=" + this.f2341a + ", surfaceOutput=" + this.f2342b + "}";
    }
}
