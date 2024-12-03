package androidx.camera.core.impl;

import androidx.annotation.NonNull;

public class CameraCaptureFailure {

    /* renamed from: a  reason: collision with root package name */
    private final Reason f2352a;

    public enum Reason {
        ERROR
    }

    public CameraCaptureFailure(@NonNull Reason reason) {
        this.f2352a = reason;
    }

    @NonNull
    public Reason a() {
        return this.f2352a;
    }
}
