package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import com.coffeemeetsbagel.discoverV2.filters.DiscoverFeedFiltersView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DiscoverFragment$observeViewModel$5 extends Lambda implements Function1<DiscoverViewModel.FilterStateViewState, Unit> {
    final /* synthetic */ DiscoverFragment this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12208a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$FilterStateViewState[] r0 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.FilterStateViewState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$FilterStateViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.FilterStateViewState.ON     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$FilterStateViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.FilterStateViewState.OFF     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f12208a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.discoverV2.DiscoverFragment$observeViewModel$5.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverFragment$observeViewModel$5(DiscoverFragment discoverFragment) {
        super(1);
        this.this$0 = discoverFragment;
    }

    public final void a(DiscoverViewModel.FilterStateViewState filterStateViewState) {
        if (filterStateViewState != null) {
            int i10 = a.f12208a[filterStateViewState.ordinal()];
            DiscoverFeedFiltersView discoverFeedFiltersView = null;
            if (i10 == 1) {
                DiscoverFeedFiltersView I0 = this.this$0.C;
                if (I0 == null) {
                    j.y("discoverFeedFiltersView");
                } else {
                    discoverFeedFiltersView = I0;
                }
                discoverFeedFiltersView.D();
            } else if (i10 == 2) {
                DiscoverFeedFiltersView I02 = this.this$0.C;
                if (I02 == null) {
                    j.y("discoverFeedFiltersView");
                } else {
                    discoverFeedFiltersView = I02;
                }
                discoverFeedFiltersView.E();
            }
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((DiscoverViewModel.FilterStateViewState) obj);
        return Unit.f32013a;
    }
}
