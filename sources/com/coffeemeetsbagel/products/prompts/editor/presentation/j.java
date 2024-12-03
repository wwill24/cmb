package com.coffeemeetsbagel.products.prompts.editor.presentation;

import com.coffeemeetsbagel.products.prompts.editor.presentation.g;
import fj.d;
import fk.a;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

public final class j implements d<PromptEditPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final g.b f35941a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PublishSubject<Unit>> f35942b;

    public j(g.b bVar, a<PublishSubject<Unit>> aVar) {
        this.f35941a = bVar;
        this.f35942b = aVar;
    }

    public static j a(g.b bVar, a<PublishSubject<Unit>> aVar) {
        return new j(bVar, aVar);
    }

    public static PromptEditPresenter c(g.b bVar, PublishSubject<Unit> publishSubject) {
        return (PromptEditPresenter) fj.g.e(bVar.c(publishSubject));
    }

    /* renamed from: b */
    public PromptEditPresenter get() {
        return c(this.f35941a, this.f35942b.get());
    }
}
