package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.today_view.card.actioncards.b;
import fj.d;
import fj.g;
import fk.a;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

public final class c implements d<ActionCardPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final b.C0463b f37293a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PublishSubject<Unit>> f37294b;

    public c(b.C0463b bVar, a<PublishSubject<Unit>> aVar) {
        this.f37293a = bVar;
        this.f37294b = aVar;
    }

    public static ActionCardPresenter a(b.C0463b bVar, PublishSubject<Unit> publishSubject) {
        return (ActionCardPresenter) g.e(bVar.a(publishSubject));
    }

    public static c b(b.C0463b bVar, a<PublishSubject<Unit>> aVar) {
        return new c(bVar, aVar);
    }

    /* renamed from: c */
    public ActionCardPresenter get() {
        return a(this.f37293a, this.f37294b.get());
    }
}
