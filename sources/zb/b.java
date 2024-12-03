package zb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.like_pass.view.CustomFabLikeButton;
import com.coffeemeetsbagel.like_pass.view.SendFlowerButtonContainerView;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f42229a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CustomFabLikeButton f42230b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CustomFabLikeButton f42231c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CustomFabLikeButton f42232d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CustomFabLikeButton f42233e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CustomFabLikeButton f42234f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CmbTextView f42235g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final SendFlowerButtonContainerView f42236h;

    private b(@NonNull ConstraintLayout constraintLayout, @NonNull CustomFabLikeButton customFabLikeButton, @NonNull CustomFabLikeButton customFabLikeButton2, @NonNull CustomFabLikeButton customFabLikeButton3, @NonNull CustomFabLikeButton customFabLikeButton4, @NonNull CustomFabLikeButton customFabLikeButton5, @NonNull CmbTextView cmbTextView, @NonNull SendFlowerButtonContainerView sendFlowerButtonContainerView) {
        this.f42229a = constraintLayout;
        this.f42230b = customFabLikeButton;
        this.f42231c = customFabLikeButton2;
        this.f42232d = customFabLikeButton3;
        this.f42233e = customFabLikeButton4;
        this.f42234f = customFabLikeButton5;
        this.f42235g = cmbTextView;
        this.f42236h = sendFlowerButtonContainerView;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = yb.a.button_flower;
        CustomFabLikeButton customFabLikeButton = (CustomFabLikeButton) z1.b.a(view, i10);
        if (customFabLikeButton != null) {
            i10 = yb.a.button_like;
            CustomFabLikeButton customFabLikeButton2 = (CustomFabLikeButton) z1.b.a(view, i10);
            if (customFabLikeButton2 != null) {
                i10 = yb.a.button_pass;
                CustomFabLikeButton customFabLikeButton3 = (CustomFabLikeButton) z1.b.a(view, i10);
                if (customFabLikeButton3 != null) {
                    i10 = yb.a.button_rewind;
                    CustomFabLikeButton customFabLikeButton4 = (CustomFabLikeButton) z1.b.a(view, i10);
                    if (customFabLikeButton4 != null) {
                        i10 = yb.a.button_send_flower;
                        CustomFabLikeButton customFabLikeButton5 = (CustomFabLikeButton) z1.b.a(view, i10);
                        if (customFabLikeButton5 != null) {
                            i10 = yb.a.price_text;
                            CmbTextView cmbTextView = (CmbTextView) z1.b.a(view, i10);
                            if (cmbTextView != null) {
                                i10 = yb.a.send_flower_container;
                                SendFlowerButtonContainerView sendFlowerButtonContainerView = (SendFlowerButtonContainerView) z1.b.a(view, i10);
                                if (sendFlowerButtonContainerView != null) {
                                    return new b((ConstraintLayout) view, customFabLikeButton, customFabLikeButton2, customFabLikeButton3, customFabLikeButton4, customFabLikeButton5, cmbTextView, sendFlowerButtonContainerView);
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
    public static b c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(yb.b.history_match_container, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f42229a;
    }
}
