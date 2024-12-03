package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import bf.b;
import bf.d;
import bf.l;
import com.google.android.material.internal.p;
import qf.c;

public final class e extends b {

    /* renamed from: g  reason: collision with root package name */
    public int f19953g;

    /* renamed from: h  reason: collision with root package name */
    public int f19954h;

    /* renamed from: i  reason: collision with root package name */
    public int f19955i;

    public e(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.circularProgressIndicatorStyle);
    }

    /* access modifiers changed from: package-private */
    public void e() {
    }

    public e(@NonNull Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, CircularProgressIndicator.f19908t);
    }

    public e(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(d.mtrl_progress_circular_inset_medium);
        TypedArray i12 = p.i(context, attributeSet, l.CircularProgressIndicator, i10, i11, new int[0]);
        this.f19953g = Math.max(c.c(context, i12, l.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.f19928a * 2);
        this.f19954h = c.c(context, i12, l.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f19955i = i12.getInt(l.CircularProgressIndicator_indicatorDirectionCircular, 0);
        i12.recycle();
        e();
    }
}
