package ub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.store.n0;
import com.coffeemeetsbagel.store.o0;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f41952a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final LottieAnimationView f41953b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbButton f41954c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f41955d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbImageView f41956e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbTextView f41957f;

    private a(@NonNull FrameLayout frameLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull CmbButton cmbButton, @NonNull CmbTextView cmbTextView, @NonNull CmbImageView cmbImageView, @NonNull CmbTextView cmbTextView2) {
        this.f41952a = frameLayout;
        this.f41953b = lottieAnimationView;
        this.f41954c = cmbButton;
        this.f41955d = cmbTextView;
        this.f41956e = cmbImageView;
        this.f41957f = cmbTextView2;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = n0.celebration_dialog_animation;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b.a(view, i10);
        if (lottieAnimationView != null) {
            i10 = n0.celebration_dialog_button;
            CmbButton cmbButton = (CmbButton) b.a(view, i10);
            if (cmbButton != null) {
                i10 = n0.celebration_dialog_description;
                CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
                if (cmbTextView != null) {
                    i10 = n0.celebration_dialog_image;
                    CmbImageView cmbImageView = (CmbImageView) b.a(view, i10);
                    if (cmbImageView != null) {
                        i10 = n0.celebration_dialog_title;
                        CmbTextView cmbTextView2 = (CmbTextView) b.a(view, i10);
                        if (cmbTextView2 != null) {
                            return new a((FrameLayout) view, lottieAnimationView, cmbButton, cmbTextView, cmbImageView, cmbTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(o0.celebration_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f41952a;
    }
}
