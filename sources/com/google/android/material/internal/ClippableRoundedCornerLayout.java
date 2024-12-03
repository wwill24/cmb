package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

public class ClippableRoundedCornerLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Path f19790a;

    public ClippableRoundedCornerLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f19790a == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.f19790a);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }
}
