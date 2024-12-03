package com.skydoves.balloon;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class Balloon$autoDismissRunnable$2 extends Lambda implements Function0<a> {
    final /* synthetic */ Balloon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Balloon$autoDismissRunnable$2(Balloon balloon) {
        super(0);
        this.this$0 = balloon;
    }

    /* renamed from: a */
    public final a invoke() {
        return new a(this.this$0);
    }
}
