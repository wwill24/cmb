package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.content.a;
import androidx.core.view.n0;
import bf.b;
import bf.k;
import tf.g;

public class MaterialDivider extends View {

    /* renamed from: f  reason: collision with root package name */
    private static final int f19674f = k.Widget_MaterialComponents_MaterialDivider;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final g f19675a;

    /* renamed from: b  reason: collision with root package name */
    private int f19676b;

    /* renamed from: c  reason: collision with root package name */
    private int f19677c;

    /* renamed from: d  reason: collision with root package name */
    private int f19678d;

    /* renamed from: e  reason: collision with root package name */
    private int f19679e;

    public MaterialDivider(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.materialDividerStyle);
    }

    public int getDividerColor() {
        return this.f19677c;
    }

    public int getDividerInsetEnd() {
        return this.f19679e;
    }

    public int getDividerInsetStart() {
        return this.f19678d;
    }

    public int getDividerThickness() {
        return this.f19676b;
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        int i10;
        int i11;
        int i12;
        super.onDraw(canvas);
        boolean z10 = true;
        if (n0.B(this) != 1) {
            z10 = false;
        }
        if (z10) {
            i10 = this.f19679e;
        } else {
            i10 = this.f19678d;
        }
        if (z10) {
            i12 = getWidth();
            i11 = this.f19678d;
        } else {
            i12 = getWidth();
            i11 = this.f19679e;
        }
        this.f19675a.setBounds(i10, 0, i12 - i11, getBottom() - getTop());
        this.f19675a.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.f19676b;
            if (i12 > 0 && measuredHeight != i12) {
                measuredHeight = i12;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i10) {
        if (this.f19677c != i10) {
            this.f19677c = i10;
            this.f19675a.b0(ColorStateList.valueOf(i10));
            invalidate();
        }
    }

    public void setDividerColorResource(int i10) {
        setDividerColor(a.getColor(getContext(), i10));
    }

    public void setDividerInsetEnd(int i10) {
        this.f19679e = i10;
    }

    public void setDividerInsetEndResource(int i10) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerInsetStart(int i10) {
        this.f19678d = i10;
    }

    public void setDividerInsetStartResource(int i10) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerThickness(int i10) {
        if (this.f19676b != i10) {
            this.f19676b = i10;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i10) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i10));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialDivider(@androidx.annotation.NonNull android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = f19674f
            android.content.Context r8 = wf.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            tf.g r0 = new tf.g
            r0.<init>()
            r7.f19675a = r0
            int[] r2 = bf.l.MaterialDivider
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.p.i(r0, r1, r2, r3, r4, r5)
            int r10 = bf.l.MaterialDivider_dividerThickness
            android.content.res.Resources r0 = r7.getResources()
            int r1 = bf.d.material_divider_thickness
            int r0 = r0.getDimensionPixelSize(r1)
            int r10 = r9.getDimensionPixelSize(r10, r0)
            r7.f19676b = r10
            int r10 = bf.l.MaterialDivider_dividerInsetStart
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.f19678d = r10
            int r10 = bf.l.MaterialDivider_dividerInsetEnd
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.f19679e = r10
            int r10 = bf.l.MaterialDivider_dividerColor
            android.content.res.ColorStateList r8 = qf.c.a(r8, r9, r10)
            int r8 = r8.getDefaultColor()
            r7.setDividerColor(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.divider.MaterialDivider.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
