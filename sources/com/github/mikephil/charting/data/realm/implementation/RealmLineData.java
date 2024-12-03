package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.realm.base.RealmUtils;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.List;

public class RealmLineData extends LineData {
    public RealmLineData(RealmResults<? extends RealmObject> realmResults, String str, List<ILineDataSet> list) {
        super(RealmUtils.toXVals(realmResults, str), list);
    }
}
