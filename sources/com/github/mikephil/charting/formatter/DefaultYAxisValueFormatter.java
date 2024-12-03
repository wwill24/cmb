package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.YAxis;
import java.text.DecimalFormat;

public class DefaultYAxisValueFormatter implements YAxisValueFormatter {
    private DecimalFormat mFormat;

    public DefaultYAxisValueFormatter(int i10) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String getFormattedValue(float f10, YAxis yAxis) {
        return this.mFormat.format((double) f10);
    }
}
