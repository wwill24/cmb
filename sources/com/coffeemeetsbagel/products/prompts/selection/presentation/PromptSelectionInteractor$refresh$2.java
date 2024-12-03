package com.coffeemeetsbagel.products.prompts.selection.presentation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import rn.c;

final class PromptSelectionInteractor$refresh$2 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ PromptSelectionInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptSelectionInteractor$refresh$2(PromptSelectionInteractor promptSelectionInteractor) {
        super(1);
        this.this$0 = promptSelectionInteractor;
    }

    public final void a(c cVar) {
        this.this$0.f2(true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((c) obj);
        return Unit.f32013a;
    }
}
