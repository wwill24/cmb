package q6;

import android.content.Intent;
import b6.u;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.discover_feed.filters.DiscoverFeedFiltersView;
import com.coffeemeetsbagel.feature.discover.search.DiscoverFilterActivity;
import com.coffeemeetsbagel.util.RequestCode;
import lc.a;
import q6.d;

public class l extends u<DiscoverFeedFiltersView, d.a, f> {
    public l(DiscoverFeedFiltersView discoverFeedFiltersView, d.a aVar, f fVar) {
        super(discoverFeedFiltersView, aVar, fVar);
    }

    public void m() {
        ActivityMain a10 = ((d.a) e()).a();
        a.d(a10, new Intent(a10, DiscoverFilterActivity.class), RequestCode.CHOOSE_FILTERS);
    }

    public void n() {
        ((f) f()).H1();
    }
}
