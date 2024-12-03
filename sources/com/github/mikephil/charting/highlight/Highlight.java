package com.github.mikephil.charting.highlight;

public class Highlight {
    private int mDataSetIndex;
    private Range mRange;
    private int mStackIndex;
    private int mXIndex;

    public Highlight(int i10, int i11) {
        this.mStackIndex = -1;
        this.mXIndex = i10;
        this.mDataSetIndex = i11;
    }

    public boolean equalTo(Highlight highlight) {
        return highlight != null && this.mDataSetIndex == highlight.mDataSetIndex && this.mXIndex == highlight.mXIndex && this.mStackIndex == highlight.mStackIndex;
    }

    public int getDataSetIndex() {
        return this.mDataSetIndex;
    }

    public Range getRange() {
        return this.mRange;
    }

    public int getStackIndex() {
        return this.mStackIndex;
    }

    public int getXIndex() {
        return this.mXIndex;
    }

    public String toString() {
        return "Highlight, xIndex: " + this.mXIndex + ", dataSetIndex: " + this.mDataSetIndex + ", stackIndex (only stacked barentry): " + this.mStackIndex;
    }

    public Highlight(int i10, int i11, int i12) {
        this(i10, i11);
        this.mStackIndex = i12;
    }

    public Highlight(int i10, int i11, int i12, Range range) {
        this(i10, i11, i12);
        this.mRange = range;
    }
}
