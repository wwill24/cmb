package r;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.camera.core.v1;
import java.nio.BufferUnderflowException;
import o.c0;
import q.l;
import q.q;

public final class f {
    private static boolean a(@NonNull c0 c0Var) {
        Boolean bool = (Boolean) c0Var.a(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool == null) {
            v1.l("FlashAvailability", "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static boolean b(@NonNull c0 c0Var) {
        try {
            return a(c0Var);
        } catch (BufferUnderflowException unused) {
            return false;
        }
    }

    public static boolean c(@NonNull c0 c0Var) {
        Class cls = q.class;
        if (l.a(cls) == null) {
            return a(c0Var);
        }
        v1.a("FlashAvailability", "Device has quirk " + cls.getSimpleName() + ". Checking for flash availability safely...");
        return b(c0Var);
    }
}
