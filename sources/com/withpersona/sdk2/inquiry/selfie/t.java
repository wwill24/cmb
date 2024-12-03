package com.withpersona.sdk2.inquiry.selfie;

import java.io.File;
import kotlin.jvm.internal.j;

public final class t {
    public static final void a(SelfieState selfieState) {
        j.g(selfieState, "<this>");
        for (Selfie a10 : selfieState.g()) {
            new File(a10.a()).delete();
        }
    }
}
