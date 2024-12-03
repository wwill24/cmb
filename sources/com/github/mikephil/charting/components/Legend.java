package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class Legend extends ComponentBase {
    private Boolean[] mCalculatedLabelBreakPoints;
    private FSize[] mCalculatedLabelSizes;
    private FSize[] mCalculatedLineSizes;
    private int[] mColors;
    private LegendDirection mDirection;
    private int[] mExtraColors;
    private String[] mExtraLabels;
    private float mFormSize;
    private float mFormToTextSpace;
    private boolean mIsLegendCustom;
    private String[] mLabels;
    private float mMaxSizePercent;
    public float mNeededHeight;
    public float mNeededWidth;
    private LegendPosition mPosition;
    private LegendForm mShape;
    private float mStackSpace;
    public float mTextHeightMax;
    public float mTextWidthMax;
    private boolean mWordWrapEnabled;
    private float mXEntrySpace;
    private float mYEntrySpace;

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendPosition {
        RIGHT_OF_CHART,
        RIGHT_OF_CHART_CENTER,
        RIGHT_OF_CHART_INSIDE,
        LEFT_OF_CHART,
        LEFT_OF_CHART_CENTER,
        LEFT_OF_CHART_INSIDE,
        BELOW_CHART_LEFT,
        BELOW_CHART_RIGHT,
        BELOW_CHART_CENTER,
        ABOVE_CHART_LEFT,
        ABOVE_CHART_RIGHT,
        ABOVE_CHART_CENTER,
        PIECHART_CENTER
    }

    public Legend() {
        this.mIsLegendCustom = false;
        this.mPosition = LegendPosition.BELOW_CHART_LEFT;
        this.mDirection = LegendDirection.LEFT_TO_RIGHT;
        this.mShape = LegendForm.SQUARE;
        this.mFormSize = 8.0f;
        this.mXEntrySpace = 6.0f;
        this.mYEntrySpace = 0.0f;
        this.mFormToTextSpace = 5.0f;
        this.mStackSpace = 3.0f;
        this.mMaxSizePercent = 0.95f;
        this.mNeededWidth = 0.0f;
        this.mNeededHeight = 0.0f;
        this.mTextHeightMax = 0.0f;
        this.mTextWidthMax = 0.0f;
        this.mWordWrapEnabled = false;
        this.mCalculatedLabelSizes = new FSize[0];
        this.mCalculatedLabelBreakPoints = new Boolean[0];
        this.mCalculatedLineSizes = new FSize[0];
        this.mFormSize = Utils.convertDpToPixel(8.0f);
        this.mXEntrySpace = Utils.convertDpToPixel(6.0f);
        this.mYEntrySpace = Utils.convertDpToPixel(0.0f);
        this.mFormToTextSpace = Utils.convertDpToPixel(5.0f);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mStackSpace = Utils.convertDpToPixel(3.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(4.0f);
    }

    public void calculateDimensions(Paint paint, ViewPortHandler viewPortHandler) {
        int i10;
        float f10;
        float f11;
        int i11;
        int i12;
        float f12;
        float f13;
        LegendPosition legendPosition = this.mPosition;
        if (legendPosition == LegendPosition.RIGHT_OF_CHART || legendPosition == LegendPosition.RIGHT_OF_CHART_CENTER || legendPosition == LegendPosition.LEFT_OF_CHART || legendPosition == LegendPosition.LEFT_OF_CHART_CENTER || legendPosition == LegendPosition.PIECHART_CENTER) {
            this.mNeededWidth = getMaximumEntryWidth(paint);
            this.mNeededHeight = getFullHeight(paint);
            this.mTextWidthMax = this.mNeededWidth;
            this.mTextHeightMax = getMaximumEntryHeight(paint);
        } else if (legendPosition == LegendPosition.BELOW_CHART_LEFT || legendPosition == LegendPosition.BELOW_CHART_RIGHT || legendPosition == LegendPosition.BELOW_CHART_CENTER || legendPosition == LegendPosition.ABOVE_CHART_LEFT || legendPosition == LegendPosition.ABOVE_CHART_RIGHT || legendPosition == LegendPosition.ABOVE_CHART_CENTER) {
            int length = this.mLabels.length;
            float lineHeight = Utils.getLineHeight(paint);
            float lineSpacing = Utils.getLineSpacing(paint) + this.mYEntrySpace;
            float contentWidth = viewPortHandler.contentWidth();
            ArrayList arrayList = new ArrayList(length);
            ArrayList arrayList2 = new ArrayList(length);
            ArrayList arrayList3 = new ArrayList();
            int i13 = -1;
            int i14 = -1;
            int i15 = 0;
            float f14 = 0.0f;
            float f15 = 0.0f;
            float f16 = 0.0f;
            while (true) {
                boolean z10 = true;
                if (i15 >= length) {
                    break;
                }
                if (this.mColors[i15] == -2) {
                    z10 = false;
                }
                arrayList2.add(Boolean.FALSE);
                if (i14 == i13) {
                    f10 = 0.0f;
                } else {
                    f10 = this.mStackSpace + f15;
                }
                String str = this.mLabels[i15];
                if (str != null) {
                    arrayList.add(Utils.calcTextSize(paint, str));
                    if (z10) {
                        f13 = this.mFormSize + this.mFormToTextSpace;
                    } else {
                        f13 = 0.0f;
                    }
                    f11 = f10 + f13 + ((FSize) arrayList.get(i15)).width;
                } else {
                    Paint paint2 = paint;
                    arrayList.add(new FSize(0.0f, 0.0f));
                    if (z10) {
                        f12 = this.mFormSize;
                    } else {
                        f12 = 0.0f;
                    }
                    f11 = f10 + f12;
                    if (i14 == -1) {
                        i14 = i15;
                    }
                }
                if (this.mLabels[i15] != null || i15 == length - 1) {
                    float f17 = 0.0f;
                    int i16 = (f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1));
                    if (i16 != 0) {
                        f17 = this.mXEntrySpace;
                    }
                    if (!this.mWordWrapEnabled || i16 == 0 || contentWidth - f16 >= f17 + f11) {
                        i11 = -1;
                        f16 += f17 + f11;
                    } else {
                        arrayList3.add(new FSize(f16, lineHeight));
                        float max = Math.max(f14, f16);
                        i11 = -1;
                        if (i14 > -1) {
                            i12 = i14;
                        } else {
                            i12 = i15;
                        }
                        arrayList2.set(i12, Boolean.TRUE);
                        f16 = f11;
                        f14 = max;
                    }
                    if (i15 == length - 1) {
                        arrayList3.add(new FSize(f16, lineHeight));
                        f14 = Math.max(f14, f16);
                    }
                } else {
                    i11 = -1;
                }
                if (this.mLabels[i15] != null) {
                    i14 = i11;
                }
                i15++;
                i13 = i11;
                f15 = f11;
            }
            this.mCalculatedLabelSizes = (FSize[]) arrayList.toArray(new FSize[arrayList.size()]);
            this.mCalculatedLabelBreakPoints = (Boolean[]) arrayList2.toArray(new Boolean[arrayList2.size()]);
            this.mCalculatedLineSizes = (FSize[]) arrayList3.toArray(new FSize[arrayList3.size()]);
            this.mTextWidthMax = getMaximumEntryWidth(paint);
            this.mTextHeightMax = getMaximumEntryHeight(paint);
            this.mNeededWidth = f14;
            FSize[] fSizeArr = this.mCalculatedLineSizes;
            float length2 = lineHeight * ((float) fSizeArr.length);
            if (fSizeArr.length == 0) {
                i10 = 0;
            } else {
                i10 = fSizeArr.length - 1;
            }
            this.mNeededHeight = length2 + (lineSpacing * ((float) i10));
        } else {
            this.mNeededWidth = getFullWidth(paint);
            this.mNeededHeight = getMaximumEntryHeight(paint);
            this.mTextWidthMax = getMaximumEntryWidth(paint);
            this.mTextHeightMax = this.mNeededHeight;
        }
    }

    public Boolean[] getCalculatedLabelBreakPoints() {
        return this.mCalculatedLabelBreakPoints;
    }

    public FSize[] getCalculatedLabelSizes() {
        return this.mCalculatedLabelSizes;
    }

    public FSize[] getCalculatedLineSizes() {
        return this.mCalculatedLineSizes;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public LegendDirection getDirection() {
        return this.mDirection;
    }

    public int[] getExtraColors() {
        return this.mExtraColors;
    }

    public String[] getExtraLabels() {
        return this.mExtraLabels;
    }

    public LegendForm getForm() {
        return this.mShape;
    }

    public float getFormSize() {
        return this.mFormSize;
    }

    public float getFormToTextSpace() {
        return this.mFormToTextSpace;
    }

    public float getFullHeight(Paint paint) {
        float f10 = 0.0f;
        int i10 = 0;
        while (true) {
            String[] strArr = this.mLabels;
            if (i10 >= strArr.length) {
                return f10;
            }
            String str = strArr[i10];
            if (str != null) {
                f10 += (float) Utils.calcTextHeight(paint, str);
                if (i10 < this.mLabels.length - 1) {
                    f10 += this.mYEntrySpace;
                }
            }
            i10++;
        }
    }

    public float getFullWidth(Paint paint) {
        float f10;
        float f11 = 0.0f;
        int i10 = 0;
        while (true) {
            String[] strArr = this.mLabels;
            if (i10 >= strArr.length) {
                return f11;
            }
            String str = strArr[i10];
            if (str != null) {
                if (this.mColors[i10] != -2) {
                    f11 += this.mFormSize + this.mFormToTextSpace;
                }
                f11 += (float) Utils.calcTextWidth(paint, str);
                if (i10 < this.mLabels.length - 1) {
                    f10 = this.mXEntrySpace;
                } else {
                    i10++;
                }
            } else {
                f11 += this.mFormSize;
                if (i10 < strArr.length - 1) {
                    f10 = this.mStackSpace;
                } else {
                    i10++;
                }
            }
            f11 += f10;
            i10++;
        }
    }

    public String getLabel(int i10) {
        return this.mLabels[i10];
    }

    public String[] getLabels() {
        return this.mLabels;
    }

    public float getMaxSizePercent() {
        return this.mMaxSizePercent;
    }

    public float getMaximumEntryHeight(Paint paint) {
        float f10 = 0.0f;
        int i10 = 0;
        while (true) {
            String[] strArr = this.mLabels;
            if (i10 >= strArr.length) {
                return f10;
            }
            String str = strArr[i10];
            if (str != null) {
                float calcTextHeight = (float) Utils.calcTextHeight(paint, str);
                if (calcTextHeight > f10) {
                    f10 = calcTextHeight;
                }
            }
            i10++;
        }
    }

    public float getMaximumEntryWidth(Paint paint) {
        float f10 = 0.0f;
        int i10 = 0;
        while (true) {
            String[] strArr = this.mLabels;
            if (i10 >= strArr.length) {
                return f10 + this.mFormSize + this.mFormToTextSpace;
            }
            String str = strArr[i10];
            if (str != null) {
                float calcTextWidth = (float) Utils.calcTextWidth(paint, str);
                if (calcTextWidth > f10) {
                    f10 = calcTextWidth;
                }
            }
            i10++;
        }
    }

    public LegendPosition getPosition() {
        return this.mPosition;
    }

    public float getStackSpace() {
        return this.mStackSpace;
    }

    public float getXEntrySpace() {
        return this.mXEntrySpace;
    }

    public float getYEntrySpace() {
        return this.mYEntrySpace;
    }

    public boolean isLegendCustom() {
        return this.mIsLegendCustom;
    }

    public boolean isWordWrapEnabled() {
        return this.mWordWrapEnabled;
    }

    public void resetCustom() {
        this.mIsLegendCustom = false;
    }

    public void setComputedColors(List<Integer> list) {
        this.mColors = Utils.convertIntegers(list);
    }

    public void setComputedLabels(List<String> list) {
        this.mLabels = Utils.convertStrings(list);
    }

    public void setCustom(int[] iArr, String[] strArr) {
        if (iArr.length == strArr.length) {
            this.mLabels = strArr;
            this.mColors = iArr;
            this.mIsLegendCustom = true;
            return;
        }
        throw new IllegalArgumentException("colors array and labels array need to be of same size");
    }

    public void setDirection(LegendDirection legendDirection) {
        this.mDirection = legendDirection;
    }

    public void setExtra(List<Integer> list, List<String> list2) {
        this.mExtraColors = Utils.convertIntegers(list);
        this.mExtraLabels = Utils.convertStrings(list2);
    }

    public void setForm(LegendForm legendForm) {
        this.mShape = legendForm;
    }

    public void setFormSize(float f10) {
        this.mFormSize = Utils.convertDpToPixel(f10);
    }

    public void setFormToTextSpace(float f10) {
        this.mFormToTextSpace = Utils.convertDpToPixel(f10);
    }

    public void setMaxSizePercent(float f10) {
        this.mMaxSizePercent = f10;
    }

    public void setPosition(LegendPosition legendPosition) {
        this.mPosition = legendPosition;
    }

    public void setStackSpace(float f10) {
        this.mStackSpace = f10;
    }

    public void setWordWrapEnabled(boolean z10) {
        this.mWordWrapEnabled = z10;
    }

    public void setXEntrySpace(float f10) {
        this.mXEntrySpace = Utils.convertDpToPixel(f10);
    }

    public void setYEntrySpace(float f10) {
        this.mYEntrySpace = Utils.convertDpToPixel(f10);
    }

    public void setExtra(int[] iArr, String[] strArr) {
        this.mExtraColors = iArr;
        this.mExtraLabels = strArr;
    }

    public void setCustom(List<Integer> list, List<String> list2) {
        if (list.size() == list2.size()) {
            this.mColors = Utils.convertIntegers(list);
            this.mLabels = Utils.convertStrings(list2);
            this.mIsLegendCustom = true;
            return;
        }
        throw new IllegalArgumentException("colors array and labels array need to be of same size");
    }

    public Legend(int[] iArr, String[] strArr) {
        this();
        if (iArr == null || strArr == null) {
            throw new IllegalArgumentException("colors array or labels array is NULL");
        } else if (iArr.length == strArr.length) {
            this.mColors = iArr;
            this.mLabels = strArr;
        } else {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        }
    }

    public Legend(List<Integer> list, List<String> list2) {
        this();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("colors array or labels array is NULL");
        } else if (list.size() == list2.size()) {
            this.mColors = Utils.convertIntegers(list);
            this.mLabels = Utils.convertStrings(list2);
        } else {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        }
    }
}
