package com.google.android.material.internal;

final class g {
    static void a(float f10, float[] fArr) {
        if (f10 <= 0.5f) {
            fArr[0] = 1.0f - (f10 * 2.0f);
            fArr[1] = 0.0f;
            return;
        }
        fArr[0] = 0.0f;
        fArr[1] = (f10 * 2.0f) - 1.0f;
    }
}
