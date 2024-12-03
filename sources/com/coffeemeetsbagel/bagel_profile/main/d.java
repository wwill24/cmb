package com.coffeemeetsbagel.bagel_profile.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bagel_profile.GenericMatchContainerV2Presenter;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match_view.GetActivityReportUseCase;
import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.match_view.m;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.e;
import com.coffeemeetsbagel.qna.g;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.k0;

public final class d extends b6.c<i, c> {

    public interface a extends j<GenericMatchContainerV2Interactor>, m.c {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final GenericMatchContainerView f11042a;

        /* renamed from: b  reason: collision with root package name */
        private final GenericMatchContainerV2Interactor f11043b;

        public b(GenericMatchContainerView genericMatchContainerView, GenericMatchContainerV2Interactor genericMatchContainerV2Interactor) {
            kotlin.jvm.internal.j.g(genericMatchContainerView, "bagelProfileMainView");
            kotlin.jvm.internal.j.g(genericMatchContainerV2Interactor, "interactor");
            this.f11042a = genericMatchContainerView;
            this.f11043b = genericMatchContainerV2Interactor;
        }

        public final com.coffemeetsbagel.hide_report.a a(ProfileRepository profileRepository) {
            kotlin.jvm.internal.j.g(profileRepository, "profileRepository");
            return new com.coffemeetsbagel.hide_report.a(profileRepository);
        }

        public final GenericMatchContainerV2Presenter b() {
            return new GenericMatchContainerV2Presenter(this.f11042a, this.f11043b);
        }
    }

    public interface c {
        ProfileRepository A();

        SaveAnswerUseCase D();

        v7.d G();

        x J();

        a6.a N();

        a7.a R();

        e Y();

        c6.b a0();

        s9.a b();

        ProfileContract$Manager d();

        UserRepository e();

        cb.a f();

        com.coffeemeetsbagel.qna.j f0();

        BuySubscriptionUseCase g();

        GetMyOwnProfileLocalUseCase h();

        k0 j();

        QuestionRepository k();

        SubscriptionRepository m();

        androidx.appcompat.app.c n();

        DeletePromptAnswerUseCase o();

        c9.d p();

        g q();

        y6.a s();

        bb.a u();

        GetGroupOptionsRemainingUseCase v();

        LoadProfileUseCase w();

        GetActivityReportUseCase y();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final i b(ViewGroup viewGroup, boolean z10, Bagel bagel, String str, boolean z11, String str2, boolean z12, String str3, boolean z13) {
        ViewGroup viewGroup2 = viewGroup;
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(str, "profileId");
        GenericMatchContainerV2Interactor genericMatchContainerV2Interactor = new GenericMatchContainerV2Interactor(bagel, str, z11, str2, z12, str3, z13);
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bagel_profile_main, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.bagel_profile.main.GenericMatchContainerView");
        GenericMatchContainerView genericMatchContainerView = (GenericMatchContainerView) inflate;
        a b10 = b.a().a(new b(genericMatchContainerView, genericMatchContainerV2Interactor)).c((c) a()).b();
        kotlin.jvm.internal.j.f(b10, "builder()\n              …\n                .build()");
        return new i(genericMatchContainerView, b10, genericMatchContainerV2Interactor, viewGroup);
    }
}
