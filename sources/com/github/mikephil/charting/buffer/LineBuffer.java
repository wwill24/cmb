package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

public class LineBuffer extends AbstractBuffer<ILineDataSet> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LineBuffer(int i10) {
        super(i10 < 4 ? 4 : i10);
    }

    public void lineTo(float f10, float f11) {
        int i10 = this.index;
        if (i10 == 2) {
            float[] fArr = this.buffer;
            int i11 = i10 + 1;
            fArr[i10] = f10;
            this.index = i11 + 1;
            fArr[i11] = f11;
            return;
        }
        float[] fArr2 = this.buffer;
        float f12 = fArr2[i10 - 2];
        float f13 = fArr2[i10 - 1];
        int i12 = i10 + 1;
        fArr2[i10] = f12;
        int i13 = i12 + 1;
        fArr2[i12] = f13;
        int i14 = i13 + 1;
        fArr2[i13] = f10;
        this.index = i14 + 1;
        fArr2[i14] = f11;
    }

    public void moveTo(float f10, float f11) {
        int i10 = this.index;
        if (i10 == 0) {
            float[] fArr = this.buffer;
            int i11 = i10 + 1;
            fArr[i10] = f10;
            int i12 = i11 + 1;
            this.index = i12;
            fArr[i11] = f11;
            fArr[i12] = f10;
            fArr[i12 + 1] = f11;
        }
    }

    public void feed(ILineDataSet iLineDataSet) {
        moveTo((float) iLineDataSet.getEntryForIndex(this.mFrom).getXIndex(), iLineDataSet.getEntryForIndex(this.mFrom).getVal() * this.phaseY);
        int i10 = this.mTo;
        int i11 = this.mFrom;
        int ceil = (int) Math.ceil((double) ((((float) (i10 - i11)) * this.phaseX) + ((float) i11)));
        int i12 = this.mFrom;
        while (true) {
            i12++;
            if (i12 < ceil) {
                Entry entryForIndex = iLineDataSet.getEntryForIndex(i12);
                lineTo((float) entryForIndex.getXIndex(), entryForIndex.getVal() * this.phaseY);
            } else {
                reset();
                return;
            }
        }
    }
}
