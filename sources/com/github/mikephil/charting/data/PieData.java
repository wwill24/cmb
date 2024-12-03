package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import java.util.ArrayList;
import java.util.List;

public class PieData extends ChartData<IPieDataSet> {
    public PieData() {
    }

    private static List<IPieDataSet> toList(IPieDataSet iPieDataSet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(iPieDataSet);
        return arrayList;
    }

    public IPieDataSet getDataSet() {
        return (IPieDataSet) this.mDataSets.get(0);
    }

    public float getYValueSum() {
        float f10 = 0.0f;
        for (int i10 = 0; i10 < getDataSet().getEntryCount(); i10++) {
            f10 += getDataSet().getEntryForIndex(i10).getVal();
        }
        return f10;
    }

    public void setDataSet(IPieDataSet iPieDataSet) {
        this.mDataSets.clear();
        this.mDataSets.add(iPieDataSet);
        init();
    }

    public PieData(List<String> list) {
        super(list);
    }

    public IPieDataSet getDataSetByIndex(int i10) {
        if (i10 == 0) {
            return getDataSet();
        }
        return null;
    }

    public IPieDataSet getDataSetByLabel(String str, boolean z10) {
        if (z10) {
            if (str.equalsIgnoreCase(((IPieDataSet) this.mDataSets.get(0)).getLabel())) {
                return (IPieDataSet) this.mDataSets.get(0);
            }
            return null;
        } else if (str.equals(((IPieDataSet) this.mDataSets.get(0)).getLabel())) {
            return (IPieDataSet) this.mDataSets.get(0);
        } else {
            return null;
        }
    }

    public PieData(String[] strArr) {
        super(strArr);
    }

    public PieData(List<String> list, IPieDataSet iPieDataSet) {
        super(list, toList(iPieDataSet));
    }

    public PieData(String[] strArr, IPieDataSet iPieDataSet) {
        super(strArr, toList(iPieDataSet));
    }
}
