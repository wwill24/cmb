package com.coffeemeetsbagel.qna.data;

import ab.a;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import za.b;
import za.h;

final class QuestionRepository$fetch$localStream$1 extends Lambda implements Function1<Pair<? extends List<? extends h>, ? extends List<? extends b>>, a> {
    final /* synthetic */ QuestionGroupType $groupType;
    final /* synthetic */ QuestionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionRepository$fetch$localStream$1(QuestionGroupType questionGroupType, QuestionRepository questionRepository) {
        super(1);
        this.$groupType = questionGroupType;
        this.this$0 = questionRepository;
    }

    /* renamed from: a */
    public final a invoke(Pair<? extends List<h>, ? extends List<b>> pair) {
        j.g(pair, "it");
        if (!((List) pair.c()).isEmpty()) {
            return this.this$0.u((List) pair.c(), (List) pair.d());
        }
        throw new IllegalArgumentException("group " + this.$groupType + " does not exist in db");
    }
}
