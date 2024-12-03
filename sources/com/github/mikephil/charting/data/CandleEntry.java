package com.github.mikephil.charting.data;

public class CandleEntry extends Entry {
    private float mClose;
    private float mOpen;
    private float mShadowHigh;
    private float mShadowLow;

    public CandleEntry(int i10, float f10, float f11, float f12, float f13) {
        super((f10 + f11) / 2.0f, i10);
        this.mShadowHigh = f10;
        this.mShadowLow = f11;
        this.mOpen = f12;
        this.mClose = f13;
    }

    public float getBodyRange() {
        return Math.abs(this.mOpen - this.mClose);
    }

    public float getClose() {
        return this.mClose;
    }

    public float getHigh() {
        return this.mShadowHigh;
    }

    public float getLow() {
        return this.mShadowLow;
    }

    public float getOpen() {
        return this.mOpen;
    }

    public float getShadowRange() {
        return Math.abs(this.mShadowHigh - this.mShadowLow);
    }

    public float getVal() {
        return super.getVal();
    }

    public void setClose(float f10) {
        this.mClose = f10;
    }

    public void setHigh(float f10) {
        this.mShadowHigh = f10;
    }

    public void setLow(float f10) {
        this.mShadowLow = f10;
    }

    public void setOpen(float f10) {
        this.mOpen = f10;
    }

    public CandleEntry copy() {
        return new CandleEntry(getXIndex(), this.mShadowHigh, this.mShadowLow, this.mOpen, this.mClose, getData());
    }

    public CandleEntry(int i10, float f10, float f11, float f12, float f13, Object obj) {
        super((f10 + f11) / 2.0f, i10, obj);
        this.mShadowHigh = f10;
        this.mShadowLow = f11;
        this.mOpen = f12;
        this.mClose = f13;
    }
}
