package kc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.upsell_banner.e;
import com.coffeemeetsbagel.upsell_banner.f;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f41066a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbImageView f41067b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f41068c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f41069d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f41070e;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull CmbImageView cmbImageView, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2, @NonNull ConstraintLayout constraintLayout2) {
        this.f41066a = constraintLayout;
        this.f41067b = cmbImageView;
        this.f41068c = cmbTextView;
        this.f41069d = cmbTextView2;
        this.f41070e = constraintLayout2;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = e.close_button;
        CmbImageView cmbImageView = (CmbImageView) b.a(view, i10);
        if (cmbImageView != null) {
            i10 = e.cta;
            CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
            if (cmbTextView != null) {
                i10 = e.text_view;
                CmbTextView cmbTextView2 = (CmbTextView) b.a(view, i10);
                if (cmbTextView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new a(constraintLayout, cmbImageView, cmbTextView, cmbTextView2, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(f.upsell_banner, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f41066a;
    }
}
