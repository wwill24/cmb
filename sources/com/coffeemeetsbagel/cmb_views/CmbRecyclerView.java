package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.subjects.a;
import j5.x;
import qj.q;

public class CmbRecyclerView extends RecyclerView {
    private final a<x> V0 = a.C0();

    public CmbRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public q<x> K1() {
        return this.V0.P();
    }

    public void S0(int i10) {
        super.S0(i10);
        this.V0.d(x.a());
    }
}
