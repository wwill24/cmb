package com.coffeemeetsbagel.qna.data;

import com.coffeemeetsbagel.models.responses.ResponsePeriodicQuestions;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.network.NetworkPeriodicQuestion;
import com.coffeemeetsbagel.qna.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class QuestionRepository$getQuestions$2 extends Lambda implements Function1<ResponsePeriodicQuestions, List<? extends QuestionWAnswers>> {

    /* renamed from: a  reason: collision with root package name */
    public static final QuestionRepository$getQuestions$2 f36245a = new QuestionRepository$getQuestions$2();

    QuestionRepository$getQuestions$2() {
        super(1);
    }

    /* renamed from: a */
    public final List<QuestionWAnswers> invoke(ResponsePeriodicQuestions responsePeriodicQuestions) {
        j.g(responsePeriodicQuestions, "responsePeriodicQuestions");
        List<NetworkPeriodicQuestion> questions = responsePeriodicQuestions.getData().getQuestions();
        ArrayList arrayList = new ArrayList(r.t(questions, 10));
        for (NetworkPeriodicQuestion networkPeriodicQuestion : questions) {
            arrayList.add(new QuestionWAnswers(r.h(networkPeriodicQuestion.getQuestion(), networkPeriodicQuestion.getQuestionGroupName()), q.j()));
        }
        return arrayList;
    }
}
