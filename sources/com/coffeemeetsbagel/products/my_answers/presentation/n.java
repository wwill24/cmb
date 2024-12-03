package com.coffeemeetsbagel.products.my_answers.presentation;

import com.coffeemeetsbagel.products.my_answers.presentation.m;
import fj.d;
import fk.a;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import qj.h;

public final class n implements d<h<Unit>> {

    /* renamed from: a  reason: collision with root package name */
    private final m.b f35884a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PublishSubject<Unit>> f35885b;

    public n(m.b bVar, a<PublishSubject<Unit>> aVar) {
        this.f35884a = bVar;
        this.f35885b = aVar;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [io.reactivex.subjects.PublishSubject, io.reactivex.subjects.PublishSubject<kotlin.Unit>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static qj.h<kotlin.Unit> a(com.coffeemeetsbagel.products.my_answers.presentation.m.b r0, io.reactivex.subjects.PublishSubject<kotlin.Unit> r1) {
        /*
            qj.h r0 = r0.a(r1)
            java.lang.Object r0 = fj.g.e(r0)
            qj.h r0 = (qj.h) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.products.my_answers.presentation.n.a(com.coffeemeetsbagel.products.my_answers.presentation.m$b, io.reactivex.subjects.PublishSubject):qj.h");
    }

    public static n b(m.b bVar, a<PublishSubject<Unit>> aVar) {
        return new n(bVar, aVar);
    }

    /* renamed from: c */
    public h<Unit> get() {
        return a(this.f35884a, this.f35885b.get());
    }
}
