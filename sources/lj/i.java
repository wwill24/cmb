package lj;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class i extends MetricAffectingSpan {
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setFakeBoldText(true);
    }

    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setFakeBoldText(true);
    }
}
