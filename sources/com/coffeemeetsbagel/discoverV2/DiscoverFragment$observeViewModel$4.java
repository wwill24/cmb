package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class DiscoverFragment$observeViewModel$4 extends Lambda implements Function1<Triple<? extends DiscoverViewModel.DialogViewState, ? extends GiveTake, ? extends PurchaseType>, Unit> {
    final /* synthetic */ DiscoverFragment this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12207a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$DialogViewState[] r0 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.DialogViewState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$DialogViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.DialogViewState.GONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$DialogViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.DialogViewState.PREMIUM     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.discoverV2.DiscoverViewModel$DialogViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.DialogViewState.UNPAUSE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f12207a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.discoverV2.DiscoverFragment$observeViewModel$4.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverFragment$observeViewModel$4(DiscoverFragment discoverFragment) {
        super(1);
        this.this$0 = discoverFragment;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.coffeemeetsbagel.discoverV2.DiscoverViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.coffeemeetsbagel.discoverV2.DiscoverViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(kotlin.Triple<? extends com.coffeemeetsbagel.discoverV2.DiscoverViewModel.DialogViewState, ? extends com.coffeemeetsbagel.models.GiveTake, ? extends com.coffeemeetsbagel.store.alc.PurchaseType> r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x00b0
            fa.a$a r0 = fa.a.f40771d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "premiumDialogState: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "DiscoverFeedFragment"
            r0.a(r2, r1)
            java.lang.Object r0 = r5.a()
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel$DialogViewState r0 = (com.coffeemeetsbagel.discoverV2.DiscoverViewModel.DialogViewState) r0
            int[] r1 = com.coffeemeetsbagel.discoverV2.DiscoverFragment$observeViewModel$4.a.f12207a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            java.lang.String r2 = "discoverListView"
            r3 = 0
            if (r0 == r1) goto L_0x00a0
            r1 = 2
            if (r0 == r1) goto L_0x0059
            r1 = 3
            if (r0 == r1) goto L_0x0036
            goto L_0x00b0
        L_0x0036:
            com.coffeemeetsbagel.discoverV2.DiscoverFragment r0 = r4.this$0
            com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView r0 = r0.f12198y
            if (r0 != 0) goto L_0x0042
            kotlin.jvm.internal.j.y(r2)
            goto L_0x0043
        L_0x0042:
            r3 = r0
        L_0x0043:
            java.lang.Object r0 = r5.b()
            kotlin.jvm.internal.j.d(r0)
            com.coffeemeetsbagel.models.GiveTake r0 = (com.coffeemeetsbagel.models.GiveTake) r0
            java.lang.Object r5 = r5.c()
            kotlin.jvm.internal.j.d(r5)
            com.coffeemeetsbagel.store.alc.PurchaseType r5 = (com.coffeemeetsbagel.store.alc.PurchaseType) r5
            r3.y(r0, r5)
            goto L_0x00b0
        L_0x0059:
            java.lang.Object r0 = r5.c()
            kotlin.jvm.internal.j.d(r0)
            com.coffeemeetsbagel.store.alc.PurchaseType r1 = com.coffeemeetsbagel.store.alc.PurchaseType.PAID_LIKE
            java.lang.String r2 = "viewModel"
            if (r0 != r1) goto L_0x0078
            com.coffeemeetsbagel.discoverV2.DiscoverFragment r0 = r4.this$0
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel r0 = r0.f12195t
            if (r0 != 0) goto L_0x0072
            kotlin.jvm.internal.j.y(r2)
            goto L_0x0073
        L_0x0072:
            r3 = r0
        L_0x0073:
            com.coffeemeetsbagel.models.Price r0 = r3.W()
            goto L_0x0089
        L_0x0078:
            com.coffeemeetsbagel.discoverV2.DiscoverFragment r0 = r4.this$0
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel r0 = r0.f12195t
            if (r0 != 0) goto L_0x0084
            kotlin.jvm.internal.j.y(r2)
            goto L_0x0085
        L_0x0084:
            r3 = r0
        L_0x0085:
            com.coffeemeetsbagel.models.Price r0 = r3.O()
        L_0x0089:
            com.coffeemeetsbagel.discoverV2.DiscoverFragment r1 = r4.this$0
            com.coffeemeetsbagel.store.PurchaseSource r2 = new com.coffeemeetsbagel.store.PurchaseSource
            r2.<init>()
            java.lang.Object r5 = r5.c()
            kotlin.jvm.internal.j.d(r5)
            com.coffeemeetsbagel.store.alc.PurchaseType r5 = (com.coffeemeetsbagel.store.alc.PurchaseType) r5
            kotlin.jvm.internal.j.d(r0)
            r1.K1(r2, r5, r0)
            goto L_0x00b0
        L_0x00a0:
            com.coffeemeetsbagel.discoverV2.DiscoverFragment r5 = r4.this$0
            com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView r5 = r5.f12198y
            if (r5 != 0) goto L_0x00ac
            kotlin.jvm.internal.j.y(r2)
            goto L_0x00ad
        L_0x00ac:
            r3 = r5
        L_0x00ad:
            r3.k()
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.discoverV2.DiscoverFragment$observeViewModel$4.a(kotlin.Triple):void");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Triple) obj);
        return Unit.f32013a;
    }
}
