package com.coffeemeetsbagel.products.prompts.selection.presentation;

import com.coffeemeetsbagel.products.prompts.selection.presentation.h;
import fj.d;
import fj.g;
import fk.a;

public final class l implements d<PromptSelectionPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final h.b f35994a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PromptSelectionAdapter> f35995b;

    public l(h.b bVar, a<PromptSelectionAdapter> aVar) {
        this.f35994a = bVar;
        this.f35995b = aVar;
    }

    public static l a(h.b bVar, a<PromptSelectionAdapter> aVar) {
        return new l(bVar, aVar);
    }

    public static PromptSelectionPresenter c(h.b bVar, PromptSelectionAdapter promptSelectionAdapter) {
        return (PromptSelectionPresenter) g.e(bVar.d(promptSelectionAdapter));
    }

    /* renamed from: b */
    public PromptSelectionPresenter get() {
        return c(this.f35994a, this.f35995b.get());
    }
}
