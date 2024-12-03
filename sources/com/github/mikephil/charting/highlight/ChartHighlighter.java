package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.SelectionDetail;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> {
    protected T mChart;

    public ChartHighlighter(T t10) {
        this.mChart = t10;
    }

    /* access modifiers changed from: protected */
    public int getDataSetIndex(int i10, float f10, float f11) {
        List<SelectionDetail> selectionDetailsAtIndex = getSelectionDetailsAtIndex(i10);
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        float minimumDistance = Utils.getMinimumDistance(selectionDetailsAtIndex, f11, axisDependency);
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        if (minimumDistance >= Utils.getMinimumDistance(selectionDetailsAtIndex, f11, axisDependency2)) {
            axisDependency = axisDependency2;
        }
        return Utils.getClosestDataSetIndex(selectionDetailsAtIndex, f11, axisDependency);
    }

    public Highlight getHighlight(float f10, float f11) {
        int dataSetIndex;
        int xIndex = getXIndex(f10);
        if (xIndex == -2147483647 || (dataSetIndex = getDataSetIndex(xIndex, f10, f11)) == -2147483647) {
            return null;
        }
        return new Highlight(xIndex, dataSetIndex);
    }

    /* access modifiers changed from: protected */
    public List<SelectionDetail> getSelectionDetailsAtIndex(int i10) {
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[2];
        for (int i11 = 0; i11 < this.mChart.getData().getDataSetCount(); i11++) {
            IDataSet dataSetByIndex = this.mChart.getData().getDataSetByIndex(i11);
            if (dataSetByIndex.isHighlightEnabled()) {
                float yValForXIndex = dataSetByIndex.getYValForXIndex(i10);
                if (yValForXIndex != Float.NaN) {
                    fArr[1] = yValForXIndex;
                    this.mChart.getTransformer(dataSetByIndex.getAxisDependency()).pointValuesToPixel(fArr);
                    if (!Float.isNaN(fArr[1])) {
                        arrayList.add(new SelectionDetail(fArr[1], i11, dataSetByIndex));
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int getXIndex(float f10) {
        float[] fArr = new float[2];
        fArr[0] = f10;
        this.mChart.getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        return Math.round(fArr[0]);
    }
}
