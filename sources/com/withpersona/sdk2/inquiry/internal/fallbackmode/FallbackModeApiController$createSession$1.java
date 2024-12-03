package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.withpersona.sdk2.inquiry.internal.InquiryField;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController", f = "ApiController.kt", l = {75, 93}, m = "createSession-BWLJW6A")
final class FallbackModeApiController$createSession$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FallbackModeApiController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FallbackModeApiController$createSession$1(FallbackModeApiController fallbackModeApiController, c<? super FallbackModeApiController$createSession$1> cVar) {
        super(cVar);
        this.this$0 = fallbackModeApiController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object b10 = this.this$0.b((String) null, (String) null, (Map<String, ? extends InquiryField>) null, this);
        return b10 == b.d() ? b10 : Result.a(b10);
    }
}
