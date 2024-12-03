package o;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class c0 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Map<CameraCharacteristics.Key<?>, Object> f16678a = new HashMap();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final a f16679b;

    public interface a {
        <T> T a(@NonNull CameraCharacteristics.Key<T> key);
    }

    private c0(@NonNull CameraCharacteristics cameraCharacteristics) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f16679b = new a0(cameraCharacteristics);
        } else {
            this.f16679b = new b0(cameraCharacteristics);
        }
    }

    private boolean b(@NonNull CameraCharacteristics.Key<?> key) {
        return key.equals(CameraCharacteristics.SENSOR_ORIENTATION);
    }

    @NonNull
    public static c0 c(@NonNull CameraCharacteristics cameraCharacteristics) {
        return new c0(cameraCharacteristics);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T a(@androidx.annotation.NonNull android.hardware.camera2.CameraCharacteristics.Key<T> r3) {
        /*
            r2 = this;
            boolean r0 = r2.b(r3)
            if (r0 == 0) goto L_0x000d
            o.c0$a r0 = r2.f16679b
            java.lang.Object r3 = r0.a(r3)
            return r3
        L_0x000d:
            monitor-enter(r2)
            java.util.Map<android.hardware.camera2.CameraCharacteristics$Key<?>, java.lang.Object> r0 = r2.f16678a     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0018
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            return r0
        L_0x0018:
            o.c0$a r0 = r2.f16679b     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r0.a(r3)     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0025
            java.util.Map<android.hardware.camera2.CameraCharacteristics$Key<?>, java.lang.Object> r1 = r2.f16678a     // Catch:{ all -> 0x0027 }
            r1.put(r3, r0)     // Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            return r0
        L_0x0027:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o.c0.a(android.hardware.camera2.CameraCharacteristics$Key):java.lang.Object");
    }
}
