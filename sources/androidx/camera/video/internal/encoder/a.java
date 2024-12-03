package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.c;
import java.util.Objects;

public abstract class a implements l {

    /* renamed from: androidx.camera.video.internal.encoder.a$a  reason: collision with other inner class name */
    public static abstract class C0024a {
        C0024a() {
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract a a();

        @NonNull
        public a b() {
            a a10 = a();
            if (!Objects.equals(a10.b(), "audio/mp4a-latm") || a10.g() != l.f3328a) {
                return a10;
            }
            throw new IllegalArgumentException("Encoder mime set to AAC, but no AAC profile was provided.");
        }

        @NonNull
        public abstract C0024a c(int i10);

        @NonNull
        public abstract C0024a d(int i10);

        @NonNull
        public abstract C0024a e(@NonNull Timebase timebase);

        @NonNull
        public abstract C0024a f(@NonNull String str);

        @NonNull
        public abstract C0024a g(int i10);

        @NonNull
        public abstract C0024a h(int i10);
    }

    a() {
    }

    @NonNull
    public static C0024a d() {
        return new c.b().g(l.f3328a);
    }

    @NonNull
    public MediaFormat a() {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(b(), h(), f());
        createAudioFormat.setInteger("bitrate", e());
        if (g() != l.f3328a) {
            if (b().equals("audio/mp4a-latm")) {
                createAudioFormat.setInteger("aac-profile", g());
            } else {
                createAudioFormat.setInteger("profile", g());
            }
        }
        return createAudioFormat;
    }

    @NonNull
    public abstract String b();

    @NonNull
    public abstract Timebase c();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();
}
