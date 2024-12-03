package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;

public interface ValueFormatter {
    String getFormattedValue(float f10, Entry entry, int i10, ViewPortHandler viewPortHandler);
}
