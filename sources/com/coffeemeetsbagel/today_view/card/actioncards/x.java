package com.coffeemeetsbagel.today_view.card.actioncards;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class x implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f37328a;

    public /* synthetic */ x(Function1 function1) {
        this.f37328a = function1;
    }

    public final void accept(Object obj) {
        ActionCardPresenter.n(this.f37328a, obj);
    }
}
