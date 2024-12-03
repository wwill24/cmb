package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class BubbleDataSet extends BarLineScatterCandleBubbleDataSet<BubbleEntry> implements IBubbleDataSet {
    private float mHighlightCircleWidth = 2.5f;
    protected float mMaxSize;
    protected float mXMax;
    protected float mXMin;

    public BubbleDataSet(List<BubbleEntry> list, String str) {
        super(list, str);
    }

    private float largestSize(BubbleEntry bubbleEntry) {
        return bubbleEntry.getSize();
    }

    private float xMax(BubbleEntry bubbleEntry) {
        return (float) bubbleEntry.getXIndex();
    }

    private float xMin(BubbleEntry bubbleEntry) {
        return (float) bubbleEntry.getXIndex();
    }

    private float yMax(BubbleEntry bubbleEntry) {
        return bubbleEntry.getVal();
    }

    private float yMin(BubbleEntry bubbleEntry) {
        return bubbleEntry.getVal();
    }

    public void calcMinMax(int i10, int i11) {
        List<T> list = this.mYVals;
        if (list != null && list.size() != 0) {
            if (i11 == 0 || i11 >= this.mYVals.size()) {
                i11 = this.mYVals.size() - 1;
            }
            this.mYMin = yMin((BubbleEntry) this.mYVals.get(i10));
            this.mYMax = yMax((BubbleEntry) this.mYVals.get(i10));
            while (i10 <= i11) {
                BubbleEntry bubbleEntry = (BubbleEntry) this.mYVals.get(i10);
                float yMin = yMin(bubbleEntry);
                float yMax = yMax(bubbleEntry);
                if (yMin < this.mYMin) {
                    this.mYMin = yMin;
                }
                if (yMax > this.mYMax) {
                    this.mYMax = yMax;
                }
                float xMin = xMin(bubbleEntry);
                float xMax = xMax(bubbleEntry);
                if (xMin < this.mXMin) {
                    this.mXMin = xMin;
                }
                if (xMax > this.mXMax) {
                    this.mXMax = xMax;
                }
                float largestSize = largestSize(bubbleEntry);
                if (largestSize > this.mMaxSize) {
                    this.mMaxSize = largestSize;
                }
                i10++;
            }
        }
    }

    public DataSet<BubbleEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.mYVals.size(); i10++) {
            arrayList.add(((BubbleEntry) this.mYVals.get(i10)).copy());
        }
        BubbleDataSet bubbleDataSet = new BubbleDataSet(arrayList, getLabel());
        bubbleDataSet.mColors = this.mColors;
        bubbleDataSet.mHighLightColor = this.mHighLightColor;
        return bubbleDataSet;
    }

    public float getHighlightCircleWidth() {
        return this.mHighlightCircleWidth;
    }

    public float getMaxSize() {
        return this.mMaxSize;
    }

    public float getXMax() {
        return this.mXMax;
    }

    public float getXMin() {
        return this.mXMin;
    }

    public void setHighlightCircleWidth(float f10) {
        this.mHighlightCircleWidth = Utils.convertDpToPixel(f10);
    }
}
