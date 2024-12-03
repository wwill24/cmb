package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smackx.message_retraction.element.RetractElement;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

public class RetractItem implements ExtensionElement {

    /* renamed from: id  reason: collision with root package name */
    private final String f24224id;

    public RetractItem(String str) {
        if (str != null) {
            this.f24224id = str;
            return;
        }
        throw new IllegalArgumentException("itemId must not be 'null'");
    }

    public String getElementName() {
        return RetractElement.ELEMENT;
    }

    public String getId() {
        return this.f24224id;
    }

    public String getNamespace() {
        return PubSubNamespace.event.getXmlns();
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<retract id='" + this.f24224id + "'/>";
    }
}
