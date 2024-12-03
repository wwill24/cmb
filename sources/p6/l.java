package p6;

import android.content.Intent;
import b6.u;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.discover_feed.empty.DiscoverFeedEmptyView;
import com.coffeemeetsbagel.feature.discover.search.DiscoverFilterActivity;
import com.coffeemeetsbagel.util.RequestCode;
import p6.d;

public class l extends u<DiscoverFeedEmptyView, d.a, g> {
    public l(DiscoverFeedEmptyView discoverFeedEmptyView, d.a aVar, g gVar) {
        super(discoverFeedEmptyView, aVar, gVar);
    }

    public void m() {
        ActivityMain a10 = ((d.a) e()).a();
        a10.startActivityForResult(new Intent(a10, DiscoverFilterActivity.class), RequestCode.CHOOSE_FILTERS);
    }
}
