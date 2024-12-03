package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class QuestionGroupRefreshUseCase$generateSources$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ QuestionGroupType $type;
    final /* synthetic */ QuestionGroupRefreshUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionGroupRefreshUseCase$generateSources$1$1(QuestionGroupRefreshUseCase questionGroupRefreshUseCase, QuestionGroupType questionGroupType) {
        super(1);
        this.this$0 = questionGroupRefreshUseCase;
        this.$type = questionGroupType;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String f10 = this.this$0.f36219d;
        j.f(f10, "tag");
        j.f(th2, "throwable");
        aVar.c(f10, "Failed to sync " + this.$type + '.', th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
