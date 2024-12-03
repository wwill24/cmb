package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.SurfaceConfig;

final class j extends SurfaceConfig {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceConfig.ConfigType f2550a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceConfig.ConfigSize f2551b;

    j(SurfaceConfig.ConfigType configType, SurfaceConfig.ConfigSize configSize) {
        if (configType != null) {
            this.f2550a = configType;
            if (configSize != null) {
                this.f2551b = configSize;
                return;
            }
            throw new NullPointerException("Null configSize");
        }
        throw new NullPointerException("Null configType");
    }

    @NonNull
    public SurfaceConfig.ConfigSize b() {
        return this.f2551b;
    }

    @NonNull
    public SurfaceConfig.ConfigType c() {
        return this.f2550a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceConfig)) {
            return false;
        }
        SurfaceConfig surfaceConfig = (SurfaceConfig) obj;
        if (!this.f2550a.equals(surfaceConfig.c()) || !this.f2551b.equals(surfaceConfig.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f2550a.hashCode() ^ 1000003) * 1000003) ^ this.f2551b.hashCode();
    }

    public String toString() {
        return "SurfaceConfig{configType=" + this.f2550a + ", configSize=" + this.f2551b + "}";
    }
}
