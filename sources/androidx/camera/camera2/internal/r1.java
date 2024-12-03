package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.d0;
import java.util.List;
import zf.a;

interface r1 {
    void a(@NonNull List<d0> list);

    void b();

    @NonNull
    a<Void> c(boolean z10);

    void close();

    @NonNull
    List<d0> d();

    SessionConfig e();

    void f(SessionConfig sessionConfig);

    @NonNull
    a<Void> g(@NonNull SessionConfig sessionConfig, @NonNull CameraDevice cameraDevice, @NonNull d3 d3Var);
}
