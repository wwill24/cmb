package androidx.camera.core.impl.utils;

import android.opengl.Matrix;
import androidx.annotation.NonNull;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f2687a = new float[16];

    private static void a(float[] fArr, float f10, float f11) {
        Matrix.translateM(fArr, 0, -f10, -f11, 0.0f);
    }

    private static void b(float[] fArr, float f10, float f11) {
        Matrix.translateM(fArr, 0, f10, f11, 0.0f);
    }

    public static void c(@NonNull float[] fArr, float f10, float f11, float f12) {
        b(fArr, f11, f12);
        Matrix.rotateM(fArr, 0, f10, 0.0f, 0.0f, 1.0f);
        a(fArr, f11, f12);
    }
}
