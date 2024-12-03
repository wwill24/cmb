package com.github.mikephil.charting.data.realm.implementation;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.realm.base.RealmLineRadarDataSet;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.FillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public class RealmLineDataSet<T extends RealmObject> extends RealmLineRadarDataSet<T> implements ILineDataSet {
    private int mCircleColorHole = -1;
    private List<Integer> mCircleColors = null;
    private float mCircleSize = 8.0f;
    private float mCubicIntensity = 0.2f;
    private DashPathEffect mDashPathEffect = null;
    private boolean mDrawCircleHole = true;
    private boolean mDrawCircles = true;
    private boolean mDrawCubic = false;
    private FillFormatter mFillFormatter = new DefaultFillFormatter();

    public RealmLineDataSet(RealmResults<T> realmResults, String str) {
        super(realmResults, str);
        ArrayList arrayList = new ArrayList();
        this.mCircleColors = arrayList;
        arrayList.add(Integer.valueOf(Color.rgb(Opcodes.F2L, 234, 255)));
        build(this.results);
        calcMinMax(0, this.results.size());
    }

    public void build(RealmResults<T> realmResults) {
        super.build(realmResults);
    }

    public void disableDashedLine() {
        this.mDashPathEffect = null;
    }

    public void enableDashedLine(float f10, float f11, float f12) {
        this.mDashPathEffect = new DashPathEffect(new float[]{f10, f11}, f12);
    }

    public int getCircleColor(int i10) {
        List<Integer> list = this.mCircleColors;
        return list.get(i10 % list.size()).intValue();
    }

    public List<Integer> getCircleColors() {
        return this.mCircleColors;
    }

    public int getCircleHoleColor() {
        return this.mCircleColorHole;
    }

    public float getCircleRadius() {
        return this.mCircleSize;
    }

    public float getCubicIntensity() {
        return this.mCubicIntensity;
    }

    public DashPathEffect getDashPathEffect() {
        return this.mDashPathEffect;
    }

    public FillFormatter getFillFormatter() {
        return this.mFillFormatter;
    }

    public boolean isDashedLineEnabled() {
        return this.mDashPathEffect != null;
    }

    public boolean isDrawCircleHoleEnabled() {
        return this.mDrawCircleHole;
    }

    public boolean isDrawCirclesEnabled() {
        return this.mDrawCircles;
    }

    public boolean isDrawCubicEnabled() {
        return this.mDrawCubic;
    }

    public void resetCircleColors() {
        this.mCircleColors = new ArrayList();
    }

    public void setCircleColor(int i10) {
        resetCircleColors();
        this.mCircleColors.add(Integer.valueOf(i10));
    }

    public void setCircleColorHole(int i10) {
        this.mCircleColorHole = i10;
    }

    public void setCircleColors(List<Integer> list) {
        this.mCircleColors = list;
    }

    public void setCircleSize(float f10) {
        this.mCircleSize = Utils.convertDpToPixel(f10);
    }

    public void setCubicIntensity(float f10) {
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        if (f10 < 0.05f) {
            f10 = 0.05f;
        }
        this.mCubicIntensity = f10;
    }

    public void setDrawCircleHole(boolean z10) {
        this.mDrawCircleHole = z10;
    }

    public void setDrawCircles(boolean z10) {
        this.mDrawCircles = z10;
    }

    public void setDrawCubic(boolean z10) {
        this.mDrawCubic = z10;
    }

    public void setFillFormatter(FillFormatter fillFormatter) {
        if (fillFormatter == null) {
            this.mFillFormatter = new DefaultFillFormatter();
        } else {
            this.mFillFormatter = fillFormatter;
        }
    }

    public void setCircleColors(int[] iArr) {
        this.mCircleColors = ColorTemplate.createColors(iArr);
    }

    public void setCircleColors(int[] iArr, Context context) {
        ArrayList arrayList = new ArrayList();
        for (int color : iArr) {
            arrayList.add(Integer.valueOf(context.getResources().getColor(color)));
        }
        this.mCircleColors = arrayList;
    }

    public RealmLineDataSet(RealmResults<T> realmResults, String str, String str2) {
        super(realmResults, str, str2);
        ArrayList arrayList = new ArrayList();
        this.mCircleColors = arrayList;
        arrayList.add(Integer.valueOf(Color.rgb(Opcodes.F2L, 234, 255)));
        build(this.results);
        calcMinMax(0, this.results.size());
    }
}
