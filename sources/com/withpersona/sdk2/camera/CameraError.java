package com.withpersona.sdk2.camera;

import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class CameraError extends Exception {
    private CameraError() {
    }

    public /* synthetic */ CameraError(String str, Throwable th2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th2);
    }

    public /* synthetic */ CameraError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CameraError(String str, Throwable th2) {
        super(str, th2);
    }
}
