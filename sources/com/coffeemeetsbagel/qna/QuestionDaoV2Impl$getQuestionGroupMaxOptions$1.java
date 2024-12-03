package com.coffeemeetsbagel.qna;

import java.util.List;
import java.util.OptionalInt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class QuestionDaoV2Impl$getQuestionGroupMaxOptions$1 extends Lambda implements Function1<List<? extends Integer>, OptionalInt> {

    /* renamed from: a  reason: collision with root package name */
    public static final QuestionDaoV2Impl$getQuestionGroupMaxOptions$1 f36214a = new QuestionDaoV2Impl$getQuestionGroupMaxOptions$1();

    QuestionDaoV2Impl$getQuestionGroupMaxOptions$1() {
        super(1);
    }

    /* renamed from: a */
    public final OptionalInt invoke(List<Integer> list) {
        j.g(list, "list");
        return CollectionsKt___CollectionsKt.P(list) == null ? OptionalInt.empty() : OptionalInt.of(list.get(0).intValue());
    }
}
