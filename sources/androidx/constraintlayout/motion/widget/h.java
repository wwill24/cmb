package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.a;

public class h extends a implements MotionLayout.d {

    /* renamed from: k  reason: collision with root package name */
    private boolean f4071k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4072l;

    /* renamed from: m  reason: collision with root package name */
    private float f4073m;

    /* renamed from: n  reason: collision with root package name */
    protected View[] f4074n;

    public void a(MotionLayout motionLayout, int i10, int i11, float f10) {
    }

    public void b(MotionLayout motionLayout, int i10) {
    }

    public void c(MotionLayout motionLayout, int i10, int i11) {
    }

    public float getProgress() {
        return this.f4073m;
    }

    /* access modifiers changed from: protected */
    public void m(AttributeSet attributeSet) {
        super.m(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.h.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == androidx.constraintlayout.widget.h.MotionHelper_onShow) {
                    this.f4071k = obtainStyledAttributes.getBoolean(index, this.f4071k);
                } else if (index == androidx.constraintlayout.widget.h.MotionHelper_onHide) {
                    this.f4072l = obtainStyledAttributes.getBoolean(index, this.f4072l);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f10) {
        this.f4073m = f10;
        int i10 = 0;
        if (this.f4196b > 0) {
            this.f4074n = l((ConstraintLayout) getParent());
            while (i10 < this.f4196b) {
                x(this.f4074n[i10], f10);
                i10++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i10 < childCount) {
            View childAt = viewGroup.getChildAt(i10);
            if (!(childAt instanceof h)) {
                x(childAt, f10);
            }
            i10++;
        }
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        return this.f4072l;
    }

    public boolean v() {
        return this.f4071k;
    }

    public void w(Canvas canvas) {
    }

    public void x(View view, float f10) {
    }
}
