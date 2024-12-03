package com.coffeemeetsbagel.products.prompts.selection.presentation;

import android.view.ViewGroup;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import r7.h;

final class PromptSelectionPresenter$progressDialog$2 extends Lambda implements Function0<h> {
    final /* synthetic */ PromptSelectionPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptSelectionPresenter$progressDialog$2(PromptSelectionPresenter promptSelectionPresenter) {
        super(0);
        this.this$0 = promptSelectionPresenter;
    }

    /* renamed from: a */
    public final h invoke() {
        return new h(((ViewGroup) this.this$0.f7869c).getContext());
    }
}
