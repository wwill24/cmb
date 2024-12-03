package com.coffeemeetsbagel.today_view.card.actioncards;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b6.j;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.domain.repository.ActionCardRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.today_view.card.actioncards.ActionCardPresenter;
import com.coffeemeetsbagel.today_view.main.e;
import com.coffeemeetsbagel.today_view.today_question.d;
import fc.d;
import io.reactivex.BackpressureStrategy;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import qj.h;
import qj.q;

public final class b extends b6.c<a0, c> {

    public interface a extends j<ActionCardInteractor>, d.a, d.c {
        ActivityMain a();
    }

    /* renamed from: com.coffeemeetsbagel.today_view.card.actioncards.b$b  reason: collision with other inner class name */
    public static final class C0463b {

        /* renamed from: a  reason: collision with root package name */
        private final k6.a f37279a;

        /* renamed from: b  reason: collision with root package name */
        private final ActionCardPresenter.a f37280b;

        /* renamed from: c  reason: collision with root package name */
        private final ActivityMain f37281c;

        public C0463b(k6.a aVar, ActionCardPresenter.a aVar2, ActivityMain activityMain) {
            kotlin.jvm.internal.j.g(aVar, "binding");
            kotlin.jvm.internal.j.g(aVar2, "listener");
            kotlin.jvm.internal.j.g(activityMain, "activity");
            this.f37279a = aVar;
            this.f37280b = aVar2;
            this.f37281c = activityMain;
        }

        public final ActionCardPresenter a(PublishSubject<Unit> publishSubject) {
            kotlin.jvm.internal.j.g(publishSubject, "producer");
            return new ActionCardPresenter(this.f37279a, this.f37280b, publishSubject);
        }

        public final c6.b b() {
            c6.b t22 = this.f37281c.t2();
            kotlin.jvm.internal.j.f(t22, "activity.activityResultStream()");
            return t22;
        }

        public final a c(a7.a aVar) {
            kotlin.jvm.internal.j.g(aVar, "analyticsManager");
            return new a(aVar);
        }

        public final h<Unit> d(PublishSubject<Unit> publishSubject) {
            kotlin.jvm.internal.j.g(publishSubject, "producer");
            return publishSubject.v0(BackpressureStrategy.LATEST);
        }

        public final PublishSubject<Unit> e() {
            PublishSubject<Unit> C0 = PublishSubject.C0();
            kotlin.jvm.internal.j.f(C0, "create<Unit>()");
            return C0;
        }
    }

    public interface c {
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

        com.coffeemeetsbagel.match.j l();

        ActionCardRepository m0();

        SaveProfilesLocalUseCase o0();

        e.a r();

        bb.a u();

        a6.a x();

        SaveAnswerUseCase z();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final a0 b(ViewGroup viewGroup, boolean z10, boolean z11, q<Boolean> qVar) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(qVar, "isVisible");
        ActionCardInteractor actionCardInteractor = new ActionCardInteractor(z10, z11, qVar);
        k6.a c10 = k6.a.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(LayoutInflater.f…, parentViewGroup, false)");
        a b10 = b0.a().a(new C0463b(c10, actionCardInteractor, ((c) a()).a())).c((c) a()).b();
        ConstraintLayout b11 = c10.getRoot();
        kotlin.jvm.internal.j.f(b11, "binding.root");
        kotlin.jvm.internal.j.f(b10, "component");
        return new a0(b11, b10, actionCardInteractor);
    }
}
