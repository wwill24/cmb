package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;

public abstract class z1 {
    z1() {
    }

    @NonNull
    public static z1 a(@NonNull Size size, @NonNull Size size2, @NonNull Size size3) {
        return new k(size, size2, size3);
    }

    @NonNull
    public abstract Size b();

    @NonNull
    public abstract Size c();

    @NonNull
    public abstract Size d();
}
