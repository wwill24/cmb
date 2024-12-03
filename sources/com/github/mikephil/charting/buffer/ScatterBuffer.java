package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;

public class ScatterBuffer extends AbstractBuffer<IScatterDataSet> {
    public ScatterBuffer(int i10) {
        super(i10);
    }

    /* access modifiers changed from: protected */
    public void addForm(float f10, float f11) {
        float[] fArr = this.buffer;
        int i10 = this.index;
        int i11 = i10 + 1;
        fArr[i10] = f10;
        this.index = i11 + 1;
        fArr[i11] = f11;
    }

    public void feed(IScatterDataSet iScatterDataSet) {
        float entryCount = ((float) iScatterDataSet.getEntryCount()) * this.phaseX;
        for (int i10 = 0; ((float) i10) < entryCount; i10++) {
            Entry entryForIndex = iScatterDataSet.getEntryForIndex(i10);
            addForm((float) entryForIndex.getXIndex(), entryForIndex.getVal() * this.phaseY);
        }
        reset();
    }
}
