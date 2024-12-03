package com.coffeemeetsbagel.discoverV2;

import a7.a;
import android.view.View;
import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import com.coffeemeetsbagel.discoverV2.empty.DiscoverFeedEmptyView;
import com.coffeemeetsbagel.discoverV2.filters.DiscoverFeedFiltersView;
import com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DiscoverFragment$observeViewModel$1 extends Lambda implements Function1<List<? extends GiveTakeBase>, Unit> {
    final /* synthetic */ DiscoverFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverFragment$observeViewModel$1(DiscoverFragment discoverFragment) {
        super(1);
        this.this$0 = discoverFragment;
    }

    public final void a(List<? extends GiveTakeBase> list) {
        boolean z10;
        String str;
        DiscoverFeedEmptyView discoverFeedEmptyView = null;
        if (list.isEmpty()) {
            DiscoverFeedEmptyView G0 = this.this$0.B;
            if (G0 == null) {
                j.y("discoverEmptyListView");
                G0 = null;
            }
            if (G0.getVisibility() != 0) {
                DiscoverViewModel O0 = this.this$0.f12195t;
                if (O0 == null) {
                    j.y("viewModel");
                    O0 = null;
                }
                if (O0.Q().f() == DiscoverViewModel.FilterStateViewState.ON) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                DiscoverFeedEmptyView G02 = this.this$0.B;
                if (G02 == null) {
                    j.y("discoverEmptyListView");
                    G02 = null;
                }
                G02.I(z10);
                DiscoverFeedEmptyView G03 = this.this$0.B;
                if (G03 == null) {
                    j.y("discoverEmptyListView");
                    G03 = null;
                }
                G03.setVisibility(0);
                a d12 = this.this$0.d1();
                if (z10) {
                    str = "Empty Discover Filter Feed Shown";
                } else {
                    str = "Empty Discover Feed Shown";
                }
                d12.i(str);
            }
            DiscoverFeedFiltersView I0 = this.this$0.C;
            if (I0 == null) {
                j.y("discoverFeedFiltersView");
                I0 = null;
            }
            I0.setVisibility(8);
            DiscoverFeedListView J0 = this.this$0.f12198y;
            if (J0 == null) {
                j.y("discoverListView");
                J0 = null;
            }
            J0.setVisibility(8);
            View N0 = this.this$0.f12199z;
            if (N0 == null) {
                j.y("upsellBannerView");
                N0 = null;
            }
            N0.setVisibility(8);
            DiscoverFeedEmptyView G04 = this.this$0.B;
            if (G04 == null) {
                j.y("discoverEmptyListView");
            } else {
                discoverFeedEmptyView = G04;
            }
            discoverFeedEmptyView.setVisibility(0);
            return;
        }
        DiscoverFeedEmptyView G05 = this.this$0.B;
        if (G05 == null) {
            j.y("discoverEmptyListView");
            G05 = null;
        }
        G05.setVisibility(8);
        DiscoverFragment discoverFragment = this.this$0;
        DiscoverViewModel O02 = discoverFragment.f12195t;
        if (O02 == null) {
            j.y("viewModel");
            O02 = null;
        }
        List<GiveTakeBase> f10 = O02.S().f();
        j.d(f10);
        discoverFragment.I1(f10);
        DiscoverFeedListView J02 = this.this$0.f12198y;
        if (J02 == null) {
            j.y("discoverListView");
            J02 = null;
        }
        J02.setVisibility(0);
        DiscoverFeedFiltersView I02 = this.this$0.C;
        if (I02 == null) {
            j.y("discoverFeedFiltersView");
        } else {
            discoverFeedEmptyView = I02;
        }
        discoverFeedEmptyView.setVisibility(0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
