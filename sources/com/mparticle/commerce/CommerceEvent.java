package com.mparticle.commerce;

import androidx.annotation.NonNull;
import com.mparticle.BaseEvent;
import com.mparticle.commerce.Product;
import com.mparticle.d;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.kits.ReportingMessage;
import com.mparticle.t;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.b;

public final class CommerceEvent extends BaseEvent {
    private String mCheckoutOptions;
    private Integer mCheckoutStep;
    private String mCurrency;
    private String mEventName;
    private List<Impression> mImpressions;
    /* access modifiers changed from: private */
    public Boolean mNonIteraction;
    private String mProductAction;
    private String mProductListName;
    private String mProductListSource;
    private String mPromotionAction;
    /* access modifiers changed from: private */
    public String mScreen;
    private TransactionAttributes mTransactionAttributes;
    private List<Product> productList;
    private List<Promotion> promotionList;

    public boolean equals(Object obj) {
        return obj != null && obj.toString().equals(toString());
    }

    public String getCheckoutOptions() {
        return this.mCheckoutOptions;
    }

    public Integer getCheckoutStep() {
        return this.mCheckoutStep;
    }

    public String getCurrency() {
        return this.mCurrency;
    }

    public String getEventName() {
        return this.mEventName;
    }

    public List<Impression> getImpressions() {
        List<Impression> list = this.mImpressions;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public d getMessage() {
        return new t.a(this).a(getCustomFlags());
    }

    public Boolean getNonInteraction() {
        return this.mNonIteraction;
    }

    public String getProductAction() {
        return this.mProductAction;
    }

    public String getProductListName() {
        return this.mProductListName;
    }

    public String getProductListSource() {
        return this.mProductListSource;
    }

    public List<Product> getProducts() {
        List<Product> list = this.productList;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String getPromotionAction() {
        return this.mPromotionAction;
    }

    public List<Promotion> getPromotions() {
        List<Promotion> list = this.promotionList;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String getScreen() {
        return this.mScreen;
    }

    public TransactionAttributes getTransactionAttributes() {
        return this.mTransactionAttributes;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @NonNull
    public String toString() {
        try {
            b bVar = new b();
            String str = this.mScreen;
            if (str != null) {
                bVar.put("sn", (Object) str);
            }
            Boolean bool = this.mNonIteraction;
            if (bool != null) {
                bVar.put("ni", bool.booleanValue());
            }
            int i10 = 0;
            if (this.mProductAction != null) {
                b bVar2 = new b();
                bVar.put("pd", (Object) bVar2);
                bVar2.put("an", (Object) this.mProductAction);
                Integer num = this.mCheckoutStep;
                if (num != null) {
                    bVar2.put("cs", (Object) num);
                }
                String str2 = this.mCheckoutOptions;
                if (str2 != null) {
                    bVar2.put("co", (Object) str2);
                }
                String str3 = this.mProductListName;
                if (str3 != null) {
                    bVar2.put("pal", (Object) str3);
                }
                String str4 = this.mProductListSource;
                if (str4 != null) {
                    bVar2.put("pls", (Object) str4);
                }
                TransactionAttributes transactionAttributes = this.mTransactionAttributes;
                if (transactionAttributes != null) {
                    if (transactionAttributes.getId() != null) {
                        bVar2.put("ti", (Object) this.mTransactionAttributes.getId());
                    }
                    if (this.mTransactionAttributes.getAffiliation() != null) {
                        bVar2.put("ta", (Object) this.mTransactionAttributes.getAffiliation());
                    }
                    if (this.mTransactionAttributes.getRevenue() != null) {
                        bVar2.put("tr", (Object) this.mTransactionAttributes.getRevenue());
                    }
                    if (this.mTransactionAttributes.getTax() != null) {
                        bVar2.put("tt", (Object) this.mTransactionAttributes.getTax());
                    }
                    if (this.mTransactionAttributes.getShipping() != null) {
                        bVar2.put("ts", (Object) this.mTransactionAttributes.getShipping());
                    }
                    if (this.mTransactionAttributes.getCouponCode() != null) {
                        bVar2.put("tcc", (Object) this.mTransactionAttributes.getCouponCode());
                    }
                }
                List<Product> list = this.productList;
                if (list != null && list.size() > 0) {
                    org.json.a aVar = new org.json.a();
                    while (i10 < this.productList.size()) {
                        aVar.E(new b(this.productList.get(i10).toString()));
                        i10++;
                    }
                    bVar2.put("pl", (Object) aVar);
                }
            } else {
                b bVar3 = new b();
                bVar.put(ReportingMessage.MessageType.PUSH_RECEIVED, (Object) bVar3);
                bVar3.put("an", (Object) this.mPromotionAction);
                List<Promotion> list2 = this.promotionList;
                if (list2 != null && list2.size() > 0) {
                    org.json.a aVar2 = new org.json.a();
                    while (i10 < this.promotionList.size()) {
                        aVar2.E(new b(this.promotionList.get(i10).toString()));
                        i10++;
                    }
                    bVar3.put("pl", (Object) aVar2);
                }
            }
            List<Impression> list3 = this.mImpressions;
            if (list3 != null && list3.size() > 0) {
                org.json.a aVar3 = new org.json.a();
                for (Impression next : this.mImpressions) {
                    b bVar4 = new b();
                    if (next.getListName() != null) {
                        bVar4.put("pil", (Object) next.getListName());
                    }
                    if (next.getProducts() != null && next.getProducts().size() > 0) {
                        org.json.a aVar4 = new org.json.a();
                        bVar4.put("pl", (Object) aVar4);
                        for (Product product : next.getProducts()) {
                            aVar4.E(new b(product.toString()));
                        }
                    }
                    if (bVar4.length() > 0) {
                        aVar3.E(bVar4);
                    }
                }
                if (aVar3.o() > 0) {
                    bVar.put("pi", (Object) aVar3);
                }
            }
            return bVar.toString();
        } catch (JSONException unused) {
            return super.toString();
        }
    }

    private CommerceEvent(Builder builder) {
        super(BaseEvent.Type.COMMERCE_EVENT);
        TransactionAttributes transactionAttributes;
        List<Impression> list;
        this.mProductAction = builder.mProductAction;
        this.mPromotionAction = builder.mPromotionAction;
        setCustomAttributes(builder.customAttributes);
        if (!MPUtility.isEmpty((Collection) builder.promotionList)) {
            builder.promotionList.removeAll(Collections.singleton((Object) null));
        }
        this.promotionList = builder.promotionList;
        if (!MPUtility.isEmpty((Collection) builder.productList)) {
            LinkedList linkedList = new LinkedList(builder.productList);
            this.productList = linkedList;
            linkedList.removeAll(Collections.singleton((Object) null));
        }
        this.mCheckoutStep = builder.mCheckoutStep;
        this.mCheckoutOptions = builder.mCheckoutOptions;
        this.mProductListName = builder.mProductListName;
        this.mProductListSource = builder.mProductListSource;
        this.mCurrency = builder.mCurrency;
        this.mTransactionAttributes = builder.mTransactionAttributes;
        this.mScreen = builder.mScreen;
        this.mImpressions = builder.mImpressions;
        this.mNonIteraction = builder.mNonIteraction;
        this.mEventName = builder.mEventName;
        if (builder.mCustomFlags != null) {
            setCustomFlags(builder.mCustomFlags);
        }
        if (builder.mShouldUploadEvent != null) {
            setShouldUploadEvent(builder.mShouldUploadEvent.booleanValue());
        }
        if (MPUtility.isEmpty((CharSequence) this.mProductAction) && MPUtility.isEmpty((CharSequence) this.mPromotionAction) && ((list = this.mImpressions) == null || list.size() == 0)) {
            Logger.error("CommerceEvent must be created with either a product action, promotion action, or an impression.");
        }
        String str = this.mProductAction;
        if (str != null) {
            if ((str.equalsIgnoreCase("purchase") || this.mProductAction.equalsIgnoreCase("refund")) && ((transactionAttributes = this.mTransactionAttributes) == null || MPUtility.isEmpty((CharSequence) transactionAttributes.getId()))) {
                Logger.error("CommerceEvent with action " + this.mProductAction + " must include a TransactionAttributes object with a transaction ID.");
            }
            List<Promotion> list2 = this.promotionList;
            if (list2 != null && list2.size() > 0) {
                Logger.error("Product CommerceEvent should not contain Promotions.");
            }
            if (!this.mProductAction.equals("add_to_cart") && !this.mProductAction.equals("add_to_wishlist") && !this.mProductAction.equals(Product.CHECKOUT) && !this.mProductAction.equals(Product.CHECKOUT_OPTION) && !this.mProductAction.equals("click") && !this.mProductAction.equals(Product.DETAIL) && !this.mProductAction.equals("purchase") && !this.mProductAction.equals("refund") && !this.mProductAction.equals("remove_from_cart") && !this.mProductAction.equals(Product.REMOVE_FROM_WISHLIST)) {
                Logger.error("CommerceEvent created with unrecognized Product action: " + this.mProductAction);
            }
        } else if (this.mPromotionAction != null) {
            List<Product> list3 = this.productList;
            if (list3 != null && list3.size() > 0) {
                Logger.error("Promotion CommerceEvent should not contain Products.");
            }
            if (!this.mPromotionAction.equals("view") && !this.mPromotionAction.equals("click")) {
                Logger.error("CommerceEvent created with unrecognized Promotion action: " + this.mProductAction);
            }
        } else {
            List<Product> list4 = this.productList;
            if (list4 != null && list4.size() > 0) {
                Logger.error("Impression CommerceEvent should not contain Products.");
            }
            List<Promotion> list5 = this.promotionList;
            if (list5 != null && list5.size() > 0) {
                Logger.error("Impression CommerceEvent should not contain Promotions.");
            }
        }
        TransactionAttributes transactionAttributes2 = this.mTransactionAttributes;
        if (transactionAttributes2 == null || transactionAttributes2.getRevenue() == null) {
            TransactionAttributes transactionAttributes3 = this.mTransactionAttributes;
            double d10 = 0.0d;
            if (transactionAttributes3 == null) {
                this.mTransactionAttributes = new TransactionAttributes();
            } else {
                Double shipping = transactionAttributes3.getShipping();
                Double tax = this.mTransactionAttributes.getTax();
                d10 = (tax != null ? tax.doubleValue() : d10) + (shipping != null ? shipping.doubleValue() : 0.0d) + 0.0d;
            }
            List<Product> list6 = this.productList;
            if (list6 != null) {
                for (Product next : list6) {
                    if (next != null) {
                        d10 += next.getUnitPrice() * next.getQuantity();
                    }
                }
            }
            this.mTransactionAttributes.setRevenue(Double.valueOf(d10));
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Map<String, String> customAttributes;
        /* access modifiers changed from: private */
        public String mCheckoutOptions;
        /* access modifiers changed from: private */
        public Integer mCheckoutStep;
        /* access modifiers changed from: private */
        public String mCurrency;
        /* access modifiers changed from: private */
        public Map<String, List<String>> mCustomFlags;
        /* access modifiers changed from: private */
        public String mEventName;
        /* access modifiers changed from: private */
        public List<Impression> mImpressions;
        /* access modifiers changed from: private */
        public Boolean mNonIteraction;
        String mProductAction;
        /* access modifiers changed from: private */
        public String mProductListName;
        /* access modifiers changed from: private */
        public String mProductListSource;
        String mPromotionAction;
        /* access modifiers changed from: private */
        public String mScreen;
        /* access modifiers changed from: private */
        public Boolean mShouldUploadEvent;
        /* access modifiers changed from: private */
        public TransactionAttributes mTransactionAttributes;
        /* access modifiers changed from: private */
        public List<Product> productList;
        /* access modifiers changed from: private */
        public List<Promotion> promotionList;

        Builder() {
            this.customAttributes = null;
            this.promotionList = null;
            this.productList = null;
            this.mCheckoutStep = null;
            this.mCheckoutOptions = null;
            this.mProductListName = null;
            this.mProductListSource = null;
            this.mCurrency = null;
            this.mTransactionAttributes = null;
            this.mScreen = null;
            this.mCustomFlags = null;
            this.mShouldUploadEvent = null;
            this.mPromotionAction = null;
            this.mProductAction = null;
        }

        @NonNull
        public Builder addCustomFlag(String str, String str2) {
            if (this.mCustomFlags == null) {
                this.mCustomFlags = new HashMap();
            }
            if (!this.mCustomFlags.containsKey(str)) {
                this.mCustomFlags.put(str, new LinkedList());
            }
            this.mCustomFlags.get(str).add(str2);
            return this;
        }

        @NonNull
        public Builder addImpression(@NonNull Impression impression) {
            if (impression != null) {
                if (this.mImpressions == null) {
                    this.mImpressions = new LinkedList();
                }
                this.mImpressions.add(impression);
            }
            return this;
        }

        @NonNull
        public Builder addProduct(Product product) {
            if (this.productList == null) {
                this.productList = new LinkedList();
            }
            this.productList.add(product);
            return this;
        }

        @NonNull
        public Builder addPromotion(@NonNull Promotion promotion) {
            if (this.promotionList == null) {
                this.promotionList = new LinkedList();
            }
            this.promotionList.add(promotion);
            return this;
        }

        @NonNull
        public CommerceEvent build() {
            return new CommerceEvent(this);
        }

        @NonNull
        public Builder checkoutOptions(String str) {
            this.mCheckoutOptions = str;
            return this;
        }

        @NonNull
        public Builder checkoutStep(Integer num) {
            if (num == null || num.intValue() >= 0) {
                this.mCheckoutStep = num;
            }
            return this;
        }

        @NonNull
        public Builder currency(String str) {
            this.mCurrency = str;
            return this;
        }

        @NonNull
        public Builder customAttributes(Map<String, String> map) {
            this.customAttributes = map;
            return this;
        }

        @NonNull
        public Builder customFlags(Map<String, List<String>> map) {
            this.mCustomFlags = map;
            return this;
        }

        @NonNull
        public Builder impressions(@NonNull List<Impression> list) {
            this.mImpressions = list;
            return this;
        }

        @NonNull
        public Builder internalEventName(String str) {
            this.mEventName = str;
            return this;
        }

        @NonNull
        public Builder nonInteraction(boolean z10) {
            this.mNonIteraction = Boolean.valueOf(z10);
            return this;
        }

        @NonNull
        public Builder productListName(String str) {
            this.mProductListName = str;
            return this;
        }

        @NonNull
        public Builder productListSource(String str) {
            this.mProductListSource = str;
            return this;
        }

        @NonNull
        public Builder products(@NonNull List<Product> list) {
            this.productList = list;
            return this;
        }

        @NonNull
        public Builder promotions(@NonNull List<Promotion> list) {
            this.promotionList = list;
            return this;
        }

        @NonNull
        public Builder screen(String str) {
            this.mScreen = str;
            return this;
        }

        @NonNull
        public Builder shouldUploadEvent(boolean z10) {
            this.mShouldUploadEvent = Boolean.valueOf(z10);
            return this;
        }

        @NonNull
        public Builder transactionAttributes(@NonNull TransactionAttributes transactionAttributes) {
            this.mTransactionAttributes = transactionAttributes;
            return this;
        }

        public Builder(@NonNull String str, Product product) {
            this.customAttributes = null;
            this.promotionList = null;
            this.productList = null;
            this.mCheckoutStep = null;
            this.mCheckoutOptions = null;
            this.mProductListName = null;
            this.mProductListSource = null;
            this.mCurrency = null;
            this.mTransactionAttributes = null;
            this.mScreen = null;
            this.mCustomFlags = null;
            this.mShouldUploadEvent = null;
            this.mProductAction = str;
            this.mPromotionAction = null;
            addProduct(product);
        }

        public Builder(@NonNull String str, @NonNull Promotion promotion) {
            this.customAttributes = null;
            this.promotionList = null;
            this.productList = null;
            this.mCheckoutStep = null;
            this.mCheckoutOptions = null;
            this.mProductListName = null;
            this.mProductListSource = null;
            this.mCurrency = null;
            this.mTransactionAttributes = null;
            this.mScreen = null;
            this.mCustomFlags = null;
            this.mShouldUploadEvent = null;
            this.mProductAction = null;
            this.mPromotionAction = str;
            addPromotion(promotion);
        }

        public Builder(@NonNull Impression impression) {
            this.customAttributes = null;
            this.promotionList = null;
            this.productList = null;
            this.mCheckoutStep = null;
            this.mCheckoutOptions = null;
            this.mProductListName = null;
            this.mProductListSource = null;
            this.mCurrency = null;
            this.mTransactionAttributes = null;
            this.mScreen = null;
            this.mCustomFlags = null;
            this.mShouldUploadEvent = null;
            addImpression(impression);
            this.mPromotionAction = null;
            this.mProductAction = null;
        }

        public Builder(@NonNull CommerceEvent commerceEvent) {
            this.customAttributes = null;
            this.promotionList = null;
            this.productList = null;
            this.mCheckoutStep = null;
            this.mCheckoutOptions = null;
            this.mProductListName = null;
            this.mProductListSource = null;
            this.mCurrency = null;
            this.mTransactionAttributes = null;
            this.mScreen = null;
            this.mCustomFlags = null;
            this.mShouldUploadEvent = null;
            this.mProductAction = commerceEvent.getProductAction();
            this.mPromotionAction = commerceEvent.getPromotionAction();
            if (commerceEvent.getCustomAttributeStrings() != null) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(commerceEvent.getCustomAttributeStrings());
                this.customAttributes = hashMap;
            }
            if (commerceEvent.getPromotions() != null) {
                for (Promotion promotion : commerceEvent.getPromotions()) {
                    addPromotion(new Promotion(promotion));
                }
            }
            if (commerceEvent.getProducts() != null) {
                for (Product builder : commerceEvent.getProducts()) {
                    addProduct(new Product.Builder(builder).build());
                }
            }
            this.mCheckoutStep = commerceEvent.getCheckoutStep();
            this.mCheckoutOptions = commerceEvent.getCheckoutOptions();
            this.mProductListName = commerceEvent.getProductListName();
            this.mProductListSource = commerceEvent.getProductListSource();
            this.mCurrency = commerceEvent.getCurrency();
            if (commerceEvent.getTransactionAttributes() != null) {
                this.mTransactionAttributes = new TransactionAttributes(commerceEvent.getTransactionAttributes());
            }
            this.mScreen = commerceEvent.mScreen;
            this.mNonIteraction = commerceEvent.mNonIteraction;
            if (commerceEvent.getImpressions() != null) {
                for (Impression impression : commerceEvent.getImpressions()) {
                    addImpression(new Impression(impression));
                }
            }
            this.mEventName = commerceEvent.getEventName();
            this.mCustomFlags = commerceEvent.getCustomFlags();
            this.mShouldUploadEvent = Boolean.valueOf(commerceEvent.isShouldUploadEvent());
        }
    }

    private CommerceEvent() {
        super(BaseEvent.Type.COMMERCE_EVENT);
    }
}
