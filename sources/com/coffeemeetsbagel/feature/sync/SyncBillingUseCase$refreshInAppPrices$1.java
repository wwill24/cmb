package com.coffeemeetsbagel.feature.sync;

import fa.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class SyncBillingUseCase$refreshInAppPrices$1 extends Lambda implements Function1<Throwable, f> {
    final /* synthetic */ SyncBillingUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SyncBillingUseCase$refreshInAppPrices$1(SyncBillingUseCase syncBillingUseCase) {
        super(1);
        this.this$0 = syncBillingUseCase;
    }

    /* renamed from: a */
    public final f invoke(Throwable th2) {
        j.g(th2, "throwable");
        a.f40771d.c(this.this$0.f13412g, "Failed to refresh bean prices.", th2);
        return qj.a.m();
    }
}
