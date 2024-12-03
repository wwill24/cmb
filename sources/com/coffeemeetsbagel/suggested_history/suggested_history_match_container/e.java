package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
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
import l8.h;

public final class e extends b6.c<SuggestedHistoryMatchContainerRouter, a> {

    public interface a {
        SaveAnswerUseCase D();

        d F0();

        x J();

        com.coffeemeetsbagel.store.alc.b L0();

        UpdateBagelLocalUseCase M();

        com.coffeemeetsbagel.qna.e O();

        SubscriptionRepository P();

        b6.d<?, ?> a();

        s9.a b();

        a7.a c();

        ProfileContract$Manager d();

        j d0();

        UserRepository e();

        c6.b e0();

        cb.a f();

        BuySubscriptionUseCase g();

        GetMyOwnProfileLocalUseCase h();

        k0 j();

        QuestionRepository k();

        com.coffeemeetsbagel.match.j l();

        androidx.appcompat.app.c n();

        DeletePromptAnswerUseCase o();

        c9.d p();

        g q();

        wb.c r();

        y6.a s();

        h t();

        bb.a u();

        z u0();

        GetGroupOptionsRemainingUseCase v();

        LoadProfileUseCase w();

        a6.a x();

        FirebaseContract.Analytics x0();

        GetActivityReportUseCase y();
    }

    public interface b extends b6.j<SuggestedHistoryMatchContainerInteractor>, m.c {
        b6.d<?, ?> a();
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final zb.b f37203a;

        /* renamed from: b  reason: collision with root package name */
        private final i0 f37204b;

        public c(zb.b bVar, i0 i0Var) {
            kotlin.jvm.internal.j.g(bVar, "binding");
            kotlin.jvm.internal.j.g(i0Var, "listener");
            this.f37203a = bVar;
            this.f37204b = i0Var;
        }

        public final com.coffeemeetsbagel.store.alc.a a(a7.a aVar, FirebaseContract.Analytics analytics) {
            kotlin.jvm.internal.j.g(aVar, "analytics");
            kotlin.jvm.internal.j.g(analytics, "firebase");
            return new com.coffeemeetsbagel.store.alc.a(aVar, analytics);
        }

        public final h0 b() {
            return new h0(this.f37203a, this.f37204b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final SuggestedHistoryMatchContainerRouter b(ViewGroup viewGroup, Bagel bagel, d dVar) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(bagel, Extra.BAGEL);
        kotlin.jvm.internal.j.g(dVar, "parentListener");
        SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor = new SuggestedHistoryMatchContainerInteractor(bagel, dVar);
        zb.b c10 = zb.b.c(LayoutInflater.from(((a) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        b a10 = b.a().c(new c(c10, suggestedHistoryMatchContainerInteractor)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new SuggestedHistoryMatchContainerRouter(c10, a10, suggestedHistoryMatchContainerInteractor);
    }
}
