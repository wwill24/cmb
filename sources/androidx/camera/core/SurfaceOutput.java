package androidx.camera.core;

import android.view.Surface;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public interface SurfaceOutput {

    public enum GlTransformOptions {
        USE_SURFACE_TEXTURE_TRANSFORM,
        APPLY_CROP_ROTATE_AND_MIRRORING
    }

    public static abstract class a {
        @NonNull
        public static a c(int i10, @NonNull SurfaceOutput surfaceOutput) {
            return new i(i10, surfaceOutput);
        }

        public abstract int a();

        @NonNull
        public abstract SurfaceOutput b();
    }

    int a();

    void b(@NonNull float[] fArr, @NonNull float[] fArr2);

    @NonNull
    Surface c(@NonNull Executor executor, @NonNull androidx.core.util.a<a> aVar);

    void close();
}
