package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.interfaces.datasets.IDataSet;

public class SelectionDetail {
    public IDataSet dataSet;
    public int dataSetIndex;
    public float val;

    public SelectionDetail(float f10, int i10, IDataSet iDataSet) {
        this.val = f10;
        this.dataSetIndex = i10;
        this.dataSet = iDataSet;
    }
}
