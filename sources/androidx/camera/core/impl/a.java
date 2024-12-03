package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;

public abstract class a {
    a() {
    }

    @NonNull
    public static a a(@NonNull SurfaceConfig surfaceConfig, int i10, @NonNull Size size, Range<Integer> range) {
        return new b(surfaceConfig, i10, size, range);
    }

    public abstract int b();

    @NonNull
    public abstract Size c();

    @NonNull
    public abstract SurfaceConfig d();

    public abstract Range<Integer> e();
}
