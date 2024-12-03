package com.withpersona.sdk2.inquiry.network;

import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class NetworkUtilsKt$enqueueRetriableRequestWithRetry$2 extends Lambda implements Function1<InternalErrorInfo.NetworkErrorInfo, Boolean> {
    public static final NetworkUtilsKt$enqueueRetriableRequestWithRetry$2 INSTANCE = new NetworkUtilsKt$enqueueRetriableRequestWithRetry$2();

    NetworkUtilsKt$enqueueRetriableRequestWithRetry$2() {
        super(1);
    }

    public final Boolean invoke(InternalErrorInfo.NetworkErrorInfo networkErrorInfo) {
        j.g(networkErrorInfo, "error");
        return Boolean.valueOf(networkErrorInfo.isRecoverable());
    }
}
