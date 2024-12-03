package com.github.mikephil.charting.data;

public class BubbleEntry extends Entry {
    private float mSize;

    public BubbleEntry(int i10, float f10, float f11) {
        super(f10, i10);
        this.mSize = f11;
    }

    public float getSize() {
        return this.mSize;
    }

    public void setSize(float f10) {
        this.mSize = f10;
    }

    public BubbleEntry copy() {
        return new BubbleEntry(getXIndex(), getVal(), this.mSize, getData());
    }

    public BubbleEntry(int i10, float f10, float f11, Object obj) {
        super(f10, i10, obj);
        this.mSize = f11;
    }
}
