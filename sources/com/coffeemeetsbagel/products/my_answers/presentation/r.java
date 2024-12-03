package com.coffeemeetsbagel.products.my_answers.presentation;

import com.coffeemeetsbagel.products.my_answers.presentation.m;
import fj.d;
import fj.g;
import fk.a;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

public final class r implements d<MyAnswersPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final m.b f35890a;

    /* renamed from: b  reason: collision with root package name */
    private final a<MyAnswersAdapter> f35891b;

    /* renamed from: c  reason: collision with root package name */
    private final a<PublishSubject<Unit>> f35892c;

    public r(m.b bVar, a<MyAnswersAdapter> aVar, a<PublishSubject<Unit>> aVar2) {
        this.f35890a = bVar;
        this.f35891b = aVar;
        this.f35892c = aVar2;
    }

    public static r a(m.b bVar, a<MyAnswersAdapter> aVar, a<PublishSubject<Unit>> aVar2) {
        return new r(bVar, aVar, aVar2);
    }

    public static MyAnswersPresenter c(m.b bVar, MyAnswersAdapter myAnswersAdapter, PublishSubject<Unit> publishSubject) {
        return (MyAnswersPresenter) g.e(bVar.e(myAnswersAdapter, publishSubject));
    }

    /* renamed from: b */
    public MyAnswersPresenter get() {
        return c(this.f35890a, this.f35891b.get(), this.f35892c.get());
    }
}
