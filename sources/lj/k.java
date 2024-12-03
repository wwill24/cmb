package lj;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.annotation.NonNull;
import jj.a;

public class k implements LeadingMarginSpan {

    /* renamed from: a  reason: collision with root package name */
    private final a f32778a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f32779b = g.b();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f32780c = g.a();

    public k(@NonNull a aVar) {
        this.f32778a = aVar;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int i17;
        int i18 = i12 + ((i14 - i12) / 2);
        this.f32780c.set(paint);
        this.f32778a.h(this.f32780c);
        int strokeWidth = (int) ((((float) ((int) (this.f32780c.getStrokeWidth() + 0.5f))) / 2.0f) + 0.5f);
        if (i11 > 0) {
            i17 = canvas.getWidth();
        } else {
            i17 = i10;
            i10 -= canvas.getWidth();
        }
        this.f32779b.set(i10, i18 - strokeWidth, i17, i18 + strokeWidth);
        canvas.drawRect(this.f32779b, this.f32780c);
    }

    public int getLeadingMargin(boolean z10) {
        return 0;
    }
}
