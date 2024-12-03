package com.coffeemeetsbagel.shop.shop.adapter.subscription;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import lb.b;
import lb.e;
import qb.c;

public class DynamicPreSubscriptionView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private CmbTextView f36513a;

    public static class a extends b {
        public a(View view) {
            super(view);
        }

        public void V(e eVar) {
            ((DynamicPreSubscriptionView) this.f6302a).a((c) eVar);
        }
    }

    public DynamicPreSubscriptionView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        this.f36513a.setOnClickListener(cVar.c());
        addView(cVar.b(), 0);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f36513a = (CmbTextView) findViewById(R.id.shop_subscribe);
    }
}
