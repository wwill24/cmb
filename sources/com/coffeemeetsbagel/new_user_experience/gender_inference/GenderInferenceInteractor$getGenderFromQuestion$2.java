package com.coffeemeetsbagel.new_user_experience.gender_inference;

import ab.a;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.enums.InferredGenderOptions;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GenderInferenceInteractor$getGenderFromQuestion$2 extends Lambda implements Function1<a, InferredGenderOptions> {
    final /* synthetic */ GenderInferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderInferenceInteractor$getGenderFromQuestion$2(GenderInferenceInteractor genderInferenceInteractor) {
        super(1);
        this.this$0 = genderInferenceInteractor;
    }

    /* renamed from: a */
    public final InferredGenderOptions invoke(a aVar) {
        String str;
        T t10;
        j.g(aVar, "group");
        for (QuestionWAnswers questionWAnswers : aVar.b()) {
            if (j.b(questionWAnswers.e().getName(), ProfileQuestion.GENDER.getApiKey())) {
                this.this$0.k2(questionWAnswers);
                Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                String str2 = null;
                if (answer != null) {
                    str = answer.getOptionId();
                } else {
                    str = null;
                }
                Iterator<T> it = questionWAnswers.e().getOptions().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t10 = null;
                        break;
                    }
                    t10 = it.next();
                    if (j.b(((Option) t10).getId(), str)) {
                        break;
                    }
                }
                Option option = (Option) t10;
                InferredGenderOptions.Companion companion = InferredGenderOptions.Companion;
                if (option != null) {
                    str2 = option.getName();
                }
                return companion.fromString(str2);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
