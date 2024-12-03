package com.withpersona.sdk2.inquiry.shared.device;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import td.c;

final class RealAppSetIDHelper$refreshAppSetId$1 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ RealAppSetIDHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealAppSetIDHelper$refreshAppSetId$1(RealAppSetIDHelper realAppSetIDHelper) {
        super(1);
        this.this$0 = realAppSetIDHelper;
    }

    public final void a(c cVar) {
        RealAppSetIDHelper realAppSetIDHelper = this.this$0;
        String a10 = cVar.a();
        j.f(a10, "it.id");
        realAppSetIDHelper.f27500a = a10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((c) obj);
        return Unit.f32013a;
    }
}
