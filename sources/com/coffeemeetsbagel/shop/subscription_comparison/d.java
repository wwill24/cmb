package com.coffeemeetsbagel.shop.subscription_comparison;

import android.view.View;
import com.coffeemeetsbagel.shop.subscription_comparison.SubscriptionCardPagerAdapter;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCardPagerAdapter.CardType f36623a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCardPagerAdapter f36624b;

    public /* synthetic */ d(SubscriptionCardPagerAdapter.CardType cardType, SubscriptionCardPagerAdapter subscriptionCardPagerAdapter) {
        this.f36623a = cardType;
        this.f36624b = subscriptionCardPagerAdapter;
    }

    public final void onClick(View view) {
        SubscriptionCardPagerAdapter.C(this.f36623a, this.f36624b, view);
    }
}
