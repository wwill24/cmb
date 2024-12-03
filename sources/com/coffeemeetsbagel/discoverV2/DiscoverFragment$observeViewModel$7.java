package com.coffeemeetsbagel.discoverV2;

import android.view.View;
import b6.r;
import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import com.coffeemeetsbagel.upsell_banner.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DiscoverFragment$observeViewModel$7 extends Lambda implements Function1<DiscoverViewModel.UpsellViewState, Unit> {
    final /* synthetic */ DiscoverFragment this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12210a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$UpsellViewState[] r0 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.UpsellViewState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$UpsellViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.UpsellViewState.ENABLED_FREE_TRIAL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$UpsellViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.UpsellViewState.ENABLED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$UpsellViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.UpsellViewState.DISABLED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$UpsellViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.UpsellViewState.CLOSED_BY_USER     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f12210a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.discoverV2.DiscoverFragment$observeViewModel$7.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverFragment$observeViewModel$7(DiscoverFragment discoverFragment) {
        super(1);
        this.this$0 = discoverFragment;
    }

    public final void a(DiscoverViewModel.UpsellViewState upsellViewState) {
        if (upsellViewState != null) {
            fa.a.f40771d.a("DiscoverFeedFragment", "Upsell State: " + upsellViewState);
            int i10 = a.f12210a[upsellViewState.ordinal()];
            if (i10 == 1) {
                this.this$0.L1(true);
            } else if (i10 != 2) {
                View view = null;
                if (i10 == 3) {
                    if (this.this$0.o1() != null) {
                        r.b(this.this$0.o1());
                        this.this$0.F1((n) null);
                    }
                    View N0 = this.this$0.f12199z;
                    if (N0 == null) {
                        j.y("upsellBannerView");
                    } else {
                        view = N0;
                    }
                    view.setVisibility(8);
                } else if (i10 == 4) {
                    View N02 = this.this$0.f12199z;
                    if (N02 == null) {
                        j.y("upsellBannerView");
                        N02 = null;
                    }
                    N02.setVisibility(8);
                    if (this.this$0.o1() != null) {
                        r.b(this.this$0.o1());
                        this.this$0.F1((n) null);
                    }
                }
            } else {
                this.this$0.L1(false);
            }
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((DiscoverViewModel.UpsellViewState) obj);
        return Unit.f32013a;
    }
}
