package com.coffeemeetsbagel.discoverV2.list;

import androidx.recyclerview.widget.RecyclerView;
import j5.x;
import kotlin.jvm.internal.j;

public final class g extends RecyclerView.t {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DiscoverFeedListView f12354a;

    g(DiscoverFeedListView discoverFeedListView) {
        this.f12354a = discoverFeedListView;
    }

    public void b(RecyclerView recyclerView, int i10, int i11) {
        j.g(recyclerView, "recyclerView");
        super.b(recyclerView, i10, i11);
        if (!recyclerView.canScrollVertically(1)) {
            this.f12354a.f12324l.d(x.a());
        }
    }
}
