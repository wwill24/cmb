package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import z.c;

public abstract class SurfaceConfig {

    public enum ConfigSize {
        VGA(0),
        PREVIEW(1),
        RECORD(2),
        MAXIMUM(3),
        NOT_SUPPORT(4);
        
        final int mId;

        private ConfigSize(int i10) {
            this.mId = i10;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.mId;
        }
    }

    public enum ConfigType {
        PRIV,
        YUV,
        JPEG,
        RAW
    }

    SurfaceConfig() {
    }

    @NonNull
    public static SurfaceConfig a(@NonNull ConfigType configType, @NonNull ConfigSize configSize) {
        return new j(configType, configSize);
    }

    @NonNull
    public static ConfigType d(int i10) {
        if (i10 == 35) {
            return ConfigType.YUV;
        }
        if (i10 == 256) {
            return ConfigType.JPEG;
        }
        if (i10 == 32) {
            return ConfigType.RAW;
        }
        return ConfigType.PRIV;
    }

    @NonNull
    public static SurfaceConfig f(int i10, @NonNull Size size, @NonNull z1 z1Var) {
        ConfigSize configSize;
        ConfigType d10 = d(i10);
        ConfigSize configSize2 = ConfigSize.VGA;
        int a10 = c.a(size);
        if (a10 <= c.a(z1Var.b())) {
            configSize = ConfigSize.VGA;
        } else if (a10 <= c.a(z1Var.c())) {
            configSize = ConfigSize.PREVIEW;
        } else if (a10 <= c.a(z1Var.d())) {
            configSize = ConfigSize.RECORD;
        } else {
            configSize = ConfigSize.MAXIMUM;
        }
        return a(d10, configSize);
    }

    @NonNull
    public abstract ConfigSize b();

    @NonNull
    public abstract ConfigType c();

    public final boolean e(@NonNull SurfaceConfig surfaceConfig) {
        ConfigType c10 = surfaceConfig.c();
        if (surfaceConfig.b().a() > b().a() || c10 != c()) {
            return false;
        }
        return true;
    }
}
