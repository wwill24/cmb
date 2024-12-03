package com.coffeemeetsbagel.limelight.profile_activity;

import android.app.Activity;
import b6.c;
import b6.d;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.limelight.profile_activity.r;
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
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import l8.h;

public final class j extends c<q, b> {

    public interface a extends b6.j<LikesYouBrowserInteractor>, r.c {
    }

    public interface b {
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
    public j(b bVar) {
        super(bVar);
        kotlin.jvm.internal.j.g(bVar, "dependency");
    }

    public final q b(String str, String str2, String str3) {
        kotlin.jvm.internal.j.g(str, "screenSource");
        kotlin.jvm.internal.j.g(str2, "groupId");
        kotlin.jvm.internal.j.g(str3, "selectedMatchId");
        LikesYouBrowserInteractor likesYouBrowserInteractor = new LikesYouBrowserInteractor(str, str2, str3);
        a a10 = b.a().b((b) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new q(a10, likesYouBrowserInteractor);
    }
}
