package ec;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.domain.repository.ActionCardRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.today_view.card.actioncards.GetFirstEligibleActionCardUseCase;
import com.coffeemeetsbagel.today_view.card.actioncards.b;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.b;
import com.coffeemeetsbagel.today_view.main.e;
import dc.d;
import fc.d;
import qj.q;

public final class d extends b6.c<i, a> {

    public interface a {
        UserRepository C();

        hb.c H();

        b7.c K();

        t7.a Q();

        ActivityMain a();

        s9.a b();

        a7.a c();

        ProfileContract$Manager d();

        cb.a f();

        GetFirstEligibleActionCardUseCase g0();

        k0 j();

        QuestionRepository k();

        j l();

        ActionCardRepository m0();

        SaveProfilesLocalUseCase o0();

        e.a r();

        bb.a u();

        a6.a x();

        SaveAnswerUseCase z();
    }

    public interface b extends b6.j<f>, d.c, d.c, b.c, b.a {
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f40673a;

        public c(ViewGroup viewGroup) {
            kotlin.jvm.internal.j.g(viewGroup, "view");
            this.f40673a = viewGroup;
        }

        public final h a() {
            return new h(this.f40673a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final i b(ViewGroup viewGroup, boolean z10, boolean z11, q<Boolean> qVar, SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(qVar, "isVisible");
        f fVar = new f(z10, z11, qVar, unsubPaywall);
        Object a10 = a();
        kotlin.jvm.internal.j.d(a10);
        View inflate = LayoutInflater.from(((a) a10).a()).inflate(R.layout.today_card_component, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        b a11 = b.a().c(new c(viewGroup2)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a11, "component");
        return new i(viewGroup2, a11, fVar, viewGroup);
    }
}
