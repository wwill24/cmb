package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.withpersona.sdk2.inquiry.internal.InquiryField;
import java.util.Map;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager", f = "RealFallbackModeManager.kt", l = {45}, m = "createFallbackSession")
final class RealFallbackModeManager$createFallbackSession$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealFallbackModeManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealFallbackModeManager$createFallbackSession$1(RealFallbackModeManager realFallbackModeManager, c<? super RealFallbackModeManager$createFallbackSession$1> cVar) {
        super(cVar);
        this.this$0 = realFallbackModeManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d((String) null, (String) null, (Map<String, ? extends InquiryField>) null, this);
    }
}
