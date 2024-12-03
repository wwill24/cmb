package tf;

import androidx.annotation.NonNull;

public class j extends d {

    /* renamed from: a  reason: collision with root package name */
    float f24545a = -1.0f;

    public void a(@NonNull m mVar, float f10, float f11, float f12) {
        mVar.o(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        float f13 = f12 * 2.0f * f11;
        mVar.a(0.0f, 0.0f, f13, f13, 180.0f, f10);
    }
}
