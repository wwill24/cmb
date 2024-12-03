package com.coffeemeetsbagel.today_view.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.domain.repository.ActionCardRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.bagel.GetLastPassedBagelUseCase;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.d;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.match_view.GetActivityReportUseCase;
import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.g;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.today_view.card.actioncards.GetFirstEligibleActionCardUseCase;
import com.coffeemeetsbagel.today_view.main.e;
import com.coffeemeetsbagel.today_view.today_bagel.e;
import com.coffeemeetsbagel.today_view.today_question.d;
import ec.d;
import java.util.Objects;
import l8.h;
import l9.e;

public class b extends b6.c<h, a> {

    public interface a {
        t B();

        GetLastPassedBagelUseCase B0();

        z F();

        d G0();

        hb.c H();

        e H0();

        b7.c K();

        ActivityMain K0();

        a0 L();

        UpdateBagelLocalUseCase M();

        j M0();

        y5.b N0();

        com.coffeemeetsbagel.qna.e O();

        t7.a Q();

        FirebaseContract.Analytics a0();

        s9.a b();

        a7.a c();

        ProfileContract$Manager d();

        UserRepository e();

        cb.a f();

        BuySubscriptionUseCase g();

        GetFirstEligibleActionCardUseCase g0();

        GetMyOwnProfileLocalUseCase h();

        k0 j();

        l5.a j0();

        QuestionRepository k();

        x k0();

        com.coffeemeetsbagel.match.j l();

        com.coffeemeetsbagel.store.alc.b l0();

        SubscriptionRepository m();

        ActionCardRepository m0();

        androidx.appcompat.app.c n();

        DeletePromptAnswerUseCase o();

        SaveProfilesLocalUseCase o0();

        c9.d p();

        g q();

        wb.c r();

        y6.a s();

        h t();

        bb.a u();

        GetGroupOptionsRemainingUseCase v();

        LoadProfileUseCase w();

        com.coffeemeetsbagel.instant_like.d w0();

        a6.a x();

        GetActivityReportUseCase y();

        SaveAnswerUseCase z();

        SuggestedRepository z0();
    }

    /* renamed from: com.coffeemeetsbagel.today_view.main.b$b  reason: collision with other inner class name */
    public interface C0468b extends b6.j<e>, d.a, d.a, e.a {
        ActivityMain K0();
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private final TodayViewMainView f37366a;

        /* renamed from: b  reason: collision with root package name */
        private final e f37367b;

        c(TodayViewMainView todayViewMainView, e eVar) {
            this.f37366a = todayViewMainView;
            this.f37367b = eVar;
        }

        /* access modifiers changed from: package-private */
        public g a() {
            return new g(this.f37366a);
        }

        /* access modifiers changed from: package-private */
        public e.a b() {
            e eVar = this.f37367b;
            Objects.requireNonNull(eVar);
            return new e.a();
        }
    }

    public b(a aVar) {
        super(aVar);
    }

    public h b(ViewGroup viewGroup) {
        e eVar = new e();
        TodayViewMainView todayViewMainView = (TodayViewMainView) LayoutInflater.from(((a) a()).K0()).inflate(R.layout.today_view_main, viewGroup, false);
        return new h(todayViewMainView, a.a().c(new c(todayViewMainView, eVar)).b((a) a()).a(), eVar, viewGroup);
    }
}
