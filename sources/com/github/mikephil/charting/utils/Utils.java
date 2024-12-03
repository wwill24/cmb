package com.github.mikephil.charting.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.mparticle.kits.MPSideloadedKit;
import java.util.List;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public abstract class Utils {
    public static final double DEG2RAD = 0.017453292519943295d;
    public static final float FDEG2RAD = 0.017453292f;
    private static final int[] POW_10 = {1, 10, 100, 1000, 10000, 100000, MPSideloadedKit.MIN_SIDELOADED_KIT, 10000000, 100000000, 1000000000};
    private static Rect mDrawTextRectBuffer = new Rect();
    private static Paint.FontMetrics mFontMetricsBuffer = new Paint.FontMetrics();
    private static int mMaximumFlingVelocity = 8000;
    private static DisplayMetrics mMetrics = null;
    private static int mMinimumFlingVelocity = 50;

    public static int calcTextHeight(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static FSize calcTextSize(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return new FSize((float) rect.width(), (float) rect.height());
    }

    public static int calcTextWidth(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static float convertDpToPixel(float f10) {
        DisplayMetrics displayMetrics = mMetrics;
        if (displayMetrics == null) {
            return f10;
        }
        return f10 * (((float) displayMetrics.densityDpi) / 160.0f);
    }

    public static int[] convertIntegers(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = list.get(i10).intValue();
        }
        return iArr;
    }

    public static float convertPixelsToDp(float f10) {
        DisplayMetrics displayMetrics = mMetrics;
        if (displayMetrics == null) {
            return f10;
        }
        return f10 / (((float) displayMetrics.densityDpi) / 160.0f);
    }

    public static String[] convertStrings(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = list.get(i10);
        }
        return strArr;
    }

    public static void drawMultilineText(Canvas canvas, StaticLayout staticLayout, float f10, float f11, TextPaint textPaint, PointF pointF, float f12) {
        float fontMetrics = textPaint.getFontMetrics(mFontMetricsBuffer);
        float width = (float) staticLayout.getWidth();
        float lineCount = ((float) staticLayout.getLineCount()) * fontMetrics;
        float f13 = 0.0f - ((float) mDrawTextRectBuffer.left);
        float f14 = lineCount + 0.0f;
        Paint.Align textAlign = textPaint.getTextAlign();
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (f12 != 0.0f) {
            float f15 = f13 - (width * 0.5f);
            float f16 = f14 - (lineCount * 0.5f);
            if (!(pointF.x == 0.5f && pointF.y == 0.5f)) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees(width, lineCount, f12);
                f10 -= sizeOfRotatedRectangleByDegrees.width * (pointF.x - 0.5f);
                f11 -= sizeOfRotatedRectangleByDegrees.height * (pointF.y - 0.5f);
            }
            canvas.save();
            canvas.translate(f10, f11);
            canvas.rotate(f12);
            canvas.translate(f15, f16);
            staticLayout.draw(canvas);
            canvas.restore();
        } else {
            float f17 = pointF.x;
            if (!(f17 == 0.0f && pointF.y == 0.0f)) {
                f13 -= width * f17;
                f14 -= lineCount * pointF.y;
            }
            canvas.save();
            canvas.translate(f13 + f10, f14 + f11);
            staticLayout.draw(canvas);
            canvas.restore();
        }
        textPaint.setTextAlign(textAlign);
    }

    public static void drawText(Canvas canvas, String str, float f10, float f11, Paint paint, PointF pointF, float f12) {
        paint.getTextBounds(str, 0, str.length(), mDrawTextRectBuffer);
        float height = (float) mDrawTextRectBuffer.height();
        float f13 = 0.0f - ((float) mDrawTextRectBuffer.left);
        float f14 = height + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f12 != 0.0f) {
            float width = f13 - (((float) mDrawTextRectBuffer.width()) * 0.5f);
            float f15 = f14 - (height * 0.5f);
            if (!(pointF.x == 0.5f && pointF.y == 0.5f)) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees((float) mDrawTextRectBuffer.width(), height, f12);
                f10 -= sizeOfRotatedRectangleByDegrees.width * (pointF.x - 0.5f);
                f11 -= sizeOfRotatedRectangleByDegrees.height * (pointF.y - 0.5f);
            }
            canvas.save();
            canvas.translate(f10, f11);
            canvas.rotate(f12);
            canvas.drawText(str, width, f15, paint);
            canvas.restore();
        } else {
            if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
                f13 -= ((float) mDrawTextRectBuffer.width()) * pointF.x;
                f14 -= height * pointF.y;
            }
            canvas.drawText(str, f13 + f10, f14 + f11, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static String formatNumber(float f10, int i10, boolean z10) {
        return formatNumber(f10, i10, z10, '.');
    }

    public static int getClosestDataSetIndex(List<SelectionDetail> list, float f10, YAxis.AxisDependency axisDependency) {
        int i10 = -2147483647;
        float f11 = Float.MAX_VALUE;
        for (int i11 = 0; i11 < list.size(); i11++) {
            SelectionDetail selectionDetail = list.get(i11);
            if (axisDependency == null || selectionDetail.dataSet.getAxisDependency() == axisDependency) {
                float abs = Math.abs(selectionDetail.val - f10);
                if (abs < f11) {
                    i10 = list.get(i11).dataSetIndex;
                    f11 = abs;
                }
            }
        }
        return i10;
    }

    public static int getDecimals(float f10) {
        return ((int) Math.ceil(-Math.log10((double) roundToNextSignificant((double) f10)))) + 2;
    }

    public static float getLineHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getLineSpacing(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static int getMaximumFlingVelocity() {
        return mMaximumFlingVelocity;
    }

    public static float getMinimumDistance(List<SelectionDetail> list, float f10, YAxis.AxisDependency axisDependency) {
        float f11 = Float.MAX_VALUE;
        for (int i10 = 0; i10 < list.size(); i10++) {
            SelectionDetail selectionDetail = list.get(i10);
            if (selectionDetail.dataSet.getAxisDependency() == axisDependency) {
                float abs = Math.abs(selectionDetail.val - f10);
                if (abs < f11) {
                    f11 = abs;
                }
            }
        }
        return f11;
    }

    public static int getMinimumFlingVelocity() {
        return mMinimumFlingVelocity;
    }

    public static float getNormalizedAngle(float f10) {
        while (f10 < 0.0f) {
            f10 += 360.0f;
        }
        return f10 % 360.0f;
    }

    public static PointF getPosition(PointF pointF, float f10, float f11) {
        double d10 = (double) f10;
        double d11 = (double) f11;
        return new PointF((float) (((double) pointF.x) + (Math.cos(Math.toRadians(d11)) * d10)), (float) (((double) pointF.y) + (d10 * Math.sin(Math.toRadians(d11)))));
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(FSize fSize, float f10) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f10 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(FSize fSize, float f10) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f10);
    }

    public static void init(Context context) {
        if (context == null) {
            mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        mMetrics = context.getResources().getDisplayMetrics();
    }

    public static boolean needsDefaultFormatter(ValueFormatter valueFormatter) {
        return valueFormatter == null || (valueFormatter instanceof DefaultValueFormatter);
    }

    public static double nextUp(double d10) {
        if (d10 == Double.POSITIVE_INFINITY) {
            return d10;
        }
        double d11 = d10 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d11) + (d11 >= 0.0d ? 1 : -1));
    }

    @SuppressLint({"NewApi"})
    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    public static float roundToNextSignificant(double d10) {
        double d11;
        if (d10 < 0.0d) {
            d11 = -d10;
        } else {
            d11 = d10;
        }
        float pow = (float) Math.pow(10.0d, (double) (1 - ((int) ((float) Math.ceil((double) ((float) Math.log10(d11)))))));
        return ((float) Math.round(d10 * ((double) pow))) / pow;
    }

    public static void velocityTrackerPointerUpCleanUpIfNecessary(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, (float) mMaximumFlingVelocity);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            if (i10 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i10);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    public static String formatNumber(float f10, int i10, boolean z10, char c10) {
        boolean z11;
        float f11 = f10;
        char[] cArr = new char[35];
        if (f11 == 0.0f) {
            return "0";
        }
        int i11 = 0;
        boolean z12 = f11 < 1.0f && f11 > -1.0f;
        if (f11 < 0.0f) {
            f11 = -f11;
            z11 = true;
        } else {
            z11 = false;
        }
        int[] iArr = POW_10;
        int i12 = i10;
        int length = i12 > iArr.length ? iArr.length - 1 : i12;
        long round = (long) Math.round(f11 * ((float) iArr[length]));
        int i13 = 34;
        boolean z13 = false;
        while (true) {
            if (round == 0 && i11 >= length + 1) {
                break;
            }
            boolean z14 = z13;
            round /= 10;
            int i14 = i13 - 1;
            cArr[i13] = (char) (((int) (round % 10)) + 48);
            i11++;
            if (i11 == length) {
                i13 = i14 - 1;
                cArr[i14] = ',';
                i11++;
                z13 = true;
            } else {
                if (z10 && round != 0 && i11 > length) {
                    if (z14) {
                        if ((i11 - length) % 4 == 0) {
                            i13 = i14 - 1;
                            cArr[i14] = c10;
                        }
                    } else if ((i11 - length) % 4 == 3) {
                        i13 = i14 - 1;
                        cArr[i14] = c10;
                    }
                    i11++;
                    z13 = z14;
                }
                i13 = i14;
                z13 = z14;
            }
        }
        if (z12) {
            cArr[i13] = '0';
            i11++;
            i13--;
        }
        if (z11) {
            cArr[i13] = SignatureVisitor.SUPER;
            i11++;
        }
        int i15 = 35 - i11;
        return String.valueOf(cArr, i15, 35 - i15);
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(float f10, float f11, float f12) {
        return getSizeOfRotatedRectangleByRadians(f10, f11, f12 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(float f10, float f11, float f12) {
        double d10 = (double) f12;
        return new FSize(Math.abs(((float) Math.cos(d10)) * f10) + Math.abs(((float) Math.sin(d10)) * f11), Math.abs(f10 * ((float) Math.sin(d10))) + Math.abs(f11 * ((float) Math.cos(d10))));
    }

    @Deprecated
    public static void init(Resources resources) {
        mMetrics = resources.getDisplayMetrics();
        mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
        mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static void drawMultilineText(Canvas canvas, String str, float f10, float f11, TextPaint textPaint, FSize fSize, PointF pointF, float f12) {
        TextPaint textPaint2 = textPaint;
        drawMultilineText(canvas, new StaticLayout(str, 0, str.length(), textPaint2, (int) Math.max(Math.ceil((double) fSize.width), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false), f10, f11, textPaint2, pointF, f12);
    }
}
