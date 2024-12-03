package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.ActionCardBody;
import com.coffeemeetsbagel.models.dto.ActionCard;
import com.coffeemeetsbagel.models.responses.ResponseActionCards;
import hb.c;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ma.a;
import qj.b0;
import qj.w;

public final class ActionCardRepository {

    /* renamed from: a  reason: collision with root package name */
    private final a f12386a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final u6.a f12387b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c f12388c;

    public ActionCardRepository(a aVar, u6.a aVar2, c cVar) {
        j.g(aVar, "actionCardService");
        j.g(aVar2, "actionCardDao");
        j.g(cVar, "sharedPrefsManager");
        this.f12386a = aVar;
        this.f12387b = aVar2;
        this.f12388c = cVar;
    }

    /* access modifiers changed from: private */
    public final w<List<ActionCard>> h() {
        w<R> v10 = this.f12386a.a().r(new c(new ActionCardRepository$fetchFromNetworkAndSaveToDb$1(this))).v(new d(new ActionCardRepository$fetchFromNetworkAndSaveToDb$2(this)));
        j.f(v10, "private fun fetchFromNet…    }\n            }\n    }");
        return v10;
    }

    /* access modifiers changed from: private */
    public static final void i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 j(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Long l(ActionCardRepository actionCardRepository) {
        j.g(actionCardRepository, "this$0");
        return Long.valueOf(actionCardRepository.f12388c.t("last_fetch_action_card_timestamp"));
    }

    /* access modifiers changed from: private */
    public static final b0 m(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final w<List<ActionCard>> k() {
        w<List<ActionCard>> v10 = w.A(new a(this)).K(dk.a.c()).v(new b(new ActionCardRepository$getActionCards$2(this)));
        j.f(v10, "fun getActionCards(): Si…}\n                }\n    }");
        return v10;
    }

    public final void n() {
        this.f12388c.e("last_fetch_action_card_timestamp");
    }

    public final w<ResponseActionCards> o(ActionCardBody actionCardBody) {
        j.g(actionCardBody, "actionCardBody");
        w<ResponseActionCards> K = this.f12386a.b(actionCardBody).K(dk.a.c());
        j.f(K, "actionCardService.action…scribeOn(Schedulers.io())");
        return K;
    }
}
