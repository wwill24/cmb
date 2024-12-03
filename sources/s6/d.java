package s6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.discover_feed.main.DiscoverFeedMainView;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.upsell_banner.g;
import l8.h;
import lc.k;
import p6.d;
import q6.d;
import r6.e;
import s6.m;

public final class d extends b6.c<p, c> {

    public interface a extends j<m>, e.c, d.c, d.c, g.c {
        ActivityMain a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final DiscoverFeedMainView f17497a;

        /* renamed from: b  reason: collision with root package name */
        private final m f17498b;

        public b(DiscoverFeedMainView discoverFeedMainView, m mVar) {
            kotlin.jvm.internal.j.g(discoverFeedMainView, "discoverFeedView");
            kotlin.jvm.internal.j.g(mVar, "mainInteractor");
            this.f17497a = discoverFeedMainView;
            this.f17498b = mVar;
        }

        public final o a() {
            return new o(this.f17497a);
        }

        public final m.b b() {
            return new m.b();
        }
    }

    public interface c {
        ProfileRepositoryV2 A0();

        com.coffeemeetsbagel.store.alc.d C0();

        ActivityMain D();

        BuySubscriptionUseCase D0();

        GetMyOwnProfileLocalUseCase E0();

        z F();

        v7.d G();

        b7.c K();

        t7.a Q();

        s9.a b();

        a7.a c();

        ProfileContract$Manager d();

        UserRepository e();

        cb.a f();

        m1 i0();

        k0 j();

        com.coffeemeetsbagel.match.j l();

        SubscriptionRepository m();

        k q0();

        wb.c r();

        h t();

        a6.a x();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final p b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        m mVar = new m();
        Object a10 = a();
        kotlin.jvm.internal.j.d(a10);
        View inflate = LayoutInflater.from(((c) a10).D()).inflate(R.layout.discover_view, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.discover_feed.main.DiscoverFeedMainView");
        DiscoverFeedMainView discoverFeedMainView = (DiscoverFeedMainView) inflate;
        a a11 = b.a().b(new b(discoverFeedMainView, mVar)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a11, "builder()\n              …\n                .build()");
        return new p(discoverFeedMainView, a11, mVar, viewGroup);
    }
}
