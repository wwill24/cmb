package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class PurchaseHistoryRecord {

    /* renamed from: a  reason: collision with root package name */
    private final String f8855a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8856b;

    /* renamed from: c  reason: collision with root package name */
    private final b f8857c;

    public PurchaseHistoryRecord(@NonNull String str, @NonNull String str2) throws JSONException {
        this.f8855a = str;
        this.f8856b = str2;
        this.f8857c = new b(str);
    }

    private final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        if (this.f8857c.has("productIds")) {
            a optJSONArray = this.f8857c.optJSONArray("productIds");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.o(); i10++) {
                    arrayList.add(optJSONArray.w(i10));
                }
            }
        } else if (this.f8857c.has("productId")) {
            arrayList.add(this.f8857c.optString("productId"));
        }
        return arrayList;
    }

    @NonNull
    public String a() {
        return this.f8855a;
    }

    @NonNull
    public String b() {
        b bVar = this.f8857c;
        return bVar.optString("token", bVar.optString(SDKConstants.PARAM_PURCHASE_TOKEN));
    }

    @NonNull
    public String c() {
        return this.f8856b;
    }

    @NonNull
    @Deprecated
    public ArrayList<String> d() {
        return e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseHistoryRecord)) {
            return false;
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
        if (!TextUtils.equals(this.f8855a, purchaseHistoryRecord.a()) || !TextUtils.equals(this.f8856b, purchaseHistoryRecord.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f8855a.hashCode();
    }

    @NonNull
    public String toString() {
        return "PurchaseHistoryRecord. Json: ".concat(String.valueOf(this.f8855a));
    }
}
