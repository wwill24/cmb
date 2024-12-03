package com.coffeemeetsbagel.products.my_answers.presentation;

import android.view.View;
import io.reactivex.subjects.PublishSubject;

public final /* synthetic */ class i0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PublishSubject f35874a;

    public /* synthetic */ i0(PublishSubject publishSubject) {
        this.f35874a = publishSubject;
    }

    public final void onClick(View view) {
        MyAnswersPresenter.k(this.f35874a, view);
    }
}
