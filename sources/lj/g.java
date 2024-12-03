package lj;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

abstract class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Rect f32770a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private static final RectF f32771b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f32772c = new Paint(1);

    static Paint a() {
        return f32772c;
    }

    static Rect b() {
        return f32770a;
    }

    static RectF c() {
        return f32771b;
    }
}
