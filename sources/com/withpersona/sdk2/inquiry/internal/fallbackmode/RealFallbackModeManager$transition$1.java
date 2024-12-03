package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager", f = "RealFallbackModeManager.kt", l = {78, 90}, m = "transition")
final class RealFallbackModeManager$transition$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealFallbackModeManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealFallbackModeManager$transition$1(RealFallbackModeManager realFallbackModeManager, c<? super RealFallbackModeManager$transition$1> cVar) {
        super(cVar);
        this.this$0 = realFallbackModeManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((String) null, (String) null, (Object) null, this);
    }
}
