package com.coffeemeetsbagel.feature.education;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.content.a;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public class EducationPlusBeansView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private CmbTextView f13012a;

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f13013b;

    public EducationPlusBeansView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        CmbTextView cmbTextView = (CmbTextView) findViewById(R.id.education_share_text);
        this.f13012a = cmbTextView;
        cmbTextView.setVisibility(0);
        CmbTextView cmbTextView2 = (CmbTextView) findViewById(R.id.education_beans_incentive_text);
        this.f13013b = cmbTextView2;
        cmbTextView2.setVisibility(0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.margin_small);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.margin_xxxxxxxsmall);
        Drawable drawable = a.getDrawable(getContext(), R.drawable.icon_bean_white);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f13013b.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.f13013b.setCompoundDrawablePadding(dimensionPixelSize2);
        androidx.core.graphics.drawable.a.n(androidx.core.graphics.drawable.a.r(drawable), getContext().getResources().getColor(R.color.hot_pink));
    }
}
