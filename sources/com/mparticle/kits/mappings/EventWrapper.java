package com.mparticle.kits.mappings;

import com.mparticle.MPEvent;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.commerce.Product;
import com.mparticle.commerce.Promotion;
import com.mparticle.kits.CommerceEventUtils;
import com.mparticle.kits.KitUtils;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

abstract class EventWrapper {
    protected Map<Integer, String> attributeHashes;

    static class CommerceEventWrapper extends EventWrapper {
        private HashMap<String, String> eventFieldAttributes;
        private Map<Integer, String> eventFieldHashes;
        private CommerceEvent mCommerceEvent;

        public CommerceEventWrapper(CommerceEvent commerceEvent) {
            this.mCommerceEvent = commerceEvent;
        }

        public Map.Entry<String, String> findAttribute(String str, int i10, Product product, Promotion promotion) {
            String str2;
            if ("EventAttribute".equalsIgnoreCase(str)) {
                if (!(getEvent().getCustomAttributeStrings() == null || getEvent().getCustomAttributeStrings().size() == 0 || (str2 = getAttributeHashes().get(Integer.valueOf(i10))) == null)) {
                    return new AbstractMap.SimpleEntry(str2, this.mCommerceEvent.getCustomAttributeStrings().get(str2));
                }
            } else if ("EventField".equalsIgnoreCase(str)) {
                if (this.eventFieldHashes == null) {
                    if (this.eventFieldAttributes == null) {
                        this.eventFieldAttributes = new HashMap<>();
                        CommerceEventUtils.extractActionAttributes(getEvent(), (Map<String, String>) this.eventFieldAttributes);
                        CommerceEventUtils.extractTransactionAttributes(getEvent(), (Map<String, String>) this.eventFieldAttributes);
                    }
                    this.eventFieldHashes = EventWrapper.getHashes(getEventTypeOrdinal() + "", this.eventFieldAttributes);
                }
                String str3 = this.eventFieldHashes.get(Integer.valueOf(i10));
                if (str3 != null) {
                    return new AbstractMap.SimpleEntry(str3, this.eventFieldAttributes.get(str3));
                }
            } else if ("ProductAttribute".equalsIgnoreCase(str)) {
                if (product == null || product.getCustomAttributes() == null || product.getCustomAttributes().size() == 0) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                CommerceEventUtils.extractProductAttributes(product, (Map<String, String>) hashMap);
                String str4 = EventWrapper.getHashes(getEventTypeOrdinal() + "", hashMap).get(Integer.valueOf(i10));
                if (str4 != null) {
                    return new AbstractMap.SimpleEntry(str4, (String) hashMap.get(str4));
                }
            } else if ("ProductField".equalsIgnoreCase(str)) {
                if (product == null) {
                    return null;
                }
                HashMap hashMap2 = new HashMap();
                CommerceEventUtils.extractProductFields(product, (Map<String, String>) hashMap2);
                String str5 = EventWrapper.getHashes(getEventTypeOrdinal() + "", hashMap2).get(Integer.valueOf(i10));
                if (str5 != null) {
                    return new AbstractMap.SimpleEntry(str5, (String) hashMap2.get(str5));
                }
            } else if (!"PromotionField".equalsIgnoreCase(str) || promotion == null) {
                return null;
            } else {
                HashMap hashMap3 = new HashMap();
                CommerceEventUtils.extractPromotionAttributes(promotion, (Map<String, String>) hashMap3);
                String str6 = EventWrapper.getHashes(getEventTypeOrdinal() + "", hashMap3).get(Integer.valueOf(i10));
                if (str6 != null) {
                    return new AbstractMap.SimpleEntry(str6, (String) hashMap3.get(str6));
                }
            }
            return null;
        }

        public Map<Integer, String> getAttributeHashes() {
            if (this.attributeHashes == null) {
                this.attributeHashes = new HashMap();
                if (this.mCommerceEvent.getCustomAttributeStrings() != null) {
                    for (Map.Entry next : this.mCommerceEvent.getCustomAttributeStrings().entrySet()) {
                        this.attributeHashes.put(Integer.valueOf(KitUtils.hashForFiltering(getEventTypeOrdinal() + ((String) next.getKey()))), (String) next.getKey());
                    }
                }
            }
            return this.attributeHashes;
        }

        public int getEventHash() {
            return KitUtils.hashForFiltering("" + getEventTypeOrdinal());
        }

        public int getEventTypeOrdinal() {
            return CommerceEventUtils.getEventType(this.mCommerceEvent);
        }

        public int getMessageType() {
            return 16;
        }

        public void setEvent(CommerceEvent commerceEvent) {
            this.mCommerceEvent = commerceEvent;
        }

        public CommerceEvent getEvent() {
            return this.mCommerceEvent;
        }

        public Map.Entry<String, String> findAttribute(String str, String str2, Product product, Promotion promotion) {
            if ("EventAttribute".equalsIgnoreCase(str)) {
                if (!(getEvent().getCustomAttributeStrings() == null || getEvent().getCustomAttributeStrings().size() == 0 || !getEvent().getCustomAttributeStrings().containsKey(str2))) {
                    return new AbstractMap.SimpleEntry(str2, getEvent().getCustomAttributeStrings().get(str2));
                }
            } else if ("EventField".equalsIgnoreCase(str)) {
                if (this.eventFieldAttributes == null) {
                    this.eventFieldAttributes = new HashMap<>();
                    CommerceEventUtils.extractActionAttributes(getEvent(), (Map<String, String>) this.eventFieldAttributes);
                    CommerceEventUtils.extractTransactionAttributes(getEvent(), (Map<String, String>) this.eventFieldAttributes);
                }
                if (this.eventFieldAttributes.containsKey(str2)) {
                    return new AbstractMap.SimpleEntry(str2, this.eventFieldAttributes.get(str2));
                }
            } else if ("ProductAttribute".equalsIgnoreCase(str)) {
                if (product == null || product.getCustomAttributes() == null) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                CommerceEventUtils.extractProductAttributes(product, (Map<String, String>) hashMap);
                if (hashMap.containsKey(str2)) {
                    return new AbstractMap.SimpleEntry(str2, (String) hashMap.get(str2));
                }
            } else if ("ProductField".equalsIgnoreCase(str)) {
                if (product == null) {
                    return null;
                }
                HashMap hashMap2 = new HashMap();
                CommerceEventUtils.extractProductFields(product, (Map<String, String>) hashMap2);
                if (hashMap2.containsKey(str2)) {
                    return new AbstractMap.SimpleEntry(str2, (String) hashMap2.get(str2));
                }
            } else if (!"PromotionField".equalsIgnoreCase(str) || promotion == null) {
                return null;
            } else {
                HashMap hashMap3 = new HashMap();
                CommerceEventUtils.extractPromotionAttributes(promotion, (Map<String, String>) hashMap3);
                if (hashMap3.containsKey(str2)) {
                    return new AbstractMap.SimpleEntry(str2, (String) hashMap3.get(str2));
                }
            }
            return null;
        }
    }

    static class MPEventWrapper extends EventWrapper {
        private final MPEvent mEvent;
        private boolean mScreenEvent;

        public MPEventWrapper(MPEvent mPEvent) {
            this(mPEvent, false);
        }

        public Map.Entry<String, String> findAttribute(String str, String str2, Product product, Promotion promotion) {
            String str3;
            if (!"EventAttribute".equalsIgnoreCase(str) || getEvent().getCustomAttributeStrings() == null || (str3 = getEvent().getCustomAttributeStrings().get(str2)) == null) {
                return null;
            }
            return new AbstractMap.SimpleEntry(str2, str3);
        }

        public Map<Integer, String> getAttributeHashes() {
            if (this.attributeHashes == null) {
                this.attributeHashes = new HashMap();
                if (this.mEvent.getCustomAttributeStrings() != null) {
                    for (Map.Entry next : this.mEvent.getCustomAttributeStrings().entrySet()) {
                        this.attributeHashes.put(Integer.valueOf(KitUtils.hashForFiltering(getEventTypeOrdinal() + this.mEvent.getEventName() + ((String) next.getKey()))), (String) next.getKey());
                    }
                }
            }
            return this.attributeHashes;
        }

        public int getEventHash() {
            if (!this.mScreenEvent) {
                return this.mEvent.getEventHash();
            }
            return KitUtils.hashForFiltering(getEventTypeOrdinal() + this.mEvent.getEventName());
        }

        public int getEventTypeOrdinal() {
            if (this.mScreenEvent) {
                return 0;
            }
            return this.mEvent.getEventType().ordinal();
        }

        public int getMessageType() {
            return this.mScreenEvent ? 3 : 4;
        }

        public MPEventWrapper(MPEvent mPEvent, boolean z10) {
            this.mEvent = mPEvent;
            this.mScreenEvent = z10;
        }

        public MPEvent getEvent() {
            return this.mEvent;
        }

        public Map.Entry<String, String> findAttribute(String str, int i10, Product product, Promotion promotion) {
            String str2;
            if (!"EventAttribute".equalsIgnoreCase(str) || (str2 = getAttributeHashes().get(Integer.valueOf(i10))) == null) {
                return null;
            }
            return new AbstractMap.SimpleEntry(str2, this.mEvent.getCustomAttributeStrings().get(str2));
        }
    }

    EventWrapper() {
    }

    protected static Map<Integer, String> getHashes(String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(Integer.valueOf(KitUtils.hashForFiltering(str + ((String) next.getKey()))), (String) next.getKey());
        }
        return hashMap;
    }

    public abstract Map.Entry<String, String> findAttribute(String str, int i10, Product product, Promotion promotion);

    public abstract Map.Entry<String, String> findAttribute(String str, String str2, Product product, Promotion promotion);

    public abstract Map<Integer, String> getAttributeHashes();

    public abstract Object getEvent();

    public abstract int getEventHash();

    public abstract int getEventTypeOrdinal();

    public abstract int getMessageType();
}
