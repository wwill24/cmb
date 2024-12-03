package com.github.mikephil.charting.components;

import android.graphics.Typeface;
import com.github.mikephil.charting.utils.Utils;

public abstract class ComponentBase {
    protected boolean mEnabled = true;
    protected int mTextColor = -16777216;
    protected float mTextSize = 10.0f;
    protected Typeface mTypeface = null;
    protected float mXOffset = 5.0f;
    protected float mYOffset = 5.0f;

    public int getTextColor() {
        return this.mTextColor;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public float getXOffset() {
        return this.mXOffset;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z10) {
        this.mEnabled = z10;
    }

    public void setTextColor(int i10) {
        this.mTextColor = i10;
    }

    public void setTextSize(float f10) {
        if (f10 > 24.0f) {
            f10 = 24.0f;
        }
        if (f10 < 6.0f) {
            f10 = 6.0f;
        }
        this.mTextSize = Utils.convertDpToPixel(f10);
    }

    public void setTypeface(Typeface typeface) {
        this.mTypeface = typeface;
    }

    public void setXOffset(float f10) {
        this.mXOffset = Utils.convertDpToPixel(f10);
    }

    public void setYOffset(float f10) {
        this.mYOffset = Utils.convertDpToPixel(f10);
    }
}
