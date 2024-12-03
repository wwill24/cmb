package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import java.util.ArrayList;
import java.util.List;

public class RadarDataSet extends LineRadarDataSet<Entry> implements IRadarDataSet {
    public RadarDataSet(List<Entry> list, String str) {
        super(list, str);
    }

    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.mYVals.size(); i10++) {
            arrayList.add(((Entry) this.mYVals.get(i10)).copy());
        }
        RadarDataSet radarDataSet = new RadarDataSet(arrayList, getLabel());
        radarDataSet.mColors = this.mColors;
        radarDataSet.mHighLightColor = this.mHighLightColor;
        return radarDataSet;
    }
}
