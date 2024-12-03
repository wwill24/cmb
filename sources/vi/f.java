package vi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import ti.i;
import z1.a;

public final class f implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f33912a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f33913b;

    private f(@NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.f33912a = imageView;
        this.f33913b = imageView2;
    }

    @NonNull
    public static f a(@NonNull View view) {
        if (view != null) {
            ImageView imageView = (ImageView) view;
            return new f(imageView, imageView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static f c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.pi2_ui_image_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ImageView getRoot() {
        return this.f33912a;
    }
}
