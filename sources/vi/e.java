package vi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import ti.i;
import z1.a;

public final class e implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ThemeableLottieAnimationView f33910a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ThemeableLottieAnimationView f33911b;

    private e(@NonNull ThemeableLottieAnimationView themeableLottieAnimationView, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView2) {
        this.f33910a = themeableLottieAnimationView;
        this.f33911b = themeableLottieAnimationView2;
    }

    @NonNull
    public static e a(@NonNull View view) {
        if (view != null) {
            ThemeableLottieAnimationView themeableLottieAnimationView = (ThemeableLottieAnimationView) view;
            return new e(themeableLottieAnimationView, themeableLottieAnimationView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static e c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.pi2_ui_image_lottie, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ThemeableLottieAnimationView getRoot() {
        return this.f33910a;
    }
}
