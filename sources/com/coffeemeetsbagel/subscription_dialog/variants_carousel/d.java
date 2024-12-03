package com.coffeemeetsbagel.subscription_dialog.variants_carousel;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class d extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private CmbTextView f37088a = ((CmbTextView) findViewById(R.id.subscription_duration_popular));

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f37089b;

    /* renamed from: c  reason: collision with root package name */
    private CmbTextView f37090c;

    /* renamed from: d  reason: collision with root package name */
    private CmbTextView f37091d;

    /* renamed from: e  reason: collision with root package name */
    private CmbTextView f37092e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f37093f;

    /* renamed from: g  reason: collision with root package name */
    private View f37094g;

    /* renamed from: h  reason: collision with root package name */
    private View f37095h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        CmbTextView cmbTextView;
        CmbTextView cmbTextView2;
        CmbTextView cmbTextView3;
        CmbTextView cmbTextView4;
        View view;
        j.g(context, IdentityHttpResponse.CONTEXT);
        View.inflate(getContext(), R.layout.subscription_variant_view, this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
        setOrientation(1);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.subscription_duration_selector_container);
        this.f37093f = linearLayout;
        View view2 = null;
        if (linearLayout != null) {
            cmbTextView = (CmbTextView) linearLayout.findViewById(R.id.subscription_duration_duration);
        } else {
            cmbTextView = null;
        }
        this.f37089b = cmbTextView;
        LinearLayout linearLayout2 = this.f37093f;
        if (linearLayout2 != null) {
            cmbTextView2 = (CmbTextView) linearLayout2.findViewById(R.id.subscription_duration_monthly_cost);
        } else {
            cmbTextView2 = null;
        }
        this.f37091d = cmbTextView2;
        LinearLayout linearLayout3 = this.f37093f;
        if (linearLayout3 != null) {
            cmbTextView3 = (CmbTextView) linearLayout3.findViewById(R.id.subscription_duration_total_cost);
        } else {
            cmbTextView3 = null;
        }
        this.f37090c = cmbTextView3;
        LinearLayout linearLayout4 = this.f37093f;
        if (linearLayout4 != null) {
            cmbTextView4 = (CmbTextView) linearLayout4.findViewById(R.id.subscription_duration_save);
        } else {
            cmbTextView4 = null;
        }
        this.f37092e = cmbTextView4;
        LinearLayout linearLayout5 = this.f37093f;
        if (linearLayout5 != null) {
            view = linearLayout5.findViewById(R.id.subscription_duration_top_divider);
        } else {
            view = null;
        }
        this.f37094g = view;
        LinearLayout linearLayout6 = this.f37093f;
        this.f37095h = linearLayout6 != null ? linearLayout6.findViewById(R.id.subscription_duration_bottom_divider) : view2;
    }

    public final void a() {
        LinearLayout linearLayout = this.f37093f;
        if (linearLayout != null) {
            linearLayout.setSelected(false);
        }
        CmbTextView cmbTextView = this.f37088a;
        if (cmbTextView != null) {
            cmbTextView.setVisibility(4);
        }
        View view = this.f37094g;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.f37095h;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    public final LinearLayout getBackgroundContainer() {
        return this.f37093f;
    }

    public final CmbTextView getDuration() {
        return this.f37089b;
    }

    public final CmbTextView getMarketingLabel() {
        return this.f37088a;
    }

    public final CmbTextView getMonthlyCost() {
        return this.f37091d;
    }

    public final CmbTextView getSavingsComparisonRate() {
        return this.f37092e;
    }

    public final CmbTextView getTotalCost() {
        return this.f37090c;
    }

    public final void setAsSelected(String str) {
        CmbTextView cmbTextView;
        LinearLayout linearLayout = this.f37093f;
        if (linearLayout != null) {
            linearLayout.setSelected(true);
        }
        if (!(str == null || (cmbTextView = this.f37088a) == null)) {
            cmbTextView.setVisibility(0);
        }
        View view = this.f37094g;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.f37095h;
        if (view2 != null) {
            view2.setVisibility(4);
        }
    }

    public final void setBackgroundContainer(LinearLayout linearLayout) {
        this.f37093f = linearLayout;
    }

    public final void setDuration(CmbTextView cmbTextView) {
        this.f37089b = cmbTextView;
    }

    public final void setMarketingLabel(CmbTextView cmbTextView) {
        this.f37088a = cmbTextView;
    }

    public final void setMonthlyCost(CmbTextView cmbTextView) {
        this.f37091d = cmbTextView;
    }

    public final void setSavingsComparisonRate(CmbTextView cmbTextView) {
        this.f37092e = cmbTextView;
    }

    public final void setTotalCost(CmbTextView cmbTextView) {
        this.f37090c = cmbTextView;
    }
}
