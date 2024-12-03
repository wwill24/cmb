package com.mparticle.kits.mappings;

import com.google.firebase.messaging.Constants;
import com.mparticle.MPEvent;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.commerce.Product;
import com.mparticle.commerce.Promotion;
import com.mparticle.kits.CommerceEventUtils;
import com.mparticle.kits.KitUtils;
import com.mparticle.kits.mappings.EventWrapper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.a;
import org.json.b;

final class CustomMappingMatch {
    static final String MATCH_TYPE_HASH = "H";
    static final String MATCH_TYPE_STRING = "S";
    public static final String PROPERTY_LOCATION_EVENT_ATTRIBUTE = "EventAttribute";
    public static final String PROPERTY_LOCATION_EVENT_FIELD = "EventField";
    public static final String PROPERTY_LOCATION_PRODUCT_ATTRIBUTE = "ProductAttribute";
    public static final String PROPERTY_LOCATION_PRODUCT_FIELD = "ProductField";
    public static final String PROPERTY_LOCATION_PROMOTION_FIELD = "PromotionField";
    String commerceMatchProperty = null;
    String commerceMatchPropertyName = null;
    Set<String> commerceMatchPropertyValues = null;
    String mAttributeKey = null;
    Set<String> mAttributeValues = null;
    int mEventHash;
    String mEventName = null;
    String mMatchType = "String";
    int mMessageType = -1;

    public CustomMappingMatch(b bVar) {
        if (bVar == null) {
            this.mEventHash = 0;
            this.mMessageType = -1;
            this.mMatchType = "String";
            this.mEventName = null;
            this.mAttributeKey = null;
            this.mAttributeValues = null;
            return;
        }
        this.mMessageType = bVar.optInt(Constants.MessagePayloadKeys.MESSAGE_TYPE);
        this.mMatchType = bVar.optString("event_match_type", "String");
        this.commerceMatchProperty = bVar.optString("property", "EventAttribute");
        this.commerceMatchPropertyName = bVar.optString("property_name", (String) null);
        if (bVar.has("property_values")) {
            try {
                a jSONArray = bVar.getJSONArray("property_values");
                this.commerceMatchPropertyValues = new HashSet(jSONArray.o());
                for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                    this.commerceMatchPropertyValues.add(jSONArray.w(i10).toLowerCase(Locale.US));
                }
            } catch (JSONException unused) {
            }
        }
        if (this.mMatchType.startsWith(MATCH_TYPE_HASH)) {
            this.mEventHash = Integer.parseInt(bVar.optString("event"));
            this.mAttributeKey = null;
            this.mAttributeValues = null;
            this.mEventName = null;
            return;
        }
        this.mEventHash = 0;
        this.mEventName = bVar.optString("event");
        this.mAttributeKey = bVar.optString("attribute_key");
        try {
            if (bVar.has("attribute_values") && (bVar.get("attribute_values") instanceof a)) {
                a jSONArray2 = bVar.getJSONArray("attribute_values");
                this.mAttributeValues = new HashSet(jSONArray2.o());
                for (int i11 = 0; i11 < jSONArray2.o(); i11++) {
                    this.mAttributeValues.add(jSONArray2.w(i11).toLowerCase(Locale.US));
                }
            } else if (bVar.has("attribute_values")) {
                HashSet hashSet = new HashSet(1);
                this.mAttributeValues = hashSet;
                hashSet.add(bVar.optString("attribute_values").toLowerCase(Locale.US));
            } else {
                HashSet hashSet2 = new HashSet(1);
                this.mAttributeValues = hashSet2;
                hashSet2.add(bVar.optString("attribute_value").toLowerCase(Locale.US));
            }
        } catch (JSONException unused2) {
        }
    }

    private boolean matchAppEvent(EventWrapper.MPEventWrapper mPEventWrapper) {
        MPEvent event = mPEventWrapper.getEvent();
        if (event == null) {
            return false;
        }
        if (this.mMatchType.startsWith(MATCH_TYPE_HASH) && mPEventWrapper.getEventHash() == this.mEventHash) {
            return true;
        }
        if (!this.mMatchType.startsWith(MATCH_TYPE_STRING) || !event.getEventName().equalsIgnoreCase(this.mEventName) || event.getCustomAttributeStrings() == null || !event.getCustomAttributeStrings().containsKey(this.mAttributeKey) || !getAttributeValues().contains(event.getCustomAttributeStrings().get(this.mAttributeKey).toLowerCase(Locale.US))) {
            return false;
        }
        return true;
    }

    private boolean matchCommerceAttributes(CommerceEvent commerceEvent) {
        Map<String, String> customAttributeStrings = commerceEvent.getCustomAttributeStrings();
        if (customAttributeStrings != null && customAttributeStrings.size() >= 1) {
            int parseInt = Integer.parseInt(this.commerceMatchPropertyName);
            for (Map.Entry next : customAttributeStrings.entrySet()) {
                if (KitUtils.hashForFiltering(CommerceEventUtils.getEventType(commerceEvent) + ((String) next.getKey())) == parseInt) {
                    return this.commerceMatchPropertyValues.contains(((String) next.getValue()).toLowerCase(Locale.US));
                }
            }
        }
        return false;
    }

    private CommerceEvent matchCommerceEvent(EventWrapper.CommerceEventWrapper commerceEventWrapper) {
        CommerceEvent event = commerceEventWrapper.getEvent();
        if (event == null) {
            return null;
        }
        String str = this.commerceMatchProperty;
        if (!(str == null || this.commerceMatchPropertyName == null)) {
            if (str.equalsIgnoreCase("EventField")) {
                if (matchCommerceFields(event)) {
                    return event;
                }
                return null;
            } else if (this.commerceMatchProperty.equalsIgnoreCase("EventAttribute")) {
                if (matchCommerceAttributes(event)) {
                    return event;
                }
                return null;
            } else if (this.commerceMatchProperty.equalsIgnoreCase("ProductField")) {
                return matchProductFields(event);
            } else {
                if (this.commerceMatchProperty.equalsIgnoreCase("ProductAttribute")) {
                    return matchProductAttributes(event);
                }
                if (this.commerceMatchProperty.equalsIgnoreCase("PromotionField")) {
                    return matchPromotionFields(event);
                }
            }
        }
        if (!this.mMatchType.startsWith(MATCH_TYPE_HASH) || commerceEventWrapper.getEventHash() != this.mEventHash) {
            return null;
        }
        return event;
    }

    private boolean matchCommerceFields(CommerceEvent commerceEvent) {
        int parseInt = Integer.parseInt(this.commerceMatchPropertyName);
        HashMap hashMap = new HashMap();
        CommerceEventUtils.extractActionAttributes(commerceEvent, (Map<String, String>) hashMap);
        for (Map.Entry entry : hashMap.entrySet()) {
            if (KitUtils.hashForFiltering(CommerceEventUtils.getEventType(commerceEvent) + ((String) entry.getKey())) == parseInt) {
                return this.commerceMatchPropertyValues.contains(((String) entry.getValue()).toLowerCase(Locale.US));
            }
        }
        return false;
    }

    private CommerceEvent matchProductAttributes(CommerceEvent commerceEvent) {
        int parseInt = Integer.parseInt(this.commerceMatchPropertyName);
        List<Product> products = commerceEvent.getProducts();
        if (products == null || products.size() == 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (Product next : products) {
            Map<String, String> customAttributes = next.getCustomAttributes();
            if (customAttributes != null) {
                for (Map.Entry next2 : customAttributes.entrySet()) {
                    if (KitUtils.hashForFiltering(CommerceEventUtils.getEventType(commerceEvent) + ((String) next2.getKey())) == parseInt && this.commerceMatchPropertyValues.contains(((String) next2.getValue()).toLowerCase(Locale.US))) {
                        linkedList.add(next);
                    }
                }
            }
        }
        if (linkedList.size() == 0) {
            return null;
        }
        if (linkedList.size() != products.size()) {
            return new CommerceEvent.Builder(commerceEvent).products(linkedList).build();
        }
        return commerceEvent;
    }

    private CommerceEvent matchProductFields(CommerceEvent commerceEvent) {
        int parseInt = Integer.parseInt(this.commerceMatchPropertyName);
        int eventType = CommerceEventUtils.getEventType(commerceEvent);
        List<Product> products = commerceEvent.getProducts();
        if (products == null || products.size() == 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        for (Product next : products) {
            hashMap.clear();
            CommerceEventUtils.extractProductFields(next, (Map<String, String>) hashMap);
            for (Map.Entry entry : hashMap.entrySet()) {
                if (KitUtils.hashForFiltering(eventType + ((String) entry.getKey())) == parseInt && this.commerceMatchPropertyValues.contains(((String) entry.getValue()).toLowerCase(Locale.US))) {
                    linkedList.add(next);
                }
            }
        }
        if (linkedList.size() == 0) {
            return null;
        }
        if (linkedList.size() != products.size()) {
            return new CommerceEvent.Builder(commerceEvent).products(linkedList).build();
        }
        return commerceEvent;
    }

    private CommerceEvent matchPromotionFields(CommerceEvent commerceEvent) {
        int parseInt = Integer.parseInt(this.commerceMatchPropertyName);
        List<Promotion> promotions = commerceEvent.getPromotions();
        if (promotions == null || promotions.size() == 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        for (Promotion next : promotions) {
            hashMap.clear();
            CommerceEventUtils.extractPromotionAttributes(next, (Map<String, String>) hashMap);
            for (Map.Entry entry : hashMap.entrySet()) {
                if (KitUtils.hashForFiltering(CommerceEventUtils.getEventType(commerceEvent) + ((String) entry.getKey())) == parseInt && this.commerceMatchPropertyValues.contains(((String) entry.getValue()).toLowerCase(Locale.US))) {
                    linkedList.add(next);
                }
            }
        }
        if (linkedList.size() == 0) {
            return null;
        }
        if (linkedList.size() != promotions.size()) {
            return new CommerceEvent.Builder(commerceEvent).promotions(linkedList).build();
        }
        return commerceEvent;
    }

    public Set<String> getAttributeValues() {
        return this.mAttributeValues;
    }

    public boolean isMatch(EventWrapper eventWrapper) {
        if (eventWrapper.getMessageType() != this.mMessageType) {
            return false;
        }
        if (!(eventWrapper instanceof EventWrapper.MPEventWrapper)) {
            EventWrapper.CommerceEventWrapper commerceEventWrapper = (EventWrapper.CommerceEventWrapper) eventWrapper;
            CommerceEvent matchCommerceEvent = matchCommerceEvent(commerceEventWrapper);
            if (matchCommerceEvent != null) {
                commerceEventWrapper.setEvent(matchCommerceEvent);
                return true;
            }
        } else if (matchAppEvent((EventWrapper.MPEventWrapper) eventWrapper)) {
            return true;
        }
        return false;
    }
}
