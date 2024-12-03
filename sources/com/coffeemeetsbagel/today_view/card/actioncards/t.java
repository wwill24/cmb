package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.match.k;
import com.coffeemeetsbagel.models.responses.ResponseBagel;

public final /* synthetic */ class t implements k {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActionCardInteractor f37324a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j.d f37325b;

    public /* synthetic */ t(ActionCardInteractor actionCardInteractor, j.d dVar) {
        this.f37324a = actionCardInteractor;
        this.f37325b = dVar;
    }

    public final void onSuccess(Object obj) {
        ActionCardInteractor.S2(this.f37324a, this.f37325b, (ResponseBagel) obj);
    }
}
