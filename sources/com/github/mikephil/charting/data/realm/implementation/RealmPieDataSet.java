package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.realm.base.RealmBaseDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import io.realm.DynamicRealmObject;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.Iterator;

public class RealmPieDataSet<T extends RealmObject> extends RealmBaseDataSet<T, Entry> implements IPieDataSet {
    private float mShift = 18.0f;
    private float mSliceSpace = 0.0f;

    public RealmPieDataSet(RealmResults<T> realmResults, String str) {
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

    public float getSelectionShift() {
        return this.mShift;
    }

    public float getSliceSpace() {
        return this.mSliceSpace;
    }

    public void setSelectionShift(float f10) {
        this.mShift = Utils.convertDpToPixel(f10);
    }

    public void setSliceSpace(float f10) {
        if (f10 > 20.0f) {
            f10 = 20.0f;
        }
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        this.mSliceSpace = Utils.convertDpToPixel(f10);
    }

    public RealmPieDataSet(RealmResults<T> realmResults, String str, String str2) {
        super(realmResults, str, str2);
        build(this.results);
        calcMinMax(0, this.results.size());
    }
}
