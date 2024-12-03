package com.github.mikephil.charting.data.realm.base;

import android.graphics.Color;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import io.realm.RealmObject;
import io.realm.RealmResults;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class RealmBarLineScatterCandleBubbleDataSet<T extends RealmObject, S extends Entry> extends RealmBaseDataSet<T, S> implements IBarLineScatterCandleBubbleDataSet<S> {
    protected int mHighLightColor = Color.rgb(255, Opcodes.NEW, 115);

    public RealmBarLineScatterCandleBubbleDataSet(RealmResults<T> realmResults, String str) {
        super(realmResults, str);
    }

    public int getHighLightColor() {
        return this.mHighLightColor;
    }

    public void setHighLightColor(int i10) {
        this.mHighLightColor = i10;
    }

    public RealmBarLineScatterCandleBubbleDataSet(RealmResults<T> realmResults, String str, String str2) {
        super(realmResults, str, str2);
    }
}
