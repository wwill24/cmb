package com.withpersona.sdk2.inquiry.network;

import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public abstract class NetworkCallResult<T> {

    public static final class Failure<T> extends NetworkCallResult<T> {
        private final InternalErrorInfo.NetworkErrorInfo networkErrorInfo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(InternalErrorInfo.NetworkErrorInfo networkErrorInfo2) {
            super((DefaultConstructorMarker) null);
            j.g(networkErrorInfo2, "networkErrorInfo");
            this.networkErrorInfo = networkErrorInfo2;
        }

        public final InternalErrorInfo.NetworkErrorInfo getNetworkErrorInfo() {
            return this.networkErrorInfo;
        }
    }

    public static final class Success<T> extends NetworkCallResult<T> {
        private final T response;

        public Success(T t10) {
            super((DefaultConstructorMarker) null);
            this.response = t10;
        }

        public final T getResponse() {
            return this.response;
        }
    }

    private NetworkCallResult() {
    }

    public /* synthetic */ NetworkCallResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
