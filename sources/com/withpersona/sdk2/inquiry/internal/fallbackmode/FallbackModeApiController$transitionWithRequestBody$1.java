package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import okhttp3.z;

@d(c = "com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController", f = "ApiController.kt", l = {121, 156}, m = "transitionWithRequestBody")
final class FallbackModeApiController$transitionWithRequestBody$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FallbackModeApiController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FallbackModeApiController$transitionWithRequestBody$1(FallbackModeApiController fallbackModeApiController, c<? super FallbackModeApiController$transitionWithRequestBody$1> cVar) {
        super(cVar);
        this.this$0 = fallbackModeApiController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((String) null, (z) null, this);
    }
}
