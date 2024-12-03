package ub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public final class h implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f41993a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f41994b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbButton f41995c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbButton f41996d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f41997e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f41998f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f41999g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final NestedScrollView f42000h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f42001j;

    private h(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull CmbButton cmbButton, @NonNull CmbButton cmbButton2, @NonNull CmbTextView cmbTextView, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull NestedScrollView nestedScrollView, @NonNull CmbTextView cmbTextView2) {
        this.f41993a = constraintLayout;
        this.f41994b = recyclerView;
        this.f41995c = cmbButton;
        this.f41996d = cmbButton2;
        this.f41997e = cmbTextView;
        this.f41998f = constraintLayout2;
        this.f41999g = imageView;
        this.f42000h = nestedScrollView;
        this.f42001j = cmbTextView2;
    }

    @NonNull
    public static h a(@NonNull View view) {
        int i10 = n0.comparison_list;
        RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
        if (recyclerView != null) {
            i10 = n0.cta_primary;
            CmbButton cmbButton = (CmbButton) b.a(view, i10);
            if (cmbButton != null) {
                i10 = n0.cta_secondary;
                CmbButton cmbButton2 = (CmbButton) b.a(view, i10);
                if (cmbButton2 != null) {
                    i10 = n0.description;
                    CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
                    if (cmbTextView != null) {
                        i10 = n0.footer_container;
                        ConstraintLayout constraintLayout = (ConstraintLayout) b.a(view, i10);
                        if (constraintLayout != null) {
                            i10 = n0.header_image;
                            ImageView imageView = (ImageView) b.a(view, i10);
                            if (imageView != null) {
                                i10 = n0.list_container;
                                NestedScrollView nestedScrollView = (NestedScrollView) b.a(view, i10);
                                if (nestedScrollView != null) {
                                    i10 = n0.title;
                                    CmbTextView cmbTextView2 = (CmbTextView) b.a(view, i10);
                                    if (cmbTextView2 != null) {
                                        return new h((ConstraintLayout) view, recyclerView, cmbButton, cmbButton2, cmbTextView, constraintLayout, imageView, nestedScrollView, cmbTextView2);
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
    public static h c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(o0.subscription_comparisons, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f41993a;
    }
}
