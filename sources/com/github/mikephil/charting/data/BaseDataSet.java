package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class BaseDataSet<T extends Entry> implements IDataSet<T> {
    protected YAxis.AxisDependency mAxisDependency;
    protected List<Integer> mColors;
    protected boolean mDrawValues;
    protected boolean mHighlightEnabled;
    private String mLabel;
    protected List<Integer> mValueColors;
    protected transient ValueFormatter mValueFormatter;
    protected float mValueTextSize;
    protected Typeface mValueTypeface;
    protected boolean mVisible;

    public BaseDataSet() {
        this.mColors = null;
        this.mValueColors = null;
        this.mLabel = "DataSet";
        this.mAxisDependency = YAxis.AxisDependency.LEFT;
        this.mHighlightEnabled = true;
        this.mDrawValues = true;
        this.mValueTextSize = 17.0f;
        this.mVisible = true;
        this.mColors = new ArrayList();
        this.mValueColors = new ArrayList();
        this.mColors.add(Integer.valueOf(Color.rgb(Opcodes.F2L, 234, 255)));
        this.mValueColors.add(-16777216);
    }

    public void addColor(int i10) {
        if (this.mColors == null) {
            this.mColors = new ArrayList();
        }
        this.mColors.add(Integer.valueOf(i10));
    }

    public boolean contains(T t10) {
        for (int i10 = 0; i10 < getEntryCount(); i10++) {
            if (getEntryForIndex(i10).equals(t10)) {
                return true;
            }
        }
        return false;
    }

    public YAxis.AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    public int getColor() {
        return this.mColors.get(0).intValue();
    }

    public List<Integer> getColors() {
        return this.mColors;
    }

    public int getIndexInEntries(int i10) {
        for (int i11 = 0; i11 < getEntryCount(); i11++) {
            if (i10 == getEntryForIndex(i11).getXIndex()) {
                return i11;
            }
        }
        return -1;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public List<Integer> getValueColors() {
        return this.mValueColors;
    }

    public ValueFormatter getValueFormatter() {
        ValueFormatter valueFormatter = this.mValueFormatter;
        if (valueFormatter == null) {
            return new DefaultValueFormatter(1);
        }
        return valueFormatter;
    }

    public int getValueTextColor() {
        return this.mValueColors.get(0).intValue();
    }

    public float getValueTextSize() {
        return this.mValueTextSize;
    }

    public Typeface getValueTypeface() {
        return this.mValueTypeface;
    }

    public boolean isDrawValuesEnabled() {
        return this.mDrawValues;
    }

    public boolean isHighlightEnabled() {
        return this.mHighlightEnabled;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public void notifyDataSetChanged() {
        calcMinMax(0, getEntryCount() - 1);
    }

    public boolean removeEntry(int i10) {
        return removeEntry(getEntryForXIndex(i10));
    }

    public boolean removeFirst() {
        return removeEntry(getEntryForIndex(0));
    }

    public boolean removeLast() {
        return removeEntry(getEntryForIndex(getEntryCount() - 1));
    }

    public void resetColors() {
        this.mColors = new ArrayList();
    }

    public void setAxisDependency(YAxis.AxisDependency axisDependency) {
        this.mAxisDependency = axisDependency;
    }

    public void setColor(int i10) {
        resetColors();
        this.mColors.add(Integer.valueOf(i10));
    }

    public void setColors(List<Integer> list) {
        this.mColors = list;
    }

    public void setDrawValues(boolean z10) {
        this.mDrawValues = z10;
    }

    public void setHighlightEnabled(boolean z10) {
        this.mHighlightEnabled = z10;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter != null) {
            this.mValueFormatter = valueFormatter;
        }
    }

    public void setValueTextColor(int i10) {
        this.mValueColors.clear();
        this.mValueColors.add(Integer.valueOf(i10));
    }

    public void setValueTextColors(List<Integer> list) {
        this.mValueColors = list;
    }

    public void setValueTextSize(float f10) {
        this.mValueTextSize = Utils.convertDpToPixel(f10);
    }

    public void setValueTypeface(Typeface typeface) {
        this.mValueTypeface = typeface;
    }

    public void setVisible(boolean z10) {
        this.mVisible = z10;
    }

    public int getColor(int i10) {
        List<Integer> list = this.mColors;
        return list.get(i10 % list.size()).intValue();
    }

    public int getValueTextColor(int i10) {
        List<Integer> list = this.mValueColors;
        return list.get(i10 % list.size()).intValue();
    }

    public void setColors(int[] iArr) {
        this.mColors = ColorTemplate.createColors(iArr);
    }

    public void setColor(int i10, int i11) {
        setColor(Color.argb(i11, Color.red(i10), Color.green(i10), Color.blue(i10)));
    }

    public void setColors(int[] iArr, Context context) {
        ArrayList arrayList = new ArrayList();
        for (int color : iArr) {
            arrayList.add(Integer.valueOf(context.getResources().getColor(color)));
        }
        this.mColors = arrayList;
    }

    public void setColors(int[] iArr, int i10) {
        resetColors();
        for (int i11 : iArr) {
            addColor(Color.argb(i10, Color.red(i11), Color.green(i11), Color.blue(i11)));
        }
    }

    public BaseDataSet(String str) {
        this();
        this.mLabel = str;
    }
}
