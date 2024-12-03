package androidx.camera.core.impl;

import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

final class d extends b0 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f2483a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f2484b;

    d(Executor executor, Handler handler) {
        if (executor != null) {
            this.f2483a = executor;
            if (handler != null) {
                this.f2484b = handler;
                return;
            }
            throw new NullPointerException("Null schedulerHandler");
        }
        throw new NullPointerException("Null cameraExecutor");
    }

    @NonNull
    public Executor b() {
        return this.f2483a;
    }

    @NonNull
    public Handler c() {
        return this.f2484b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (!this.f2483a.equals(b0Var.b()) || !this.f2484b.equals(b0Var.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f2483a.hashCode() ^ 1000003) * 1000003) ^ this.f2484b.hashCode();
    }

    public String toString() {
        return "CameraThreadConfig{cameraExecutor=" + this.f2483a + ", schedulerHandler=" + this.f2484b + "}";
    }
}
