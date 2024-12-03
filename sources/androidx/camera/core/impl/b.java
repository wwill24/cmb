package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;

final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceConfig f2463a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2464b;

    /* renamed from: c  reason: collision with root package name */
    private final Size f2465c;

    /* renamed from: d  reason: collision with root package name */
    private final Range<Integer> f2466d;

    b(SurfaceConfig surfaceConfig, int i10, Size size, Range<Integer> range) {
        if (surfaceConfig != null) {
            this.f2463a = surfaceConfig;
            this.f2464b = i10;
            if (size != null) {
                this.f2465c = size;
                this.f2466d = range;
                return;
            }
            throw new NullPointerException("Null size");
        }
        throw new NullPointerException("Null surfaceConfig");
    }

    public int b() {
        return this.f2464b;
    }

    @NonNull
    public Size c() {
        return this.f2465c;
    }

    @NonNull
    public SurfaceConfig d() {
        return this.f2463a;
    }

    public Range<Integer> e() {
        return this.f2466d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f2463a.equals(aVar.d()) && this.f2464b == aVar.b() && this.f2465c.equals(aVar.c())) {
            Range<Integer> range = this.f2466d;
            if (range == null) {
                if (aVar.e() == null) {
                    return true;
                }
            } else if (range.equals(aVar.e())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = (((((this.f2463a.hashCode() ^ 1000003) * 1000003) ^ this.f2464b) * 1000003) ^ this.f2465c.hashCode()) * 1000003;
        Range<Integer> range = this.f2466d;
        if (range == null) {
            i10 = 0;
        } else {
            i10 = range.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.f2463a + ", imageFormat=" + this.f2464b + ", size=" + this.f2465c + ", targetFrameRate=" + this.f2466d + "}";
    }
}
