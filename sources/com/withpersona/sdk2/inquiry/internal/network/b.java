package com.withpersona.sdk2.inquiry.internal.network;

import com.withpersona.sdk2.inquiry.internal.network.ErrorRequest;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class b {
    public static final ErrorRequest.ErrorType a(InternalErrorInfo internalErrorInfo) {
        j.g(internalErrorInfo, "<this>");
        if (internalErrorInfo instanceof InternalErrorInfo.NetworkErrorInfo) {
            return ErrorRequest.ErrorType.Network;
        }
        if (internalErrorInfo instanceof InternalErrorInfo.IntegrationErrorInfo) {
            return ErrorRequest.ErrorType.Other;
        }
        if (internalErrorInfo instanceof InternalErrorInfo.PermissionErrorInfo) {
            return ErrorRequest.ErrorType.Permissions;
        }
        if (internalErrorInfo instanceof InternalErrorInfo.CameraErrorInfo) {
            return ErrorRequest.ErrorType.Camera;
        }
        if (internalErrorInfo instanceof InternalErrorInfo.ConfigurationErrorInfo) {
            return ErrorRequest.ErrorType.Other;
        }
        throw new NoWhenBranchMatchedException();
    }
}
