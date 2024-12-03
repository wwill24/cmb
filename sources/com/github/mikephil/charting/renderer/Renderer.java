package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class Renderer {
    protected int mMaxX = 0;
    protected int mMinX = 0;
    protected ViewPortHandler mViewPortHandler;

    public Renderer(ViewPortHandler viewPortHandler) {
        this.mViewPortHandler = viewPortHandler;
    }

    public void calcXBounds(BarLineScatterCandleBubbleDataProvider barLineScatterCandleBubbleDataProvider, int i10) {
        int i11;
        int lowestVisibleXIndex = barLineScatterCandleBubbleDataProvider.getLowestVisibleXIndex();
        int highestVisibleXIndex = barLineScatterCandleBubbleDataProvider.getHighestVisibleXIndex();
        if (lowestVisibleXIndex % i10 == 0) {
            i11 = i10;
        } else {
            i11 = 0;
        }
        this.mMinX = Math.max(((lowestVisibleXIndex / i10) * i10) - i11, 0);
        this.mMaxX = Math.min(((highestVisibleXIndex / i10) * i10) + i10, (int) barLineScatterCandleBubbleDataProvider.getXChartMax());
    }

    /* access modifiers changed from: protected */
    public boolean fitsBounds(float f10, float f11, float f12) {
        return f10 >= f11 && f10 <= f12;
    }
}
