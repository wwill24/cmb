package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import bf.b;
import bf.k;

public final class CircularProgressIndicator extends a<e> {

    /* renamed from: t  reason: collision with root package name */
    public static final int f19908t = k.Widget_MaterialComponents_CircularProgressIndicator;

    public CircularProgressIndicator(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.circularProgressIndicatorStyle);
    }

    private void s() {
        setIndeterminateDrawable(j.t(getContext(), (e) this.f19910a));
        setProgressDrawable(f.v(getContext(), (e) this.f19910a));
    }

    public int getIndicatorDirection() {
        return ((e) this.f19910a).f19955i;
    }

    public int getIndicatorInset() {
        return ((e) this.f19910a).f19954h;
    }

    public int getIndicatorSize() {
        return ((e) this.f19910a).f19953g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public e i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new e(context, attributeSet);
    }

    public void setIndicatorDirection(int i10) {
        ((e) this.f19910a).f19955i = i10;
        invalidate();
    }

    public void setIndicatorInset(int i10) {
        S s10 = this.f19910a;
        if (((e) s10).f19954h != i10) {
            ((e) s10).f19954h = i10;
            invalidate();
        }
    }

    public void setIndicatorSize(int i10) {
        int max = Math.max(i10, getTrackThickness() * 2);
        S s10 = this.f19910a;
        if (((e) s10).f19953g != max) {
            ((e) s10).f19953g = max;
            ((e) s10).e();
            invalidate();
        }
    }

    public void setTrackThickness(int i10) {
        super.setTrackThickness(i10);
        ((e) this.f19910a).e();
    }

    public CircularProgressIndicator(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, f19908t);
        s();
    }
}
