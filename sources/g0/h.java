package g0;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.m;
import androidx.camera.video.internal.encoder.l;
import g0.g;

public abstract class h {

    public static abstract class a {
        @NonNull
        public abstract h a();

        @NonNull
        public abstract a b(m mVar);

        @NonNull
        public abstract a c(int i10);
    }

    @NonNull
    public static a a(@NonNull String str) {
        return new g.b().d(str).c(l.f3328a);
    }

    public abstract m b();

    @NonNull
    public abstract String c();

    public abstract int d();
}
