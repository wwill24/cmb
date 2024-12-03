package com.withpersona.sdk2.inquiry.internal.network;

import com.withpersona.sdk2.camera.analyzers.d;
import kotlin.jvm.internal.j;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f26918a = new q();

    private q() {
    }

    public final void a() {
        try {
            Object newInstance = Class.forName("com.withpersona.sdk2.inquiry.extraction.impl.TextEntityExtractorImpl").newInstance();
            j.e(newInstance, "null cannot be cast to non-null type com.withpersona.sdk2.camera.analyzers.TextEntityExtractor");
            ((d) newInstance).a();
        } catch (ClassNotFoundException unused) {
        }
    }
}
