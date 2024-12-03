package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.e;
import androidx.camera.core.impl.Config;
import java.util.List;

public interface v0 extends s1 {

    /* renamed from: g  reason: collision with root package name */
    public static final Config.a<Integer> f2689g = Config.a.a("camerax.core.imageOutput.targetAspectRatio", e.class);

    /* renamed from: h  reason: collision with root package name */
    public static final Config.a<Integer> f2690h;

    /* renamed from: i  reason: collision with root package name */
    public static final Config.a<Integer> f2691i;

    /* renamed from: j  reason: collision with root package name */
    public static final Config.a<Size> f2692j = Config.a.a("camerax.core.imageOutput.targetResolution", Size.class);

    /* renamed from: k  reason: collision with root package name */
    public static final Config.a<Size> f2693k = Config.a.a("camerax.core.imageOutput.defaultResolution", Size.class);

    /* renamed from: l  reason: collision with root package name */
    public static final Config.a<Size> f2694l = Config.a.a("camerax.core.imageOutput.maxResolution", Size.class);

    /* renamed from: m  reason: collision with root package name */
    public static final Config.a<List<Pair<Integer, Size[]>>> f2695m = Config.a.a("camerax.core.imageOutput.supportedResolutions", List.class);

    static {
        Class cls = Integer.TYPE;
        f2690h = Config.a.a("camerax.core.imageOutput.targetRotation", cls);
        f2691i = Config.a.a("camerax.core.imageOutput.appTargetRotation", cls);
    }

    Size B(Size size) {
        return (Size) g(f2692j, size);
    }

    Size i(Size size) {
        return (Size) g(f2694l, size);
    }

    List<Pair<Integer, Size[]>> k(List<Pair<Integer, Size[]>> list) {
        return (List) g(f2695m, list);
    }

    int r(int i10) {
        return ((Integer) g(f2691i, Integer.valueOf(i10))).intValue();
    }

    boolean u() {
        return b(f2689g);
    }

    int x() {
        return ((Integer) a(f2689g)).intValue();
    }

    int y(int i10) {
        return ((Integer) g(f2690h, Integer.valueOf(i10))).intValue();
    }

    Size z(Size size) {
        return (Size) g(f2693k, size);
    }
}
