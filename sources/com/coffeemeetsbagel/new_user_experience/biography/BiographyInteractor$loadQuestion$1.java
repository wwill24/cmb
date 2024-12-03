package com.coffeemeetsbagel.new_user_experience.biography;

import ab.a;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BiographyInteractor$loadQuestion$1 extends Lambda implements Function1<a, QuestionWAnswers> {
    final /* synthetic */ ProfileQuestion $question;
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$loadQuestion$1(BiographyInteractor biographyInteractor, ProfileQuestion profileQuestion) {
        super(1);
        this.this$0 = biographyInteractor;
        this.$question = profileQuestion;
    }

    /* renamed from: a */
    public final QuestionWAnswers invoke(a aVar) {
        j.g(aVar, "group");
        List<QuestionWAnswers> b10 = aVar.b();
        ProfileQuestion profileQuestion = this.$question;
        for (QuestionWAnswers questionWAnswers : b10) {
            if (j.b(questionWAnswers.e().getName(), profileQuestion.getApiKey())) {
                this.this$0.f34824z.put(questionWAnswers.e().getName(), questionWAnswers.e().getId());
                return questionWAnswers;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
