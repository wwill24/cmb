package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.annotation.NonNull;
import java.util.Objects;

public class j1 extends a1 implements i1 {

    /* renamed from: c  reason: collision with root package name */
    private final MediaCodecInfo.VideoCapabilities f3325c;

    j1(@NonNull MediaCodecInfo mediaCodecInfo, @NonNull String str) throws InvalidConfigException {
        super(mediaCodecInfo, str);
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.f3254b.getVideoCapabilities();
        Objects.requireNonNull(videoCapabilities);
        MediaCodecInfo.VideoCapabilities videoCapabilities2 = videoCapabilities;
        this.f3325c = videoCapabilities;
    }

    @NonNull
    public static j1 h(@NonNull h1 h1Var) throws InvalidConfigException {
        return new j1(a1.g(h1Var), h1Var.b());
    }

    @NonNull
    private static IllegalArgumentException i(@NonNull Throwable th2) {
        if (th2 instanceof IllegalArgumentException) {
            return (IllegalArgumentException) th2;
        }
        return new IllegalArgumentException(th2);
    }

    @NonNull
    public Range<Integer> a(int i10) {
        try {
            return this.f3325c.getSupportedWidthsFor(i10);
        } catch (Throwable th2) {
            throw i(th2);
        }
    }

    public int b() {
        return this.f3325c.getHeightAlignment();
    }

    public int c() {
        return this.f3325c.getWidthAlignment();
    }

    @NonNull
    public Range<Integer> d(int i10) {
        try {
            return this.f3325c.getSupportedHeightsFor(i10);
        } catch (Throwable th2) {
            throw i(th2);
        }
    }

    @NonNull
    public Range<Integer> e() {
        return this.f3325c.getSupportedWidths();
    }

    @NonNull
    public Range<Integer> f() {
        return this.f3325c.getSupportedHeights();
    }
}
