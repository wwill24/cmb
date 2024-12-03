package com.github.mikephil.charting.data;

import android.graphics.Typeface;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ChartData<T extends IDataSet<? extends Entry>> {
    protected List<T> mDataSets;
    protected float mLeftAxisMax;
    protected float mLeftAxisMin;
    protected float mRightAxisMax;
    protected float mRightAxisMin;
    private float mXValMaximumLength;
    protected List<String> mXVals;
    protected float mYMax;
    protected float mYMin;
    private int mYValCount;

    public ChartData() {
        this.mYMax = 0.0f;
        this.mYMin = 0.0f;
        this.mLeftAxisMax = 0.0f;
        this.mLeftAxisMin = 0.0f;
        this.mRightAxisMax = 0.0f;
        this.mRightAxisMin = 0.0f;
        this.mYValCount = 0;
        this.mXValMaximumLength = 0.0f;
        this.mXVals = new ArrayList();
        this.mDataSets = new ArrayList();
    }

    private List<String> arrayToList(String[] strArr) {
        return Arrays.asList(strArr);
    }

    private void calcXValMaximumLength() {
        if (this.mXVals.size() <= 0) {
            this.mXValMaximumLength = 1.0f;
            return;
        }
        int i10 = 1;
        for (int i11 = 0; i11 < this.mXVals.size(); i11++) {
            int length = this.mXVals.get(i11).length();
            if (length > i10) {
                i10 = length;
            }
        }
        this.mXValMaximumLength = (float) i10;
    }

    private void checkLegal() {
        if (this.mDataSets != null && !(this instanceof ScatterData)) {
            int i10 = 0;
            while (i10 < this.mDataSets.size()) {
                if (((IDataSet) this.mDataSets.get(i10)).getEntryCount() <= this.mXVals.size()) {
                    i10++;
                } else {
                    throw new IllegalArgumentException("One or more of the DataSet Entry arrays are longer than the x-values array of this ChartData object.");
                }
            }
        }
    }

    public static List<String> generateXVals(int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        while (i10 < i11) {
            arrayList.add("" + i10);
            i10++;
        }
        return arrayList;
    }

    private void handleEmptyAxis(T t10, T t11) {
        if (t10 == null) {
            this.mLeftAxisMax = this.mRightAxisMax;
            this.mLeftAxisMin = this.mRightAxisMin;
        } else if (t11 == null) {
            this.mRightAxisMax = this.mLeftAxisMax;
            this.mRightAxisMin = this.mLeftAxisMin;
        }
    }

    public void addDataSet(T t10) {
        if (t10 != null) {
            this.mYValCount += t10.getEntryCount();
            if (this.mDataSets.size() <= 0) {
                this.mYMax = t10.getYMax();
                this.mYMin = t10.getYMin();
                if (t10.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                    this.mLeftAxisMax = t10.getYMax();
                    this.mLeftAxisMin = t10.getYMin();
                } else {
                    this.mRightAxisMax = t10.getYMax();
                    this.mRightAxisMin = t10.getYMin();
                }
            } else {
                if (this.mYMax < t10.getYMax()) {
                    this.mYMax = t10.getYMax();
                }
                if (this.mYMin > t10.getYMin()) {
                    this.mYMin = t10.getYMin();
                }
                if (t10.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                    if (this.mLeftAxisMax < t10.getYMax()) {
                        this.mLeftAxisMax = t10.getYMax();
                    }
                    if (this.mLeftAxisMin > t10.getYMin()) {
                        this.mLeftAxisMin = t10.getYMin();
                    }
                } else {
                    if (this.mRightAxisMax < t10.getYMax()) {
                        this.mRightAxisMax = t10.getYMax();
                    }
                    if (this.mRightAxisMin > t10.getYMin()) {
                        this.mRightAxisMin = t10.getYMin();
                    }
                }
            }
            this.mDataSets.add(t10);
            handleEmptyAxis(getFirstLeft(), getFirstRight());
        }
    }

    public void addEntry(Entry entry, int i10) {
        if (this.mDataSets.size() > i10 && i10 >= 0) {
            IDataSet iDataSet = (IDataSet) this.mDataSets.get(i10);
            if (iDataSet.addEntry(entry)) {
                float val = entry.getVal();
                if (this.mYValCount == 0) {
                    this.mYMin = val;
                    this.mYMax = val;
                    if (iDataSet.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                        this.mLeftAxisMax = entry.getVal();
                        this.mLeftAxisMin = entry.getVal();
                    } else {
                        this.mRightAxisMax = entry.getVal();
                        this.mRightAxisMin = entry.getVal();
                    }
                } else {
                    if (this.mYMax < val) {
                        this.mYMax = val;
                    }
                    if (this.mYMin > val) {
                        this.mYMin = val;
                    }
                    if (iDataSet.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                        if (this.mLeftAxisMax < entry.getVal()) {
                            this.mLeftAxisMax = entry.getVal();
                        }
                        if (this.mLeftAxisMin > entry.getVal()) {
                            this.mLeftAxisMin = entry.getVal();
                        }
                    } else {
                        if (this.mRightAxisMax < entry.getVal()) {
                            this.mRightAxisMax = entry.getVal();
                        }
                        if (this.mRightAxisMin > entry.getVal()) {
                            this.mRightAxisMin = entry.getVal();
                        }
                    }
                }
                this.mYValCount++;
                handleEmptyAxis(getFirstLeft(), getFirstRight());
            }
        }
    }

    public void addXValue(String str) {
        if (str != null && ((float) str.length()) > this.mXValMaximumLength) {
            this.mXValMaximumLength = (float) str.length();
        }
        this.mXVals.add(str);
    }

    public void calcMinMax(int i10, int i11) {
        List<T> list = this.mDataSets;
        if (list == null || list.size() < 1) {
            this.mYMax = 0.0f;
            this.mYMin = 0.0f;
            return;
        }
        this.mYMin = Float.MAX_VALUE;
        this.mYMax = -3.4028235E38f;
        for (int i12 = 0; i12 < this.mDataSets.size(); i12++) {
            IDataSet iDataSet = (IDataSet) this.mDataSets.get(i12);
            iDataSet.calcMinMax(i10, i11);
            if (iDataSet.getYMin() < this.mYMin) {
                this.mYMin = iDataSet.getYMin();
            }
            if (iDataSet.getYMax() > this.mYMax) {
                this.mYMax = iDataSet.getYMax();
            }
        }
        if (this.mYMin == Float.MAX_VALUE) {
            this.mYMin = 0.0f;
            this.mYMax = 0.0f;
        }
        IDataSet firstLeft = getFirstLeft();
        if (firstLeft != null) {
            this.mLeftAxisMax = firstLeft.getYMax();
            this.mLeftAxisMin = firstLeft.getYMin();
            for (T t10 : this.mDataSets) {
                if (t10.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                    if (t10.getYMin() < this.mLeftAxisMin) {
                        this.mLeftAxisMin = t10.getYMin();
                    }
                    if (t10.getYMax() > this.mLeftAxisMax) {
                        this.mLeftAxisMax = t10.getYMax();
                    }
                }
            }
        }
        IDataSet firstRight = getFirstRight();
        if (firstRight != null) {
            this.mRightAxisMax = firstRight.getYMax();
            this.mRightAxisMin = firstRight.getYMin();
            for (T t11 : this.mDataSets) {
                if (t11.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                    if (t11.getYMin() < this.mRightAxisMin) {
                        this.mRightAxisMin = t11.getYMin();
                    }
                    if (t11.getYMax() > this.mRightAxisMax) {
                        this.mRightAxisMax = t11.getYMax();
                    }
                }
            }
        }
        handleEmptyAxis(firstLeft, firstRight);
    }

    /* access modifiers changed from: protected */
    public void calcYValueCount() {
        this.mYValCount = 0;
        if (this.mDataSets != null) {
            int i10 = 0;
            for (int i11 = 0; i11 < this.mDataSets.size(); i11++) {
                i10 += ((IDataSet) this.mDataSets.get(i11)).getEntryCount();
            }
            this.mYValCount = i10;
        }
    }

    public void clearValues() {
        this.mDataSets.clear();
        notifyDataChanged();
    }

    public boolean contains(T t10) {
        for (T equals : this.mDataSets) {
            if (equals.equals(t10)) {
                return true;
            }
        }
        return false;
    }

    public int[] getColors() {
        if (this.mDataSets == null) {
            return null;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.mDataSets.size(); i11++) {
            i10 += ((IDataSet) this.mDataSets.get(i11)).getColors().size();
        }
        int[] iArr = new int[i10];
        int i12 = 0;
        for (int i13 = 0; i13 < this.mDataSets.size(); i13++) {
            for (Integer intValue : ((IDataSet) this.mDataSets.get(i13)).getColors()) {
                iArr[i12] = intValue.intValue();
                i12++;
            }
        }
        return iArr;
    }

    public T getDataSetByIndex(int i10) {
        List<T> list = this.mDataSets;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return (IDataSet) this.mDataSets.get(i10);
    }

    public T getDataSetByLabel(String str, boolean z10) {
        int dataSetIndexByLabel = getDataSetIndexByLabel(this.mDataSets, str, z10);
        if (dataSetIndexByLabel < 0 || dataSetIndexByLabel >= this.mDataSets.size()) {
            return null;
        }
        return (IDataSet) this.mDataSets.get(dataSetIndexByLabel);
    }

    public int getDataSetCount() {
        List<T> list = this.mDataSets;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getDataSetForEntry(Entry entry) {
        if (entry == null) {
            return null;
        }
        for (int i10 = 0; i10 < this.mDataSets.size(); i10++) {
            T t10 = (IDataSet) this.mDataSets.get(i10);
            for (int i11 = 0; i11 < t10.getEntryCount(); i11++) {
                if (entry.equalTo(t10.getEntryForXIndex(entry.getXIndex()))) {
                    return t10;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getDataSetIndexByLabel(List<T> list, String str, boolean z10) {
        int i10 = 0;
        if (z10) {
            while (i10 < list.size()) {
                if (str.equalsIgnoreCase(((IDataSet) list.get(i10)).getLabel())) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        while (i10 < list.size()) {
            if (str.equals(((IDataSet) list.get(i10)).getLabel())) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public String[] getDataSetLabels() {
        String[] strArr = new String[this.mDataSets.size()];
        for (int i10 = 0; i10 < this.mDataSets.size(); i10++) {
            strArr[i10] = ((IDataSet) this.mDataSets.get(i10)).getLabel();
        }
        return strArr;
    }

    public List<T> getDataSets() {
        return this.mDataSets;
    }

    public Entry getEntryForHighlight(Highlight highlight) {
        if (highlight.getDataSetIndex() >= this.mDataSets.size()) {
            return null;
        }
        return ((IDataSet) this.mDataSets.get(highlight.getDataSetIndex())).getEntryForXIndex(highlight.getXIndex());
    }

    public T getFirstLeft() {
        for (T t10 : this.mDataSets) {
            if (t10.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                return t10;
            }
        }
        return null;
    }

    public T getFirstRight() {
        for (T t10 : this.mDataSets) {
            if (t10.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                return t10;
            }
        }
        return null;
    }

    public int getIndexOfDataSet(T t10) {
        for (int i10 = 0; i10 < this.mDataSets.size(); i10++) {
            if (this.mDataSets.get(i10) == t10) {
                return i10;
            }
        }
        return -1;
    }

    public int getXValCount() {
        return this.mXVals.size();
    }

    public float getXValMaximumLength() {
        return this.mXValMaximumLength;
    }

    public List<String> getXVals() {
        return this.mXVals;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public float getYMin() {
        return this.mYMin;
    }

    public int getYValCount() {
        return this.mYValCount;
    }

    /* access modifiers changed from: protected */
    public void init() {
        checkLegal();
        calcYValueCount();
        calcMinMax(0, this.mYValCount);
        calcXValMaximumLength();
    }

    public boolean isHighlightEnabled() {
        for (T isHighlightEnabled : this.mDataSets) {
            if (!isHighlightEnabled.isHighlightEnabled()) {
                return false;
            }
        }
        return true;
    }

    public void notifyDataChanged() {
        init();
    }

    public boolean removeDataSet(T t10) {
        if (t10 == null) {
            return false;
        }
        boolean remove = this.mDataSets.remove(t10);
        if (remove) {
            int entryCount = this.mYValCount - t10.getEntryCount();
            this.mYValCount = entryCount;
            calcMinMax(0, entryCount);
        }
        return remove;
    }

    public boolean removeEntry(Entry entry, int i10) {
        IDataSet iDataSet;
        if (entry == null || i10 >= this.mDataSets.size() || (iDataSet = (IDataSet) this.mDataSets.get(i10)) == null) {
            return false;
        }
        boolean removeEntry = iDataSet.removeEntry(entry);
        if (removeEntry) {
            int i11 = this.mYValCount - 1;
            this.mYValCount = i11;
            calcMinMax(0, i11);
        }
        return removeEntry;
    }

    public void removeXValue(int i10) {
        this.mXVals.remove(i10);
    }

    public void setDrawValues(boolean z10) {
        for (T drawValues : this.mDataSets) {
            drawValues.setDrawValues(z10);
        }
    }

    public void setHighlightEnabled(boolean z10) {
        for (T highlightEnabled : this.mDataSets) {
            highlightEnabled.setHighlightEnabled(z10);
        }
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter != null) {
            for (T valueFormatter2 : this.mDataSets) {
                valueFormatter2.setValueFormatter(valueFormatter);
            }
        }
    }

    public void setValueTextColor(int i10) {
        for (T valueTextColor : this.mDataSets) {
            valueTextColor.setValueTextColor(i10);
        }
    }

    public void setValueTextColors(List<Integer> list) {
        for (T valueTextColors : this.mDataSets) {
            valueTextColors.setValueTextColors(list);
        }
    }

    public void setValueTextSize(float f10) {
        for (T valueTextSize : this.mDataSets) {
            valueTextSize.setValueTextSize(f10);
        }
    }

    public void setValueTypeface(Typeface typeface) {
        for (T valueTypeface : this.mDataSets) {
            valueTypeface.setValueTypeface(typeface);
        }
    }

    public float getYMax(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mLeftAxisMax;
        }
        return this.mRightAxisMax;
    }

    public float getYMin(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mLeftAxisMin;
        }
        return this.mRightAxisMin;
    }

    public boolean removeDataSet(int i10) {
        if (i10 >= this.mDataSets.size() || i10 < 0) {
            return false;
        }
        return removeDataSet((IDataSet) this.mDataSets.get(i10));
    }

    public boolean removeEntry(int i10, int i11) {
        Entry entryForXIndex;
        if (i11 < this.mDataSets.size() && (entryForXIndex = ((IDataSet) this.mDataSets.get(i11)).getEntryForXIndex(i10)) != null && entryForXIndex.getXIndex() == i10) {
            return removeEntry(entryForXIndex, i11);
        }
        return false;
    }

    public ChartData(List<String> list) {
        this.mYMax = 0.0f;
        this.mYMin = 0.0f;
        this.mLeftAxisMax = 0.0f;
        this.mLeftAxisMin = 0.0f;
        this.mRightAxisMax = 0.0f;
        this.mRightAxisMin = 0.0f;
        this.mYValCount = 0;
        this.mXValMaximumLength = 0.0f;
        this.mXVals = list;
        this.mDataSets = new ArrayList();
        init();
    }

    public ChartData(String[] strArr) {
        this.mYMax = 0.0f;
        this.mYMin = 0.0f;
        this.mLeftAxisMax = 0.0f;
        this.mLeftAxisMin = 0.0f;
        this.mRightAxisMax = 0.0f;
        this.mRightAxisMin = 0.0f;
        this.mYValCount = 0;
        this.mXValMaximumLength = 0.0f;
        this.mXVals = arrayToList(strArr);
        this.mDataSets = new ArrayList();
        init();
    }

    public ChartData(List<String> list, List<T> list2) {
        this.mYMax = 0.0f;
        this.mYMin = 0.0f;
        this.mLeftAxisMax = 0.0f;
        this.mLeftAxisMin = 0.0f;
        this.mRightAxisMax = 0.0f;
        this.mRightAxisMin = 0.0f;
        this.mYValCount = 0;
        this.mXValMaximumLength = 0.0f;
        this.mXVals = list;
        this.mDataSets = list2;
        init();
    }

    public ChartData(String[] strArr, List<T> list) {
        this.mYMax = 0.0f;
        this.mYMin = 0.0f;
        this.mLeftAxisMax = 0.0f;
        this.mLeftAxisMin = 0.0f;
        this.mRightAxisMax = 0.0f;
        this.mRightAxisMin = 0.0f;
        this.mYValCount = 0;
        this.mXValMaximumLength = 0.0f;
        this.mXVals = arrayToList(strArr);
        this.mDataSets = list;
        init();
    }
}
