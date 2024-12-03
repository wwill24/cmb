package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.profile.n;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;

final class MatchViewInteractor$didBecomeActive$1 extends Lambda implements Function1<LoadProfileUseCase.a, Unit> {
    final /* synthetic */ MatchViewInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewInteractor$didBecomeActive$1(MatchViewInteractor matchViewInteractor) {
        super(1);
        this.this$0 = matchViewInteractor;
    }

    public final void a(LoadProfileUseCase.a aVar) {
        String str;
        String str2;
        this.this$0.s2(aVar.j(), aVar.h(), aVar.g());
        String str3 = null;
        if (this.this$0.C2().a("ProfileMigration.Enabled.Android")) {
            MatchViewInteractor matchViewInteractor = this.this$0;
            matchViewInteractor.Y2(matchViewInteractor.t2(aVar.f(), ProfileQuestion.LOCATION.getApiKey()), aVar.h());
            MatchViewInteractor matchViewInteractor2 = this.this$0;
            QuestionWAnswers W1 = matchViewInteractor2.t2(aVar.f(), ProfileQuestion.OCCUPATION.getApiKey());
            if (W1 != null) {
                str = MatchViewInteractor.z2(this.this$0, W1, (Boolean) null, 1, (Object) null);
            } else {
                str = null;
            }
            QuestionWAnswers W12 = this.this$0.t2(aVar.f(), ProfileQuestion.EMPLOYER.getApiKey());
            if (W12 != null) {
                str2 = MatchViewInteractor.z2(this.this$0, W12, (Boolean) null, 1, (Object) null);
            } else {
                str2 = null;
            }
            matchViewInteractor2.Z2(str, str2);
            List h02 = CollectionsKt___CollectionsKt.h0(aVar.c(), aVar.d());
            MatchViewInteractor matchViewInteractor3 = this.this$0;
            QuestionWAnswers W13 = matchViewInteractor3.t2(h02, ProfileQuestion.SCHOOL_ONE.getApiKey(), ProfileQuestion.SCHOOL_TWO.getApiKey());
            if (W13 != null) {
                str3 = MatchViewInteractor.z2(this.this$0, W13, (Boolean) null, 1, (Object) null);
            }
            matchViewInteractor3.d3(str3);
        } else {
            this.this$0.X2(aVar.h());
            this.this$0.Z2(aVar.h().l(), aVar.h().e());
            MatchViewInteractor matchViewInteractor4 = this.this$0;
            n d10 = aVar.h().d();
            if (d10 != null) {
                str3 = d10.b();
            }
            matchViewInteractor4.d3(str3);
        }
        MatchViewInteractor matchViewInteractor5 = this.this$0;
        j.f(aVar, MamElements.MamResultExtension.ELEMENT);
        matchViewInteractor5.x3(aVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((LoadProfileUseCase.a) obj);
        return Unit.f32013a;
    }
}
