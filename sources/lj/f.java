package lj;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;
import jj.a;
import pj.c;

public class f extends MetricAffectingSpan implements LeadingMarginSpan {

    /* renamed from: a  reason: collision with root package name */
    private final a f32766a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f32767b = g.b();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f32768c = g.a();

    /* renamed from: d  reason: collision with root package name */
    private final int f32769d;

    public f(@NonNull a aVar, int i10) {
        this.f32766a = aVar;
        this.f32769d = i10;
    }

    private void a(TextPaint textPaint) {
        this.f32766a.e(textPaint, this.f32769d);
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int i17;
        int i18 = this.f32769d;
        if ((i18 == 1 || i18 == 2) && c.a(i16, charSequence, this)) {
            this.f32768c.set(paint);
            this.f32766a.d(this.f32768c);
            float strokeWidth = this.f32768c.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i19 = (int) ((((float) i14) - strokeWidth) + 0.5f);
                if (i11 > 0) {
                    i17 = canvas.getWidth();
                } else {
                    i17 = i10;
                    i10 -= canvas.getWidth();
                }
                this.f32767b.set(i10, i19, i17, i14);
                canvas.drawRect(this.f32767b, this.f32768c);
            }
        }
    }

    public int getLeadingMargin(boolean z10) {
        return 0;
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
