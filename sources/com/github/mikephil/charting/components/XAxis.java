package com.github.mikephil.charting.components;

import com.github.mikephil.charting.formatter.DefaultXAxisValueFormatter;
import com.github.mikephil.charting.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class XAxis extends AxisBase {
    private boolean mAvoidFirstLastClipping = false;
    public int mAxisLabelModulus = 1;
    private boolean mIsAxisModulusCustom = false;
    public int mLabelHeight = 1;
    public int mLabelRotatedHeight = 1;
    public int mLabelRotatedWidth = 1;
    protected float mLabelRotationAngle = 0.0f;
    public int mLabelWidth = 1;
    private XAxisPosition mPosition = XAxisPosition.TOP;
    private int mSpaceBetweenLabels = 4;
    protected List<String> mValues = new ArrayList();
    protected XAxisValueFormatter mXAxisValueFormatter = new DefaultXAxisValueFormatter();

    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.mYOffset = Utils.convertDpToPixel(4.0f);
    }

    public float getLabelRotationAngle() {
        return this.mLabelRotationAngle;
    }

    public String getLongestLabel() {
        String str = "";
        for (int i10 = 0; i10 < this.mValues.size(); i10++) {
            String str2 = this.mValues.get(i10);
            if (str.length() < str2.length()) {
                str = str2;
            }
        }
        return str;
    }

    public XAxisPosition getPosition() {
        return this.mPosition;
    }

    public int getSpaceBetweenLabels() {
        return this.mSpaceBetweenLabels;
    }

    public XAxisValueFormatter getValueFormatter() {
        return this.mXAxisValueFormatter;
    }

    public List<String> getValues() {
        return this.mValues;
    }

    public boolean isAvoidFirstLastClippingEnabled() {
        return this.mAvoidFirstLastClipping;
    }

    public boolean isAxisModulusCustom() {
        return this.mIsAxisModulusCustom;
    }

    public void resetLabelsToSkip() {
        this.mIsAxisModulusCustom = false;
    }

    public void setAvoidFirstLastClipping(boolean z10) {
        this.mAvoidFirstLastClipping = z10;
    }

    public void setLabelRotationAngle(float f10) {
        this.mLabelRotationAngle = f10;
    }

    public void setLabelsToSkip(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.mIsAxisModulusCustom = true;
        this.mAxisLabelModulus = i10 + 1;
    }

    public void setPosition(XAxisPosition xAxisPosition) {
        this.mPosition = xAxisPosition;
    }

    public void setSpaceBetweenLabels(int i10) {
        this.mSpaceBetweenLabels = i10;
    }

    public void setValueFormatter(XAxisValueFormatter xAxisValueFormatter) {
        if (xAxisValueFormatter == null) {
            this.mXAxisValueFormatter = new DefaultXAxisValueFormatter();
        } else {
            this.mXAxisValueFormatter = xAxisValueFormatter;
        }
    }

    public void setValues(List<String> list) {
        this.mValues = list;
    }
}
