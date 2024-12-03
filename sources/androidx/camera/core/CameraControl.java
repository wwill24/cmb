package androidx.camera.core;

import androidx.annotation.NonNull;
import zf.a;

public interface CameraControl {

    public static final class OperationCanceledException extends Exception {
        public OperationCanceledException(@NonNull String str) {
            super(str);
        }
    }

    @NonNull
    a<Void> a(boolean z10);

    @NonNull
    a<g0> g(@NonNull f0 f0Var);
}
