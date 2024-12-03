package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.List;

public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<?>> {
    private BarData mBarData;
    private BubbleData mBubbleData;
    private CandleData mCandleData;
    private LineData mLineData;
    private ScatterData mScatterData;

    public CombinedData() {
    }

    public List<ChartData> getAllData() {
        ArrayList arrayList = new ArrayList();
        LineData lineData = this.mLineData;
        if (lineData != null) {
            arrayList.add(lineData);
        }
        BarData barData = this.mBarData;
        if (barData != null) {
            arrayList.add(barData);
        }
        ScatterData scatterData = this.mScatterData;
        if (scatterData != null) {
            arrayList.add(scatterData);
        }
        CandleData candleData = this.mCandleData;
        if (candleData != null) {
            arrayList.add(candleData);
        }
        BubbleData bubbleData = this.mBubbleData;
        if (bubbleData != null) {
            arrayList.add(bubbleData);
        }
        return arrayList;
    }

    public BarData getBarData() {
        return this.mBarData;
    }

    public BubbleData getBubbleData() {
        return this.mBubbleData;
    }

    public CandleData getCandleData() {
        return this.mCandleData;
    }

    public LineData getLineData() {
        return this.mLineData;
    }

    public ScatterData getScatterData() {
        return this.mScatterData;
    }

    public void notifyDataChanged() {
        LineData lineData = this.mLineData;
        if (lineData != null) {
            lineData.notifyDataChanged();
        }
        BarData barData = this.mBarData;
        if (barData != null) {
            barData.notifyDataChanged();
        }
        CandleData candleData = this.mCandleData;
        if (candleData != null) {
            candleData.notifyDataChanged();
        }
        ScatterData scatterData = this.mScatterData;
        if (scatterData != null) {
            scatterData.notifyDataChanged();
        }
        BubbleData bubbleData = this.mBubbleData;
        if (bubbleData != null) {
            bubbleData.notifyDataChanged();
        }
        init();
    }

    public void setData(LineData lineData) {
        this.mLineData = lineData;
        this.mDataSets.addAll(lineData.getDataSets());
        init();
    }

    public CombinedData(List<String> list) {
        super(list);
    }

    public CombinedData(String[] strArr) {
        super(strArr);
    }

    public void setData(BarData barData) {
        this.mBarData = barData;
        this.mDataSets.addAll(barData.getDataSets());
        init();
    }

    public void setData(ScatterData scatterData) {
        this.mScatterData = scatterData;
        this.mDataSets.addAll(scatterData.getDataSets());
        init();
    }

    public void setData(CandleData candleData) {
        this.mCandleData = candleData;
        this.mDataSets.addAll(candleData.getDataSets());
        init();
    }

    public void setData(BubbleData bubbleData) {
        this.mBubbleData = bubbleData;
        this.mDataSets.addAll(bubbleData.getDataSets());
        init();
    }
}
