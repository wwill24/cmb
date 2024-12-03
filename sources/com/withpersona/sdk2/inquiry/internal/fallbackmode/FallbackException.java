package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import kotlin.jvm.internal.j;

public final class FallbackException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FallbackException(String str) {
        super(str);
        j.g(str, "message");
    }
}
