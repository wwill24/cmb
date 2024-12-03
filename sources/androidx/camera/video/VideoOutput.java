package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.h0;
import androidx.camera.core.impl.l1;

public interface VideoOutput {

    public enum SourceState {
        ACTIVE_STREAMING,
        ACTIVE_NON_STREAMING,
        INACTIVE
    }

    void a(@NonNull SurfaceRequest surfaceRequest);

    void b(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        a(surfaceRequest);
    }

    @NonNull
    l1<n> c() {
        return h0.g(null);
    }

    @NonNull
    l1<StreamInfo> d() {
        return StreamInfo.f3067c;
    }

    void e(@NonNull SourceState sourceState) {
    }
}
