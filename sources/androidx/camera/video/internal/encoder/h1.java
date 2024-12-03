package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.d;

public abstract class h1 implements l {

    public static abstract class a {
        a() {
        }

        @NonNull
        public abstract h1 a();

        @NonNull
        public abstract a b(int i10);

        @NonNull
        public abstract a c(int i10);

        @NonNull
        public abstract a d(int i10);

        @NonNull
        public abstract a e(int i10);

        @NonNull
        public abstract a f(@NonNull Timebase timebase);

        @NonNull
        public abstract a g(@NonNull String str);

        @NonNull
        public abstract a h(@NonNull Size size);
    }

    h1() {
    }

    @NonNull
    public static a d() {
        return new d.b().i(l.f3328a).e(1).c(2130708361);
    }

    @NonNull
    public MediaFormat a() {
        Size j10 = j();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(b(), j10.getWidth(), j10.getHeight());
        createVideoFormat.setInteger("color-format", f());
        createVideoFormat.setInteger("bitrate", e());
        createVideoFormat.setInteger("frame-rate", g());
        createVideoFormat.setInteger("i-frame-interval", h());
        if (i() != l.f3328a) {
            createVideoFormat.setInteger("profile", i());
        }
        return createVideoFormat;
    }

    @NonNull
    public abstract String b();

    @NonNull
    public abstract Timebase c();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    @NonNull
    public abstract Size j();
}
