package kf;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.NonNull;
import qf.b;

public class a {

    /* renamed from: f  reason: collision with root package name */
    private static final int f23600f = ((int) Math.round(5.1000000000000005d));

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23601a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23602b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23603c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23604d;

    /* renamed from: e  reason: collision with root package name */
    private final float f23605e;

    public a(@NonNull Context context) {
        this(b.b(context, bf.b.elevationOverlayEnabled, false), hf.a.b(context, bf.b.elevationOverlayColor, 0), hf.a.b(context, bf.b.elevationOverlayAccentColor, 0), hf.a.b(context, bf.b.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean f(int i10) {
        return androidx.core.graphics.a.l(i10, 255) == this.f23604d;
    }

    public float a(float f10) {
        float f11 = this.f23605e;
        if (f11 <= 0.0f || f10 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p((double) (f10 / f11))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i10, float f10) {
        int i11;
        float a10 = a(f10);
        int alpha = Color.alpha(i10);
        int i12 = hf.a.i(androidx.core.graphics.a.l(i10, 255), this.f23602b, a10);
        if (a10 > 0.0f && (i11 = this.f23603c) != 0) {
            i12 = hf.a.h(i12, androidx.core.graphics.a.l(i11, f23600f));
        }
        return androidx.core.graphics.a.l(i12, alpha);
    }

    public int c(int i10, float f10) {
        if (!this.f23601a || !f(i10)) {
            return i10;
        }
        return b(i10, f10);
    }

    public int d(float f10) {
        return c(this.f23604d, f10);
    }

    public boolean e() {
        return this.f23601a;
    }

    public a(boolean z10, int i10, int i11, int i12, float f10) {
        this.f23601a = z10;
        this.f23602b = i10;
        this.f23603c = i11;
        this.f23604d = i12;
        this.f23605e = f10;
    }
}
