package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraControl;
import androidx.camera.core.f0;
import androidx.camera.core.g0;
import androidx.camera.core.impl.SessionConfig;
import java.util.Collections;
import java.util.List;
import u.f;

public interface CameraControlInternal extends CameraControl {

    /* renamed from: a  reason: collision with root package name */
    public static final CameraControlInternal f2386a = new a();

    public static final class CameraControlException extends Exception {
        @NonNull
        private CameraCaptureFailure mCameraCaptureFailure;

        public CameraControlException(@NonNull CameraCaptureFailure cameraCaptureFailure) {
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }
    }

    class a implements CameraControlInternal {
        a() {
        }

        @NonNull
        public zf.a<Void> a(boolean z10) {
            return f.h(null);
        }

        public void b(@NonNull SessionConfig.b bVar) {
        }

        @NonNull
        public zf.a<List<Void>> c(@NonNull List<d0> list, int i10, int i11) {
            return f.h(Collections.emptyList());
        }

        @NonNull
        public Rect d() {
            return new Rect();
        }

        public void e(int i10) {
        }

        @NonNull
        public Config f() {
            return null;
        }

        @NonNull
        public zf.a<g0> g(@NonNull f0 f0Var) {
            return f.h(g0.b());
        }

        public void h(@NonNull Config config) {
        }

        public void i() {
        }
    }

    public interface b {
        void a();

        void b(@NonNull List<d0> list);
    }

    void b(@NonNull SessionConfig.b bVar);

    @NonNull
    zf.a<List<Void>> c(@NonNull List<d0> list, int i10, int i11);

    @NonNull
    Rect d();

    void e(int i10);

    @NonNull
    Config f();

    void h(@NonNull Config config);

    void i();
}
