package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import za.b;
import za.i;

final class QuestionDaoV2Impl$getQuestionWithAnswers$1 extends Lambda implements Function2<List<? extends i>, List<? extends b>, Pair<? extends i, ? extends List<? extends b>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final QuestionDaoV2Impl$getQuestionWithAnswers$1 f36215a = new QuestionDaoV2Impl$getQuestionWithAnswers$1();

    QuestionDaoV2Impl$getQuestionWithAnswers$1() {
        super(2);
    }

    /* renamed from: a */
    public final Pair<i, List<b>> invoke(List<i> list, List<b> list2) {
        j.g(list, ProfileConstants.Field.QUESTIONS);
        j.g(list2, "answers");
        return new Pair<>(list.get(0), list2);
    }
}
