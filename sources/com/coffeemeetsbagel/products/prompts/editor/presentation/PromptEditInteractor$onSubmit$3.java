package com.coffeemeetsbagel.products.prompts.editor.presentation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PromptEditInteractor$onSubmit$3 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ PromptEditInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptEditInteractor$onSubmit$3(PromptEditInteractor promptEditInteractor) {
        super(1);
        this.this$0 = promptEditInteractor;
    }

    public final void a(Throwable th2) {
        this.this$0.X1(false);
        PromptEditInteractor promptEditInteractor = this.this$0;
        j.f(th2, "throwable");
        promptEditInteractor.R1(th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
