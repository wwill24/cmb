package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.dto.ActionCard;
import com.coffeemeetsbagel.models.responses.ResponseActionCard;
import com.coffeemeetsbagel.models.responses.ResponseActionCards;
import com.coffeemeetsbagel.models.responses.ResponseActionCardsV1;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import v6.a;

final class ActionCardRepository$fetchFromNetworkAndSaveToDb$2 extends Lambda implements Function1<ResponseActionCards, b0<? extends List<? extends ActionCard>>> {
    final /* synthetic */ ActionCardRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardRepository$fetchFromNetworkAndSaveToDb$2(ActionCardRepository actionCardRepository) {
        super(1);
        this.this$0 = actionCardRepository;
    }

    /* renamed from: a */
    public final b0<? extends List<ActionCard>> invoke(ResponseActionCards responseActionCards) {
        List<ResponseActionCard> list;
        boolean z10;
        j.g(responseActionCards, "it");
        ResponseActionCardsV1 data = responseActionCards.getData();
        if (data != null) {
            list = data.getV1();
        } else {
            list = null;
        }
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return w.t(new UnknownServiceException("server return no action card"));
        }
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (ResponseActionCard a10 : list) {
            arrayList.add(a.f18073a.a(a10));
        }
        return this.this$0.f12387b.c(arrayList);
    }
}
