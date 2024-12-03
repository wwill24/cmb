package com.coffeemeetsbagel.subscription_dialog.benefits_carousel;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.coffeemeetsbagel.R;
import com.google.android.material.tabs.TabLayout;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class i extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager f37022a;

    /* renamed from: b  reason: collision with root package name */
    private TabLayout f37023b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Context context) {
        super(context);
        j.g(context, IdentityHttpResponse.CONTEXT);
        View.inflate(getContext(), R.layout.subscription_dialog_benefit_carousel, this);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setOrientation(1);
        View findViewById = findViewById(R.id.view_pager);
        j.f(findViewById, "findViewById(R.id.view_pager)");
        this.f37022a = (ViewPager) findViewById;
        View findViewById2 = findViewById(R.id.circle_page_indicator);
        j.f(findViewById2, "findViewById(R.id.circle_page_indicator)");
        this.f37023b = (TabLayout) findViewById2;
    }

    public final void a() {
        int i10;
        if (this.f37022a.getChildCount() >= 2) {
            int currentItem = this.f37022a.getCurrentItem() + 1;
            a adapter = this.f37022a.getAdapter();
            int i11 = 0;
            if (adapter != null) {
                i10 = adapter.e();
            } else {
                i10 = 0;
            }
            if (currentItem < i10) {
                i11 = this.f37022a.getCurrentItem() + 1;
            }
            this.f37022a.N(i11, true);
        }
    }

    public final void b(a aVar, Integer num) {
        j.g(aVar, "viewPagerAdapter");
        this.f37022a.setAdapter(aVar);
        this.f37023b.setupWithViewPager(this.f37022a);
        if (num != null) {
            this.f37022a.N(num.intValue(), true);
        }
    }
}
