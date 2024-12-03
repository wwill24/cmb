package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import org.json.b;

@Deprecated
public class SkuDetails {

    /* renamed from: a  reason: collision with root package name */
    private final String f8858a;

    /* renamed from: b  reason: collision with root package name */
    private final b f8859b;

    @NonNull
    public String a() {
        return this.f8859b.optString("productId");
    }

    @NonNull
    public String b() {
        return this.f8859b.optString("type");
    }

    public int c() {
        return this.f8859b.optInt("offer_type");
    }

    @NonNull
    public String d() {
        return this.f8859b.optString("offer_id");
    }

    @NonNull
    public String e() {
        String optString = this.f8859b.optString("offerIdToken");
        if (optString.isEmpty()) {
            return this.f8859b.optString("offer_id_token");
        }
        return optString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuDetails)) {
            return false;
        }
        return TextUtils.equals(this.f8858a, ((SkuDetails) obj).f8858a);
    }

    @NonNull
    public final String f() {
        return this.f8859b.optString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
    }

    @NonNull
    public String g() {
        return this.f8859b.optString("serializedDocid");
    }

    /* access modifiers changed from: package-private */
    public final String h() {
        return this.f8859b.optString("skuDetailsToken");
    }

    public int hashCode() {
        return this.f8858a.hashCode();
    }

    @NonNull
    public String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.f8858a));
    }
}
