package com.coffeemeetsbagel.products.prompts.editor.presentation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class PromptEditInteractor$didBecomeActive$1 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ PromptEditInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptEditInteractor$didBecomeActive$1(PromptEditInteractor promptEditInteractor) {
        super(1);
        this.this$0 = promptEditInteractor;
    }

    public final void a(Unit unit) {
        ((v) this.this$0.B1()).m();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Unit) obj);
        return Unit.f32013a;
    }
}
