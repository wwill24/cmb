package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.realm.base.RealmLineScatterCandleRadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import io.realm.DynamicRealmObject;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.Iterator;

public class RealmScatterDataSet<T extends RealmObject> extends RealmLineScatterCandleRadarDataSet<T, Entry> implements IScatterDataSet {
    private ScatterChart.ScatterShape mScatterShape = ScatterChart.ScatterShape.SQUARE;
    private int mScatterShapeHoleColor = -1;
    private float mScatterShapeHoleRadius = 0.0f;
    private float mShapeSize = 10.0f;

    public RealmScatterDataSet(RealmResults<T> realmResults, String str) {
        super(realmResults, str);
        build(this.results);
        calcMinMax(0, this.results.size());
    }

    public void build(RealmResults<T> realmResults) {
        if (this.mIndexField == null) {
            int i10 = 0;
            Iterator it = realmResults.iterator();
            while (it.hasNext()) {
                this.mValues.add(new Entry(new DynamicRealmObject((RealmObject) it.next()).getFloat(this.mValuesField), i10));
                i10++;
            }
            return;
        }
        Iterator it2 = realmResults.iterator();
        while (it2.hasNext()) {
            DynamicRealmObject dynamicRealmObject = new DynamicRealmObject((RealmObject) it2.next());
            this.mValues.add(new Entry(dynamicRealmObject.getFloat(this.mValuesField), dynamicRealmObject.getInt(this.mIndexField)));
        }
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

    public RealmScatterDataSet(RealmResults<T> realmResults, String str, String str2) {
        super(realmResults, str, str2);
        build(this.results);
        calcMinMax(0, this.results.size());
    }
}
