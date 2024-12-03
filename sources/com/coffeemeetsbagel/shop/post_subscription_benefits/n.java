package com.coffeemeetsbagel.shop.post_subscription_benefits;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.coffeemeetsbagel.R;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class n extends CardView {

    /* renamed from: k  reason: collision with root package name */
    private ViewGroup f36481k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(Context context) {
        super(context);
        j.g(context, IdentityHttpResponse.CONTEXT);
        View.inflate(getContext(), R.layout.shop_post_subscription_layout, this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.baseline_2x);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.baseline_1x);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        setLayoutParams(layoutParams);
        setRadius(getResources().getDimension(R.dimen.corner_radius));
        View findViewById = findViewById(R.id.premium_features);
        j.f(findViewById, "findViewById(R.id.premium_features)");
        this.f36481k = (ViewGroup) findViewById;
    }

    public final void e(View view) {
        j.g(view, "view");
        this.f36481k.addView(view);
    }

    public final void f() {
        this.f36481k.removeAllViews();
    }

    public final void g(boolean z10, View.OnClickListener onClickListener) {
        j.g(onClickListener, "listener");
        TextView textView = (TextView) findViewById(R.id.upgrade_subscription_button);
        textView.setOnClickListener(onClickListener);
        if (z10) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    public final void setRenewalString(String str) {
        j.g(str, "renewalText");
        ((TextView) findViewById(R.id.subscription_renewal_date)).setText(str);
    }
}
