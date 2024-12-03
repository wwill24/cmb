package com.mparticle.kits.mappings;

import com.coffeemeetsbagel.models.constants.Extra;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.api.a;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.commerce.Product;
import com.mparticle.commerce.Promotion;
import com.mparticle.internal.MPUtility;
import com.mparticle.kits.CommerceEventUtils;
import com.mparticle.kits.mappings.EventWrapper;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smackx.hoxt.packet.Base64BinaryChunk;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class CustomMapping {
    static final String MATCH_TYPE_FIELD = "F";
    static final String MATCH_TYPE_HASH = "H";
    static final String MATCH_TYPE_STATIC = "Sta";
    static final String MATCH_TYPE_STRING = "S";
    public static final String PROPERTY_LOCATION_EVENT_ATTRIBUTE = "EventAttribute";
    public static final String PROPERTY_LOCATION_EVENT_FIELD = "EventField";
    public static final String PROPERTY_LOCATION_PRODUCT_ATTRIBUTE = "ProductAttribute";
    public static final String PROPERTY_LOCATION_PRODUCT_FIELD = "ProductField";
    public static final String PROPERTY_LOCATION_PROMOTION_FIELD = "PromotionField";
    private final boolean isSelectorLast;
    final boolean mAppendUnmappedAsIs;
    final int mID;
    final boolean mIsDefault;
    final int mMappingId;
    final int mMaxCustomParams;
    final int mModuleMappingId;
    final int mOutboundMessageType;
    final String mProjectedEventName;
    final List<AttributeMap> mRequiredAttributeMapList;
    final List<AttributeMap> mStaticAttributeMapList;
    private List<CustomMappingMatch> matchList = null;
    public b rawJsonProjection;

    static class AttributeMap {
        final int mDataType;
        final boolean mIsRequired;
        final String mLocation;
        final String mMatchType;
        final String mProjectedAttributeName;
        final String mValue;

        public AttributeMap(b bVar) {
            this.mProjectedAttributeName = bVar.optString("projected_attribute_name");
            this.mMatchType = bVar.optString(Extra.MATCH_TYPE, "String");
            this.mValue = bVar.optString("value");
            this.mDataType = bVar.optInt("data_type", 1);
            this.mIsRequired = bVar.optBoolean("is_required");
            this.mLocation = bVar.optString("property", "EventAttribute");
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || toString().equals(obj.toString());
        }

        public boolean matchesDataType(String str) {
            int i10 = this.mDataType;
            if (i10 == 1) {
                return true;
            }
            if (i10 == 2) {
                try {
                    Integer.parseInt(str);
                    return true;
                } catch (NumberFormatException unused) {
                    return false;
                }
            } else if (i10 != 3) {
                if (i10 != 4) {
                    return false;
                }
                try {
                    Double.parseDouble(str);
                    return true;
                } catch (NumberFormatException unused2) {
                    return false;
                }
            } else if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str) || "false".equalsIgnoreCase(str)) {
                return true;
            } else {
                return false;
            }
        }

        public String toString() {
            return "projected_attribute_name: " + this.mProjectedAttributeName + "\nmatch_type: " + this.mMatchType + "\nvalue: " + this.mValue + "\ndata_type: " + this.mDataType + "\nis_required: " + this.mIsRequired;
        }
    }

    public CustomMapping(b bVar) throws JSONException {
        this.rawJsonProjection = bVar;
        this.mID = bVar.getInt("id");
        this.mMappingId = bVar.optInt("pmid");
        this.mModuleMappingId = bVar.optInt("pmmid");
        if (bVar.has("matches")) {
            a jSONArray = bVar.getJSONArray("matches");
            this.matchList = new ArrayList(jSONArray.o());
            for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                this.matchList.add(new CustomMappingMatch(jSONArray.j(i10)));
            }
        } else {
            this.matchList = new ArrayList(1);
            this.matchList.add(new CustomMappingMatch((b) null));
        }
        if (bVar.has("behavior")) {
            b jSONObject = bVar.getJSONObject("behavior");
            this.mMaxCustomParams = jSONObject.optInt("max_custom_params", a.e.API_PRIORITY_OTHER);
            this.mAppendUnmappedAsIs = jSONObject.optBoolean("append_unmapped_as_is");
            this.mIsDefault = jSONObject.optBoolean("is_default");
            this.isSelectorLast = jSONObject.optString("selector", "foreach").equalsIgnoreCase(Base64BinaryChunk.ATTRIBUTE_LAST);
        } else {
            this.mMaxCustomParams = a.e.API_PRIORITY_OTHER;
            this.mAppendUnmappedAsIs = false;
            this.mIsDefault = false;
            this.isSelectorLast = false;
        }
        if (bVar.has("action")) {
            b jSONObject2 = bVar.getJSONObject("action");
            this.mOutboundMessageType = jSONObject2.optInt("outbound_message_type", 4);
            this.mProjectedEventName = jSONObject2.optString("projected_event_name");
            if (jSONObject2.has("attribute_maps")) {
                this.mRequiredAttributeMapList = new LinkedList();
                this.mStaticAttributeMapList = new LinkedList();
                org.json.a jSONArray2 = jSONObject2.getJSONArray("attribute_maps");
                for (int i11 = 0; i11 < jSONArray2.o(); i11++) {
                    AttributeMap attributeMap = new AttributeMap(jSONArray2.j(i11));
                    if (attributeMap.mMatchType.startsWith(MATCH_TYPE_STATIC)) {
                        this.mStaticAttributeMapList.add(attributeMap);
                    } else {
                        this.mRequiredAttributeMapList.add(attributeMap);
                    }
                }
                Collections.sort(this.mRequiredAttributeMapList, new Comparator<AttributeMap>() {
                    public int compare(AttributeMap attributeMap, AttributeMap attributeMap2) {
                        boolean z10 = attributeMap.mIsRequired;
                        boolean z11 = attributeMap2.mIsRequired;
                        if (z10 == z11) {
                            return 0;
                        }
                        return (!z10 || z11) ? 1 : -1;
                    }
                });
                return;
            }
            this.mRequiredAttributeMapList = null;
            this.mStaticAttributeMapList = null;
            return;
        }
        this.mRequiredAttributeMapList = null;
        this.mStaticAttributeMapList = null;
        this.mProjectedEventName = null;
        this.mOutboundMessageType = 4;
    }

    private boolean mapAttributes(List<AttributeMap> list, EventWrapper eventWrapper, Map<String, String> map, Set<String> set, Product product, Promotion promotion) {
        if (list == null) {
            return true;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            AttributeMap attributeMap = list.get(i10);
            Map.Entry entry = null;
            if (attributeMap.mMatchType.startsWith(MATCH_TYPE_STRING)) {
                entry = eventWrapper.findAttribute(attributeMap.mLocation, attributeMap.mValue, product, promotion);
            } else if (attributeMap.mMatchType.startsWith(MATCH_TYPE_HASH)) {
                entry = eventWrapper.findAttribute(attributeMap.mLocation, Integer.parseInt(attributeMap.mValue), product, promotion);
            } else if (attributeMap.mMatchType.startsWith(MATCH_TYPE_FIELD) && (eventWrapper.getEvent() instanceof MPEvent)) {
                entry = new AbstractMap.SimpleEntry(attributeMap.mProjectedAttributeName, ((MPEvent) eventWrapper.getEvent()).getEventName());
            }
            if (entry != null && attributeMap.matchesDataType((String) entry.getValue())) {
                String str = (String) entry.getKey();
                if (!MPUtility.isEmpty((CharSequence) attributeMap.mProjectedAttributeName)) {
                    str = attributeMap.mProjectedAttributeName;
                }
                map.put(str, (String) entry.getValue());
                set.add((String) entry.getKey());
            } else if (attributeMap.mIsRequired) {
                return false;
            }
        }
        return true;
    }

    private ProjectionResult projectCommerceEvent(EventWrapper.CommerceEventWrapper commerceEventWrapper, Product product, Promotion promotion) {
        HashMap hashMap;
        HashMap hashMap2 = new HashMap();
        HashSet hashSet = new HashSet();
        if (!mapAttributes(this.mRequiredAttributeMapList, commerceEventWrapper, hashMap2, hashSet, product, promotion)) {
            return null;
        }
        if (this.mStaticAttributeMapList != null) {
            for (int i10 = 0; i10 < this.mStaticAttributeMapList.size(); i10++) {
                AttributeMap attributeMap = this.mStaticAttributeMapList.get(i10);
                hashMap2.put(attributeMap.mProjectedAttributeName, attributeMap.mValue);
                hashSet.add(attributeMap.mValue);
            }
        }
        if (this.mAppendUnmappedAsIs && this.mMaxCustomParams > 0 && hashMap2.size() < this.mMaxCustomParams) {
            CommerceEvent event = commerceEventWrapper.getEvent();
            if (event.getCustomAttributeStrings() != null) {
                hashMap = new HashMap(event.getCustomAttributeStrings());
            } else {
                hashMap = new HashMap();
            }
            ArrayList arrayList = new ArrayList(hashMap.keySet());
            Collections.sort(arrayList);
            for (int i11 = 0; i11 < arrayList.size() && hashMap2.size() < this.mMaxCustomParams; i11++) {
                String str = (String) arrayList.get(i11);
                if (!hashSet.contains(str) && !hashMap2.containsKey(str)) {
                    hashMap2.put(str, (String) hashMap.get(str));
                }
            }
        }
        if (this.mOutboundMessageType == 16) {
            return new ProjectionResult(new CommerceEvent.Builder(commerceEventWrapper.getEvent()).internalEventName(this.mProjectedEventName).customAttributes(hashMap2).build(), this.mID);
        }
        return new ProjectionResult(new MPEvent.Builder(this.mProjectedEventName, MParticle.EventType.Transaction).customAttributes(hashMap2).build(), this.mID);
    }

    public static List<ProjectionResult> projectEvents(MPEvent mPEvent, List<CustomMapping> list, CustomMapping customMapping) {
        return projectEvents(mPEvent, false, list, customMapping, (CustomMapping) null);
    }

    private ProjectionResult projectMPEvent(MPEvent mPEvent) {
        String str;
        HashMap hashMap;
        EventWrapper.MPEventWrapper mPEventWrapper = new EventWrapper.MPEventWrapper(mPEvent);
        if (MPUtility.isEmpty((CharSequence) this.mProjectedEventName)) {
            str = mPEvent.getEventName();
        } else {
            str = this.mProjectedEventName;
        }
        MPEvent.Builder builder = new MPEvent.Builder(mPEvent);
        builder.eventName(str);
        builder.customAttributes((Map<String, ?>) null);
        HashMap hashMap2 = new HashMap();
        HashSet hashSet = new HashSet();
        if (!mapAttributes(this.mRequiredAttributeMapList, mPEventWrapper, hashMap2, hashSet, (Product) null, (Promotion) null)) {
            return null;
        }
        if (this.mStaticAttributeMapList != null) {
            for (int i10 = 0; i10 < this.mStaticAttributeMapList.size(); i10++) {
                AttributeMap attributeMap = this.mStaticAttributeMapList.get(i10);
                hashMap2.put(attributeMap.mProjectedAttributeName, attributeMap.mValue);
                hashSet.add(attributeMap.mValue);
            }
        }
        if (this.mAppendUnmappedAsIs && this.mMaxCustomParams > 0 && hashMap2.size() < this.mMaxCustomParams) {
            if (mPEvent.getCustomAttributeStrings() != null) {
                hashMap = new HashMap(mPEvent.getCustomAttributeStrings());
            } else {
                hashMap = new HashMap();
            }
            ArrayList arrayList = new ArrayList(hashMap.keySet());
            Collections.sort(arrayList);
            for (int i11 = 0; i11 < arrayList.size() && hashMap2.size() < this.mMaxCustomParams; i11++) {
                String str2 = (String) arrayList.get(i11);
                if (!hashSet.contains(str2) && !hashMap2.containsKey(str2)) {
                    hashMap2.put(str2, (String) hashMap.get(str2));
                }
            }
        }
        builder.customAttributes(hashMap2);
        return new ProjectionResult(builder.build(), this.mID);
    }

    public List<CustomMappingMatch> getMatchList() {
        return this.matchList;
    }

    public int getMessageType() {
        return this.matchList.get(0).mMessageType;
    }

    public boolean isDefault() {
        return this.mIsDefault;
    }

    /* access modifiers changed from: package-private */
    public boolean isMatch(EventWrapper eventWrapper) {
        if (this.mIsDefault) {
            return true;
        }
        for (CustomMappingMatch isMatch : this.matchList) {
            if (!isMatch.isMatch(eventWrapper)) {
                return false;
            }
        }
        return true;
    }

    public List<ProjectionResult> project(EventWrapper.CommerceEventWrapper commerceEventWrapper) {
        LinkedList linkedList = new LinkedList();
        CommerceEvent event = commerceEventWrapper.getEvent();
        int eventType = CommerceEventUtils.getEventType(event);
        if (eventType == 22) {
            return null;
        }
        int i10 = 0;
        if (eventType == 19 || eventType == 18) {
            List<Promotion> promotions = event.getPromotions();
            if (promotions == null || promotions.size() == 0) {
                ProjectionResult projectCommerceEvent = projectCommerceEvent(commerceEventWrapper, (Product) null, (Promotion) null);
                if (projectCommerceEvent != null) {
                    linkedList.add(projectCommerceEvent);
                }
            } else if (this.isSelectorLast) {
                ProjectionResult projectCommerceEvent2 = projectCommerceEvent(commerceEventWrapper, (Product) null, promotions.get(promotions.size() - 1));
                if (projectCommerceEvent2 != null) {
                    linkedList.add(projectCommerceEvent2);
                }
            } else {
                while (i10 < promotions.size()) {
                    ProjectionResult projectCommerceEvent3 = projectCommerceEvent(commerceEventWrapper, (Product) null, promotions.get(i10));
                    if (projectCommerceEvent3 != null) {
                        if (projectCommerceEvent3.getCommerceEvent() != null) {
                            CommerceEvent unused = projectCommerceEvent3.mCommerceEvent = new CommerceEvent.Builder(projectCommerceEvent3.getCommerceEvent()).promotions((List<Promotion>) null).addPromotion(promotions.get(i10)).build();
                        }
                        linkedList.add(projectCommerceEvent3);
                    }
                    i10++;
                }
            }
        } else {
            List<Product> products = event.getProducts();
            if (this.isSelectorLast) {
                ProjectionResult projectCommerceEvent4 = projectCommerceEvent(commerceEventWrapper, (products == null || products.size() <= 0) ? null : products.get(products.size() - 1), (Promotion) null);
                if (projectCommerceEvent4 != null) {
                    linkedList.add(projectCommerceEvent4);
                }
            } else if (products != null) {
                while (i10 < products.size()) {
                    ProjectionResult projectCommerceEvent5 = projectCommerceEvent(commerceEventWrapper, products.get(i10), (Promotion) null);
                    if (projectCommerceEvent5 != null) {
                        if (projectCommerceEvent5.getCommerceEvent() != null) {
                            CommerceEvent unused2 = projectCommerceEvent5.mCommerceEvent = new CommerceEvent.Builder(projectCommerceEvent5.getCommerceEvent()).products((List<Product>) null).addProduct(products.get(i10)).build();
                        }
                        linkedList.add(projectCommerceEvent5);
                    }
                    i10++;
                }
            }
        }
        if (linkedList.size() > 0) {
            return linkedList;
        }
        return null;
    }

    public static List<ProjectionResult> projectEvents(CommerceEvent commerceEvent, List<CustomMapping> list, CustomMapping customMapping) {
        List<ProjectionResult> project;
        if (CommerceEventUtils.getEventType(commerceEvent) == 22) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        EventWrapper.CommerceEventWrapper commerceEventWrapper = new EventWrapper.CommerceEventWrapper(commerceEvent);
        for (int i10 = 0; i10 < list.size(); i10++) {
            CustomMapping customMapping2 = list.get(i10);
            if (customMapping2.isMatch(commerceEventWrapper) && (project = customMapping2.project(commerceEventWrapper)) != null) {
                linkedList.addAll(project);
            }
        }
        if (linkedList.isEmpty()) {
            if (customMapping == null) {
                return null;
            }
            linkedList.addAll(customMapping.project(commerceEventWrapper));
        }
        return linkedList;
    }

    public static class ProjectionResult {
        /* access modifiers changed from: private */
        public CommerceEvent mCommerceEvent;
        private final MPEvent mEvent;
        private final int mProjectionId;

        public ProjectionResult(MPEvent mPEvent, int i10) {
            this.mEvent = mPEvent;
            this.mCommerceEvent = null;
            this.mProjectionId = i10;
        }

        public CommerceEvent getCommerceEvent() {
            return this.mCommerceEvent;
        }

        public MPEvent getMPEvent() {
            return this.mEvent;
        }

        public int getProjectionId() {
            return this.mProjectionId;
        }

        public ProjectionResult(CommerceEvent commerceEvent, int i10) {
            this.mCommerceEvent = commerceEvent;
            this.mEvent = null;
            this.mProjectionId = i10;
        }
    }

    public static List<ProjectionResult> projectEvents(MPEvent mPEvent, boolean z10, List<CustomMapping> list, CustomMapping customMapping, CustomMapping customMapping2) {
        List<ProjectionResult> project;
        LinkedList linkedList = new LinkedList();
        EventWrapper.MPEventWrapper mPEventWrapper = new EventWrapper.MPEventWrapper(mPEvent, z10);
        for (int i10 = 0; i10 < list.size(); i10++) {
            CustomMapping customMapping3 = list.get(i10);
            if (customMapping3.isMatch(mPEventWrapper) && (project = customMapping3.project(mPEventWrapper)) != null) {
                linkedList.addAll(project);
            }
        }
        if (linkedList.isEmpty()) {
            if (z10) {
                if (customMapping2 == null) {
                    return null;
                }
                linkedList.addAll(customMapping2.project(mPEventWrapper));
            } else if (customMapping == null) {
                return null;
            } else {
                linkedList.addAll(customMapping.project(mPEventWrapper));
            }
        }
        return linkedList;
    }

    public List<ProjectionResult> project(EventWrapper.MPEventWrapper mPEventWrapper) {
        LinkedList linkedList = new LinkedList();
        ProjectionResult projectMPEvent = projectMPEvent(mPEventWrapper.getEvent());
        if (projectMPEvent != null) {
            linkedList.add(projectMPEvent);
        }
        if (linkedList.size() > 0) {
            return linkedList;
        }
        return null;
    }
}
