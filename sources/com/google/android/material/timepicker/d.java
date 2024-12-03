package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.core.view.n0;
import bf.f;
import bf.h;
import bf.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tf.g;
import tf.i;

class d extends ConstraintLayout {
    private final Runnable F;
    private int G;
    private g H;

    public d(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B(List<View> list, c cVar, int i10) {
        float f10 = 0.0f;
        for (View id2 : list) {
            cVar.j(id2.getId(), f.circle_center, i10, f10);
            f10 += 360.0f / ((float) list.size());
        }
    }

    private Drawable C() {
        g gVar = new g();
        this.H = gVar;
        gVar.Z(new i(0.5f));
        this.H.b0(ColorStateList.valueOf(-1));
        return this.H;
    }

    private static boolean G(View view) {
        return "skip".equals(view.getTag());
    }

    private void I() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.F);
            handler.post(this.F);
        }
    }

    /* access modifiers changed from: package-private */
    public int D(int i10) {
        return i10 == 2 ? Math.round(((float) this.G) * 0.66f) : this.G;
    }

    public int E() {
        return this.G;
    }

    public void F(int i10) {
        this.G = i10;
        H();
    }

    /* access modifiers changed from: protected */
    public void H() {
        c cVar = new c();
        cVar.f(this);
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getId() != f.circle_center && !G(childAt)) {
                int i11 = (Integer) childAt.getTag(f.material_clock_level);
                if (i11 == null) {
                    i11 = 1;
                }
                if (!hashMap.containsKey(i11)) {
                    hashMap.put(i11, new ArrayList());
                }
                ((List) hashMap.get(i11)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            B((List) entry.getValue(), cVar, D(((Integer) entry.getKey()).intValue()));
        }
        cVar.c(this);
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            view.setId(n0.k());
        }
        I();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        H();
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        I();
    }

    public void setBackgroundColor(int i10) {
        this.H.b0(ColorStateList.valueOf(i10));
    }

    public d(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(h.material_radial_view_group, this);
        n0.w0(this, C());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.RadialViewGroup, i10, 0);
        this.G = obtainStyledAttributes.getDimensionPixelSize(l.RadialViewGroup_materialCircleRadius, 0);
        this.F = new c(this);
        obtainStyledAttributes.recycle();
    }
}
