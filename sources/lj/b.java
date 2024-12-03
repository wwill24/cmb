package lj;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.annotation.NonNull;
import jj.a;
import pj.c;

public class b implements LeadingMarginSpan {

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f32756f;

    /* renamed from: a  reason: collision with root package name */
    private a f32757a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f32758b = g.a();

    /* renamed from: c  reason: collision with root package name */
    private final RectF f32759c = g.c();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f32760d = g.b();

    /* renamed from: e  reason: collision with root package name */
    private final int f32761e;

    static {
        boolean z10;
        if (25 == Build.VERSION.SDK_INT) {
            z10 = true;
        } else {
            z10 = false;
        }
        f32756f = z10;
    }

    public b(@NonNull a aVar, int i10) {
        this.f32757a = aVar;
        this.f32761e = i10;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int i17;
        int i18;
        Paint.Style style;
        int i19;
        if (z10 && c.b(i15, charSequence, this)) {
            this.f32758b.set(paint);
            this.f32757a.g(this.f32758b);
            int save = canvas.save();
            try {
                int j10 = this.f32757a.j();
                int l10 = this.f32757a.l((int) ((this.f32758b.descent() - this.f32758b.ascent()) + 0.5f));
                int i20 = (j10 - l10) / 2;
                if (f32756f) {
                    if (i11 < 0) {
                        i19 = i10 - (layout.getWidth() - (j10 * this.f32761e));
                    } else {
                        i19 = (j10 * this.f32761e) - i10;
                    }
                    int i21 = i10 + (i20 * i11);
                    int i22 = (i11 * l10) + i21;
                    int i23 = i11 * i19;
                    i17 = Math.min(i21, i22) + i23;
                    i18 = Math.max(i21, i22) + i23;
                } else {
                    if (i11 <= 0) {
                        i10 -= j10;
                    }
                    i17 = i10 + i20;
                    i18 = i17 + l10;
                }
                int descent = (i13 + ((int) (((this.f32758b.descent() + this.f32758b.ascent()) / 2.0f) + 0.5f))) - (l10 / 2);
                int i24 = l10 + descent;
                int i25 = this.f32761e;
                if (i25 != 0) {
                    if (i25 != 1) {
                        this.f32760d.set(i17, descent, i18, i24);
                        this.f32758b.setStyle(Paint.Style.FILL);
                        canvas.drawRect(this.f32760d, this.f32758b);
                    }
                }
                this.f32759c.set((float) i17, (float) descent, (float) i18, (float) i24);
                if (this.f32761e == 0) {
                    style = Paint.Style.FILL;
                } else {
                    style = Paint.Style.STROKE;
                }
                this.f32758b.setStyle(style);
                canvas.drawOval(this.f32759c, this.f32758b);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }

    public int getLeadingMargin(boolean z10) {
        return this.f32757a.j();
    }
}
