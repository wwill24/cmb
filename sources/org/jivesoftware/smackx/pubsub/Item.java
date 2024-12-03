package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;

public class Item extends NodeExtension {
    private final String itemId;

    public enum ItemNamespace {
        pubsub(PubSubElementType.ITEM),
        event(PubSubElementType.ITEM_EVENT);
        
        /* access modifiers changed from: private */
        public final PubSubElementType type;

        private ItemNamespace(PubSubElementType pubSubElementType) {
            this.type = pubSubElementType;
        }

        public static ItemNamespace fromXmlns(String str) {
            for (ItemNamespace itemNamespace : values()) {
                if (itemNamespace.type.getNamespace().getXmlns().equals(str)) {
                    return itemNamespace;
                }
            }
            throw new IllegalArgumentException("Invalid item namespace: " + str);
        }
    }

    public Item() {
        this(ItemNamespace.pubsub, (String) null, (String) null);
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.optAttribute("id", getId());
        xmlStringBuilder.closeEmptyElement();
    }

    public String getId() {
        return this.itemId;
    }

    public String toString() {
        return getClass().getName() + " | Content [" + toXML() + "]";
    }

    public Item(String str) {
        this(ItemNamespace.pubsub, str, (String) null);
    }

    public Item(ItemNamespace itemNamespace, String str) {
        this(itemNamespace, str, (String) null);
    }

    public Item(String str, String str2) {
        this(ItemNamespace.pubsub, str, str2);
    }

    public Item(ItemNamespace itemNamespace, String str, String str2) {
        super(itemNamespace.type, str2);
        this.itemId = str;
    }
}
