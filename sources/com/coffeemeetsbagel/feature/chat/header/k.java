package com.coffeemeetsbagel.feature.chat.header;

import android.content.Intent;
import android.view.View;
import b6.u;
import com.coffeemeetsbagel.bagel_profile.BagelProfileComponentActivity;
import com.coffeemeetsbagel.feature.chat.header.a;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.util.RequestCode;
import k6.c0;
import kotlin.jvm.internal.j;

public final class k extends u<View, a.C0135a, ChatHeaderInteractor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(c0 c0Var, a.C0135a aVar, ChatHeaderInteractor chatHeaderInteractor) {
        super(c0Var.getRoot(), aVar, chatHeaderInteractor);
        j.g(c0Var, "view");
        j.g(aVar, "component");
        j.g(chatHeaderInteractor, "interactor");
    }

    public final void m(Bagel bagel) {
        j.g(bagel, Extra.BAGEL);
        Intent intent = new Intent(((a.C0135a) e()).i(), BagelProfileComponentActivity.class);
        intent.putExtra(Extra.BAGEL, bagel);
        intent.putExtra("source", ModelDeeplinkData.VALUE_PAGE_CHAT);
        intent.putExtra(Extra.MATCH_TYPE, Extra.BAGEL);
        intent.putExtra(Extra.IS_CONNECTED, bagel.isConnected());
        ((a.C0135a) e()).i().startActivityForResult(intent, RequestCode.GENERIC);
    }
}
