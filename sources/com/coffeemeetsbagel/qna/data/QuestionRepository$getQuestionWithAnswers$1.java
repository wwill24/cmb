package com.coffeemeetsbagel.qna.data;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.q;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import za.b;
import za.i;

final class QuestionRepository$getQuestionWithAnswers$1 extends Lambda implements Function1<Pair<? extends i, ? extends List<? extends b>>, QuestionWAnswers> {

    /* renamed from: a  reason: collision with root package name */
    public static final QuestionRepository$getQuestionWithAnswers$1 f36244a = new QuestionRepository$getQuestionWithAnswers$1();

    QuestionRepository$getQuestionWithAnswers$1() {
        super(1);
    }

    /* renamed from: a */
    public final QuestionWAnswers invoke(Pair<i, ? extends List<b>> pair) {
        j.g(pair, "pair");
        return q.f36305a.a((List) pair.d(), p.e(pair.c())).get(0);
    }
}
