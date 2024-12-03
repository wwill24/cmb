package com.coffeemeetsbagel.qna.data;

import fa.a;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import za.g;

final class QuestionRepository$fetchFromNetworkAndSave$2 extends Lambda implements Function1<g, b0<? extends List<? extends Long>>> {
    final /* synthetic */ String $profileId;
    final /* synthetic */ boolean $shouldUpdateQuestions;
    final /* synthetic */ QuestionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionRepository$fetchFromNetworkAndSave$2(QuestionRepository questionRepository, String str, boolean z10) {
        super(1);
        this.this$0 = questionRepository;
        this.$profileId = str;
        this.$shouldUpdateQuestions = z10;
    }

    /* renamed from: a */
    public final b0<? extends List<Long>> invoke(g gVar) {
        j.g(gVar, "questionGroupEntity");
        a.f40771d.a(this.this$0.f36242f, "Saving remote data to local DB (source of truth)");
        return this.this$0.Z(this.$profileId, gVar, this.$shouldUpdateQuestions);
    }
}
