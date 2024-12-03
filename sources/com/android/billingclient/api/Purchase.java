package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class Purchase {

    /* renamed from: a  reason: collision with root package name */
    private final String f8852a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8853b;

    /* renamed from: c  reason: collision with root package name */
    private final b f8854c;

    public Purchase(@NonNull String str, @NonNull String str2) throws JSONException {
        this.f8852a = str;
        this.f8853b = str2;
        this.f8854c = new b(str);
    }

    private final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        if (this.f8854c.has("productIds")) {
            a optJSONArray = this.f8854c.optJSONArray("productIds");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.o(); i10++) {
                    arrayList.add(optJSONArray.w(i10));
                }
            }
        } else if (this.f8854c.has("productId")) {
            arrayList.add(this.f8854c.optString("productId"));
        }
        return arrayList;
    }

    @NonNull
    public String a() {
        return this.f8852a;
    }

    @NonNull
    public List<String> b() {
        return h();
    }

    public int c() {
        return this.f8854c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    @NonNull
    public String d() {
        b bVar = this.f8854c;
        return bVar.optString("token", bVar.optString(SDKConstants.PARAM_PURCHASE_TOKEN));
    }

    @NonNull
    public String e() {
        return this.f8853b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        if (!TextUtils.equals(this.f8852a, purchase.a()) || !TextUtils.equals(this.f8853b, purchase.e())) {
            return false;
        }
        return true;
    }

    @NonNull
    @Deprecated
    public ArrayList<String> f() {
        return h();
    }

    public boolean g() {
        return this.f8854c.optBoolean("acknowledged", true);
    }

    public int hashCode() {
        return this.f8852a.hashCode();
    }

    @NonNull
    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f8852a));
    }
}
