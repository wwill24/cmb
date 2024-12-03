package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class BarLineScatterCandleBubbleDataSet<T extends Entry> extends DataSet<T> implements IBarLineScatterCandleBubbleDataSet<T> {
    protected int mHighLightColor = Color.rgb(255, Opcodes.NEW, 115);

    public BarLineScatterCandleBubbleDataSet(List<T> list, String str) {
        super(list, str);
    }

    public int getHighLightColor() {
        return this.mHighLightColor;
    }

    public void setHighLightColor(int i10) {
        this.mHighLightColor = i10;
    }
}
