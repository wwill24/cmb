package com.coffeemeetsbagel.discoverV2.list;

import android.view.View;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.store.alc.PurchaseType;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiscoverFeedListView f12351a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GiveTake f12352b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PurchaseType f12353c;

    public /* synthetic */ f(DiscoverFeedListView discoverFeedListView, GiveTake giveTake, PurchaseType purchaseType) {
        this.f12351a = discoverFeedListView;
        this.f12352b = giveTake;
        this.f12353c = purchaseType;
    }

    public final void onClick(View view) {
        DiscoverFeedListView.z(this.f12351a, this.f12352b, this.f12353c, view);
    }
}
