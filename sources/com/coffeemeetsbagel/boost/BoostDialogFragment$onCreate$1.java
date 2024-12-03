package com.coffeemeetsbagel.boost;

import com.coffeemeetsbagel.boost.BoostViewModel;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BoostDialogFragment$onCreate$1 extends Lambda implements Function1<BoostViewModel.ViewState, Unit> {
    final /* synthetic */ BoostDialogFragment this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11429a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.coffeemeetsbagel.boost.BoostViewModel$ViewState[] r0 = com.coffeemeetsbagel.boost.BoostViewModel.ViewState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.boost.BoostViewModel$ViewState r1 = com.coffeemeetsbagel.boost.BoostViewModel.ViewState.AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.boost.BoostViewModel$ViewState r1 = com.coffeemeetsbagel.boost.BoostViewModel.ViewState.PURCHASING_BOOST     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.boost.BoostViewModel$ViewState r1 = com.coffeemeetsbagel.boost.BoostViewModel.ViewState.INSUFFICIENT_BEANS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.boost.BoostViewModel$ViewState r1 = com.coffeemeetsbagel.boost.BoostViewModel.ViewState.PURCHASED_BOOST     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.coffeemeetsbagel.boost.BoostViewModel$ViewState r1 = com.coffeemeetsbagel.boost.BoostViewModel.ViewState.PURCHASE_FAILED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f11429a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.boost.BoostDialogFragment$onCreate$1.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoostDialogFragment$onCreate$1(BoostDialogFragment boostDialogFragment) {
        super(1);
        this.this$0 = boostDialogFragment;
    }

    public final void a(BoostViewModel.ViewState viewState) {
        int i10;
        a.C0491a aVar = fa.a.f40771d;
        String J0 = this.this$0.f11415b;
        aVar.a(J0, "observeUiState: " + viewState);
        if (viewState == null) {
            i10 = -1;
        } else {
            i10 = a.f11429a[viewState.ordinal()];
        }
        if (i10 == 1) {
            this.this$0.l1();
        } else if (i10 == 2) {
            this.this$0.W0().show();
        } else if (i10 == 3) {
            this.this$0.W0().hide();
            this.this$0.b1();
        } else if (i10 == 4) {
            this.this$0.W0().hide();
            this.this$0.d1();
        } else if (i10 == 5) {
            this.this$0.W0().hide();
            this.this$0.c1();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((BoostViewModel.ViewState) obj);
        return Unit.f32013a;
    }
}
