package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.a;

public class Barrier extends a {

    /* renamed from: k  reason: collision with root package name */
    private int f4094k;

    /* renamed from: l  reason: collision with root package name */
    private int f4095l;

    /* renamed from: m  reason: collision with root package name */
    private a f4096m;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void t(ConstraintWidget constraintWidget, int i10, boolean z10) {
        this.f4095l = i10;
        if (z10) {
            int i11 = this.f4094k;
            if (i11 == 5) {
                this.f4095l = 1;
            } else if (i11 == 6) {
                this.f4095l = 0;
            }
        } else {
            int i12 = this.f4094k;
            if (i12 == 5) {
                this.f4095l = 0;
            } else if (i12 == 6) {
                this.f4095l = 1;
            }
        }
        if (constraintWidget instanceof a) {
            ((a) constraintWidget).A1(this.f4095l);
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.f4096m.u1();
    }

    public int getMargin() {
        return this.f4096m.w1();
    }

    public int getType() {
        return this.f4094k;
    }

    /* access modifiers changed from: protected */
    public void m(AttributeSet attributeSet) {
        super.m(attributeSet);
        this.f4096m = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f4096m.z1(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == h.ConstraintLayout_Layout_barrierMargin) {
                    this.f4096m.B1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f4198d = this.f4096m;
        s();
    }

    public void n(ConstraintWidget constraintWidget, boolean z10) {
        t(constraintWidget, this.f4094k, z10);
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f4096m.z1(z10);
    }

    public void setDpMargin(int i10) {
        a aVar = this.f4096m;
        aVar.B1((int) ((((float) i10) * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i10) {
        this.f4096m.B1(i10);
    }

    public void setType(int i10) {
        this.f4094k = i10;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
