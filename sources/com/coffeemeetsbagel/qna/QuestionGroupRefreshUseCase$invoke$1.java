package com.coffeemeetsbagel.qna;

import fa.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class QuestionGroupRefreshUseCase$invoke$1 extends Lambda implements Function1<String, f> {
    final /* synthetic */ QuestionGroupRefreshUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionGroupRefreshUseCase$invoke$1(QuestionGroupRefreshUseCase questionGroupRefreshUseCase) {
        super(1);
        this.this$0 = questionGroupRefreshUseCase;
    }

    /* renamed from: a */
    public final f invoke(String str) {
        j.g(str, "profileId");
        a.C0491a aVar = a.f40771d;
        String f10 = this.this$0.f36219d;
        j.f(f10, "tag");
        aVar.a(f10, "About to start refresh.");
        QuestionGroupRefreshUseCase questionGroupRefreshUseCase = this.this$0;
        return qj.a.y(questionGroupRefreshUseCase.g(str, questionGroupRefreshUseCase.f36216a.A("ProfileMigration.Enabled.Android")));
    }
}
