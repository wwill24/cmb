package org.jivesoftware.smackx.pubsub;

import java.util.Collection;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class ItemsExtension extends NodeExtension implements EmbeddedPacketExtension {
    protected List<? extends NamedElement> items;
    protected Boolean notify;
    protected ItemsElementType type;

    public enum ItemsElementType {
        items(PubSubElementType.ITEMS, "max_items"),
        retract(PubSubElementType.RETRACT, "notify");
        
        private final String att;
        private final PubSubElementType elem;

        private ItemsElementType(PubSubElementType pubSubElementType, String str) {
            this.elem = pubSubElementType;
            this.att = str;
        }

        public String getElementAttribute() {
            return this.att;
        }

        public PubSubElementType getNodeElement() {
            return this.elem;
        }
    }

    public ItemsExtension(ItemsElementType itemsElementType, String str, List<? extends NamedElement> list) {
        super(itemsElementType.getNodeElement(), str);
        this.type = itemsElementType;
        this.items = list;
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        List<? extends NamedElement> list = this.items;
        if (list == null || list.size() == 0) {
            xmlStringBuilder.closeEmptyElement();
            return;
        }
        if (this.notify != null) {
            xmlStringBuilder.attribute(this.type.getElementAttribute(), this.notify.booleanValue());
            xmlStringBuilder.rightAngleBracket();
        } else {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append((Collection<? extends Element>) this.items);
        }
        xmlStringBuilder.closeElement((NamedElement) this);
    }

    public List<ExtensionElement> getExtensions() {
        return getItems();
    }

    public List<? extends NamedElement> getItems() {
        return this.items;
    }

    public ItemsElementType getItemsElementType() {
        return this.type;
    }

    public boolean getNotify() {
        return this.notify.booleanValue();
    }

    public String toString() {
        return getClass().getName() + "Content [" + toXML() + "]";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ItemsExtension(java.lang.String r3, java.util.List<? extends org.jivesoftware.smack.packet.ExtensionElement> r4, boolean r5) {
        /*
            r2 = this;
            org.jivesoftware.smackx.pubsub.ItemsExtension$ItemsElementType r0 = org.jivesoftware.smackx.pubsub.ItemsExtension.ItemsElementType.retract
            org.jivesoftware.smackx.pubsub.PubSubElementType r1 = r0.getNodeElement()
            r2.<init>(r1, r3)
            r2.type = r0
            r2.items = r4
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)
            r2.notify = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.pubsub.ItemsExtension.<init>(java.lang.String, java.util.List, boolean):void");
    }
}
