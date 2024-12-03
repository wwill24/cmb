package com.coffeemeetsbagel.today_view.card.actioncards;

import android.view.View;

public final /* synthetic */ class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActionCardPresenter f37329a;

    public /* synthetic */ y(ActionCardPresenter actionCardPresenter) {
        this.f37329a = actionCardPresenter;
    }

    public final void onClick(View view) {
        ActionCardPresenter$insufficientBeansDialog$2.d(this.f37329a, view);
    }
}
