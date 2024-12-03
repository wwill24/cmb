package com.coffeemeetsbagel.suggested_history.suggested_history_list;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.a;

final class SuggestedHistoryListInteractor$didBecomeActive$2 extends Lambda implements Function1<Pair<? extends List<? extends Bagel>, ? extends Optional<a>>, Unit> {
    final /* synthetic */ SuggestedHistoryListInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryListInteractor$didBecomeActive$2(SuggestedHistoryListInteractor suggestedHistoryListInteractor) {
        super(1);
        this.this$0 = suggestedHistoryListInteractor;
    }

    public final void a(Pair<? extends List<? extends Bagel>, ? extends Optional<a>> pair) {
        List list = (List) pair.a();
        SuggestedHistoryListInteractor suggestedHistoryListInteractor = this.this$0;
        j.f(list, "bagelList");
        suggestedHistoryListInteractor.X1(list, ((Optional) pair.b()).d());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
