package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class HeightWrappingViewPager extends ViewPager {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeightWrappingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(attributeSet, "attrs");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int childCount = getChildCount();
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            childAt.measure(i10, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i12) {
                i12 = measuredHeight;
            }
        }
        if (i12 > 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        super.onMeasure(i10, i11);
    }
}
