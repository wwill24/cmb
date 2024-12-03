package com.withpersona.sdk2.inquiry.network;

import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;

@d(c = "com.withpersona.sdk2.inquiry.network.NetworkUtilsKt", f = "NetworkUtils.kt", l = {162}, m = "enqueueWithRetryWhen")
final class NetworkUtilsKt$enqueueWithRetryWhen$1<T> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    NetworkUtilsKt$enqueueWithRetryWhen$1(c<? super NetworkUtilsKt$enqueueWithRetryWhen$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return NetworkUtilsKt.enqueueWithRetryWhen((Function1) null, (Function1<? super InternalErrorInfo.NetworkErrorInfo, Boolean>) null, this);
    }
}
