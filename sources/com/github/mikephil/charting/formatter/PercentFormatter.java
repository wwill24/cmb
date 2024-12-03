package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.text.DecimalFormat;

public class PercentFormatter implements ValueFormatter, YAxisValueFormatter {
    protected DecimalFormat mFormat;

    public PercentFormatter() {
        this.mFormat = new DecimalFormat("###,###,##0.0");
    }

    public String getFormattedValue(float f10, Entry entry, int i10, ViewPortHandler viewPortHandler) {
        return this.mFormat.format((double) f10) + " %";
    }

    public String getFormattedValue(float f10, YAxis yAxis) {
        return this.mFormat.format((double) f10) + " %";
    }

    public PercentFormatter(DecimalFormat decimalFormat) {
        this.mFormat = decimalFormat;
    }
}
