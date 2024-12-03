package com.mparticle.kits;

import android.util.SparseBooleanArray;
import com.facebook.appevents.AppEventsConstants;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.commerce.Impression;
import com.mparticle.commerce.Product;
import com.mparticle.commerce.Promotion;
import com.mparticle.commerce.TransactionAttributes;
import com.mparticle.consent.CCPAConsent;
import com.mparticle.consent.ConsentState;
import com.mparticle.consent.GDPRConsent;
import com.mparticle.identity.MParticleUser;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.kits.CommerceEventUtils;
import com.mparticle.kits.ReportingMessage;
import com.mparticle.kits.mappings.CustomMapping;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class KitConfiguration {
    private static final int ENTITY_PRODUCT = 1;
    private static final int ENTITY_PROMOTION = 2;
    private static final String HONOR_OPT_OUT = "honorOptOut";
    static final String KEY_ATTRIBUTE_VALUE_FILTERING = "avf";
    static final String KEY_ATTRIBUTE_VALUE_FILTERING_ATTRIBUTE = "a";
    private static final String KEY_ATTRIBUTE_VALUE_FILTERING_SHOULD_INCLUDE_MATCHES = "i";
    private static final String KEY_ATTRIBUTE_VALUE_FILTERING_VALUE = "v";
    private static final String KEY_BRACKETING = "bk";
    private static final String KEY_BRACKETING_HIGH = "hi";
    private static final String KEY_BRACKETING_LOW = "lo";
    private static final String KEY_COMMERCE_ATTRIBUTE_FILTER = "cea";
    private static final String KEY_COMMERCE_ENTITY_ATTRIBUTE_FILTERS = "afa";
    private static final String KEY_COMMERCE_ENTITY_FILTERS = "ent";
    private static final String KEY_CONSENT_FORWARDING_RULES = "crvf";
    static final String KEY_CONSENT_FORWARDING_RULES_ARRAY = "v";
    static final String KEY_CONSENT_FORWARDING_RULES_SHOULD_INCLUDE_MATCHES = "i";
    private static final String KEY_CONSENT_FORWARDING_RULES_VALUE_CONSENTED = "c";
    private static final String KEY_CONSENT_FORWARDING_RULES_VALUE_HASH = "h";
    static final String KEY_EVENT_ATTRIBUTES_FILTER = "ea";
    private static final String KEY_EVENT_ATTRIBUTE_ADD_USER = "eaa";
    private static final String KEY_EVENT_ATTRIBUTE_REMOVE_USER = "ear";
    private static final String KEY_EVENT_ATTRIBUTE_SINGLE_ITEM_USER = "eas";
    static final String KEY_EVENT_NAMES_FILTER = "ec";
    static final String KEY_EVENT_TYPES_FILTER = "et";
    private static final String KEY_EXCLUDE_ANONYMOUS_USERS = "eau";
    private static final String KEY_FILTERS = "hs";
    static final String KEY_ID = "id";
    private static final String KEY_PROJECTIONS = "pr";
    private static final String KEY_PROPERTIES = "as";
    static final String KEY_SCREEN_ATTRIBUTES_FILTER = "svea";
    static final String KEY_SCREEN_NAME_FILTER = "svec";
    static final String KEY_USER_ATTRIBUTE_FILTER = "ua";
    static final String KEY_USER_IDENTITY_FILTER = "uid";
    private int avfHashedAttribute = 0;
    private int avfHashedValue = 0;
    private boolean avfIsActive = false;
    private boolean avfShouldIncludeMatches = false;
    protected boolean consentForwardingIncludeMatches = false;
    private LinkedList<CustomMapping> customMappingList;
    private CustomMapping defaultCommerceCustomMapping = null;
    private CustomMapping defaultCustomMapping = null;
    private CustomMapping defaultScreenCustomMapping = null;
    private int highBracket = 101;
    private int kitId;
    private int lowBracket = 0;
    protected Map<Integer, String> mAttributeAddToUser = new HashMap();
    protected SparseBooleanArray mAttributeFilters = new SparseBooleanArray(0);
    protected Map<Integer, String> mAttributeRemoveFromUser = new HashMap();
    protected Map<Integer, String> mAttributeSingleItemUser = new HashMap();
    protected SparseBooleanArray mCommerceAttributeFilters = new SparseBooleanArray(0);
    private Map<Integer, SparseBooleanArray> mCommerceEntityAttributeFilters = new HashMap(0);
    protected SparseBooleanArray mCommerceEntityFilters = new SparseBooleanArray(0);
    protected Map<Integer, Boolean> mConsentForwardingRules = new HashMap();
    protected boolean mExcludeAnonymousUsers;
    protected SparseBooleanArray mNameFilters = new SparseBooleanArray(0);
    protected SparseBooleanArray mScreenAttributeFilters = new SparseBooleanArray(0);
    protected SparseBooleanArray mScreenNameFilters = new SparseBooleanArray(0);
    protected SparseBooleanArray mTypeFilters = new SparseBooleanArray(0);
    protected SparseBooleanArray mUserAttributeFilters = new SparseBooleanArray(0);
    protected SparseBooleanArray mUserIdentityFilters = new SparseBooleanArray(0);
    private HashMap<String, String> settings = new HashMap<>(0);

    public static b convertSparseArrayToJsonObject(SparseBooleanArray sparseBooleanArray) throws JSONException {
        if (sparseBooleanArray == null || sparseBooleanArray.size() == 0) {
            return null;
        }
        b bVar = new b();
        for (int i10 = 0; i10 < sparseBooleanArray.size(); i10++) {
            int keyAt = sparseBooleanArray.keyAt(i10);
            try {
                bVar.put(Integer.toString(keyAt), sparseBooleanArray.get(keyAt));
            } catch (JSONException e10) {
                Logger.error("Issue while parsing kit configuration: " + e10.getMessage());
            }
        }
        return bVar;
    }

    private static b convertSparseMapToJsonObject(Map<Integer, String> map) throws JSONException {
        if (map == null || map.size() == 0) {
            return null;
        }
        b bVar = new b();
        for (Map.Entry next : map.entrySet()) {
            try {
                bVar.put(Integer.toString(((Integer) next.getKey()).intValue()), next.getValue());
            } catch (JSONException e10) {
                Logger.error("Issue while parsing kit configuration: " + e10.getMessage());
            }
        }
        return bVar;
    }

    public static KitConfiguration createKitConfiguration(b bVar) throws JSONException {
        return new KitConfiguration().parseConfiguration(bVar);
    }

    public static final Map<String, ?> filterAttributes(SparseBooleanArray sparseBooleanArray, Map<String, ?> map) {
        if (map == null || sparseBooleanArray == null || sparseBooleanArray.size() <= 0 || map.size() <= 0) {
            return map;
        }
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (shouldForwardAttribute(sparseBooleanArray, (String) next.getKey())) {
                hashMap.put(next.getKey(), next.getValue());
            }
        }
        return hashMap;
    }

    private CommerceEvent filterCommerceEntities(CommerceEvent commerceEvent) {
        SparseBooleanArray sparseBooleanArray = this.mCommerceEntityFilters;
        if (sparseBooleanArray == null || sparseBooleanArray.size() == 0) {
            return commerceEvent;
        }
        CommerceEvent.Builder builder = new CommerceEvent.Builder(commerceEvent);
        boolean z10 = !this.mCommerceEntityFilters.get(1, true);
        boolean z11 = true ^ this.mCommerceEntityFilters.get(2, true);
        if (z10) {
            builder.products(new LinkedList());
            List<Impression> impressions = commerceEvent.getImpressions();
            if (impressions != null) {
                builder.impressions((List<Impression>) null);
                for (Impression listName : impressions) {
                    builder.addImpression(new Impression(listName.getListName(), (Product) null));
                }
            }
        }
        if (z11) {
            builder.promotions(new LinkedList());
        }
        return builder.build();
    }

    private CommerceEvent filterCommerceEntityAttributes(CommerceEvent commerceEvent) {
        Map<Integer, SparseBooleanArray> map = this.mCommerceEntityAttributeFilters;
        if (map == null || map.size() == 0) {
            return commerceEvent;
        }
        CommerceEvent.Builder builder = new CommerceEvent.Builder(commerceEvent);
        for (Map.Entry next : this.mCommerceEntityAttributeFilters.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) next.getValue();
            if (intValue != 1) {
                if (intValue == 2 && commerceEvent.getPromotions() != null && commerceEvent.getPromotions().size() > 0) {
                    LinkedList linkedList = new LinkedList();
                    for (Promotion next2 : commerceEvent.getPromotions()) {
                        Promotion promotion = new Promotion();
                        if (!MPUtility.isEmpty((CharSequence) next2.getId()) && sparseBooleanArray.get(KitUtils.hashForFiltering("Id"), true)) {
                            promotion.setId(next2.getId());
                        }
                        if (!MPUtility.isEmpty((CharSequence) next2.getCreative()) && sparseBooleanArray.get(KitUtils.hashForFiltering(CommerceEventUtils.Constants.ATT_PROMOTION_CREATIVE), true)) {
                            promotion.setCreative(next2.getCreative());
                        }
                        if (!MPUtility.isEmpty((CharSequence) next2.getName()) && sparseBooleanArray.get(KitUtils.hashForFiltering("Name"), true)) {
                            promotion.setName(next2.getName());
                        }
                        if (!MPUtility.isEmpty((CharSequence) next2.getPosition()) && sparseBooleanArray.get(KitUtils.hashForFiltering("Position"), true)) {
                            promotion.setPosition(next2.getPosition());
                        }
                        linkedList.add(promotion);
                    }
                    builder.promotions(linkedList);
                }
            } else if (commerceEvent.getProducts() != null && commerceEvent.getProducts().size() > 0) {
                LinkedList linkedList2 = new LinkedList();
                for (Product next3 : commerceEvent.getProducts()) {
                    Product.Builder builder2 = new Product.Builder(next3);
                    if (next3.getCustomAttributes() != null && next3.getCustomAttributes().size() > 0) {
                        HashMap hashMap = new HashMap(next3.getCustomAttributes().size());
                        for (Map.Entry next4 : next3.getCustomAttributes().entrySet()) {
                            if (sparseBooleanArray.get(KitUtils.hashForFiltering((String) next4.getKey()), true)) {
                                hashMap.put((String) next4.getKey(), (String) next4.getValue());
                            }
                        }
                        builder2.customAttributes(hashMap);
                    }
                    if (MPUtility.isEmpty((CharSequence) next3.getCouponCode()) || !sparseBooleanArray.get(KitUtils.hashForFiltering("Coupon Code"), true)) {
                        builder2.couponCode((String) null);
                    } else {
                        builder2.couponCode(next3.getCouponCode());
                    }
                    if (next3.getPosition() == null || !sparseBooleanArray.get(KitUtils.hashForFiltering("Position"), true)) {
                        builder2.position((Integer) null);
                    } else {
                        builder2.position(next3.getPosition());
                    }
                    if (MPUtility.isEmpty((CharSequence) next3.getVariant()) || !sparseBooleanArray.get(KitUtils.hashForFiltering(CommerceEventUtils.Constants.ATT_PRODUCT_VARIANT), true)) {
                        builder2.variant((String) null);
                    } else {
                        builder2.variant(next3.getVariant());
                    }
                    if (MPUtility.isEmpty((CharSequence) next3.getCategory()) || !sparseBooleanArray.get(KitUtils.hashForFiltering(CommerceEventUtils.Constants.ATT_PRODUCT_CATEGORY), true)) {
                        builder2.category((String) null);
                    } else {
                        builder2.category(next3.getCategory());
                    }
                    if (MPUtility.isEmpty((CharSequence) next3.getBrand()) || !sparseBooleanArray.get(KitUtils.hashForFiltering(CommerceEventUtils.Constants.ATT_PRODUCT_BRAND), true)) {
                        builder2.brand((String) null);
                    } else {
                        builder2.brand(next3.getBrand());
                    }
                    linkedList2.add(builder2.build());
                }
                builder.products(linkedList2);
            }
        }
        return builder.build();
    }

    private CommerceEvent filterCommerceEventAttributes(CommerceEvent commerceEvent) {
        String num = Integer.toString(CommerceEventUtils.getEventType(commerceEvent));
        SparseBooleanArray sparseBooleanArray = this.mCommerceAttributeFilters;
        if (sparseBooleanArray == null || sparseBooleanArray.size() == 0) {
            return commerceEvent;
        }
        CommerceEvent.Builder builder = new CommerceEvent.Builder(commerceEvent);
        Map<String, String> customAttributeStrings = commerceEvent.getCustomAttributeStrings();
        if (customAttributeStrings != null) {
            HashMap hashMap = new HashMap(customAttributeStrings.size());
            for (Map.Entry next : customAttributeStrings.entrySet()) {
                SparseBooleanArray sparseBooleanArray2 = this.mCommerceAttributeFilters;
                if (sparseBooleanArray2.get(KitUtils.hashForFiltering(num + ((String) next.getKey())), true)) {
                    hashMap.put((String) next.getKey(), (String) next.getValue());
                }
            }
            builder.customAttributes(hashMap);
        }
        if (commerceEvent.getCheckoutStep() != null) {
            SparseBooleanArray sparseBooleanArray3 = this.mCommerceAttributeFilters;
            if (!sparseBooleanArray3.get(KitUtils.hashForFiltering(num + CommerceEventUtils.Constants.ATT_ACTION_CHECKOUT_STEP), true)) {
                builder.checkoutStep((Integer) null);
            }
        }
        if (commerceEvent.getCheckoutOptions() != null) {
            SparseBooleanArray sparseBooleanArray4 = this.mCommerceAttributeFilters;
            if (!sparseBooleanArray4.get(KitUtils.hashForFiltering(num + CommerceEventUtils.Constants.ATT_ACTION_CHECKOUT_OPTIONS), true)) {
                builder.checkoutOptions((String) null);
            }
        }
        TransactionAttributes transactionAttributes = commerceEvent.getTransactionAttributes();
        if (transactionAttributes != null) {
            if (transactionAttributes.getCouponCode() != null) {
                SparseBooleanArray sparseBooleanArray5 = this.mCommerceAttributeFilters;
                if (!sparseBooleanArray5.get(KitUtils.hashForFiltering(num + "Coupon Code"), true)) {
                    transactionAttributes.setCouponCode((String) null);
                }
            }
            if (transactionAttributes.getShipping() != null) {
                SparseBooleanArray sparseBooleanArray6 = this.mCommerceAttributeFilters;
                if (!sparseBooleanArray6.get(KitUtils.hashForFiltering(num + CommerceEventUtils.Constants.ATT_SHIPPING), true)) {
                    transactionAttributes.setShipping((Double) null);
                }
            }
            if (transactionAttributes.getTax() != null) {
                SparseBooleanArray sparseBooleanArray7 = this.mCommerceAttributeFilters;
                if (!sparseBooleanArray7.get(KitUtils.hashForFiltering(num + CommerceEventUtils.Constants.ATT_TAX), true)) {
                    transactionAttributes.setTax((Double) null);
                }
            }
            if (transactionAttributes.getRevenue() != null) {
                SparseBooleanArray sparseBooleanArray8 = this.mCommerceAttributeFilters;
                if (!sparseBooleanArray8.get(KitUtils.hashForFiltering(num + CommerceEventUtils.Constants.ATT_TOTAL), true)) {
                    transactionAttributes.setRevenue(Double.valueOf(0.0d));
                }
            }
            if (transactionAttributes.getId() != null) {
                SparseBooleanArray sparseBooleanArray9 = this.mCommerceAttributeFilters;
                if (!sparseBooleanArray9.get(KitUtils.hashForFiltering(num + CommerceEventUtils.Constants.ATT_TRANSACTION_ID), true)) {
                    transactionAttributes.setId((String) null);
                }
            }
            if (transactionAttributes.getAffiliation() != null) {
                SparseBooleanArray sparseBooleanArray10 = this.mCommerceAttributeFilters;
                if (!sparseBooleanArray10.get(KitUtils.hashForFiltering(num + CommerceEventUtils.Constants.ATT_AFFILIATION), true)) {
                    transactionAttributes.setAffiliation((String) null);
                }
            }
            builder.transactionAttributes(transactionAttributes);
        }
        return builder.build();
    }

    private b getAttributeValueFiltering() throws JSONException {
        b bVar = new b();
        bVar.put("i", this.avfShouldIncludeMatches);
        bVar.put("a", this.avfHashedAttribute);
        bVar.put(ReportingMessage.MessageType.SCREEN_VIEW, this.avfHashedValue);
        return bVar;
    }

    private b getBracketing() throws JSONException {
        b bVar = new b();
        int i10 = this.lowBracket;
        if (i10 != 0) {
            bVar.put(KEY_BRACKETING_LOW, i10);
        }
        int i11 = this.highBracket;
        if (i11 != 101) {
            bVar.put(KEY_BRACKETING_HIGH, i11);
        }
        return bVar;
    }

    private b getConsentRules() throws JSONException {
        b bVar = new b();
        bVar.put("i", this.consentForwardingIncludeMatches);
        a aVar = new a();
        for (Map.Entry next : this.mConsentForwardingRules.entrySet()) {
            b bVar2 = new b();
            bVar2.put("h", next.getKey());
            bVar2.put("c", next.getValue());
            aVar.E(bVar2);
        }
        bVar.put(ReportingMessage.MessageType.SCREEN_VIEW, (Object) aVar);
        return bVar;
    }

    private a getCustomMapping() {
        a aVar = new a();
        Iterator<CustomMapping> it = this.customMappingList.iterator();
        while (it.hasNext()) {
            b bVar = it.next().rawJsonProjection;
            if (bVar != null) {
                aVar.E(bVar);
            }
        }
        return aVar;
    }

    private b getKeyFilters() throws JSONException {
        b bVar = new b();
        b convertSparseArrayToJsonObject = convertSparseArrayToJsonObject(this.mTypeFilters);
        if (convertSparseArrayToJsonObject != null) {
            bVar.put(KEY_EVENT_TYPES_FILTER, (Object) convertSparseArrayToJsonObject);
        }
        b convertSparseArrayToJsonObject2 = convertSparseArrayToJsonObject(this.mNameFilters);
        if (convertSparseArrayToJsonObject2 != null) {
            bVar.put(KEY_EVENT_NAMES_FILTER, (Object) convertSparseArrayToJsonObject2);
        }
        b convertSparseArrayToJsonObject3 = convertSparseArrayToJsonObject(this.mAttributeFilters);
        if (convertSparseArrayToJsonObject3 != null) {
            bVar.put(KEY_EVENT_ATTRIBUTES_FILTER, (Object) convertSparseArrayToJsonObject3);
        }
        b convertSparseArrayToJsonObject4 = convertSparseArrayToJsonObject(this.mScreenNameFilters);
        if (convertSparseArrayToJsonObject4 != null) {
            bVar.put(KEY_SCREEN_NAME_FILTER, (Object) convertSparseArrayToJsonObject4);
        }
        b convertSparseArrayToJsonObject5 = convertSparseArrayToJsonObject(this.mScreenAttributeFilters);
        if (convertSparseArrayToJsonObject5 != null) {
            bVar.put(KEY_SCREEN_ATTRIBUTES_FILTER, (Object) convertSparseArrayToJsonObject5);
        }
        b convertSparseArrayToJsonObject6 = convertSparseArrayToJsonObject(this.mUserIdentityFilters);
        if (convertSparseArrayToJsonObject6 != null) {
            bVar.put(KEY_USER_IDENTITY_FILTER, (Object) convertSparseArrayToJsonObject6);
        }
        b convertSparseArrayToJsonObject7 = convertSparseArrayToJsonObject(this.mCommerceAttributeFilters);
        if (convertSparseArrayToJsonObject7 != null) {
            bVar.put(KEY_COMMERCE_ATTRIBUTE_FILTER, (Object) convertSparseArrayToJsonObject7);
        }
        b convertSparseArrayToJsonObject8 = convertSparseArrayToJsonObject(this.mCommerceEntityFilters);
        if (convertSparseArrayToJsonObject8 != null) {
            bVar.put(KEY_COMMERCE_ENTITY_FILTERS, (Object) convertSparseArrayToJsonObject8);
        }
        b convertSparseMapToJsonObject = convertSparseMapToJsonObject(this.mAttributeAddToUser);
        if (convertSparseMapToJsonObject != null) {
            bVar.put(KEY_EVENT_ATTRIBUTE_ADD_USER, (Object) convertSparseMapToJsonObject);
        }
        b convertSparseMapToJsonObject2 = convertSparseMapToJsonObject(this.mAttributeRemoveFromUser);
        if (convertSparseMapToJsonObject2 != null) {
            bVar.put(KEY_EVENT_ATTRIBUTE_REMOVE_USER, (Object) convertSparseMapToJsonObject2);
        }
        b convertSparseMapToJsonObject3 = convertSparseMapToJsonObject(this.mAttributeSingleItemUser);
        if (convertSparseMapToJsonObject3 != null) {
            bVar.put(KEY_EVENT_ATTRIBUTE_SINGLE_ITEM_USER, (Object) convertSparseMapToJsonObject3);
        }
        Map<Integer, SparseBooleanArray> map = this.mCommerceEntityAttributeFilters;
        if (map != null && !map.isEmpty()) {
            b bVar2 = new b();
            for (Map.Entry next : this.mCommerceEntityAttributeFilters.entrySet()) {
                bVar2.put(Integer.toString(((Integer) next.getKey()).intValue()), (Object) convertSparseArrayToJsonObject((SparseBooleanArray) next.getValue()));
            }
            bVar.put(KEY_COMMERCE_ENTITY_ATTRIBUTE_FILTERS, (Object) bVar2);
        }
        return bVar;
    }

    public static final boolean shouldForwardAttribute(SparseBooleanArray sparseBooleanArray, String str) {
        return sparseBooleanArray.get(KitUtils.hashForFiltering(str), true);
    }

    public KitConfiguration applySideloadedKits(MPSideloadedFilters mPSideloadedFilters) {
        Map<String, b> filters = mPSideloadedFilters.getFilters();
        if (filters.containsKey(KEY_ATTRIBUTE_VALUE_FILTERING)) {
            b bVar = filters.get(KEY_ATTRIBUTE_VALUE_FILTERING);
            if (bVar.has("i")) {
                try {
                    this.avfShouldIncludeMatches = bVar.getBoolean("i");
                } catch (JSONException unused) {
                }
            }
            if (bVar.has("a")) {
                try {
                    this.avfHashedAttribute = bVar.getInt("a");
                } catch (JSONException unused2) {
                }
            }
            if (bVar.has(ReportingMessage.MessageType.SCREEN_VIEW)) {
                try {
                    this.avfHashedValue = bVar.getInt(ReportingMessage.MessageType.SCREEN_VIEW);
                } catch (JSONException unused3) {
                }
            }
        }
        if (filters.containsKey(KEY_EVENT_TYPES_FILTER)) {
            try {
                b bVar2 = filters.get(KEY_EVENT_TYPES_FILTER);
                if (bVar2 != null && bVar2.length() > 0) {
                    this.mTypeFilters = convertToSparseArray(bVar2);
                }
            } catch (Exception unused4) {
            }
        }
        if (filters.containsKey(KEY_EVENT_NAMES_FILTER)) {
            try {
                b bVar3 = filters.get(KEY_EVENT_NAMES_FILTER);
                if (bVar3 != null && bVar3.length() > 0) {
                    this.mNameFilters = convertToSparseArray(bVar3);
                }
            } catch (Exception unused5) {
            }
        }
        if (filters.containsKey(KEY_EVENT_ATTRIBUTES_FILTER)) {
            try {
                b bVar4 = filters.get(KEY_EVENT_ATTRIBUTES_FILTER);
                if (bVar4 != null && bVar4.length() > 0) {
                    this.mAttributeFilters = convertToSparseArray(bVar4);
                }
            } catch (Exception unused6) {
            }
        }
        if (filters.containsKey(KEY_SCREEN_NAME_FILTER)) {
            try {
                b bVar5 = filters.get(KEY_SCREEN_NAME_FILTER);
                if (bVar5 != null && bVar5.length() > 0) {
                    this.mScreenNameFilters = convertToSparseArray(bVar5);
                }
            } catch (Exception unused7) {
            }
        }
        if (filters.containsKey(KEY_SCREEN_ATTRIBUTES_FILTER)) {
            try {
                b bVar6 = filters.get(KEY_SCREEN_ATTRIBUTES_FILTER);
                if (bVar6 != null && bVar6.length() > 0) {
                    this.mScreenAttributeFilters = convertToSparseArray(bVar6);
                }
            } catch (Exception unused8) {
            }
        }
        if (filters.containsKey(KEY_USER_IDENTITY_FILTER)) {
            try {
                b bVar7 = filters.get(KEY_USER_IDENTITY_FILTER);
                if (bVar7 != null && bVar7.length() > 0) {
                    this.mUserIdentityFilters = convertToSparseArray(bVar7);
                }
            } catch (Exception unused9) {
            }
        }
        if (filters.containsKey(KEY_COMMERCE_ATTRIBUTE_FILTER)) {
            try {
                b bVar8 = filters.get(KEY_COMMERCE_ATTRIBUTE_FILTER);
                if (bVar8 != null && bVar8.length() > 0) {
                    this.mCommerceAttributeFilters = convertToSparseArray(bVar8);
                }
            } catch (Exception unused10) {
            }
        }
        if (filters.containsKey(KEY_COMMERCE_ENTITY_FILTERS)) {
            try {
                b bVar9 = filters.get(KEY_COMMERCE_ENTITY_FILTERS);
                if (bVar9 != null && bVar9.length() > 0) {
                    this.mCommerceAttributeFilters = convertToSparseArray(bVar9);
                }
            } catch (Exception unused11) {
            }
        }
        if (filters.containsKey(KEY_EVENT_ATTRIBUTE_ADD_USER)) {
            try {
                b bVar10 = filters.get(KEY_EVENT_ATTRIBUTE_ADD_USER);
                if (bVar10 != null && bVar10.length() > 0) {
                    this.mAttributeAddToUser = convertToSparseMap(bVar10);
                }
            } catch (Exception unused12) {
            }
        }
        if (filters.containsKey(KEY_EVENT_ATTRIBUTE_REMOVE_USER)) {
            try {
                b bVar11 = filters.get(KEY_EVENT_ATTRIBUTE_REMOVE_USER);
                if (bVar11 != null && bVar11.length() > 0) {
                    this.mAttributeRemoveFromUser = convertToSparseMap(bVar11);
                }
            } catch (Exception unused13) {
            }
        }
        if (filters.containsKey(KEY_EVENT_ATTRIBUTE_SINGLE_ITEM_USER)) {
            try {
                b bVar12 = filters.get(KEY_EVENT_ATTRIBUTE_SINGLE_ITEM_USER);
                if (bVar12 != null && bVar12.length() > 0) {
                    this.mAttributeSingleItemUser = convertToSparseMap(bVar12);
                }
            } catch (Exception unused14) {
            }
        }
        return this;
    }

    public b convertToJsonObject() {
        b bVar = new b();
        try {
            bVar.put("id", this.kitId);
            if (this.avfIsActive) {
                bVar.put(KEY_ATTRIBUTE_VALUE_FILTERING, (Object) getAttributeValueFiltering());
            }
            if (!this.settings.isEmpty()) {
                bVar.put(KEY_PROPERTIES, (Object) this.settings.toString());
            }
            b keyFilters = getKeyFilters();
            if (keyFilters.length() > 0) {
                bVar.put(KEY_FILTERS, (Object) keyFilters);
            }
            b bracketing = getBracketing();
            if (bracketing.length() > 0) {
                bVar.put(KEY_BRACKETING, (Object) bracketing);
            }
            a customMapping = getCustomMapping();
            if (customMapping.o() > 0) {
                bVar.put("pr", (Object) customMapping);
            }
            Map<Integer, Boolean> map = this.mConsentForwardingRules;
            if (map != null && !map.isEmpty()) {
                bVar.put(KEY_CONSENT_FORWARDING_RULES, (Object) getConsentRules());
            }
            bVar.put(KEY_EXCLUDE_ANONYMOUS_USERS, this.mExcludeAnonymousUsers);
        } catch (JSONException unused) {
            Logger.error("Issue while converting KitConfigurationToJsonObject: ");
        }
        return bVar;
    }

    /* access modifiers changed from: protected */
    public SparseBooleanArray convertToSparseArray(b bVar) {
        boolean z10;
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                int parseInt = Integer.parseInt(next);
                if (bVar.getInt(next) == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                sparseBooleanArray.put(parseInt, z10);
            } catch (JSONException e10) {
                Logger.error("Issue while parsing kit configuration: " + e10.getMessage());
            }
        }
        return sparseBooleanArray;
    }

    /* access modifiers changed from: protected */
    public Map<Integer, String> convertToSparseMap(b bVar) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                hashMap.put(Integer.valueOf(Integer.parseInt(next)), bVar.getString(next));
            } catch (JSONException e10) {
                Logger.error("Issue while parsing kit configuration: " + e10.getMessage());
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public boolean excludeAnonymousUsers() {
        return this.mExcludeAnonymousUsers;
    }

    /* access modifiers changed from: protected */
    public CommerceEvent filterCommerceEvent(CommerceEvent commerceEvent) {
        if (!shouldIncludeFromAttributeValueFiltering(commerceEvent.getCustomAttributeStrings())) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray = this.mTypeFilters;
        if (sparseBooleanArray != null) {
            if (!sparseBooleanArray.get(KitUtils.hashForFiltering(CommerceEventUtils.getEventType(commerceEvent) + ""), true)) {
                return null;
            }
        }
        return filterCommerceEventAttributes(filterCommerceEntityAttributes(filterCommerceEntities(new CommerceEvent.Builder(commerceEvent).build())));
    }

    public final Map<String, Object> filterEventAttributes(MPEvent mPEvent) {
        return filterEventAttributes(mPEvent.getEventType(), mPEvent.getEventName(), this.mAttributeFilters, mPEvent.getCustomAttributes());
    }

    public final Map<String, Object> filterScreenAttributes(MParticle.EventType eventType, String str, Map<String, Object> map) {
        return filterEventAttributes(eventType, str, this.mScreenAttributeFilters, map);
    }

    public int getAvfHashedAttribute() {
        return this.avfHashedAttribute;
    }

    public int getAvfHashedValue() {
        return this.avfHashedValue;
    }

    public SparseBooleanArray getCommerceAttributeFilters() {
        return this.mCommerceAttributeFilters;
    }

    public Map<Integer, SparseBooleanArray> getCommerceEntityAttributeFilters() {
        return this.mCommerceEntityAttributeFilters;
    }

    public SparseBooleanArray getCommerceEntityFilters() {
        return this.mCommerceEntityFilters;
    }

    public final List<CustomMapping> getCustomMappingList() {
        return this.customMappingList;
    }

    public final CustomMapping getDefaultCommerceCustomMapping() {
        return this.defaultCommerceCustomMapping;
    }

    public final CustomMapping getDefaultEventProjection() {
        return this.defaultCustomMapping;
    }

    public final CustomMapping getDefaultScreenCustomMapping() {
        return this.defaultScreenCustomMapping;
    }

    public SparseBooleanArray getEventAttributeFilters() {
        return this.mAttributeFilters;
    }

    public Map<Integer, String> getEventAttributesAddToUser() {
        return this.mAttributeAddToUser;
    }

    public Map<Integer, String> getEventAttributesRemoveFromUser() {
        return this.mAttributeRemoveFromUser;
    }

    public Map<Integer, String> getEventAttributesSingleItemUser() {
        return this.mAttributeSingleItemUser;
    }

    public SparseBooleanArray getEventNameFilters() {
        return this.mNameFilters;
    }

    public SparseBooleanArray getEventTypeFilters() {
        return this.mTypeFilters;
    }

    public int getHighBracket() {
        return this.highBracket;
    }

    public int getKitId() {
        return this.kitId;
    }

    public int getLowBracket() {
        return this.lowBracket;
    }

    public SparseBooleanArray getScreenAttributeFilters() {
        return this.mScreenAttributeFilters;
    }

    public SparseBooleanArray getScreenNameFilters() {
        return this.mScreenNameFilters;
    }

    public Map<String, String> getSettings() {
        return this.settings;
    }

    public SparseBooleanArray getUserAttributeFilters() {
        return this.mUserAttributeFilters;
    }

    public SparseBooleanArray getUserIdentityFilters() {
        return this.mUserIdentityFilters;
    }

    public Map<Integer, String> getValueFromSideloadedFilterToMap(Map<String, b> map, String str) {
        b bVar = map.get(str);
        if (bVar == null || bVar.length() <= 0) {
            return null;
        }
        return convertToSparseMap(bVar);
    }

    public SparseBooleanArray getValueFromSideloadedFilterToSparseArray(Map<String, b> map, String str) {
        b bVar = map.get(str);
        if (bVar == null || bVar.length() <= 0) {
            return null;
        }
        return convertToSparseArray(bVar);
    }

    public boolean isAttributeValueFilteringActive() {
        return this.avfIsActive;
    }

    public boolean isAvfShouldIncludeMatches() {
        return this.avfShouldIncludeMatches;
    }

    public boolean isConsentStateFilterMatch(ConsentState consentState) {
        if (!(this.mConsentForwardingRules.size() == 0 || consentState == null || (consentState.getGDPRConsentState().size() == 0 && consentState.getCCPAConsentState() == null))) {
            for (Map.Entry next : consentState.getGDPRConsentState().entrySet()) {
                Boolean bool = this.mConsentForwardingRules.get(Integer.valueOf(KitUtils.hashForFiltering(AppEventsConstants.EVENT_PARAM_VALUE_YES + ((String) next.getKey()))));
                if (bool != null && bool.booleanValue() == ((GDPRConsent) next.getValue()).isConsented()) {
                    return true;
                }
            }
            CCPAConsent cCPAConsentState = consentState.getCCPAConsentState();
            if (cCPAConsentState != null) {
                Boolean bool2 = this.mConsentForwardingRules.get(Integer.valueOf(KitUtils.hashForFiltering("2data_sale_opt_out")));
                if (bool2 == null || bool2.booleanValue() != cCPAConsentState.isConsented()) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public KitConfiguration parseConfiguration(b bVar) throws JSONException {
        this.kitId = bVar.optInt("id");
        if (bVar.has(KEY_ATTRIBUTE_VALUE_FILTERING)) {
            this.avfIsActive = true;
            try {
                b jSONObject = bVar.getJSONObject(KEY_ATTRIBUTE_VALUE_FILTERING);
                this.avfShouldIncludeMatches = jSONObject.getBoolean("i");
                this.avfHashedAttribute = jSONObject.getInt("a");
                this.avfHashedValue = jSONObject.getInt(ReportingMessage.MessageType.SCREEN_VIEW);
            } catch (JSONException e10) {
                Logger.error("Issue when parsing attribute value filtering configuration: " + e10.getMessage());
                this.avfIsActive = false;
            }
        }
        if (bVar.has(KEY_PROPERTIES)) {
            b jSONObject2 = bVar.getJSONObject(KEY_PROPERTIES);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject2.isNull(next)) {
                    this.settings.put(next, jSONObject2.optString(next));
                }
            }
        }
        if (bVar.has(KEY_FILTERS)) {
            b jSONObject3 = bVar.getJSONObject(KEY_FILTERS);
            if (jSONObject3.has(KEY_EVENT_TYPES_FILTER)) {
                this.mTypeFilters = convertToSparseArray(jSONObject3.getJSONObject(KEY_EVENT_TYPES_FILTER));
            } else {
                this.mTypeFilters.clear();
            }
            if (jSONObject3.has(KEY_EVENT_NAMES_FILTER)) {
                this.mNameFilters = convertToSparseArray(jSONObject3.getJSONObject(KEY_EVENT_NAMES_FILTER));
            } else {
                this.mNameFilters.clear();
            }
            if (jSONObject3.has(KEY_EVENT_ATTRIBUTES_FILTER)) {
                this.mAttributeFilters = convertToSparseArray(jSONObject3.getJSONObject(KEY_EVENT_ATTRIBUTES_FILTER));
            } else {
                this.mAttributeFilters.clear();
            }
            if (jSONObject3.has(KEY_SCREEN_NAME_FILTER)) {
                this.mScreenNameFilters = convertToSparseArray(jSONObject3.getJSONObject(KEY_SCREEN_NAME_FILTER));
            } else {
                this.mScreenNameFilters.clear();
            }
            if (jSONObject3.has(KEY_SCREEN_ATTRIBUTES_FILTER)) {
                this.mScreenAttributeFilters = convertToSparseArray(jSONObject3.getJSONObject(KEY_SCREEN_ATTRIBUTES_FILTER));
            } else {
                this.mScreenAttributeFilters.clear();
            }
            if (jSONObject3.has(KEY_USER_IDENTITY_FILTER)) {
                this.mUserIdentityFilters = convertToSparseArray(jSONObject3.getJSONObject(KEY_USER_IDENTITY_FILTER));
            } else {
                this.mUserIdentityFilters.clear();
            }
            if (jSONObject3.has(KEY_USER_ATTRIBUTE_FILTER)) {
                this.mUserAttributeFilters = convertToSparseArray(jSONObject3.getJSONObject(KEY_USER_ATTRIBUTE_FILTER));
            } else {
                this.mUserAttributeFilters.clear();
            }
            if (jSONObject3.has(KEY_COMMERCE_ATTRIBUTE_FILTER)) {
                this.mCommerceAttributeFilters = convertToSparseArray(jSONObject3.getJSONObject(KEY_COMMERCE_ATTRIBUTE_FILTER));
            } else {
                this.mCommerceAttributeFilters.clear();
            }
            if (jSONObject3.has(KEY_COMMERCE_ENTITY_FILTERS)) {
                this.mCommerceEntityFilters = convertToSparseArray(jSONObject3.getJSONObject(KEY_COMMERCE_ENTITY_FILTERS));
            } else {
                this.mCommerceEntityFilters.clear();
            }
            if (jSONObject3.has(KEY_COMMERCE_ENTITY_ATTRIBUTE_FILTERS)) {
                b jSONObject4 = jSONObject3.getJSONObject(KEY_COMMERCE_ENTITY_ATTRIBUTE_FILTERS);
                this.mCommerceEntityAttributeFilters.clear();
                Iterator<String> keys2 = jSONObject4.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    this.mCommerceEntityAttributeFilters.put(Integer.valueOf(Integer.parseInt(next2)), convertToSparseArray(jSONObject4.getJSONObject(next2)));
                }
            } else {
                this.mCommerceEntityAttributeFilters.clear();
            }
            if (jSONObject3.has(KEY_EVENT_ATTRIBUTE_ADD_USER)) {
                this.mAttributeAddToUser = convertToSparseMap(jSONObject3.getJSONObject(KEY_EVENT_ATTRIBUTE_ADD_USER));
            } else {
                this.mAttributeAddToUser.clear();
            }
            if (jSONObject3.has(KEY_EVENT_ATTRIBUTE_REMOVE_USER)) {
                this.mAttributeRemoveFromUser = convertToSparseMap(jSONObject3.getJSONObject(KEY_EVENT_ATTRIBUTE_REMOVE_USER));
            } else {
                this.mAttributeRemoveFromUser.clear();
            }
            if (jSONObject3.has(KEY_EVENT_ATTRIBUTE_SINGLE_ITEM_USER)) {
                this.mAttributeSingleItemUser = convertToSparseMap(jSONObject3.getJSONObject(KEY_EVENT_ATTRIBUTE_SINGLE_ITEM_USER));
            } else {
                this.mAttributeSingleItemUser.clear();
            }
        }
        if (bVar.has(KEY_BRACKETING)) {
            b jSONObject5 = bVar.getJSONObject(KEY_BRACKETING);
            this.lowBracket = jSONObject5.optInt(KEY_BRACKETING_LOW, 0);
            this.highBracket = jSONObject5.optInt(KEY_BRACKETING_HIGH, 101);
        } else {
            this.lowBracket = 0;
            this.highBracket = 101;
        }
        this.customMappingList = new LinkedList<>();
        this.defaultCustomMapping = null;
        if (bVar.has("pr")) {
            a jSONArray = bVar.getJSONArray("pr");
            for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                CustomMapping customMapping = new CustomMapping(jSONArray.j(i10));
                if (!customMapping.isDefault()) {
                    this.customMappingList.add(customMapping);
                } else if (customMapping.getMessageType() == 4) {
                    this.defaultCustomMapping = customMapping;
                } else if (customMapping.getMessageType() == 3) {
                    this.defaultScreenCustomMapping = customMapping;
                } else {
                    this.defaultCommerceCustomMapping = customMapping;
                }
            }
        }
        this.mConsentForwardingRules.clear();
        if (bVar.has(KEY_CONSENT_FORWARDING_RULES)) {
            b jSONObject6 = bVar.getJSONObject(KEY_CONSENT_FORWARDING_RULES);
            this.consentForwardingIncludeMatches = jSONObject6.optBoolean("i");
            a jSONArray2 = jSONObject6.getJSONArray(ReportingMessage.MessageType.SCREEN_VIEW);
            for (int i11 = 0; i11 < jSONArray2.o(); i11++) {
                this.mConsentForwardingRules.put(Integer.valueOf(jSONArray2.j(i11).getInt("h")), Boolean.valueOf(jSONArray2.j(i11).getBoolean("c")));
            }
        }
        this.mExcludeAnonymousUsers = bVar.optBoolean(KEY_EXCLUDE_ANONYMOUS_USERS, false);
        return this;
    }

    public boolean passesBracketing(int i10) {
        return i10 >= this.lowBracket && i10 < this.highBracket;
    }

    public boolean shouldExcludeUser(MParticleUser mParticleUser) {
        return this.mExcludeAnonymousUsers && (mParticleUser == null || !mParticleUser.isLoggedIn());
    }

    public boolean shouldHonorOptOut() {
        if (this.settings.containsKey(HONOR_OPT_OUT)) {
            return Boolean.parseBoolean(this.settings.get(HONOR_OPT_OUT));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldIncludeFromAttributeValueFiltering(java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r5 = this;
            boolean r0 = r5.avfIsActive
            r1 = 1
            if (r0 == 0) goto L_0x0045
            r0 = 0
            if (r6 == 0) goto L_0x003a
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0010:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x003a
            java.lang.Object r2 = r6.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.mparticle.kits.KitUtils.hashForFiltering(r3)
            int r4 = r5.avfHashedAttribute
            if (r3 != r4) goto L_0x0010
            java.lang.Object r6 = r2.getValue()
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.mparticle.kits.KitUtils.hashForFiltering(r6)
            int r2 = r5.avfHashedValue
            if (r6 != r2) goto L_0x003a
            r6 = r1
            goto L_0x003b
        L_0x003a:
            r6 = r0
        L_0x003b:
            boolean r2 = r5.avfShouldIncludeMatches
            if (r2 == 0) goto L_0x0041
            r1 = r6
            goto L_0x0045
        L_0x0041:
            if (r6 != 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r1 = r0
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.kits.KitConfiguration.shouldIncludeFromAttributeValueFiltering(java.util.Map):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean shouldIncludeFromConsentRules(MParticleUser mParticleUser) {
        if (this.mConsentForwardingRules.size() == 0) {
            return true;
        }
        if (mParticleUser == null) {
            return false;
        }
        if (this.consentForwardingIncludeMatches == isConsentStateFilterMatch(mParticleUser.getConsentState())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean shouldLogEvent(MPEvent mPEvent) {
        if (!shouldIncludeFromAttributeValueFiltering(mPEvent.getCustomAttributeStrings())) {
            return false;
        }
        if (!this.mTypeFilters.get(KitUtils.hashForFiltering(mPEvent.getEventType().ordinal() + ""), true) || !this.mNameFilters.get(mPEvent.getEventHash(), true)) {
            return false;
        }
        return true;
    }

    public boolean shouldLogScreen(String str) {
        int hashForFiltering = KitUtils.hashForFiltering("0" + str);
        if (this.mScreenNameFilters.size() <= 0 || this.mScreenNameFilters.get(hashForFiltering, true)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldSetIdentity(MParticle.IdentityType identityType) {
        SparseBooleanArray userIdentityFilters = getUserIdentityFilters();
        if (userIdentityFilters == null || userIdentityFilters.size() == 0 || userIdentityFilters.get(identityType.getValue(), true)) {
            return true;
        }
        return false;
    }

    public static final Map<String, Object> filterEventAttributes(MParticle.EventType eventType, String str, SparseBooleanArray sparseBooleanArray, Map<String, Object> map) {
        String str2;
        if (map == null || map.size() <= 0 || sparseBooleanArray == null || sparseBooleanArray.size() <= 0) {
            return map;
        }
        if (eventType != null) {
            str2 = eventType.ordinal() + "";
        } else {
            str2 = "0";
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str3 = (String) next.getKey();
            if (sparseBooleanArray.get(KitUtils.hashForFiltering(str2 + str + str3), true)) {
                hashMap.put(str3, next.getValue());
            }
        }
        return hashMap;
    }
}
