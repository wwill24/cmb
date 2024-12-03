package lj;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.annotation.NonNull;

public class a implements LeadingMarginSpan {

    /* renamed from: a  reason: collision with root package name */
    private final jj.a f32753a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f32754b = g.b();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f32755c = g.a();

    public a(@NonNull jj.a aVar) {
        this.f32753a = aVar;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int k10 = this.f32753a.k();
        this.f32755c.set(paint);
        this.f32753a.a(this.f32755c);
        int i17 = i11 * k10;
        int i18 = i10 + i17;
        int i19 = i17 + i18;
        this.f32754b.set(Math.min(i18, i19), i12, Math.max(i18, i19), i14);
        canvas.drawRect(this.f32754b, this.f32755c);
    }

    public int getLeadingMargin(boolean z10) {
        return this.f32753a.j();
    }
}
