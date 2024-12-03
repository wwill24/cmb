package n;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.core.e0;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.h1;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n1;
import s.j;

public final class a extends j {
    public static final Config.a<Integer> B = Config.a.a("camera2.captureRequest.templateType", Integer.TYPE);
    public static final Config.a<Long> C = Config.a.a("camera2.cameraCaptureSession.streamUseCase", Long.TYPE);
    public static final Config.a<CameraDevice.StateCallback> D = Config.a.a("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);
    public static final Config.a<CameraCaptureSession.StateCallback> E = Config.a.a("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);
    public static final Config.a<CameraCaptureSession.CaptureCallback> F = Config.a.a("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);
    public static final Config.a<c> G = Config.a.a("camera2.cameraEvent.callback", c.class);
    public static final Config.a<Object> H = Config.a.a("camera2.captureRequest.tag", Object.class);
    public static final Config.a<String> I = Config.a.a("camera2.cameraCaptureSession.physicalCameraId", String.class);

    /* renamed from: n.a$a  reason: collision with other inner class name */
    public static final class C0174a implements e0<a> {

        /* renamed from: a  reason: collision with root package name */
        private final i1 f16346a = i1.O();

        @NonNull
        public h1 a() {
            return this.f16346a;
        }

        @NonNull
        public a c() {
            return new a(n1.M(this.f16346a));
        }

        @NonNull
        public C0174a d(@NonNull Config config) {
            for (Config.a next : config.e()) {
                this.f16346a.p(next, config.a(next));
            }
            return this;
        }

        @NonNull
        public <ValueT> C0174a e(@NonNull CaptureRequest.Key<ValueT> key, @NonNull ValueT valuet) {
            this.f16346a.p(a.K(key), valuet);
            return this;
        }
    }

    public a(@NonNull Config config) {
        super(config);
    }

    @NonNull
    public static Config.a<Object> K(@NonNull CaptureRequest.Key<?> key) {
        return Config.a.b("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }

    public c L(c cVar) {
        return (c) getConfig().g(G, cVar);
    }

    @NonNull
    public j M() {
        return j.a.e(getConfig()).d();
    }

    public Object N(Object obj) {
        return getConfig().g(H, obj);
    }

    public int O(int i10) {
        return ((Integer) getConfig().g(B, Integer.valueOf(i10))).intValue();
    }

    public CameraDevice.StateCallback P(CameraDevice.StateCallback stateCallback) {
        return (CameraDevice.StateCallback) getConfig().g(D, stateCallback);
    }

    public String Q(String str) {
        return (String) getConfig().g(I, str);
    }

    public CameraCaptureSession.CaptureCallback R(CameraCaptureSession.CaptureCallback captureCallback) {
        return (CameraCaptureSession.CaptureCallback) getConfig().g(F, captureCallback);
    }

    public CameraCaptureSession.StateCallback S(CameraCaptureSession.StateCallback stateCallback) {
        return (CameraCaptureSession.StateCallback) getConfig().g(E, stateCallback);
    }

    public long T(long j10) {
        return ((Long) getConfig().g(C, Long.valueOf(j10))).longValue();
    }
}
