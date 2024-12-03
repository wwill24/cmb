package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class LineRadarDataSet<T extends Entry> extends LineScatterCandleRadarDataSet<T> implements ILineRadarDataSet<T> {
    private boolean mDrawFilled = false;
    private int mFillAlpha = 85;
    private int mFillColor = Color.rgb(Opcodes.F2L, 234, 255);
    protected Drawable mFillDrawable;
    private float mLineWidth = 2.5f;

    public LineRadarDataSet(List<T> list, String str) {
        super(list, str);
    }

    public int getFillAlpha() {
        return this.mFillAlpha;
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public Drawable getFillDrawable() {
        return this.mFillDrawable;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public boolean isDrawFilledEnabled() {
        return this.mDrawFilled;
    }

    public void setDrawFilled(boolean z10) {
        this.mDrawFilled = z10;
    }

    public void setFillAlpha(int i10) {
        this.mFillAlpha = i10;
    }

    public void setFillColor(int i10) {
        this.mFillColor = i10;
        this.mFillDrawable = null;
    }

    public void setFillDrawable(Drawable drawable) {
        this.mFillDrawable = drawable;
    }

    public void setLineWidth(float f10) {
        if (f10 < 0.2f) {
            f10 = 0.2f;
        }
        if (f10 > 10.0f) {
            f10 = 10.0f;
        }
        this.mLineWidth = Utils.convertDpToPixel(f10);
    }
}
