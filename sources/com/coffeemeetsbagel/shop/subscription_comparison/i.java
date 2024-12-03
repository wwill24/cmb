package com.coffeemeetsbagel.shop.subscription_comparison;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import kotlin.jvm.internal.j;
import vb.c;

public final class i extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f36627e;

    /* renamed from: f  reason: collision with root package name */
    public SubscriptionComparisonsAdapter f36628f;

    public interface a {
        void a();

        void b();
    }

    public static final class b implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f36629a;

        b(i iVar) {
            this.f36629a = iVar;
        }

        public void S(int i10, float f10, int i11) {
        }

        public void m0(int i10) {
        }

        public void q(int i10) {
            if (i10 == 0) {
                this.f36629a.j().W(SubscriptionComparisonsAdapter.BundleType.FIRST);
            } else {
                this.f36629a.j().W(SubscriptionComparisonsAdapter.BundleType.SECOND);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(View view) {
        super(view);
        j.g(view, "view");
        LayoutInflater from = LayoutInflater.from(view.getContext());
        j.f(from, "from(view.context)");
        this.f36627e = from;
    }

    public final SubscriptionComparisonsAdapter j() {
        SubscriptionComparisonsAdapter subscriptionComparisonsAdapter = this.f36628f;
        if (subscriptionComparisonsAdapter != null) {
            return subscriptionComparisonsAdapter;
        }
        j.y("subscriptionComparisonsAdapter");
        return null;
    }

    public final void k(List<c> list, vb.a aVar, a aVar2) {
        j.g(list, "bundles");
        j.g(aVar2, "onUpgradeListener");
        ViewPager viewPager = (ViewPager) this.f7869c.findViewById(R.id.subscription_view_pager);
        viewPager.setPageMargin(this.f7869c.getContext().getResources().getDimensionPixelSize(R.dimen.baseline_2x));
        Context context = this.f7869c.getContext();
        j.f(context, "view.context");
        viewPager.setAdapter(new SubscriptionCardPagerAdapter(context, aVar, aVar2, list));
        ((TabLayout) this.f7869c.findViewById(R.id.subscription_page_indicator)).setupWithViewPager(viewPager);
        l(new SubscriptionComparisonsAdapter(false, (c) CollectionsKt___CollectionsKt.Y(list), (c) CollectionsKt___CollectionsKt.N(list)));
        j().X(true);
        ((RecyclerView) this.f7869c.findViewById(R.id.shop_comparison_list)).setAdapter(j());
        j().J(((c) CollectionsKt___CollectionsKt.Y(list)).a());
        viewPager.N(0, true);
        j().W(SubscriptionComparisonsAdapter.BundleType.FIRST);
        viewPager.c(new b(this));
    }

    public final void l(SubscriptionComparisonsAdapter subscriptionComparisonsAdapter) {
        j.g(subscriptionComparisonsAdapter, "<set-?>");
        this.f36628f = subscriptionComparisonsAdapter;
    }
}
