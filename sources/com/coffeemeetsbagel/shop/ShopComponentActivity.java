package com.coffeemeetsbagel.shop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.shop.main.d;
import com.coffeemeetsbagel.shop.main.o;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import j5.t;
import java.util.List;

public class ShopComponentActivity extends t<b, o> {
    public static Intent U0(Context context, PurchaseType purchaseType, int i10, Price price, long j10, PurchaseSource purchaseSource) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Extra.PURCHASE_TYPE, purchaseType);
        bundle.putInt(Extra.ITEM_COUNT, i10);
        bundle.putSerializable(Extra.PRICE, price);
        bundle.putLong(Extra.EXPECTED_PRICE, j10);
        bundle.putParcelable("ARG_PURCHASE_SOURCE", purchaseSource);
        Intent intent = new Intent(context, ShopComponentActivity.class);
        intent.putExtras(bundle);
        return intent;
    }

    private void V0(Intent intent) {
        Uri data;
        if ("android.intent.action.VIEW".equals(intent.getAction()) && (data = intent.getData()) != null) {
            List<String> pathSegments = data.getPathSegments();
            String str = null;
            int size = pathSegments.size();
            if (size == 1) {
                str = pathSegments.get(0);
            } else if (size == 2) {
                if ("purchase".equals(pathSegments.get(0))) {
                    str = pathSegments.get(1);
                }
            } else {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("itemToPurchase sku: ");
            sb2.append(str);
            ((b) this.f7848e).D0(str);
        }
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "SHOP";
    }

    /* access modifiers changed from: protected */
    public int Q0() {
        return R.string.shop;
    }

    /* access modifiers changed from: protected */
    /* renamed from: S0 */
    public b G0() {
        if (this.f7848e == null) {
            this.f7848e = new b();
        }
        return (b) this.f7848e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: T0 */
    public o H0(ViewGroup viewGroup) {
        PurchaseSource purchaseSource;
        V0(getIntent());
        if (getIntent().hasExtra("ARG_PURCHASE_SOURCE")) {
            purchaseSource = (PurchaseSource) getIntent().getParcelableExtra("ARG_PURCHASE_SOURCE");
        } else {
            purchaseSource = null;
        }
        return new d((d.c) ((b) this.f7848e).A0()).b(viewGroup, purchaseSource, getIntent().getData());
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.f7848e == null) {
            this.f7848e = new b();
        }
    }
}
