package lc;

import android.content.Intent;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.store.alc.PurchaseType;

public class p {
    public Intent a(PurchaseType purchaseType, Price price, int i10, int i11) {
        Intent intent = new Intent();
        intent.putExtra(Extra.PURCHASE_TYPE, purchaseType);
        intent.putExtra(Extra.PRICE, price);
        intent.putExtra(Extra.ITEM_COUNT, i10);
        intent.putExtra(Extra.EXPECTED_PRICE, i11);
        return intent;
    }
}
