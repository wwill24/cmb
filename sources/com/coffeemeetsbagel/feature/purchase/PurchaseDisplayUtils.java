package com.coffeemeetsbagel.feature.purchase;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.store.PurchaseFailureType;
import ha.a;

public class PurchaseDisplayUtils {

    /* renamed from: com.coffeemeetsbagel.feature.purchase.PurchaseDisplayUtils$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$coffeemeetsbagel$store$PurchaseFailureType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.coffeemeetsbagel.store.PurchaseFailureType[] r0 = com.coffeemeetsbagel.store.PurchaseFailureType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$coffeemeetsbagel$store$PurchaseFailureType = r0
                com.coffeemeetsbagel.store.PurchaseFailureType r1 = com.coffeemeetsbagel.store.PurchaseFailureType.UNABLE_TO_CONSUME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$coffeemeetsbagel$store$PurchaseFailureType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.store.PurchaseFailureType r1 = com.coffeemeetsbagel.store.PurchaseFailureType.UNABLE_TO_VERIFY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$coffeemeetsbagel$store$PurchaseFailureType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.store.PurchaseFailureType r1 = com.coffeemeetsbagel.store.PurchaseFailureType.GENERIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$coffeemeetsbagel$store$PurchaseFailureType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.coffeemeetsbagel.store.PurchaseFailureType r1 = com.coffeemeetsbagel.store.PurchaseFailureType.ACTIVITY_FINISHING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.feature.purchase.PurchaseDisplayUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public static int getErrorForFailedPurchase(PurchaseFailureType purchaseFailureType) {
        a.a(purchaseFailureType, "cannot be null purchase type");
        int i10 = AnonymousClass1.$SwitchMap$com$coffeemeetsbagel$store$PurchaseFailureType[purchaseFailureType.ordinal()];
        if (i10 == 1) {
            return R.string.bean_shop_purchase_consumption_failure;
        }
        if (i10 != 2) {
            return R.string.purchase_generic_could_not_complete;
        }
        return R.string.bean_shop_purchase_verification_failure;
    }
}
