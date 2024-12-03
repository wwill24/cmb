package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
public class s extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    private int f19903a;

    public s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void d(int i10, boolean z10) {
        super.setVisibility(i10);
        if (z10) {
            this.f19903a = i10;
        }
    }

    public final int getUserSetVisibility() {
        return this.f19903a;
    }

    public void setVisibility(int i10) {
        d(i10, true);
    }

    public s(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19903a = getVisibility();
    }
}
