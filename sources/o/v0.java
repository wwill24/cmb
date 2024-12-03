package o;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.core.util.h;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import o.d0;
import o.q0;

class v0 implements q0.b {

    /* renamed from: a  reason: collision with root package name */
    final CameraManager f16755a;

    /* renamed from: b  reason: collision with root package name */
    final Object f16756b;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<CameraManager.AvailabilityCallback, q0.a> f16757a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Handler f16758b;

        a(@NonNull Handler handler) {
            this.f16758b = handler;
        }
    }

    v0(@NonNull Context context, Object obj) {
        this.f16755a = (CameraManager) context.getSystemService("camera");
        this.f16756b = obj;
    }

    static v0 g(@NonNull Context context, @NonNull Handler handler) {
        return new v0(context, new a(handler));
    }

    public void a(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        if (executor != null) {
            q0.a aVar = null;
            a aVar2 = (a) this.f16756b;
            if (availabilityCallback != null) {
                synchronized (aVar2.f16757a) {
                    aVar = aVar2.f16757a.get(availabilityCallback);
                    if (aVar == null) {
                        aVar = new q0.a(executor, availabilityCallback);
                        aVar2.f16757a.put(availabilityCallback, aVar);
                    }
                }
            }
            this.f16755a.registerAvailabilityCallback(aVar, aVar2.f16758b);
            return;
        }
        throw new IllegalArgumentException("executor was null");
    }

    @NonNull
    public CameraCharacteristics b(@NonNull String str) throws CameraAccessExceptionCompat {
        try {
            return this.f16755a.getCameraCharacteristics(str);
        } catch (CameraAccessException e10) {
            throw CameraAccessExceptionCompat.e(e10);
        }
    }

    public void c(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        h.g(executor);
        h.g(stateCallback);
        try {
            this.f16755a.openCamera(str, new d0.b(executor, stateCallback), ((a) this.f16756b).f16758b);
        } catch (CameraAccessException e10) {
            throw CameraAccessExceptionCompat.e(e10);
        }
    }

    @NonNull
    public String[] d() throws CameraAccessExceptionCompat {
        try {
            return this.f16755a.getCameraIdList();
        } catch (CameraAccessException e10) {
            throw CameraAccessExceptionCompat.e(e10);
        }
    }

    public void e(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        q0.a aVar;
        if (availabilityCallback != null) {
            a aVar2 = (a) this.f16756b;
            synchronized (aVar2.f16757a) {
                aVar = aVar2.f16757a.remove(availabilityCallback);
            }
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.g();
        }
        this.f16755a.unregisterAvailabilityCallback(aVar);
    }
}
