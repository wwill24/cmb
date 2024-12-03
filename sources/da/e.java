package da;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.likes_you.r0;
import com.coffeemeetsbagel.likes_you.s0;
import z1.a;
import z1.b;

public final class e implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f40582a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final AppCompatImageView f40583b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f40584c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f40585d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f40586e;

    private e(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull ConstraintLayout constraintLayout2, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2) {
        this.f40582a = constraintLayout;
        this.f40583b = appCompatImageView;
        this.f40584c = constraintLayout2;
        this.f40585d = cmbTextView;
        this.f40586e = cmbTextView2;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i10 = r0.upsell_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
        if (appCompatImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i10 = r0.upsell_top_cta;
            CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
            if (cmbTextView != null) {
                i10 = r0.upsell_top_text;
                CmbTextView cmbTextView2 = (CmbTextView) b.a(view, i10);
                if (cmbTextView2 != null) {
                    return new e(constraintLayout, appCompatImageView, constraintLayout, cmbTextView, cmbTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static e c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(s0.list_item_upsell, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f40582a;
    }
}
