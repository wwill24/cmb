package com.github.mikephil.charting.data.realm.base;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import io.realm.DynamicRealmObject;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.Iterator;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class RealmLineRadarDataSet<T extends RealmObject> extends RealmLineScatterCandleRadarDataSet<T, Entry> implements ILineRadarDataSet<Entry> {
    private boolean mDrawFilled = false;
    private int mFillAlpha = 85;
    private int mFillColor = Color.rgb(Opcodes.F2L, 234, 255);
    protected Drawable mFillDrawable;
    private float mLineWidth = 2.5f;

    public RealmLineRadarDataSet(RealmResults<T> realmResults, String str) {
        super(realmResults, str);
    }

    public void build(RealmResults<T> realmResults) {
        if (this.mIndexField == null) {
            int i10 = 0;
            Iterator it = realmResults.iterator();
            while (it.hasNext()) {
                this.mValues.add(new Entry(new DynamicRealmObject((RealmObject) it.next()).getFloat(this.mValuesField), i10));
                i10++;
            }
            return;
        }
        Iterator it2 = realmResults.iterator();
        while (it2.hasNext()) {
            DynamicRealmObject dynamicRealmObject = new DynamicRealmObject((RealmObject) it2.next());
            this.mValues.add(new Entry(dynamicRealmObject.getFloat(this.mValuesField), dynamicRealmObject.getInt(this.mIndexField)));
        }
    }

    public int getFillAlpha() {
        return this.mFillAlpha;
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public Drawable getFillDrawable() {
        return this.mFillDrawable;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public boolean isDrawFilledEnabled() {
        return this.mDrawFilled;
    }

    public void setDrawFilled(boolean z10) {
        this.mDrawFilled = z10;
    }

    public void setFillAlpha(int i10) {
        this.mFillAlpha = i10;
    }

    public void setFillColor(int i10) {
        this.mFillColor = i10;
        this.mFillDrawable = null;
    }

    public void setFillDrawable(Drawable drawable) {
        this.mFillDrawable = drawable;
    }

    public void setLineWidth(float f10) {
        if (f10 < 0.2f) {
            f10 = 0.2f;
        }
        if (f10 > 10.0f) {
            f10 = 10.0f;
        }
        this.mLineWidth = Utils.convertDpToPixel(f10);
    }

    public RealmLineRadarDataSet(RealmResults<T> realmResults, String str, String str2) {
        super(realmResults, str, str2);
    }
}
