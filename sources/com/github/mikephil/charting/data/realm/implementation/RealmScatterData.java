package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.realm.base.RealmUtils;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.List;

public class RealmScatterData extends ScatterData {
    public RealmScatterData(RealmResults<? extends RealmObject> realmResults, String str, List<IScatterDataSet> list) {
        super(RealmUtils.toXVals(realmResults, str), list);
    }
}
