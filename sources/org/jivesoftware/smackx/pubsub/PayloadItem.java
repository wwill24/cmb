package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.pubsub.Item;

public class PayloadItem<E extends ExtensionElement> extends Item {
    private final E payload;

    public PayloadItem(E e10) {
        if (e10 != null) {
            this.payload = e10;
            return;
        }
        throw new IllegalArgumentException("payload cannot be 'null'");
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.optAttribute("id", getId());
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((Element) this.payload);
        xmlStringBuilder.closeElement((NamedElement) this);
    }

    public E getPayload() {
        return this.payload;
    }

    public String toString() {
        return getClass().getName() + " | Content [" + toXML() + "]";
    }

    public PayloadItem(String str, E e10) {
        super(str);
        if (e10 != null) {
            this.payload = e10;
            return;
        }
        throw new IllegalArgumentException("payload cannot be 'null'");
    }

    public PayloadItem(String str, String str2, E e10) {
        this(Item.ItemNamespace.pubsub, str, str2, e10);
    }

    public PayloadItem(Item.ItemNamespace itemNamespace, String str, String str2, E e10) {
        super(itemNamespace, str, str2);
        if (e10 != null) {
            this.payload = e10;
            return;
        }
        throw new IllegalArgumentException("payload cannot be 'null'");
    }
}
