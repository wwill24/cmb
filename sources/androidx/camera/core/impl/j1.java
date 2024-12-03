package androidx.camera.core.impl;

import androidx.annotation.NonNull;

public class j1<T> extends x1<T> {
    private j1(Object obj, boolean z10) {
        super(obj, z10);
    }

    @NonNull
    public static <T> j1<T> i(T t10) {
        return new j1<>(t10, false);
    }

    public void h(T t10) {
        f(t10);
    }
}
