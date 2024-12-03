package com.coffeemeetsbagel.qna.data;

import com.coffeemeetsbagel.models.responses.ResponseQuestionGroup;
import com.coffeemeetsbagel.qna.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import za.g;

final class QuestionRepository$fetchFromNetworkAndSave$1 extends Lambda implements Function1<ResponseQuestionGroup, g> {
    final /* synthetic */ String $profileId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionRepository$fetchFromNetworkAndSave$1(String str) {
        super(1);
        this.$profileId = str;
    }

    /* renamed from: a */
    public final g invoke(ResponseQuestionGroup responseQuestionGroup) {
        j.g(responseQuestionGroup, "it");
        return r.c(responseQuestionGroup, this.$profileId);
    }
}
