package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import d.f;
import d.j;

public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1040a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1041b;

    /* renamed from: c  reason: collision with root package name */
    private int f1042c = -1;

    public ButtonBarLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] iArr = j.ButtonBarLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        n0.q0(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.f1040a = obtainStyledAttributes.getBoolean(j.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f1040a);
        }
    }

    private int a(int i10) {
        int childCount = getChildCount();
        while (i10 < childCount) {
            if (getChildAt(i10).getVisibility() == 0) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    private boolean b() {
        return this.f1041b;
    }

    private void setStacked(boolean z10) {
        int i10;
        int i11;
        if (this.f1041b == z10) {
            return;
        }
        if (!z10 || this.f1040a) {
            this.f1041b = z10;
            setOrientation(z10 ? 1 : 0);
            if (z10) {
                i10 = 8388613;
            } else {
                i10 = 80;
            }
            setGravity(i10);
            View findViewById = findViewById(f.spacer);
            if (findViewById != null) {
                if (z10) {
                    i11 = 8;
                } else {
                    i11 = 4;
                }
                findViewById.setVisibility(i11);
            }
            for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                bringChildToFront(getChildAt(childCount));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        boolean z10;
        int i12;
        boolean z11;
        int size = View.MeasureSpec.getSize(i10);
        int i13 = 0;
        if (this.f1040a) {
            if (size > this.f1042c && b()) {
                setStacked(false);
            }
            this.f1042c = size;
        }
        if (b() || View.MeasureSpec.getMode(i10) != 1073741824) {
            i12 = i10;
            z10 = false;
        } else {
            i12 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z10 = true;
        }
        super.onMeasure(i12, i11);
        if (this.f1040a && !b()) {
            if ((getMeasuredWidthAndState() & -16777216) == 16777216) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                setStacked(true);
                z10 = true;
            }
        }
        if (z10) {
            super.onMeasure(i10, i11);
        }
        int a10 = a(0);
        if (a10 >= 0) {
            View childAt = getChildAt(a10);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (b()) {
                int a11 = a(a10 + 1);
                if (a11 >= 0) {
                    paddingTop += getChildAt(a11).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i13 = paddingTop;
            } else {
                i13 = paddingTop + getPaddingBottom();
            }
        }
        if (n0.C(this) != i13) {
            setMinimumHeight(i13);
            if (i11 == 0) {
                super.onMeasure(i10, i11);
            }
        }
    }

    public void setAllowStacking(boolean z10) {
        if (this.f1040a != z10) {
            this.f1040a = z10;
            if (!z10 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
