package com.coffeemeetsbagel.products.prompts.editor.presentation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tj.b;

final class PromptEditInteractor$onSubmit$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ PromptEditInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptEditInteractor$onSubmit$1(PromptEditInteractor promptEditInteractor) {
        super(1);
        this.this$0 = promptEditInteractor;
    }

    public final void a(b bVar) {
        this.this$0.X1(true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}
