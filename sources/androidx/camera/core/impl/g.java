package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;

final class g extends o1 {

    /* renamed from: a  reason: collision with root package name */
    private final Surface f2532a;

    /* renamed from: b  reason: collision with root package name */
    private final Size f2533b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2534c;

    g(Surface surface, Size size, int i10) {
        if (surface != null) {
            this.f2532a = surface;
            if (size != null) {
                this.f2533b = size;
                this.f2534c = i10;
                return;
            }
            throw new NullPointerException("Null size");
        }
        throw new NullPointerException("Null surface");
    }

    public int b() {
        return this.f2534c;
    }

    @NonNull
    public Size c() {
        return this.f2533b;
    }

    @NonNull
    public Surface d() {
        return this.f2532a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        if (!this.f2532a.equals(o1Var.d()) || !this.f2533b.equals(o1Var.c()) || this.f2534c != o1Var.b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.f2532a.hashCode() ^ 1000003) * 1000003) ^ this.f2533b.hashCode()) * 1000003) ^ this.f2534c;
    }

    public String toString() {
        return "OutputSurface{surface=" + this.f2532a + ", size=" + this.f2533b + ", imageFormat=" + this.f2534c + "}";
    }
}
