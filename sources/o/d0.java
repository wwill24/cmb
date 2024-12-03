package o;

import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.concurrent.Executor;
import p.k;

public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    private final a f16680a;

    interface a {
        void a(@NonNull k kVar) throws CameraAccessExceptionCompat;
    }

    static final class b extends CameraDevice.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        final CameraDevice.StateCallback f16681a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f16682b;

        b(@NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) {
            this.f16682b = executor;
            this.f16681a = stateCallback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(CameraDevice cameraDevice) {
            this.f16681a.onClosed(cameraDevice);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(CameraDevice cameraDevice) {
            this.f16681a.onDisconnected(cameraDevice);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(CameraDevice cameraDevice, int i10) {
            this.f16681a.onError(cameraDevice, i10);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(CameraDevice cameraDevice) {
            this.f16681a.onOpened(cameraDevice);
        }

        public void onClosed(@NonNull CameraDevice cameraDevice) {
            this.f16682b.execute(new e0(this, cameraDevice));
        }

        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            this.f16682b.execute(new f0(this, cameraDevice));
        }

        public void onError(@NonNull CameraDevice cameraDevice, int i10) {
            this.f16682b.execute(new h0(this, cameraDevice, i10));
        }

        public void onOpened(@NonNull CameraDevice cameraDevice) {
            this.f16682b.execute(new g0(this, cameraDevice));
        }
    }

    private d0(@NonNull CameraDevice cameraDevice, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f16680a = new l0(cameraDevice);
        } else {
            this.f16680a = j0.e(cameraDevice, handler);
        }
    }

    @NonNull
    public static d0 b(@NonNull CameraDevice cameraDevice, @NonNull Handler handler) {
        return new d0(cameraDevice, handler);
    }

    public void a(@NonNull k kVar) throws CameraAccessExceptionCompat {
        this.f16680a.a(kVar);
    }
}
