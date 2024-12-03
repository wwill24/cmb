package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.h;

public abstract class j extends a {

    /* renamed from: k  reason: collision with root package name */
    private boolean f4337k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4338l;

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void i(ConstraintLayout constraintLayout) {
        h(constraintLayout);
    }

    /* access modifiers changed from: protected */
    public void m(AttributeSet attributeSet) {
        super.m(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.ConstraintLayout_Layout_android_visibility) {
                    this.f4337k = true;
                } else if (index == h.ConstraintLayout_Layout_android_elevation) {
                    this.f4338l = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4337k || this.f4338l) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i10 = 0; i10 < this.f4196b; i10++) {
                    View l10 = constraintLayout.l(this.f4195a[i10]);
                    if (l10 != null) {
                        if (this.f4337k) {
                            l10.setVisibility(visibility);
                        }
                        if (this.f4338l && elevation > 0.0f) {
                            l10.setTranslationZ(l10.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        g();
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        g();
    }

    public void t(h hVar, int i10, int i11) {
    }
}
