package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

public abstract class MarkerView extends RelativeLayout {
    public MarkerView(Context context, int i10) {
        super(context);
        setupLayoutResource(i10);
    }

    private void setupLayoutResource(int i10) {
        View inflate = LayoutInflater.from(getContext()).inflate(i10, this);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    public void draw(Canvas canvas, float f10, float f11) {
        float xOffset = f10 + ((float) getXOffset(f10));
        float yOffset = f11 + ((float) getYOffset(f11));
        canvas.translate(xOffset, yOffset);
        draw(canvas);
        canvas.translate(-xOffset, -yOffset);
    }

    public abstract int getXOffset(float f10);

    public abstract int getYOffset(float f10);

    public abstract void refreshContent(Entry entry, Highlight highlight);
}
