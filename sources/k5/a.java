package k5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.boost.k;
import com.coffeemeetsbagel.boost.l;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15660a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbButton f15661b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15662c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbButton f15663d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f15664e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbTextView f15665f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CmbTextView f15666g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final CmbTextView f15667h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final AppCompatImageView f15668j;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull CmbButton cmbButton, @NonNull CmbTextView cmbTextView, @NonNull CmbButton cmbButton2, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3, @NonNull CmbTextView cmbTextView4, @NonNull CmbTextView cmbTextView5, @NonNull AppCompatImageView appCompatImageView) {
        this.f15660a = constraintLayout;
        this.f15661b = cmbButton;
        this.f15662c = cmbTextView;
        this.f15663d = cmbButton2;
        this.f15664e = cmbTextView2;
        this.f15665f = cmbTextView3;
        this.f15666g = cmbTextView4;
        this.f15667h = cmbTextView5;
        this.f15668j = appCompatImageView;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = k.cta_primary;
        CmbButton cmbButton = (CmbButton) b.a(view, i10);
        if (cmbButton != null) {
            i10 = k.cta_secondary;
            CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
            if (cmbTextView != null) {
                i10 = k.cta_subscribe;
                CmbButton cmbButton2 = (CmbButton) b.a(view, i10);
                if (cmbButton2 != null) {
                    i10 = k.description;
                    CmbTextView cmbTextView2 = (CmbTextView) b.a(view, i10);
                    if (cmbTextView2 != null) {
                        i10 = k.description_more;
                        CmbTextView cmbTextView3 = (CmbTextView) b.a(view, i10);
                        if (cmbTextView3 != null) {
                            i10 = k.grant_count;
                            CmbTextView cmbTextView4 = (CmbTextView) b.a(view, i10);
                            if (cmbTextView4 != null) {
                                i10 = k.header;
                                CmbTextView cmbTextView5 = (CmbTextView) b.a(view, i10);
                                if (cmbTextView5 != null) {
                                    i10 = k.icon;
                                    AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
                                    if (appCompatImageView != null) {
                                        return new a((ConstraintLayout) view, cmbButton, cmbTextView, cmbButton2, cmbTextView2, cmbTextView3, cmbTextView4, cmbTextView5, appCompatImageView);
                                    }
                                }
                            }
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
        View inflate = layoutInflater.inflate(l.boost_comp, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f15660a;
    }
}
