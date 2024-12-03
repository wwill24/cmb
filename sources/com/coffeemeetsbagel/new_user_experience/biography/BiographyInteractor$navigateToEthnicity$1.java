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

final class BiographyInteractor$navigateToEthnicity$1 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ boolean $goingForwards;
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$navigateToEthnicity$1(BiographyInteractor biographyInteractor, boolean z10) {
        super(1);
        this.this$0 = biographyInteractor;
        this.$goingForwards = z10;
    }

    public final void a(QuestionWAnswers questionWAnswers) {
        List<Option> options = questionWAnswers.e().getOptions();
        ArrayList arrayList = new ArrayList(r.t(options, 10));
        for (Option option : options) {
            arrayList.add(new Resource(option.getId(), option.getTitle(), ""));
        }
        List<Answer> d10 = questionWAnswers.d();
        ArrayList arrayList2 = new ArrayList(r.t(d10, 10));
        for (Answer optionId : d10) {
            arrayList2.add(optionId.getOptionId());
        }
        List<Option> options2 = questionWAnswers.e().getOptions();
        ArrayList<Option> arrayList3 = new ArrayList<>();
        for (T next : options2) {
            if (arrayList2.contains(((Option) next).getId())) {
                arrayList3.add(next);
            }
        }
        ArrayList arrayList4 = new ArrayList(r.t(arrayList3, 10));
        for (Option title : arrayList3) {
            arrayList4.add(title.getTitle());
        }
        ((BiographyPresenter) this.this$0.f7875e).H(arrayList, arrayList4, this.$goingForwards);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}
