package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.google.android.material.tabs.TabLayout;
import q5.f;
import q5.p;

public class CustomTabLayout extends TabLayout {

    /* renamed from: j0  reason: collision with root package name */
    private Context f11500j0;

    /* renamed from: k0  reason: collision with root package name */
    private String f11501k0;

    /* renamed from: l0  reason: collision with root package name */
    private final float f11502l0;

    public CustomTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11500j0 = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.CustomTabLayout);
        this.f11501k0 = obtainStyledAttributes.getString(p.CustomTabLayout_tabTextFont);
        this.f11502l0 = (float) obtainStyledAttributes.getDimensionPixelSize(p.CustomTabLayout_tabTextSize, (int) TypedValue.applyDimension(2, (float) 14, this.f11500j0.getResources().getDisplayMetrics()));
        obtainStyledAttributes.recycle();
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a adapter;
        H();
        if (viewPager != null && (adapter = viewPager.getAdapter()) != null) {
            Typeface c10 = f.c(this.f11500j0, this.f11501k0);
            int e10 = adapter.e();
            for (int i10 = 0; i10 < e10; i10++) {
                CharSequence g10 = adapter.g(i10);
                TextView textView = new TextView(this.f11500j0);
                textView.setTypeface(c10);
                textView.setText(g10);
                textView.setTextSize(0, this.f11502l0);
                textView.setTextColor(getTabTextColors());
                textView.setGravity(1);
                TabLayout.g E = E();
                E.p(textView);
                i(E);
            }
            super.setupWithViewPager(viewPager);
        }
    }
}
