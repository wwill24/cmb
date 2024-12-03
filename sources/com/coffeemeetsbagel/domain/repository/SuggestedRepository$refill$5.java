package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.Bagel;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedRepository$refill$5 extends Lambda implements Function1<List<? extends Bagel>, List<? extends Bagel>> {
    final /* synthetic */ SuggestedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedRepository$refill$5(SuggestedRepository suggestedRepository) {
        super(1);
        this.this$0 = suggestedRepository;
    }

    /* renamed from: a */
    public final List<Bagel> invoke(List<? extends Bagel> list) {
        j.g(list, "bagels");
        this.this$0.f12457g.a(list);
        return list;
    }
}
