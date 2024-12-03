package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class HorizontalBarHighlighter extends BarHighlighter {
    public HorizontalBarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    /* access modifiers changed from: protected */
    public float getBase(float f10) {
        float[] fArr = new float[2];
        fArr[1] = f10;
        ((BarDataProvider) this.mChart).getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        float f11 = fArr[1];
        return f11 - (((BarDataProvider) this.mChart).getBarData().getGroupSpace() * ((float) ((int) (f11 / (((float) ((BarDataProvider) this.mChart).getBarData().getDataSetCount()) + ((BarDataProvider) this.mChart).getBarData().getGroupSpace())))));
    }

    public Highlight getHighlight(float f10, float f11) {
        Highlight highlight = super.getHighlight(f10, f11);
        if (highlight == null) {
            return highlight;
        }
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarDataProvider) this.mChart).getBarData().getDataSetByIndex(highlight.getDataSetIndex());
        if (!iBarDataSet.isStacked()) {
            return highlight;
        }
        float[] fArr = new float[2];
        fArr[0] = f11;
        ((BarDataProvider) this.mChart).getTransformer(iBarDataSet.getAxisDependency()).pixelsToValue(fArr);
        return getStackedHighlight(highlight, iBarDataSet, highlight.getXIndex(), highlight.getDataSetIndex(), (double) fArr[0]);
    }

    /* access modifiers changed from: protected */
    public int getXIndex(float f10) {
        if (!((BarDataProvider) this.mChart).getBarData().isGrouped()) {
            float[] fArr = new float[2];
            fArr[1] = f10;
            ((BarDataProvider) this.mChart).getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
            return Math.round(fArr[1]);
        }
        int base = ((int) getBase(f10)) / ((BarDataProvider) this.mChart).getBarData().getDataSetCount();
        int xValCount = ((BarDataProvider) this.mChart).getData().getXValCount();
        if (base < 0) {
            return 0;
        }
        if (base >= xValCount) {
            return xValCount - 1;
        }
        return base;
    }
}
