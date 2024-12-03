package r6;

import android.view.View;
import com.coffeemeetsbagel.discover_feed.list.DiscoverFeedListView;
import com.coffeemeetsbagel.models.Price;

public final /* synthetic */ class k0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiscoverFeedListView f17310a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Price f17311b;

    public /* synthetic */ k0(DiscoverFeedListView discoverFeedListView, Price price) {
        this.f17310a = discoverFeedListView;
        this.f17311b = price;
    }

    public final void onClick(View view) {
        this.f17310a.q(this.f17311b, view);
    }
}
