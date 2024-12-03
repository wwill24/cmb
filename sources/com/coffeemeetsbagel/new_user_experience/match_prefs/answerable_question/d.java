package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.PremiumPreferencePresenter;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import kotlin.jvm.internal.j;
import ma.g;
import qj.q;

public final class d extends b6.c<w, b> {

    /* renamed from: b  reason: collision with root package name */
    private final QuestionWAnswers f35249b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35250a;

        /* renamed from: b  reason: collision with root package name */
        private final ia.d f35251b;

        /* renamed from: c  reason: collision with root package name */
        private final PremiumPreferencePresenter.a f35252c;

        public a(ViewGroup viewGroup, ia.d dVar, PremiumPreferencePresenter.a aVar) {
            j.g(viewGroup, "parentViewGroup");
            j.g(dVar, "binding");
            j.g(aVar, "userInputListener");
            this.f35250a = viewGroup;
            this.f35251b = dVar;
            this.f35252c = aVar;
        }

        public final PremiumPreferencePresenter a() {
            return new PremiumPreferencePresenter(this.f35251b, this.f35252c);
        }
    }

    public interface b {
        UserRepository C();

        q<c6.a> a0();

        s9.a b();

        a7.a c();

        g c0();

        QuestionRepository e0();

        cb.a f();

        BuySubscriptionUseCase g();

        GetMyOwnProfileLocalUseCase h();

        SubscriptionRepository h0();

        l j();

        l5.a j0();

        k k();

        androidx.appcompat.app.c n();

        SaveAnswerUseCase z();
    }

    public interface c extends b6.j<PremiumPreferenceInteractor>, e.a {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(b bVar, QuestionWAnswers questionWAnswers) {
        super(bVar);
        j.g(bVar, "dependency");
        j.g(questionWAnswers, "question");
        this.f35249b = questionWAnswers;
    }

    public final w b(ViewGroup viewGroup) {
        j.g(viewGroup, "parentViewGroup");
        PremiumPreferenceInteractor premiumPreferenceInteractor = new PremiumPreferenceInteractor(this.f35249b.e().getId());
        ia.d c10 = ia.d.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        j.f(c10, "inflate(inflater, parentViewGroup, false)");
        c b10 = b.a().a(new a(viewGroup, c10, premiumPreferenceInteractor)).c((b) a()).b();
        String label = this.f35249b.e().getLabel();
        j.f(b10, "component");
        return new w(label, c10, b10, premiumPreferenceInteractor);
    }
}
