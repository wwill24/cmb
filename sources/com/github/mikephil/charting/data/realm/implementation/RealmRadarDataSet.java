package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.realm.base.RealmLineRadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmRadarDataSet<T extends RealmObject> extends RealmLineRadarDataSet<T> implements IRadarDataSet {
    public RealmRadarDataSet(RealmResults<T> realmResults, String str) {
        super(realmResults, str);
        build(this.results);
        calcMinMax(0, this.results.size());
    }

    public void build(RealmResults<T> realmResults) {
        super.build(realmResults);
    }

    public RealmRadarDataSet(RealmResults<T> realmResults, String str, String str2) {
        super(realmResults, str, str2);
        build(this.results);
        calcMinMax(0, this.results.size());
    }
}
