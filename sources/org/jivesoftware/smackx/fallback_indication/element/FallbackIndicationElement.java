package org.jivesoftware.smackx.fallback_indication.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class FallbackIndicationElement implements ExtensionElement {
    public static final String ELEMENT = "fallback";
    public static final FallbackIndicationElement INSTANCE = new FallbackIndicationElement();
    public static final String NAMESPACE = "urn:xmpp:fallback:0";

    public static FallbackIndicationElement fromMessage(Message message) {
        return (FallbackIndicationElement) message.getExtension(FallbackIndicationElement.class);
    }

    public static boolean hasFallbackIndication(Message message) {
        return message.hasExtension(ELEMENT, NAMESPACE);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).closeEmptyElement();
    }
}
