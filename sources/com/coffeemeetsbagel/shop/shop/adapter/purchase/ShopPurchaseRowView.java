package com.coffeemeetsbagel.shop.shop.adapter.purchase;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import kotlin.jvm.internal.j;
import lb.b;
import lb.e;

public final class ShopPurchaseRowView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private CmbTextView f36510a;

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f36511b;

    /* renamed from: c  reason: collision with root package name */
    private CmbTextView f36512c;

    public static final class a extends b {
        public a(View view) {
            super(view);
        }

        public void V(e eVar) {
            j.g(eVar, "shopViewModel");
            View view = this.f6302a;
            j.e(view, "null cannot be cast to non-null type com.coffeemeetsbagel.shop.shop.adapter.purchase.ShopPurchaseRowView");
            ((ShopPurchaseRowView) view).b((pb.a) eVar);
        }
    }

    public ShopPurchaseRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public final void b(pb.a aVar) {
        int i10;
        CmbTextView cmbTextView = this.f36510a;
        CmbTextView cmbTextView2 = null;
        if (cmbTextView == null) {
            j.y("rewardView");
            cmbTextView = null;
        }
        cmbTextView.setText(String.valueOf(aVar.d().getRewardAmount()));
        CmbTextView cmbTextView3 = this.f36511b;
        if (cmbTextView3 == null) {
            j.y("savingsView");
            cmbTextView3 = null;
        }
        cmbTextView3.setText(aVar.e());
        CmbTextView cmbTextView4 = this.f36511b;
        if (cmbTextView4 == null) {
            j.y("savingsView");
            cmbTextView4 = null;
        }
        if (TextUtils.isEmpty(aVar.e())) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        cmbTextView4.setVisibility(i10);
        if (TextUtils.isEmpty(aVar.d().getPriceString())) {
            CmbTextView cmbTextView5 = this.f36512c;
            if (cmbTextView5 == null) {
                j.y("purchaseButton");
                cmbTextView5 = null;
            }
            cmbTextView5.setText(aVar.c());
            CmbTextView cmbTextView6 = this.f36512c;
            if (cmbTextView6 == null) {
                j.y("purchaseButton");
                cmbTextView6 = null;
            }
            cmbTextView6.setEnabled(false);
        } else {
            CmbTextView cmbTextView7 = this.f36512c;
            if (cmbTextView7 == null) {
                j.y("purchaseButton");
                cmbTextView7 = null;
            }
            cmbTextView7.setText(aVar.d().getPriceString());
            CmbTextView cmbTextView8 = this.f36512c;
            if (cmbTextView8 == null) {
                j.y("purchaseButton");
                cmbTextView8 = null;
            }
            cmbTextView8.setEnabled(true);
        }
        CmbTextView cmbTextView9 = this.f36512c;
        if (cmbTextView9 == null) {
            j.y("purchaseButton");
        } else {
            cmbTextView2 = cmbTextView9;
        }
        cmbTextView2.setOnClickListener(aVar.b());
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.shop_purchase_reward);
        j.f(findViewById, "findViewById(R.id.shop_purchase_reward)");
        this.f36510a = (CmbTextView) findViewById;
        View findViewById2 = findViewById(R.id.shop_purchase_button_text);
        j.f(findViewById2, "findViewById(R.id.shop_purchase_button_text)");
        this.f36512c = (CmbTextView) findViewById2;
        View findViewById3 = findViewById(R.id.shop_purchase_saving);
        j.f(findViewById3, "findViewById(R.id.shop_purchase_saving)");
        CmbTextView cmbTextView = (CmbTextView) findViewById3;
        this.f36511b = cmbTextView;
        if (cmbTextView == null) {
            j.y("savingsView");
            cmbTextView = null;
        }
        cmbTextView.x(Boolean.TRUE);
    }
}
