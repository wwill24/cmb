package com.coffeemeetsbagel.shop.shop.adapter.header;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import kotlin.jvm.internal.j;
import lb.b;
import lb.e;

public final class ShopHeaderRowView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private CmbTextView f36508a;

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f36509b;

    public static final class a extends b {
        public a(View view) {
            super(view);
        }

        public void V(e eVar) {
            j.g(eVar, "shopViewModel");
            View view = this.f6302a;
            j.e(view, "null cannot be cast to non-null type com.coffeemeetsbagel.shop.shop.adapter.header.ShopHeaderRowView");
            ((ShopHeaderRowView) view).b((ob.a) eVar);
        }
    }

    public ShopHeaderRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public final void b(ob.a aVar) {
        CmbTextView cmbTextView = this.f36508a;
        CmbTextView cmbTextView2 = null;
        if (cmbTextView == null) {
            j.y("titleView");
            cmbTextView = null;
        }
        cmbTextView.setText(aVar.c());
        CmbTextView cmbTextView3 = this.f36509b;
        if (cmbTextView3 == null) {
            j.y("explainerView");
            cmbTextView3 = null;
        }
        cmbTextView3.setText(aVar.b());
        if (TextUtils.isEmpty(aVar.b())) {
            CmbTextView cmbTextView4 = this.f36509b;
            if (cmbTextView4 == null) {
                j.y("explainerView");
            } else {
                cmbTextView2 = cmbTextView4;
            }
            cmbTextView2.setVisibility(8);
            return;
        }
        CmbTextView cmbTextView5 = this.f36509b;
        if (cmbTextView5 == null) {
            j.y("explainerView");
        } else {
            cmbTextView2 = cmbTextView5;
        }
        cmbTextView2.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.shop_header_title);
        j.f(findViewById, "findViewById(R.id.shop_header_title)");
        this.f36508a = (CmbTextView) findViewById;
        View findViewById2 = findViewById(R.id.shop_header_explainer);
        j.f(findViewById2, "findViewById(R.id.shop_header_explainer)");
        this.f36509b = (CmbTextView) findViewById2;
    }
}
