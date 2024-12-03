package lj;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class e extends MetricAffectingSpan {
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSkewX(-0.25f);
    }

    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSkewX(-0.25f);
    }
}
