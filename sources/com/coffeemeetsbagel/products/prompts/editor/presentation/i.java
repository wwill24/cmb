package com.coffeemeetsbagel.products.prompts.editor.presentation;

import com.coffeemeetsbagel.products.prompts.editor.presentation.g;
import fj.d;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

public final class i implements d<PublishSubject<Unit>> {

    /* renamed from: a  reason: collision with root package name */
    private final g.b f35940a;

    public i(g.b bVar) {
        this.f35940a = bVar;
    }

    public static PublishSubject<Unit> a(g.b bVar) {
        return (PublishSubject) fj.g.e(bVar.b());
    }

    public static i b(g.b bVar) {
        return new i(bVar);
    }

    /* renamed from: c */
    public PublishSubject<Unit> get() {
        return a(this.f35940a);
    }
}
