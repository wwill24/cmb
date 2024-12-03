package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.core.util.h;

public abstract class i extends ReplacementSpan {

    /* renamed from: a  reason: collision with root package name */
    private final Paint.FontMetricsInt f5469a = new Paint.FontMetricsInt();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final g f5470b;

    /* renamed from: c  reason: collision with root package name */
    private short f5471c = -1;

    /* renamed from: d  reason: collision with root package name */
    private short f5472d = -1;

    /* renamed from: e  reason: collision with root package name */
    private float f5473e = 1.0f;

    i(@NonNull g gVar) {
        h.h(gVar, "metadata cannot be null");
        this.f5470b = gVar;
    }

    @NonNull
    public final g a() {
        return this.f5470b;
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        return this.f5471c;
    }

    public int getSize(@NonNull Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f5469a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f5469a;
        this.f5473e = (((float) Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent)) * 1.0f) / ((float) this.f5470b.e());
        this.f5472d = (short) ((int) (((float) this.f5470b.e()) * this.f5473e));
        short i12 = (short) ((int) (((float) this.f5470b.i()) * this.f5473e));
        this.f5471c = i12;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f5469a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i12;
    }
}
