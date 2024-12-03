package com.coffeemeetsbagel.match_prefs.dealbreaker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class DealbreakerSheetViewModel$observeDealbreakerCount$2 extends Lambda implements Function1<String, a<? extends Integer>> {
    final /* synthetic */ DealbreakerSheetViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DealbreakerSheetViewModel$observeDealbreakerCount$2(DealbreakerSheetViewModel dealbreakerSheetViewModel) {
        super(1);
        this.this$0 = dealbreakerSheetViewModel;
    }

    /* renamed from: a */
    public final a<? extends Integer> invoke(String str) {
        j.g(str, "profileId");
        return this.this$0.l().G(str);
    }
}
