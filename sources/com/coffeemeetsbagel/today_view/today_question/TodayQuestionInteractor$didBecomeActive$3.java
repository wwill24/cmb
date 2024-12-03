package com.coffeemeetsbagel.today_view.today_question;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class TodayQuestionInteractor$didBecomeActive$3 extends Lambda implements Function1<List<? extends QuestionWAnswers>, QuestionWAnswers> {

    /* renamed from: a  reason: collision with root package name */
    public static final TodayQuestionInteractor$didBecomeActive$3 f37510a = new TodayQuestionInteractor$didBecomeActive$3();

    TodayQuestionInteractor$didBecomeActive$3() {
        super(1);
    }

    /* renamed from: a */
    public final QuestionWAnswers invoke(List<QuestionWAnswers> list) {
        j.g(list, "questionList");
        return list.get(0);
    }
}
