package com.coffeemeetsbagel.shop.shop.adapter.subscription_durations;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.feature.activityreports.getpremium.GetPremiumViewPager;
import com.coffeemeetsbagel.feature.activityreports.getpremium.PremiumPageType;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import lb.b;
import lb.d;
import lb.e;

public class ShopNonPurchasedSubscriptionRowView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private GetPremiumViewPager f36514a;

    /* renamed from: b  reason: collision with root package name */
    private TabLayout f36515b;

    /* renamed from: c  reason: collision with root package name */
    private CmbTextView f36516c;

    /* renamed from: d  reason: collision with root package name */
    private z6.a f36517d;

    public static class a extends b implements d.b {
        public a(View view) {
            super(view);
        }

        public void V(e eVar) {
            ((ShopNonPurchasedSubscriptionRowView) this.f6302a).c((rb.a) eVar);
        }

        public void c() {
            ((ShopNonPurchasedSubscriptionRowView) this.f6302a).d();
        }
    }

    public ShopNonPurchasedSubscriptionRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public void c(rb.a aVar) {
        setPremiumPagerAdapter(aVar);
        this.f36516c.setOnClickListener(aVar.b());
    }

    /* access modifiers changed from: private */
    public void d() {
        int currentItem = this.f36514a.getCurrentItem() + 1;
        if (currentItem >= this.f36517d.e()) {
            currentItem = 0;
        }
        this.f36514a.N(currentItem, true);
    }

    private void setPremiumPagerAdapter(rb.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PremiumPageType.LIKES_YOU);
        arrayList.add(PremiumPageType.ACTIVITY_REPORT_DLS);
        if (aVar.c()) {
            arrayList.add(PremiumPageType.READ_RECEIPT_DLS);
        }
        z6.a aVar2 = new z6.a(getContext());
        this.f36517d = aVar2;
        this.f36514a.setAdapter(aVar2);
        this.f36515b.setupWithViewPager(this.f36514a);
        this.f36517d.u(arrayList);
        this.f36517d.k();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f36514a = (GetPremiumViewPager) findViewById(R.id.shop_subscription_viewpager);
        this.f36515b = (TabLayout) findViewById(R.id.shop_page_indicator);
        this.f36516c = (CmbTextView) findViewById(R.id.shop_subscribe);
    }
}
