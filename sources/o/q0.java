package o;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.impl.utils.n;
import java.util.Map;
import java.util.concurrent.Executor;

public final class q0 {

    /* renamed from: a  reason: collision with root package name */
    private final b f16738a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, c0> f16739b = new ArrayMap(4);

    static final class a extends CameraManager.AvailabilityCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f16740a;

        /* renamed from: b  reason: collision with root package name */
        final CameraManager.AvailabilityCallback f16741b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f16742c = new Object();

        /* renamed from: d  reason: collision with root package name */
        private boolean f16743d = false;

        a(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
            this.f16740a = executor;
            this.f16741b = availabilityCallback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d() {
            g.a(this.f16741b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(String str) {
            this.f16741b.onCameraAvailable(str);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(String str) {
            this.f16741b.onCameraUnavailable(str);
        }

        /* access modifiers changed from: package-private */
        public void g() {
            synchronized (this.f16742c) {
                this.f16743d = true;
            }
        }

        public void onCameraAccessPrioritiesChanged() {
            synchronized (this.f16742c) {
                if (!this.f16743d) {
                    this.f16740a.execute(new n0(this));
                }
            }
        }

        public void onCameraAvailable(@NonNull String str) {
            synchronized (this.f16742c) {
                if (!this.f16743d) {
                    this.f16740a.execute(new p0(this, str));
                }
            }
        }

        public void onCameraUnavailable(@NonNull String str) {
            synchronized (this.f16742c) {
                if (!this.f16743d) {
                    this.f16740a.execute(new o0(this, str));
                }
            }
        }
    }

    public interface b {
        @NonNull
        static b f(@NonNull Context context, @NonNull Handler handler) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                return new u0(context);
            }
            if (i10 >= 28) {
                return t0.h(context);
            }
            return v0.g(context, handler);
        }

        void a(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback);

        @NonNull
        CameraCharacteristics b(@NonNull String str) throws CameraAccessExceptionCompat;

        void c(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat;

        @NonNull
        String[] d() throws CameraAccessExceptionCompat;

        void e(@NonNull CameraManager.AvailabilityCallback availabilityCallback);
    }

    private q0(b bVar) {
        this.f16738a = bVar;
    }

    @NonNull
    public static q0 a(@NonNull Context context) {
        return b(context, n.a());
    }

    @NonNull
    public static q0 b(@NonNull Context context, @NonNull Handler handler) {
        return new q0(b.f(context, handler));
    }

    @NonNull
    public c0 c(@NonNull String str) throws CameraAccessExceptionCompat {
        c0 c0Var;
        synchronized (this.f16739b) {
            c0Var = this.f16739b.get(str);
            if (c0Var == null) {
                try {
                    c0Var = c0.c(this.f16738a.b(str));
                    this.f16739b.put(str, c0Var);
                } catch (AssertionError e10) {
                    throw new CameraAccessExceptionCompat(10002, e10.getMessage(), e10);
                }
            }
        }
        return c0Var;
    }

    @NonNull
    public String[] d() throws CameraAccessExceptionCompat {
        return this.f16738a.d();
    }

    public void e(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        this.f16738a.c(str, executor, stateCallback);
    }

    public void f(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.f16738a.a(executor, availabilityCallback);
    }

    public void g(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.f16738a.e(availabilityCallback);
    }
}
