package com.mparticle.commerce;

import androidx.annotation.NonNull;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.kits.ReportingMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONException;

public final class Product {
    @NonNull
    public static final String ADD_TO_CART = "add_to_cart";
    @NonNull
    public static final String ADD_TO_WISHLIST = "add_to_wishlist";
    @NonNull
    public static final String CHECKOUT = "checkout";
    @NonNull
    public static final String CHECKOUT_OPTION = "checkout_option";
    @NonNull
    public static final String CLICK = "click";
    @NonNull
    public static final String DETAIL = "view_detail";
    @NonNull
    public static final String PURCHASE = "purchase";
    @NonNull
    public static final String REFUND = "refund";
    @NonNull
    public static final String REMOVE_FROM_CART = "remove_from_cart";
    @NonNull
    public static final String REMOVE_FROM_WISHLIST = "remove_from_wishlist";
    private static EqualityComparator mComparator = new b();
    /* access modifiers changed from: private */
    public String mBrand;
    /* access modifiers changed from: private */
    public String mCategory;
    /* access modifiers changed from: private */
    public String mCouponCode;
    private Map<String, String> mCustomAttributes;
    private String mName;
    /* access modifiers changed from: private */
    public Integer mPosition;
    /* access modifiers changed from: private */
    public double mPrice;
    /* access modifiers changed from: private */
    public double mQuantity;
    private String mSku;
    protected long mTimeAdded;
    /* access modifiers changed from: private */
    public String mVariant;

    public interface EqualityComparator {
        boolean equals(Product product, Product product2);
    }

    static class b implements EqualityComparator {
        b() {
        }

        public boolean equals(Product product, Product product2) {
            if (product == null || product2 == null) {
                return false;
            }
            return product.toString().equals(product2.toString());
        }
    }

    static Product fromJson(org.json.b bVar) {
        try {
            Builder builder = new Builder(bVar.getString("nm"), bVar.optString("id", (String) null), bVar.optDouble(ReportingMessage.MessageType.PUSH_REGISTRATION, 0.0d));
            builder.category(bVar.optString("ca", (String) null));
            builder.couponCode(bVar.optString("cc", (String) null));
            if (bVar.has("ps")) {
                builder.position(Integer.valueOf(bVar.optInt("ps", 0)));
            }
            if (bVar.has("qt")) {
                builder.quantity(bVar.optDouble("qt", 1.0d));
            }
            builder.brand(bVar.optString(XHTMLText.BR, (String) null));
            builder.variant(bVar.optString("va", (String) null));
            if (bVar.has("attrs")) {
                org.json.b jSONObject = bVar.getJSONObject("attrs");
                if (jSONObject.length() > 0) {
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.getString(next));
                    }
                    builder.customAttributes(hashMap);
                }
            }
            Product build = builder.build();
            build.mTimeAdded = bVar.optLong("act", 0);
            return build;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static Product fromString(@NonNull String str) {
        try {
            return fromJson(new org.json.b(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void setEqualityComparator(EqualityComparator equalityComparator) {
        if (equalityComparator == null) {
            mComparator = new b();
        } else {
            mComparator = equalityComparator;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        EqualityComparator equalityComparator = mComparator;
        if (equalityComparator == null) {
            return false;
        }
        return equalityComparator.equals(this, product);
    }

    public String getBrand() {
        return this.mBrand;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getCouponCode() {
        return this.mCouponCode;
    }

    public Map<String, String> getCustomAttributes() {
        return this.mCustomAttributes;
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public double getQuantity() {
        double d10 = this.mQuantity;
        if (d10 < 1.0d) {
            return 1.0d;
        }
        return d10;
    }

    @NonNull
    public String getSku() {
        return this.mSku;
    }

    public double getTotalAmount() {
        return getUnitPrice() * getQuantity();
    }

    public double getUnitPrice() {
        return this.mPrice;
    }

    public String getVariant() {
        return this.mVariant;
    }

    /* access modifiers changed from: package-private */
    public void setQuantity(double d10) {
        this.mQuantity = d10;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public org.json.b toJson() {
        try {
            org.json.b bVar = new org.json.b();
            String str = this.mName;
            if (str != null) {
                bVar.put("nm", (Object) str);
            }
            String str2 = this.mCategory;
            if (str2 != null) {
                bVar.put("ca", (Object) str2);
            }
            String str3 = this.mCouponCode;
            if (str3 != null) {
                bVar.put("cc", (Object) str3);
            }
            String str4 = this.mSku;
            if (str4 != null) {
                bVar.put("id", (Object) str4);
            }
            Integer num = this.mPosition;
            if (num != null) {
                bVar.put("ps", (Object) num);
            }
            bVar.put(ReportingMessage.MessageType.PUSH_REGISTRATION, this.mPrice);
            bVar.put("qt", this.mQuantity);
            bVar.put("act", this.mTimeAdded);
            bVar.put("tpa", getTotalAmount());
            String str5 = this.mBrand;
            if (str5 != null) {
                bVar.put(XHTMLText.BR, (Object) str5);
            }
            String str6 = this.mVariant;
            if (str6 != null) {
                bVar.put("va", (Object) str6);
            }
            Map<String, String> map = this.mCustomAttributes;
            if (map != null && map.size() > 0) {
                org.json.b bVar2 = new org.json.b();
                for (Map.Entry next : this.mCustomAttributes.entrySet()) {
                    bVar2.put((String) next.getKey(), next.getValue());
                }
                bVar.put("attrs", (Object) bVar2);
            }
            return bVar;
        } catch (JSONException unused) {
            return new org.json.b();
        }
    }

    @NonNull
    public String toString() {
        return toJson().toString();
    }

    /* access modifiers changed from: package-private */
    public void updateTimeAdded() {
        this.mTimeAdded = System.currentTimeMillis();
    }

    private Product() {
        this.mName = null;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String mBrand;
        /* access modifiers changed from: private */
        public String mCategory;
        /* access modifiers changed from: private */
        public String mCouponCode;
        /* access modifiers changed from: private */
        public Map<String, String> mCustomAttributes;
        /* access modifiers changed from: private */
        public String mName;
        /* access modifiers changed from: private */
        public Integer mPosition;
        /* access modifiers changed from: private */
        public double mPrice;
        /* access modifiers changed from: private */
        public double mQuantity;
        /* access modifiers changed from: private */
        public String mSku;
        /* access modifiers changed from: private */
        public String mVariant;

        Builder() {
            this.mName = null;
            this.mQuantity = 1.0d;
            this.mCustomAttributes = null;
        }

        @NonNull
        public Builder brand(String str) {
            this.mBrand = str;
            return this;
        }

        @NonNull
        public Product build() {
            return new Product(this);
        }

        @NonNull
        public Builder category(String str) {
            this.mCategory = str;
            return this;
        }

        @NonNull
        public Builder couponCode(String str) {
            this.mCouponCode = str;
            return this;
        }

        @NonNull
        public Builder customAttributes(Map<String, String> map) {
            this.mCustomAttributes = map;
            return this;
        }

        @NonNull
        public Builder name(@NonNull String str) {
            this.mName = str;
            return this;
        }

        @NonNull
        public Builder position(Integer num) {
            this.mPosition = num;
            return this;
        }

        @NonNull
        public Builder quantity(double d10) {
            this.mQuantity = d10;
            return this;
        }

        @NonNull
        public Builder sku(@NonNull String str) {
            this.mSku = str;
            return this;
        }

        @NonNull
        public Builder unitPrice(double d10) {
            this.mPrice = d10;
            return this;
        }

        @NonNull
        public Builder variant(String str) {
            this.mVariant = str;
            return this;
        }

        public Builder(@NonNull String str, @NonNull String str2, double d10) {
            this.mQuantity = 1.0d;
            this.mCustomAttributes = null;
            this.mName = str;
            this.mSku = str2;
            this.mPrice = d10;
        }

        public Builder(@NonNull Product product) {
            this(product.getName(), product.getSku(), product.getUnitPrice());
            this.mCategory = product.mCategory;
            this.mCouponCode = product.mCouponCode;
            this.mPosition = product.mPosition;
            this.mPrice = product.mPrice;
            this.mQuantity = product.mQuantity;
            this.mBrand = product.mBrand;
            this.mVariant = product.mVariant;
            if (product.getCustomAttributes() != null) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(product.getCustomAttributes());
                this.mCustomAttributes = hashMap;
            }
        }
    }

    private Product(Builder builder) {
        this.mName = null;
        this.mName = builder.mName;
        this.mCategory = builder.mCategory;
        this.mCouponCode = builder.mCouponCode;
        this.mSku = builder.mSku;
        this.mPosition = builder.mPosition;
        this.mPrice = builder.mPrice;
        this.mQuantity = builder.mQuantity;
        this.mBrand = builder.mBrand;
        this.mVariant = builder.mVariant;
        this.mCustomAttributes = builder.mCustomAttributes;
        updateTimeAdded();
        if (MPUtility.isEmpty((CharSequence) this.mName)) {
            this.mName = "Unknown";
            Logger.error("Product name is required.");
        } else if (MPUtility.isEmpty((CharSequence) this.mSku)) {
            this.mSku = "Unknown";
            Logger.error("Product SKU is required.");
        }
    }
}
