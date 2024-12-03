package com.coffeemeetsbagel.suggested_history;

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
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.e;
import com.coffeemeetsbagel.qna.g;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.suggested_history.p;
import com.coffeemeetsbagel.suggested_history.suggested_history_list.f;
import com.coffeemeetsbagel.suggested_history.suggested_history_match_container.e;
import l8.h;

public final class k extends b6.c<o, p.a> {

    public interface a {
        SaveAnswerUseCase D();

        GetHistoryBagelUseCase E0();

        d F0();

        x J();

        com.coffeemeetsbagel.store.alc.b L0();

        UpdateBagelLocalUseCase M();

        bb.a M0();

        e O();

        SubscriptionRepository P();

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

        z u0();

        GetGroupOptionsRemainingUseCase v();

        LoadProfileUseCase w();

        a6.a x();

        FirebaseContract.Analytics x0();

        GetActivityReportUseCase y();
    }

    public interface b extends b6.j<m>, e.a, f.a {
        b6.d<?, ?> a();
    }

    public final class c {

        /* renamed from: a  reason: collision with root package name */
        private final zb.d f37124a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f37125b;

        public c(k kVar, zb.d dVar) {
            kotlin.jvm.internal.j.g(dVar, "binding");
            this.f37125b = kVar;
            this.f37124a = dVar;
        }

        public final SuggestedHistoryCompPresenter a(b6.d<?, ?> dVar) {
            kotlin.jvm.internal.j.g(dVar, "activity");
            return new SuggestedHistoryCompPresenter(this.f37124a, dVar);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(p.a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final o b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        m mVar = new m();
        zb.d c10 = zb.d.c(LayoutInflater.from(((p.a) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        b a10 = b.a().b(new c(this, c10)).c((p.a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new o(c10, a10, mVar);
    }
}
