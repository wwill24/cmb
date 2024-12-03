package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.o;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import ja.b;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BiographyInteractor$navigateToHeight$2 extends Lambda implements Function1<Pair<? extends QuestionWAnswers, ? extends b>, Unit> {
    final /* synthetic */ boolean $goingForwards;
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$navigateToHeight$2(BiographyInteractor biographyInteractor, boolean z10) {
        super(1);
        this.this$0 = biographyInteractor;
        this.$goingForwards = z10;
    }

    public final void a(Pair<QuestionWAnswers, b> pair) {
        Float f10;
        o oVar;
        Integer num;
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(pair.c().d());
        Integer num2 = null;
        if (answer != null) {
            f10 = answer.getFloatValue();
        } else {
            f10 = null;
        }
        if (pair.d().x()) {
            BiographyPresenter biographyPresenter = (BiographyPresenter) this.this$0.f7875e;
            if (f10 != null) {
                num2 = Integer.valueOf((int) f10.floatValue());
            }
            biographyPresenter.M(num2, 168, this.$goingForwards);
            return;
        }
        if (f10 != null) {
            oVar = new o(f10.floatValue());
        } else {
            oVar = null;
        }
        BiographyPresenter biographyPresenter2 = (BiographyPresenter) this.this$0.f7875e;
        if (oVar != null) {
            num = Integer.valueOf(oVar.b());
        } else {
            num = null;
        }
        if (oVar != null) {
            num2 = Integer.valueOf(oVar.c());
        }
        biographyPresenter2.K(num, num2, 5, 6, this.$goingForwards);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
