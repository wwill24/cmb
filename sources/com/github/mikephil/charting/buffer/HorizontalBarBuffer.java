package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class HorizontalBarBuffer extends BarBuffer {
    public HorizontalBarBuffer(int i10, float f10, int i11, boolean z10) {
        super(i10, f10, i11, z10);
    }

    public void feed(IBarDataSet iBarDataSet) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float entryCount = ((float) iBarDataSet.getEntryCount()) * this.phaseX;
        int i10 = this.mDataSetCount - 1;
        float f17 = this.mBarSpace / 2.0f;
        float f18 = this.mGroupSpace / 2.0f;
        int i11 = 0;
        while (((float) i11) < entryCount) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i11);
            float xIndex = ((float) (barEntry.getXIndex() + (barEntry.getXIndex() * i10) + this.mDataSetIndex)) + (this.mGroupSpace * ((float) barEntry.getXIndex())) + f18;
            float val = barEntry.getVal();
            float[] vals = barEntry.getVals();
            float f19 = 0.0f;
            float f20 = 0.5f;
            if (!this.mContainsStacks || vals == null) {
                f10 = entryCount;
                float f21 = (xIndex - 0.5f) + f17;
                float f22 = (xIndex + 0.5f) - f17;
                if (this.mInverted) {
                    f12 = 0.0f;
                    f11 = val >= 0.0f ? val : 0.0f;
                    if (val > 0.0f) {
                        val = 0.0f;
                    }
                } else {
                    f12 = 0.0f;
                    float f23 = val >= 0.0f ? val : 0.0f;
                    if (val > 0.0f) {
                        val = 0.0f;
                    }
                    float f24 = val;
                    val = f23;
                    f11 = f24;
                }
                if (val > f12) {
                    val *= this.phaseY;
                } else {
                    f11 *= this.phaseY;
                }
                addBar(f11, f22, val, f21);
            } else {
                float f25 = -barEntry.getNegativeSum();
                float f26 = 0.0f;
                int i12 = 0;
                while (i12 < vals.length) {
                    float f27 = vals[i12];
                    if (f27 >= f19) {
                        f13 = f27 + f26;
                        f14 = f25;
                        f25 = f26;
                        f26 = f13;
                    } else {
                        f13 = f25 + Math.abs(f27);
                        f14 = Math.abs(f27) + f25;
                    }
                    float f28 = (xIndex - f20) + f17;
                    float f29 = (xIndex + f20) - f17;
                    if (this.mInverted) {
                        f16 = f25 >= f13 ? f25 : f13;
                        if (f25 > f13) {
                            f25 = f13;
                        }
                        f15 = entryCount;
                    } else {
                        float f30 = f25 >= f13 ? f25 : f13;
                        if (f25 > f13) {
                            f25 = f13;
                        }
                        f15 = entryCount;
                        float f31 = f30;
                        f16 = f25;
                        f25 = f31;
                    }
                    float f32 = this.phaseY;
                    addBar(f16 * f32, f29, f25 * f32, f28);
                    i12++;
                    f25 = f14;
                    entryCount = f15;
                    f19 = 0.0f;
                    f20 = 0.5f;
                }
                f10 = entryCount;
            }
            i11++;
            entryCount = f10;
        }
        reset();
    }
}
