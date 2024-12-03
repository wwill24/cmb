package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class d extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    c f4327a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    /* renamed from: b */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public c getConstraintSet() {
        if (this.f4327a == null) {
            this.f4327a = new c();
        }
        this.f4327a.g(this);
        return this.f4327a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.b(layoutParams);
    }

    public static class a extends ConstraintLayout.b {
        public float A0;
        public float B0;
        public float C0;
        public float D0;
        public float E0;
        public float F0;
        public float G0;
        public float H0;
        public float I0;
        public float J0;

        /* renamed from: x0  reason: collision with root package name */
        public float f4328x0;

        /* renamed from: y0  reason: collision with root package name */
        public boolean f4329y0;

        /* renamed from: z0  reason: collision with root package name */
        public float f4330z0;

        public a(int i10, int i11) {
            super(i10, i11);
            this.f4328x0 = 1.0f;
            this.f4329y0 = false;
            this.f4330z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 1.0f;
            this.E0 = 1.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
            this.J0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4328x0 = 1.0f;
            this.f4329y0 = false;
            this.f4330z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 1.0f;
            this.E0 = 1.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
            this.J0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.ConstraintSet_android_alpha) {
                    this.f4328x0 = obtainStyledAttributes.getFloat(index, this.f4328x0);
                } else if (index == h.ConstraintSet_android_elevation) {
                    this.f4330z0 = obtainStyledAttributes.getFloat(index, this.f4330z0);
                    this.f4329y0 = true;
                } else if (index == h.ConstraintSet_android_rotationX) {
                    this.B0 = obtainStyledAttributes.getFloat(index, this.B0);
                } else if (index == h.ConstraintSet_android_rotationY) {
                    this.C0 = obtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == h.ConstraintSet_android_rotation) {
                    this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == h.ConstraintSet_android_scaleX) {
                    this.D0 = obtainStyledAttributes.getFloat(index, this.D0);
                } else if (index == h.ConstraintSet_android_scaleY) {
                    this.E0 = obtainStyledAttributes.getFloat(index, this.E0);
                } else if (index == h.ConstraintSet_android_transformPivotX) {
                    this.F0 = obtainStyledAttributes.getFloat(index, this.F0);
                } else if (index == h.ConstraintSet_android_transformPivotY) {
                    this.G0 = obtainStyledAttributes.getFloat(index, this.G0);
                } else if (index == h.ConstraintSet_android_translationX) {
                    this.H0 = obtainStyledAttributes.getFloat(index, this.H0);
                } else if (index == h.ConstraintSet_android_translationY) {
                    this.I0 = obtainStyledAttributes.getFloat(index, this.I0);
                } else if (index == h.ConstraintSet_android_translationZ) {
                    this.J0 = obtainStyledAttributes.getFloat(index, this.J0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
