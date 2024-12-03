package com.coffeemeetsbagel.dialogs;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ChipSelectQuestionDialog$dismiss$1$disposable$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ ChipSelectQuestionDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipSelectQuestionDialog$dismiss$1$disposable$2(ChipSelectQuestionDialog chipSelectQuestionDialog) {
        super(1);
        this.this$0 = chipSelectQuestionDialog;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String r10 = this.this$0.r();
        j.f(th2, "error");
        aVar.c(r10, "Failed to save selection.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
