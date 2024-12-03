package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class BarHighlighter extends ChartHighlighter<BarDataProvider> {
    public BarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    /* access modifiers changed from: protected */
    public float getBase(float f10) {
        float[] fArr = new float[2];
        fArr[0] = f10;
        ((BarDataProvider) this.mChart).getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        float f11 = fArr[0];
        return f11 - (((BarDataProvider) this.mChart).getBarData().getGroupSpace() * ((float) ((int) (f11 / (((float) ((BarDataProvider) this.mChart).getBarData().getDataSetCount()) + ((BarDataProvider) this.mChart).getBarData().getGroupSpace())))));
    }

    /* access modifiers changed from: protected */
    public int getClosestStackIndex(Range[] rangeArr, float f10) {
        if (rangeArr == null || rangeArr.length == 0) {
            return 0;
        }
        int i10 = 0;
        for (Range contains : rangeArr) {
            if (contains.contains(f10)) {
                return i10;
            }
            i10++;
        }
        int max = Math.max(rangeArr.length - 1, 0);
        if (f10 > rangeArr[max].to) {
            return max;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getDataSetIndex(int i10, float f10, float f11) {
        if (!((BarDataProvider) this.mChart).getBarData().isGrouped()) {
            return 0;
        }
        float base = getBase(f10);
        int dataSetCount = ((BarDataProvider) this.mChart).getBarData().getDataSetCount();
        int i11 = ((int) base) % dataSetCount;
        if (i11 < 0) {
            return 0;
        }
        if (i11 >= dataSetCount) {
            return dataSetCount - 1;
        }
        return i11;
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
        fArr[1] = f11;
        ((BarDataProvider) this.mChart).getTransformer(iBarDataSet.getAxisDependency()).pixelsToValue(fArr);
        return getStackedHighlight(highlight, iBarDataSet, highlight.getXIndex(), highlight.getDataSetIndex(), (double) fArr[1]);
    }

    /* access modifiers changed from: protected */
    public Range[] getRanges(BarEntry barEntry) {
        float[] vals = barEntry.getVals();
        if (vals == null || vals.length == 0) {
            return null;
        }
        float f10 = -barEntry.getNegativeSum();
        int length = vals.length;
        Range[] rangeArr = new Range[length];
        float f11 = 0.0f;
        for (int i10 = 0; i10 < length; i10++) {
            float f12 = vals[i10];
            if (f12 < 0.0f) {
                rangeArr[i10] = new Range(f10, Math.abs(f12) + f10);
                f10 += Math.abs(f12);
            } else {
                float f13 = f12 + f11;
                rangeArr[i10] = new Range(f11, f13);
                f11 = f13;
            }
        }
        return rangeArr;
    }

    /* access modifiers changed from: protected */
    public Highlight getStackedHighlight(Highlight highlight, IBarDataSet iBarDataSet, int i10, int i11, double d10) {
        BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXIndex(i10);
        if (barEntry == null || barEntry.getVals() == null) {
            return highlight;
        }
        Range[] ranges = getRanges(barEntry);
        int closestStackIndex = getClosestStackIndex(ranges, (float) d10);
        return new Highlight(i10, i11, closestStackIndex, ranges[closestStackIndex]);
    }

    /* access modifiers changed from: protected */
    public int getXIndex(float f10) {
        if (!((BarDataProvider) this.mChart).getBarData().isGrouped()) {
            return super.getXIndex(f10);
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
