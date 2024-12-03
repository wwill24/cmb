package com.withpersona.sdk2.camera;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.GovernmentIdFeed", f = "GovernmentIdFeed.kt", l = {88, 94}, m = "analyze-gIAlu-s")
final class GovernmentIdFeed$analyze$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GovernmentIdFeed this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdFeed$analyze$1(GovernmentIdFeed governmentIdFeed, c<? super GovernmentIdFeed$analyze$1> cVar) {
        super(cVar);
        this.this$0 = governmentIdFeed;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object j10 = this.this$0.l((s) null, this);
        return j10 == b.d() ? j10 : Result.a(j10);
    }
}
