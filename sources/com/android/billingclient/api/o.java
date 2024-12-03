package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzu;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final String f8959a;

    /* renamed from: b  reason: collision with root package name */
    private final org.json.b f8960b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8961c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8962d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8963e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8964f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8965g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8966h;

    /* renamed from: i  reason: collision with root package name */
    private final String f8967i;

    /* renamed from: j  reason: collision with root package name */
    private final String f8968j;

    /* renamed from: k  reason: collision with root package name */
    private final String f8969k;

    /* renamed from: l  reason: collision with root package name */
    private final List f8970l;

    /* renamed from: m  reason: collision with root package name */
    private final List f8971m;

    /* renamed from: n  reason: collision with root package name */
    private final a1 f8972n;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f8973a;

        /* renamed from: b  reason: collision with root package name */
        private final long f8974b;

        /* renamed from: c  reason: collision with root package name */
        private final String f8975c;

        /* renamed from: d  reason: collision with root package name */
        private final String f8976d;

        /* renamed from: e  reason: collision with root package name */
        private final String f8977e;

        /* renamed from: f  reason: collision with root package name */
        private final zzu f8978f;

        a(org.json.b bVar) throws JSONException {
            this.f8973a = bVar.optString("formattedPrice");
            this.f8974b = bVar.optLong("priceAmountMicros");
            this.f8975c = bVar.optString("priceCurrencyCode");
            this.f8976d = bVar.optString("offerIdToken");
            this.f8977e = bVar.optString("offerId");
            bVar.optInt("offerType");
            org.json.a optJSONArray = bVar.optJSONArray("offerTags");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.o(); i10++) {
                    arrayList.add(optJSONArray.n(i10));
                }
            }
            this.f8978f = zzu.zzj(arrayList);
        }

        @NonNull
        public String a() {
            return this.f8973a;
        }

        public long b() {
            return this.f8974b;
        }

        @NonNull
        public String c() {
            return this.f8975c;
        }

        @NonNull
        public final String d() {
            return this.f8976d;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f8979a;

        /* renamed from: b  reason: collision with root package name */
        private final long f8980b;

        /* renamed from: c  reason: collision with root package name */
        private final String f8981c;

        /* renamed from: d  reason: collision with root package name */
        private final String f8982d;

        /* renamed from: e  reason: collision with root package name */
        private final int f8983e;

        /* renamed from: f  reason: collision with root package name */
        private final int f8984f;

        b(org.json.b bVar) {
            this.f8982d = bVar.optString("billingPeriod");
            this.f8981c = bVar.optString("priceCurrencyCode");
            this.f8979a = bVar.optString("formattedPrice");
            this.f8980b = bVar.optLong("priceAmountMicros");
            this.f8984f = bVar.optInt("recurrenceMode");
            this.f8983e = bVar.optInt("billingCycleCount");
        }

        @NonNull
        public String a() {
            return this.f8979a;
        }

        public long b() {
            return this.f8980b;
        }

        @NonNull
        public String c() {
            return this.f8981c;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f8985a;

        c(org.json.a aVar) {
            ArrayList arrayList = new ArrayList();
            if (aVar != null) {
                for (int i10 = 0; i10 < aVar.o(); i10++) {
                    org.json.b s10 = aVar.s(i10);
                    if (s10 != null) {
                        arrayList.add(new b(s10));
                    }
                }
            }
            this.f8985a = arrayList;
        }

        @NonNull
        public List<b> a() {
            return this.f8985a;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f8986a;

        /* renamed from: b  reason: collision with root package name */
        private final String f8987b;

        /* renamed from: c  reason: collision with root package name */
        private final String f8988c;

        /* renamed from: d  reason: collision with root package name */
        private final c f8989d;

        /* renamed from: e  reason: collision with root package name */
        private final List f8990e;

        /* renamed from: f  reason: collision with root package name */
        private final z0 f8991f;

        d(org.json.b bVar) throws JSONException {
            this.f8986a = bVar.optString("basePlanId");
            String optString = bVar.optString("offerId");
            z0 z0Var = null;
            this.f8987b = true == optString.isEmpty() ? null : optString;
            this.f8988c = bVar.getString("offerIdToken");
            this.f8989d = new c(bVar.getJSONArray("pricingPhases"));
            org.json.b optJSONObject = bVar.optJSONObject("installmentPlanDetails");
            this.f8991f = optJSONObject != null ? new z0(optJSONObject) : z0Var;
            ArrayList arrayList = new ArrayList();
            org.json.a optJSONArray = bVar.optJSONArray("offerTags");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.o(); i10++) {
                    arrayList.add(optJSONArray.n(i10));
                }
            }
            this.f8990e = arrayList;
        }

        @NonNull
        public String a() {
            return this.f8988c;
        }

        @NonNull
        public c b() {
            return this.f8989d;
        }
    }

    o(String str) throws JSONException {
        ArrayList arrayList;
        this.f8959a = str;
        org.json.b bVar = new org.json.b(str);
        this.f8960b = bVar;
        String optString = bVar.optString("productId");
        this.f8961c = optString;
        String optString2 = bVar.optString("type");
        this.f8962d = optString2;
        if (TextUtils.isEmpty(optString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        } else if (!TextUtils.isEmpty(optString2)) {
            this.f8963e = bVar.optString("title");
            this.f8964f = bVar.optString("name");
            this.f8965g = bVar.optString("description");
            this.f8967i = bVar.optString("packageDisplayName");
            this.f8968j = bVar.optString("iconUrl");
            this.f8966h = bVar.optString("skuDetailsToken");
            this.f8969k = bVar.optString("serializedDocid");
            org.json.a optJSONArray = bVar.optJSONArray("subscriptionOfferDetails");
            if (optJSONArray != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i10 = 0; i10 < optJSONArray.o(); i10++) {
                    arrayList2.add(new d(optJSONArray.j(i10)));
                }
                this.f8970l = arrayList2;
            } else {
                if (optString2.equals("subs") || optString2.equals("play_pass_subs")) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = null;
                }
                this.f8970l = arrayList;
            }
            org.json.b optJSONObject = this.f8960b.optJSONObject("oneTimePurchaseOfferDetails");
            org.json.a optJSONArray2 = this.f8960b.optJSONArray("oneTimePurchaseOfferDetailsList");
            ArrayList arrayList3 = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i11 = 0; i11 < optJSONArray2.o(); i11++) {
                    arrayList3.add(new a(optJSONArray2.j(i11)));
                }
                this.f8971m = arrayList3;
            } else if (optJSONObject != null) {
                arrayList3.add(new a(optJSONObject));
                this.f8971m = arrayList3;
            } else {
                this.f8971m = null;
            }
            org.json.b optJSONObject2 = this.f8960b.optJSONObject("limitedQuantityInfo");
            if (optJSONObject2 != null) {
                this.f8972n = new a1(optJSONObject2);
            } else {
                this.f8972n = null;
            }
        } else {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
    }

    public a a() {
        List list = this.f8971m;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (a) this.f8971m.get(0);
    }

    @NonNull
    public String b() {
        return this.f8961c;
    }

    @NonNull
    public String c() {
        return this.f8962d;
    }

    public List<d> d() {
        return this.f8970l;
    }

    @NonNull
    public final String e() {
        return this.f8960b.optString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        return TextUtils.equals(this.f8959a, ((o) obj).f8959a);
    }

    /* access modifiers changed from: package-private */
    public final String f() {
        return this.f8966h;
    }

    public String g() {
        return this.f8969k;
    }

    public int hashCode() {
        return this.f8959a.hashCode();
    }

    @NonNull
    public String toString() {
        String str = this.f8959a;
        String obj = this.f8960b.toString();
        String str2 = this.f8961c;
        String str3 = this.f8962d;
        String str4 = this.f8963e;
        String str5 = this.f8966h;
        String valueOf = String.valueOf(this.f8970l);
        return "ProductDetails{jsonString='" + str + "', parsedJson=" + obj + ", productId='" + str2 + "', productType='" + str3 + "', title='" + str4 + "', productDetailsToken='" + str5 + "', subscriptionOfferDetails=" + valueOf + "}";
    }
}
