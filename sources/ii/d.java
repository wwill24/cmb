package ii;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.withpersona.sdk2.inquiry.document.k;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import z1.a;
import z1.b;

public final class d implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f29963a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final MaterialCardView f29964b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29965c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f29966d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f29967e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CircularProgressIndicator f29968f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ThemeableLottieAnimationView f29969g;

    private d(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialCardView materialCardView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull CircularProgressIndicator circularProgressIndicator, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView) {
        this.f29963a = constraintLayout;
        this.f29964b = materialCardView;
        this.f29965c = textView;
        this.f29966d = imageView;
        this.f29967e = linearLayout;
        this.f29968f = circularProgressIndicator;
        this.f29969g = themeableLottieAnimationView;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i10 = k.card_view;
        MaterialCardView materialCardView = (MaterialCardView) b.a(view, i10);
        if (materialCardView != null) {
            i10 = k.filename_view;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                i10 = k.image_view;
                ImageView imageView = (ImageView) b.a(view, i10);
                if (imageView != null) {
                    i10 = k.image_view_container;
                    LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                    if (linearLayout != null) {
                        i10 = k.loading_animation;
                        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) b.a(view, i10);
                        if (circularProgressIndicator != null) {
                            i10 = k.remove_button;
                            ThemeableLottieAnimationView themeableLottieAnimationView = (ThemeableLottieAnimationView) b.a(view, i10);
                            if (themeableLottieAnimationView != null) {
                                return new d((ConstraintLayout) view, materialCardView, textView, imageView, linearLayout, circularProgressIndicator, themeableLottieAnimationView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f29963a;
    }
}
