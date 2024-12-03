package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class SuggestedRepository$syncSuggestedLimitsFromNetwork$2 extends Lambda implements Function1<Long, f> {
    final /* synthetic */ SuggestedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedRepository$syncSuggestedLimitsFromNetwork$2(SuggestedRepository suggestedRepository) {
        super(1);
        this.this$0 = suggestedRepository;
    }

    /* renamed from: a */
    public final f invoke(Long l10) {
        j.g(l10, "previousDateInMillis");
        return this.this$0.I(l10.longValue());
    }
}
