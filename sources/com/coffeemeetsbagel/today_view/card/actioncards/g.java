package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.today_view.card.actioncards.b;
import fj.d;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

public final class g implements d<PublishSubject<Unit>> {

    /* renamed from: a  reason: collision with root package name */
    private final b.C0463b f37301a;

    public g(b.C0463b bVar) {
        this.f37301a = bVar;
    }

    public static g a(b.C0463b bVar) {
        return new g(bVar);
    }

    public static PublishSubject<Unit> c(b.C0463b bVar) {
        return (PublishSubject) fj.g.e(bVar.e());
    }

    /* renamed from: b */
    public PublishSubject<Unit> get() {
        return c(this.f37301a);
    }
}
