package f;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

public class b extends Drawable {

    /* renamed from: m  reason: collision with root package name */
    private static final float f14617m = ((float) Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    private final Paint f14618a;

    /* renamed from: b  reason: collision with root package name */
    private float f14619b;

    /* renamed from: c  reason: collision with root package name */
    private float f14620c;

    /* renamed from: d  reason: collision with root package name */
    private float f14621d;

    /* renamed from: e  reason: collision with root package name */
    private float f14622e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14623f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f14624g;

    /* renamed from: h  reason: collision with root package name */
    private final int f14625h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14626i;

    /* renamed from: j  reason: collision with root package name */
    private float f14627j;

    /* renamed from: k  reason: collision with root package name */
    private float f14628k;

    /* renamed from: l  reason: collision with root package name */
    private int f14629l;

    private static float a(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public void b(float f10) {
        if (this.f14627j != f10) {
            this.f14627j = f10;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        float f10;
        float f11;
        int i10;
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i11 = this.f14629l;
        boolean z10 = false;
        if (i11 != 0 && (i11 == 1 || (i11 == 3 ? a.f(this) == 0 : a.f(this) == 1))) {
            z10 = true;
        }
        float f12 = this.f14619b;
        float a10 = a(this.f14620c, (float) Math.sqrt((double) (f12 * f12 * 2.0f)), this.f14627j);
        float a11 = a(this.f14620c, this.f14621d, this.f14627j);
        float round = (float) Math.round(a(0.0f, this.f14628k, this.f14627j));
        float a12 = a(0.0f, f14617m, this.f14627j);
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = -180.0f;
        }
        if (z10) {
            f11 = 180.0f;
        } else {
            f11 = 0.0f;
        }
        float a13 = a(f10, f11, this.f14627j);
        double d10 = (double) a10;
        float f13 = a13;
        double d11 = (double) a12;
        boolean z11 = z10;
        float round2 = (float) Math.round(Math.cos(d11) * d10);
        float round3 = (float) Math.round(d10 * Math.sin(d11));
        this.f14624g.rewind();
        float a14 = a(this.f14622e + this.f14618a.getStrokeWidth(), -this.f14628k, this.f14627j);
        float f14 = (-a11) / 2.0f;
        this.f14624g.moveTo(f14 + round, 0.0f);
        this.f14624g.rLineTo(a11 - (round * 2.0f), 0.0f);
        this.f14624g.moveTo(f14, a14);
        this.f14624g.rLineTo(round2, round3);
        this.f14624g.moveTo(f14, -a14);
        this.f14624g.rLineTo(round2, -round3);
        this.f14624g.close();
        canvas.save();
        float strokeWidth = this.f14618a.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f15 = this.f14622e;
        canvas2.translate((float) bounds.centerX(), ((float) ((((int) (height - (2.0f * f15))) / 4) * 2)) + (strokeWidth * 1.5f) + f15);
        if (this.f14623f) {
            if (this.f14626i ^ z11) {
                i10 = -1;
            } else {
                i10 = 1;
            }
            canvas2.rotate(f13 * ((float) i10));
        } else if (z11) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.f14624g, this.f14618a);
        canvas.restore();
    }

    public int getIntrinsicHeight() {
        return this.f14625h;
    }

    public int getIntrinsicWidth() {
        return this.f14625h;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i10) {
        if (i10 != this.f14618a.getAlpha()) {
            this.f14618a.setAlpha(i10);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f14618a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
