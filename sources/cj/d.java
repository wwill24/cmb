package cj;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.j;

final class d extends MetricAffectingSpan {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f24942a;

    public d(Typeface typeface) {
        j.g(typeface, "typeface");
        this.f24942a = typeface;
    }

    public void updateDrawState(TextPaint textPaint) {
        j.g(textPaint, "textPaint");
        textPaint.setTypeface(this.f24942a);
        textPaint.setFlags(textPaint.getFlags() | 128);
    }

    public void updateMeasureState(TextPaint textPaint) {
        j.g(textPaint, "paint");
        textPaint.setTypeface(this.f24942a);
        textPaint.setFlags(textPaint.getFlags() | 128);
    }
}
