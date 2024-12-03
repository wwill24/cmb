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

public class c extends MetricAffectingSpan implements LeadingMarginSpan {

    /* renamed from: a  reason: collision with root package name */
    private final a f32762a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f32763b = g.b();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f32764c = g.a();

    public c(@NonNull a aVar) {
        this.f32762a = aVar;
    }

    private void a(TextPaint textPaint) {
        this.f32762a.b(textPaint);
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int i17;
        this.f32764c.setStyle(Paint.Style.FILL);
        this.f32764c.setColor(this.f32762a.n(paint));
        if (i11 > 0) {
            i17 = canvas.getWidth();
        } else {
            int i18 = i10;
            i10 -= canvas.getWidth();
            i17 = i18;
        }
        this.f32763b.set(i10, i12, i17, i14);
        canvas.drawRect(this.f32763b, this.f32764c);
    }

    public int getLeadingMargin(boolean z10) {
        return this.f32762a.o();
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
