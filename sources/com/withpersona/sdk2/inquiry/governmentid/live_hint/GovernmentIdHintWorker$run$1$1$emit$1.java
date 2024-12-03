package com.withpersona.sdk2.inquiry.governmentid.live_hint;

import com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$run$1;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$run$1$1", f = "GovernmentIdHintWorker.kt", l = {92, 93}, m = "emit")
final class GovernmentIdHintWorker$run$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GovernmentIdHintWorker$run$1.AnonymousClass1<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdHintWorker$run$1$1$emit$1(GovernmentIdHintWorker$run$1.AnonymousClass1<? super T> r12, c<? super GovernmentIdHintWorker$run$1$1$emit$1> cVar) {
        super(cVar);
        this.this$0 = r12;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c((GovernmentIdHintWorker.c) null, this);
    }
}
