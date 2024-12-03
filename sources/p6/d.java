package p6;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.discover_feed.empty.DiscoverFeedEmptyView;

public class d extends b6.c<l, c> {

    public interface a extends j<g> {
        ActivityMain a();
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final DiscoverFeedEmptyView f17038a;

        /* renamed from: b  reason: collision with root package name */
        private final h f17039b;

        b(DiscoverFeedEmptyView discoverFeedEmptyView, h hVar) {
            this.f17038a = discoverFeedEmptyView;
            this.f17039b = hVar;
        }

        /* access modifiers changed from: package-private */
        public k a() {
            return new k(this.f17038a, this.f17039b);
        }
    }

    public interface c {
        v7.d G();

        ActivityMain a();
    }

    public d(c cVar) {
        super(cVar);
    }

    public l b(ViewGroup viewGroup) {
        g gVar = new g();
        DiscoverFeedEmptyView discoverFeedEmptyView = (DiscoverFeedEmptyView) LayoutInflater.from(((c) a()).a()).inflate(R.layout.discover_empty_dls, viewGroup, false);
        return new l(discoverFeedEmptyView, b.a().b(new b(discoverFeedEmptyView, gVar)).c((c) a()).a(), gVar);
    }
}
