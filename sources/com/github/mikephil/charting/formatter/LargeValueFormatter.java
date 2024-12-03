package com.github.mikephil.charting.formatter;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.text.DecimalFormat;

public class LargeValueFormatter implements ValueFormatter, YAxisValueFormatter {
    private static final int MAX_LENGTH = 4;
    private static String[] SUFFIX = {"", "k", NetworkProfile.MALE, NetworkProfile.BISEXUAL, "t"};
    private DecimalFormat mFormat;
    private String mText;

    public LargeValueFormatter() {
        this.mText = "";
        this.mFormat = new DecimalFormat("###E0");
    }

    private String makePretty(double d10) {
        String format2 = this.mFormat.format(d10);
        String replaceAll = format2.replaceAll("E[0-9]", SUFFIX[Character.getNumericValue(format2.charAt(format2.length() - 1)) / 3]);
        while (true) {
            if (replaceAll.length() <= 4 && !replaceAll.matches("[0-9]+\\.[a-z]")) {
                return replaceAll;
            }
            replaceAll = replaceAll.substring(0, replaceAll.length() - 2) + replaceAll.substring(replaceAll.length() - 1);
        }
    }

    public String getFormattedValue(float f10, Entry entry, int i10, ViewPortHandler viewPortHandler) {
        return makePretty((double) f10) + this.mText;
    }

    public void setAppendix(String str) {
        this.mText = str;
    }

    public void setSuffix(String[] strArr) {
        if (strArr.length == 5) {
            SUFFIX = strArr;
        }
    }

    public String getFormattedValue(float f10, YAxis yAxis) {
        return makePretty((double) f10) + this.mText;
    }

    public LargeValueFormatter(String str) {
        this();
        this.mText = str;
    }
}
