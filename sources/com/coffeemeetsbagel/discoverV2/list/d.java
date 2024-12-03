package com.coffeemeetsbagel.discoverV2.list;

import android.view.View;
import com.coffeemeetsbagel.models.Price;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiscoverFeedListView f12347a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Price f12348b;

    public /* synthetic */ d(DiscoverFeedListView discoverFeedListView, Price price) {
        this.f12347a = discoverFeedListView;
        this.f12348b = price;
    }

    public final void onClick(View view) {
        DiscoverFeedListView.F(this.f12347a, this.f12348b, view);
    }
}
