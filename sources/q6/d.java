package q6;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.discover_feed.filters.DiscoverFeedFiltersView;
import com.coffeemeetsbagel.store.k0;

public class d extends b6.c<l, c> {

    public interface a extends j<f> {
        ActivityMain a();
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final DiscoverFeedFiltersView f17179a;

        /* renamed from: b  reason: collision with root package name */
        private final g f17180b;

        b(DiscoverFeedFiltersView discoverFeedFiltersView, g gVar) {
            this.f17179a = discoverFeedFiltersView;
            this.f17180b = gVar;
        }

        /* access modifiers changed from: package-private */
        public k a(v7.d dVar) {
            return new k(this.f17179a, this.f17180b, dVar);
        }
    }

    public interface c {
        v7.d G();

        ActivityMain a();

        s9.a b();

        k0 j();
    }

    public d(c cVar) {
        super(cVar);
    }

    public l b(ViewGroup viewGroup) {
        f fVar = new f();
        DiscoverFeedFiltersView discoverFeedFiltersView = (DiscoverFeedFiltersView) LayoutInflater.from(((c) a()).a()).inflate(R.layout.discover_search_bar, viewGroup, false);
        return new l(discoverFeedFiltersView, b.a().b(new b(discoverFeedFiltersView, fVar)).c((c) a()).a(), fVar);
    }
}
