package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DiscoverFragment$observeViewModel$6 extends Lambda implements Function1<DiscoverViewModel.ProgressDialogViewState, Unit> {
    final /* synthetic */ DiscoverFragment this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12209a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$ProgressDialogViewState[] r0 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.ProgressDialogViewState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$ProgressDialogViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.ProgressDialogViewState.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$ProgressDialogViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.ProgressDialogViewState.GONE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f12209a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.discoverV2.DiscoverFragment$observeViewModel$6.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverFragment$observeViewModel$6(DiscoverFragment discoverFragment) {
        super(1);
        this.this$0 = discoverFragment;
    }

    public final void a(DiscoverViewModel.ProgressDialogViewState progressDialogViewState) {
        if (progressDialogViewState != null) {
            int i10 = a.f12209a[progressDialogViewState.ordinal()];
            DiscoverFeedListView discoverFeedListView = null;
            if (i10 == 1) {
                DiscoverFeedListView J0 = this.this$0.f12198y;
                if (J0 == null) {
                    j.y("discoverListView");
                } else {
                    discoverFeedListView = J0;
                }
                discoverFeedListView.G();
            } else if (i10 == 2) {
                DiscoverFeedListView J02 = this.this$0.f12198y;
                if (J02 == null) {
                    j.y("discoverListView");
                } else {
                    discoverFeedListView = J02;
                }
                discoverFeedListView.m();
            }
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((DiscoverViewModel.ProgressDialogViewState) obj);
        return Unit.f32013a;
    }
}
