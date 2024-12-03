package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.i;
import com.google.android.gms.internal.play_billing.zzb;
import java.util.ArrayList;

final class c1 {
    static i a(Bundle bundle, String str, String str2) {
        i iVar = u0.f9020j;
        if (bundle == null) {
            zzb.zzj("BillingClient", String.format("%s got null owned items list", new Object[]{str2}));
            return iVar;
        }
        int zzb = zzb.zzb(bundle, "BillingClient");
        String zzf = zzb.zzf(bundle, "BillingClient");
        i.a c10 = i.c();
        c10.c(zzb);
        c10.b(zzf);
        i a10 = c10.a();
        if (zzb != 0) {
            zzb.zzj("BillingClient", String.format("%s failed. Response code: %s", new Object[]{str2, Integer.valueOf(zzb)}));
            return a10;
        } else if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            zzb.zzj("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", new Object[]{str2}));
            return iVar;
        } else {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            if (stringArrayList == null) {
                zzb.zzj("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", new Object[]{str2}));
                return iVar;
            } else if (stringArrayList2 == null) {
                zzb.zzj("BillingClient", String.format("Bundle returned from %s contains null purchases list.", new Object[]{str2}));
                return iVar;
            } else if (stringArrayList3 != null) {
                return u0.f9022l;
            } else {
                zzb.zzj("BillingClient", String.format("Bundle returned from %s contains null signatures list.", new Object[]{str2}));
                return iVar;
            }
        }
    }
}
