package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import bf.a;
import cf.h;
import cf.j;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: i  reason: collision with root package name */
    private Map<View, Integer> f20472i;

    public FabTransformationSheetBehavior() {
    }

    private void g0(@NonNull View view, boolean z10) {
        boolean z11;
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                this.f20472i = new HashMap(childCount);
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (!(childAt.getLayoutParams() instanceof CoordinatorLayout.f) || !(((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (childAt != view && !z11) {
                    if (!z10) {
                        Map<View, Integer> map = this.f20472i;
                        if (map != null && map.containsKey(childAt)) {
                            n0.D0(childAt, this.f20472i.get(childAt).intValue());
                        }
                    } else {
                        this.f20472i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        n0.D0(childAt, 4);
                    }
                }
            }
            if (!z10) {
                this.f20472i = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean H(@NonNull View view, @NonNull View view2, boolean z10, boolean z11) {
        g0(view2, z10);
        return super.H(view, view2, z10, z11);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public FabTransformationBehavior.e e0(Context context, boolean z10) {
        int i10;
        if (z10) {
            i10 = a.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i10 = a.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.f20465a = h.c(context, i10);
        eVar.f20466b = new j(17, 0.0f, 0.0f);
        return eVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
