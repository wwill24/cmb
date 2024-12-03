package com.withpersona.sdk2.camera;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class FinalizeRecordingError extends CameraError {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinalizeRecordingError(String str, Throwable th2) {
        super(str, th2, (DefaultConstructorMarker) null);
        j.g(str, "message");
    }
}
