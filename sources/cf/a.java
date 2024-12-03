package cf;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import j1.b;
import j1.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f18977a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f18978b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f18979c = new j1.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f18980d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f18981e = new DecelerateInterpolator();

    public static float a(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    public static float b(float f10, float f11, float f12, float f13, float f14) {
        return f14 <= f12 ? f10 : f14 >= f13 ? f11 : a(f10, f11, (f14 - f12) / (f13 - f12));
    }

    public static int c(int i10, int i11, float f10) {
        return i10 + Math.round(f10 * ((float) (i11 - i10)));
    }
}
