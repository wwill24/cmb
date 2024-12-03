package com.coffeemeetsbagel.new_user_experience.carousel;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class CarouselPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f34926e;

    /* renamed from: f  reason: collision with root package name */
    private ViewPager f34927f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CmbButton f34928g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TabLayout f34929h;

    /* renamed from: j  reason: collision with root package name */
    private final int f34930j = 2;

    public interface a {
        void B(int i10);

        void J0(int i10);

        void L();

        void h1(int i10);
    }

    public static final class b implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        private int f34931a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CarouselPresenter f34932b;

        b(CarouselPresenter carouselPresenter) {
            this.f34932b = carouselPresenter;
        }

        public void S(int i10, float f10, int i11) {
            if (i10 == 1) {
                float f11 = ((float) -1) * ((float) i11);
                CmbButton k10 = this.f34932b.f34928g;
                if (k10 != null) {
                    k10.setTranslationX(f11);
                }
                TabLayout l10 = this.f34932b.f34929h;
                if (l10 != null) {
                    l10.setTranslationX(f11);
                }
            }
            this.f34931a = i10;
        }

        public void m0(int i10) {
        }

        public void q(int i10) {
            this.f34932b.o().J0(i10);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f34926e = aVar;
    }

    /* access modifiers changed from: private */
    public static final void n(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void p() {
        int i10;
        ViewPager viewPager = this.f34927f;
        if (viewPager != null) {
            i10 = viewPager.getCurrentItem();
        } else {
            i10 = 0;
        }
        if (i10 >= this.f34930j) {
            this.f34926e.L();
        } else {
            ViewPager viewPager2 = this.f34927f;
            if (viewPager2 != null) {
                viewPager2.N(i10 + 1, true);
            }
        }
        this.f34926e.B(i10);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f34926e.J0(0);
        ((com.uber.autodispose.p) ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new h(new CarouselPresenter$didLoad$1(this)));
        this.f34928g = (CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button);
        g gVar = new g(this.f34926e);
        ViewPager viewPager = (ViewPager) ((ViewGroup) this.f7869c).findViewById(R.id.view_pager);
        this.f34927f = viewPager;
        if (viewPager != null) {
            viewPager.setAdapter(gVar);
        }
        ViewPager viewPager2 = this.f34927f;
        if (viewPager2 != null) {
            viewPager2.c(new b(this));
        }
        ViewPager viewPager3 = this.f34927f;
        if (viewPager3 != null) {
            viewPager3.setCurrentItem(0);
        }
        TabLayout tabLayout = (TabLayout) ((ViewGroup) this.f7869c).findViewById(R.id.progress_indicator);
        this.f34929h = tabLayout;
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(this.f34927f);
        }
    }

    public final a o() {
        return this.f34926e;
    }

    public final boolean q() {
        int i10;
        int i11;
        a aVar = this.f34926e;
        ViewPager viewPager = this.f34927f;
        boolean z10 = false;
        if (viewPager != null) {
            i10 = viewPager.getCurrentItem();
        } else {
            i10 = 0;
        }
        aVar.h1(i10);
        ViewPager viewPager2 = this.f34927f;
        if (viewPager2 != null) {
            i11 = viewPager2.getCurrentItem();
        } else {
            i11 = 0;
        }
        if (i11 > 0) {
            ViewPager viewPager3 = this.f34927f;
            z10 = true;
            if (viewPager3 != null) {
                viewPager3.N(i11 - 1, true);
            }
        }
        return z10;
    }
}
