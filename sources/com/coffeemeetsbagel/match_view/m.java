package com.coffeemeetsbagel.match_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import c9.d;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match_view.MatchViewInteractor;
import com.coffeemeetsbagel.products.my_answers.presentation.m;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.ProfileView;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.g;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import net.bytebuddy.jar.asm.Opcodes;
import qj.q;

public final class m extends b6.c<u0, c> {

    public interface a extends j<MatchViewInteractor>, m.c, e.a {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ProfileView f34679a;

        /* renamed from: b  reason: collision with root package name */
        private final MatchViewInteractor f34680b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f34681c;

        public b(ProfileView profileView, MatchViewInteractor matchViewInteractor, boolean z10) {
            kotlin.jvm.internal.j.g(profileView, "profileView");
            kotlin.jvm.internal.j.g(matchViewInteractor, "interactor");
            this.f34679a = profileView;
            this.f34680b = matchViewInteractor;
            this.f34681c = z10;
        }

        public final MatchViewPresenter a() {
            return new MatchViewPresenter(this.f34679a, this.f34681c, this.f34680b);
        }

        public final ProfileStringFormatter b(bb.a aVar, d dVar) {
            kotlin.jvm.internal.j.g(aVar, "stringProvider");
            kotlin.jvm.internal.j.g(dVar, "resourcesManager");
            return new ProfileStringFormatter(aVar);
        }
    }

    public interface c {
        SaveAnswerUseCase D();

        x J();

        a6.a N();

        com.coffeemeetsbagel.qna.e O();

        SubscriptionRepository P();

        s9.a b();

        a7.a c();

        ProfileContract$Manager d();

        com.coffeemeetsbagel.qna.j d0();

        UserRepository e();

        c6.b e0();

        cb.a f();

        BuySubscriptionUseCase g();

        GetMyOwnProfileLocalUseCase h();

        QuestionRepository k();

        androidx.appcompat.app.c n();

        DeletePromptAnswerUseCase o();

        d p();

        g q();

        y6.a s();

        bb.a u();

        GetGroupOptionsRemainingUseCase v();

        LoadProfileUseCase w();

        GetActivityReportUseCase y();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public static /* synthetic */ u0 c(m mVar, ViewGroup viewGroup, boolean z10, Integer num, boolean z11, MatchIdAttribution matchIdAttribution, String str, boolean z12, String str2, boolean z13, MatchViewInteractor.b bVar, q qVar, int i10, int i11, boolean z14, String str3, String str4, int i12, Object obj) {
        int i13 = i12;
        return mVar.b(viewGroup, z10, num, z11, matchIdAttribution, str, z12, str2, z13, bVar, qVar, (i13 & 2048) != 0 ? 0 : i10, (i13 & Opcodes.ACC_SYNTHETIC) != 0 ? 0 : i11, (i13 & 8192) != 0 ? true : z14, str3, (i13 & 32768) != 0 ? "" : str4);
    }

    public final u0 b(ViewGroup viewGroup, boolean z10, Integer num, boolean z11, MatchIdAttribution matchIdAttribution, String str, boolean z12, String str2, boolean z13, MatchViewInteractor.b bVar, q<Boolean> qVar, int i10, int i11, boolean z14, String str3, String str4) {
        ViewGroup viewGroup2 = viewGroup;
        kotlin.jvm.internal.j.g(viewGroup2, "parentViewGroup");
        String str5 = str;
        kotlin.jvm.internal.j.g(str5, "profileId");
        MatchViewInteractor.b bVar2 = bVar;
        kotlin.jvm.internal.j.g(bVar2, "listener");
        q<Boolean> qVar2 = qVar;
        kotlin.jvm.internal.j.g(qVar2, "matchIsSeen");
        kotlin.jvm.internal.j.g(str4, "matchToMe");
        MatchViewInteractor matchViewInteractor = new MatchViewInteractor(z10, num, z11, matchIdAttribution, str5, i10, i11, z12, str2, z13, z14, qVar2, bVar2, str3, str4);
        View inflate = LayoutInflater.from(((c) a()).n()).inflate(R.layout.profile, viewGroup2, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.profile.ProfileView");
        ProfileView profileView = (ProfileView) inflate;
        a a10 = b.a().b(new b(profileView, matchViewInteractor, z11)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "builder()\n              …\n                .build()");
        return new u0(profileView, a10, matchViewInteractor);
    }
}
