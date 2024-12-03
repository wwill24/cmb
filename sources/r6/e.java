package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.discover_feed.list.DiscoverFeedListView;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.alc.d;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import l8.h;
import lc.k;
import s6.m;

public final class e extends b6.c<g0, c> {

    public interface a extends j<u>, e.a {
        ActivityMain a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final DiscoverFeedListView f17295a;

        /* renamed from: b  reason: collision with root package name */
        private final w f17296b;

        public b(DiscoverFeedListView discoverFeedListView, w wVar) {
            kotlin.jvm.internal.j.g(discoverFeedListView, "discoverFeedListView");
            kotlin.jvm.internal.j.g(wVar, "discoverFeedListInteractor");
            this.f17295a = discoverFeedListView;
            this.f17296b = wVar;
        }

        public final f0 a(ProfileContract$Manager profileContract$Manager, k0 k0Var, s9.a aVar, a6.a aVar2) {
            kotlin.jvm.internal.j.g(profileContract$Manager, "profileManager");
            kotlin.jvm.internal.j.g(k0Var, "purchaseManager");
            kotlin.jvm.internal.j.g(aVar, "featureManager");
            kotlin.jvm.internal.j.g(aVar2, "coachmarkManager");
            return new f0(this.f17295a, this.f17296b, new com.coffeemeetsbagel.discover_feed.list.a(profileContract$Manager, k0Var, aVar, aVar2));
        }

        public final androidx.appcompat.app.c b(ActivityMain activityMain) {
            kotlin.jvm.internal.j.g(activityMain, "activityMain");
            return activityMain;
        }
    }

    public interface c {
        ProfileRepositoryV2 A0();

        d C0();

        BuySubscriptionUseCase D0();

        GetMyOwnProfileLocalUseCase E0();

        z F();

        wb.c F0();

        v7.d G();

        m.b G0();

        b7.c K();

        t7.a Q();

        ActivityMain a();

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

        h t();

        a6.a x();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final g0 b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        u uVar = new u();
        Object a10 = a();
        kotlin.jvm.internal.j.d(a10);
        View inflate = LayoutInflater.from(((c) a10).a()).inflate(R.layout.discover_list, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.discover_feed.list.DiscoverFeedListView");
        DiscoverFeedListView discoverFeedListView = (DiscoverFeedListView) inflate;
        a a11 = b.a().b(new b(discoverFeedListView, uVar)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a11, "builder()\n              …\n                .build()");
        return new g0(discoverFeedListView, a11, uVar);
    }
}
