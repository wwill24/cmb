package ub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.store.n0;
import com.coffeemeetsbagel.store.o0;
import z1.a;
import z1.b;

public final class j implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f42011a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f42012b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbButton f42013c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f42014d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f42015e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final NestedScrollView f42016f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CmbTextView f42017g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final CmbTextView f42018h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f42019j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final CmbTextView f42020k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final CmbTextView f42021l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final RecyclerView f42022m;

    private j(@NonNull ConstraintLayout constraintLayout, @NonNull CmbTextView cmbTextView, @NonNull CmbButton cmbButton, @NonNull CmbTextView cmbTextView2, @NonNull ConstraintLayout constraintLayout2, @NonNull NestedScrollView nestedScrollView, @NonNull CmbTextView cmbTextView3, @NonNull CmbTextView cmbTextView4, @NonNull CmbTextView cmbTextView5, @NonNull CmbTextView cmbTextView6, @NonNull CmbTextView cmbTextView7, @NonNull RecyclerView recyclerView) {
        this.f42011a = constraintLayout;
        this.f42012b = cmbTextView;
        this.f42013c = cmbButton;
        this.f42014d = cmbTextView2;
        this.f42015e = constraintLayout2;
        this.f42016f = nestedScrollView;
        this.f42017g = cmbTextView3;
        this.f42018h = cmbTextView4;
        this.f42019j = cmbTextView5;
        this.f42020k = cmbTextView6;
        this.f42021l = cmbTextView7;
        this.f42022m = recyclerView;
    }

    @NonNull
    public static j a(@NonNull View view) {
        int i10 = n0.billing_cycle;
        CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
        if (cmbTextView != null) {
            i10 = n0.cta_primary;
            CmbButton cmbButton = (CmbButton) b.a(view, i10);
            if (cmbButton != null) {
                i10 = n0.cta_secondary;
                CmbTextView cmbTextView2 = (CmbTextView) b.a(view, i10);
                if (cmbTextView2 != null) {
                    i10 = n0.footer_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) b.a(view, i10);
                    if (constraintLayout != null) {
                        i10 = n0.list_container;
                        NestedScrollView nestedScrollView = (NestedScrollView) b.a(view, i10);
                        if (nestedScrollView != null) {
                            i10 = n0.monthly_price;
                            CmbTextView cmbTextView3 = (CmbTextView) b.a(view, i10);
                            if (cmbTextView3 != null) {
                                i10 = n0.recurring_billing;
                                CmbTextView cmbTextView4 = (CmbTextView) b.a(view, i10);
                                if (cmbTextView4 != null) {
                                    i10 = n0.sale_ends_counter;
                                    CmbTextView cmbTextView5 = (CmbTextView) b.a(view, i10);
                                    if (cmbTextView5 != null) {
                                        i10 = n0.title;
                                        CmbTextView cmbTextView6 = (CmbTextView) b.a(view, i10);
                                        if (cmbTextView6 != null) {
                                            i10 = n0.title_description;
                                            CmbTextView cmbTextView7 = (CmbTextView) b.a(view, i10);
                                            if (cmbTextView7 != null) {
                                                i10 = n0.variant_list;
                                                RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
                                                if (recyclerView != null) {
                                                    return new j((ConstraintLayout) view, cmbTextView, cmbButton, cmbTextView2, constraintLayout, nestedScrollView, cmbTextView3, cmbTextView4, cmbTextView5, cmbTextView6, cmbTextView7, recyclerView);
                                                }
                                            }
                                        }
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
    public static j c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(o0.subscription_variants, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f42011a;
    }
}
