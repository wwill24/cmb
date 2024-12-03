package com.coffeemeetsbagel.shop.shop.adapter.free;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import kotlin.jvm.internal.j;
import lb.b;
import lb.e;

public final class ShopFreeRowView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private CmbTextView f36503a;

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f36504b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f36505c;

    /* renamed from: d  reason: collision with root package name */
    private CmbImageView f36506d;

    /* renamed from: e  reason: collision with root package name */
    private CmbTextView f36507e;

    public static final class a extends b {
        public a(View view) {
            super(view);
        }

        public void V(e eVar) {
            j.g(eVar, "shopViewModel");
            View view = this.f6302a;
            j.e(view, "null cannot be cast to non-null type com.coffeemeetsbagel.shop.shop.adapter.free.ShopFreeRowView");
            ((ShopFreeRowView) view).b((nb.a) eVar);
        }
    }

    public ShopFreeRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public final void b(nb.a aVar) {
        CmbTextView cmbTextView = this.f36503a;
        LinearLayout linearLayout = null;
        if (cmbTextView == null) {
            j.y("rewardView");
            cmbTextView = null;
        }
        cmbTextView.setText(String.valueOf(aVar.g().getRewardAmount()));
        if (!TextUtils.isEmpty(aVar.f())) {
            CmbTextView cmbTextView2 = this.f36503a;
            if (cmbTextView2 == null) {
                j.y("rewardView");
                cmbTextView2 = null;
            }
            cmbTextView2.setText(aVar.f());
        }
        CmbTextView cmbTextView3 = this.f36504b;
        if (cmbTextView3 == null) {
            j.y("rewardExplainerView");
            cmbTextView3 = null;
        }
        cmbTextView3.setText(aVar.e());
        if (TextUtils.isEmpty(aVar.e())) {
            CmbTextView cmbTextView4 = this.f36504b;
            if (cmbTextView4 == null) {
                j.y("rewardExplainerView");
                cmbTextView4 = null;
            }
            cmbTextView4.setVisibility(8);
        } else {
            CmbTextView cmbTextView5 = this.f36504b;
            if (cmbTextView5 == null) {
                j.y("rewardExplainerView");
                cmbTextView5 = null;
            }
            cmbTextView5.setVisibility(0);
        }
        CmbImageView cmbImageView = this.f36506d;
        if (cmbImageView == null) {
            j.y("rewardButtonIcon");
            cmbImageView = null;
        }
        cmbImageView.setImageDrawable(aVar.c());
        if (aVar.c() == null) {
            CmbImageView cmbImageView2 = this.f36506d;
            if (cmbImageView2 == null) {
                j.y("rewardButtonIcon");
                cmbImageView2 = null;
            }
            cmbImageView2.setVisibility(8);
        } else {
            CmbImageView cmbImageView3 = this.f36506d;
            if (cmbImageView3 == null) {
                j.y("rewardButtonIcon");
                cmbImageView3 = null;
            }
            cmbImageView3.setVisibility(0);
        }
        CmbTextView cmbTextView6 = this.f36507e;
        if (cmbTextView6 == null) {
            j.y("rewardButtonText");
            cmbTextView6 = null;
        }
        cmbTextView6.setText(aVar.d());
        LinearLayout linearLayout2 = this.f36505c;
        if (linearLayout2 == null) {
            j.y("rewardButton");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setOnClickListener(aVar.b());
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.shop_free_reward);
        j.f(findViewById, "findViewById(R.id.shop_free_reward)");
        this.f36503a = (CmbTextView) findViewById;
        View findViewById2 = findViewById(R.id.shop_free_reward_explainer);
        j.f(findViewById2, "findViewById(R.id.shop_free_reward_explainer)");
        this.f36504b = (CmbTextView) findViewById2;
        View findViewById3 = findViewById(R.id.shop_free_button);
        j.f(findViewById3, "findViewById(R.id.shop_free_button)");
        this.f36505c = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.shop_free_button_image);
        j.f(findViewById4, "findViewById(R.id.shop_free_button_image)");
        this.f36506d = (CmbImageView) findViewById4;
        View findViewById5 = findViewById(R.id.shop_free_button_text);
        j.f(findViewById5, "findViewById(R.id.shop_free_button_text)");
        this.f36507e = (CmbTextView) findViewById5;
    }
}
