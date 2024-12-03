package com.coffeemeetsbagel.shop.main;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.coffeemeetsbagel.R;

public class MainShopComponentView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager f36428a;

    public MainShopComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f36428a = (ViewPager) findViewById(R.id.shop_view_pager);
    }

    /* access modifiers changed from: package-private */
    public void setPagerAdapter(a aVar) {
        this.f36428a.setAdapter(aVar);
    }
}
