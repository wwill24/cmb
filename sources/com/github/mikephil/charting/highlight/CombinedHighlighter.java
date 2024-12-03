package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.SelectionDetail;
import java.util.ArrayList;
import java.util.List;

public class CombinedHighlighter extends ChartHighlighter<BarLineScatterCandleBubbleDataProvider> {
    public CombinedHighlighter(BarLineScatterCandleBubbleDataProvider barLineScatterCandleBubbleDataProvider) {
        super(barLineScatterCandleBubbleDataProvider);
    }

    /* access modifiers changed from: protected */
    public List<SelectionDetail> getSelectionDetailsAtIndex(int i10) {
        List<ChartData> allData = ((CombinedData) this.mChart.getData()).getAllData();
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[2];
        for (int i11 = 0; i11 < allData.size(); i11++) {
            for (int i12 = 0; i12 < allData.get(i11).getDataSetCount(); i12++) {
                IDataSet dataSetByIndex = allData.get(i11).getDataSetByIndex(i12);
                if (dataSetByIndex.isHighlightEnabled()) {
                    float yValForXIndex = dataSetByIndex.getYValForXIndex(i10);
                    if (yValForXIndex != Float.NaN) {
                        fArr[1] = yValForXIndex;
                        this.mChart.getTransformer(dataSetByIndex.getAxisDependency()).pointValuesToPixel(fArr);
                        if (!Float.isNaN(fArr[1])) {
                            arrayList.add(new SelectionDetail(fArr[1], i12, dataSetByIndex));
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
