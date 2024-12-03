package com.coffeemeetsbagel.products.prompts.selection.presentation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PromptSelectionInteractor$refresh$6 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ PromptSelectionInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptSelectionInteractor$refresh$6(PromptSelectionInteractor promptSelectionInteractor) {
        super(1);
        this.this$0 = promptSelectionInteractor;
    }

    public final void a(Throwable th2) {
        PromptSelectionInteractor promptSelectionInteractor = this.this$0;
        j.f(th2, "throwable");
        promptSelectionInteractor.W1(th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
