package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BiographyInteractor$navigateToDegree$1 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ boolean $goingForwards;
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$navigateToDegree$1(BiographyInteractor biographyInteractor, boolean z10) {
        super(1);
        this.this$0 = biographyInteractor;
        this.$goingForwards = z10;
    }

    public final void a(QuestionWAnswers questionWAnswers) {
        String str;
        List<Option> options = questionWAnswers.e().getOptions();
        ArrayList arrayList = new ArrayList(r.t(options, 10));
        for (Option option : options) {
            arrayList.add(new Resource(option.getId(), option.getTitle(), ""));
        }
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (answer != null) {
            str = answer.getOptionId();
        } else {
            str = null;
        }
        ((BiographyPresenter) this.this$0.f7875e).F(arrayList, str, this.$goingForwards);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}
