package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.animation.EasingFunction;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

@SuppressLint({"NewApi"})
public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>> extends ViewGroup implements ChartInterface {
    public static final String LOG_TAG = "MPAndroidChart";
    public static final int PAINT_CENTER_TEXT = 14;
    public static final int PAINT_DESCRIPTION = 11;
    public static final int PAINT_GRID_BACKGROUND = 4;
    public static final int PAINT_HOLE = 13;
    public static final int PAINT_INFO = 7;
    public static final int PAINT_LEGEND_LABEL = 18;
    protected ChartAnimator mAnimator;
    protected ChartTouchListener mChartTouchListener;
    protected T mData = null;
    protected ValueFormatter mDefaultFormatter;
    protected float mDeltaX = 1.0f;
    protected Paint mDescPaint;
    protected String mDescription = "Description";
    private PointF mDescriptionPosition;
    private boolean mDragDecelerationEnabled = true;
    private float mDragDecelerationFrictionCoef = 0.9f;
    protected boolean mDrawMarkerViews = true;
    protected Paint mDrawPaint;
    private float mExtraBottomOffset = 0.0f;
    private float mExtraLeftOffset = 0.0f;
    private float mExtraRightOffset = 0.0f;
    private float mExtraTopOffset = 0.0f;
    private OnChartGestureListener mGestureListener;
    protected boolean mHighLightPerTapEnabled = true;
    protected ChartHighlighter mHighlighter;
    protected Highlight[] mIndicesToHighlight;
    protected Paint mInfoPaint;
    protected ArrayList<Runnable> mJobs = new ArrayList<>();
    protected Legend mLegend;
    protected LegendRenderer mLegendRenderer;
    protected boolean mLogEnabled = false;
    protected MarkerView mMarkerView;
    private String mNoDataText = "No chart data available.";
    private String mNoDataTextDescription;
    private boolean mOffsetsCalculated = false;
    protected DataRenderer mRenderer;
    protected OnChartValueSelectedListener mSelectionListener;
    protected boolean mTouchEnabled = true;
    private boolean mUnbind = false;
    protected ViewPortHandler mViewPortHandler;
    protected float mXChartMax = 0.0f;
    protected float mXChartMin = 0.0f;

    /* renamed from: com.github.mikephil.charting.charts.Chart$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$CompressFormat;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.graphics.Bitmap$CompressFormat[] r0 = android.graphics.Bitmap.CompressFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$graphics$Bitmap$CompressFormat = r0
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$graphics$Bitmap$CompressFormat     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.WEBP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$graphics$Bitmap$CompressFormat     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.Chart.AnonymousClass2.<clinit>():void");
        }
    }

    public Chart(Context context) {
        super(context);
        init();
    }

    private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback((Drawable.Callback) null);
        }
        if (view instanceof ViewGroup) {
            int i10 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i10 < viewGroup.getChildCount()) {
                    unbindDrawables(viewGroup.getChildAt(i10));
                    i10++;
                } else {
                    viewGroup.removeAllViews();
                    return;
                }
            }
        }
    }

    public void addViewportJob(Runnable runnable) {
        if (this.mViewPortHandler.hasChartDimens()) {
            post(runnable);
        } else {
            this.mJobs.add(runnable);
        }
    }

    public void animateX(int i10, EasingFunction easingFunction) {
        this.mAnimator.animateX(i10, easingFunction);
    }

    public void animateXY(int i10, int i11, EasingFunction easingFunction, EasingFunction easingFunction2) {
        this.mAnimator.animateXY(i10, i11, easingFunction, easingFunction2);
    }

    public void animateY(int i10, EasingFunction easingFunction) {
        this.mAnimator.animateY(i10, easingFunction);
    }

    /* access modifiers changed from: protected */
    public abstract void calcMinMax();

    /* access modifiers changed from: protected */
    public void calculateFormatter(float f10, float f11) {
        float f12;
        T t10 = this.mData;
        if (t10 == null || t10.getXValCount() < 2) {
            f12 = Math.max(Math.abs(f10), Math.abs(f11));
        } else {
            f12 = Math.abs(f11 - f10);
        }
        this.mDefaultFormatter = new DefaultValueFormatter(Utils.getDecimals(f12));
    }

    /* access modifiers changed from: protected */
    public abstract void calculateOffsets();

    public void clear() {
        this.mData = null;
        this.mIndicesToHighlight = null;
        invalidate();
    }

    public void clearAllViewportJobs() {
        this.mJobs.clear();
    }

    public void clearValues() {
        this.mData.clearValues();
        invalidate();
    }

    public void disableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* access modifiers changed from: protected */
    public void drawDescription(Canvas canvas) {
        if (!this.mDescription.equals("")) {
            PointF pointF = this.mDescriptionPosition;
            if (pointF == null) {
                canvas.drawText(this.mDescription, (((float) getWidth()) - this.mViewPortHandler.offsetRight()) - 10.0f, (((float) getHeight()) - this.mViewPortHandler.offsetBottom()) - 10.0f, this.mDescPaint);
            } else {
                canvas.drawText(this.mDescription, pointF.x, pointF.y, this.mDescPaint);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawMarkers(Canvas canvas) {
        Entry entryForHighlight;
        if (this.mMarkerView != null && this.mDrawMarkerViews && valuesToHighlight()) {
            int i10 = 0;
            while (true) {
                Highlight[] highlightArr = this.mIndicesToHighlight;
                if (i10 < highlightArr.length) {
                    Highlight highlight = highlightArr[i10];
                    int xIndex = highlight.getXIndex();
                    highlight.getDataSetIndex();
                    float f10 = (float) xIndex;
                    float f11 = this.mDeltaX;
                    if (f10 <= f11 && f10 <= f11 * this.mAnimator.getPhaseX() && (entryForHighlight = this.mData.getEntryForHighlight(this.mIndicesToHighlight[i10])) != null && entryForHighlight.getXIndex() == this.mIndicesToHighlight[i10].getXIndex()) {
                        float[] markerPosition = getMarkerPosition(entryForHighlight, highlight);
                        if (this.mViewPortHandler.isInBounds(markerPosition[0], markerPosition[1])) {
                            this.mMarkerView.refreshContent(entryForHighlight, highlight);
                            this.mMarkerView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                            MarkerView markerView = this.mMarkerView;
                            markerView.layout(0, 0, markerView.getMeasuredWidth(), this.mMarkerView.getMeasuredHeight());
                            if (markerPosition[1] - ((float) this.mMarkerView.getHeight()) <= 0.0f) {
                                float f12 = markerPosition[1];
                                this.mMarkerView.draw(canvas, markerPosition[0], f12 + (((float) this.mMarkerView.getHeight()) - f12));
                            } else {
                                this.mMarkerView.draw(canvas, markerPosition[0], markerPosition[1]);
                            }
                        }
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public void enableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public ChartAnimator getAnimator() {
        return this.mAnimator;
    }

    public PointF getCenter() {
        return new PointF(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    public PointF getCenterOfView() {
        return getCenter();
    }

    public PointF getCenterOffsets() {
        return this.mViewPortHandler.getContentCenter();
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public RectF getContentRect() {
        return this.mViewPortHandler.getContentRect();
    }

    public T getData() {
        return this.mData;
    }

    public ValueFormatter getDefaultValueFormatter() {
        return this.mDefaultFormatter;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.mDragDecelerationFrictionCoef;
    }

    public List<Entry> getEntriesAtIndex(int i10) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < this.mData.getDataSetCount(); i11++) {
            Entry entryForXIndex = this.mData.getDataSetByIndex(i11).getEntryForXIndex(i10);
            if (entryForXIndex != null) {
                arrayList.add(entryForXIndex);
            }
        }
        return arrayList;
    }

    public float getExtraBottomOffset() {
        return this.mExtraBottomOffset;
    }

    public float getExtraLeftOffset() {
        return this.mExtraLeftOffset;
    }

    public float getExtraRightOffset() {
        return this.mExtraRightOffset;
    }

    public float getExtraTopOffset() {
        return this.mExtraTopOffset;
    }

    public Highlight[] getHighlighted() {
        return this.mIndicesToHighlight;
    }

    public ChartHighlighter getHighlighter() {
        return this.mHighlighter;
    }

    public ArrayList<Runnable> getJobs() {
        return this.mJobs;
    }

    public Legend getLegend() {
        return this.mLegend;
    }

    public LegendRenderer getLegendRenderer() {
        return this.mLegendRenderer;
    }

    /* access modifiers changed from: protected */
    public abstract float[] getMarkerPosition(Entry entry, Highlight highlight);

    public MarkerView getMarkerView() {
        return this.mMarkerView;
    }

    public OnChartGestureListener getOnChartGestureListener() {
        return this.mGestureListener;
    }

    public Paint getPaint(int i10) {
        if (i10 == 7) {
            return this.mInfoPaint;
        }
        if (i10 != 11) {
            return null;
        }
        return this.mDescPaint;
    }

    public DataRenderer getRenderer() {
        return this.mRenderer;
    }

    public int getValueCount() {
        return this.mData.getYValCount();
    }

    public ViewPortHandler getViewPortHandler() {
        return this.mViewPortHandler;
    }

    public float getXChartMax() {
        return this.mXChartMax;
    }

    public float getXChartMin() {
        return this.mXChartMin;
    }

    public int getXValCount() {
        return this.mData.getXValCount();
    }

    public String getXValue(int i10) {
        T t10 = this.mData;
        if (t10 == null || t10.getXValCount() <= i10) {
            return null;
        }
        return this.mData.getXVals().get(i10);
    }

    public float getYMax() {
        return this.mData.getYMax();
    }

    public float getYMin() {
        return this.mData.getYMin();
    }

    @Deprecated
    public void highlightTouch(Highlight highlight) {
        highlightValue(highlight, true);
    }

    public void highlightValue(int i10, int i11) {
        if (i10 < 0 || i11 < 0 || i10 >= this.mData.getXValCount() || i11 >= this.mData.getDataSetCount()) {
            highlightValues((Highlight[]) null);
            return;
        }
        highlightValues(new Highlight[]{new Highlight(i10, i11)});
    }

    public void highlightValues(Highlight[] highlightArr) {
        Highlight highlight;
        this.mIndicesToHighlight = highlightArr;
        if (highlightArr == null || highlightArr.length <= 0 || (highlight = highlightArr[0]) == null) {
            this.mChartTouchListener.setLastHighlighted((Highlight) null);
        } else {
            this.mChartTouchListener.setLastHighlighted(highlight);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void init() {
        setWillNotDraw(false);
        this.mAnimator = new ChartAnimator(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Chart.this.postInvalidate();
            }
        });
        Utils.init(getContext());
        this.mDefaultFormatter = new DefaultValueFormatter(1);
        this.mViewPortHandler = new ViewPortHandler();
        Legend legend = new Legend();
        this.mLegend = legend;
        this.mLegendRenderer = new LegendRenderer(this.mViewPortHandler, legend);
        Paint paint = new Paint(1);
        this.mDescPaint = paint;
        paint.setColor(-16777216);
        this.mDescPaint.setTextAlign(Paint.Align.RIGHT);
        this.mDescPaint.setTextSize(Utils.convertDpToPixel(9.0f));
        Paint paint2 = new Paint(1);
        this.mInfoPaint = paint2;
        paint2.setColor(Color.rgb(247, Opcodes.ANEWARRAY, 51));
        this.mInfoPaint.setTextAlign(Paint.Align.CENTER);
        this.mInfoPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mDrawPaint = new Paint(4);
    }

    public boolean isDragDecelerationEnabled() {
        return this.mDragDecelerationEnabled;
    }

    public boolean isDrawMarkerViewEnabled() {
        return this.mDrawMarkerViews;
    }

    public boolean isEmpty() {
        T t10 = this.mData;
        if (t10 != null && t10.getYValCount() > 0) {
            return false;
        }
        return true;
    }

    public boolean isHighlightPerTapEnabled() {
        return this.mHighLightPerTapEnabled;
    }

    public boolean isLogEnabled() {
        return this.mLogEnabled;
    }

    public abstract void notifyDataSetChanged();

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mUnbind) {
            unbindDrawables(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f10;
        float f11;
        if (this.mData == null) {
            boolean z10 = !TextUtils.isEmpty(this.mNoDataText);
            boolean isEmpty = true ^ TextUtils.isEmpty(this.mNoDataTextDescription);
            float f12 = 0.0f;
            if (z10) {
                f10 = (float) Utils.calcTextHeight(this.mInfoPaint, this.mNoDataText);
            } else {
                f10 = 0.0f;
            }
            if (isEmpty) {
                f11 = (float) Utils.calcTextHeight(this.mInfoPaint, this.mNoDataTextDescription);
            } else {
                f11 = 0.0f;
            }
            if (z10 && isEmpty) {
                f12 = this.mInfoPaint.getFontSpacing() - f10;
            }
            float height = ((((float) getHeight()) - ((f10 + f12) + f11)) / 2.0f) + f10;
            if (z10) {
                canvas.drawText(this.mNoDataText, (float) (getWidth() / 2), height, this.mInfoPaint);
                if (isEmpty) {
                    height = height + f10 + f12;
                }
            }
            if (isEmpty) {
                canvas.drawText(this.mNoDataTextDescription, (float) (getWidth() / 2), height, this.mInfoPaint);
            }
        } else if (!this.mOffsetsCalculated) {
            calculateOffsets();
            this.mOffsetsCalculated = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            getChildAt(i14).layout(i10, i11, i12, i13);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int convertDpToPixel = (int) Utils.convertDpToPixel(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), View.resolveSize(convertDpToPixel, i10)), Math.max(getSuggestedMinimumHeight(), View.resolveSize(convertDpToPixel, i11)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        if (i10 > 0 && i11 > 0 && i10 < 10000 && i11 < 10000) {
            this.mViewPortHandler.setChartDimens((float) i10, (float) i11);
            if (this.mLogEnabled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting chart dimens, width: ");
                sb2.append(i10);
                sb2.append(", height: ");
                sb2.append(i11);
            }
            Iterator<Runnable> it = this.mJobs.iterator();
            while (it.hasNext()) {
                post(it.next());
            }
            this.mJobs.clear();
        }
        notifyDataSetChanged();
        super.onSizeChanged(i10, i11, i12, i13);
    }

    public void removeViewportJob(Runnable runnable) {
        this.mJobs.remove(runnable);
    }

    public boolean saveToGallery(String str, String str2, String str3, Bitmap.CompressFormat compressFormat, int i10) {
        if (i10 < 0 || i10 > 100) {
            i10 = 50;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory.getAbsolutePath() + "/DCIM/" + str2);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        int i11 = AnonymousClass2.$SwitchMap$android$graphics$Bitmap$CompressFormat[compressFormat.ordinal()];
        String str4 = "image/png";
        if (i11 != 1) {
            if (i11 != 2) {
                if (!str.endsWith(".jpg") && !str.endsWith(".jpeg")) {
                    str = str + ".jpg";
                }
                str4 = "image/jpeg";
            } else {
                if (!str.endsWith(".webp")) {
                    str = str + ".webp";
                }
                str4 = "image/webp";
            }
        } else if (!str.endsWith(".png")) {
            str = str + ".png";
        }
        String str5 = file.getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + str;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str5);
            getChartBitmap().compress(compressFormat, i10, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            long length = new File(str5).length();
            ContentValues contentValues = new ContentValues(8);
            contentValues.put("title", str);
            contentValues.put("_display_name", str);
            contentValues.put("date_added", Long.valueOf(currentTimeMillis));
            contentValues.put("mime_type", str4);
            contentValues.put("description", str3);
            contentValues.put("orientation", 0);
            contentValues.put("_data", str5);
            contentValues.put("_size", Long.valueOf(length));
            if (getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) != null) {
                return true;
            }
            return false;
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public boolean saveToPath(String str, String str2) {
        Bitmap chartBitmap = getChartBitmap();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + str2 + RemoteSettings.FORWARD_SLASH_STRING + str + ".png");
            chartBitmap.compress(Bitmap.CompressFormat.PNG, 40, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public void setData(T t10) {
        if (t10 != null) {
            this.mOffsetsCalculated = false;
            this.mData = t10;
            calculateFormatter(t10.getYMin(), t10.getYMax());
            for (IDataSet iDataSet : this.mData.getDataSets()) {
                if (Utils.needsDefaultFormatter(iDataSet.getValueFormatter())) {
                    iDataSet.setValueFormatter(this.mDefaultFormatter);
                }
            }
            notifyDataSetChanged();
        }
    }

    public void setDescription(String str) {
        if (str == null) {
            str = "";
        }
        this.mDescription = str;
    }

    public void setDescriptionColor(int i10) {
        this.mDescPaint.setColor(i10);
    }

    public void setDescriptionPosition(float f10, float f11) {
        this.mDescriptionPosition = new PointF(f10, f11);
    }

    public void setDescriptionTextSize(float f10) {
        if (f10 > 16.0f) {
            f10 = 16.0f;
        }
        if (f10 < 6.0f) {
            f10 = 6.0f;
        }
        this.mDescPaint.setTextSize(Utils.convertDpToPixel(f10));
    }

    public void setDescriptionTypeface(Typeface typeface) {
        this.mDescPaint.setTypeface(typeface);
    }

    public void setDragDecelerationEnabled(boolean z10) {
        this.mDragDecelerationEnabled = z10;
    }

    public void setDragDecelerationFrictionCoef(float f10) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 >= 1.0f) {
            f10 = 0.999f;
        }
        this.mDragDecelerationFrictionCoef = f10;
    }

    public void setDrawMarkerViews(boolean z10) {
        this.mDrawMarkerViews = z10;
    }

    public void setExtraBottomOffset(float f10) {
        this.mExtraBottomOffset = Utils.convertDpToPixel(f10);
    }

    public void setExtraLeftOffset(float f10) {
        this.mExtraLeftOffset = Utils.convertDpToPixel(f10);
    }

    public void setExtraOffsets(float f10, float f11, float f12, float f13) {
        setExtraLeftOffset(f10);
        setExtraTopOffset(f11);
        setExtraRightOffset(f12);
        setExtraBottomOffset(f13);
    }

    public void setExtraRightOffset(float f10) {
        this.mExtraRightOffset = Utils.convertDpToPixel(f10);
    }

    public void setExtraTopOffset(float f10) {
        this.mExtraTopOffset = Utils.convertDpToPixel(f10);
    }

    public void setHardwareAccelerationEnabled(boolean z10) {
        if (z10) {
            setLayerType(2, (Paint) null);
        } else {
            setLayerType(1, (Paint) null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z10) {
        this.mHighLightPerTapEnabled = z10;
    }

    public void setHighlighter(ChartHighlighter chartHighlighter) {
        this.mHighlighter = chartHighlighter;
    }

    public void setLogEnabled(boolean z10) {
        this.mLogEnabled = z10;
    }

    public void setMarkerView(MarkerView markerView) {
        this.mMarkerView = markerView;
    }

    public void setNoDataText(String str) {
        this.mNoDataText = str;
    }

    public void setNoDataTextDescription(String str) {
        this.mNoDataTextDescription = str;
    }

    public void setOnChartGestureListener(OnChartGestureListener onChartGestureListener) {
        this.mGestureListener = onChartGestureListener;
    }

    public void setOnChartValueSelectedListener(OnChartValueSelectedListener onChartValueSelectedListener) {
        this.mSelectionListener = onChartValueSelectedListener;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.mChartTouchListener = chartTouchListener;
    }

    public void setPaint(Paint paint, int i10) {
        if (i10 == 7) {
            this.mInfoPaint = paint;
        } else if (i10 == 11) {
            this.mDescPaint = paint;
        }
    }

    public void setRenderer(DataRenderer dataRenderer) {
        if (dataRenderer != null) {
            this.mRenderer = dataRenderer;
        }
    }

    public void setTouchEnabled(boolean z10) {
        this.mTouchEnabled = z10;
    }

    public void setUnbindEnabled(boolean z10) {
        this.mUnbind = z10;
    }

    public boolean valuesToHighlight() {
        Highlight[] highlightArr = this.mIndicesToHighlight;
        return (highlightArr == null || highlightArr.length <= 0 || highlightArr[0] == null) ? false : true;
    }

    public void animateX(int i10, Easing.EasingOption easingOption) {
        this.mAnimator.animateX(i10, easingOption);
    }

    public void animateXY(int i10, int i11, Easing.EasingOption easingOption, Easing.EasingOption easingOption2) {
        this.mAnimator.animateXY(i10, i11, easingOption, easingOption2);
    }

    public void animateY(int i10, Easing.EasingOption easingOption) {
        this.mAnimator.animateY(i10, easingOption);
    }

    public void animateX(int i10) {
        this.mAnimator.animateX(i10);
    }

    public void animateXY(int i10, int i11) {
        this.mAnimator.animateXY(i10, i11);
    }

    public void animateY(int i10) {
        this.mAnimator.animateY(i10);
    }

    public void highlightValue(Highlight highlight) {
        highlightValue(highlight, false);
    }

    public void highlightValue(Highlight highlight, boolean z10) {
        Entry entry = null;
        if (highlight == null) {
            this.mIndicesToHighlight = null;
        } else {
            if (this.mLogEnabled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Highlighted: ");
                sb2.append(highlight.toString());
            }
            Entry entryForHighlight = this.mData.getEntryForHighlight(highlight);
            if (entryForHighlight == null || entryForHighlight.getXIndex() != highlight.getXIndex()) {
                this.mIndicesToHighlight = null;
                highlight = null;
            } else {
                this.mIndicesToHighlight = new Highlight[]{highlight};
            }
            entry = entryForHighlight;
        }
        if (z10 && this.mSelectionListener != null) {
            if (!valuesToHighlight()) {
                this.mSelectionListener.onNothingSelected();
            } else {
                this.mSelectionListener.onValueSelected(entry, highlight.getDataSetIndex(), highlight);
            }
        }
        invalidate();
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public boolean saveToGallery(String str, int i10) {
        return saveToGallery(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.JPEG, i10);
    }

    public Chart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init();
    }
}
