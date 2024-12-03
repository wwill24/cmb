package com.coffeemeetsbagel.profile;

import ja.b;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class RefreshMyProfileUseCase$invoke$2 extends Lambda implements Function1<List<? extends Long>, b0<? extends b>> {
    final /* synthetic */ RefreshMyProfileUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RefreshMyProfileUseCase$invoke$2(RefreshMyProfileUseCase refreshMyProfileUseCase) {
        super(1);
        this.this$0 = refreshMyProfileUseCase;
    }

    /* renamed from: a */
    public final b0<? extends b> invoke(List<Long> list) {
        j.g(list, "it");
        return this.this$0.f36061a.o();
    }
}
