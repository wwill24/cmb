package com.coffeemeetsbagel.suggested_history.suggested_history_list;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import vb.a;

final class SuggestedHistoryListInteractor$didBecomeActive$1 extends Lambda implements Function1<Optional<a>, b0<? extends Pair<? extends List<? extends Bagel>, ? extends Optional<a>>>> {
    final /* synthetic */ SuggestedHistoryListInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryListInteractor$didBecomeActive$1(SuggestedHistoryListInteractor suggestedHistoryListInteractor) {
        super(1);
        this.this$0 = suggestedHistoryListInteractor;
    }

    /* access modifiers changed from: private */
    public static final Pair d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends Pair<List<Bagel>, Optional<a>>> invoke(final Optional<a> optional) {
        j.g(optional, "subscription");
        return this.this$0.T1().c().D(new m(new Function1<List<? extends Bagel>, Pair<? extends List<? extends Bagel>, ? extends Optional<a>>>() {
            /* renamed from: a */
            public final Pair<List<Bagel>, Optional<a>> invoke(List<? extends Bagel> list) {
                j.g(list, "bagelsList");
                return new Pair<>(list, optional);
            }
        }));
    }
}
