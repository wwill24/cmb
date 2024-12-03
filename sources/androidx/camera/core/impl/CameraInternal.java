package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraControl;
import androidx.camera.core.UseCase;
import androidx.camera.core.l;
import androidx.camera.core.q;
import java.util.Collection;

public interface CameraInternal extends l, UseCase.c {

    public enum State {
        PENDING_OPEN(false),
        OPENING(true),
        OPEN(true),
        CLOSING(true),
        CLOSED(false),
        RELEASING(true),
        RELEASED(false);
        
        private final boolean mHoldsCameraSlot;

        private State(boolean z10) {
            this.mHoldsCameraSlot = z10;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.mHoldsCameraSlot;
        }
    }

    @NonNull
    CameraControl a() {
        return f();
    }

    @NonNull
    q b() {
        return l();
    }

    @NonNull
    l1<State> c();

    @NonNull
    CameraControlInternal f();

    @NonNull
    r g() {
        return u.a();
    }

    void h(boolean z10) {
    }

    void j(@NonNull Collection<UseCase> collection);

    void k(@NonNull Collection<UseCase> collection);

    @NonNull
    x l();

    void m(r rVar) {
    }
}
