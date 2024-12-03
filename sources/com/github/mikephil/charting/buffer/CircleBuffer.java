package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

public class CircleBuffer extends AbstractBuffer<ILineDataSet> {
    public CircleBuffer(int i10) {
        super(i10);
    }

    /* access modifiers changed from: protected */
    public void addCircle(float f10, float f11) {
        float[] fArr = this.buffer;
        int i10 = this.index;
        int i11 = i10 + 1;
        fArr[i10] = f10;
        this.index = i11 + 1;
        fArr[i11] = f11;
    }

    public void feed(ILineDataSet iLineDataSet) {
        int i10 = this.mTo;
        int i11 = this.mFrom;
        int ceil = (int) Math.ceil((double) ((((float) (i10 - i11)) * this.phaseX) + ((float) i11)));
        for (int i12 = this.mFrom; i12 < ceil; i12++) {
            Entry entryForIndex = iLineDataSet.getEntryForIndex(i12);
            addCircle((float) entryForIndex.getXIndex(), entryForIndex.getVal() * this.phaseY);
        }
        reset();
    }
}
