package com.coffeemeetsbagel.qna.data;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.QnaPair;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class QuestionRepository$fetchFromNetworkAndSave$3 extends Lambda implements Function1<List<? extends Long>, a<? extends List<? extends QnaPair>>> {
    final /* synthetic */ QuestionGroupType $groupType;
    final /* synthetic */ String $profileId;
    final /* synthetic */ QuestionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionRepository$fetchFromNetworkAndSave$3(QuestionRepository questionRepository, String str, QuestionGroupType questionGroupType) {
        super(1);
        this.this$0 = questionRepository;
        this.$profileId = str;
        this.$groupType = questionGroupType;
    }

    /* renamed from: a */
    public final a<? extends List<QnaPair>> invoke(List<Long> list) {
        j.g(list, "it");
        return this.this$0.f36240d.k(this.$profileId, this.$groupType.getQuestionGroupApiString());
    }
}
