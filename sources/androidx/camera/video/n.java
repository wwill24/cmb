package androidx.camera.video;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.camera.video.f;
import androidx.camera.video.internal.encoder.l;
import androidx.camera.video.j0;
import java.util.Objects;

public abstract class n {

    public static abstract class a {
        a() {
        }

        @NonNull
        public abstract n a();

        @NonNull
        public a b(@NonNull androidx.core.util.a<j0.a> aVar) {
            j0.a f10 = c().f();
            aVar.accept(f10);
            f(f10.a());
            return this;
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"KotlinPropertyAccess"})
        public abstract j0 c();

        @NonNull
        public abstract a d(@NonNull a aVar);

        @NonNull
        public abstract a e(int i10);

        @NonNull
        public abstract a f(@NonNull j0 j0Var);
    }

    n() {
    }

    @NonNull
    public static a a() {
        return new f.b().e(-1).d(a.a().a()).f(j0.a().a());
    }

    @NonNull
    public static String e(int i10) {
        return i10 != 1 ? "audio/mp4a-latm" : "audio/vorbis";
    }

    public static int f(int i10) {
        if (Objects.equals(e(i10), "audio/mp4a-latm")) {
            return 2;
        }
        return l.f3328a;
    }

    static int g(int i10) {
        return i10 != 1 ? 0 : 1;
    }

    @NonNull
    public static String h(int i10) {
        return i10 != 1 ? "video/avc" : "video/x-vnd.on2.vp8";
    }

    @NonNull
    public abstract a b();

    public abstract int c();

    @NonNull
    public abstract j0 d();

    @NonNull
    public abstract a i();
}
