package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import fa.a;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LoadProfileUseCase$questionSource$2 extends Lambda implements Function1<Throwable, List<? extends QuestionWAnswers>> {
    final /* synthetic */ QuestionGroupType $group;
    final /* synthetic */ LoadProfileUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoadProfileUseCase$questionSource$2(LoadProfileUseCase loadProfileUseCase, QuestionGroupType questionGroupType) {
        super(1);
        this.this$0 = loadProfileUseCase;
        this.$group = questionGroupType;
    }

    /* renamed from: a */
    public final List<QuestionWAnswers> invoke(Throwable th2) {
        j.g(th2, "throwable");
        a.C0491a aVar = a.f40771d;
        String d10 = this.this$0.f34608f;
        QuestionGroupType questionGroupType = this.$group;
        aVar.c(d10, "Failed to load: " + questionGroupType + " when showing profile.", th2);
        return q.j();
    }
}
