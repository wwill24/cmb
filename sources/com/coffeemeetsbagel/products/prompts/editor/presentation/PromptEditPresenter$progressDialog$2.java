package com.coffeemeetsbagel.products.prompts.editor.presentation;

import android.view.ViewGroup;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import r7.h;

final class PromptEditPresenter$progressDialog$2 extends Lambda implements Function0<h> {
    final /* synthetic */ PromptEditPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptEditPresenter$progressDialog$2(PromptEditPresenter promptEditPresenter) {
        super(0);
        this.this$0 = promptEditPresenter;
    }

    /* renamed from: a */
    public final h invoke() {
        return new h(((ViewGroup) this.this$0.f7869c).getContext());
    }
}
