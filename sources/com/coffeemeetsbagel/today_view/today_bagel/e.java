package com.coffeemeetsbagel.today_view.today_bagel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.bagel.GetLastPassedBagelUseCase;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.instant_like.f;
import com.coffeemeetsbagel.match.d;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.match_view.GetActivityReportUseCase;
import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.match_view.m;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.g;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import com.coffeemeetsbagel.today_view.main.e;
import l8.h;

public final class e extends b6.c<n0, a> {

    public interface a {
        y5.b A();

        t B();

        GetLastPassedBagelUseCase B0();

        SaveAnswerUseCase D();

        z F();

        d G0();

        hb.c H();

        l9.e H0();

        a0 L();

        UpdateBagelLocalUseCase M();

        a6.a N();

        com.coffeemeetsbagel.qna.e Y();

        ActivityMain a();

        FirebaseContract.Analytics a0();

        s9.a b();

        a7.a c();

        ProfileContract$Manager d();

        j d0();

        UserRepository e();

        cb.a f();

        BuySubscriptionUseCase g();

        GetMyOwnProfileLocalUseCase h();

        k0 j();

        l5.a j0();

        QuestionRepository k();

        x k0();

        com.coffeemeetsbagel.match.j l();

        com.coffeemeetsbagel.store.alc.b l0();

        SubscriptionRepository m();

        androidx.appcompat.app.c n();

        DeletePromptAnswerUseCase o();

        c9.d p();

        g q();

        e.a r();

        y6.a s();

        h t();

        bb.a u();

        GetGroupOptionsRemainingUseCase v();

        LoadProfileUseCase w();

        com.coffeemeetsbagel.instant_like.d w0();

        GetActivityReportUseCase y();

        SuggestedRepository z0();
    }

    public interface b extends b6.j<SuggestedMatchContainerInteractor>, m.c, f.c, e.a {
        ActivityMain K0();
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final TodayBagelView f37452a;

        /* renamed from: b  reason: collision with root package name */
        private final SuggestedMatchContainerInteractor f37453b;

        public c(TodayBagelView todayBagelView, SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
            kotlin.jvm.internal.j.g(todayBagelView, "todayBagelView");
            kotlin.jvm.internal.j.g(suggestedMatchContainerInteractor, "interactor");
            this.f37452a = todayBagelView;
            this.f37453b = suggestedMatchContainerInteractor;
        }

        public final a1 a(s9.a aVar, a7.a aVar2) {
            kotlin.jvm.internal.j.g(aVar, "featureManager");
            kotlin.jvm.internal.j.g(aVar2, "analyticsManager");
            return new a1(this.f37452a, this.f37453b, aVar, aVar2);
        }

        public final c6.b b(ActivityMain activityMain) {
            kotlin.jvm.internal.j.g(activityMain, "activity");
            c6.b t22 = activityMain.t2();
            kotlin.jvm.internal.j.f(t22, "activity.activityResultStream()");
            return t22;
        }

        public final com.coffeemeetsbagel.store.alc.a c(a7.a aVar, FirebaseContract.Analytics analytics) {
            kotlin.jvm.internal.j.g(aVar, "analytics");
            kotlin.jvm.internal.j.g(analytics, "firebase");
            return new com.coffeemeetsbagel.store.alc.a(aVar, analytics);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final n0 b(ViewGroup viewGroup, Bagel bagel, boolean z10) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(bagel, Extra.BAGEL);
        SuggestedMatchContainerInteractor suggestedMatchContainerInteractor = new SuggestedMatchContainerInteractor(bagel, z10);
        View inflate = LayoutInflater.from(((a) a()).a()).inflate(R.layout.today_bagel, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.today_view.today_bagel.TodayBagelView");
        TodayBagelView todayBagelView = (TodayBagelView) inflate;
        b a10 = b.a().c(new c(todayBagelView, suggestedMatchContainerInteractor)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "builder()\n              …\n                .build()");
        return new n0(todayBagelView, a10, suggestedMatchContainerInteractor, viewGroup);
    }
}
