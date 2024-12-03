package com.coffeemeetsbagel.limelight.profile_activity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b6.d;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.limelight.profile_activity.LikesYouMatchContainerInteractor;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.match_view.GetActivityReportUseCase;
import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.match_view.m;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.e;
import com.coffeemeetsbagel.qna.g;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import java.util.List;
import l8.h;

public final class r extends b6.c<p0, c> {

    public interface a extends j<LikesYouMatchContainerInteractor>, m.c {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final FrameLayout f34467a;

        /* renamed from: b  reason: collision with root package name */
        private final LikesYouMatchContainerInteractor f34468b;

        public b(FrameLayout frameLayout, LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
            kotlin.jvm.internal.j.g(frameLayout, "layout");
            kotlin.jvm.internal.j.g(likesYouMatchContainerInteractor, "interactor");
            this.f34467a = frameLayout;
            this.f34468b = likesYouMatchContainerInteractor;
        }

        public final c6.b a(d<?, ?> dVar) {
            kotlin.jvm.internal.j.g(dVar, "componentActivity");
            c6.b F0 = dVar.F0();
            kotlin.jvm.internal.j.f(F0, "componentActivity.activityResultStream()");
            return F0;
        }

        public final LikesYouProfilePresenter b() {
            return new LikesYouProfilePresenter(this.f34467a, this.f34468b);
        }
    }

    public interface c {
        t B();

        SaveAnswerUseCase D();

        z F();

        x J();

        a0 L();

        a6.a N();

        a7.a R();

        e Y();

        d<?, ?> a();

        s9.a b();

        ProfileContract$Manager d();

        UserRepository e();

        cb.a f();

        com.coffeemeetsbagel.qna.j f0();

        BuySubscriptionUseCase g();

        GetMyOwnProfileLocalUseCase h();

        Activity i();

        QuestionRepository k();

        com.coffeemeetsbagel.match.j l();

        SubscriptionRepository m();

        androidx.appcompat.app.c n();

        DeletePromptAnswerUseCase o();

        c9.d p();

        g q();

        wb.c r();

        y6.a s();

        h t();

        LikesYouMatchRepository t0();

        bb.a u();

        GetGroupOptionsRemainingUseCase v();

        LoadProfileUseCase w();

        GetActivityReportUseCase y();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final p0 b(ViewGroup viewGroup, List<String> list, String str, MatchIdAttribution matchIdAttribution, LikesYouMatchContainerInteractor.b bVar) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(list, "profileIds");
        kotlin.jvm.internal.j.g(str, "screenSource");
        kotlin.jvm.internal.j.g(matchIdAttribution, "profileIdAttribution");
        kotlin.jvm.internal.j.g(bVar, "actionListener");
        LikesYouMatchContainerInteractor likesYouMatchContainerInteractor = new LikesYouMatchContainerInteractor(matchIdAttribution, list, bVar, str);
        View inflate = LayoutInflater.from(((c) a()).a()).inflate(R.layout.likes_you_profile, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(R.id.profile_placeholder);
        a a10 = e.a().b(new b(frameLayout, likesYouMatchContainerInteractor)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        kotlin.jvm.internal.j.f(frameLayout2, "profilePlaceholder");
        return new p0(frameLayout, a10, likesYouMatchContainerInteractor, frameLayout2);
    }
}
