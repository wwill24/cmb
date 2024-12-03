package com.coffeemeetsbagel.subscription_dialog.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.coffeemeetsbagel.R;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class x extends CardView {

    /* renamed from: k  reason: collision with root package name */
    private final ViewGroup f37073k;

    /* renamed from: l  reason: collision with root package name */
    private final ViewGroup f37074l;

    /* renamed from: m  reason: collision with root package name */
    private final TextView f37075m;

    /* renamed from: n  reason: collision with root package name */
    private final View f37076n;

    /* renamed from: p  reason: collision with root package name */
    private final TextView f37077p;

    /* renamed from: q  reason: collision with root package name */
    private final TextView f37078q;

    /* renamed from: t  reason: collision with root package name */
    private final TextView f37079t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(Context context) {
        super(context);
        j.g(context, IdentityHttpResponse.CONTEXT);
        View.inflate(getContext(), R.layout.component_subscription_dialog, this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(R.dimen.baseline_2x, R.dimen.baseline_2x, R.dimen.baseline_2x, R.dimen.baseline_2x);
        setLayoutParams(layoutParams);
        setBackgroundResource(R.drawable.rounded_solid_white_12dp);
        setRadius(getResources().getDimension(R.dimen.corner_radius));
        setUseCompatPadding(true);
        setPreventCornerOverlap(true);
        View findViewById = findViewById(R.id.benefits_carousel);
        j.f(findViewById, "findViewById(R.id.benefits_carousel)");
        this.f37073k = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.variants_carousel);
        j.f(findViewById2, "findViewById(R.id.variants_carousel)");
        this.f37074l = (ViewGroup) findViewById2;
        View findViewById3 = findViewById(R.id.subscription_cta);
        j.f(findViewById3, "findViewById(R.id.subscription_cta)");
        this.f37075m = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.cancel_cta);
        j.f(findViewById4, "findViewById(R.id.cancel_cta)");
        this.f37076n = findViewById4;
        View findViewById5 = findViewById(R.id.disclaimer);
        j.f(findViewById5, "findViewById(R.id.disclaimer)");
        this.f37077p = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.debug_view);
        j.f(findViewById6, "findViewById(R.id.debug_view)");
        this.f37078q = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.buy_more_beans);
        j.f(findViewById7, "findViewById(R.id.buy_more_beans)");
        this.f37079t = (TextView) findViewById7;
    }

    public final ViewGroup getBenefitsContainer() {
        return this.f37073k;
    }

    public final TextView getBuyMoreBeansView() {
        return this.f37079t;
    }

    public final View getCancelCta() {
        return this.f37076n;
    }

    public final TextView getDebugView() {
        return this.f37078q;
    }

    public final TextView getDisclaimer() {
        return this.f37077p;
    }

    public final TextView getSubscriptionCta() {
        return this.f37075m;
    }

    public final ViewGroup getVariantsContainer() {
        return this.f37074l;
    }
}
