package a0;

import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.w2;
import androidx.core.util.h;
import java.util.concurrent.Executor;

public class g0 implements a0 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final w2 f46a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Executor f47b;

    public g0(@NonNull w2 w2Var, @NonNull Executor executor) {
        h.j(!(w2Var instanceof a0), "SurfaceProcessorInternal should always be thread safe. Do not wrap.");
        this.f46a = w2Var;
        this.f47b = executor;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(SurfaceRequest surfaceRequest) {
        this.f46a.a(surfaceRequest);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(SurfaceOutput surfaceOutput) {
        this.f46a.b(surfaceOutput);
    }

    public void a(@NonNull SurfaceRequest surfaceRequest) {
        this.f47b.execute(new e0(this, surfaceRequest));
    }

    public void b(@NonNull SurfaceOutput surfaceOutput) {
        this.f47b.execute(new f0(this, surfaceOutput));
    }

    public void release() {
    }
}
