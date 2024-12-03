package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.List;

public final class o extends n {

    /* renamed from: a  reason: collision with root package name */
    private final List<n> f2571a;

    public void a() {
        for (n a10 : this.f2571a) {
            a10.a();
        }
    }

    public void b(@NonNull p pVar) {
        for (n b10 : this.f2571a) {
            b10.b(pVar);
        }
    }

    public void c(@NonNull CameraCaptureFailure cameraCaptureFailure) {
        for (n c10 : this.f2571a) {
            c10.c(cameraCaptureFailure);
        }
    }

    @NonNull
    public List<n> d() {
        return this.f2571a;
    }
}
