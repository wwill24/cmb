package ub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.store.n0;
import com.coffeemeetsbagel.store.o0;
import z1.a;
import z1.b;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f41963a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f41964b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f41965c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f41966d;

    private c(@NonNull ConstraintLayout constraintLayout, @NonNull CmbTextView cmbTextView, @NonNull ImageView imageView, @NonNull CmbTextView cmbTextView2) {
        this.f41963a = constraintLayout;
        this.f41964b = cmbTextView;
        this.f41965c = imageView;
        this.f41966d = cmbTextView2;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i10 = n0.description;
        CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
        if (cmbTextView != null) {
            i10 = n0.image;
            ImageView imageView = (ImageView) b.a(view, i10);
            if (imageView != null) {
                i10 = n0.title;
                CmbTextView cmbTextView2 = (CmbTextView) b.a(view, i10);
                if (cmbTextView2 != null) {
                    return new c((ConstraintLayout) view, cmbTextView, imageView, cmbTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(o0.subscription_benefit_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f41963a;
    }
}
