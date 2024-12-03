package androidx.camera.camera2.internal;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.g2;
import androidx.camera.core.impl.p1;
import androidx.camera.core.impl.r0;
import androidx.camera.core.impl.s0;
import java.util.Collection;

public final class p2 {
    public static long a(@NonNull Collection<f2<?>> collection, @NonNull Collection<SessionConfig> collection2) {
        if (Build.VERSION.SDK_INT < 33) {
            return -1;
        }
        if (collection.isEmpty()) {
            return 0;
        }
        for (SessionConfig l10 : collection2) {
            if (l10.l() == 5) {
                return 0;
            }
        }
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (f2 next : collection) {
            if (next instanceof r0) {
                return 0;
            }
            if (next instanceof p1) {
                z12 = true;
            } else if (next instanceof s0) {
                if (z11) {
                    return 4;
                }
                z10 = true;
            } else if (!(next instanceof g2)) {
                continue;
            } else if (z10) {
                return 4;
            } else {
                z11 = true;
            }
        }
        if (z10) {
            return 2;
        }
        if (z11) {
            return 3;
        }
        if (!z12) {
            return 0;
        }
        return 1;
    }
}
