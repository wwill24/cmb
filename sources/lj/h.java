package lj;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.widget.TextView;
import androidx.annotation.NonNull;
import jj.a;
import pj.c;

public class h implements LeadingMarginSpan {

    /* renamed from: a  reason: collision with root package name */
    private final a f32773a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32774b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f32775c = g.a();

    /* renamed from: d  reason: collision with root package name */
    private int f32776d;

    public h(@NonNull a aVar, @NonNull String str) {
        this.f32773a = aVar;
        this.f32774b = str;
    }

    public static void a(@NonNull TextView textView, @NonNull CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            h[] hVarArr = (h[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), h.class);
            if (hVarArr != null) {
                TextPaint paint = textView.getPaint();
                for (h hVar : hVarArr) {
                    hVar.f32776d = (int) (paint.measureText(hVar.f32774b) + 0.5f);
                }
            }
        }
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int i17;
        if (z10 && c.b(i15, charSequence, this)) {
            this.f32775c.set(paint);
            this.f32773a.g(this.f32775c);
            int measureText = (int) (this.f32775c.measureText(this.f32774b) + 0.5f);
            int j10 = this.f32773a.j();
            if (measureText > j10) {
                this.f32776d = measureText;
                j10 = measureText;
            } else {
                this.f32776d = 0;
            }
            if (i11 > 0) {
                i17 = (i10 + (j10 * i11)) - measureText;
            } else {
                i17 = i10 + (i11 * j10) + (j10 - measureText);
            }
            canvas.drawText(this.f32774b, (float) i17, (float) i13, this.f32775c);
        }
    }

    public int getLeadingMargin(boolean z10) {
        return Math.max(this.f32776d, this.f32773a.j());
    }
}
