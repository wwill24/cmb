package com.github.mikephil.charting.data;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.ArrayList;
import java.util.List;

public class ScatterDataSet extends LineScatterCandleRadarDataSet<Entry> implements IScatterDataSet {
    private ScatterChart.ScatterShape mScatterShape = ScatterChart.ScatterShape.SQUARE;
    private int mScatterShapeHoleColor = -1;
    private float mScatterShapeHoleRadius = 0.0f;
    private float mShapeSize = 15.0f;

    public ScatterDataSet(List<Entry> list, String str) {
        super(list, str);
    }

    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.mYVals.size(); i10++) {
            arrayList.add(((Entry) this.mYVals.get(i10)).copy());
        }
        ScatterDataSet scatterDataSet = new ScatterDataSet(arrayList, getLabel());
        scatterDataSet.mColors = this.mColors;
        scatterDataSet.mShapeSize = this.mShapeSize;
        scatterDataSet.mScatterShape = this.mScatterShape;
        scatterDataSet.mScatterShapeHoleRadius = this.mScatterShapeHoleRadius;
        scatterDataSet.mScatterShapeHoleColor = this.mScatterShapeHoleColor;
        scatterDataSet.mHighLightColor = this.mHighLightColor;
        return scatterDataSet;
    }

    public ScatterChart.ScatterShape getScatterShape() {
        return this.mScatterShape;
    }

    public int getScatterShapeHoleColor() {
        return this.mScatterShapeHoleColor;
    }

    public float getScatterShapeHoleRadius() {
        return this.mScatterShapeHoleRadius;
    }

    public float getScatterShapeSize() {
        return this.mShapeSize;
    }

    public void setScatterShape(ScatterChart.ScatterShape scatterShape) {
        this.mScatterShape = scatterShape;
    }

    public void setScatterShapeHoleColor(int i10) {
        this.mScatterShapeHoleColor = i10;
    }

    public void setScatterShapeHoleRadius(float f10) {
        this.mScatterShapeHoleRadius = f10;
    }

    public void setScatterShapeSize(float f10) {
        this.mShapeSize = f10;
    }
}
