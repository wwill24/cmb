package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import u.f;
import zf.a;

public final class y0 extends DeferrableSurface {

    /* renamed from: m  reason: collision with root package name */
    private final Surface f2716m;

    public y0(@NonNull Surface surface, @NonNull Size size, int i10) {
        super(size, i10);
        this.f2716m = surface;
    }

    @NonNull
    public a<Surface> n() {
        return f.h(this.f2716m);
    }

    public y0(@NonNull Surface surface) {
        this.f2716m = surface;
    }
}
