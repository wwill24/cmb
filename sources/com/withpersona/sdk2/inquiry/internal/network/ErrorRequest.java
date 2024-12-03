package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class ErrorRequest {

    /* renamed from: a  reason: collision with root package name */
    private final ErrorType f26460a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f26461b;

    @i(generateAdapter = false)
    public enum ErrorType {
        Camera,
        Network,
        Permissions,
        Other
    }

    public ErrorRequest(ErrorType errorType, Object obj) {
        j.g(errorType, "errorType");
        this.f26460a = errorType;
        this.f26461b = obj;
    }

    public final Object a() {
        return this.f26461b;
    }

    public final ErrorType b() {
        return this.f26460a;
    }
}
