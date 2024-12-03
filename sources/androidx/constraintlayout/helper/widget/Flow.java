package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.widget.h;
import androidx.constraintlayout.widget.j;

public class Flow extends j {

    /* renamed from: m  reason: collision with root package name */
    private e f3993m;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void m(AttributeSet attributeSet) {
        super.m(attributeSet);
        this.f3993m = new e();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.ConstraintLayout_Layout_android_orientation) {
                    this.f3993m.D2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.ConstraintLayout_Layout_android_padding) {
                    this.f3993m.I1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == h.ConstraintLayout_Layout_android_paddingStart) {
                    this.f3993m.N1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == h.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f3993m.K1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == h.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f3993m.L1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == h.ConstraintLayout_Layout_android_paddingTop) {
                    this.f3993m.O1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == h.ConstraintLayout_Layout_android_paddingRight) {
                    this.f3993m.M1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == h.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f3993m.J1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == h.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f3993m.I2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f3993m.x2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f3993m.H2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f3993m.r2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f3993m.z2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f3993m.t2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f3993m.B2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f3993m.v2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == h.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f3993m.q2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == h.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f3993m.y2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == h.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f3993m.s2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == h.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f3993m.A2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == h.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f3993m.F2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == h.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f3993m.u2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == h.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f3993m.E2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == h.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f3993m.w2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == h.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f3993m.G2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == h.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f3993m.C2(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f4198d = this.f3993m;
        s();
    }

    public void n(ConstraintWidget constraintWidget, boolean z10) {
        this.f3993m.t1(z10);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i10, int i11) {
        t(this.f3993m, i10, i11);
    }

    public void setFirstHorizontalBias(float f10) {
        this.f3993m.q2(f10);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i10) {
        this.f3993m.r2(i10);
        requestLayout();
    }

    public void setFirstVerticalBias(float f10) {
        this.f3993m.s2(f10);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i10) {
        this.f3993m.t2(i10);
        requestLayout();
    }

    public void setHorizontalAlign(int i10) {
        this.f3993m.u2(i10);
        requestLayout();
    }

    public void setHorizontalBias(float f10) {
        this.f3993m.v2(f10);
        requestLayout();
    }

    public void setHorizontalGap(int i10) {
        this.f3993m.w2(i10);
        requestLayout();
    }

    public void setHorizontalStyle(int i10) {
        this.f3993m.x2(i10);
        requestLayout();
    }

    public void setLastHorizontalBias(float f10) {
        this.f3993m.y2(f10);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i10) {
        this.f3993m.z2(i10);
        requestLayout();
    }

    public void setLastVerticalBias(float f10) {
        this.f3993m.A2(f10);
        requestLayout();
    }

    public void setLastVerticalStyle(int i10) {
        this.f3993m.B2(i10);
        requestLayout();
    }

    public void setMaxElementsWrap(int i10) {
        this.f3993m.C2(i10);
        requestLayout();
    }

    public void setOrientation(int i10) {
        this.f3993m.D2(i10);
        requestLayout();
    }

    public void setPadding(int i10) {
        this.f3993m.I1(i10);
        requestLayout();
    }

    public void setPaddingBottom(int i10) {
        this.f3993m.J1(i10);
        requestLayout();
    }

    public void setPaddingLeft(int i10) {
        this.f3993m.L1(i10);
        requestLayout();
    }

    public void setPaddingRight(int i10) {
        this.f3993m.M1(i10);
        requestLayout();
    }

    public void setPaddingTop(int i10) {
        this.f3993m.O1(i10);
        requestLayout();
    }

    public void setVerticalAlign(int i10) {
        this.f3993m.E2(i10);
        requestLayout();
    }

    public void setVerticalBias(float f10) {
        this.f3993m.F2(f10);
        requestLayout();
    }

    public void setVerticalGap(int i10) {
        this.f3993m.G2(i10);
        requestLayout();
    }

    public void setVerticalStyle(int i10) {
        this.f3993m.H2(i10);
        requestLayout();
    }

    public void setWrapMode(int i10) {
        this.f3993m.I2(i10);
        requestLayout();
    }

    public void t(androidx.constraintlayout.core.widgets.h hVar, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (hVar != null) {
            hVar.C1(mode, size, mode2, size2);
            setMeasuredDimension(hVar.x1(), hVar.w1());
            return;
        }
        setMeasuredDimension(0, 0);
    }
}
