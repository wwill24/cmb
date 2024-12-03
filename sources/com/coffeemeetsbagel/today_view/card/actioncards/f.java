package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.today_view.card.actioncards.b;
import fj.d;
import fk.a;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import qj.h;

public final class f implements d<h<Unit>> {

    /* renamed from: a  reason: collision with root package name */
    private final b.C0463b f37298a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PublishSubject<Unit>> f37299b;

    public f(b.C0463b bVar, a<PublishSubject<Unit>> aVar) {
        this.f37298a = bVar;
        this.f37299b = aVar;
    }

    public static f a(b.C0463b bVar, a<PublishSubject<Unit>> aVar) {
        return new f(bVar, aVar);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [io.reactivex.subjects.PublishSubject, io.reactivex.subjects.PublishSubject<kotlin.Unit>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static qj.h<kotlin.Unit> c(com.coffeemeetsbagel.today_view.card.actioncards.b.C0463b r0, io.reactivex.subjects.PublishSubject<kotlin.Unit> r1) {
        /*
            qj.h r0 = r0.d(r1)
            java.lang.Object r0 = fj.g.e(r0)
            qj.h r0 = (qj.h) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.today_view.card.actioncards.f.c(com.coffeemeetsbagel.today_view.card.actioncards.b$b, io.reactivex.subjects.PublishSubject):qj.h");
    }

    /* renamed from: b */
    public h<Unit> get() {
        return c(this.f37298a, this.f37299b.get());
    }
}
