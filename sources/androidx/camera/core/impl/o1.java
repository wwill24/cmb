package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;

public abstract class o1 {
    @NonNull
    public static o1 a(@NonNull Surface surface, @NonNull Size size, int i10) {
        return new g(surface, size, i10);
    }

    public abstract int b();

    @NonNull
    public abstract Size c();

    @NonNull
    public abstract Surface d();
}
