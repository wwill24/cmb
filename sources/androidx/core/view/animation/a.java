package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;

public final class a {

    /* renamed from: androidx.core.view.animation.a$a  reason: collision with other inner class name */
    static class C0046a {
        static PathInterpolator a(float f10, float f11) {
            return new PathInterpolator(f10, f11);
        }

        static PathInterpolator b(float f10, float f11, float f12, float f13) {
            return new PathInterpolator(f10, f11, f12, f13);
        }

        static PathInterpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    @NonNull
    public static Interpolator a(float f10, float f11, float f12, float f13) {
        return C0046a.b(f10, f11, f12, f13);
    }

    @NonNull
    public static Interpolator b(@NonNull Path path) {
        return C0046a.c(path);
    }
}
