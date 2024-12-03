package com.github.mikephil.charting.buffer;

public abstract class AbstractBuffer<T> {
    public final float[] buffer;
    protected int index = 0;
    protected int mFrom = 0;
    protected int mTo = 0;
    protected float phaseX = 1.0f;
    protected float phaseY = 1.0f;

    public AbstractBuffer(int i10) {
        this.buffer = new float[i10];
    }

    public abstract void feed(T t10);

    public void limitFrom(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.mFrom = i10;
    }

    public void limitTo(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.mTo = i10;
    }

    public void reset() {
        this.index = 0;
    }

    public void setPhases(float f10, float f11) {
        this.phaseX = f10;
        this.phaseY = f11;
    }

    public int size() {
        return this.buffer.length;
    }
}
