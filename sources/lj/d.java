package lj;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;
import jj.a;

public class d extends MetricAffectingSpan {

    /* renamed from: a  reason: collision with root package name */
    private final a f32765a;

    public d(@NonNull a aVar) {
        this.f32765a = aVar;
    }

    private void a(TextPaint textPaint) {
        this.f32765a.c(textPaint);
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
        textPaint.bgColor = this.f32765a.m(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
