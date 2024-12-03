package ii;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;
import com.withpersona.sdk2.inquiry.document.k;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f29950a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ThemeableLottieAnimationView f29951b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final MaterialCardView f29952c;

    private b(@NonNull ConstraintLayout constraintLayout, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView, @NonNull MaterialCardView materialCardView) {
        this.f29950a = constraintLayout;
        this.f29951b = themeableLottieAnimationView;
        this.f29952c = materialCardView;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = k.add_button;
        ThemeableLottieAnimationView themeableLottieAnimationView = (ThemeableLottieAnimationView) z1.b.a(view, i10);
        if (themeableLottieAnimationView != null) {
            i10 = k.card_view;
            MaterialCardView materialCardView = (MaterialCardView) z1.b.a(view, i10);
            if (materialCardView != null) {
                return new b((ConstraintLayout) view, themeableLottieAnimationView, materialCardView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f29950a;
    }
}
