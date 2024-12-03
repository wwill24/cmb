package com.github.mikephil.charting.data;

import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CandleDataSet extends LineScatterCandleRadarDataSet<CandleEntry> implements ICandleDataSet {
    private float mBarSpace = 0.1f;
    protected int mDecreasingColor = -1;
    protected Paint.Style mDecreasingPaintStyle = Paint.Style.FILL;
    protected int mIncreasingColor = -1;
    protected Paint.Style mIncreasingPaintStyle = Paint.Style.STROKE;
    protected int mNeutralColor = -1;
    protected int mShadowColor = -1;
    private boolean mShadowColorSameAsCandle = false;
    private float mShadowWidth = 3.0f;
    private boolean mShowCandleBar = true;

    public CandleDataSet(List<CandleEntry> list, String str) {
        super(list, str);
    }

    public void calcMinMax(int i10, int i11) {
        List<T> list = this.mYVals;
        if (list != null && list.size() != 0) {
            if (i11 == 0 || i11 >= this.mYVals.size()) {
                i11 = this.mYVals.size() - 1;
            }
            this.mYMin = Float.MAX_VALUE;
            this.mYMax = -3.4028235E38f;
            while (i10 <= i11) {
                CandleEntry candleEntry = (CandleEntry) this.mYVals.get(i10);
                if (candleEntry.getLow() < this.mYMin) {
                    this.mYMin = candleEntry.getLow();
                }
                if (candleEntry.getHigh() > this.mYMax) {
                    this.mYMax = candleEntry.getHigh();
                }
                i10++;
            }
        }
    }

    public DataSet<CandleEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.mYVals.size(); i10++) {
            arrayList.add(((CandleEntry) this.mYVals.get(i10)).copy());
        }
        CandleDataSet candleDataSet = new CandleDataSet(arrayList, getLabel());
        candleDataSet.mColors = this.mColors;
        candleDataSet.mShadowWidth = this.mShadowWidth;
        candleDataSet.mShowCandleBar = this.mShowCandleBar;
        candleDataSet.mBarSpace = this.mBarSpace;
        candleDataSet.mHighLightColor = this.mHighLightColor;
        candleDataSet.mIncreasingPaintStyle = this.mIncreasingPaintStyle;
        candleDataSet.mDecreasingPaintStyle = this.mDecreasingPaintStyle;
        candleDataSet.mShadowColor = this.mShadowColor;
        return candleDataSet;
    }

    public float getBarSpace() {
        return this.mBarSpace;
    }

    public int getDecreasingColor() {
        return this.mDecreasingColor;
    }

    public Paint.Style getDecreasingPaintStyle() {
        return this.mDecreasingPaintStyle;
    }

    public int getIncreasingColor() {
        return this.mIncreasingColor;
    }

    public Paint.Style getIncreasingPaintStyle() {
        return this.mIncreasingPaintStyle;
    }

    public int getNeutralColor() {
        return this.mNeutralColor;
    }

    public int getShadowColor() {
        return this.mShadowColor;
    }

    public boolean getShadowColorSameAsCandle() {
        return this.mShadowColorSameAsCandle;
    }

    public float getShadowWidth() {
        return this.mShadowWidth;
    }

    public boolean getShowCandleBar() {
        return this.mShowCandleBar;
    }

    public void setBarSpace(float f10) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 > 0.45f) {
            f10 = 0.45f;
        }
        this.mBarSpace = f10;
    }

    public void setDecreasingColor(int i10) {
        this.mDecreasingColor = i10;
    }

    public void setDecreasingPaintStyle(Paint.Style style) {
        this.mDecreasingPaintStyle = style;
    }

    public void setIncreasingColor(int i10) {
        this.mIncreasingColor = i10;
    }

    public void setIncreasingPaintStyle(Paint.Style style) {
        this.mIncreasingPaintStyle = style;
    }

    public void setNeutralColor(int i10) {
        this.mNeutralColor = i10;
    }

    public void setShadowColor(int i10) {
        this.mShadowColor = i10;
    }

    public void setShadowColorSameAsCandle(boolean z10) {
        this.mShadowColorSameAsCandle = z10;
    }

    public void setShadowWidth(float f10) {
        this.mShadowWidth = Utils.convertDpToPixel(f10);
    }

    public void setShadowWidth(boolean z10) {
        this.mShowCandleBar = z10;
    }
}
