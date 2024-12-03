package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import bf.d;
import bf.l;
import com.google.android.material.internal.p;
import hf.a;
import qf.c;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public int f19928a;

    /* renamed from: b  reason: collision with root package name */
    public int f19929b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public int[] f19930c = new int[0];

    /* renamed from: d  reason: collision with root package name */
    public int f19931d;

    /* renamed from: e  reason: collision with root package name */
    public int f19932e;

    /* renamed from: f  reason: collision with root package name */
    public int f19933f;

    protected b(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.mtrl_progress_track_thickness);
        TypedArray i12 = p.i(context, attributeSet, l.BaseProgressIndicator, i10, i11, new int[0]);
        this.f19928a = c.c(context, i12, l.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.f19929b = Math.min(c.c(context, i12, l.BaseProgressIndicator_trackCornerRadius, 0), this.f19928a / 2);
        this.f19932e = i12.getInt(l.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f19933f = i12.getInt(l.BaseProgressIndicator_hideAnimationBehavior, 0);
        c(context, i12);
        d(context, i12);
        i12.recycle();
    }

    private void c(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i10 = l.BaseProgressIndicator_indicatorColor;
        if (!typedArray.hasValue(i10)) {
            this.f19930c = new int[]{a.b(context, bf.b.colorPrimary, -1)};
        } else if (typedArray.peekValue(i10).type != 1) {
            this.f19930c = new int[]{typedArray.getColor(i10, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i10, -1));
            this.f19930c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
    }

    private void d(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i10 = l.BaseProgressIndicator_trackColor;
        if (typedArray.hasValue(i10)) {
            this.f19931d = typedArray.getColor(i10, -1);
            return;
        }
        this.f19931d = this.f19930c[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842803});
        float f10 = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.f19931d = a.a(this.f19931d, (int) (f10 * 255.0f));
    }

    public boolean a() {
        return this.f19933f != 0;
    }

    public boolean b() {
        return this.f19932e != 0;
    }

    /* access modifiers changed from: package-private */
    public abstract void e();
}
