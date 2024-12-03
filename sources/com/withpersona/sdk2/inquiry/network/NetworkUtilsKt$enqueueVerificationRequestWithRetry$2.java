package com.withpersona.sdk2.inquiry.network;

import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class NetworkUtilsKt$enqueueVerificationRequestWithRetry$2 extends Lambda implements Function1<InternalErrorInfo.NetworkErrorInfo, Boolean> {
    public static final NetworkUtilsKt$enqueueVerificationRequestWithRetry$2 INSTANCE = new NetworkUtilsKt$enqueueVerificationRequestWithRetry$2();

    NetworkUtilsKt$enqueueVerificationRequestWithRetry$2() {
        super(1);
    }

    public final Boolean invoke(InternalErrorInfo.NetworkErrorInfo networkErrorInfo) {
        j.g(networkErrorInfo, "error");
        int code = networkErrorInfo.getCode();
        return Boolean.valueOf((code == 0 || code == 409 || code == 413 || code == 422) ? false : true);
    }
}
