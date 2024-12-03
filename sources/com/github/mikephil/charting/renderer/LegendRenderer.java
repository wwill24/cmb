package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class LegendRenderer extends Renderer {
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;

    /* renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition;

        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0085 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0091 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x009d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b5 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendForm[] r0 = com.github.mikephil.charting.components.Legend.LegendForm.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm = r0
                r1 = 1
                com.github.mikephil.charting.components.Legend$LegendForm r2 = com.github.mikephil.charting.components.Legend.LegendForm.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendForm r3 = com.github.mikephil.charting.components.Legend.LegendForm.SQUARE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.LINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.github.mikephil.charting.components.Legend$LegendPosition[] r3 = com.github.mikephil.charting.components.Legend.LegendPosition.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition = r3
                com.github.mikephil.charting.components.Legend$LegendPosition r4 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_LEFT     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.github.mikephil.charting.components.Legend$LegendPosition r3 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_RIGHT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x004d }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_LEFT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_RIGHT     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x006e }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.PIECHART_CENTER     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x0085 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x0091 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x009d }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_INSIDE     // Catch:{ NoSuchFieldError -> 0x009d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009d }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009d }
            L_0x009d:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x00a9 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART     // Catch:{ NoSuchFieldError -> 0x00a9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a9 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a9 }
            L_0x00a9:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x00b5 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x00b5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b5 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b5 }
            L_0x00b5:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition     // Catch:{ NoSuchFieldError -> 0x00c1 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_INSIDE     // Catch:{ NoSuchFieldError -> 0x00c1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c1 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c1 }
            L_0x00c1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.mLegend = legend;
        Paint paint = new Paint(1);
        this.mLegendLabelPaint = paint;
        paint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.mLegendFormPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mLegendFormPaint.setStrokeWidth(3.0f);
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [com.github.mikephil.charting.data.ChartData, com.github.mikephil.charting.data.ChartData<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeLegend(com.github.mikephil.charting.data.ChartData<?> r12) {
        /*
            r11 = this;
            com.github.mikephil.charting.components.Legend r0 = r11.mLegend
            boolean r0 = r0.isLegendCustom()
            if (r0 != 0) goto L_0x0146
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = r2
        L_0x0014:
            int r4 = r12.getDataSetCount()
            if (r3 >= r4) goto L_0x010e
            com.github.mikephil.charting.interfaces.datasets.IDataSet r4 = r12.getDataSetByIndex(r3)
            java.util.List r5 = r4.getColors()
            int r6 = r4.getEntryCount()
            boolean r7 = r4 instanceof com.github.mikephil.charting.interfaces.datasets.IBarDataSet
            r8 = -2
            if (r7 == 0) goto L_0x006d
            r7 = r4
            com.github.mikephil.charting.interfaces.datasets.IBarDataSet r7 = (com.github.mikephil.charting.interfaces.datasets.IBarDataSet) r7
            boolean r9 = r7.isStacked()
            if (r9 == 0) goto L_0x006d
            java.lang.String[] r4 = r7.getStackLabels()
            r6 = r2
        L_0x0039:
            int r9 = r5.size()
            if (r6 >= r9) goto L_0x0057
            int r9 = r7.getStackSize()
            if (r6 >= r9) goto L_0x0057
            int r9 = r4.length
            int r9 = r6 % r9
            r9 = r4[r9]
            r0.add(r9)
            java.lang.Object r9 = r5.get(r6)
            r1.add(r9)
            int r6 = r6 + 1
            goto L_0x0039
        L_0x0057:
            java.lang.String r4 = r7.getLabel()
            if (r4 == 0) goto L_0x010a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r1.add(r4)
            java.lang.String r4 = r7.getLabel()
            r0.add(r4)
            goto L_0x010a
        L_0x006d:
            boolean r7 = r4 instanceof com.github.mikephil.charting.interfaces.datasets.IPieDataSet
            if (r7 == 0) goto L_0x00ac
            java.util.List r7 = r12.getXVals()
            com.github.mikephil.charting.interfaces.datasets.IPieDataSet r4 = (com.github.mikephil.charting.interfaces.datasets.IPieDataSet) r4
            r9 = r2
        L_0x0078:
            int r10 = r5.size()
            if (r9 >= r10) goto L_0x0097
            if (r9 >= r6) goto L_0x0097
            int r10 = r7.size()
            if (r9 >= r10) goto L_0x0097
            java.lang.Object r10 = r7.get(r9)
            r0.add(r10)
            java.lang.Object r10 = r5.get(r9)
            r1.add(r10)
            int r9 = r9 + 1
            goto L_0x0078
        L_0x0097:
            java.lang.String r5 = r4.getLabel()
            if (r5 == 0) goto L_0x010a
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r1.add(r5)
            java.lang.String r4 = r4.getLabel()
            r0.add(r4)
            goto L_0x010a
        L_0x00ac:
            boolean r7 = r4 instanceof com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
            r8 = 0
            if (r7 == 0) goto L_0x00dc
            r7 = r4
            com.github.mikephil.charting.interfaces.datasets.ICandleDataSet r7 = (com.github.mikephil.charting.interfaces.datasets.ICandleDataSet) r7
            int r9 = r7.getDecreasingColor()
            r10 = -1
            if (r9 == r10) goto L_0x00dc
            int r5 = r7.getDecreasingColor()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.add(r5)
            int r5 = r7.getIncreasingColor()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.add(r5)
            r0.add(r8)
            java.lang.String r4 = r4.getLabel()
            r0.add(r4)
            goto L_0x010a
        L_0x00dc:
            r4 = r2
        L_0x00dd:
            int r7 = r5.size()
            if (r4 >= r7) goto L_0x010a
            if (r4 >= r6) goto L_0x010a
            int r7 = r5.size()
            int r7 = r7 + -1
            if (r4 >= r7) goto L_0x00f5
            int r7 = r6 + -1
            if (r4 >= r7) goto L_0x00f5
            r0.add(r8)
            goto L_0x0100
        L_0x00f5:
            com.github.mikephil.charting.interfaces.datasets.IDataSet r7 = r12.getDataSetByIndex(r3)
            java.lang.String r7 = r7.getLabel()
            r0.add(r7)
        L_0x0100:
            java.lang.Object r7 = r5.get(r4)
            r1.add(r7)
            int r4 = r4 + 1
            goto L_0x00dd
        L_0x010a:
            int r3 = r3 + 1
            goto L_0x0014
        L_0x010e:
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            int[] r12 = r12.getExtraColors()
            if (r12 == 0) goto L_0x013c
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            java.lang.String[] r12 = r12.getExtraLabels()
            if (r12 == 0) goto L_0x013c
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            int[] r12 = r12.getExtraColors()
            int r3 = r12.length
        L_0x0125:
            if (r2 >= r3) goto L_0x0133
            r4 = r12[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
            int r2 = r2 + 1
            goto L_0x0125
        L_0x0133:
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            java.lang.String[] r12 = r12.getExtraLabels()
            java.util.Collections.addAll(r0, r12)
        L_0x013c:
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            r12.setComputedColors(r1)
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            r12.setComputedLabels(r0)
        L_0x0146:
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            android.graphics.Typeface r12 = r12.getTypeface()
            if (r12 == 0) goto L_0x0153
            android.graphics.Paint r0 = r11.mLegendLabelPaint
            r0.setTypeface(r12)
        L_0x0153:
            android.graphics.Paint r12 = r11.mLegendLabelPaint
            com.github.mikephil.charting.components.Legend r0 = r11.mLegend
            float r0 = r0.getTextSize()
            r12.setTextSize(r0)
            android.graphics.Paint r12 = r11.mLegendLabelPaint
            com.github.mikephil.charting.components.Legend r0 = r11.mLegend
            int r0 = r0.getTextColor()
            r12.setColor(r0)
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            android.graphics.Paint r0 = r11.mLegendLabelPaint
            com.github.mikephil.charting.utils.ViewPortHandler r1 = r11.mViewPortHandler
            r12.calculateDimensions(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.computeLegend(com.github.mikephil.charting.data.ChartData):void");
    }

    /* access modifiers changed from: protected */
    public void drawForm(Canvas canvas, float f10, float f11, int i10, Legend legend) {
        if (legend.getColors()[i10] != -2) {
            this.mLegendFormPaint.setColor(legend.getColors()[i10]);
            float formSize = legend.getFormSize();
            float f12 = formSize / 2.0f;
            int i11 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[legend.getForm().ordinal()];
            if (i11 == 1) {
                canvas.drawCircle(f10 + f12, f11, f12, this.mLegendFormPaint);
            } else if (i11 == 2) {
                canvas.drawRect(f10, f11 - f12, f10 + formSize, f11 + f12, this.mLegendFormPaint);
            } else if (i11 == 3) {
                canvas.drawLine(f10, f11, f10 + formSize, f11, this.mLegendFormPaint);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawLabel(Canvas canvas, float f10, float f11, String str) {
        canvas.drawText(str, f10, f11, this.mLegendLabelPaint);
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0261  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void renderLegend(android.graphics.Canvas r37) {
        /*
            r36 = this;
            r6 = r36
            r7 = r37
            com.github.mikephil.charting.components.Legend r0 = r6.mLegend
            boolean r0 = r0.isEnabled()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            com.github.mikephil.charting.components.Legend r0 = r6.mLegend
            android.graphics.Typeface r0 = r0.getTypeface()
            if (r0 == 0) goto L_0x001a
            android.graphics.Paint r1 = r6.mLegendLabelPaint
            r1.setTypeface(r0)
        L_0x001a:
            android.graphics.Paint r0 = r6.mLegendLabelPaint
            com.github.mikephil.charting.components.Legend r1 = r6.mLegend
            float r1 = r1.getTextSize()
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.mLegendLabelPaint
            com.github.mikephil.charting.components.Legend r1 = r6.mLegend
            int r1 = r1.getTextColor()
            r0.setColor(r1)
            android.graphics.Paint r0 = r6.mLegendLabelPaint
            float r8 = com.github.mikephil.charting.utils.Utils.getLineHeight(r0)
            android.graphics.Paint r0 = r6.mLegendLabelPaint
            float r0 = com.github.mikephil.charting.utils.Utils.getLineSpacing(r0)
            com.github.mikephil.charting.components.Legend r1 = r6.mLegend
            float r1 = r1.getYEntrySpace()
            float r9 = r0 + r1
            android.graphics.Paint r0 = r6.mLegendLabelPaint
            java.lang.String r1 = "ABC"
            int r0 = com.github.mikephil.charting.utils.Utils.calcTextHeight(r0, r1)
            float r0 = (float) r0
            r10 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r10
            float r11 = r8 - r0
            com.github.mikephil.charting.components.Legend r0 = r6.mLegend
            java.lang.String[] r12 = r0.getLabels()
            com.github.mikephil.charting.components.Legend r0 = r6.mLegend
            int[] r13 = r0.getColors()
            com.github.mikephil.charting.components.Legend r0 = r6.mLegend
            float r14 = r0.getFormToTextSpace()
            com.github.mikephil.charting.components.Legend r0 = r6.mLegend
            float r15 = r0.getXEntrySpace()
            com.github.mikephil.charting.components.Legend r0 = r6.mLegend
            com.github.mikephil.charting.components.Legend$LegendDirection r5 = r0.getDirection()
            com.github.mikephil.charting.components.Legend r0 = r6.mLegend
            float r16 = r0.getFormSize()
            com.github.mikephil.charting.components.Legend r0 = r6.mLegend
            float r4 = r0.getStackSpace()
            com.github.mikephil.charting.components.Legend r0 = r6.mLegend
            float r0 = r0.getYOffset()
            com.github.mikephil.charting.components.Legend r1 = r6.mLegend
            float r1 = r1.getXOffset()
            com.github.mikephil.charting.components.Legend r2 = r6.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r3 = r2.getPosition()
            int[] r2 = com.github.mikephil.charting.renderer.LegendRenderer.AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition
            int r17 = r3.ordinal()
            r2 = r2[r17]
            r10 = -2
            r18 = 0
            r19 = 1
            r20 = 0
            switch(r2) {
                case 1: goto L_0x01e2;
                case 2: goto L_0x01e2;
                case 3: goto L_0x01e2;
                case 4: goto L_0x01e2;
                case 5: goto L_0x01e2;
                case 6: goto L_0x01e2;
                case 7: goto L_0x00a2;
                case 8: goto L_0x00a2;
                case 9: goto L_0x00a2;
                case 10: goto L_0x00a2;
                case 11: goto L_0x00a2;
                case 12: goto L_0x00a2;
                case 13: goto L_0x00a2;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            goto L_0x0334
        L_0x00a2:
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.PIECHART_CENTER
            if (r3 != r2) goto L_0x00d3
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r6.mViewPortHandler
            float r0 = r0.getChartWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            com.github.mikephil.charting.components.Legend$LegendDirection r2 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r5 != r2) goto L_0x00b9
            com.github.mikephil.charting.components.Legend r2 = r6.mLegend
            float r2 = r2.mTextWidthMax
            float r2 = -r2
            goto L_0x00bd
        L_0x00b9:
            com.github.mikephil.charting.components.Legend r2 = r6.mLegend
            float r2 = r2.mTextWidthMax
        L_0x00bd:
            float r2 = r2 / r1
            float r0 = r0 + r2
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r6.mViewPortHandler
            float r2 = r2.getChartHeight()
            float r2 = r2 / r1
            com.github.mikephil.charting.components.Legend r3 = r6.mLegend
            float r15 = r3.mNeededHeight
            float r15 = r15 / r1
            float r2 = r2 - r15
            float r1 = r3.getYOffset()
            float r2 = r2 + r1
            r15 = r0
            goto L_0x0132
        L_0x00d3:
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART
            if (r3 == r2) goto L_0x00e3
            com.github.mikephil.charting.components.Legend$LegendPosition r15 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_CENTER
            if (r3 == r15) goto L_0x00e3
            com.github.mikephil.charting.components.Legend$LegendPosition r15 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_INSIDE
            if (r3 != r15) goto L_0x00e0
            goto L_0x00e3
        L_0x00e0:
            r15 = r20
            goto L_0x00e5
        L_0x00e3:
            r15 = r19
        L_0x00e5:
            if (r15 == 0) goto L_0x00f9
            com.github.mikephil.charting.utils.ViewPortHandler r15 = r6.mViewPortHandler
            float r15 = r15.getChartWidth()
            float r1 = r15 - r1
            com.github.mikephil.charting.components.Legend$LegendDirection r15 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r5 != r15) goto L_0x0102
            com.github.mikephil.charting.components.Legend r15 = r6.mLegend
            float r15 = r15.mTextWidthMax
            float r1 = r1 - r15
            goto L_0x0102
        L_0x00f9:
            com.github.mikephil.charting.components.Legend$LegendDirection r15 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r5 != r15) goto L_0x0102
            com.github.mikephil.charting.components.Legend r15 = r6.mLegend
            float r15 = r15.mTextWidthMax
            float r1 = r1 + r15
        L_0x0102:
            if (r3 == r2) goto L_0x012a
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART
            if (r3 != r2) goto L_0x0109
            goto L_0x012a
        L_0x0109:
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_CENTER
            if (r3 == r2) goto L_0x0119
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_CENTER
            if (r3 != r2) goto L_0x0112
            goto L_0x0119
        L_0x0112:
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r6.mViewPortHandler
            float r2 = r2.contentTop()
            goto L_0x0130
        L_0x0119:
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r6.mViewPortHandler
            float r0 = r0.getChartHeight()
            r2 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r2
            com.github.mikephil.charting.components.Legend r3 = r6.mLegend
            float r3 = r3.mNeededHeight
            float r3 = r3 / r2
            float r2 = r0 - r3
            goto L_0x0131
        L_0x012a:
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r6.mViewPortHandler
            float r2 = r2.contentTop()
        L_0x0130:
            float r2 = r2 + r0
        L_0x0131:
            r15 = r1
        L_0x0132:
            r17 = r2
            r21 = r18
            r3 = r20
            r22 = r3
        L_0x013a:
            int r0 = r12.length
            if (r3 >= r0) goto L_0x0334
            r0 = r13[r3]
            if (r0 == r10) goto L_0x0144
            r0 = r19
            goto L_0x0146
        L_0x0144:
            r0 = r20
        L_0x0146:
            java.lang.Boolean r23 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r23.booleanValue()
            if (r0 == 0) goto L_0x0180
            com.github.mikephil.charting.components.Legend$LegendDirection r2 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r5 != r2) goto L_0x0157
            float r0 = r15 + r21
            goto L_0x015b
        L_0x0157:
            float r0 = r16 - r21
            float r0 = r15 - r0
        L_0x015b:
            r24 = r0
            float r25 = r17 + r11
            com.github.mikephil.charting.components.Legend r1 = r6.mLegend
            r0 = r36
            r26 = r1
            r1 = r37
            r10 = r2
            r2 = r24
            r28 = r3
            r3 = r25
            r25 = r15
            r15 = r4
            r4 = r28
            r29 = r11
            r11 = r5
            r5 = r26
            r0.drawForm(r1, r2, r3, r4, r5)
            if (r11 != r10) goto L_0x018a
            float r24 = r24 + r16
            goto L_0x018a
        L_0x0180:
            r28 = r3
            r29 = r11
            r25 = r15
            r15 = r4
            r11 = r5
            r24 = r25
        L_0x018a:
            r0 = r12[r28]
            if (r0 == 0) goto L_0x01d1
            boolean r0 = r23.booleanValue()
            if (r0 == 0) goto L_0x01a0
            if (r22 != 0) goto L_0x01a0
            com.github.mikephil.charting.components.Legend$LegendDirection r0 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r11 != r0) goto L_0x019c
            r0 = r14
            goto L_0x019d
        L_0x019c:
            float r0 = -r14
        L_0x019d:
            float r24 = r24 + r0
            goto L_0x01a4
        L_0x01a0:
            if (r22 == 0) goto L_0x01a4
            r24 = r25
        L_0x01a4:
            com.github.mikephil.charting.components.Legend$LegendDirection r0 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r0) goto L_0x01b3
            android.graphics.Paint r0 = r6.mLegendLabelPaint
            r1 = r12[r28]
            int r0 = com.github.mikephil.charting.utils.Utils.calcTextWidth(r0, r1)
            float r0 = (float) r0
            float r24 = r24 - r0
        L_0x01b3:
            r0 = r24
            if (r22 != 0) goto L_0x01bf
            float r1 = r17 + r8
            r2 = r12[r28]
            r6.drawLabel(r7, r0, r1, r2)
            goto L_0x01ca
        L_0x01bf:
            float r1 = r8 + r9
            float r17 = r17 + r1
            float r1 = r17 + r8
            r2 = r12[r28]
            r6.drawLabel(r7, r0, r1, r2)
        L_0x01ca:
            float r0 = r8 + r9
            float r17 = r17 + r0
            r21 = r18
            goto L_0x01d7
        L_0x01d1:
            float r4 = r16 + r15
            float r21 = r21 + r4
            r22 = r19
        L_0x01d7:
            int r3 = r28 + 1
            r5 = r11
            r4 = r15
            r15 = r25
            r11 = r29
            r10 = -2
            goto L_0x013a
        L_0x01e2:
            r29 = r11
            r10 = r15
            r15 = r4
            r11 = r5
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r6.mViewPortHandler
            float r2 = r2.contentWidth()
            com.github.mikephil.charting.components.Legend$LegendPosition r4 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_LEFT
            if (r3 == r4) goto L_0x021b
            com.github.mikephil.charting.components.Legend$LegendPosition r4 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_LEFT
            if (r3 != r4) goto L_0x01f6
            goto L_0x021b
        L_0x01f6:
            com.github.mikephil.charting.components.Legend$LegendPosition r4 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_RIGHT
            if (r3 == r4) goto L_0x0209
            com.github.mikephil.charting.components.Legend$LegendPosition r4 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_RIGHT
            if (r3 != r4) goto L_0x01ff
            goto L_0x0209
        L_0x01ff:
            com.github.mikephil.charting.utils.ViewPortHandler r1 = r6.mViewPortHandler
            float r1 = r1.contentLeft()
            r4 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r4
            goto L_0x022a
        L_0x0209:
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r6.mViewPortHandler
            float r2 = r2.contentRight()
            float r1 = r2 - r1
            com.github.mikephil.charting.components.Legend$LegendDirection r2 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r11 != r2) goto L_0x022b
            com.github.mikephil.charting.components.Legend r2 = r6.mLegend
            float r2 = r2.mNeededWidth
            float r1 = r1 - r2
            goto L_0x022b
        L_0x021b:
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r6.mViewPortHandler
            float r2 = r2.contentLeft()
            float r1 = r1 + r2
            com.github.mikephil.charting.components.Legend$LegendDirection r2 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r2) goto L_0x022b
            com.github.mikephil.charting.components.Legend r2 = r6.mLegend
            float r2 = r2.mNeededWidth
        L_0x022a:
            float r1 = r1 + r2
        L_0x022b:
            r21 = r1
            com.github.mikephil.charting.components.Legend r1 = r6.mLegend
            com.github.mikephil.charting.utils.FSize[] r5 = r1.getCalculatedLineSizes()
            com.github.mikephil.charting.components.Legend r1 = r6.mLegend
            com.github.mikephil.charting.utils.FSize[] r22 = r1.getCalculatedLabelSizes()
            com.github.mikephil.charting.components.Legend r1 = r6.mLegend
            java.lang.Boolean[] r4 = r1.getCalculatedLabelBreakPoints()
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_LEFT
            if (r3 == r1) goto L_0x0259
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_RIGHT
            if (r3 == r1) goto L_0x0259
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_CENTER
            if (r3 != r1) goto L_0x024c
            goto L_0x0259
        L_0x024c:
            com.github.mikephil.charting.utils.ViewPortHandler r1 = r6.mViewPortHandler
            float r1 = r1.getChartHeight()
            float r1 = r1 - r0
            com.github.mikephil.charting.components.Legend r0 = r6.mLegend
            float r0 = r0.mNeededHeight
            float r18 = r1 - r0
        L_0x0259:
            int r2 = r12.length
            r0 = r20
            r1 = r0
            r23 = r21
        L_0x025f:
            if (r1 >= r2) goto L_0x0334
            r24 = r2
            int r2 = r4.length
            if (r1 >= r2) goto L_0x0274
            r2 = r4[r1]
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0274
            float r2 = r8 + r9
            float r18 = r18 + r2
            r23 = r21
        L_0x0274:
            int r2 = (r23 > r21 ? 1 : (r23 == r21 ? 0 : -1))
            if (r2 != 0) goto L_0x0296
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_CENTER
            if (r3 != r2) goto L_0x0296
            int r2 = r5.length
            if (r0 >= r2) goto L_0x0296
            com.github.mikephil.charting.components.Legend$LegendDirection r2 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r2) goto L_0x0288
            r2 = r5[r0]
            float r2 = r2.width
            goto L_0x028d
        L_0x0288:
            r2 = r5[r0]
            float r2 = r2.width
            float r2 = -r2
        L_0x028d:
            r17 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r17
            float r23 = r23 + r2
            int r0 = r0 + 1
            goto L_0x0298
        L_0x0296:
            r17 = 1073741824(0x40000000, float:2.0)
        L_0x0298:
            r35 = r23
            r23 = r0
            r0 = r35
            r2 = r13[r1]
            r25 = r9
            r9 = -2
            if (r2 == r9) goto L_0x02a8
            r26 = r19
            goto L_0x02aa
        L_0x02a8:
            r26 = r20
        L_0x02aa:
            r2 = r12[r1]
            if (r2 != 0) goto L_0x02b1
            r27 = r19
            goto L_0x02b3
        L_0x02b1:
            r27 = r20
        L_0x02b3:
            if (r26 == 0) goto L_0x02e4
            com.github.mikephil.charting.components.Legend$LegendDirection r2 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r2) goto L_0x02bb
            float r0 = r0 - r16
        L_0x02bb:
            r28 = r0
            float r30 = r18 + r29
            com.github.mikephil.charting.components.Legend r2 = r6.mLegend
            r0 = r36
            r31 = r1
            r1 = r37
            r32 = r2
            r2 = r28
            r33 = r3
            r3 = r30
            r30 = r4
            r4 = r31
            r34 = r5
            r5 = r32
            r0.drawForm(r1, r2, r3, r4, r5)
            com.github.mikephil.charting.components.Legend$LegendDirection r0 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r11 != r0) goto L_0x02e1
            float r0 = r28 + r16
            goto L_0x02ec
        L_0x02e1:
            r0 = r28
            goto L_0x02ec
        L_0x02e4:
            r31 = r1
            r33 = r3
            r30 = r4
            r34 = r5
        L_0x02ec:
            if (r27 != 0) goto L_0x0318
            if (r26 == 0) goto L_0x02f8
            com.github.mikephil.charting.components.Legend$LegendDirection r1 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r1) goto L_0x02f6
            float r1 = -r14
            goto L_0x02f7
        L_0x02f6:
            r1 = r14
        L_0x02f7:
            float r0 = r0 + r1
        L_0x02f8:
            com.github.mikephil.charting.components.Legend$LegendDirection r1 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r1) goto L_0x0301
            r2 = r22[r31]
            float r2 = r2.width
            float r0 = r0 - r2
        L_0x0301:
            float r2 = r18 + r8
            r3 = r12[r31]
            r6.drawLabel(r7, r0, r2, r3)
            com.github.mikephil.charting.components.Legend$LegendDirection r2 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r11 != r2) goto L_0x0311
            r2 = r22[r31]
            float r2 = r2.width
            float r0 = r0 + r2
        L_0x0311:
            if (r11 != r1) goto L_0x0315
            float r1 = -r10
            goto L_0x0316
        L_0x0315:
            r1 = r10
        L_0x0316:
            float r0 = r0 + r1
            goto L_0x0320
        L_0x0318:
            com.github.mikephil.charting.components.Legend$LegendDirection r1 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r1) goto L_0x031e
            float r4 = -r15
            goto L_0x031f
        L_0x031e:
            r4 = r15
        L_0x031f:
            float r0 = r0 + r4
        L_0x0320:
            int r1 = r31 + 1
            r2 = r24
            r9 = r25
            r4 = r30
            r3 = r33
            r5 = r34
            r35 = r23
            r23 = r0
            r0 = r35
            goto L_0x025f
        L_0x0334:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.renderLegend(android.graphics.Canvas):void");
    }
}
