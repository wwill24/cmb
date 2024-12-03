package androidx.camera.video;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<Integer> f3080a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{2, 3})));

    b() {
    }

    @NonNull
    static b c(int i10, Throwable th2) {
        return new d(i10, th2);
    }

    public abstract int a();

    public abstract Throwable b();
}
