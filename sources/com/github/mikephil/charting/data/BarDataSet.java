package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.List;

public class BarDataSet extends BarLineScatterCandleBubbleDataSet<BarEntry> implements IBarDataSet {
    private int mBarShadowColor = Color.rgb(215, 215, 215);
    private float mBarSpace = 0.15f;
    private int mEntryCountStacks = 0;
    private int mHighLightAlpha = 120;
    private String[] mStackLabels = {"Stack"};
    private int mStackSize = 1;

    public BarDataSet(List<BarEntry> list, String str) {
        super(list, str);
        this.mHighLightColor = Color.rgb(0, 0, 0);
        calcStackSize(list);
        calcEntryCountIncludingStacks(list);
    }

    private void calcEntryCountIncludingStacks(List<BarEntry> list) {
        this.mEntryCountStacks = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            float[] vals = list.get(i10).getVals();
            if (vals == null) {
                this.mEntryCountStacks++;
            } else {
                this.mEntryCountStacks += vals.length;
            }
        }
    }

    private void calcStackSize(List<BarEntry> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            float[] vals = list.get(i10).getVals();
            if (vals != null && vals.length > this.mStackSize) {
                this.mStackSize = vals.length;
            }
        }
    }

    public void calcMinMax(int i10, int i11) {
        int size;
        List<T> list = this.mYVals;
        if (list != null && (size = list.size()) != 0) {
            if (i11 == 0 || i11 >= size) {
                i11 = size - 1;
            }
            this.mYMin = Float.MAX_VALUE;
            this.mYMax = -3.4028235E38f;
            while (i10 <= i11) {
                BarEntry barEntry = (BarEntry) this.mYVals.get(i10);
                if (barEntry != null && !Float.isNaN(barEntry.getVal())) {
                    if (barEntry.getVals() == null) {
                        if (barEntry.getVal() < this.mYMin) {
                            this.mYMin = barEntry.getVal();
                        }
                        if (barEntry.getVal() > this.mYMax) {
                            this.mYMax = barEntry.getVal();
                        }
                    } else {
                        if ((-barEntry.getNegativeSum()) < this.mYMin) {
                            this.mYMin = -barEntry.getNegativeSum();
                        }
                        if (barEntry.getPositiveSum() > this.mYMax) {
                            this.mYMax = barEntry.getPositiveSum();
                        }
                    }
                }
                i10++;
            }
            if (this.mYMin == Float.MAX_VALUE) {
                this.mYMin = 0.0f;
                this.mYMax = 0.0f;
            }
        }
    }

    public DataSet<BarEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.mYVals.size(); i10++) {
            arrayList.add(((BarEntry) this.mYVals.get(i10)).copy());
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, getLabel());
        barDataSet.mColors = this.mColors;
        barDataSet.mStackSize = this.mStackSize;
        barDataSet.mBarSpace = this.mBarSpace;
        barDataSet.mBarShadowColor = this.mBarShadowColor;
        barDataSet.mStackLabels = this.mStackLabels;
        barDataSet.mHighLightColor = this.mHighLightColor;
        barDataSet.mHighLightAlpha = this.mHighLightAlpha;
        return barDataSet;
    }

    public int getBarShadowColor() {
        return this.mBarShadowColor;
    }

    public float getBarSpace() {
        return this.mBarSpace;
    }

    public float getBarSpacePercent() {
        return this.mBarSpace * 100.0f;
    }

    public int getEntryCountStacks() {
        return this.mEntryCountStacks;
    }

    public int getHighLightAlpha() {
        return this.mHighLightAlpha;
    }

    public String[] getStackLabels() {
        return this.mStackLabels;
    }

    public int getStackSize() {
        return this.mStackSize;
    }

    public boolean isStacked() {
        return this.mStackSize > 1;
    }

    public void setBarShadowColor(int i10) {
        this.mBarShadowColor = i10;
    }

    public void setBarSpacePercent(float f10) {
        this.mBarSpace = f10 / 100.0f;
    }

    public void setHighLightAlpha(int i10) {
        this.mHighLightAlpha = i10;
    }

    public void setStackLabels(String[] strArr) {
        this.mStackLabels = strArr;
    }
}
