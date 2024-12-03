package com.coffeemeetsbagel.products.my_answers.presentation;

import com.coffeemeetsbagel.products.my_answers.presentation.m;
import fj.d;
import fj.g;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

public final class o implements d<PublishSubject<Unit>> {

    /* renamed from: a  reason: collision with root package name */
    private final m.b f35886a;

    public o(m.b bVar) {
        this.f35886a = bVar;
    }

    public static PublishSubject<Unit> a(m.b bVar) {
        return (PublishSubject) g.e(bVar.b());
    }

    public static o b(m.b bVar) {
        return new o(bVar);
    }

    /* renamed from: c */
    public PublishSubject<Unit> get() {
        return a(this.f35886a);
    }
}
