package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DiscoverFragment$observeViewModel$8 extends Lambda implements Function1<Triple<? extends DiscoverViewModel.ActionState, ? extends GiveTakeBase, ? extends PurchaseType>, Unit> {
    final /* synthetic */ DiscoverFragment this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12211a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$ActionState[] r0 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.ActionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$ActionState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.ActionState.LIKED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$ActionState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.ActionState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$ActionState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.ActionState.FLOWER_SENT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$ActionState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.ActionState.OUT_OF_BEANS     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$ActionState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.ActionState.LIST_CHANGED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f12211a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.discoverV2.DiscoverFragment$observeViewModel$8.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverFragment$observeViewModel$8(DiscoverFragment discoverFragment) {
        super(1);
        this.this$0 = discoverFragment;
    }

    public final void a(Triple<? extends DiscoverViewModel.ActionState, ? extends GiveTakeBase, ? extends PurchaseType> triple) {
        if (triple != null) {
            int i10 = a.f12211a[((DiscoverViewModel.ActionState) triple.a()).ordinal()];
            DiscoverFeedListView discoverFeedListView = null;
            if (i10 == 1) {
                DiscoverFeedListView J0 = this.this$0.f12198y;
                if (J0 == null) {
                    j.y("discoverListView");
                } else {
                    discoverFeedListView = J0;
                }
                DiscoverFragment discoverFragment = this.this$0;
                Object b10 = triple.b();
                j.d(b10);
                discoverFeedListView.D(discoverFragment.j1((GiveTakeBase) b10));
            } else if (i10 == 2) {
                DiscoverFeedListView J02 = this.this$0.f12198y;
                if (J02 == null) {
                    j.y("discoverListView");
                } else {
                    discoverFeedListView = J02;
                }
                DiscoverFragment discoverFragment2 = this.this$0;
                Object b11 = triple.b();
                j.d(b11);
                discoverFeedListView.B(discoverFragment2.j1((GiveTakeBase) b11));
            } else if (i10 == 3) {
                DiscoverFeedListView J03 = this.this$0.f12198y;
                if (J03 == null) {
                    j.y("discoverListView");
                } else {
                    discoverFeedListView = J03;
                }
                DiscoverFragment discoverFragment3 = this.this$0;
                Object b12 = triple.b();
                j.d(b12);
                discoverFeedListView.C(discoverFragment3.j1((GiveTakeBase) b12));
            } else if (i10 == 4) {
                this.this$0.N1((PurchaseType) triple.c());
            } else if (i10 == 5) {
                this.this$0.O1();
            }
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Triple) obj);
        return Unit.f32013a;
    }
}
