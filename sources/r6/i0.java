package r6;

import android.view.View;
import com.coffeemeetsbagel.discover_feed.list.DiscoverFeedListView;
import com.coffeemeetsbagel.models.GiveTake;

public final /* synthetic */ class i0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiscoverFeedListView f17303a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GiveTake f17304b;

    public /* synthetic */ i0(DiscoverFeedListView discoverFeedListView, GiveTake giveTake) {
        this.f17303a = discoverFeedListView;
        this.f17304b = giveTake;
    }

    public final void onClick(View view) {
        this.f17303a.o(this.f17304b, view);
    }
}
