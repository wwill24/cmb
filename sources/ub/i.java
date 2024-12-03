package ub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.store.n0;
import com.coffeemeetsbagel.store.o0;
import z1.a;
import z1.b;

public final class i implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f42002a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f42003b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f42004c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f42005d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f42006e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbTextView f42007f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CmbTextView f42008g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final CmbTextView f42009h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f42010j;

    private i(@NonNull FrameLayout frameLayout, @NonNull CmbTextView cmbTextView, @NonNull ConstraintLayout constraintLayout, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3, @NonNull CmbTextView cmbTextView4, @NonNull CmbTextView cmbTextView5, @NonNull CmbTextView cmbTextView6, @NonNull CmbTextView cmbTextView7) {
        this.f42002a = frameLayout;
        this.f42003b = cmbTextView;
        this.f42004c = constraintLayout;
        this.f42005d = cmbTextView2;
        this.f42006e = cmbTextView3;
        this.f42007f = cmbTextView4;
        this.f42008g = cmbTextView5;
        this.f42009h = cmbTextView6;
        this.f42010j = cmbTextView7;
    }

    @NonNull
    public static i a(@NonNull View view) {
        int i10 = n0.billing_cycle;
        CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
        if (cmbTextView != null) {
            i10 = n0.content_main;
            ConstraintLayout constraintLayout = (ConstraintLayout) b.a(view, i10);
            if (constraintLayout != null) {
                i10 = n0.duration;
                CmbTextView cmbTextView2 = (CmbTextView) b.a(view, i10);
                if (cmbTextView2 != null) {
                    i10 = n0.monthly_price;
                    CmbTextView cmbTextView3 = (CmbTextView) b.a(view, i10);
                    if (cmbTextView3 != null) {
                        i10 = n0.on_sale_variant_tag;
                        CmbTextView cmbTextView4 = (CmbTextView) b.a(view, i10);
                        if (cmbTextView4 != null) {
                            i10 = n0.price_compare;
                            CmbTextView cmbTextView5 = (CmbTextView) b.a(view, i10);
                            if (cmbTextView5 != null) {
                                i10 = n0.recommended_variant_tag;
                                CmbTextView cmbTextView6 = (CmbTextView) b.a(view, i10);
                                if (cmbTextView6 != null) {
                                    i10 = n0.total_price;
                                    CmbTextView cmbTextView7 = (CmbTextView) b.a(view, i10);
                                    if (cmbTextView7 != null) {
                                        return new i((FrameLayout) view, cmbTextView, constraintLayout, cmbTextView2, cmbTextView3, cmbTextView4, cmbTextView5, cmbTextView6, cmbTextView7);
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
    public static i c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(o0.subscription_variant_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f42002a;
    }
}
