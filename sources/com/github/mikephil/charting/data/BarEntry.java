package com.github.mikephil.charting.data;

public class BarEntry extends Entry {
    private float mNegativeSum;
    private float mPositiveSum;
    private float[] mVals;

    public BarEntry(float[] fArr, int i10) {
        super(calcSum(fArr), i10);
        this.mVals = fArr;
        calcPosNegSum();
    }

    private void calcPosNegSum() {
        float[] fArr = this.mVals;
        if (fArr == null) {
            this.mNegativeSum = 0.0f;
            this.mPositiveSum = 0.0f;
            return;
        }
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (float f12 : fArr) {
            if (f12 <= 0.0f) {
                f10 += Math.abs(f12);
            } else {
                f11 += f12;
            }
        }
        this.mNegativeSum = f10;
        this.mPositiveSum = f11;
    }

    private static float calcSum(float[] fArr) {
        float f10 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (float f11 : fArr) {
            f10 += f11;
        }
        return f10;
    }

    public float getBelowSum(int i10) {
        float[] fArr = this.mVals;
        float f10 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        int length = fArr.length - 1;
        while (length > i10 && length >= 0) {
            f10 += this.mVals[length];
            length--;
        }
        return f10;
    }

    public float getNegativeSum() {
        return this.mNegativeSum;
    }

    public float getPositiveSum() {
        return this.mPositiveSum;
    }

    public float getVal() {
        return super.getVal();
    }

    public float[] getVals() {
        return this.mVals;
    }

    public boolean isStacked() {
        return this.mVals != null;
    }

    public void setVals(float[] fArr) {
        setVal(calcSum(fArr));
        this.mVals = fArr;
        calcPosNegSum();
    }

    public BarEntry copy() {
        BarEntry barEntry = new BarEntry(getVal(), getXIndex(), getData());
        barEntry.setVals(this.mVals);
        return barEntry;
    }

    public BarEntry(float f10, int i10) {
        super(f10, i10);
    }

    public BarEntry(float[] fArr, int i10, String str) {
        super(calcSum(fArr), i10, str);
        this.mVals = fArr;
        calcPosNegSum();
    }

    public BarEntry(float f10, int i10, Object obj) {
        super(f10, i10, obj);
    }
}
