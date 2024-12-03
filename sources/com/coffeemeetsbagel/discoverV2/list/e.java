package com.coffeemeetsbagel.discoverV2.list;

import android.view.View;
import com.coffeemeetsbagel.models.GiveTake;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiscoverFeedListView f12349a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GiveTake f12350b;

    public /* synthetic */ e(DiscoverFeedListView discoverFeedListView, GiveTake giveTake) {
        this.f12349a = discoverFeedListView;
        this.f12350b = giveTake;
    }

    public final void onClick(View view) {
        DiscoverFeedListView.s(this.f12349a, this.f12350b, view);
    }
}
