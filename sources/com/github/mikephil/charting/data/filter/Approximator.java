package com.github.mikephil.charting.data.filter;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

public class Approximator {
    private boolean[] keep;
    private float mDeltaRatio;
    private float mScaleRatio;
    private double mTolerance;
    private ApproximatorType mType;

    /* renamed from: com.github.mikephil.charting.data.filter.Approximator$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$data$filter$Approximator$ApproximatorType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.github.mikephil.charting.data.filter.Approximator$ApproximatorType[] r0 = com.github.mikephil.charting.data.filter.Approximator.ApproximatorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$github$mikephil$charting$data$filter$Approximator$ApproximatorType = r0
                com.github.mikephil.charting.data.filter.Approximator$ApproximatorType r1 = com.github.mikephil.charting.data.filter.Approximator.ApproximatorType.DOUGLAS_PEUCKER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$data$filter$Approximator$ApproximatorType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.data.filter.Approximator$ApproximatorType r1 = com.github.mikephil.charting.data.filter.Approximator.ApproximatorType.NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.filter.Approximator.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ApproximatorType {
        NONE,
        DOUGLAS_PEUCKER
    }

    public Approximator() {
        this.mType = ApproximatorType.DOUGLAS_PEUCKER;
        this.mTolerance = 0.0d;
        this.mScaleRatio = 1.0f;
        this.mDeltaRatio = 1.0f;
        this.mType = ApproximatorType.NONE;
    }

    private void algorithmDouglasPeucker(List<Entry> list, double d10, int i10, int i11) {
        List<Entry> list2 = list;
        int i12 = i10;
        int i13 = i11;
        int i14 = i12 + 1;
        if (i13 > i14) {
            double d11 = 0.0d;
            Entry entry = list.get(i12);
            Entry entry2 = list.get(i13);
            int i15 = 0;
            while (i14 < i13) {
                double calcAngleBetweenLines = calcAngleBetweenLines(entry, entry2, entry, list.get(i14));
                if (calcAngleBetweenLines > d11) {
                    i15 = i14;
                    d11 = calcAngleBetweenLines;
                }
                i14++;
            }
            if (d11 > d10) {
                this.keep[i15] = true;
                List<Entry> list3 = list;
                double d12 = d10;
                algorithmDouglasPeucker(list3, d12, i10, i15);
                algorithmDouglasPeucker(list3, d12, i15, i11);
            }
        }
    }

    private List<Entry> reduceWithDouglasPeuker(List<Entry> list, double d10) {
        if (d10 <= 0.0d || list.size() < 3) {
            return list;
        }
        boolean[] zArr = this.keep;
        zArr[0] = true;
        zArr[list.size() - 1] = true;
        algorithmDouglasPeucker(list, d10, 0, list.size() - 1);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (this.keep[i10]) {
                Entry entry = list.get(i10);
                arrayList.add(new Entry(entry.getVal(), entry.getXIndex()));
            }
        }
        return arrayList;
    }

    public double calcAngle(Entry entry, Entry entry2) {
        return (Math.atan2((double) (entry2.getVal() - entry.getVal()), (double) ((float) (entry2.getXIndex() - entry.getXIndex()))) * 180.0d) / 3.141592653589793d;
    }

    public double calcAngleBetweenLines(Entry entry, Entry entry2, Entry entry3, Entry entry4) {
        return Math.abs(calcAngleWithRatios(entry, entry2) - calcAngleWithRatios(entry3, entry4));
    }

    public double calcAngleWithRatios(Entry entry, Entry entry2) {
        return (Math.atan2((double) ((entry2.getVal() * this.mScaleRatio) - (entry.getVal() * this.mScaleRatio)), (double) ((((float) entry2.getXIndex()) * this.mDeltaRatio) - (((float) entry.getXIndex()) * this.mDeltaRatio))) * 180.0d) / 3.141592653589793d;
    }

    public double calcPointToLineDistance(Entry entry, Entry entry2, Entry entry3) {
        float xIndex = ((float) entry2.getXIndex()) - ((float) entry.getXIndex());
        float xIndex2 = ((float) entry3.getXIndex()) - ((float) entry.getXIndex());
        return ((double) Math.abs((xIndex2 * (entry2.getVal() - entry.getVal())) - ((entry3.getVal() - entry.getVal()) * xIndex))) / Math.sqrt((double) ((xIndex * xIndex) + ((entry2.getVal() - entry.getVal()) * (entry2.getVal() - entry.getVal()))));
    }

    public List<Entry> filter(List<Entry> list) {
        return filter(list, this.mTolerance);
    }

    public void setRatios(float f10, float f11) {
        this.mDeltaRatio = f10;
        this.mScaleRatio = f11;
    }

    public void setTolerance(double d10) {
        this.mTolerance = d10;
    }

    public void setType(ApproximatorType approximatorType) {
        this.mType = approximatorType;
    }

    public void setup(ApproximatorType approximatorType, double d10) {
        this.mType = approximatorType;
        this.mTolerance = d10;
    }

    public List<Entry> filter(List<Entry> list, double d10) {
        if (d10 <= 0.0d) {
            return list;
        }
        this.keep = new boolean[list.size()];
        if (AnonymousClass1.$SwitchMap$com$github$mikephil$charting$data$filter$Approximator$ApproximatorType[this.mType.ordinal()] != 1) {
            return list;
        }
        return reduceWithDouglasPeuker(list, d10);
    }

    public Approximator(ApproximatorType approximatorType, double d10) {
        this.mType = ApproximatorType.DOUGLAS_PEUCKER;
        this.mTolerance = 0.0d;
        this.mScaleRatio = 1.0f;
        this.mDeltaRatio = 1.0f;
        setup(approximatorType, d10);
    }
}
